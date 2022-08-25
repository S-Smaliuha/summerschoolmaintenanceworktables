package edu.sma.maintenanceworktables.repository.mongo;

import edu.sma.maintenanceworktables.model.Repair;
import edu.sma.maintenanceworktables.model.WorkTableType;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface WorkTableTypeMongoRepository extends MongoRepository<WorkTableType,String> {
}
