package example2.DAO;

import example2.POJO.Student;
import example2.Utils.DBUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class StudentDAO {
	public ArrayList<Student> list(){
		ArrayList<Student> studentList = new ArrayList<>();
		Connection con = DBUtils.getConnection();
		PreparedStatement pstmt;
		String sql = "select id,stuId,name,score from Student";
		try{
			pstmt = con.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			//把记录集合转化为对象集合
			while(rs.next()){
				Student student = new Student();
				student.setId(rs.getInt(1));
				student.setStuId(rs.getString(2));
				student.setName(rs.getString(3));
				student.setScore(rs.getInt(4));
				studentList.add(student);
			}
			pstmt.close();
		}catch (Exception e){
			e.printStackTrace();
		}finally {
			DBUtils.closeConnection(con);
		}
		return studentList;
	}

	public boolean insert(Student student){
		Connection con = DBUtils.getConnection();
		PreparedStatement pstmt;
		String sql = "insert into Student (stuId,name,score) values(?,?,?)";
		try{
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1,student.getStuId());
			pstmt.setString(2,student.getName());
			pstmt.setInt(3,student.getScore());
			pstmt.executeUpdate();
			pstmt.close();
		}catch (Exception e){
			e.printStackTrace();
		}finally {
			DBUtils.closeConnection(con);
		}
		return true;
	}

	public boolean delete(int id){
		Connection con = DBUtils.getConnection();
		PreparedStatement pstmt;
		String sql = "delete from Student where id=?";
		try{
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1,id);
			pstmt.executeUpdate();
			pstmt.close();
		}catch (Exception e){
			e.printStackTrace();
		}finally {
			DBUtils.closeConnection(con);
		}
		return true;
	}

	public Student edit(int id){
		Student student = null;
		Connection con = DBUtils.getConnection();
		PreparedStatement pstmt;
		String sql = "select stuId,name,score from Student where id=?";
		try{
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1,id);
			ResultSet rs = pstmt.executeQuery();
			if(rs.next()){
				student = new Student();
				student.setStuId(rs.getString(1));
				student.setName(rs.getString(2));
				student.setScore(rs.getInt(3));
			}
			pstmt.close();
		}catch (Exception e){
			e.printStackTrace();
		}finally {
			DBUtils.closeConnection(con);
		}
		return student;
	}

	public boolean modify(Student student){
		Connection con = DBUtils.getConnection();
		PreparedStatement pstmt;
		String sql = "update Student set stuId=?,name=?,score=? where id=?";
		try{
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1,student.getStuId());
			pstmt.setString(2,student.getName());
			pstmt.setInt(3,student.getScore());
			pstmt.setInt(4,student.getId());
			pstmt.executeUpdate();
			pstmt.close();
		}catch (Exception e){
			e.printStackTrace();
		}finally {
			DBUtils.closeConnection(con);
		}
		return true;
	}

	public int count(){
		return count(null);
	}

	public int count(String condition){
		int count=0;
		String sql = "select count(*) from Student where";
		if(condition!=null && !"".equals(condition.trim()))
			sql= sql+"and"+condition;

		Connection con=DBUtils.getConnection();
		PreparedStatement pstmt;
		try{
			pstmt = con.prepareStatement(sql);
			ResultSet rs=pstmt.executeQuery();
			if(rs.next())
				count = rs.getInt(1);
		}catch(Exception e){
			e.printStackTrace();
		}finally {
			DBUtils.closeConnection(con);
		}
		return count;
	}
}

//interface Condition{
//	boolean condition(Object... params);
//}
