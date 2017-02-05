package ddd.dao;

import ddd.model.Role;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository("roleDao")

public class RoleDaoImpl implements RoleDao {
    private static Logger logger = LoggerFactory.getLogger(RoleDaoImpl.class);
    private SessionFactory sessionFactory;// будет создавать сессию для создания соединения с БД

    public RoleDaoImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public void addRole(Role role) {
        Session session = this.sessionFactory.getCurrentSession();
        session.persist(role);
        logger.info("Роль успешно добавлена" + role);
    }

    @Override
    public void changeRole(Role role) {
        Session session = this.sessionFactory.getCurrentSession();
        session.update(role);
        logger.info("Роль была успешно изменена" + role);
    }

    @Override
    public void deleteRole(int id) {
        Session session = this.sessionFactory.getCurrentSession();
        Role role = (Role) session.load(Role.class, new Integer(id));
        if (role != null) {
            session.delete(role);
        }
        logger.info("Роль была успешно удалена" + role);
    }

    @Override
    public Role getRoleById(int id) {
        Session session = this.sessionFactory.getCurrentSession();
        Role role = (Role) session.load(Role.class, new Integer(id));
        logger.info("Роль была успешно загружена" + role);
        return role;
    }

    @Transactional
    public List<Role> returnListRole() {
        @SuppressWarnings("unchecked")

        List<Role> listRole = (List<Role>) sessionFactory.getCurrentSession()
                .createCriteria(Role.class)
                .setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();
        System.out.println(listRole);
        return listRole;
    }
}
