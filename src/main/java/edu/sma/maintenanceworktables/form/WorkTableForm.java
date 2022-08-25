package edu.sma.maintenanceworktables.form;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;
import java.util.Objects;


public class WorkTableForm {
    private  String id;
    private String name;
    private String type;
    private int numberRepairs;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    public WorkTableForm() {
    }

    public WorkTableForm(String name, String type, int numberRepairs) {
        this.name = name;
        this.type = type;
        this.numberRepairs = numberRepairs;
    }

    public WorkTableForm(String id, String name, String type, int numberRepairs, LocalDateTime createdAt, LocalDateTime updatedAt) {
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

    public String getType() {
        return type;
    }

    public void setType(String type) {
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
