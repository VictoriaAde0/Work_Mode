package com.employee.Work_Mode.Controller;
import com.employee.Work_Mode.DTO.DepartmentDTO;
import com.employee.Work_Mode.Model.Department;
import com.employee.Work_Mode.Service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/departments")
public class DeptC {
    @Autowired
    private DeptService deptService;

    @GetMapping
    public List<Department> getAllDepts() {
        return deptService.getAllDepts();
    }

    @PostMapping
    public Department createDept(@RequestBody DepartmentDTO departmentDTO) {
        return deptService.createDept(departmentDTO);
    }

    @GetMapping("/{id}")
    public Department getDeptById(@PathVariable Long id) {
        return deptService.getDeptById(id);
    }

    @PutMapping("/{id}")
    public Department updateDept(@PathVariable Long id, @RequestBody DepartmentDTO departmentDTO) {
       return deptService.updateDept(id, departmentDTO);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteDept(@PathVariable Long id) {
        deptService.deleteDept(id);
        return ResponseEntity.ok().build();
    }
}
