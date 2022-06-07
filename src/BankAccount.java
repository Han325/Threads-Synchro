public class BankAccount {
    private int x;

    public void setValue(int x) {
        this.x = x;
    }

    public synchronized void incrementBy(int incValue){
        x = x + incValue;
    }

//    public void incrementBy(int incValue) {
//        x = x + incValue;
//
//    }

    public int getValue() {
        return x;
    }
}
