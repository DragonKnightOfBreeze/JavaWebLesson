package example3.dao;

import dk_breeze.utils.ext.StringExt;
import example3.domain.Student;
import example3.utils.DBUtils;
import org.jetbrains.annotations.NotNull;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 * 学生的Dao类
 * @noinspection Duplicates
 */
public class StudentDao implements IStudentDao {
	private Connection con;
	private PreparedStatement pstmt = null;

	StudentDao() {
		con = DBUtils.getConnection();
	}

	@Override
	public Student findById(int id) throws Exception {
		String sql = "select stuId,name,score from Student where id=?";

		Student student = null;
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, id);
			ResultSet rs = pstmt.executeQuery();
			if (rs.next()) {
				student = new Student();
				student.setId(id);
				student.setStuId(rs.getString(1));
				student.setName(rs.getString(2));
				student.setScore(rs.getInt(3));
			}
			pstmt.close();
		} finally {
			DBUtils.closeConnection(con);
		}
		return student;
	}

	@Override
	public List<Student> findAllInPage(int pageIndex, int pageSize) throws Exception {
		ArrayList<Student> studentList = new ArrayList<>();
		String sql = "select id,stuId,name,score from Student limit ?,?";

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
		} finally {
			DBUtils.closeConnection(con);
		}
		return studentList;
	}

	@Override
	public ArrayList<Student> findAll() throws Exception {
		String sql = "select id,stuId,name,score from Student";

		ArrayList<Student> studentList = new ArrayList<>();
		try {
			pstmt = con.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			//把记录集合转化为对象集合
			while (rs.next()) {
				Student student = new Student();
				student.setId(rs.getInt(1));
				student.setStuId(rs.getString(2));
				student.setName(rs.getString(3));
				student.setScore(rs.getInt(4));
				studentList.add(student);
			}
			pstmt.close();
		} finally {
			DBUtils.closeConnection(con);
		}
		return studentList;
	}

	@Override
	public void doAdd(@NotNull Student student) throws Exception {
		String sql = "insert into Student (stuId,name,score) values (?,?,?)";
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, student.getStuId());
			pstmt.setString(2, student.getName());
			pstmt.setInt(3, student.getScore());
			pstmt.executeUpdate();
			pstmt.close();
		} finally {
			DBUtils.closeConnection(con);
		}
	}

	@Override
	public void doDelete(int id) throws Exception {
		String sql = "delete from Student where id=?";
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, id);
			pstmt.executeUpdate();
			pstmt.close();
		} finally {
			DBUtils.closeConnection(con);
		}
	}

	@Override
	public void doModify(@NotNull Student student) throws Exception {
		String sql = "update Student set stuId=?,name=?,score=? where id=?";

		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, student.getStuId());
			pstmt.setString(2, student.getName());
			pstmt.setInt(3, student.getScore());
			pstmt.setInt(4, student.getId());
			pstmt.executeUpdate();
			pstmt.close();
		} finally {
			DBUtils.closeConnection(con);
		}
	}

	@Override
	public int getTotal() throws Exception {
		return getTotalInCondition("");
	}

	@Override
	public int getPageNumber(int pageCount) throws Exception {
		return getTotal() / pageCount + 1;
	}

	@Override
	public int getTotalInCondition(@NotNull String condition) throws Exception {
		String sql = "select count(*) from Student where 1=1";

		int count = 0;
		if (StringExt.isSpace(condition)) {
			sql = sql + " and" + condition;
		}

		try {
			pstmt = con.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			if (rs.next()) {
				count = rs.getInt(1);
			}
		} finally {
			DBUtils.closeConnection(con);
		}
		return count;
	}
}
