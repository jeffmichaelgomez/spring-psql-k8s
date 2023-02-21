package com.mis.studentdata.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.mis.studentdata.entities.Students;
import com.mis.studentdata.repository.StudentRepo;

@Component
public class StudentServiceImpl implements StudentService {
    
	@Autowired
	StudentRepo repo;
	
    @Override
    public List<Students> getStudents() {
    	return repo.findAll();
    }

    @Override
    public List<Students> addStudent(Students student) {
    	repo.save(student);
    	return getStudents();
        		
    }
    
    @Override
    public List<Students> updateStudent(Long id, Students updatedStudent) {
        Students student = repo.findById(id).orElse(null);
        if (student != null) {
            student.setName(updatedStudent.getName());
            student.setEmail(updatedStudent.getEmail());
            repo.save(student);
        }
        return getStudents();
    }
    
    @Override
    public List<Students> deleteStudent(Long id) {
        repo.deleteById(id);
        return getStudents();
    }
    
    @Override
    public List<Students> patchStudent(Long id, Students updatedStudent) {
        Students student = repo.findById(id).orElse(null);
        if (student != null) {
            if (updatedStudent.getName() != null) {
                student.setName(updatedStudent.getName());
            }
            if (updatedStudent.getEmail() != null) {
                student.setEmail(updatedStudent.getEmail());
            }
            repo.save(student);
        }
        return getStudents();
    }
    
    @Override
    public Students getStudent(Long id) {
        return repo.findById(id).orElse(null);
    }

}
