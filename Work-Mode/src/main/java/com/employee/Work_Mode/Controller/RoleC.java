package com.employee.Work_Mode.Controller;
import com.employee.Work_Mode.DTO.RoleDTO;
import com.employee.Work_Mode.Model.Role;
import com.employee.Work_Mode.Service.RoleService;
import jakarta.validation.Valid;
import org.springframework.beans.BeanUtils;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/roles")
public class RoleC {
    @Autowired
    private RoleService roleService;

    @GetMapping
    public ResponseEntity<List<RoleDTO>> getAllRoles() {
        List<Role> roles = roleService.getAllRoles();
        List<RoleDTO> roleDTOS = roles.stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
        return ResponseEntity.ok(roleDTOS);
    }

    @GetMapping("/{id}")
    public ResponseEntity<RoleDTO> getRoleById(@PathVariable Long id) {
        Role role = roleService.getRoleById(id);
        if (role != null) {
            return ResponseEntity.ok(convertToDTO(role));
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public ResponseEntity<RoleDTO> createRole(@Valid @RequestBody RoleDTO roleDTO) {
        Role role = convertToEntity(roleDTO);
        Role createdRole = roleService.createRole(role);
        return ResponseEntity.status(HttpStatus.CREATED).body(convertToDTO(createdRole));
    }

    @PutMapping("/{id}")
    public ResponseEntity<RoleDTO> updateRole(@PathVariable Long id, @Valid @RequestBody RoleDTO roleDTO) {
        Role role = convertToEntity(roleDTO);
        Role updatedRole = roleService.updateRole(id, role);
        if (updatedRole != null) {
            return ResponseEntity.ok(convertToDTO(updatedRole));
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteRole(@PathVariable Long id) {
        roleService.deleteRole(id);
        return ResponseEntity.noContent().build();
    }

    private RoleDTO convertToDTO(Role role) {
        RoleDTO roleDTO = new RoleDTO();
        BeanUtils.copyProperties(role, roleDTO);
        return roleDTO;
    }

    private Role convertToEntity(RoleDTO roleDTO) {
        Role role = new Role();
        BeanUtils.copyProperties(roleDTO, role);
        return role;
    }
}
