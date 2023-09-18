public class Main {
    public static void main(String[] args) throws FieldLengthLimitException, IncorrectSalaryException {

        try{
            Employee emp=new Employee("Bilbo", "Baggins", 5500);
            emp.infoAboutPerson();
        }catch(FieldLengthLimitException ex){
            System.out.println(ex.getMessage());
        }catch (IncorrectSalaryException ex1){
            System.out.println(ex1.getMessage());
        }
    }
}