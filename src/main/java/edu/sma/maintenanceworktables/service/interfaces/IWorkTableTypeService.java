package edu.sma.maintenanceworktables.service.interfaces;

import edu.sma.maintenanceworktables.model.WorkTableType;

import java.util.List;

public interface IWorkTableTypeService {
    WorkTableType create(WorkTableType payment);

    WorkTableType update(WorkTableType payment);

    WorkTableType get(String id);

    void delete(String id);

    List<WorkTableType> getAll();
}
