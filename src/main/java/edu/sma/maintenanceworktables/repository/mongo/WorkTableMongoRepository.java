package edu.sma.maintenanceworktables.repository.mongo;

import edu.sma.maintenanceworktables.model.Repair;
import edu.sma.maintenanceworktables.model.WorkTable;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface WorkTableMongoRepository extends MongoRepository<WorkTable,String> {
}
