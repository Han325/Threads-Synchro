public class TestClass {
    public static void main(String[] args) {
        MyThread NewThreadName = new MyThread();
        NewThreadName.start();

        MyThreadRunnable NewInstance = new MyThreadRunnable();
        Thread NewThreadRunnable = new Thread(NewInstance);
        NewThreadRunnable.start();
    }
}
