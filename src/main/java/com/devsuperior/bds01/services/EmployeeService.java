package com.devsuperior.bds01.services;


import com.devsuperior.bds01.dto.EmployeeDTO;
import com.devsuperior.bds01.entities.Employee;
import com.devsuperior.bds01.repositories.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class EmployeeService {

    @Autowired
    EmployeeRepository repository;

    public Page<EmployeeDTO> findAllPaged(Pageable pageable){
        Page<Employee> list = repository.findAll(pageable);
        return list.map(emp -> new EmployeeDTO(emp));
    }

}
