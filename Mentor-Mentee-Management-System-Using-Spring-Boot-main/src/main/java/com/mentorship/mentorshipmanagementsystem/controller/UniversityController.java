package com.mentorship.mentorshipmanagementsystem.controller;

import com.mentorship.mentorshipmanagementsystem.domain.Meeting;
import com.mentorship.mentorshipmanagementsystem.domain.Student;
import com.mentorship.mentorshipmanagementsystem.service.ReadableStudentService;
import com.mentorship.mentorshipmanagementsystem.service.WritableStudentService;
import com.mentorship.mentorshipmanagementsystem.service.MeetingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class UniversityController {

    private final ReadableStudentService readableStudentService;
    private final WritableStudentService writableStudentService;
    private final MeetingService meetingService;

    @Autowired
    public UniversityController(ReadableStudentService readableStudentService,
                                WritableStudentService writableStudentService,
                                MeetingService meetingService) {
        this.readableStudentService = readableStudentService;
        this.writableStudentService = writableStudentService;
        this.meetingService = meetingService;
    }

    @GetMapping("/")
    public String viewHomePage(Model model) {
        model.addAttribute("listStudents", readableStudentService.getAllStudents());
        return "home";
    }

    @GetMapping("/home")
    public String homePage() {
        return "home";
    }

    @GetMapping("/students")
    public String viewStudents(Model model) {
        List<Student> students = readableStudentService.getAllStudents();
        model.addAttribute("listStudents", students);
        return "students"; 
    }

    @GetMapping("/showNewStudentForm")
    public String showNewStudentForm(Model model) {
        Student student = new Student();
        model.addAttribute("student", student);
        return "new_student";
    }

    @PostMapping("/saveStudent")
    public String saveStudent(@ModelAttribute("student") Student student) {
        writableStudentService.saveStudent(student);
        return "redirect:/";
    }

    @GetMapping("/showFormForUpdate/{id}")
    public String showUpdateForm(@PathVariable Long id, Model model) {
        Student student = readableStudentService.getStudentById(id);
        model.addAttribute("student", student);
        return "update_student";
    }

    @GetMapping("/delete/{id}")
    public String deleteStudentById(@PathVariable Long id, Model model) {
        writableStudentService.deleteStudentById(id);
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
