public class Employee {
    private int id;
    private static int nextid = 1;
    private String name;
    private String surname;
    private double salary;

    public Employee(String name, String surname, double salary) throws FieldLengthLimitException, IncorrectSalaryException {
        this.id = nextid++;
        if (name.length() > 15) {
            throw new FieldLengthLimitException("Too much symbols in name!");
        } else {
            this.name = name;
        }
        if(surname.length() > 20){
            throw new FieldLengthLimitException("Too much sumbols is surname");
        }else {
            this.surname = surname;
        }
        if(salary < 0){
            throw new IncorrectSalaryException("Salary cannot be less than 0");
        }else {
            this.salary = salary;
        }
    }

    void infoAboutPerson(){
        System.out.print("Name: " + name + " Surname: " + surname + " Salary: " + salary);
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public double getSalary() {
        return salary;
    }
}
