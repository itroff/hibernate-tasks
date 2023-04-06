package com.nxlog.demo.entities;

import javax.persistence.*;

import org.hibernate.annotations.NaturalId;

import com.nxlog.demo.models.task4_5.ModuleType;


@Entity
public class Module extends AbstractEntity {
    @NaturalId
    @ManyToOne(cascade = CascadeType.DETACH)
    @JoinColumn(name = "agent_id")
    private Agent agent;
    @NaturalId
    @Column(name = "name", length = 128)
    private String name;
    @Column(nullable = false, length = 31)
    @Enumerated(EnumType.STRING)
    private ModuleType type;

    public Agent getAgent() {
        return agent;
    }
    public void setAgent(Agent agent) {
        this.agent = agent;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public ModuleType getType() {
        return type;
    }
    public void setType(ModuleType type) {
        this.type = type;
    }

    
}
