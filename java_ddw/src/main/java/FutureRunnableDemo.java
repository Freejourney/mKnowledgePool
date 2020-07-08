
public class FutureRunnableDemo {

    /**
     * 在并发编程时，一般使用runnable，然后扔给线程池完事，这种情况下不需要线程的结果。
     * 所以run的返回值是void类型。
     */


    public static void main(String[] args) {
        System.out.println("print sth");
    }
}
