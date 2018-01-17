package cn.felixgu.module.seckill.dao;

import cn.felixgu.module.seckill.entity.UserEntity;
import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.orm.hibernate4.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;

@Repository
public class UserDao extends HibernateDaoSupport {

    @Autowired
    public UserDao(SessionFactory sessionFactory) {
        setSessionFactory(sessionFactory);
    }

    public void save(UserEntity user) throws DataAccessException,HibernateException{
        getHibernateTemplate().save(user);
    }

}
