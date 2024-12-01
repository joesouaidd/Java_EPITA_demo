package main.services;

import main.datamodel.Patient;

import java.sql.*;

public class PatientDAO {

    private static Connection getConnection() throws SQLException {
        return DriverManager.getConnection("jdbc:h2:mem:test;DB_CLOSE_DELAY=-1", "test", "test");
    }

    public void createTable(){
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
        }catch (SQLException sqle){
            sqle.printStackTrace();
        }
    }
    public void createPatient(Patient patient) {
        try (Connection connection = getConnection()) {
            PreparedStatement insertStatement = connection.prepareStatement("INSERT INTO PATIENTS (pat_num_HC, pat_lastname, pat_firstname, pat_address, pat_tel, pat_insurance_id, pat_subscription_date) VALUES (?, ?, ?, ?, ?, ?, ?)");
            insertStatement.setString(1, patient.getPatientNb());
            insertStatement.setString(2, patient.getPat_lastname());
            insertStatement.setString(3, patient.getPat_firstname());
            insertStatement.setString(4, patient.getPat_address());
            insertStatement.setString(5, patient.getPat_tel());
            insertStatement.setInt(6, patient.getPat_insurance_id());
            insertStatement.setDate(7, new java.sql.Date(patient.getPat_sub_date().getTime()));
            insertStatement.execute();
        } catch (SQLException e) {
            e.printStackTrace();

        }
    }

    public void deletePatient(String patientNb) {
    try (Connection connection = getConnection()) {
        PreparedStatement deleteStatement = connection.prepareStatement("DELETE FROM PATIENTS WHERE pat_num_HC = ?");
        deleteStatement.setString(1, patientNb);
        deleteStatement.execute();
    } catch (SQLException e) {
        e.printStackTrace();
    }
}

    public Patient getPatientByNumber(String patientNb) {
    Patient patient = null;
    try (Connection connection = getConnection()) {
        PreparedStatement selectStatement = connection.prepareStatement("SELECT * FROM PATIENTS WHERE pat_num_HC = ?");
        selectStatement.setString(1, patientNb);
        ResultSet resultSet = selectStatement.executeQuery();
        if (resultSet.next()) {
            patient = new Patient();
            patient.setPatientNb(resultSet.getString("pat_num_HC"));
            patient.setPat_lastname(resultSet.getString("pat_lastname"));
            patient.setPat_firstname(resultSet.getString("pat_firstname"));
            patient.setPat_address(resultSet.getString("pat_address"));
            patient.setPat_tel(resultSet.getString("pat_tel"));
            patient.setPat_insurance_id(resultSet.getInt("pat_insurance_id"));
            patient.setPat_sub_date(resultSet.getDate("pat_subscription_date"));
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }
    return patient;
}

    public Patient getPatientByName(String firstName, String lastName) {
        Patient patient = null;
        try (Connection connection = getConnection()) {
            PreparedStatement selectStatement = connection.prepareStatement("SELECT * FROM PATIENTS WHERE pat_firstname = ? AND pat_lastname = ?");
            selectStatement.setString(1, firstName);
            selectStatement.setString(2, lastName);
            ResultSet resultSet = selectStatement.executeQuery();
            if (resultSet.next()) {
                patient = new Patient();
                patient.setPatientNb(resultSet.getString("pat_num_HC"));
                patient.setPat_lastname(resultSet.getString("pat_lastname"));
                patient.setPat_firstname(resultSet.getString("pat_firstname"));
                patient.setPat_address(resultSet.getString("pat_address"));
                patient.setPat_tel(resultSet.getString("pat_tel"));
                patient.setPat_insurance_id(resultSet.getInt("pat_insurance_id"));
                patient.setPat_sub_date(resultSet.getDate("pat_subscription_date"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return patient;
    }

    public void updatePatient(Patient patient) {
        String sql = "UPDATE PATIENTS SET pat_lastname = ?, pat_firstname = ?, pat_address = ?, pat_tel = ?, pat_insurance_id = ?, pat_subscription_date = ? WHERE pat_num_HC = ?";
        try (Connection connection = getConnection()) {
            PreparedStatement updateStatement = connection.prepareStatement(sql);
            updateStatement.setString(1, patient.getPat_lastname());
            updateStatement.setString(2, patient.getPat_firstname());
            updateStatement.setString(3, patient.getPat_address());
            updateStatement.setString(4, patient.getPat_tel());
            updateStatement.setInt(5, patient.getPat_insurance_id());
            updateStatement.setDate(6, new java.sql.Date(patient.getPat_sub_date().getTime()));
            updateStatement.setString(7, patient.getPatientNb());
            updateStatement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }



}