package tests;

import java.util.List;
import java.util.ArrayList;

import components.*;

// 1.1.2 Creation of main class for tests
public class Main {
	
	//Tests
	public static void main(String[] args) {
		Client client1 = new Client("Fahmi", "Samir");
		Client client2 = new Client("Loulou", "poulou");
		Client client3 = new Client("Lupin", "Jean");
		Client client4 = new Client("Dupond", "Martin");
		List<Client> allClients = new ArrayList<>();
		allClients.add(client1);
		allClients.add(client2);
		allClients.add(client3);
		allClients.add(client4);
		List<Client> partOfClients = loadTableClients(allClients, 1);
		displayTable(allClients);
		displayTable(partOfClients);
	}

	// method to load the table of clients contains the number of clients in parameter and return it 
	private static List<Client> loadTableClients(List<Client> allClients, int numberOfClients) {
		if (numberOfClients > allClients.size()) {
			System.out.println("The table contains less than " + numberOfClients + " clients!");
			return allClients;
		}
		List<Client> partOfClients = new ArrayList<>();
		for (int i = 0; i < numberOfClients; i++) {
			partOfClients.add(allClients.get(i));
		}
		return partOfClients;
	}
	
	// method to display the table of clients uses a stream
	private static void displayTable(List<Client> allClients) {	
		System.out.println("Table of clients : ");
		allClients.stream().forEach(elem -> System.out.println(elem.toString()));
	}  

}
