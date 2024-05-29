package it.epicode.gestionedispositivi.controllers;

import it.epicode.gestionedispositivi.controllers.models.DeviceRequest;
import it.epicode.gestionedispositivi.entities.Device;
import it.epicode.gestionedispositivi.services.DeviceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/devices")
public class DeviceController {
    @Autowired
    DeviceService deviceService;

    @PostMapping
    public ResponseEntity<Device> save(@RequestBody @Validated DeviceRequest body, BindingResult validator){
        if (validator.hasErrors()) throw new RuntimeException(String.valueOf(validator.getAllErrors()));
        var device = deviceService.save(body);
        return ResponseEntity.ok(device);
    }

    @PatchMapping("/{idDevice}/employee/{idEmployee}")
    public ResponseEntity<Device> assignToEmployee(@PathVariable Long idDevice, @PathVariable Long idEmployee){
        var device = deviceService.assignToEmployee(idEmployee, idDevice);
        return ResponseEntity.ok(device);
    }
}
