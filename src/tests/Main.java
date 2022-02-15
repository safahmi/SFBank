package tests;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import components.Account;
import components.Client;
import components.Credit;
import components.CurrentAccount;
import components.Debit;
import components.Flow;
import components.SavingsAccount;
import components.Transfert;

// 1.1.2 Creation of main class for tests
public class Main {

	public static void main(String[] args) {
		// Tests client
		List<Client> allClients = new ArrayList<>();
		allClients = loadTableClients(2);
		displayTableClients(allClients);

		// 1.2.3 Creation of the table account
		List<Account> allAccounts = loadTableAccounts(allClients);
		displayTableAccounts(allAccounts);

		// 1.3.1 Adaptation of the table of accounts
		Map<Integer, Account> allAccountsMap = loadTableAccountsWithId(allAccounts);
		displayTableAccountsMap(allAccountsMap);

		// 1.3.4 Creation of the flow array
		List<Flow> allFlows = loadTableFlows(allAccounts);

	}

	// method to load the table of clients contains the number of clients in
	// parameter and return it
	private static List<Client> loadTableClients(int numberOfClients) {
		List<Client> clients = new ArrayList<>();
		for (int i = 1; i <= numberOfClients; i++) {
			clients.add(new Client("name" + i, "firstName" + i));
		}
		return clients;
	}

	/**
	 * method to display the table of clients uses a stream
	 * 
	 * @param allClients
	 */
	private static void displayTableClients(List<Client> allClients) {
		System.out.println("\nTable of clients : \n");
		allClients.stream().forEach(System.out::println);
	}

	/**
	 * method to load the table of accounts
	 * 
	 * @param clients
	 * @return
	 */
	private static List<Account> loadTableAccounts(List<Client> clients) {

		List<Account> allAccounts = new ArrayList<>();

		for (int i = 0; i < clients.size(); i++) {
			CurrentAccount currentAccount = new CurrentAccount("Current Account", clients.get(i));
			SavingsAccount savingsAccount = new SavingsAccount("Savings Account", clients.get(i));
			allAccounts.add(currentAccount);
			allAccounts.add(savingsAccount);
		}

		return allAccounts;

	}

	/**
	 * method to display the table of accounts
	 * 
	 * @param allAccounts
	 */
	private static void displayTableAccounts(List<Account> allAccounts) {
		System.out.println("\nTable of accounts : \n");
		allAccounts.stream().forEach(System.out::println);
	}

	/**
	 * 
	 * @param allAccounts
	 * @return an Hashtable (account identifier, Account) of accounts
	 */
	private static Map<Integer, Account> loadTableAccountsWithId(List<Account> allAccounts) {
		Map<Integer, Account> allAccountsMap = new HashMap<>();
		for (Account account : allAccounts) {
			allAccountsMap.put(account.getAccountNumber(), account);
		}
		return allAccountsMap;
	}

	// method to display the Hashtable in ascending order according to the balance
	private static void displayTableAccountsMap(Map<Integer, Account> allAccountsMap) {

		System.out.println("\nHashtable of accounts : \n");
		allAccountsMap.entrySet().stream().sorted((s1, s2) -> balancesComparator(s1, s2)).forEach(System.out::println);

	}

	/**
	 * @param s1
	 * @param s2
	 * @return 1 if s1 balance >= s2 balance
	 */
	private static int balancesComparator(Entry<Integer, Account> s1, Entry<Integer, Account> s2) {
		return s1.getValue().getBalance() >= s2.getValue().getBalance() ? 1 : -1;
	}

	// 1.3.4 method to load the flow array
	private static List<Flow> loadTableFlows(List<Account> accounts) {

		List<Flow> flowList = new ArrayList<>();
		// a debit of 50€ from account n°1
		flowList.add(new Debit(50, 1));
		for (Account account : accounts) {
			if (account instanceof CurrentAccount) {
				// A credit of 100.50€ on all current accounts in the array of accounts
				flowList.add(new Credit(100.50, account.getAccountNumber()));
			} else if (account instanceof SavingsAccount) {
				// A credit of 1500€ on all savings accounts in this same array
				flowList.add(new Credit(1500, account.getAccountNumber()));
			}

		}
		// A transfer of 50 € from account n ° 1 to account n ° 2
		flowList.add(new Transfert(50, 2, 1));

		return flowList;
	}

}
