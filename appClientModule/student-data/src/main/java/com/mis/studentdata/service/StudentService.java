package com.mis.studentdata.service;

import java.util.List;

import com.mis.studentdata.entities.Students;

public interface StudentService {

    List<Students> getStudents();

    List<Students> addStudent(Students student);

    List<Students> updateStudent(Long id, Students student);
    
    List<Students> deleteStudent(Long id);

    List<Students> patchStudent(Long id, Students student);

    Students getStudent(Long id);
}
