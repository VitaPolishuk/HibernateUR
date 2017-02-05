package ddd.services;

import ddd.dao.RoleDao;
import ddd.model.Role;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("roleService")
public class RoleServiceImpl implements RoleService{

    private RoleDao roleDao;
    public RoleServiceImpl(RoleDao roleDao) {
        this.roleDao = roleDao;
    }

    @Override
    @Transactional
    public void addRole(Role role) {
        this.roleDao.addRole(role);
    }

    @Override
    @Transactional
    public void changeRole(Role role) {
        this.roleDao.changeRole(role);
    }

    @Override
    @Transactional
    public void deleteRole(int id) {
        this.roleDao.deleteRole(id);
    }

    @Override
    @Transactional
    public Role getRoleById(int id) {
        return this.roleDao.getRoleById(id);
    }

    @Override
    @Transactional
    public List<Role> returnListRole() {
       return this.roleDao.returnListRole();
    }
}
