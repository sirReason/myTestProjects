import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Test5 {
    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        ExecutorService newFixedThreadPool = Executors.newFixedThreadPool(5);
        for (int i = 0; i < 20; i++) {
            final int index = i;
            newFixedThreadPool.execute(() -> {
                System.out.println(Thread.currentThread().getName() + " index = " + index);
                if (index == 3) {
                    try {
                        Thread.sleep(10000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                try {
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    System.out.println("exception");
                }
            });
        }
        System.out.println("on the main thread...");
        newFixedThreadPool.shutdown();
        System.out.println("执行任务消耗了 ：" + (System.currentTimeMillis() - start) + "毫秒");
    }
}