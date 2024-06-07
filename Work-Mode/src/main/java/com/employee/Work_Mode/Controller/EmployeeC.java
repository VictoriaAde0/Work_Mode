package com.employee.Work_Mode.Controller;
import com.employee.Work_Mode.DTO.EmployeeDTO;
import com.employee.Work_Mode.Service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/employees")
public class EmployeeC {
    @Autowired
    private EmployeeService employeeService;

    @GetMapping
    public List<EmployeeDTO> getAllEmployees(){
        return employeeService.getAllEmployees();
    }

   @PostMapping
    public EmployeeDTO createEmployee(@RequestBody EmployeeDTO employeeDTO) {
        return employeeService.createEmployee(employeeDTO);
   }

   @GetMapping("/{id}")
    public EmployeeDTO getEmployeeById(@PathVariable Long id) {
        return employeeService.getEmployeeById(id);
   }
   @PutMapping("/{id}")
    public ResponseEntity<Object> updateEmployee(@PathVariable Long id, @RequestBody EmployeeDTO employeeDTO) {
        employeeService.deleteEmployee(id);
        return ResponseEntity.ok().build();
   }
   @GetMapping("/search")
    public List<EmployeeDTO> searchEmployee(@RequestParam(required = false) String name,
                                           @RequestParam(required = false) Long DeptId,
                                           @RequestParam(required = false) Long Role) {
       return employeeService.searchEmployee(name, DeptId, Role);
   }
}
