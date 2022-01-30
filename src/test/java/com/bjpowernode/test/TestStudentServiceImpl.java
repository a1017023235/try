package com.bjpowernode.test;

import com.bjpowernode.domain.Student;
import com.bjpowernode.service.StudentService;
import com.bjpowernode.service.StudentServiceImpl;
import com.bjpowernode.util.ServiceFactory;
import org.junit.Test;

public class TestStudentServiceImpl {
    @Test
    public void testById(){
        StudentServiceImpl service = new StudentServiceImpl();
        String id = "100";
        service.byId(id);
    }

    @Test
    public void testSave(){
        StudentService service = (StudentService) ServiceFactory.getService(new StudentServiceImpl());
        Student student = new Student();
        student.setAge("14");
        student.setEmail("fw@qq");
        student.setId("19");
        student.setName("ll");
        service.save(student);

    }
}
