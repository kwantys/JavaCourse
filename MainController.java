package sumdu.edu.ua

import DAO;
import GradesServlet;
import Student;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;


@Controller
public class MainController {
    private final DAO studentDAO = new DAO();
    @GetMapping("/Mark")
    public String ShowMarks(@RequestParam(value = "id") Integer id , Model model) throws SQLException {
        List<Grade> grades = studentDAO.FindMarks(id);
        model.addAttribute("students" , studentDAO.FindStudent(id));
        model.addAttribute("Mark" , grades);
        return "marks.jsp";
    }
    @GetMapping("/StudentAdd")
    public String StudentAdd(){
        return "Student.jsp";
    }
    @PostMapping("/StudentAdd")
    public String StudentPost(@ModelAttribute("student")Student student , Model model) throws SQLException {
        studentDAO.AddStudent(student);
        List<Student> students = new LinkedList<Student>();
        students = studentDAO.GetStudents();
        model.addAttribute("students" , students);
        return "Student.jsp";
    }

}