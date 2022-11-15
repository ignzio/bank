import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;


public class Accounts {
    private int accountNumber;
    private String holderName;
    private String holderAddress;
    private String openingDate;
    private float holderBalance;
    private ArrayList<Transaction> transactions = new ArrayList<Transaction>();
    
    
    Accounts(int account,String holder,String address,String date,float balance){
        accountNumber = account;
        holderName = holder;
        holderAddress = address;
        openingDate = date;
        holderBalance = balance;
    }
    public int getAccountNumber(){
        return accountNumber;

        
    }
    public String getHolderName(){
        return holderName;
    }
    public String getHolderAddress(){
        return holderAddress;
    }
    public String getOpeningDate(){
        return openingDate;
    }
    public float getHolderBalance(){
        return holderBalance;
    }
    public ArrayList<Transaction> geTransactions(){
        return transactions;

    }

    public void addTransaction(Transaction t){
        if(transactions.size() < 6){
            transactions.add(t);
        }
        else{
            transactions.remove(0);
            transactions.add(t);
        }
    }

    public void displayTransactions(){
        System.out.println("Transactions of: " + holderName + "\n Account Number: " + accountNumber);
        

        Collections.sort(transactions, new Comparator<Transaction>() {
            @Override
            public int compare(Transaction o1, Transaction o2) {
                return Float.compare(o1.getAmmount(), o2.getAmmount());
            }   
        });
        
        for(Transaction t : transactions){
            System.out.println("----------------------------------------------------");
            t.displayData();
        }
        System.out.println("----------------------------------------------------");
    }


}
