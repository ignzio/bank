import java.util.Comparator;

public class Transaction implements Comparator<Transaction>{
    private String transactionType;
    private float transactionAmmount;
    private String transactionDate;
    Transaction(String type,float ammount,String date){
        transactionType = type;
        transactionAmmount = ammount;
        transactionDate = date;
    }

    public void displayData(){
        System.out.println("=================================");
        System.out.println("type: " + transactionType);
        System.out.println("ammount: " + transactionAmmount);
        System.out.println("date: " + transactionDate);
        System.out.println("=================================");
    }
    public float getAmmount(){
        return transactionAmmount;
    }

    @Override
    public int compare(Transaction o1, Transaction o2) {
        // TODO Auto-generated method stub
        return 0;
    }

   


    
}