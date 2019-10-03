package com.test.service;

import com.test.dao.UserDao;
import com.test.entity.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    UserDao userDao;

    public List<UserEntity> listAll() {
        return userDao.findAll();
    }

    public List<UserEntity> findBy(String name, Integer age, String sex) {
        UserEntity findBy = new UserEntity();
        findBy.setName(name);
        findBy.setAge(age);
        findBy.setSex(sex);
        return userDao.findBy(findBy);
    }

    public UserEntity findById(Integer id) {
        return userDao.getById(id);
    }

    public void insert(String name, Integer age, String sex) {
        UserEntity entity = new UserEntity();
        entity.setName(name);
        entity.setAge(age);
        entity.setSex(sex);
        userDao.insert(entity);

        // 配合@GeneratedValue(strategy = GenerationType.IDENTITY), 才能获取id
        System.out.println("The id of new record id :" + entity.getId());
    }

    public void insertSelective(String name, Integer age, String sex) {
        UserEntity entity = new UserEntity();
        entity.setName(name);
        entity.setAge(age);
        entity.setSex(sex);
        // 只有不空的字段才会生成到sql中
        userDao.insertSelective(entity);
        // 配合@GeneratedValue(strategy = GenerationType.IDENTITY), 才能获取id
        System.out.println("The id of new record id :" + entity.getId());
    }

    public void updateBy(Integer id, String name, Integer age, String sex) {
        UserEntity entity = new UserEntity();
        entity.setId(id);
        entity.setName(name);
        entity.setAge(age);
        entity.setSex(sex);
        userDao.updateByPrimarySelective(entity);
    }

    public void delete(Integer id, String name, Integer age, String sex) {
        UserEntity entity = new UserEntity();
        entity.setId(id);
        entity.setName(name);
        entity.setAge(age);
        entity.setSex(sex);
        userDao.delete(entity);
    }

    public void deleteByPrimaryKey(Integer id) {
        userDao.deleteByPrimaryKey(id);
    }


    // qbc query by criteria
    public void selectByExample() {

    }

}
