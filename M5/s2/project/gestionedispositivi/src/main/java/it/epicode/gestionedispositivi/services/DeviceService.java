package it.epicode.gestionedispositivi.services;

import it.epicode.gestionedispositivi.controllers.exceptions.*;
import it.epicode.gestionedispositivi.controllers.models.DeviceRequest;
import it.epicode.gestionedispositivi.daos.DeviceDAO;
import it.epicode.gestionedispositivi.daos.EmployeeDAO;
import it.epicode.gestionedispositivi.entities.Device;
import it.epicode.gestionedispositivi.entities.enums.DeviceState;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class DeviceService {
    @Autowired
    DeviceDAO deviceDAO;

    @Autowired
    EmployeeDAO employeeDAO;

    public Device save(DeviceRequest body){
        var device = Device.builder()
                .withState(body.state())
                .withType(body.type())
                .build();
        return deviceDAO.save(device);
    }

    public Device assignToEmployee(Long idEmployee, Long idDevice){
        var device = deviceDAO.findById(idDevice).orElseThrow(() -> new DeviceNotFoundException("Dispositivo non esistente."));
        var employee = employeeDAO.findById(idEmployee).orElseThrow(() -> new EmployeeNotFoundException("Dipendente non esistente."));
        switch (device.getState()){
            case DISUSED:
                throw new DeviceDisusedException("Dispositivo in disuso.");
            case ASSIGNED:
                throw new DeviceAlreadyAssignedException("Dispositivo già associato ad un dipendente.");
            case UNDER_MAINTENANCE:
                throw new DeviceUnderMaintenanceException("Dispositivo in manutenzione.");
        }
        try {
            device.setEmployee(employee);
            device.setState(DeviceState.ASSIGNED);
            deviceDAO.save(device);
        } catch (DeviceStateException exception){
            log.error("Problema con lo stato del dispositivo.");
        } catch (NotFoundException exception){
            log.error("Elemento non trovato.");
        } catch (Exception exception){
            log.error("Eccezione non gestita.");
        }
        return device;
    }
}
