package sumdu.edu.ua.;

import javax.swing.plaf.nimbus.State;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DAO {
    private static final String DB_URL = "jdbc:mysql://localhost:3311/university";
    private static final String DB_USER = "root";
    private static final String DB_PASSWORD = "root";
    private static Connection connection;
    static {
        try{
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e){
            e.printStackTrace();
        }
        try {
            connection = DriverManager.getConnection(DB_URL,DB_USER,DB_PASSWORD);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public List<Student> GetStudents() throws SQLException {
        List<Student> students = new ArrayList<>();
        Statement statement = connection.createStatement();
        String SQL = "SELECT * FROM Student";
        ResultSet resultSet = statement.executeQuery(SQL);
        while(resultSet.next()){
            Student student = new Student();
            student.setId(resultSet.getInt("id"));
            student.setName(resultSet.getString("name"));
            student.setEmail(resultSet.getString("email"));
            student.setSurname(resultSet.getString("surname"));
            student.setGroup(resultSet.getString("group_"));
            student.setFaculty(resultSet.getString("faculty"));
            students.add(student);
        }
        return students;
    }
    public void AddStudent(Student student) throws SQLException {
        PreparedStatement preparedStatement =
                connection.prepareStatement("INSERT INTO student VALUES (?,?,?,?,?)");
        preparedStatement.setString(1,student.getName());
        preparedStatement.setString(2,student.getSurname());
        preparedStatement.setString(3,student.getEmail());
        preparedStatement.setString(4,student.getGroup());
        preparedStatement.setString(5,student.getFaculty());
        preparedStatement.executeUpdate();
    }
    public Student FindStudent(Integer id) throws SQLException {
        PreparedStatement preparedStatement =
                connection.prepareStatement("SELECT * from student where id = ?");
        preparedStatement.setInt(1,id);
        ResultSet resultSet = preparedStatement.executeQuery();
        Student student = new Student();
        while(resultSet.next()){

            student.setId(resultSet.getInt("id"));
            student.setName(resultSet.getString("name"));
            student.setEmail(resultSet.getString("email"));
            student.setSurname(resultSet.getString("surname"));
            student.setGroup(resultSet.getString("group_"));
            student.setFaculty(resultSet.getString("faculty"));
        }
        return student;
    }
    public List<Grade> FindMarks(Integer id) throws SQLException {
        PreparedStatement preparedStatement =
                connection.prepareStatement("SELECT * from grades where student_id = ?");
        preparedStatement.setInt(1,id);
        ResultSet resultSet = preparedStatement.executeQuery();
        Grade grade = new Grade();
        List<Grade> grades = new ArrayList<>();
        while(resultSet.next()){
            grade.setId(resultSet.getInt("id"));
            grade.setStudent(resultSet.getInt("student_id"));
            grade.setDiscipline(resultSet.getString("discipline"));
            grade.setEcts(resultSet.getString("ects_score"));
            grade.setRegular(resultSet.getInt("regular_score"));
            grades.add(grade);
        }

        return grades;
    }
}

