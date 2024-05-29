package it.epicode.gestionedispositivi.services;

import it.epicode.gestionedispositivi.controllers.exceptions.EmployeeNotFoundException;
import it.epicode.gestionedispositivi.controllers.exceptions.NotFoundException;
import it.epicode.gestionedispositivi.controllers.models.EmployeeRequest;
import it.epicode.gestionedispositivi.daos.EmployeeDAO;
import it.epicode.gestionedispositivi.entities.Employee;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class EmployeeService {
    @Autowired
    EmployeeDAO employeeDAO;

    public Employee save(EmployeeRequest body){
        var employee = Employee.builder()
                .withEmail(body.email())
                .withName(body.name())
                .withSurname(body.surname())
                .withUsername(body.username())
                .build();
        return employeeDAO.save(employee);
    }

    public Employee delete (Long id){
        var employee = employeeDAO.findById(id).orElseThrow(() -> new EmployeeNotFoundException("Dipendente da eliminare non trovato."));
        try {
        employeeDAO.deleteById(id);
        } catch (NotFoundException exception){
            log.error("Elemento non trovato.");
        }
        return employee;
    }

    public Employee update(Long id, EmployeeRequest body){
        var employee = employeeDAO.findById(id).orElseThrow(() -> new EmployeeNotFoundException("Dipendente da aggiornare non trovato."));
        try {
            if (body.name() != null) employee.setName(body.name());
            if (body.surname() != null) employee.setSurname(body.surname());
            if (body.email() != null) employee.setEmail(body.email());
            if (body.username() != null) employee.setUsername(body.username());
        } catch (NotFoundException exception){
            log.error("Elemento non trovato");
        } catch (Exception exception){
            log.error("Eccezione non gestita");
        }
        return employeeDAO.save(employee);
    }

    public Employee findById(Long id){
        return employeeDAO.findById(id).orElseThrow(() -> new EmployeeNotFoundException("Dipendente non trovato."));
    }

    public List<Employee> findAll(){
        return employeeDAO.findAll();
    }
}
