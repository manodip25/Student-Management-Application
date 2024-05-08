
package entities;

public class Student 
{
    private int s_id;
    private String s_name;
    private String s_dept;
    private String s_passingYear;
    private String s_address;
    private String s_dob;

    public Student() {
    }

    public Student(String s_name, String s_dept, String s_passingYear, String s_address, String s_dob) {
        this.s_name = s_name;
        this.s_dept = s_dept;
        this.s_passingYear = s_passingYear;
        this.s_address = s_address;
        this.s_dob = s_dob;
    }

    public Student(int s_id, String s_name, String s_dept, String s_passingYear, String s_address, String s_dob) {
        this.s_id = s_id;
        this.s_name = s_name;
        this.s_dept = s_dept;
        this.s_passingYear = s_passingYear;
        this.s_address = s_address;
        this.s_dob = s_dob;
    }

    public int getS_id() {
        return s_id;
    }
    

    public String getS_name() {
        return s_name;
    }

    public void setS_name(String s_name) {
        this.s_name = s_name;
    }

    public String getS_dept() {
        return s_dept;
    }

    public void setS_dept(String s_dept) {
        this.s_dept = s_dept;
    }

    public String getS_passingYear() {
        return s_passingYear;
    }

    public void setS_passingYear(String s_passingYear) {
        this.s_passingYear = s_passingYear;
    }

    public String getS_address() {
        return s_address;
    }

    public void setS_address(String s_address) {
        this.s_address = s_address;
    }

    public String getS_dob() {
        return s_dob;
    }

    public void setS_dob(String s_dob) {
        this.s_dob = s_dob;
    }
    
    
    
    
}
