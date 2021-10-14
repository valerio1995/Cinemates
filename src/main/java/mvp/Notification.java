package mvp;

public class Notification {
	String text;
	String typeOfNotification;
	boolean readFromUser;
	String senderUsername;
	String receiverUsername;
	
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	public String getTypeOfNotification() {
		return typeOfNotification;
	}
	public void setTypeOfNotification(String typeOfNotification) {
		this.typeOfNotification = typeOfNotification;
	}
	public boolean isReadFromUser() {
		return readFromUser;
	}
	public void setReadFromUser(boolean read) {
		this.readFromUser = read;
	}
	public String getSenderUsername() {
		return senderUsername;
	}
	public void setSenderUsername(String senderUsername) {
		this.senderUsername = senderUsername;
	}
	public String getReceiverUsername() {
		return receiverUsername;
	}
	public void setReceiverUsername(String receiverUsername) {
		this.receiverUsername = receiverUsername;
	}

	
	

}
