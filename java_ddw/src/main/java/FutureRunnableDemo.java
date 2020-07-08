import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

public class FutureRunnableDemo {

    /**
     * 在并发编程时，一般使用runnable，然后扔给线程池完事，这种情况下不需要线程的结果。
     * 所以run的返回值是void类型。
     */


    /**
     * 试验 Java 的 Future 用法
     */

        public static class Task implements Callable<String> {

        /**         *
         * 在非耗时的情况下一个线程执行完了之后就被释放掉了，所以它又回去工作了，所以会出现相同Id的线程
         * @return
         * @throws Exception
         */
            public String call() throws Exception {
                String tid = String.valueOf(Thread.currentThread().getId());
//                Thread.sleep(500);
                System.out.printf("Thread#%s : in call\n", tid);
                return tid;
            }
        }

        public static void main(String[] args) throws InterruptedException, ExecutionException {
            List<Future<String>> results = new ArrayList<Future<String>>();
            ExecutorService es = Executors.newCachedThreadPool();

            /**
             * submit
             */
            for(int i=0; i<100;i++)
                results.add(es.submit(new Task()));

            for(Future<String> res : results)
                System.out.println(res.get());
        }


}
