package edu.sma.maintenanceworktables.form;

import edu.sma.maintenanceworktables.model.RepairType;
import edu.sma.maintenanceworktables.model.WorkTable;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;
import java.util.Objects;



public class RepairForm {

    private String id;
    private String name;
    private String workTable;
    private String repairType;
    private LocalDateTime dateStart;
    private String comment;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    public RepairForm() {
    }

    public RepairForm(String name, String workTable, String repairType, LocalDateTime dateStart, String comment) {
        this.name = name;
        this.workTable = workTable;
        this.repairType = repairType;
        this.dateStart = dateStart;
        this.comment = comment;
    }

    public RepairForm(String id, String name, String workTable, String repairType, LocalDateTime dateStart, String comment, LocalDateTime createdAt, LocalDateTime updatedAt) {
        this.id = id;
        this.name = name;
        this.workTable = workTable;
        this.repairType = repairType;
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

    public String getWorkTable() {
        return workTable;
    }

    public void setWorkTable(String workTable) {
        this.workTable = workTable;
    }

    public String getRepairType() {
        return repairType;
    }

    public void setRepairType(String repairType) {
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
    public String toString() {
        return "RepairForm{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", workTable='" + workTable + '\'' +
                ", repairType='" + repairType + '\'' +
                ", dateStart=" + dateStart +
                ", comment='" + comment + '\'' +
                ", createdAt=" + createdAt +
                ", updatedAt=" + updatedAt +
                '}';
    }
}
