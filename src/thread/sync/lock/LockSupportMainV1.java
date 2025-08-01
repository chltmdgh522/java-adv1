package thread.sync.lock;

import java.util.concurrent.locks.LockSupport;

import static util.MyLogger.log;
import static util.ThreadUtils.sleep;

public class LockSupportMainV1 {
    public static void main(String[] args) {
        Thread thread1 = new Thread(new ParkTest(), "Thread-1");
        thread1.start();

        //잠시 대기하여 Thread-1이 park 상태의 빠질 시간을 준다.
        sleep(100);
        log("Thread-1 state: " + thread1.getState());

        log("main -> unpark(Thread-1)");
         LockSupport.unpark(thread1); // 1. unpark 사용
        // thread1.interrupt(); // 2. interrupt() 사용
        // 즉 wating 상태의 스레드는 인터럽트 걸어서 중간에 깨울 수 있다. blocked 못깨움
    }

    static class ParkTest implements Runnable{

        @Override
        public void run() {
            log("park 시작");
            LockSupport.park();
            log("park 종료, state: " + Thread.currentThread().getState());
            log("인터럽트 상태: " + Thread.currentThread().isInterrupted());
        }
    }
}
