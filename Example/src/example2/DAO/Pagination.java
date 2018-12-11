package example2.DAO;

import example2.POJO.Student;
import example2.Utils.DBUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 * 分页
 */
public class Pagination {
	public ArrayList<Student> falsePage(int pageIndex , int pageSize){
		ArrayList<Student> studentList = new ArrayList<>();
		Connection con = DBUtils.getConnection();
		String sql = "select id,stuId,name,score from Student";
		PreparedStatement pstmt = null;
		try{
			pstmt= con.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			rs.absolute((pageIndex-1)*pageSize+1);
			for(int i = 0; i < pageSize; i++) {
				Student student = new Student();
				student.setId(rs.getInt("id"));
				student.setStuId(rs.getString("stuId"));
				student.setName(rs.getString("name"));
				student.setScore(rs.getInt("score"));
				studentList.add(student);
				if(!rs.next())
					break;
			}
			return studentList;
		}catch(Exception e){
			e.printStackTrace();
		}
		return null;
	}

	public ArrayList<Student> truePage(int pageIndex , int pageSize){
		ArrayList<Student> studentList = new ArrayList<>();
		Connection con = DBUtils.getConnection();
		String sql = "select id,stuId,name,score from Student limit ?,?";
		PreparedStatement pstmt = null;
		try{
			pstmt= con.prepareStatement(sql);
			pstmt.setInt(1,(pageIndex-1)*pageSize);	//第1页从0开始，第2页从page*pageSIze开始
			pstmt.setInt(2,pageSize);			//取pageSize个
			ResultSet rs = pstmt.executeQuery();	//不足pageSize个也没关系

			while(rs.next()) {
				Student student = new Student();
				student.setId(rs.getInt("id"));
				student.setStuId(rs.getString("stuId"));
				student.setName(rs.getString("name"));
				student.setScore(rs.getInt("score"));
				studentList.add(student);
			}
			return studentList;
		}catch(Exception e){
			e.printStackTrace();
		}
		return null;
	}
}
