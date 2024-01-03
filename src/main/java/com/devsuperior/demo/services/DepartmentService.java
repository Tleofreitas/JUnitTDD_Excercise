package com.devsuperior.demo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.devsuperior.demo.dto.DepartmentDTO;
import com.devsuperior.demo.entities.Department;
import com.devsuperior.demo.repositories.DepartmentRepository;

@Service
public class DepartmentService {
	
	@Autowired // Acesso ao Banco de Dados
	private DepartmentRepository repository;

	// Buscar todos os Departments
	public List<DepartmentDTO> findAll() {
		// Busca ordenada por nome
		List<Department> list = repository.findAll(Sort.by("name"));
		// Converter Lista para DTO
		return list.stream().map(x -> new DepartmentDTO(x)).toList();
	}
}
