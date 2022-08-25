package edu.sma.maintenanceworktables.controller.api;

import edu.sma.maintenanceworktables.model.WorkTableType;
import edu.sma.maintenanceworktables.service.impls.WorkTableServiceImpl;
import edu.sma.maintenanceworktables.service.impls.WorkTableTypeServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/api/v1/worktables/types/")
@RestController
public class WorkTableTypeRestController {
    @Autowired
    WorkTableTypeServiceImpl service;

    @GetMapping("")
    public List<WorkTableType> showAll() {
        return service.getAll();
    }

    @GetMapping("/{id}")
    public WorkTableType showOne(@PathVariable String id) {
        return service.get(id);
    }

    @DeleteMapping("/{id}")
    public void del(@PathVariable String id) {
        service.delete(id);
    }

    @PostMapping()
    public WorkTableType insertOne(@RequestBody WorkTableType conditionsReceipt) {
        return service.create(conditionsReceipt);
    }

    @PutMapping()
    public WorkTableType updateOne(@RequestBody WorkTableType conditionsReceipt) {
        return service.update(conditionsReceipt);
    }
}
