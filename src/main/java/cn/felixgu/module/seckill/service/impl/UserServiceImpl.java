package cn.felixgu.module.seckill.service.impl;

import cn.felixgu.module.seckill.dao.UserDao;
import cn.felixgu.module.seckill.entity.UserEntity;
import cn.felixgu.module.seckill.service.UserService;
import org.hibernate.HibernateException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserServiceImpl implements UserService{

    @Autowired
    UserDao userDao;

    @Override
    public void test() throws DataAccessException,HibernateException{
        UserEntity user1 = new UserEntity();
        user1.setId(23);
        user1.setImageId(11);
        userDao.save(user1);
//        UserEntity user2 = new UserEntity();
//        user2.setId(23);
//        user2.setImageId(22);
//        userDao.save(user2);
    }
}
