/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package supportbank;

import java.io.FileNotFoundException;
import java.util.Scanner;

import supportbank.Bank.Bank;

public class App {
    public String getGreeting() {
        return "Hello World!";
    }

    public static void main(String[] args) throws FileNotFoundException {
        Bank bank = new Bank();

        System.out.println("Enter command:" + "ListAll OR List");
        Scanner scanner = new Scanner(System.in);
        String userPrompt = scanner.nextLine();
        if (userPrompt.equals("ListAll")) {
            bank.listAll();
        } else if (userPrompt.equals("List")) {
            System.out.println("Enter account holder name:");
            String name = scanner.nextLine();
            bank.listPerson(name);
        }
        scanner.close();
        
    }
}
