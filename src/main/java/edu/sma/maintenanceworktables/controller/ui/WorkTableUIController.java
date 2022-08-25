package edu.sma.maintenanceworktables.controller.ui;

import edu.sma.maintenanceworktables.form.RepairForm;
import edu.sma.maintenanceworktables.form.RepairTypeForm;
import edu.sma.maintenanceworktables.form.WorkTableForm;
import edu.sma.maintenanceworktables.model.RepairType;
import edu.sma.maintenanceworktables.model.WorkTable;
import edu.sma.maintenanceworktables.service.impls.RepairServiceImpl;
import edu.sma.maintenanceworktables.service.impls.RepairTypeServiceImpl;
import edu.sma.maintenanceworktables.service.impls.WorkTableServiceImpl;
import edu.sma.maintenanceworktables.service.impls.WorkTableTypeServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;

@RequestMapping("/ui/v1/worktables/")
@Controller
public class WorkTableUIController {
    @Autowired
    RepairServiceImpl repairService;
    @Autowired
    WorkTableServiceImpl workTableService;
    @Autowired
    RepairTypeServiceImpl repairTypeService;
    @Autowired
    WorkTableTypeServiceImpl workTableTypeService;

    @GetMapping("")
    public String showAll(Model model) {
        model.addAttribute("worktables", workTableService.getAll());
//        model.addAttribute("conditions", serviceConditions.getAll());
//        LoanTypeForm loanTypeForm = new LoanTypeForm();
//        model.addAttribute("form", loanTypeForm);

        return "worktables";
    }

    @GetMapping("/del/{id}")
    public String deleteById(@PathVariable("id") String id) {
        workTableService.delete(id);
        return "redirect:/ui/v1/worktables/";
    }

    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public String addRepair(Model model){
        RepairForm repairForm = new RepairForm();
        model.addAttribute("form", repairForm);
        model.addAttribute("worktables", workTableService.getAll());
        model.addAttribute("types", workTableTypeService.getAll());
        return "addWorkTable";
    }

    @PostMapping("/add")
    public String addLoanType(@ModelAttribute("form") WorkTableForm form){
        WorkTable workTable = new WorkTable();
        workTable.setName(form.getName());
        workTable.setType(workTableTypeService.get(form.getType()));
        workTable.setNumberRepairs(form.getNumberRepairs());

        workTable.setCreatedAt(LocalDateTime.now());
        workTable.setUpdatedAt(LocalDateTime.now());
        workTableService.create(workTable);
        return "redirect:/ui/v1/worktables/";
    }

    @RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
    public String editRepair(Model model, @PathVariable("id") String id){
        WorkTableForm workTableForm = new WorkTableForm();
        model.addAttribute("worktables", workTableService.getAll());
        model.addAttribute("types", repairTypeService.getAll());

        WorkTable itemToUpdate = workTableService.get(id);
        model.addAttribute("item", itemToUpdate);
        workTableForm.setId(itemToUpdate.getId());
        workTableForm.setName(itemToUpdate.getName());
        workTableForm.setType(itemToUpdate.getType().getId());
        workTableForm.setNumberRepairs(itemToUpdate.getNumberRepairs());
        workTableForm.setUpdatedAt(itemToUpdate.getUpdatedAt());
        workTableForm.setCreatedAt(itemToUpdate.getCreatedAt());
        model.addAttribute("form", workTableForm);
        return "editWorkTable";
    }

    @PostMapping("/edit/{id}")
    public String updateLoanType(@ModelAttribute("form") WorkTableForm form, @PathVariable("id") String id){
        WorkTable workTable = new WorkTable();
        workTable.setId(form.getId());
        workTable.setName(form.getName());
        workTable.setType(workTableTypeService.get(form.getType()));
        workTable.setNumberRepairs(form.getNumberRepairs());

        workTable.setCreatedAt(workTableService.get(id).getCreatedAt());
        workTable.setUpdatedAt(LocalDateTime.now());
        workTableService.update(workTable);
        return "redirect:/ui/v1/worktables/";

    }
}
