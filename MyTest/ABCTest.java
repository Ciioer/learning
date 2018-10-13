package MyTest;

public class ABCTest {
    public final static  ABCTest abcTest = new ABCTest();
    public  static int index =0;
    static  class  ThreadA implements Runnable{
        private String name;
        private int printTimes;
        public  ThreadA(String name,int printTimes){
            this.name =name;
            this.printTimes =printTimes;
        }
        public void run(){
            for (int i = 0; i < printTimes;) {
                synchronized (abcTest){
                    while(index%2!=0){
                        try {
                            abcTest.wait();
                        }catch(Exception e){
                            e.printStackTrace();
                        }
                    }
                    System.out.print(name);
                    index++;
                    i++;
                }
            }
        }
    }
    static class  ThreadB implements Runnable{
        private String name;
        private int printTimes;
        public  ThreadB(String name,int printTimes){
            this.name =name;
            this.printTimes =printTimes;
        }
        public void run(){
            for (int i = 0; i < printTimes;) {
                synchronized (abcTest){
                    while(index%2!=1){
                        try {
                            abcTest.wait();
                        }catch(Exception e){
                            e.printStackTrace();
                        }
                    }
                    System.out.print(name);
                    index++;
                    i++;
                }
            }
        }
    }
    public static void main(String[] args){
        ThreadA threadA =new ThreadA("A",3);
        ThreadB threadB =new ThreadB("B",3);
        Thread thA =new Thread(threadA);
        Thread thB =new Thread(threadB);
        thA.start();
        thB.start();
    }
}
