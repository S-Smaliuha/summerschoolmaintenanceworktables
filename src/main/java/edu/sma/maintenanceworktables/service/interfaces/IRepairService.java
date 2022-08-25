package edu.sma.maintenanceworktables.service.interfaces;

import edu.sma.maintenanceworktables.model.Repair;

import java.util.List;

public interface IRepairService {
    Repair create(Repair payment);

    Repair update(Repair payment);

    Repair get(String id);

    void delete(String id);

    List<Repair> getAll();
}
