package com.employee.Work_Mode.Service;

import com.employee.Work_Mode.DTO.DepartmentDTO;
import com.employee.Work_Mode.Model.Department;
import java.util.List;
public interface DeptService {
    List<Department> getAllDepts();
    Department getDeptById(Long id);
    Department createDept(DepartmentDTO department);
    Department updateDept(Long id, DepartmentDTO department);
    void deleteDept(Long id);
}
