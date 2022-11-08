public class Accounts {
    public int accountNumber;
    public String holderName;
    public String holderPassword;
    public String holderAddress;
    public String openingDate;
    public float holderBalance;
    Accounts(int account,String holder,String password,String address,String date,float balance){
        accountNumber = account;
        holderName = holder;
        holderPassword = password;
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
}
