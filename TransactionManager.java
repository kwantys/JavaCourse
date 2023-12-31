/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import sumdu.edu.dao.StudentDAO;
import sumdu.edu.model.Student;

/**
 *
 * @author lenovo
 */

@Service
@Transactional
public class TransactionManager {
     private final StudentDAO userRepository;

    @Autowired
    public TransactionManager(StudentDAO userRepository) {
        this.userRepository = userRepository;
    }

    // Додати користувача
    public Student addStudent(Student student) {
        return userRepository.save(student);
    }

    // Отримати всіх користувачів
    public List<Student> getAllStudent() {
        return userRepository.findAll();
    }

    // Отримати користувача за ідентифікатором
    public Student getStudentById(Long StudentId) {
        return userRepository.findById(StudentId).orElse(null);
    }

    // Оновити інформацію про користувача
    public Student updateStudent(Student student) {
        return userRepository.save(student);
    }

    // Видалити користувача за ідентифікатором
    public void deleteStudent(Long StudentId) {
        userRepository.deleteById(StudentId);
    }
}
