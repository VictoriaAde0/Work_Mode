package com.employee.Work_Mode.Repository;
import com.employee.Work_Mode.Model.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface DepartmentRepository extends JpaRepository<Department, Long> {

}
