package thread.start;

public class BadThreadMain {
    public static void main(String[] args) {
        System.out.println(Thread.currentThread().getName() + ": main() start");

        HelloThread helloThread = new HelloThread();

        System.out.println(Thread.currentThread().getName() + ": main() start 호출전");

        helloThread.run(); // 이거는 main 스레드가 실행함


        System.out.println(Thread.currentThread().getName() + ": main() start 호출후");

        System.out.println(Thread.currentThread().getName() + ": main() end");


    }
}
