package com.ej2.service;

import java.util.List;

import com.ej2.dto.Empleado;

public interface IEmpleadoService {

	//Métodos del CRUD
	public List<Empleado> listarEmpleados(); //Listar All
	
	public Empleado guardarEmpleado(Empleado Empleado); //Guarda un empleado CREATE
	
	public Empleado EmpleadoXID(Long id); //Leer datos de un empleado READ
	
	public Empleado actualizarEmpleado(Empleado Empleado); //Actualiza datos del empleado UPDATE
	
	public void eliminarEmpleado(Long id);//Elimina el empleado DELETE
}
