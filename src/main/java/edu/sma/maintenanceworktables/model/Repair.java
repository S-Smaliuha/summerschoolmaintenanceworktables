package edu.sma.maintenanceworktables.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;
import java.util.Objects;

@Document
public class Repair {
    @Id
    private String id;
    private String name;
    private WorkTable workTable;
    private RepairType repairType;
    private LocalDateTime dateStart;
    private String comment;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    public Repair() {
    }

    public Repair(String name, WorkTable WorkTable, RepairType RepairType, LocalDateTime dateStart, String comment) {
        this.name = name;
        this.workTable = WorkTable;
        this.repairType = RepairType;
        this.dateStart = dateStart;
        this.comment = comment;
    }

    public Repair(String id, String name, WorkTable WorkTable, RepairType RepairType, LocalDateTime dateStart, String comment, LocalDateTime createdAt, LocalDateTime updatedAt) {
        this.id = id;
        this.name = name;
        this.workTable = WorkTable;
        this.repairType = RepairType;
        this.dateStart = dateStart;
        this.comment = comment;
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

    public WorkTable getWorkTable() {
        return workTable;
    }

    public void setWorkTable(WorkTable workTable) {
        this.workTable = workTable;
    }

    public RepairType getRepairType() {
        return repairType;
    }

    public void setRepairType(RepairType repairType) {
        this.repairType = repairType;
    }

    public LocalDateTime getDateStart() {
        return dateStart;
    }

    public void setDateStart(LocalDateTime dateStart) {
        this.dateStart = dateStart;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
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
        Repair repair = (Repair) o;
        return id.equals(repair.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "Repair{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", idWorkTable=" + workTable +
                ", idRepairType=" + repairType +
                ", dateStart=" + dateStart +
                ", comment='" + comment + '\'' +
                ", createdAt=" + createdAt +
                ", updatedAt=" + updatedAt +
                '}';
    }
}
