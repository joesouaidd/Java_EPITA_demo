package test;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import static java.sql.DriverManager.getConnection;

public class TestJDB1 {


    private static Connection getConnection() throws SQLException {
        return DriverManager.getConnection("jdbc:h2:mem:test;DB_CLOSE_DELAY=-1", "test", "test");
    }
    public static void test() {

            try (Connection connection = getConnection()){
                PreparedStatement createStatement = connection.prepareStatement("CREATE TABLE PATIENTS (" +
                        "pat_num_HC VARCHAR(255), " +
                        "pat_lastname VARCHAR (255)," +
                        "pat_firstname VARCHAR (255)," +
                        "pat_address VARCHAR (255)," +
                        "pat_tel VARCHAR (255)," +
                        "pat_insurance_id INT," +
                        "pat_subscription_date Date" +
                        ")");
                createStatement.execute();
                System.out.println("Table Created");
            }catch (SQLException sqle){
                sqle.printStackTrace();
            }




    }


    public static void main(String[] args) {
        TestJDB1.test();
    }

}
