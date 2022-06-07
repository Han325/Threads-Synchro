public class Person implements Runnable {
    BankAccount bankAccount;

    public Person(BankAccount bankAccount) {
        this.bankAccount = bankAccount;
    }

    @Override
    public void run() {
        for (int x = 0; x < 1000; x++) {
            this.bankAccount.incrementBy(1);
        }


    }
}
