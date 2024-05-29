package it.epicode.gestionedispositivi.controllers;

import it.epicode.gestionedispositivi.controllers.models.EmployeeRequest;
import it.epicode.gestionedispositivi.entities.Employee;
import it.epicode.gestionedispositivi.services.EmployeeService;
import org.apache.coyote.BadRequestException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

    @Autowired
    EmployeeService employeeService;

    @PostMapping
    public ResponseEntity<Employee> save(@RequestBody @Validated EmployeeRequest employee, BindingResult validator){
        if (validator.hasErrors()) throw new RuntimeException(String.valueOf(validator.getAllErrors()));
        var emp = employeeService.save(employee);
        return ResponseEntity.ok(emp);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<Employee> update(@PathVariable Long id, @RequestBody @Validated EmployeeRequest employee, BindingResult validator){
        if (validator.hasErrors()) throw new RuntimeException(String.valueOf(validator.getAllErrors()));
        var emp = employeeService.update(id, employee);
        return ResponseEntity.ok(emp);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Employee> delete(@PathVariable Long id){
        var emp = employeeService.delete(id);
        return ResponseEntity.ok(emp);
    }

    @GetMapping
    public ResponseEntity<List<Employee>> findAll(){
        var employees = employeeService.findAll();
        return ResponseEntity.ok(employees);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Employee> findById(@PathVariable Long id){
        var employee = employeeService.findById(id);
        return ResponseEntity.ok(employee);
    }


}
