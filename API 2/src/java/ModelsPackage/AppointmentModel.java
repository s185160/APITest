/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ModelsPackage;
    
import java.sql.Timestamp;
import java.util.Date;

public class AppointmentModel {
//    private int id;
//    private Timestamp dato;
//    private int varighed;
//    private String type;
//    private int personID;
//    private int sygehusID;
//
//    public AppointmentModel(){}
//
//    public AppointmentModel(int id, Timestamp dato, int varighed, String type, int personID, int sygehusID) {
//        this.id = id;
//        this.dato = dato;
//        this.varighed = varighed;
//        this.type = type;
//        this.personID = personID;
//        this.sygehusID = sygehusID;
//    }
//
//    public int getId() {
//        return id;
//    }
//
//    public void setId(int id) {
//        this.id = id;
//    }
//
//    public Date getDato() {
//        return dato;
//    }
//
//    public void setDato(Timestamp dato) {
//        this.dato = dato;
//    }
//
//    public int getVarighed() {
//        return varighed;
//    }
//
//    public void setVarighed(int varighed) {
//        this.varighed = varighed;
//    }
//
//    public String getType() {
//        return type;
//    }
//
//    public void setType(String type) {
//        this.type = type;
//    }
//
//    public int getPersonID() {
//        return personID;
//    }
//
//    public void setPersonID(int personID) {
//        this.personID = personID;
//    }
//
//    public int getSygehusID() {
//        return sygehusID;
//    }
//
//    public void setSygehusID(int sygehusID) {
//        this.sygehusID = sygehusID;
//    }
    
    private long _id;
    private String _type;
    private Timestamp _date;
    private long _patientCpr;
    private String _patientFirstName;
    private String _patientLastName;
    
    public AppointmentModel(long id, String type, Timestamp date, long patientCpr, String patientFirst, String patientLast ){
        _id = id;
        _type = type;
        _date = date;
        _patientCpr = patientCpr;
        _patientFirstName = patientFirst;
        _patientLastName = patientLast;
    }
    
    public long getId(){
        return _id;
    }
    public void Id(long id){
        _id = id;
    }
    
    public String gettype(){
        return _type;
    }
    public void Type(String type){
        _type = type;
    }
    
    public Timestamp getDate(){
        return _date;
    }
    public void Date(Timestamp date){
        _date = date;
    }
    
    public long getCpr(){
        return _patientCpr;
    }
    public void Cpr(long cpr){
        _patientCpr = cpr;
    }
    
    public String getFirstName(){
        return _patientFirstName;
    }
    public void FirstName(String firstName){
        _patientFirstName = firstName;
    }
    
    public String getLastName(){
        return _patientLastName;
    }
    public void LastName(String lastName){
        _patientLastName = lastName;
    }
    
}
