/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package sumdu.edu.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import sumdu.edu.model.Student;


/**
 *
 * @author lenovo
 */
public interface StudentDAO extends JpaRepository<Student, Integer>{
    Student addStudent(Student student);

    List<Student> getAllStudents();

    Student getStudentById(Integer studentId);

    Student updateStudent(Student student);

    void deleteStudent(Integer studentId);

    public Student getOne(int parseInt);
}
