package com.employee.Work_Mode.Service;
import com.employee.Work_Mode.Model.Role;
import java.util.List;
public interface RoleService {
    List<Role> getAllRoles();
    Role getRoleById(Long id);
    Role createRole(Role role);
    Role updateRole(Long id, Role role);
    void deleteRole(Long id);
}
