package com.devsuperior.bds01.controllers;

import com.devsuperior.bds01.dto.EmployeeDTO;
import com.devsuperior.bds01.services.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("employees")
public class EmployeeController {

    @Autowired
    EmployeeService service;


    @GetMapping
    public ResponseEntity<Page<EmployeeDTO>> findAll(Pageable pageable){
        Page<EmployeeDTO> list  = service.findAllPaged(pageable);
        return ResponseEntity.ok().body(list);
    }

}
