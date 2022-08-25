package edu.sma.maintenanceworktables.controller.api;

import edu.sma.maintenanceworktables.model.Repair;
import edu.sma.maintenanceworktables.service.impls.RepairServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/api/v1/repairs/")
@RestController
public class RepairRestController {
    @Autowired
    RepairServiceImpl service;

    @GetMapping("")
    public List<Repair> showAll() {
        return service.getAll();
    }

    @GetMapping("/{id}")
    public Repair showOne(@PathVariable String id) {
        return service.get(id);
    }

    @DeleteMapping("/{id}")
    public void del(@PathVariable String id) {
        service.delete(id);
    }

    @PostMapping()
    public Repair insertOne(@RequestBody Repair conditionsReceipt) {
        return service.create(conditionsReceipt);
    }

    @PutMapping()
    public Repair updateOne(@RequestBody Repair conditionsReceipt) {
        return service.update(conditionsReceipt);
    }
}
