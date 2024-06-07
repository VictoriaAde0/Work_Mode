package com.employee.Work_Mode.DTO;
import com.employee.Work_Mode.Model.Employee;
import jakarta.persistence.*;

import java.util.Set;

public class RoleDTO {
    private Long Id;
    private String Name;

    @ManyToMany(mappedBy = "roles")
    private Set<Employee> employees;


    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }
}
