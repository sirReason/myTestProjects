import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Test2 implements Serializable {

    private static final long serialVersionUID = 6232696428067116234L;

    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        List<String> list = new ArrayList<String>();
        for (int i = 0; i < 200; i++) {
            list.add(i, String.valueOf(i));
        }
        System.out.println(list);
        ExecutorService newFixedThreadPool = Executors.newFixedThreadPool(5);
        list.stream().forEach( opTrans -> {
                System.out.println(Thread.currentThread().getName() + " index = " + opTrans.toString());
                if ("3".equals(opTrans.toString())) {
                    try {
                        Thread.sleep(5000);
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
        System.out.println("on the main thread...");
        newFixedThreadPool.shutdown();
        System.out.println("执行任务消耗了 ：" + (System.currentTimeMillis() - start) + "毫秒");
    }
}