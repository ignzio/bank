import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import java.util.ArrayList;
import java.util.UUID;

//this class will manage all the methods to create account, will store all the information and is responsable of manipulating the data. and display.
public class InformationManager {
    public AmazingArrayList<Accounts> accounts = new AmazingArrayList<Accounts>();
    private int numbersOfAccounts = 0;

    JFrame informationFrame = new JFrame();

    // this method will create an account and store it in the AmazinList.
    public void createAccount(String holder, String address, boolean usePopup) {
        LocalDateTime time = LocalDateTime.now(); // take the local time
        DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("dd-MM-yyyy"); // the time formatter object
        String formattedDate = time.format(myFormatObj); // the time will be formatted as the formatter object

        Accounts account = new Accounts(numbersOfAccounts, holder, address, formattedDate, 0);// create a new istance of
                                                                                              // account
        accounts.add(account); // add the new account to the amazing list

        numbersOfAccounts += 1; // increase the number of accounts by 1

        // Display the information
        String message = "You successfully created an Account" + "\n" +
                "Account Number: " + account.getAccountNumber() + "\n" +
                "Account Name: " + account.getHolderName() + "\n" +
                "Address: " + account.getHolderAddress() + "\n" +
                "Opening Date: " + account.getOpeningDate() + "\n" +
                "Starting Balance: " + account.getHolderBalance();

        /*
         * ===============================================
         * You successfully created an Account
         * Account Number: 0
         * Account Name: name
         * Address: address
         * Opening Date: date
         * Starting Balance: 0.0
         * ===============================================
         */

        if (usePopup) { // show a gui popup if requested.
            JOptionPane.showMessageDialog(informationFrame,message,
            "Account Created",
            JOptionPane.INFORMATION_MESSAGE);
            System.out.println(
            "===============================================" +
            "\n" + message + "\n" + 
            "===============================================");
        }
    }

    // this method generates a random account by giving a quantity
    public void genRandomAccount(int quanity) {
        String message = "You successfully generated" + quanity + " Account";
        for (int i = 0; i < quanity; i++) {
            String randomStr = usingRandomUUID();
            String secondRandomStr = usingRandomUUID();
            createAccount(randomStr, secondRandomStr, false);
        }
        JOptionPane.showMessageDialog(informationFrame,message,
        "Account Created",
        JOptionPane.INFORMATION_MESSAGE);
        System.out.println(
        "==============================================="
        + "\n" + message + "\n" +
        "===============================================");
    }

    // this method will perform a binary Search to find an Account by Giving the
    // account Number.
    // using a try and catch statement to determine if the account has been found or
    // not. or if the input is generaly not valid.
    public Accounts getAccountFromArray(int accountNumber) {
        try {
            Accounts a = binarySearch(accounts, accountNumber);
            return a;
        } catch (Exception e) {
            // TODO: handle exception
            return null;
        }
    }
    public void deleteAccount(int accountNumber) {
        Accounts a = getAccountFromArray(accountNumber);
        if(a == null){
            System.out.println("Any Account is Deleted");
        }
        accounts.remove(a);
    }

    public void showAccountDetails(Accounts a){
        String message;
        message = "===============================================" + "\n" +
                    "Account Number: " + a.getAccountNumber() + "\n" +
                    "Account Name: " + a.getHolderName() + "\n" +
                    "Address: " + a.getHolderAddress() + "\n" +
                    "Opening Date: " + a.getOpeningDate() + "\n" +
                    "Starting Balance: " + a.getHolderBalance();
            System.out.println(message);
    }

    public void showAllAccountDetails() {
        if (!accounts.isEmpty()) {
            System.out.println("__________________________________________________ \n SHOWING ALL ACCOUNTS");
            for (Accounts account : accounts) {

                // CHANGE THIS TO ACCOUNT FUNCION
                System.out.println("===============================================" + "\n" +

                        "Account Number: " + account.getAccountNumber() + "\n" +
                        "Account Name: " + account.getHolderName() + "\n" +
                        "Address: " + account.getHolderAddress() + "\n" +
                        "Opening Date: " + account.getOpeningDate() + "\n" +
                        "Starting Balance: " + account.getHolderBalance());
            }
            System.out.println("\n __________________________________________________");
        } else {
            //show pop up message
            JOptionPane.showMessageDialog(informationFrame,"No Existing Accounts",
            "Account Created",
            JOptionPane.INFORMATION_MESSAGE);
            //print in the console
            System.out.println("__________________________________________________ \n SHOWING ALL ACCOUNTS");
            System.out.println("no existing accounts");
            System.out.println("\n __________________________________________________");
        }
    }

    public boolean isNumeric(String strNum) {
        if (strNum == null) {
            return false;
        }
        try {
            int i = Integer.parseInt(strNum);

        } catch (NumberFormatException nfe) {
            return false;
        }
        return true;
    }
    public boolean isNegative(String strNum){
        if(isNumeric(strNum)){
            try {
                int i = Integer.parseInt(strNum);
                if(i < 0){
                    return true;
                }
            } catch (Exception e) {
                return false;
            }
        }
        return false;
    }


    



    private Accounts binarySearch(AmazingArrayList a, int target) {
        int low = 0;
        int high = a.size() - 1;

        while (low <= high) {
            int middle = low + (high - low) / 2;
            int value = ((Accounts) a.get(middle)).getAccountNumber();

            if (value < target)
                low = middle + 1;
            else if (value > target)
                high = middle - 1;
            else
                return ((Accounts) a.get(middle));
        }

        return null;
    }

    static String usingRandomUUID() {

        UUID randomUUID = UUID.randomUUID();

        return randomUUID.toString().replaceAll("_", "");

    }

    void updateAccountTransactions(String type, float ammount, int account){
        LocalDateTime time = LocalDateTime.now(); // take the local time
        DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("dd-MM-yyyy"); // the time formatter object
        String formattedDate = time.format(myFormatObj); // the time will be formatted as the formatter object
        Accounts a = getAccountFromArray(account);
        if(a != null){
            Transaction transaction = new Transaction(type, ammount, formattedDate);
            accounts.get(a.getAccountNumber()).addTransaction(transaction);
            accounts.get(a.getAccountNumber()).displayTransactions();
        }
        else{
            System.out.println("Accunt Not found. cant do transaction");
        }
    }

}
