package contacts;
import java.util.Scanner;
import java.util.ArrayList;
public class MainClass {
	
	private static Scanner scanner;
	private static  ArrayList<Contact> contacts;
	private static int id = 0;
	public static void main(String[] args) {
		
		scanner = new Scanner(System.in);
		contacts = new ArrayList<Contact>();
		System.out.println("Welcome to my atzenta world of programming");
		initPage();
		
	}
	
	private static void initPage() {
		
		try {
			System.out.println("What can I do for you?\n" + 
					"\t1. Manage contacts" + 
					"\t2. Send a message\n" +
					"\t3. Quit");
			scanner = new Scanner(System.in);
			int initialChoice = scanner.nextInt();

			switch (initialChoice) {
			case 1:
				manageContacts();
				break;
			case 2:
				sendMessage();
				break;
			case 3:
				break;
			default:
				break;
			}	
		}catch(Exception e) {
			System.out.println("Something went wrong.");
			System.out.println("Please press once below choice 1-5!");
			scanner = new Scanner(System.in);
			initPage();
		}
	}
		
	private static void manageContacts() {
		
		try {
			System.out.println("What do you want to do?\n");
			System.out.println("\t1. Add a contact\n" +
							   "\t2. Show all contacts" +
					           "\t3. Remove a contact\n" +
							   "\t4. Search Contact\n" +
					           "\t5. Go Back");
			
			int initialChoice = scanner.nextInt();
			
			switch (initialChoice) {
				case 1:
					addNewContact();
					break;
				case 2:
					showAllContacts();
					break;
				case 3:
					removeContact();
					break;
				case 4:
					searchContact();
					break;
				case 5:
					initPage();
					break;
				default: 
					break;
					
			}	
		}catch (Exception e){
			System.out.println("Something went wrong.");
			System.out.println("Please press once below choice 1-5!");
			scanner = new Scanner(System.in);
			//int initialChoice2 = scanner.nextInt();

			manageContacts();
		}
	}
	
	private static void sendMessage() {
		
		try {
			
			System.out.println("\t1. Continue");
			System.out.println("\t2. Go Back");
			int initialChoice = scanner.nextInt();
			
			switch (initialChoice) {
				case 1:	
					System.out.println("Who are you send a personal message?\n");
					String contactName = scanner.next();
					
					boolean doesExist = false;
					
					for(int i=0; i<contacts.size(); i++) {
						if(contacts.get(i).getName().equals(contactName)) {
							doesExist = true;
						}
					}
					
					if(!doesExist) {
						System.out.println("There is no contact name " + contactName + "saved on this device");
					}else {
						System.out.println("What do you want to send?\n");
						String text = scanner.next();
						id++;
						Message message = new Message(text, contactName, id);
						for(int i=0; i<contacts.size(); i++) {
							if(contacts.get(i).equals(contactName)) {
								contacts.get(i).addMessage(message);
							}
						}
						
					}
					
					initPage();	
				case 2:
					initPage();
				default:
					break;
			}
		}catch(Exception e) {
			System.out.println("Something went wrong.");
			System.out.println("Please press once below choice 1-2!");
			scanner = new Scanner(System.in);
			//int initialChoice2 = scanner.nextInt();

			sendMessage();

		}
	}
	
	private static void addNewContact() {
		
		try {
			System.out.println("\t1. Continue");
			System.out.println("\t2. Back");

			
			int initialChoice = scanner.nextInt();
			
			switch(initialChoice) {
				case 1:
					System.out.println("Enter Contact's Name:\n");
					String newName = scanner.next();
					
					System.out.println("Enter Contact's Number:\n");
					int newNumber = scanner.nextInt();
					
					System.out.println("Enter Contact's Email:\n");
					String newEmail = scanner.next();
					
					System.out.println("Enter Contact's Job:\n");
					String newJob = scanner.next();
					
					System.out.println("Enter Contact's Gender:\n");
					String newGender = scanner.next();
					
					System.out.println("Enter Contact's Age:\n");
					int newAge = scanner.nextInt();
					
					System.out.println("Enter Contact's University:\n");
					String newUni = scanner.next();
					
					Contact newContact = new Contact(newName, newEmail, newNumber, newJob, newGender, newAge, newUni);		
					contacts.add(newContact);
					System.out.println("Contact " + newName + " Added successfully");
					initPage();
				case 2:
					manageContacts();
				default:
					break;
			}
	
		}catch(Exception e) {
			System.out.println("Something went wrong.");
			System.out.println("Please press once below choice 1-2!");
			scanner = new Scanner(System.in);
			//int initialChoice2 = scanner.nextInt();

			addNewContact();
		}		
	}
	
	private static void showAllContacts() {
		
		try {
			System.out.println("\t1. Continue");
			System.out.println("\t2. Back");

			
			int initialChoice = scanner.nextInt();
			
			switch (initialChoice) {
				case 1:
					if(contacts.size() > 0) {
						for(int i=0; i<contacts.size(); i++) {
							contacts.get(i).showContactsDetails();
							System.out.println("************");
						}
					} else {
						System.out.println("There are no saved contact");
					}
					initPage();
				case 2:
					manageContacts();
				default:
					break;
			}	
		}catch(Exception e) {
			System.out.println("Something went wrong.");
			System.out.println("Please press once below choice 1-2!");
			scanner = new Scanner(System.in);
			//int initialChoice2 = scanner.nextInt();

			showAllContacts();
		}
	}
	
	private static void removeContact() {
		
		try {
			System.out.println("\t1. Continue");
			System.out.println("\t2. Go Back");
			int initialChoice = scanner.nextInt();
			
			switch(initialChoice) {
				case 1:
					System.out.println("Please Enter contact's name:\n");
					String contactsName = scanner.next();
					//boolean flag = false;
					
					if(!contacts.isEmpty()) {
						for(int i=0; i<contacts.size(); i++) {
							if(contacts.get(i).getName().equals(contactsName)) {
								//flag = true;
								System.out.println("Are you sure to want to delete " + contactsName  + "? (Y/N)");
								String answer = scanner.next();
								switch (answer) {
									case "Y":
										for(int j=0; j<contacts.size(); j++) {
											if(contacts.get(j).getName().equals(contactsName)) {
												contacts.remove(contacts.get(j));
												System.out.println(contactsName + " deleted successfully");
												initPage();
											}
										}
										break;
									case "y":
										for(int j=0; j<contacts.size(); j++) {
											if(contacts.get(j).getName().equals(contactsName)) {
												contacts.remove(contacts.get(j));
												System.out.println(contactsName + " deleted successfully");
												initPage();
											}
										}
										break;
									case "N":
										initPage();
										break;
									case "n":
										initPage();
										break;
									default:
										break;
								}
							}else {
								System.out.println("There is name" + contactsName + " in list contacts");
								initPage();
							}
						}
					}else{
						System.out.println("There is no contact");
						initPage();
					}
				case 2:
					manageContacts();
			}
	
		}catch(Exception e) {
			System.out.println("Something went wrong.");
			System.out.println("Please press once below choice 1-2!");
			scanner = new Scanner(System.in);
			//int initialChoice2 = scanner.nextInt();

			removeContact();
		}				
	}

	private static void searchContact() {
		
		try {
			System.out.println("\t1. Continue");
			System.out.println("\t2. Go Back");
			int initialChoice = scanner.nextInt();
			
			switch(initialChoice) {
				case 1:
					System.out.println("\t1. Search Candidate name");
					System.out.println("\t2. Search Candidate Job");
					//System.out.println("\t3. Search Candidate University");

					int initialChoice2 = scanner.nextInt();
					
					switch (initialChoice2) {
						case 1: 
							System.out.println("Who are you looking for?\n");
							String contactName = scanner.next();
							
							boolean doesExist = false;
							
							for(int i=0; i<contacts.size(); i++) {
								if(contacts.get(i).getName().equals(contactName)) {
									doesExist = true;
									contacts.get(i).showContactsDetails();
									initPage();
								}
							}
							
							if(!doesExist) {
								System.out.println("There is no contact named " + contactName + "saved on this device");
								initPage();
							}	
							break;
						case 2:
							searchJob();
						default:
							break;
					}
					
				case 2:
					manageContacts();
				default:
					break;
			}
		}catch(Exception e) {
			System.out.println("Something went wrong.");
			System.out.println("Please press once below choice 1-2!");
			scanner = new Scanner(System.in);
			//int initialChoice2 = scanner.nextInt();

			searchContact();
		}
	}
	
	private static void searchJob() {
		
		try {
			System.out.println("\t1. Continue");
			System.out.println("\t2. Go Back");
			int initialChoice = scanner.nextInt();	
			switch (initialChoice) {
				case 1:
					System.out.println("What are you job looking for?\n");
					String contactJob = scanner.next();
					boolean exist = false;
					
					for(int i=0; i<contacts.size(); i++) {
						if(contacts.get(i).getJob().equals(contactJob)) {
							exist = true;
							contacts.get(i).showContactsDetails();
							System.out.println("************");
						}
					}
					initPage();
					
					if(!exist) {
						System.out.println("There is no contact job " + contactJob + "saved on this device");
						initPage();
					}
				case 2:
					manageContacts();
				default:
					break;
			}
			
		}catch(Exception e) {
			System.out.println("Something went wrong.");
			System.out.println("Please press once below choice 1-2!");
			scanner = new Scanner(System.in);
			//int initialChoice2 = scanner.nextInt();

			searchJob();

		}
		
		
	}
}

