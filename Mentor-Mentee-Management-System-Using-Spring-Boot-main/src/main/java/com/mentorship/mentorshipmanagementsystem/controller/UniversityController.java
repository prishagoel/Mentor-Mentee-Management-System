package com.mentorship.mentorshipmanagementsystem.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.mentorship.mentorshipmanagementsystem.domain.Meeting;
import com.mentorship.mentorshipmanagementsystem.domain.Student;
import com.mentorship.mentorshipmanagementsystem.service.MeetingService;
import com.mentorship.mentorshipmanagementsystem.service.StudentService;

import java.util.List;


@Controller
public class UniversityController {

    @Autowired
    private StudentService studentService;

    @Autowired
    private MeetingService meetingService;

    @GetMapping("/")
    public String viewHomePage(Model model) {
        model.addAttribute("listStudents", studentService.getAllStudents());
        return "home"; 
    }

    @GetMapping("/home")
    public String homePage() {
        return "home";
    }

    @GetMapping("/students")
    public String viewStudents(Model model) {
        List<Student> students = studentService.getAllStudents();
        model.addAttribute("listStudents", students);
        return "students"; // This should match the name of your Thymeleaf template file (students.html)
    }

    @GetMapping("/showNewStudentForm")
    public String showNewStudentForm(Model model) {
        Student student = new Student();
        model.addAttribute("student", student);
        return "new_student";
    }

    @PostMapping("/saveStudent")
    public String saveStudent(@ModelAttribute("student") Student student) {
        studentService.saveStudent(student);
        return "redirect:/";
    }

    @GetMapping("/showFormForUpdate/{id}")
    public String showUpdateForm(@PathVariable Long id, Model model) {
        Student student = studentService.getStudentById(id);
        model.addAttribute("student", student);
        return "update_student";
    }

    @GetMapping("/delete/{id}")
    public String deleteStudentById(@PathVariable Long id, Model model) {
        studentService.deleteStudentById(id);
        return "redirect:/students";
    }

    @GetMapping("/set_meeting")
    public String showSetMeetingForm(Model model) {
        model.addAttribute("meeting", new Meeting());
        return "set_meeting";
    }

    @PostMapping("/saveMeeting")
    public String saveMeeting(@ModelAttribute("meeting") Meeting meeting, Model model) {
        meetingService.saveMeeting(meeting);
        model.addAttribute("message", "Meeting successfully scheduled!");
        return "redirect:/set_meeting";
    }

    @GetMapping("/view_meetings")
    public String viewMeetings(Model model) {
        List<Meeting> meetings = meetingService.getAllMeetings();
        model.addAttribute("meetings", meetings);
        return "view_meetings";
    }

}
