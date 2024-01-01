/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package sumdu.edu.repo;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

import sumdu.edu.model.Student;
/**
 *
 * @author lenovo
 */
@Repository
public interface StudentRepo extends JpaRepository<Student, Integer> {
    
}
