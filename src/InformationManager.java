import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

//this class will manage all the methods to create account, will store all the information and is responsable of manipulating the data. and display.
public class InformationManager {
    public List< Accounts > accounts2 = new ArrayList<Accounts>();

    public AmazingArrayList<Accounts> accounts = new AmazingArrayList<Accounts>();



    int numbersOfAccounts = 0;
  
    

    void createAccount(String holder,String address){
        LocalDateTime time = LocalDateTime.now();
        DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
        String formattedDate = time.format(myFormatObj);

        //first checks if the account numbers are sorted numerically, if theres any gap betweeen accounts, add it#

        Accounts account = new Accounts(numbersOfAccounts, holder, address, formattedDate, 0);
        accounts.add(account);
       // account2.add(account);
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
    Accounts showAccountDetails(int accountNumber){
        String message;
       
        for(Accounts account : accounts){
            if(account.getAccountNumber() == accountNumber){
                message = "===============================================" + "\n" +
                "Account Number: " + account.getAccountNumber() + "\n" +
                "Account Name: " + account.getHolderName() + "\n" +
                "Address: " + account.getHolderAddress() + "\n" +
                "Opening Date: " + account.getOpeningDate() + "\n" +
                "Starting Balance: " + account.getHolderBalance(); 
                System.out.println(message);
                return account;
            }
            
        }
        return null;
        
        
      
    }
    void showAllAccountDetails(){
        if(!accounts.isEmpty()){
        System.out.println("__________________________________________________ \n SHOWING ALL ACCOUNTS");
        
        for(Accounts account : accounts){
            System.out.println("===============================================" + "\n" +
        
        "Account Number: " + account.getAccountNumber() + "\n" +
        "Account Name: " + account.getHolderName() + "\n" +
        "Address: " + account.getHolderAddress() + "\n" +
        "Opening Date: " + account.getOpeningDate() + "\n" +
        "Starting Balance: " + account.getHolderBalance());    
        }
        System.out.println("\n __________________________________________________");}
        else {
            System.out.println("__________________________________________________ \n SHOWING ALL ACCOUNTS");
            System.out.println("no existing accounts");
            System.out.println("\n __________________________________________________");
        }
    }
    //implement binary search
    void deleteAccount(int accountNumber){
        accounts.remove(accounts.get(accountNumber));

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

    

   
}
