package MyTest.Multithreading;

import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class BoundedQueueTest<T> {
    private Object[] items;
    private Lock lock = new ReentrantLock();
    private Condition notfull = lock.newCondition();
    private Condition notEmpty = lock.newCondition();
    private int addIndex, removeIndex, count;

    public BoundedQueueTest(int size) {
        items = new Object[size];
    }

    public void add(T t) throws InterruptedException {
        lock.lock();
        try {
            System.out.println("存放值"+t);
            while (count == items.length) {
                System.out.println("队列已满，阻塞put线程");
                notfull.await();
            }
            items[addIndex++] = t;
            if (addIndex == items.length) {
                addIndex = 0;
            }
            count++;
            notEmpty.signal();
        } finally {
            lock.unlock();
        }
    }

    public T remove() throws InterruptedException {
        lock.lock();
        try {
            while (count == 0) {
                System.out.println("队列空了，阻塞take线程");
                notEmpty.await();
            }
            Object x = items[removeIndex++];
            if (removeIndex == items.length) {
                removeIndex = 0;
            }
            count--;
            notfull.signal();
            System.out.println("取值"+x);
            return (T) x;
        } finally {
            lock.unlock();
        }
    }
    public static void main(String[] args) {
        //启动一个子线程，不断的生产元素
        final BoundedQueueTest<Integer> queue = new BoundedQueueTest<Integer>(2);
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                for(int i=0;i<10;i++){
                    try {
                        queue.add(i);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });
        try {
            thread.join();
            thread.start();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        //主线程不断的获取，显然最后，主线程会阻塞
        for(int i=0;i<15;i++){
            try {
              queue.remove();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }


}
