package empmgmt.dao;

import empmgmt.dbutil.DBConnection;
import empmgmt.pojo.EmpPojo;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class EmpDao {
    public static boolean addEmployee(EmpPojo e) throws SQLException{
        PreparedStatement ps=DBConnection.getConnection().prepareStatement("insert into emp values(?,?,?)");
        ps.setInt(1, e.getEmpno());
        ps.setString(2, e.getEname());
        ps.setDouble(3, e.getSal());
        int a=ps.executeUpdate();
        return (a==1);
    }
    public static EmpPojo findEmployeeById(int empno)throws SQLException{
        PreparedStatement ps=DBConnection.getConnection().prepareStatement("select * from emp where empno=(?)");
        ps.setInt(1,empno);
        ResultSet rs=ps.executeQuery();
        EmpPojo emp=new EmpPojo();
        while(rs.next()){
            if(rs.getInt("empno")==empno){
                emp.setEmpno(rs.getInt("empno"));
                emp.setEname(rs.getString("ename"));
                emp.setSal(rs.getDouble("sal"));
                return emp;
            }
        }
        return null;
    }
    public static ResultSet showAllEmployees() throws SQLException{
        Statement st=DBConnection.getConnection().createStatement();
        ResultSet rs=st.executeQuery("select * from emp");
        return rs;
    }
}
