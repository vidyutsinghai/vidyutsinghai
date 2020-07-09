package com.softvin.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.infoviaan.beans.Carrer;
import com.infoviaan.beans.Employee;

public class AdminModel {
	public Connection createConnection() {
		Connection con = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/softvinTechno", "root", "root");
		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		}
		return con;
	}

	public int checkLogin(String id, String pass) {
		int i = 0;
		Connection con = null;
		try {
			con = createConnection();
			PreparedStatement ps = con.prepareStatement("select * from admin where id = ? and PASSWORD = ?");
			ps.setString(1, id);
			ps.setString(2, pass);

			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				i = 1;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return i;
	}

	public int registerEmployee(Employee ee) {
		int i = 0;
		Connection con = null;
		try {
			con = createConnection();
			PreparedStatement ps = con.prepareStatement("insert into employee values(?,?,?,?,?,?,?)");
			ps.setString(1, ee.getEname());
			ps.setString(2, ee.getEdesignation());
			ps.setString(3, ee.getEmobile());
			ps.setString(4, ee.getEqualification());
			ps.setString(5, ee.getEgender());
			ps.setFloat(6, ee.getEsalary());
			ps.setString(7, ee.getEaddress());

			i = ps.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return i;
	}

	public ArrayList<Employee> getAllEmployee() {
		ArrayList<Employee> list = new ArrayList<>();
		Connection con = createConnection();
		try {
			PreparedStatement pst = con.prepareStatement("select * from employee");
			ResultSet rs = pst.executeQuery();
			Employee ee = null;
			while (rs.next()) {
				ee = new Employee(rs.getString("ename"), rs.getString("edesignation"), rs.getString("emobile"),
						rs.getString("equalification"), rs.getString("egender"), rs.getFloat("esalary"),
						rs.getString("eaddress"));
				list.add(ee);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

	public int deleteEmployee(String mobile) {
		int i = 0;
		try {
			Connection con = createConnection();
			PreparedStatement pst = con.prepareStatement("delete from employee where emobile=?");
			pst.setString(1, mobile);
			i = pst.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return i;
	}

	public Employee searchEmployee(String mobile) {
		Employee ee = null;
		Connection con = createConnection();
		try {
			PreparedStatement pst = con.prepareStatement("select * from employee where emobile=?");
			pst.setString(1, mobile);
			ResultSet rs = pst.executeQuery();
			if (rs.next()) {
				ee = new Employee(rs.getString("ename"), rs.getString("edesignation"), rs.getString("emobile"),
						rs.getString("equalification"), rs.getString("egender"), rs.getFloat("esalary"),
						rs.getString("eaddress"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return ee;
	}

	public int updateEmployee(Employee em) {
		int i = 0;
		Connection con = createConnection();
		try {
			PreparedStatement pst = con.prepareStatement(
					"update employee set ename=?, edesignation=?, esalary=?, egender=?, eaddress=?, equalification=? where emobile=?");
			pst.setString(1, em.getEname());
			pst.setString(2, em.getEdesignation());
			pst.setFloat(3, em.getEsalary());
			pst.setString(4, em.getEgender());
			pst.setString(5, em.getEaddress());
			pst.setString(6, em.getEqualification());
			pst.setString(7, em.getEmobile());
			i = pst.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return i;
	}

	public int submitResume(Carrer cc) {
		int i = 0;
		Connection con = createConnection();
		try {
			PreparedStatement ps = con.prepareStatement("insert into career values(?,?,?)");
			ps.setString(1, cc.getcName());
			ps.setString(2, cc.getcEmail());
			ps.setString(3, cc.getcResume());
			i = ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return i;
	}

	public ArrayList<Carrer> allCandidates() {
		ArrayList<Carrer> list = new ArrayList<>();
		Connection con = createConnection();
		try {
			PreparedStatement ps = con.prepareStatement("SELECT * FROM career");
			ResultSet rs = ps.executeQuery();
			Carrer cc = null;
			while (rs.next()) {
				cc = new Carrer(rs.getString("cname"), rs.getString("cemail"), rs.getString("cresume"));
				list.add(cc);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return list;
	}
}
