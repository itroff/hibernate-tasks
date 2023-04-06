package com.nxlog.demo.repositories;

import java.util.HashSet;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.query.NativeQuery;
import org.springframework.stereotype.Repository;

import com.nxlog.demo.entities.Module;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Repository
public class HibernateRepository {

    private Session session;
    // private EntityManager entityManager;

    @PersistenceContext
    private EntityManager entityManager;

    /**
     * Returns all modules for agent which are incllded in a complete route.
     * A complete route contains at least 1 INPUT module and at least 1 OUTPUT
     * module.
     */
    public Set<Module> getModulesIncludedInCompleteRoutes(Long agentId) {

        if (entityManager == null
                || (session = entityManager.unwrap(Session.class)) == null) {

            throw new NullPointerException();
        }

        String query = "SELECT m.ID, m.NAME, m.TYPE, m.AGENT_ID FROM MODULE m " +
                "JOIN MODULE_ROUTE mr ON m.ID = mr.MODULE_ID " +
                "JOIN ROUTE r1 ON r1.ID = mr.ROUTE_ID " +
                "WHERE r1.AGENT_ID = :agentId " +
                "AND r1.ID IN ( " +
                "SELECT r2.ID " +
                "FROM ROUTE r2 " +
                "JOIN MODULE_ROUTE mr2 ON r2.ID = mr2.ROUTE_ID " +
                "JOIN MODULE m2 ON m2.ID = mr2.MODULE_ID " +
                "WHERE m2.AGENT_ID = 1 " +
                "GROUP BY r2.ID " +
                "HAVING COUNT(DISTINCT CASE WHEN m2.TYPE = 'INPUT' THEN mr2.MODULE_ID END) >= 1 " +
                "AND COUNT(DISTINCT CASE WHEN m2.TYPE = 'OUTPUT' THEN mr2.MODULE_ID END) >= 1)";
        NativeQuery<Module> queryNative = session.createNativeQuery(query, Module.class)
                .setParameter("agentId", agentId);
        Set<Module> result = new HashSet<>();
        result.addAll(queryNative.getResultList());
        return result;
    }
}
