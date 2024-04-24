package com.mentorship.mentorshipmanagementsystem.service;

import com.mentorship.mentorshipmanagementsystem.domain.Student;
import com.mentorship.mentorshipmanagementsystem.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class WritableStudentProxy implements WritableStudentService {

    private final StudentRepository studentRepository;

    @Autowired
    public WritableStudentProxy(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @Override
    public void saveStudent(Student student) {
        studentRepository.save(student);
    }

    @Override
    public void deleteStudentById(Long id) {
        studentRepository.deleteById(id);
    }
}
