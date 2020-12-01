package jg.ou.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import jg.ou.commom.Student;
import jg.ou.helper.jdbcHelper;

public class studentDao {

	jdbcHelper jdbc = jdbcHelper.INSTANCE;

	public List<Student> queryAll() {
		List<Student> list = new ArrayList<Student>();

		Connection conn = null;
		Statement stmt = null;
		try {
			// 打开链接
			conn = jdbc.helper();
			// 执行查询
			stmt = conn.createStatement();
			String sql;
			sql = "SELECT stu_id, stu_name , stu_sex , stu_age , stu_major FROM student";
			ResultSet rs = stmt.executeQuery(sql);

			// 展开结果集数据库
			while (rs.next()) {
				// 通过字段检索
				int stu_id = rs.getInt("stu_id");
				String stu_name = rs.getString("stu_name");
				int stu_sex = rs.getInt("stu_sex");
				int stu_age = rs.getInt("stu_age");
				String stu_major = rs.getString("stu_major");
				Student student = new Student(stu_id, stu_sex, stu_age, stu_name, stu_major);
				list.add(student);
			}
			// 完成后关闭
			rs.close();
			stmt.close();
			conn.close();
		} catch (SQLException se) {
			// 处理 JDBC 错误
			se.printStackTrace();
		} catch (Exception e) {
			// 处理 Class.forName 错误
			e.printStackTrace();
		} finally {
			// 关闭资源
			try {
				if (stmt != null)
					stmt.close();
			} catch (SQLException se2) {
			} // 什么都不做
			try {
				if (conn != null)
					conn.close();
			} catch (SQLException se) {
				se.printStackTrace();
			}
		}
		return list;
	}

	public List<Student> queryInfoByData(Student stu) {
		List<Student> list = new ArrayList<Student>();

		Connection conn = null;
		Statement stmt = null;
		try {
			// 打开链接
			conn = jdbc.helper();
			// 执行查询
			stmt = conn.createStatement();
			String sql;
			sql = "SELECT stu_id, stu_name , stu_sex , stu_age , stu_major FROM student";
			if (stu.getStu_age() != 0) {
				sql = sql + " where stu_age = " + stu.getStu_age();
			}
			if (stu.getStu_id() != 0) {
				sql = sql + " where stu_id = " + stu.getStu_id();
			}
			if (stu.getStu_major() != null) {
				sql = sql + " where stu_major = " + stu.getStu_major();
			}
			if (stu.getStu_name() != null) {
				sql = sql + " where stu_name = " + stu.getStu_name();
			}
			if (stu.getStu_sex() != 0) {
				sql = sql + " where stu_sex = " + stu.getStu_sex();
			}
			System.out.println(sql);
			System.out.println(sql.indexOf("where"));
			ResultSet rs = stmt.executeQuery(sql);

			// 展开结果集数据库
			while (rs.next()) {
				// 通过字段检索
				int stu_id = rs.getInt("stu_id");
				int stu_sex = rs.getInt("stu_sex");
				int stu_age = rs.getInt("stu_age");
				String stu_name = rs.getString("stu_name");
				String stu_major = rs.getString("stu_major");
				Student student = new Student(stu_id, stu_sex, stu_age, stu_name, stu_major);
				list.add(student);
			}
			// 完成后关闭
			rs.close();
			stmt.close();
			conn.close();
		} catch (SQLException se) {
			// 处理 JDBC 错误
			se.printStackTrace();
		} catch (Exception e) {
			// 处理 Class.forName 错误
			e.printStackTrace();
		} finally {
			// 关闭资源
			try {
				if (stmt != null)
					stmt.close();
			} catch (SQLException se2) {
			} // 什么都不做
			try {
				if (conn != null)
					conn.close();
			} catch (SQLException se) {
				se.printStackTrace();
			}
		}
		return list;
	}
	

}
