package ddd.services;

import ddd.model.Role;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface RoleService {
    public void addRole(Role user);

    public void changeRole(Role user);

    public void deleteRole(int id);

    public Role getRoleById(int id);

    public List<Role> returnListRole();
}
