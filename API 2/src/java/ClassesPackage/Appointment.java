/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ClassesPackage;

import ModelsPackage.AppointmentModel;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Date;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Appointment {
    
    private Connection conn;
    private Statement statement;

    public Appointment() {
        conn = DbConnection.getConnection();
    }

    public List<AppointmentModel> getAllAppointmentsForId(int personId) throws SQLException {
        try{
            statement = conn.createStatement();
            String query = "select * from patients p\n" +
"join appointments a on p.patient_cpr = a.Patient_cpr\n" +
"join hospitals h on a.hospital_id =h.Hospital_id where p.Patient_cpr = '"+personId+"'";
            ResultSet set = statement.executeQuery(query);
            List<AppointmentModel> allAppointments = new ArrayList<>();
            while(set.next()){
                int id = Integer.parseInt(set.getString("Patient_cpr"));
                //Date dato = Date.valueOf(set.getString("Date"));
                Timestamp dato = set.getTimestamp("Date");
                int varighed = Integer.parseInt(set.getString("Type_duration"));
                String type = set.getString("Agreement_type");
                long patientCpr = Integer.parseInt(set.getString("Patient_cpr"));
                String First_name = set.getString("First_name");
                String Last_name = set.getString("Sur_name");
                int sygehusID = Integer.parseInt(set.getString("Hospital_id"));
                //AppointmentModel appointment = new AppointmentModel(id, dato, varighed, type, sygehusID, personId);
                AppointmentModel appointment = new AppointmentModel(id, type, dato, patientCpr, First_name, Last_name);
                allAppointments.add(appointment);
            }
            return allAppointments;
        }catch(Exception ex){
            
            return null;
        }
            
        
    }
    
}
