package com.diegocartajena.proyecto1.Repository;

import com.diegocartajena.proyecto1.Model.Empleados;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface empleadoRepository extends JpaRepository<Empleados, Integer> {
}
