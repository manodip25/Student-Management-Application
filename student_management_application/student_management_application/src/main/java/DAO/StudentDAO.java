
package DAO;
import entities.Student;
import helper.ConnectionProvider;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;


public class StudentDAO {
    public static boolean addStudent(Student ob)
    {
        boolean f=false;
        try
        {
            Connection con=ConnectionProvider.getConnection();
            
            String sql="INSERT INTO studentt(S_NAME,S_DEPT, S_PASSINGYEAR ,S_ADDRESS,S_DOB) VALUES(?,?,?,?,?)";
            PreparedStatement pstmt=con.prepareStatement(sql);
            pstmt.setString(1, ob.getS_name());
            pstmt.setString(2, ob.getS_dept());
            pstmt.setString(3, ob.getS_passingYear());
            pstmt.setString(4, ob.getS_address());
            pstmt.setString(5, ob.getS_dob());
            
            pstmt.executeUpdate();
            
            f=true;
            
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    
    return f;
}
    public static boolean removeStudent(int id)
    {
        boolean f = false;
        try
        {
            Connection con=ConnectionProvider.getConnection();
            
            String sql="DELETE FROM studentt WHERE S_ID = ?";
            PreparedStatement pstmt=con.prepareStatement(sql);
            pstmt.setInt(1, id);
            
            pstmt.executeUpdate();
            
            f=true;
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        return f;
    }
    
    public static Student findStudent(int id)
    {
        Student s = null;
        
        try
        {
            Connection con = ConnectionProvider.getConnection();
            String sql = "SELECT * FROM studentt WHERE S_ID = "+id;
            PreparedStatement pstmt = con.prepareStatement(sql);
           // pstmt.setInt(1, id);
            
           ResultSet set = pstmt.executeQuery();
           
           if(set.next())
           {
               int s_id=set.getInt(1);
               String s_name = set.getString(2);
               String s_dept = set.getString(3);
               String s_passingYear = set.getString(4);
               String s_address= set.getString(5);
               String s_dob = set.getString(6);
               
               s = new Student(s_id,s_name,s_dept,s_passingYear,s_address,s_dob);
           }
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        return s;
    }
    public static ArrayList<Student> displayAllStudents()
    {
        ArrayList students = new ArrayList<>();
        try
        {
            Connection con = ConnectionProvider.getConnection();
            String query = "SELECT * FROM studentt";
            Statement stmt=con.prepareStatement(query);
            
            ResultSet set = stmt.executeQuery(query);
            Student s = null;
            while(set.next())
            {
                int s_id=set.getInt(1);
               String s_name = set.getString(2);
               String s_dept = set.getString(3);
               String s_passingYear = set.getString(4);
               String s_address= set.getString(5);
               String s_dob = set.getString(6);
               
               s = new Student(s_id,s_name,s_dept,s_passingYear,s_address,s_dob);
               
               students.add(s);
            }
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        return students;
    }
    public static boolean updateStudent(int op,int id,String updateVal){
        
        boolean f=false;
        try{
            Connection con=ConnectionProvider.getConnection();
        if(op==1)
        {
            String sql="UPDATE studentt SET S_NAME = ? WHERE S_ID = ?";
            
            PreparedStatement pstmt =con.prepareStatement(sql);
            pstmt.setString(1, updateVal);
            pstmt.setInt(2, id);
            pstmt.executeUpdate();
            
            f=true;
        }
        else if(op==2)
        {
            String sql="UPDATE studentt SET S_DEPT = ? WHERE S_ID = ?";
            
            PreparedStatement pstmt =con.prepareStatement(sql);
            pstmt.setString(1, updateVal);
            pstmt.setInt(2, id);
            pstmt.executeUpdate();
            
            f=true;
            
        }
        else if(op==3)
        {
            String sql="UPDATE studentt SET S_PASSINGYEAR = ? WHERE S_ID = ?";
            
            PreparedStatement pstmt =con.prepareStatement(sql);
            pstmt.setString(1, updateVal);
            pstmt.setInt(2, id);
            pstmt.executeUpdate();
            
            f=true;
        }
        else if(op==4)
        {
            String sql="UPDATE studentt SET S_ADDRESS = ? WHERE S_ID = ?";
            
            PreparedStatement pstmt =con.prepareStatement(sql);
            pstmt.setString(1, updateVal);
            pstmt.setInt(2, id);
            pstmt.executeUpdate();
            
            f=true;
        }
        else if(op==5)
        {
            String sql="UPDATE studentt SET S_DOB = ? WHERE S_ID = ?";
            
            PreparedStatement pstmt =con.prepareStatement(sql);
            pstmt.setString(1, updateVal);
            pstmt.setInt(2, id);
            pstmt.executeUpdate();
            
            f=true;
        }
        }
        catch(Exception e){
            e.printStackTrace();
        }
        return f;
    }
    
}
