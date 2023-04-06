package com.nxlog.demo.entities;

import java.util.LinkedHashSet;
import java.util.Set;

import javax.persistence.*;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import com.nxlog.demo.models.task4_5.AgentType;



@Entity
public class Agent extends AbstractEntity{
    @Column(name = "name", length = 127, nullable = false, unique = true)
    protected String name;
    @Column(nullable = false, length = 31)
    @Enumerated(EnumType.STRING)
    private AgentType type;
    @Column(name = "global_config", length = 32671)
    @Basic(fetch = FetchType.LAZY)
    protected String globalConfig;

    @OneToMany(mappedBy = "agent", cascade = CascadeType.ALL, orphanRemoval = true)
    @Fetch(FetchMode.SUBSELECT)
    @OrderBy("id")
    protected Set<Route> routes = new LinkedHashSet<>();
    @OneToMany(mappedBy = "agent", cascade = CascadeType.ALL, orphanRemoval = true)
    @Fetch(FetchMode.SUBSELECT)
    protected Set<Module> modules = new LinkedHashSet<>();

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public AgentType getType() {
        return type;
    }
    public void setType(AgentType type) {
        this.type = type;
    }
    public String getGlobalConfig() {
        return globalConfig;
    }
    public void setGlobalConfig(String globalConfig) {
        this.globalConfig = globalConfig;
    }
    public Set<Route> getRoutes() {
        return routes;
    }
    public void setRoutes(Set<Route> routes) {
        this.routes = routes;
    }
    public Set<Module> getModules() {
        return modules;
    }
    public void setModules(Set<Module> modules) {
        this.modules = modules;
    }

    //getters and setters skipped for briefity.
}
