package com.ej2.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ej2.dto.Empleado;

public interface IEmpleadoDAO extends JpaRepository<Empleado, Long>{

}
