package edu.sma.maintenanceworktables.service.interfaces;

import edu.sma.maintenanceworktables.model.RepairType;

import java.util.List;

public interface IRepairTypeService {
    RepairType create(RepairType repairType);

    RepairType update(RepairType repairType);

    RepairType get(String id);

    void delete(String id);

    List<RepairType> getAll();
}
