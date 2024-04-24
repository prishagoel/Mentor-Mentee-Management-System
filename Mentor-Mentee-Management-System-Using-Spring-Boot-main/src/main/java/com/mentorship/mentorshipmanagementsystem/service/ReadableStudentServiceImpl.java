package com.mentorship.mentorshipmanagementsystem.service;

import com.mentorship.mentorshipmanagementsystem.domain.Student;
import com.mentorship.mentorshipmanagementsystem.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReadableStudentServiceImpl implements ReadableStudentService {

    private static ReadableStudentServiceImpl instance;

    private final StudentRepository studentRepository;

    @Autowired
    private ReadableStudentServiceImpl(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public static ReadableStudentServiceImpl getInstance(StudentRepository studentRepository) {
        if (instance == null) {
            instance = new ReadableStudentServiceImpl(studentRepository);
        }
        return instance;
    }

    @Override
    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    @Override
    public Student getStudentById(Long id) {
        return studentRepository.findById(id).orElse(null);
    }
}
