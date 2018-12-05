package example3.dao;

import example3.domain.Student;
import example3.utils.DBUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 * 分页的Dao
 * @noinspection unused, Duplicates, UnusedReturnValue
 */
@Deprecated
public class Pagination {

	Pagination(){}

	public ArrayList<Student> falsePage(int pageIndex, int pageSize) {
		ArrayList<Student> studentList = new ArrayList<>();
		Connection con = DBUtils.getConnection();
		String sql = "select id,stuId,name,score from Student";
		PreparedStatement pstmt;
		try {
			pstmt = con.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			rs.absolute((pageIndex - 1) * pageSize + 1);
			for (int i = 0; i < pageSize; i++) {
				Student student = new Student();
				student.setId(rs.getInt(1));
				student.setStuId(rs.getString(2));
				student.setName(rs.getString(3));
				student.setScore(rs.getInt(4));
				studentList.add(student);
				if (!rs.next())
					break;
			}
			return studentList;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * 真正的分页。
	 * @param pageIndex 页面索引
	 * @param pageSize 页面长度
	 * @return 页面对应的信息列表
	 */
	public List<Student> paginate(int pageIndex, int pageSize) {
		ArrayList<Student> studentList = new ArrayList<>();
		Connection con = DBUtils.getConnection();
		String sql = "select id,stuId,name,score from Student limit ?,?";

		PreparedStatement pstmt;
		try {
			pstmt = con.prepareStatement(sql);
			//第1页从0开始，第2页从page*pageSIze开始
			pstmt.setInt(1, (pageIndex - 1) * pageSize);
			//取pageSize个
			pstmt.setInt(2, pageSize);
			//不足pageSize个也没关系
			ResultSet rs = pstmt.executeQuery();

			while (rs.next()) {
				Student student = new Student();
				student.setId(rs.getInt(1));
				student.setStuId(rs.getString(2));
				student.setName(rs.getString(3));
				student.setScore(rs.getInt(4));
				studentList.add(student);
			}
			return studentList;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}
