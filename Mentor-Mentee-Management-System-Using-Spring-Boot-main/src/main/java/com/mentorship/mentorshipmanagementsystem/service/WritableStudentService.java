package com.mentorship.mentorshipmanagementsystem.service;

import com.mentorship.mentorshipmanagementsystem.domain.Student;

public interface WritableStudentService {

    void saveStudent(Student student);

    void deleteStudentById(Long id);
}