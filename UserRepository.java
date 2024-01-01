/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package sumdu.edu.security;
import org.springframework.data.jpa.repository.JpaRepository;
import sumdu.edu.model.User;
/**
 *
 * @author lenovo
 */
public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String username);
}
