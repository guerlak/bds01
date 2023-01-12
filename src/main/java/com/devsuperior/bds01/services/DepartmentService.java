package com.devsuperior.bds01.services;

import com.devsuperior.bds01.dto.DepartmentDTO;
import com.devsuperior.bds01.entities.Department;
import com.devsuperior.bds01.repositories.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class DepartmentService {

    @Autowired
    DepartmentRepository repo;

    @Transactional(readOnly = true)
    public Page<DepartmentDTO> findAllPaged(Pageable pageable){
         Page<Department> list = repo.findAll(pageable);
         return list.map(dep -> new DepartmentDTO(dep.getId(), dep.getName()));
    }
}
