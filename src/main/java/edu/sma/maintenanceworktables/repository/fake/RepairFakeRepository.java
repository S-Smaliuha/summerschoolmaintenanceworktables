package edu.sma.maintenanceworktables.repository.fake;

import edu.sma.maintenanceworktables.model.Repair;
import edu.sma.maintenanceworktables.model.RepairType;
import edu.sma.maintenanceworktables.model.WorkTable;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;

@Repository
public class RepairFakeRepository {
    private LocalDateTime now = LocalDateTime.now();
    private List<Repair> loans = new ArrayList<>(
            Arrays.asList(
                    new Repair("1","1",new WorkTable(),new RepairType(),now, "asdasd",now, now)
            ));

    public List<Repair> findAll() {
        return this.loans;
    }

    public Repair findById(String id) {
        return this.loans.stream().filter(Repair -> Repair.getId().equals(id)).findFirst().orElse(null);
    }

    public Repair update(Repair Repair) {
        this.deleteById(Repair.getId());
        Repair.setUpdatedAt(LocalDateTime.now());
        this.loans.add(Repair);
        return Repair;
    }

    public void deleteById(String id) {
        Repair Repair = this.findById(id);
        this.loans.remove(Repair);
    }

    public Repair save(Repair Repair) {
        Repair.setId(UUID.randomUUID().toString());
        Repair.setCreatedAt(LocalDateTime.now());
        this.loans.add(Repair);
        return null;
    }
}
