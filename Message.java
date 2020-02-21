package contacts;

public class Message {
	
	private String text;
	private String receiver;
	private int id;
	
	public Message (String text, String receiver, int id) {
		this.text = text;
		this.receiver = receiver;
		this.id = id;
	}
	
	public String getText() {
		return text;
	}
	
	public String getReceiver() {
		return receiver;
	}
	
	public int getId () {
		return id;
	}
	
	public void setText(String text) {
		this.text = text;
	}
	
	public void setReceiver(String receiver) {
		this.receiver = receiver;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
}
