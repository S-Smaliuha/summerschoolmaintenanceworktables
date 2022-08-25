package edu.sma.maintenanceworktables.controller.ui;

import edu.sma.maintenanceworktables.form.WorkTableTypeForm;
import edu.sma.maintenanceworktables.model.Countries;
import edu.sma.maintenanceworktables.model.WorkTable;
import edu.sma.maintenanceworktables.model.WorkTableType;
import edu.sma.maintenanceworktables.service.impls.RepairServiceImpl;
import edu.sma.maintenanceworktables.service.impls.RepairTypeServiceImpl;
import edu.sma.maintenanceworktables.service.impls.WorkTableServiceImpl;
import edu.sma.maintenanceworktables.service.impls.WorkTableTypeServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RequestMapping("/ui/v1/worktables/types/")
@Controller
public class WorkTableTypeUIController {
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
        model.addAttribute("types", workTableTypeService.getAll());
        List<Countries> countries = new ArrayList<>(
                Arrays.asList(Countries.values()));
        model.addAttribute("countries", countries);
//        LoanTypeForm loanTypeForm = new LoanTypeForm();
//        model.addAttribute("form", loanTypeForm);

        return "worktabletype";
    }

    @GetMapping("/del/{id}")
    public String deleteById(@PathVariable("id") String id) {
        workTableTypeService.delete(id);
        return "redirect:/ui/v1/worktables/types/";
    }

    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public String addRepair(Model model){
        WorkTableTypeForm workTableTypeForm = new WorkTableTypeForm();
        model.addAttribute("form", workTableTypeForm);
        return "addWorkTableType";
    }

    @PostMapping("/add")
    public String addLoanType(@ModelAttribute("form") WorkTableTypeForm form){
        WorkTableType workTableType = new WorkTableType();
        workTableType.setName(form.getName());
        workTableType.setCountry(form.getCountry());
        workTableType.setIssuanceYear(form.getIssuanceYear());

        workTableType.setCreatedAt(LocalDateTime.now());
        workTableType.setUpdatedAt(LocalDateTime.now());
        workTableTypeService.create(workTableType);
        return "redirect:/ui/v1/worktables/types/";
    }

    @RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
    public String editRepair(Model model, @PathVariable("id") String id){
        WorkTableTypeForm workTableTypeForm = new WorkTableTypeForm();
        model.addAttribute("worktables", workTableService.getAll());
        model.addAttribute("types", repairTypeService.getAll());

        WorkTableType itemToUpdate = workTableTypeService.get(id);
        model.addAttribute("item", itemToUpdate);
        workTableTypeForm.setId(itemToUpdate.getId());
        workTableTypeForm.setName(itemToUpdate.getName());
        workTableTypeForm.setCountry(itemToUpdate.getCountry());
        workTableTypeForm.setIssuanceYear(itemToUpdate.getIssuanceYear());
        workTableTypeForm.setUpdatedAt(itemToUpdate.getUpdatedAt());
        workTableTypeForm.setCreatedAt(itemToUpdate.getCreatedAt());
        model.addAttribute("form", workTableTypeForm);
        return "editWorkTableType";
    }

    @PostMapping("/edit/{id}")
    public String updateLoanType(@ModelAttribute("form") WorkTableTypeForm form, @PathVariable("id") String id){
        WorkTableType workTableType = new WorkTableType();
        workTableType.setId(form.getId());
        workTableType.setName(form.getName());
        workTableType.setCountry(form.getCountry());
        workTableType.setIssuanceYear(form.getIssuanceYear());

        workTableType.setCreatedAt(workTableTypeService.get(id).getCreatedAt());
        workTableType.setUpdatedAt(LocalDateTime.now());
        workTableTypeService.update(workTableType);
        return "redirect:/ui/v1/worktables/types/";

    }
}
