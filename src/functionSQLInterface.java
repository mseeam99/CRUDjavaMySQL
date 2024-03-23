
public interface functionSQLInterface {

    //create employee
    public void createEmployee(Employee employee);
    //show all employee
    public void showAllEmployee();
    //show employee based on id

    public void updateEmployee(int id,String name);
    //delete employee
    public void deleteEmployee(int id);

    public void clearTable();
}