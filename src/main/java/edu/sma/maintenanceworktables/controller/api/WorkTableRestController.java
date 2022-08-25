package edu.sma.maintenanceworktables.controller.api;

import edu.sma.maintenanceworktables.model.WorkTable;
import edu.sma.maintenanceworktables.service.impls.RepairTypeServiceImpl;
import edu.sma.maintenanceworktables.service.impls.WorkTableServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/api/v1/worktables/")
@RestController
public class WorkTableRestController {
    @Autowired
    WorkTableServiceImpl service;

    @GetMapping("")
    public List<WorkTable> showAll() {
        return service.getAll();
    }

    @GetMapping("/{id}")
    public WorkTable showOne(@PathVariable String id) {
        return service.get(id);
    }

    @DeleteMapping("/{id}")
    public void del(@PathVariable String id) {
        service.delete(id);
    }

    @PostMapping()
    public WorkTable insertOne(@RequestBody WorkTable conditionsReceipt) {
        return service.create(conditionsReceipt);
    }

    @PutMapping()
    public WorkTable updateOne(@RequestBody WorkTable conditionsReceipt) {
        return service.update(conditionsReceipt);
    }
}
