package edu.sma.maintenanceworktables.service.impls;

import edu.sma.maintenanceworktables.model.WorkTable;
import edu.sma.maintenanceworktables.model.RepairType;
import edu.sma.maintenanceworktables.model.WorkTable;
import edu.sma.maintenanceworktables.model.WorkTableType;
import edu.sma.maintenanceworktables.repository.mongo.RepairMongoRepository;
import edu.sma.maintenanceworktables.repository.mongo.WorkTableMongoRepository;
import edu.sma.maintenanceworktables.service.interfaces.IRepairService;
import edu.sma.maintenanceworktables.service.interfaces.IWorkTableService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class WorkTableServiceImpl implements IWorkTableService {
    private LocalDateTime now = LocalDateTime.now();
    private WorkTable repair;
    private List<WorkTable> customers = new ArrayList<>(
            Arrays.asList(
                    new WorkTable("1","1",new WorkTableType(),1,now,now)
            ));
    @Autowired
    WorkTableMongoRepository repository;

    @PostConstruct
    void init() {
        repository.saveAll(customers);
    }

    @Override
    public WorkTable create(WorkTable repair) {
        return repository.save(repair);
    }

    @Override
    public WorkTable update(WorkTable repair) {
        return repository.save(repair);
    }

    @Override
    public WorkTable get(String id) {
        return repository.findById(id).get();
    }

    @Override
    public void delete(String id) {
        repository.deleteById(id);
    }

    @Override
    public List<WorkTable> getAll() {
        return repository.findAll();
    }
}
