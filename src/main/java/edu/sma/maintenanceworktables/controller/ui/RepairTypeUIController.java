package edu.sma.maintenanceworktables.controller.ui;

import edu.sma.maintenanceworktables.form.RepairForm;
import edu.sma.maintenanceworktables.form.RepairTypeForm;
import edu.sma.maintenanceworktables.model.Repair;
import edu.sma.maintenanceworktables.model.RepairType;
import edu.sma.maintenanceworktables.service.impls.RepairServiceImpl;
import edu.sma.maintenanceworktables.service.impls.RepairTypeServiceImpl;
import edu.sma.maintenanceworktables.service.impls.WorkTableServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;

@RequestMapping("/ui/v1/repairs/types/")
@Controller
public class RepairTypeUIController {
    @Autowired
    RepairServiceImpl repairService;
    @Autowired
    WorkTableServiceImpl workTableService;
    @Autowired
    RepairTypeServiceImpl repairTypeService;

    @GetMapping("")
    public String showAll(Model model) {
        model.addAttribute("repairtypes", repairTypeService.getAll());
//        model.addAttribute("conditions", serviceConditions.getAll());
//        LoanTypeForm loanTypeForm = new LoanTypeForm();
//        model.addAttribute("form", loanTypeForm);

        return "repairTypes";
    }

    @GetMapping("/del/{id}")
    public String deleteById(@PathVariable("id") String id) {
        repairTypeService.delete(id);
        return "redirect:/ui/v1/repairs/types/";
    }

    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public String addRepair(Model model){
        RepairForm repairForm = new RepairForm();
        model.addAttribute("form", repairForm);
        model.addAttribute("worktables", workTableService.getAll());
        model.addAttribute("types", repairTypeService.getAll());
        return "addRepairType";
    }

    @PostMapping("/add")
    public String addLoanType(@ModelAttribute("form") RepairTypeForm form){
        RepairType repairType = new RepairType();
        repairType.setName(form.getName());
        repairType.setDuration(form.getDuration());
        repairType.setCost(form.getCost());
        repairType.setComment(form.getComment());

        repairType.setCreatedAt(LocalDateTime.now());
        repairType.setUpdatedAt(LocalDateTime.now());
        repairTypeService.create(repairType);
        return "redirect:/ui/v1/repairs/types/";
    }

    @RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
    public String editRepair(Model model, @PathVariable("id") String id){
        RepairTypeForm repairTypeForm = new RepairTypeForm();
        model.addAttribute("worktables", workTableService.getAll());
        model.addAttribute("types", repairTypeService.getAll());

        RepairType itemToUpdate = repairTypeService.get(id);
        model.addAttribute("item", itemToUpdate);
        repairTypeForm.setId(itemToUpdate.getId());
        repairTypeForm.setName(itemToUpdate.getName());
        repairTypeForm.setDuration(itemToUpdate.getDuration());
        repairTypeForm.setCost(itemToUpdate.getCost());
        repairTypeForm.setComment(itemToUpdate.getComment());

        repairTypeForm.setUpdatedAt(itemToUpdate.getUpdatedAt());
        repairTypeForm.setCreatedAt(itemToUpdate.getCreatedAt());
        model.addAttribute("form", repairTypeForm);
        return "editRepairType";
    }

    @PostMapping("/edit/{id}")
    public String updateLoanType(@ModelAttribute("form") RepairTypeForm form, @PathVariable("id") String id){
        RepairType repairType = new RepairType();
        repairType.setId(form.getId());
        repairType.setName(form.getName());
        repairType.setDuration(form.getDuration());
        repairType.setCost(form.getCost());
        repairType.setComment(form.getComment());

        repairType.setCreatedAt(repairTypeService.get(id).getCreatedAt());
        repairType.setUpdatedAt(LocalDateTime.now());
        repairTypeService.update(repairType);
        return "redirect:/ui/v1/repairs/types/";

    }
}
