package edu.sma.maintenanceworktables.repository.mongo;

import edu.sma.maintenanceworktables.model.Repair;
import edu.sma.maintenanceworktables.model.RepairType;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface RepairTypeMongoRepository extends MongoRepository<RepairType,String> {
}
