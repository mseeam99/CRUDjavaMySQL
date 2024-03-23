import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class functionSQLImplementation implements functionSQLInterface{
    Connection connection;
    @Override
    public void createEmployee(Employee employee) {
        connection = DatabaseConnection.createDBConnection();
        String query = "INSERT INTO employee VALUES(?,?,?,?)";
        try {
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setInt(2,employee.getId());
            statement.setString(1,employee.getName());
            statement.setDouble(3,employee.getSalary());
            statement.setInt(4,employee.getAge());
            // Corrected the parameter index
            int cnt = statement.executeUpdate();
            if (cnt != 0)
                System.out.println("Employee Inserted Successfully !!!");
        } catch (Exception ex) {
            ex.printStackTrace();
        }

    }

    @Override
    public void showAllEmployee() {
        connection=DatabaseConnection.createDBConnection();
        String query="SELECT * FROM employee";
        System.out.println("Employee Details :");
        System.out.println("---------------------------------------------");
        System.out.format("%s\t%s\t%s\t%s\n","ID","Name","Salary","Age");
        System.out.println("---------------------------------------------");

        try{
            Statement statement = connection.createStatement();
            ResultSet result= statement.executeQuery(query);
            while (result.next()){
                System.out.format("%d\t%s\t%f\t%d\n",
                        result.getInt(2),
                        result.getString(1),
                        result.getDouble(3),
                        result.getInt(4));
                System.out.println("---------------------------------------------");
            }
        }catch (Exception ex){
            ex.printStackTrace();
        }
    }



    @Override
    public void updateEmployee(int id, String name) {
        connection = DatabaseConnection.createDBConnection();
        String query = "UPDATE employee SET name=? WHERE id=?";
        try{
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1,name);
            statement.setInt(2,id);
            int cnt = statement.executeUpdate();
            if(cnt!=0)
                System.out.println("Employee Details updated successfully !!");
        }catch (Exception ex){
            ex.printStackTrace();
        }

    }

    @Override
    public void deleteEmployee(int id) {
        connection = DatabaseConnection.createDBConnection();
        String query="DELETE FROM employee WHERE id=?";
        try{
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setInt(1,id);
            int cnt = statement.executeUpdate();
            if(cnt!=0)
                System.out.println("Employee Deleted Successfully!!! "+id);
        }catch (Exception ex){
            ex.printStackTrace();
        }

    }


    @Override
    public void clearTable() {
        connection = DatabaseConnection.createDBConnection();
        String query = "DELETE FROM employee";
        try {
            PreparedStatement statement = connection.prepareStatement(query);
            int cnt = statement.executeUpdate();
            System.out.println(cnt + " rows deleted from the employee table.");
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            // Close resources
            try {
                if (connection != null)
                    connection.close();
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
    }
}