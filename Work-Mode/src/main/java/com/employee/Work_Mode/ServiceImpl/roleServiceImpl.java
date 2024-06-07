package com.employee.Work_Mode.ServiceImpl;

import com.employee.Work_Mode.DTO.RoleDTO;
import com.employee.Work_Mode.Model.Role;
import com.employee.Work_Mode.Repository.RoleRepository;
import com.employee.Work_Mode.Service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
@Service
public class roleServiceImpl implements RoleService {
    @Autowired
    private RoleRepository roleRepository;

    @Override
    public List<Role> getAllRoles() {
        return roleRepository.findAll().stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    @Override
    public Role getRoleById(Long id) {
        Optional<Role> role = roleRepository.findById(id);
        if (role.isPresent()) {
        return convertToDTO(role.get());
        } else {
            return null;
        }
    }

    @Override
    public Role createRole(Role role) {
        return null;
    }

    @Override
    public Role updateRole(Long id, Role role) {
        return null;
    }

    public Role createRole(RoleDTO roleDTO) {
        Role role = convertToEntity(roleDTO);
        role = roleRepository.save(role);
        return convertToDTO(role);
    }

    private Role convertToEntity(RoleDTO roleDTO) {
        return null;
    }


    public Role updateRole(Long id, RoleDTO roleDTO) {
        Optional<Role> roleOptional = roleRepository.findById(id);
        if (roleOptional.isPresent()) {
            Role role = roleOptional.get();
            role.setName(roleDTO.getName());
            role = roleRepository.save(role);
            return convertToDTO(role);
        } else {
            return null;
        }
    }

    @Override
    public void deleteRole(Long id) {
        roleRepository.deleteById(id);
    }

    private Role convertToDTO(Role role) {
        RoleDTO roleDTO = new RoleDTO();
        roleDTO.setId(role.getId());
        roleDTO.setName(roleDTO.getName());
        return role;
    }
}
