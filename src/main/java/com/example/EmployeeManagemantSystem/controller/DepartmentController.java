package com.example.EmployeeManagemantSystem.controller;

import com.example.EmployeeManagemantSystem.model.Department;
import com.example.EmployeeManagemantSystem.repo.DepartmentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
public class DepartmentController {

    @Autowired
    private DepartmentRepo departmentRepo;

    @GetMapping("/getAllDepartments")
    public ResponseEntity<List<Department>> getAllDepartments(){
        try {
            List<Department> departmentList = new ArrayList<>();
            departmentRepo.findAll().forEach(departmentList::add);

            if (departmentList.isEmpty()){
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }

            return new ResponseEntity<>(departmentList , HttpStatus.OK);

        } catch (Exception e) {

            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }


    @PostMapping("/addDepartment")
    public ResponseEntity<Department> addDepartment(@RequestBody Department department){
        Department departmentObj = departmentRepo.save(department);

        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/getDepartmentById/{id}")
    public ResponseEntity<Department> getDepartmentById(@PathVariable Long id){
        Optional<Department> departmentData = departmentRepo.findById(id);

        if (departmentData.isPresent()){
            return new ResponseEntity<>(HttpStatus.OK);
        }

        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }


    @DeleteMapping("/deleteDepartmentById/{id}")
    public ResponseEntity<Department> deleteDepartmentById(@PathVariable Long id){

        departmentRepo.deleteById(id);

        return new ResponseEntity<>(HttpStatus.OK);
    }


}
