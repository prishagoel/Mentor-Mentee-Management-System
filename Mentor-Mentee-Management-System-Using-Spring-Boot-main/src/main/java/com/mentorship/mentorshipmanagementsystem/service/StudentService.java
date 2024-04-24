package com.mentorship.mentorshipmanagementsystem.service;

import java.util.List;

import com.mentorship.mentorshipmanagementsystem.domain.Student;

public interface StudentService {

    List<Student> getAllStudents();

    Student getStudentById(Long id);

    void saveStudent(Student student);

    void deleteStudentById(Long id);
}
