package com.diegocartajena.proyecto1.Service;

import com.diegocartajena.proyecto1.Model.Empleados;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface empleadoService {

    List<Empleados> getAllEmpleados();
    Empleados getEmpleadoById(Integer id);
    Empleados saveEmpleado(Empleados empleado)throws RuntimeException;
    Empleados updateEmpleado(Integer id, Empleados empleado ) ;
    void deleteEmpleado(Integer id);
}
