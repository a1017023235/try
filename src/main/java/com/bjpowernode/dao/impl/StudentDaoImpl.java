package com.bjpowernode.dao.impl;

import com.bjpowernode.dao.StudentDao;
import com.bjpowernode.domain.Student;
import com.bjpowernode.util.DBUtils;
import com.bjpowernode.util.TransactionInvocationHandler;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

public class StudentDaoImpl implements StudentDao {
    @Override
    public Student byId(String id) {
        SqlSession sqlSession = DBUtils.getSqlSession();
        Student students = sqlSession.selectOne("com.bjpowernode.dao.StudentDao.byId",id);
        return students;
    }

    @Override
    public void save(Student student) {
        SqlSession sqlSession = DBUtils.getSqlSession();
        sqlSession.insert("com.bjpowernode.dao.StudentDao.save",student);
    }
}
