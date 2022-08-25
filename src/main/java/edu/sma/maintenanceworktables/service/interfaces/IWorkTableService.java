package edu.sma.maintenanceworktables.service.interfaces;

import edu.sma.maintenanceworktables.model.WorkTable;

import java.util.List;

public interface IWorkTableService {
    WorkTable create(WorkTable payment);

    WorkTable update(WorkTable payment);

    WorkTable get(String id);

    void delete(String id);

    List<WorkTable> getAll();
}
