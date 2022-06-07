public class Account {
    private int balance = 10000;

    public int getBalance() {
        return balance;
    }

    public void debit(int amount){
        balance = balance - amount;
    }

    public void credit(int amount){
        balance = balance + amount;
    }
}
