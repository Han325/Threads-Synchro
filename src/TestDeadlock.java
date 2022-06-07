import java.util.Random;

public class TestDeadlock {

    private static final int NUM_THREADS = 20;
    private static final int NUM_ACCOUNTS = 5;
    private static final int NUM_ITERATIONS = 100000;

    public static void main(String[] args) {
        final Random rnd = new Random();
        final Account[] accounts = new Account[NUM_ACCOUNTS];

        for (int i = 0; i < accounts.length; i++) {
            accounts[i] = new Account();
        }

        class TransferThread extends Thread {
            @Override
            public void run() {
                super.run();
                for (int i = 0; i < NUM_ITERATIONS; i++){
                    int fromAcct = rnd.nextInt(NUM_ACCOUNTS);
                    int toAcct = rnd.nextInt(NUM_ACCOUNTS);
                    int amt = rnd.nextInt(10);
                    System.out.println(Thread.currentThread().getName()+"Trans. $" + amt + "from Acct" + fromAcct + "to" + toAcct);
                    transferMoney(accounts[fromAcct], accounts[toAcct], amt, fromAcct, toAcct);
                }
            }

            private void transferMoney(Account fromAcct, Account toAcct, int amt, int fromAcctNum, int toAcctNum){
                synchronized (fromAcct){
                    synchronized (toAcct){
                        if(fromAcct.getBalance() < 0){
                            System.out.println("Insufficient Funds");
                            System.exit(1);
                        } else {
                            fromAcct.debit(amt);
                            toAcct.credit(amt);
                        }
                    }
                }
            }


        }

        for(int i = 0; i<NUM_THREADS; i++) new TransferThread().start();
    }



}
