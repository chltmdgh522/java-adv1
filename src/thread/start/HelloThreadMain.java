package thread.start;

public class HelloThreadMain {
    public static void main(String[] args) {
        System.out.println(Thread.currentThread().getName() + ": main() start");

        HelloThread helloThread = new HelloThread();

        System.out.println(Thread.currentThread().getName() + ": main() start 호출전");

        helloThread.start();
        // 반드시 호출해야 스택 공간을 할당 받음 즉 스레드가 작동하게 됨
        // main 스레드는 저걸 기다리지 않음 바로 실행 저거 실행하면 해당 스레드가 실행

        System.out.println(Thread.currentThread().getName() + ": main() start 호출후");

        System.out.println(Thread.currentThread().getName() + ": main() end");


    }
}
