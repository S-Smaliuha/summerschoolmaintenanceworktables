package edu.sma.maintenanceworktables.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;
import java.util.Objects;
@Document
public class WorkTableType {
    @Id
    private  String id;
    private String name;
    private Countries country;
    private int issuanceYear;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    public WorkTableType() {
    }

    public WorkTableType(String name, Countries country, int issuanceYear) {
        this.name = name;
        this.country = country;
        this.issuanceYear = issuanceYear;
    }

    public WorkTableType(String id, String name, Countries country, int issuanceYear, LocalDateTime createdAt, LocalDateTime updatedAt) {
        this.id = id;
        this.name = name;
        this.country = country;
        this.issuanceYear = issuanceYear;
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

    public Countries getCountry() {
        return country;
    }

    public void setCountry(Countries country) {
        this.country = country;
    }

    public int getIssuanceYear() {
        return issuanceYear;
    }

    public void setIssuanceYear(int issuanceYear) {
        this.issuanceYear = issuanceYear;
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
        WorkTableType that = (WorkTableType) o;
        return id.equals(that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "WorkTableType{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", country=" + country +
                ", issuanceYear=" + issuanceYear +
                ", createdAt=" + createdAt +
                ", updatedAt=" + updatedAt +
                '}';
    }
}
