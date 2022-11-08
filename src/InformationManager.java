import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
//this class will manage all the methods to create account, will store all the information and is responsable of manipulating the data. and display.
public class InformationManager {
    ArrayList<Accounts> accounts = new ArrayList<Accounts>();
    int numbersOfAccounts = 0;

    InformationManager(){

    }
    void createAccount(String holder,String password,String address){
        LocalDateTime time = LocalDateTime.now();
        DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
        String formattedDate = time.format(myFormatObj);

        //first checks if the account numbers are sorted numerically, if theres any gap betweeen accounts, add it#

        Accounts account = new Accounts(numbersOfAccounts, holder, password, address, formattedDate, 0);
        accounts.add(account);
        numbersOfAccounts += 1;
        //System.out.println(accounts +  accounts.get(0).getHolderName());

        JFrame information = new JFrame();
        String message = "You successfully created an Account" + "\n" +
        "Account Number: " + account.getAccountNumber() + "\n" +
        "Account Name: " + account.getHolderName() + "\n" +
        "Address: " + account.getHolderAddress() + "\n" +
        "Opening Date: " + account.getOpeningDate() + "\n" +
        "Starting Balance: " + account.getHolderBalance();
        
        JOptionPane.showMessageDialog(information,
          message,
          "Account Created",
          JOptionPane.INFORMATION_MESSAGE);
        System.out.println("===============================================" + "\n" +message + "\n" + "===============================================");
    }
    void showAccountDetails(){

    }
    //implement binary search
}