package com.devsuperior.bds01.services;


import com.devsuperior.bds01.dto.EmployeeDTO;
import com.devsuperior.bds01.entities.Department;
import com.devsuperior.bds01.entities.Employee;
import com.devsuperior.bds01.repositories.DepartmentRepository;
import com.devsuperior.bds01.repositories.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class EmployeeService {

    @Autowired
    EmployeeRepository repository;

    @Autowired
    DepartmentRepository departmentRepository;

    @Transactional(readOnly = true)
    public Page<EmployeeDTO> findAllPaged(Pageable pageable){
        Page<Employee> list = repository.findAll(pageable);
        return list.map(emp -> new EmployeeDTO(emp));
    }

    @Transactional
    public Employee update(Long id, EmployeeDTO dto){
        Employee employee = repository.getOne(id);
        employee.setEmail(dto.getEmail());
        employee.setName(dto.getName());
        Department department = departmentRepository.getOne(dto.getDepartmentId());

        employee.setDepartment(department);
        repository.save(employee);
        return employee;
    }

    @Transactional
    public Employee create(EmployeeDTO dto){
        Employee employee = new Employee();
        employee.setEmail(dto.getEmail());
        employee.setName(dto.getName());
        Department department = departmentRepository.getOne(dto.getDepartmentId());
        employee.setDepartment(department);


        repository.save(employee);
        return employee;
    }

}
