package edu.sma.maintenanceworktables.controller.ui;

import edu.sma.maintenanceworktables.form.RepairForm;
import edu.sma.maintenanceworktables.model.Repair;
import edu.sma.maintenanceworktables.model.WorkTable;
import edu.sma.maintenanceworktables.service.impls.RepairServiceImpl;
import edu.sma.maintenanceworktables.service.impls.RepairTypeServiceImpl;
import edu.sma.maintenanceworktables.service.impls.WorkTableServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;

@RequestMapping("/ui/v1/repairs/")
@Controller
public class RepairUIController {
    @Autowired
    RepairServiceImpl repairService;
    @Autowired
    WorkTableServiceImpl workTableService;
    @Autowired
    RepairTypeServiceImpl repairTypeService;

    @GetMapping("")
    public String showAll(Model model) {
        model.addAttribute("repairs", repairService.getAll());
//        model.addAttribute("conditions", serviceConditions.getAll());
//        LoanTypeForm loanTypeForm = new LoanTypeForm();
//        model.addAttribute("form", loanTypeForm);

        return "repairs";
    }

    @GetMapping("/del/{id}")
    public String deleteById(@PathVariable("id") String id) {
        repairService.delete(id);
        return "redirect:/ui/v1/repairs/";
    }

    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public String addRepair(Model model){
        RepairForm repairForm = new RepairForm();
        model.addAttribute("form", repairForm);
        model.addAttribute("worktables", workTableService.getAll());
        model.addAttribute("types", repairTypeService.getAll());
        return "addRepair";
    }

    @PostMapping("/add")
    public String addLoanType(@ModelAttribute("form") RepairForm form){
        Repair repair = new Repair();
        repair.setName(form.getName());
        repair.setWorkTable(workTableService.get(form.getWorkTable()));
        repair.setRepairType(repairTypeService.get(form.getRepairType()));
        repair.setDateStart(LocalDateTime.now());
        repair.setComment(form.getName());

        repair.setCreatedAt(LocalDateTime.now());
        repair.setUpdatedAt(LocalDateTime.now());
        repairService.create(repair);
        return "redirect:/ui/v1/repairs/";
    }

    @RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
    public String editRepair(Model model, @PathVariable("id") String id){
        RepairForm repairForm = new RepairForm();
        model.addAttribute("worktables", workTableService.getAll());
        model.addAttribute("types", repairTypeService.getAll());

        Repair itemToUpdate = repairService.get(id);
        model.addAttribute("item", itemToUpdate);
        repairForm.setId(itemToUpdate.getId());
        repairForm.setName(itemToUpdate.getName());

        repairForm.setWorkTable(itemToUpdate.getWorkTable().getId());
        repairForm.setRepairType(itemToUpdate.getRepairType().getId());
        repairForm.setDateStart(LocalDateTime.now());

        repairForm.setComment(itemToUpdate.getComment());

        repairForm.setUpdatedAt(itemToUpdate.getUpdatedAt());
        repairForm.setCreatedAt(itemToUpdate.getCreatedAt());
        model.addAttribute("form", repairForm);
        return "editRepair";
    }

    @PostMapping("/edit/{id}")
    public String updateLoanType(@ModelAttribute("form") RepairForm form , @PathVariable("id") String id){
        Repair repair = new Repair();
        repair.setId(form.getId());
        repair.setName(form.getName());

        repair.setWorkTable(workTableService.get(form.getWorkTable()));
        repair.setRepairType(repairTypeService.get(form.getRepairType()));
        repair.setDateStart(LocalDateTime.now());
        repair.setComment(form.getName());

        repair.setCreatedAt(repairService.get(id).getCreatedAt());
        repair.setUpdatedAt(LocalDateTime.now());
        repairService.update(repair);
        return "redirect:/ui/v1/repairs/";

    }
}
