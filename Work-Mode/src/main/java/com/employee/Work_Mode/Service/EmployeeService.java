package com.employee.Work_Mode.Service;

import com.employee.Work_Mode.DTO.EmployeeDTO;


import java.util.List;

public interface EmployeeService {

    List<EmployeeDTO> getAllEmployees();
    EmployeeDTO getEmployeeById(Long id);
    EmployeeDTO createEmployee(EmployeeDTO employeeDTO);
    EmployeeDTO updateEmployee(Long id, EmployeeDTO employeeDTO);
    void deleteEmployee(Long id);
    List<EmployeeDTO> searchEmployee(String name, Long deptId, Long roleId);

    EmployeeDTO loadUserByUsername(String username);

    List<EmployeeDTO> searchEmployees(String name, Long departmentId, Long roleId);
}
