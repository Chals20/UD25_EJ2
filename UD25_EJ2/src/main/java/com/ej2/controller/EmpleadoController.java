package com.ej2.controller;

import java.util.List;
import com.ej2.dto.Empleado;
import com.ej2.service.EmpleadoServiceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class EmpleadoController {

	@Autowired
	EmpleadoServiceImpl empl;
	
	//listar todos los empleados
	@GetMapping("/empleados")
	public List<Empleado> listarEmpleados(){
		return empl.listarEmpleados();
	}
	
	//guardar un empleado
	@PostMapping("/empleados")
	public Empleado guardarEmpl(@RequestBody Empleado Empleado) {
		return empl.guardarEmpleado(Empleado);
	}
	
	//mostrar empleado segun ID
	@GetMapping("/empleados/{id}") 
	public Empleado EmpleadoXID(@PathVariable(name="id") Long id){ 
		Empleado empleado_xid = new Empleado();
		
		empleado_xid=empl.EmpleadoXID(id);
		System.out.println("Empleado XID: "+empleado_xid);
		
		return empleado_xid;
	}
	
	//actualizar datos empleado ID
	@PutMapping("/empleados/{id}")
	public Empleado actualizarEmpleado(@PathVariable(name="id")Long id,@RequestBody Empleado Empleado) {
		
		Empleado empl_select= new Empleado();
		Empleado empl_act= new Empleado();
		
		empl_select= empl.EmpleadoXID(id);
		
		empl_select.setNombre(Empleado.getNombre());
		empl_select.setApellidos(Empleado.getApellidos());
		empl_select.setDepartamento(Empleado.getDepartamento());
		
		empl_act = empl.actualizarEmpleado(empl_select);
		
		System.out.println("El Empleado actualizado es: "+ empl_act);
		
		return empl_act;
	}
	
	//eliminar empleado ID
	@DeleteMapping("/empleados/{id}")
	public void eleiminarEmpleado(@PathVariable(name="id")Long id) {
		empl.eliminarEmpleado(id);
	}
}
