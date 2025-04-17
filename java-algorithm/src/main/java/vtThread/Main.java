package vtThread;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.IntStream;

public class Main {
    private static final ExecutorService virtualThreadExecutor = Executors.newVirtualThreadPerTaskExecutor();
    private static final ExecutorService threadPool = Executors.newFixedThreadPool(200);

    public static void main(String[] args) throws InterruptedException {


        long vElapsedTime = virtualThread(100000);
        long tElapsedTime = thread(100000);

        System.out.println("가상 스레드 :"+vElapsedTime);
        System.out.println("일반 스레드 :"+tElapsedTime);





    }

    public static long thread(int nums) throws InterruptedException {
        long start = System.currentTimeMillis();

        List<Callable<Void>> tasks = IntStream.range(0,nums).mapToObj(i-> (Callable<Void>) () ->{
            System.out.println("작업 번호: :" + i+ ", 현재 스레드: "+Thread.currentThread());
            Thread.sleep(100);
            return null;
        }).toList();

        threadPool.invokeAll(tasks);
        threadPool.shutdown();
        long end = System.currentTimeMillis();

        return end-start;
    }

    public static long virtualThread(int nums) throws InterruptedException {
        long start = System.currentTimeMillis();

        List<Callable<Void>> tasks = IntStream.range(0,nums).mapToObj(i-> (Callable<Void>) () ->{
            System.out.println("작업 번호: :" + i+ ", 현재 스레드: "+Thread.currentThread());
            Thread.sleep(100);
            return null;
        }).toList();

        virtualThreadExecutor.invokeAll(tasks);
        virtualThreadExecutor.shutdown();
        long end = System.currentTimeMillis();

        return end-start;
    }
}
