import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class EmployeeTest {

    @Test
    public void testValidEmployeeCreation() {
        try {
            Employee employee = new Employee("John", "Doe", 50000.0);
            assertEquals("John", employee.getName());
            assertEquals("Doe", employee.getSurname());
            assertEquals(50000.0, employee.getSalary(), 0.01);
        } catch (Exception e) {
            fail("Exception should not have been thrown: " + e.getMessage());
        }
    }

    @Test
    public void testInvalidName() {
        assertThrows(FieldLengthLimitException.class, () -> {
            new Employee("", "Doe", 50000.0);
        });
    }

    @Test
    public void testInvalidSurname() {
        assertThrows(FieldLengthLimitException.class, () -> {
            new Employee("John", "", 50000.0);
        });
    }

    @Test
    public void testInvalidSalary() {
        assertThrows(IncorrectSalaryException.class, () -> {
            new Employee("John", "Doe", -50000.0);
        });
    }
}

