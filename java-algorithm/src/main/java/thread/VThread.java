package thread;

import java.util.List;
import java.util.stream.IntStream;

public class VThread {
    public static void main(String[] args) {

        int max_threads = 1000_000;
        long t = System.currentTimeMillis();
        List<Thread> threads = IntStream.range(0,max_threads)
                .mapToObj(i-> new Thread(() ->{
                    System.out.println("작업 시작: " + Thread.currentThread());
                    try {
                        Thread.sleep(3000);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                    System.out.println("작업 종료");
                }))
                .toList();
//        List<Thread> threads = IntStream.range(0,max_threads)
//                .mapToObj(i-> Thread.ofVirtual().unstarted(() ->{
//                    System.out.println("작업 시작: " + Thread.currentThread());
//                    try {
//                        Thread.sleep(3000);
//                    } catch (InterruptedException e) {
//                        throw new RuntimeException(e);
//                    }
//                    System.out.println("작업 종료");
//                }))
//                .toList();

        threads.forEach(Thread::start);

        threads.forEach(e-> {
            try {
                e.join();
            } catch (InterruptedException ex) {
                throw new RuntimeException(ex);
            }
        });


        System.out.println((System.currentTimeMillis()-t)/1000);
    }
}
