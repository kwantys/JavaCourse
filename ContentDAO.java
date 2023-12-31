/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package sumdu.edu.dao;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import sumdu.edu.model.Content;
import sumdu.edu.model.Student;

/**
 *
 * @author lenovo
 */
@Repository
public interface ContentDAO extends JpaRepository<Student, Integer>{
    @Query("from Content where stud_id= :id")
    List<Content> getScoresByStId(@Param("id") int id);
}
