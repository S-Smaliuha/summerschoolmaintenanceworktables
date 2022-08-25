package edu.sma.maintenanceworktables.repository.mongo;

import edu.sma.maintenanceworktables.model.Repair;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface RepairMongoRepository extends MongoRepository<Repair,String> {
}
