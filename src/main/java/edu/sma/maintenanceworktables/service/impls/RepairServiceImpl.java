package edu.sma.maintenanceworktables.service.impls;

import edu.sma.maintenanceworktables.model.Repair;
import edu.sma.maintenanceworktables.model.RepairType;
import edu.sma.maintenanceworktables.model.WorkTable;
import edu.sma.maintenanceworktables.model.WorkTableType;
import edu.sma.maintenanceworktables.repository.mongo.RepairMongoRepository;
import edu.sma.maintenanceworktables.service.interfaces.IRepairService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
@Service

public class RepairServiceImpl implements IRepairService {
    private LocalDateTime now = LocalDateTime.now();
    private Repair repair;
    private List<Repair> customers = new ArrayList<>(
            Arrays.asList(
                    new Repair("1", "asd1", new WorkTable("1","qwd",new WorkTableType(), 1,now,now),new RepairType("1", "55",2,1,"2121",now,now),now, "---", now, now)

            ));
    @Autowired
    RepairMongoRepository repository;

    @PostConstruct
    void init() {
        repository.saveAll(customers);
    }

    @Override
    public Repair create(Repair repair) {
        return repository.save(repair);
    }

    @Override
    public Repair update(Repair repair) {
        return repository.save(repair);
    }

    @Override
    public Repair get(String id) {
        return repository.findById(id).get();
    }

    @Override
    public void delete(String id) {
        repository.deleteById(id);
    }

    @Override
    public List<Repair> getAll() {
        return repository.findAll();
    }
}
