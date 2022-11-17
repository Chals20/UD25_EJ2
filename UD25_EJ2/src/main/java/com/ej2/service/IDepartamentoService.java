package com.ej2.service;

import java.util.List;

import com.ej2.dto.Departamento;

public interface IDepartamentoService {

	//Métodos del CRUD
	public List<Departamento> listarDepartamentos(); //Listar All
	
	public Departamento guardarDepartamento(Departamento Departamento); //Guarda un departamento CREATE
	
	public Departamento DepartamentoXID(Long id); //Leer datos de un departamento READ
	
	public Departamento actualizarDepartamento(Departamento Departamento); //Actualiza datos del departamento UPDATE
	
	public void eliminarDepartamento(Long id);//Elimina el departamento DELETE
}
