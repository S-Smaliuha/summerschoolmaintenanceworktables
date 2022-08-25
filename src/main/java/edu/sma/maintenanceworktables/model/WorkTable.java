package edu.sma.maintenanceworktables.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;
import java.util.Objects;
@Document
public class WorkTable {
    @Id
    private  String id;
    private String name;
    private WorkTableType type;
    private int numberRepairs;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    public WorkTable() {
    }

    public WorkTable(String name, WorkTableType type, int numberRepairs) {
        this.name = name;
        this.type = type;
        this.numberRepairs = numberRepairs;
    }

    public WorkTable(String id, String name, WorkTableType type, int numberRepairs, LocalDateTime createdAt, LocalDateTime updatedAt) {
        this.id = id;
        this.name = name;
        this.type = type;
        this.numberRepairs = numberRepairs;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public WorkTableType getType() {
        return type;
    }

    public void setType(WorkTableType type) {
        this.type = type;
    }

    public int getNumberRepairs() {
        return numberRepairs;
    }

    public void setNumberRepairs(int numberRepairs) {
        this.numberRepairs = numberRepairs;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        WorkTable workTable = (WorkTable) o;
        return id.equals(workTable.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "WorkTable{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", type=" + type +
                ", numberRepairs=" + numberRepairs +
                ", createdAt=" + createdAt +
                ", updatedAt=" + updatedAt +
                '}';
    }
}
