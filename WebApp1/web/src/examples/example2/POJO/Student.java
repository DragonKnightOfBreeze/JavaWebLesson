package examples.example2.POJO;

/**
 * 模型类
 */
public class Student {
	private int id;
	private String stuId;
	private String name;
	private int score;


	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getStuId() {
		return stuId;
	}

	public void setStuId(String stuId) {
		this.stuId = stuId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}


	public Student(){}

	public Student(int id,String stuId,String name,int score){
		this.id=id;
		this.stuId=stuId;
		this.name=name;
		this.score=score;
	}


	@Override
	public String toString() {
		return "stuId:" + stuId + "\tname:" + name + "\tscore:" + score;
	}

}
