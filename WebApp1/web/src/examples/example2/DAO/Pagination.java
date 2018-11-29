package examples.example2.DAO;

import examples.example2.POJO.Student;
import examples.example2.Utils.DBUtils;

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
				rs.next();
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		return null;
	}
}
