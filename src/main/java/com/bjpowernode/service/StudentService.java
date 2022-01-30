package com.bjpowernode.service;

import com.bjpowernode.domain.Student;

public interface StudentService {
    public void byId(String id);
    public void save(Student student);
}
