package edu.sma.maintenanceworktables.service.impls;

import edu.sma.maintenanceworktables.model.Countries;
import edu.sma.maintenanceworktables.model.WorkTableType;
import edu.sma.maintenanceworktables.model.RepairType;
import edu.sma.maintenanceworktables.model.WorkTable;
import edu.sma.maintenanceworktables.repository.mongo.RepairMongoRepository;
import edu.sma.maintenanceworktables.repository.mongo.WorkTableTypeMongoRepository;
import edu.sma.maintenanceworktables.service.interfaces.IRepairService;
import edu.sma.maintenanceworktables.service.interfaces.IWorkTableTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class WorkTableTypeServiceImpl implements IWorkTableTypeService {
    private LocalDateTime now = LocalDateTime.now();
    private WorkTableType repair;
//    Countries countries = new Countries();
    private List<WorkTableType> customers = new ArrayList<>(
            Arrays.asList(
new WorkTableType("1","1", Countries.UKRAINE,2,now,now)
            ));
    @Autowired
    WorkTableTypeMongoRepository repository;

    @PostConstruct
    void init() {
        repository.saveAll(customers);
    }

    @Override
    public WorkTableType create(WorkTableType repair) {
        return repository.save(repair);
    }

    @Override
    public WorkTableType update(WorkTableType repair) {
        return repository.save(repair);
    }

    @Override
    public WorkTableType get(String id) {
        return repository.findById(id).get();
    }

    @Override
    public void delete(String id) {
        repository.deleteById(id);
    }

    @Override
    public List<WorkTableType> getAll() {
        return repository.findAll();
    }
}
