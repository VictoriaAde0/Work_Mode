package com.employee.Work_Mode.ServiceImpl;

import com.employee.Work_Mode.DTO.DepartmentDTO;
import com.employee.Work_Mode.Model.Department;
import com.employee.Work_Mode.Repository.DepartmentRepository;
import com.employee.Work_Mode.Service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class deptServiceImpl implements DeptService {

    @Autowired
    private DepartmentRepository departmentRepository;

    @Override
    public List<Department> getAllDepts() {
        return departmentRepository.findAll();
    }

    @Override
    public Department getDeptById(Long id) {
        return departmentRepository.findById(id).orElse(null);
    }

    @Override
    public Department createDept(DepartmentDTO departmentDTO) {
        Department department = convertToEntity(departmentDTO);
        return departmentRepository.save(department);
    }

    @Override
    public Department updateDept(Long id, DepartmentDTO departmentDTO) {
        Optional<Department> departmentOptional = departmentRepository.findById(id);
        if (departmentOptional.isPresent()) {
            Department department = departmentOptional.get();
            department.setName(departmentDTO.getName());
            return departmentRepository.save(department);
        } else {
            return null;
        }
    }

    @Override
    public void deleteDept(Long id) {
        departmentRepository.deleteById(id);
    }

    private Department convertToEntity(DepartmentDTO departmentDTO) {
        Department department = new Department();
        department.setName(departmentDTO.getName());
        return department;
    }
}
