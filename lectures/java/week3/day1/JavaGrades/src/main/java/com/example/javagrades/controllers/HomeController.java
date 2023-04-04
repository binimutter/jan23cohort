package com.example.javagrades.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

import com.example.javagrades.models.Bio;
import com.example.javagrades.models.Student;
import com.example.javagrades.services.BioServ;
import com.example.javagrades.services.GradeServ;
import com.example.javagrades.services.StudentServ;

@Controller
public class HomeController {
	
//	Get from service exports to the browser

	@Autowired
	private StudentServ studentServ;
	
	@Autowired
	private BioServ bioServ;
	
	@Autowired
	private GradeServ gradeServ;
	
//	GetMapping  - landing page (/)
	@GetMapping("/")
	public String index(@ModelAttribute("student") Student student, Model model) {
		model.addAttribute("allStudents", studentServ.getAll());
		
		return "index.jsp";
	}
//	GetMapping  -  add student page (/addStudent)
	@GetMapping("/addStudent")
	public String addStudent(@ModelAttribute("studentForm") Student student) {
		
		return "addStudent.jsp";
	}
	
//	GetMapping  - add Bio page (/addBio)
	@GetMapping("/student/{student_id}/addBio")
	public String addBio(@ModelAttribute("bioForm") Bio bio, @PathVariable Long student_id, Model model) {
		
		Student oneStudent = studentServ.getOne(student_id);
		model.addAttribute("student", oneStudent);
		
		return "addBio.jsp";
	}
	
	
//	GetMapping - add Grade page (/addGrade)
	
	
	
	
	
//	GetMapping - edit student page (/student/{id}/edit)
	@GetMapping("/student/{id}/edit")
	public String editStudent(@PathVariable("id") Long id, @ModelAttribute("studentEditForm") Student s, Model model) {
		
		model.addAttribute("s", studentServ.getOne(id));
		
		return "editStudent.jsp";
	}
	
	
//	GetMapping - edit bio page (/bio/{id}/edit)
	
//	GetMapping - edit grade page (/grade/{id}/edit)
	
//	PostMapping - createStudent (createStudent)
	@PostMapping("/createStudent")
	public String createStudent(@Valid @ModelAttribute("studentForm") Student newStudent, BindingResult result, Model model) {
		
		if(result.hasErrors()) {
			return "addStudent.jsp";
		} else {
			studentServ.createOne(newStudent);
			return "redirect:/";
		}
	}
	
//	PostMapping - createBio (/createBio)
	@PostMapping("/student/{student_id}/createBio")
	public String createBio(@PathVariable("student_id") Long id, @Valid @ModelAttribute("bioForm") Bio newBio, BindingResult result, Model model) {
		
		if(result.hasErrors()) {
			model.addAttribute("s", studentServ.getOne(id));
			return "addBio.jsp";
		} else {
			bioServ.createOne(newBio);
			return "redirect:/";
		}
	}
	
//	PostMapping - createGrade (/createGrade)
	
	
//	PutMapping - updateStudent (/student/{id}/update)
	@PutMapping("/student/{id}/update")
	public String updateStudent(@PathVariable("id") Long id, @Valid @ModelAttribute("studentEditForm") Student s, BindingResult result, Model model) {
		
		if(result.hasErrors()) {
			model.addAttribute("s", studentServ.getOne(id));
			return "editStudent.jsp";
		} else {
			studentServ.updateOne(s);
			return "redirect:/";
		}
	}
	
//	GetMapping / DeleteMapping - remove Student (/student/{id}/delete)
}

