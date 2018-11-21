package examples.example2.POJO;

/**
 * 模型类
 */
public class Student {
	private int stuId;
	private String name;
	private int score;


	public int getStuId() {
		return stuId;
	}

	public void setStuId(int stuId) {
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

	@Override
	public String toString() {
		return "id:"+ stuId +"\tname:"+name+"\tscore:"+score;
	}
}
