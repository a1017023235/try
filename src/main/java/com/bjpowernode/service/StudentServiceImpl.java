package com.bjpowernode.service;

import com.bjpowernode.dao.StudentDao;
import com.bjpowernode.dao.impl.StudentDaoImpl;
import com.bjpowernode.domain.Student;
import com.bjpowernode.util.DBUtils;
import com.bjpowernode.util.ServiceFactory;
import org.apache.ibatis.session.SqlSession;

public class StudentServiceImpl implements StudentService{
    private StudentDao studentDao = new StudentDaoImpl();

    public void byId(String id){
        Student student = studentDao.byId(id);
        System.out.println(student);
    }

    @Override
    public void save(Student student){
        studentDao.save(student);

    }
}
