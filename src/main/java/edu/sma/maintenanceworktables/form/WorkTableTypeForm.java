package edu.sma.maintenanceworktables.form;

import edu.sma.maintenanceworktables.model.Countries;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;
import java.util.Objects;


public class WorkTableTypeForm {
    private  String id;
    private String name;
    private Countries country;
    private int issuanceYear;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    public WorkTableTypeForm() {
    }

    public WorkTableTypeForm(String name, Countries country, int issuanceYear) {
        this.name = name;
        this.country = country;
        this.issuanceYear = issuanceYear;
    }

    public WorkTableTypeForm(String id, String name, Countries country, int issuanceYear, LocalDateTime createdAt, LocalDateTime updatedAt) {
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
