package edu.sma.maintenanceworktables.controller.api;

import edu.sma.maintenanceworktables.model.RepairType;
import edu.sma.maintenanceworktables.service.impls.RepairServiceImpl;
import edu.sma.maintenanceworktables.service.impls.RepairTypeServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/api/v1/repairs/types/")
@RestController
public class RepairTypeRestController {
    @Autowired
    RepairTypeServiceImpl service;

    @GetMapping("")
    public List<RepairType> showAll() {
        return service.getAll();
    }

    @GetMapping("/{id}")
    public RepairType showOne(@PathVariable String id) {
        return service.get(id);
    }

    @DeleteMapping("/{id}")
    public void del(@PathVariable String id) {
        service.delete(id);
    }

    @PostMapping()
    public RepairType insertOne(@RequestBody RepairType conditionsReceipt) {
        return service.create(conditionsReceipt);
    }

    @PutMapping()
    public RepairType updateOne(@RequestBody RepairType conditionsReceipt) {
        return service.update(conditionsReceipt);
    }
}
