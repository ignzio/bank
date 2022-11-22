
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import java.util.UUID;



/*
 *  this class will manage all the methods that perform calculations,
 *  will store  information and is responsable of manipulating the data. and display informations.
 */

public class InformationManager {
    public AmazingArrayList<Accounts> accounts = new AmazingArrayList<Accounts>(); //DataType implementation
    private int numbersOfAccounts = 0;



    /*
     * this method will create an account and store it in the ArrayList.
     */
    public void createAccount(String holder, String address, boolean usePopup) {
        LocalDateTime time = LocalDateTime.now(); // take the local time
        DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("dd-MM-yyyy"); // the time formatter object
        String formattedDate = time.format(myFormatObj); // the time will be formatted as the formatter object
        Accounts account = new Accounts(numbersOfAccounts, holder, address, formattedDate, 0);// create a new istance of                                                                                      // account
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
            JFrame informationFrame = new JFrame();
            JOptionPane.showMessageDialog(informationFrame,message,
            "Account Created",
            JOptionPane.INFORMATION_MESSAGE);
            System.out.println(
            "===============================================" +
            "\n" + message + "\n" + 
            "===============================================");
        }
    }

    /*
     * this method generates a random account by giving a quantity
     */
    public void genRandomAccount(int quanity) {
        String message = "You successfully generated" + quanity + " Account";
        for (int i = 0; i < quanity; i++) {
            String randomStr = usingRandomUUID();
            String secondRandomStr = usingRandomUUID();
            createAccount(randomStr, secondRandomStr, false);
        }
        JFrame informationFrame = new JFrame();
        JOptionPane.showMessageDialog(informationFrame,message,
        "Account Created",
        JOptionPane.INFORMATION_MESSAGE);
        System.out.println(
        "==============================================="
        + "\n" + message + "\n" +
        "===============================================");
    }



    /*
     * this method will perform a binary Search to find an Account by Giving the account Number.
        Use a try-and-catch statement to determine if the account has been found.
        Or if the input is generally not valid
     */
    public Accounts getAccountFromArray(int accountNumber) {
        try {
            Accounts a = binarySearch(accounts, accountNumber);
            return a;
        } catch (Exception e) {
            // TODO: handle exception
            return null;
        }
    }
    /*
     * this method will perform a binary Search to delete an Account by Giving the account Number.
     */
    public void deleteAccount(int accountNumber) {
        Accounts a = getAccountFromArray(accountNumber);
        if(a == null){
            popUpGuiMessage("ERROR_NODELETED");
            System.out.println("Any Account is Deleted");
        }
        accounts.remove(a);
    }


    /*
     * this method will show the details of an account taken from the AmazinArrayList in the console
     */
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
    /*
     * this method will show all the infomations of all the account inside the AmazinArrayList
     */
    public void showAllAccountDetails() {
        if (!accounts.isEmpty()) {
            System.out.println("__________________________________________________ \n SHOWING ALL ACCOUNTS");
            for (Accounts account : accounts) {
                // CHANGE THIS TO ACCOUNT FUNCION
                showAccountDetails(account);
            }
            System.out.println("\n __________________________________________________");
        } else {
            //show pop up message
            popUpGuiMessage("ERROR_NOEXIST");
            //print in the console
            System.out.println("__________________________________________________ \n SHOWING ALL ACCOUNTS");
            System.out.println("no existing accounts");
            System.out.println("\n __________________________________________________");
        }
    }

    /*
     * this method will check if a string is numeric
     */
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

    /*
     * this method will check if a string is a numeric number and is not negative
     */
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


    


    /*
     * binary search algorithm implementation.
     * this method will perform a binarySearch to find an account from the accounts AmazingArrayList
     */
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


    /*
     * this method will generate a random String using the java UUID util framework
     */
    static String usingRandomUUID() {
        UUID randomUUID = UUID.randomUUID();
        return randomUUID.toString().replaceAll("_", "");
    }

    /*
     * This method will update an Account Balance and  add the transaction 
     */
    void updateAccountTransactions(String type, float ammount, int account){
        LocalDateTime time = LocalDateTime.now(); // take the local time
        DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("dd-MM-yyyy"); // the time formatter object
        String formattedDate = time.format(myFormatObj); // the time will be formatted as the formatter object
        Accounts a = getAccountFromArray(account);
        if(a != null){
            Transaction transaction = new Transaction(type, ammount, formattedDate);
            if(transaction.getType() == "Withdraw"){
                accounts.get(a.getAccountNumber()).withdrawBalance(ammount);
            }
            if(transaction.getType() == "Deposit"){
                accounts.get(a.getAccountNumber()).depositBalance(ammount);
            }
            accounts.get(a.getAccountNumber()).addTransaction(transaction);
            accounts.get(a.getAccountNumber()).displayTransactions();
            

            JFrame informationFrame = new JFrame();
            JOptionPane.showMessageDialog(informationFrame,"Transaction Has Been added to account Number: " + a.getAccountNumber(),
            "Account Added",
            JOptionPane.INFORMATION_MESSAGE);
        }
        else{
            popUpGuiMessage("ERROR_NOFOUND");
        }
    }

    /*
     * this method will popup Different type of Error messages both in console and GUI
     */
    public void popUpGuiMessage(String flag){
        JFrame informationFrame = new JFrame();
        switch(flag){
             //error message, no account found
            case "ERROR_NOEXIST":

            JOptionPane.showMessageDialog(informationFrame,"No Existing Accounts",
            "NO EXISTING ACCOUNT",
            JOptionPane.ERROR_MESSAGE);
            break;

             //no existing accounts
            case "ERROR_NOFOUND":

            JOptionPane.showMessageDialog(informationFrame,"Any account was Found with this Account Number",
            "NO EXISTING ACCOUNT",
            JOptionPane.ERROR_MESSAGE);
            System.out.println("No Account Found");
            break;

            // no deleted
            case "ERROR_NODELETED":

            JOptionPane.showMessageDialog(informationFrame,"No Account Was deleted",
            "NO ACCOUNT DELETED",
            JOptionPane.ERROR_MESSAGE);
            break;

            case "ERROR_NOTRANSACTION":
            JOptionPane.showMessageDialog(informationFrame,"Any transaction has been found in this account",
            "NO TRANSACTION FOUND",
            JOptionPane.ERROR_MESSAGE);
            System.out.println("No Transactions has been found in this account");
            break;
            
            case "ERROR_NODIGIT":
            JOptionPane.showMessageDialog(informationFrame,"The searchbar input must be a Digit",
            "NO DIGIT INPUT",
            JOptionPane.ERROR_MESSAGE);
            System.out.println("The searchbar input must be a digit");
            break;
        }
        
    }
  
    
}
