package contacts;
import java.util.ArrayList; 

public class Contact extends Candidate implements Requirments{
	
	private String name;
	private String email;
	private int number;
	private String job;
	private ArrayList<Message> messages;
	
	public Contact(String name, String email, int number, String job, ArrayList<Message> messages, String gender, int age, String university) {
		super(gender, age, university);
		this.name = name;
		this.email = email;
		this.number = number;
		this.messages = messages;
		this.job = job;
	}
	
	public Contact(String name, String email, int number, String job, String gender, int age, String university) {
		super(gender, age, university);
		this.name = name;
		this.email = email;
		this.number = number;
		this.job = job;
		this.messages = new ArrayList<>();
	}
	
	public String getName() {
		return this.name;
	}
	
	public String getEmail() {
		return this.email;
	}
	
	public int getNumber() {
		return this.number;
	}
	
	public String getJob() {
		return this.job;
	}
	
	public ArrayList<Message> getMessage() {
		return this.messages;
	}
	
	public void setName (String name) {
		this.name = name;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public void setNumber(int number) {
		this.number = number;
	}
	
	public void setJob(String job) {
		this.job = job;
	}
	
	public void setMessage(ArrayList<Message> messages) {
		this.messages = messages;
	}
	
	public void showContactsDetails () {
		System.out.println("Name: " + getName());
		System.out.println("Email: " + getEmail());
		System.out.println("Number: " + getNumber());
		System.out.println("Job: " + getJob());
		System.out.println("Gender: " + getGender());
		System.out.println("Age: " + getAge());
		System.out.println("University: " + getUni());
		//System.out.println("Messages: " + getMessage());
	}
	
	public void addMessage(Message message) {
		this.messages.add(message);
	}
}
