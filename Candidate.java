package contacts;

public class Candidate {

	private String gender;
	private int age;
	private String university;
	
	public Candidate(String gender, int age, String university) {
		this.gender = gender;
		this.age = age;
		this.university = university;
	}
	
	public String getGender() {
		return gender;
	}
	
	public int getAge() {
		return age;
	}
	
	public String getUni() {
		return university;
	}
	
	public void setGender(String gender) {
		this.gender = gender;
	}
	
	public void setAge(int age) {
		this.age = age;
	}
	
	public void setUni(String university) {
		this.university = university;
	}
	
}
