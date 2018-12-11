package example3.dao;

import example3.domain.Student;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

/**
 * 学生的Dao接口
 * @noinspection unused, Duplicates, UnusedReturnValue
 */
public interface IStudentDao {
	/**
	 * 通过Id查询信息。
	 */
	Student findById(int id) throws Exception;

	/**
	 * 查询信息并分页。
	 * @param pageIndex 页面索引，从1开始
	 * @param pageSize 页面长度
	 * @return 页面对应的信息列表
	 */
	List<Student> findAllInPage(int pageIndex, int pageSize) throws Exception;

	/**
	 * 查询所有信息。
	 */
	ArrayList<Student> findAll() throws Exception;

	/**
	 * 插入信息。
	 */
	void doAdd(@NotNull Student student) throws Exception;

	/**
	 * 通过Id删除信息。
	 */
	void doDelete(int id) throws Exception;

	/**
	 * 编辑信息。
	 */
	void doModify(@NotNull Student student) throws Exception;

	/**
	 * 得到所有的信息数量。
	 */
	int getTotal() throws Exception;

	/**
	 * 得到页数。
	 */
	int getPageNumber(int pageCount) throws Exception;

	int getTotalInCondition(@NotNull String condition) throws Exception;
}
