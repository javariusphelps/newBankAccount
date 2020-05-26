import java.io.File;
import java.util.LinkedList;
import java.util.List;

public class BankAccountApp {

    public static void main(String[] args) {
        List<Account> accounts = new LinkedList<Account>();

        /*
         * 
         * Checking chkacc1 = new Checking("Tom Wilson", "232324346", 1500); Savings
         * savacc1 = new Savings("Rich Lowe", "132343428", 2500);
         * 
         * savacc1.compound();
         * 
         * savacc1.showInfo(); System.out.println("**************"); chkacc1.showInfo();
         */

        // Read a CSV File then create new accounts based on that data
        String file = "original.csv";
        List<String[]> newAccountHolders = utilities.CSV.read(file);
        for (String[] accountHolder : newAccountHolders) {
            String name = accountHolder[0];
            String ssn = accountHolder[1];
            String accountType = accountHolder[2];
            double initDeposit = Double.parseDouble(accountHolder[3]);
            if (accountType.equals("Savings")) {
                accounts.add(new Savings(name, ssn, initDeposit));
            } else if (accountType.equals("Checking")) {
                accounts.add(new Checking(name, ssn, initDeposit));
            } else {
                System.out.println("Error reading account type!");
            }
        }

        for (Account acc : accounts) {
            System.out.println("\n**********");
            acc.showInfo();
        }
    }

}