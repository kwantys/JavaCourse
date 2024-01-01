/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package sumdu.edu.repo;

import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

import sumdu.edu.model.Content;
import sumdu.edu.model.Student;
/**
 *
 * @author lenovo
 */
@Repository
public interface ContentRepo extends JpaRepository<Student, Integer> {
    @Query("from Content where stud_id= :id")
    List<Content> getScoresByStId (@Param("id") int id);
}
