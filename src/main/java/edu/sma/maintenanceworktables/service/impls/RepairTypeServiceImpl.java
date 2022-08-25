package edu.sma.maintenanceworktables.service.impls;

import edu.sma.maintenanceworktables.model.RepairType;
import edu.sma.maintenanceworktables.model.RepairType;
import edu.sma.maintenanceworktables.model.WorkTable;
import edu.sma.maintenanceworktables.repository.mongo.RepairMongoRepository;
import edu.sma.maintenanceworktables.repository.mongo.RepairTypeMongoRepository;
import edu.sma.maintenanceworktables.service.interfaces.IRepairService;
import edu.sma.maintenanceworktables.service.interfaces.IRepairTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class RepairTypeServiceImpl implements IRepairTypeService {
    private LocalDateTime now = LocalDateTime.now();
    private RepairType repairType;
    private List<RepairType> customers = new ArrayList<>(
            Arrays.asList(
                    new RepairType("1","1",3, 300,"as",now,now)
            ));
    @Autowired
    RepairTypeMongoRepository repository;

    @PostConstruct
    void init() {
        repository.saveAll(customers);
    }

    @Override
    public RepairType create(RepairType repairType) {
        return repository.save(repairType);
    }

    @Override
    public RepairType update(RepairType repairType) {
        return repository.save(repairType);
    }

    @Override
    public RepairType get(String id) {
        return repository.findById(id).get();
    }

    @Override
    public void delete(String id) {
        repository.deleteById(id);
    }

    @Override
    public List<RepairType> getAll() {
        return repository.findAll();
    }
}
