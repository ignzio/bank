
/*
 * Class Transaction
 * this class will rapresent A transaction that holds the type of operation
 * an ammount of money that has been trasfered in the account
 * and the date in wich the trasaction has been made
 * 
 */
public class Transaction{
    private String transactionType;
    private float transactionAmmount;
    private String transactionDate;
    Transaction(String type,float ammount,String date){
        transactionType = type;
        transactionAmmount = ammount;
        transactionDate = date;
    }
    //this method will display all the data of the transaction object
    public void displayData(){
        System.out.println("=================================");
        System.out.println("type: " + transactionType);
        System.out.println("ammount: " + transactionAmmount);
        System.out.println("date: " + transactionDate);
        System.out.println("=================================");
    }
    //get method for transactionType
    public String getType(){
        return transactionType;
    }
    //get method for transactionAmmount
    public float getAmmount(){
        return transactionAmmount;
    }
    //get method for transactionDate
    public String getDate(){
        return transactionDate;
    }
    
}