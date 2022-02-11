package tests;

import java.util.List;
import java.util.ArrayList;

import components.*;

// 1.1.2 Creation of main class for tests
public class Main {

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
		System.out.println(allClients.toString());
		List<Client> partOfClients = loadTableClients(allClients, 3);
		System.out.println(partOfClients.toString());
	}

	
	public static List<Client> loadTableClients(List<Client> allClients, int numberOfClients) {
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
	
	@Override
	public String toString() {	  
		return super.toString();
	}  

}
