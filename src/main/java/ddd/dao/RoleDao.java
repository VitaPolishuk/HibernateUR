package ddd.dao;

import ddd.model.Role;

import java.util.List;

public interface RoleDao {
    public void addRole(Role user);
    public void changeRole(Role user);
    public void deleteRole(int id);
    public Role getRoleById(int id);
    public List<Role> returnListRole();
}

