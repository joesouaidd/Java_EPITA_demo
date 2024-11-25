package main.datamodel;

import java.sql.Date;

public class Patient {

    private String patientNb;
    private String pat_lastname;
    private String pat_firstname;
    private String pat_address;
    private String pat_tel;
    private int pat_insurance_id;
    private Date pat_sub_date;



    public String getPatientNb() {
        return this.patientNb;
    }

    public String getPat_lastname() {
        return this.pat_lastname;
    }
    public String getPat_firstname() {
        return this.pat_firstname;
    }
    public String getPat_address() {
        return this.pat_address;
    }

    public String getPat_tel() {
        return this.pat_tel;
    }

    public int getPat_insurance_id() {
        return this.pat_insurance_id;
    }

    public Date getPat_sub_date() {
        return this.pat_sub_date;
    }

    public void setPatientNb(String patientNb) {
        this.patientNb = patientNb;
    }

    public void setPat_lastname(String pat_lastname) {
        this.pat_lastname = pat_lastname;
    }

    public void setPat_firstname(String pat_firstname) {
        this.pat_firstname = pat_firstname;
    }

    public void setPat_address(String pat_address) {
        this.pat_address = pat_address;
    }

    public void setPat_tel(String pat_tel) {
        this.pat_tel = pat_tel;
    }

    public void setPat_insurance_id(int pat_insurance_id) {
        this.pat_insurance_id = pat_insurance_id;
    }

    public void setPat_sub_date(Date pat_sub_date) {
        this.pat_sub_date = pat_sub_date;
    }
}
