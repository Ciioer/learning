package MyTest.Multithreading;

public class _12Test {
    public static Boolean isThreadA = true;
    public static Boolean isThreadB = false;
    static final _12Test _12TEST = new _12Test();

    static class Thread1 implements Runnable {
        public void run() {
            for (int i = 0; i < 3; i++) {
                synchronized (_12TEST) {
                    while (!isThreadA) {
                        try {
                            _12TEST.wait();
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                    System.out.print(1);
                    isThreadA = false;
                    isThreadB = true;
                    _12TEST.notifyAll();
                }
            }
        }
    }

    static class Thread2 implements Runnable {
        public void run() {
            for (int i = 0; i < 3; i++) {
                synchronized (_12TEST) {
                    while (!isThreadB) {
                        try {
                            _12TEST.wait();
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                    System.out.print(2);
                    isThreadA = true;
                    isThreadB = false;
                    _12TEST.notifyAll();
                }
            }
        }
    }

    public static void main(String[] args) {
        Thread1 th1 = new Thread1();
        Thread2 th2 = new Thread2();
        Thread thread1 = new Thread(th1);
        Thread thread2 = new Thread(th2);
        thread1.start();
        thread2.start();

    }
}
