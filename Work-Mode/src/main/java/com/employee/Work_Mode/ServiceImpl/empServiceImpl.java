package com.employee.Work_Mode.ServiceImpl;

import com.employee.Work_Mode.DTO.EmployeeDTO;
import com.employee.Work_Mode.Model.Employee;
import com.employee.Work_Mode.Repository.EmployeeRepository;
import com.employee.Work_Mode.Service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class empServiceImpl implements EmployeeService{
    @Autowired
    private EmployeeRepository employeeRepository;

    @Override
    public List<EmployeeDTO> getAllEmployees() {
        return employeeRepository.findAll().stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    @Override
    public EmployeeDTO createEmployee(EmployeeDTO employeeDTO) {
        Employee employee = convertToEntity(employeeDTO);
        employee = employeeRepository.save(employee);
        return convertToDTO(employee);
    }

    @Override
    public EmployeeDTO getEmployeeById(Long id) {
        Optional<Employee> employee = employeeRepository.findById(id);
        if (employee.isPresent()) {
            return convertToDTO(employee.get());
        } else {
            throw new UsernameNotFoundException("Employee not found with id: " + id);
        }
    }

    @Override
    public EmployeeDTO updateEmployee(Long id, EmployeeDTO employeeDTO) {
        Optional<Employee> employeeOptional = employeeRepository.findById(id);
        if (employeeOptional.isPresent()) {
            Employee employee = employeeOptional.get();
            employee.setName(employeeDTO.getName());
            employee.setEmail(employeeDTO.getEmail());
            employee.setDepartment(employeeDTO.getDepartment());
            employee.setRoles(employeeDTO.getRoles());
            employee = employeeRepository.save(employee);
            return convertToDTO(employee);
        } else {
            throw new UsernameNotFoundException("Employee not found with id: " + id);
        }
    }

    @Override
    public void deleteEmployee(Long id) {
        employeeRepository.deleteById(id);
    }

    @Override
    public List<EmployeeDTO> searchEmployee(String name, Long deptId, Long roleId) {
        // Implement search logic here
        return null;
    }

    @Override
    public EmployeeDTO loadUserByUsername(String username) {
        Optional<Employee> employee = employeeRepository.findByUsername(username);
        if (employee.isPresent()) {
            return convertToDTO(employee.get());
        } else {
            throw new UsernameNotFoundException("User not found with username: " + username);
        }
    }

    @Override
    public List<EmployeeDTO> searchEmployees(String name, Long departmentId, Long roleId) {
        List<Employee> employees = employeeRepository.findAll();

        if (name != null && !name.isEmpty()) {
            employees = employees.stream()
                    .filter(employee -> employee.getName().toLowerCase().contains(name.toLowerCase()))
                    .collect(Collectors.toList());
        }

        if (departmentId != null) {
            employees = employees.stream()
                    .filter(employee -> employee.getDepartment().getId().equals(departmentId))
                    .collect(Collectors.toList());
        }

        if (roleId != null) {
            employees = employees.stream()
                    .filter(employee -> employee.getRoles().stream().anyMatch(role -> role.getId().equals(roleId)))
                    .collect(Collectors.toList());
        }

        return employees.stream().map(this::convertToDTO).collect(Collectors.toList());
    }

    private EmployeeDTO convertToDTO(Employee employee) {
        EmployeeDTO employeeDTO = new EmployeeDTO();
        employeeDTO.setId(employee.getId());
        employeeDTO.setName(employee.getName());
        employeeDTO.setEmail(employee.getEmail());
        employeeDTO.setDepartment(employee.getDepartment());
        employeeDTO.setRoles(employee.getRoles());
        return employeeDTO;
    }

    private Employee convertToEntity(EmployeeDTO employeeDTO) {
        Employee employee = new Employee();
        employee.setId(employeeDTO.getId());
        employee.setName(employeeDTO.getName());
        employee.setEmail(employeeDTO.getEmail());
        employee.setDepartment(employeeDTO.getDepartment());
        employee.setRoles(employeeDTO.getRoles());
        return employee;
    }
}
