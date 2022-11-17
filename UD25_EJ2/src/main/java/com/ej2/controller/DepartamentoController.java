package com.ej2.controller;

import java.util.List;
import com.ej2.dto.Departamento;
import com.ej2.service.DepartamentoServiceImpl;

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
public class DepartamentoController {

	@Autowired
	DepartamentoServiceImpl dep;
	
	//listar departamentos
	@GetMapping("/departamentos")
	public List<Departamento> listarDepartamentos(){
		return dep.listarDepartamentos();
	}
	
	//guardar un departamento
	@PostMapping("/departamentos")
	public Departamento guardarDepart(@RequestBody Departamento Departamento) {
		return dep.guardarDepartamento(Departamento);
	}
	
	//mostrar departamento según ID
	@GetMapping("/departamentos/{id}") 
	public Departamento DepartamentoXID(@PathVariable(name="id") Long id){ 
		Departamento Departamento_xid = new Departamento();
		
		Departamento_xid=dep.DepartamentoXID(id);
		
		System.out.println("Departamento XID: "+Departamento_xid);
		
		return Departamento_xid;
	}
	
	//actualizar departamento segun ID
	@PutMapping("/departamentos/{id}")
	public Departamento actualizarDepartamento(@PathVariable(name="id")Long id,@RequestBody Departamento Departamento) {
		
		Departamento dep_select= new Departamento();
		Departamento dep_act= new Departamento();
		
		dep_select= dep.DepartamentoXID(id);
		
		dep_select.setNombre(Departamento.getNombre());
		dep_select.setEmpleado(Departamento.getEmpleado());
		
		dep_act = dep.actualizarDepartamento(dep_select);
		
		System.out.println("El Departamento actualizado es: "+ dep_act);
		
		return dep_act;
	}
	
	//eliminar departamento con ID indicada
	@DeleteMapping("/departamentos/{id}")
	public void eleiminarDepartamento(@PathVariable(name="id")Long id) {
		dep.eliminarDepartamento(id);
	}
}
