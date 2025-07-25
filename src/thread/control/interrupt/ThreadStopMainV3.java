package thread.control.interrupt;

import static util.MyLogger.log;
import static util.ThreadUtils.sleep;

public class ThreadStopMainV3 {
    public static void main(String[] args) {
        MyTask task = new MyTask();
        Thread thread = new Thread(task, "work");
        thread.start();
        sleep(100); // 시간을 줄임
        log("작업 중단 지시 - thread.interrupt()");
        thread.interrupt();
        log("work 스레드 인터럽트 상태1 = " + thread.isInterrupted());
    }

    static class MyTask implements Runnable {
        @Override
        public void run() {
            while (!Thread.currentThread().isInterrupted()) { // 인터럽트 상태 변경X
                log("작업 중");
            }
            log("work 스레드 인터럽트 상태2 = " +
                    Thread.currentThread().isInterrupted());
            try {
                log("자원 정리 시도");
                // 자원 정리중 인터럽트 발생하지 않길 원하는데 sleep 만나면 터짐...
                Thread.sleep(1000);
                log("자원 정리 완료");
            } catch (InterruptedException e) {
                log("자원 정리 실패 - 자원 정리 중 인터럽트 발생");
                log("work 스레드 인터럽트 상태3 = " +
                        Thread.currentThread().isInterrupted());
            }
            log("작업 종료");
        }
    }
}