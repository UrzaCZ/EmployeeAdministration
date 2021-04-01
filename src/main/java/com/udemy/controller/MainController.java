package com.udemy.controller;

import com.udemy.dbEntity.Employee;
import com.udemy.service.Services;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/employee")
public class MainController {
    @Autowired
    private Services<Employee> employeeServices;

    @GetMapping ("/list")
    public String listEmployee(Model model, @RequestParam(required = false) String sort) {
        List<Employee> theEmployees;
        if (sort !=null) {
            theEmployees = employeeServices.getServicesList (sort);
        } else {
            theEmployees = employeeServices.getServicesList ("sortByLastName");
        }
        model.addAttribute ("employees", theEmployees);
        return "listEmployee";
    }
    @GetMapping("/showFormADD")
    public String showFormADD(Model model) {
        model.addAttribute ("employee", new Employee ());
        return "showForm";
    }

    @PostMapping("/saveEmployee")
    public String saveEmployee (@Valid @ModelAttribute("employee") Employee employee, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "showForm";
        } else {
            employeeServices.saveFromServices ( employee );
            return "redirect:/employee/list";
        }
    }

    @GetMapping("/showFormUpdate")
    public String showFormUpdate(@RequestParam("employeeId") int id, Model model){
        Employee employee = employeeServices.getFromServices (id);
        model.addAttribute ("employee", employee);
        return "showForm";
    }

    @GetMapping("/showFormDelete")
    public String showFormDelete(@RequestParam("employeeId") int id){
        employeeServices.deleteFromServices (id);
        return "redirect:/employee/list";
    }

    @InitBinder
    public void initBinder (WebDataBinder webDataBinder) {
        StringTrimmerEditor stringTrimmerEditor = new StringTrimmerEditor ( true );
        webDataBinder.registerCustomEditor (String.class, stringTrimmerEditor);
    }
}
