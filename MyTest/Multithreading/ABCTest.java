package MyTest.Multithreading;

public class ABCTest {
    public static Boolean isThreadA = true;
    public static Boolean isThreadB = false;
    public static Boolean isThreadC = false;
    final static ABCTest ABC_TEST = new ABCTest();
    static class ThreadA implements Runnable {
        private String name;

        public ThreadA(String name) {
            this.name = name;
        }

        public void run() {
            for (int i = 0; i < 10; i++) {
                synchronized (ABC_TEST) {
                    while (!isThreadA) {
                        try {
                            ABC_TEST.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    System.out.print(name);
                    isThreadA = false;
                    isThreadB = true;
                    isThreadC = false;
                    ABC_TEST.notifyAll();
                }
            }
        }
    }

    static class ThreadB implements Runnable {
        private String name;

        public ThreadB(String name) {
            this.name = name;
        }

        public void run() {
            for (int i = 0; i < 10; i++) {
                synchronized (ABC_TEST) {
                    while (!isThreadB) {
                        try {
                            ABC_TEST.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    System.out.print(name);
                    isThreadA = false;
                    isThreadB = false;
                    isThreadC = true;
                    ABC_TEST.notifyAll();
                }
            }
        }
    }

    static  class ThreadC implements Runnable {
        private String name;

        public ThreadC(String name) {
            this.name = name;
        }

        public void run() {
            for (int i = 0; i < 10; i++) {
                synchronized (ABC_TEST) {
                    while (!isThreadC) {
                        try {
                            ABC_TEST.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    System.out.print(name);
                    isThreadA = true;
                    isThreadB = false;
                    isThreadC = false;
                    ABC_TEST.notifyAll();
                }
            }
        }
    }
    public static void main(String[] args) {
         ThreadA threadA = new ThreadA("A");
         ThreadB threadB = new ThreadB("B");
         ThreadC threadC = new ThreadC("C");
         Thread tha =new Thread(threadA);
          tha.start();
          Thread thb =new Thread(threadB);
          thb.start();
          Thread thc =new Thread(threadC);
          thc.start();
    }
}
