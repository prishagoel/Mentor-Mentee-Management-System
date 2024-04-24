package com.mentorship.mentorshipmanagementsystem.service;

import java.util.List;

import com.mentorship.mentorshipmanagementsystem.domain.Student;

public interface ReadableStudentService {

    List<Student> getAllStudents();

    Student getStudentById(Long id);
}
