package com.employee.Work_Mode.Repository;

import com.employee.Work_Mode.Model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {
    List<Employee> findByName(String name);
    List<Employee> findByDeptId(Long deptId);
    List<Employee> findByRole(Long roleId);

    Optional<Employee> findByUsername(String username);
}
