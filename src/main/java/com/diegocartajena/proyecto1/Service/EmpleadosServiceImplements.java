package com.diegocartajena.proyecto1.Service;


import com.diegocartajena.proyecto1.Model.Empleados;
import com.diegocartajena.proyecto1.Repository.empleadoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmpleadosServiceImplements implements empleadoService {
    private final  empleadoRepository  empleadoRepository;

    public EmpleadosServiceImplements(empleadoRepository empleadoRepository) {
        this.empleadoRepository=empleadoRepository;
    }



    @Override
    public List<Empleados> getAllEmpleados() {
        return empleadoRepository.findAll();
    }

    @Override
    public Empleados getEmpleadoById(Integer id) {
        return empleadoRepository.findById(id).orElse(null);
    }

    @Override
    public Empleados saveEmpleado(Empleados empleado) throws RuntimeException {
        return empleadoRepository.save(empleado);
    }

    @Override
    public Empleados updateEmpleado(Integer id, Empleados empleado) {
        return empleadoRepository.save(empleado);
    }

    @Override
    public void deleteEmpleado(Integer id) {
        empleadoRepository.deleteById(id);
    }
}
