/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sumdu.edu.controller;

import java.util.LinkedList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import sumdu.edu.dao.StudentDAO;
import sumdu.edu.model.Student;

/**
 *
 * @author lenovo
 */
public class StudentController {
    List<Student> students;
    ApplicationContext factory;
    
    @Autowired
    StudentDAO dao;
    
   
        @ModelAttribute
        public void modelData(Model m){
            if(students==null){ students = new LinkedList<Student>();}
            factory = new ClassPathXmlApplicationContext("/spring.xml");
        }
    
        
        @GetMapping("/")
	public String home(Model m) {
                m.addAttribute("students", dao.findAll());
		return "student";
	}
        
        @RequestMapping(value = "/StudentAdd")
        public String addStudent(HttpServletRequest request,Model m){
            
            System.out.println("accesed by "+ request.getParameter("name")+" token:"+request.getParameter("_csrf"));
        if (request.getParameter("name") != "" && request.getParameter("surname") != "") {
        Student student = (Student)factory.getBean("Student");
        
            student.setName(request.getParameter("name"));
            student.setSurname(request.getParameter("surname"));
            student.setEmail(request.getParameter("email"));
            student.setGroup(request.getParameter("group"));
            student.setFaculty(request.getParameter("faculty"));
        
        dao.save(student);
        }
        students=dao.findAll();
    
        m.addAttribute("students", students);
        return "student";
    }
}
