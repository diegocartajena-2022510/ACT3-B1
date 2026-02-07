package com.diegocartajena.proyecto1.Controller;

import com.diegocartajena.proyecto1.Model.Empleados;
import jakarta.validation.Valid;
import com.diegocartajena.proyecto1.Service.empleadoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/api/empleados")

public class empleadoController {
    private final empleadoService empleadoService;

    public empleadoController(empleadoService empleadoService) { this.empleadoService= empleadoService; }

    @GetMapping
    public List<Empleados> getAllEmpleados() { return empleadoService.getAllEmpleados();}


    @PostMapping
    public ResponseEntity<Object> createEmpleado(@Valid @RequestBody Empleados empleado) {
        try{
            Empleados createdEmpleado= empleadoService.saveEmpleado(empleado);
            return new ResponseEntity<>(createdEmpleado, HttpStatus.CREATED);

        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }

    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> updateEmpleado(@PathVariable Integer id, @Valid @RequestBody Empleados empleado) {
        try{
            Empleados empleados = empleadoService.getEmpleadoById(id);
            if (empleados == null) {
                return ResponseEntity.notFound().build();
            }
            empleado.setIdEmpleado(id);

            Empleados updatedEmpleado = empleadoService.updateEmpleado(id, empleado);
            return ResponseEntity.ok(updatedEmpleado);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteEmpleado(@PathVariable Integer id) {
        try {

            Empleados empleado = empleadoService.getEmpleadoById(id);

            empleadoService.deleteEmpleado(id);
            return ResponseEntity.noContent().build();
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> getEmpleadoById(@PathVariable Integer id) {
        try {
            Empleados empleado = empleadoService.getEmpleadoById(id);
            return ResponseEntity.ok(empleado);

        }catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }

    }

}






