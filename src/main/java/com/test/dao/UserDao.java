package com.test.dao;

import com.test.dao.mapper.UserMapper;
import com.test.entity.UserEntity;
import org.apache.ibatis.session.RowBounds;
import org.h2.engine.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

@Repository
public class UserDao {

    @Autowired
    UserMapper userMapper;

    public List<UserEntity> findAll() {
        return userMapper.selectAll();
    }

    /**
     * 需要配合@Id注解一起使用。
     * @param id
     * @return
     */
    public UserEntity getById(Integer id) {
        return userMapper.selectByPrimaryKey(id);
    }

    public List<UserEntity> findBy(UserEntity userEntity) {
        return userMapper.select(userEntity);
    }

    public void insert(UserEntity userEntity) {
        userMapper.insert(userEntity);
    }

    public void insertSelective(UserEntity userEntity) {
        userMapper.insertSelective(userEntity);
    }

    public void updateByPrimarySelective(UserEntity userEntity) {
        userMapper.updateByPrimaryKeySelective(userEntity);
    }

    public void delete(UserEntity userEntity) {
        // 注意：如果userEntity为null，会删除所有数据
        userMapper.delete(userEntity);
    }

    public void deleteByPrimaryKey(Integer id) {
        userMapper.deleteByPrimaryKey(id);
    }

    public List<UserEntity> selectByExample() {
        Example example = new Example(UserEntity.class);
        Example.Criteria criteria = example.createCriteria();
        Example.Criteria criteria1 = example.createCriteria();

        criteria.andLessThanOrEqualTo("age",  19);

        criteria1.andGreaterThan("age", 21);
        example.or(criteria1);

        // 设置排序
        example.orderBy("age").desc();
        // 设置去重
        example.setDistinct(true);
        // 设置查询的属性
        example.selectProperties("age", "name");
        return userMapper.selectByExample(example);
    }

    public List<UserEntity> selectByRowBounds() {
        RowBounds rowBounds = new RowBounds(3, 10);
        UserEntity entity = new UserEntity();
        entity.setName("test");
        // 假分页，sql并没有limit语句
        userMapper.selectByRowBounds(entity, rowBounds);
    }
}
