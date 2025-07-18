package thread.control.interrupt;

import static util.MyLogger.log;
import static util.ThreadUtils.sleep;

public class ThreadStopMainV4 {
    public static void main(String[] args) {
        MyTask myTask = new MyTask();
        Thread thread = new Thread(myTask, "work");
        thread.start();

        sleep(1000);
        log("작업 중단 지시 thread.interrupt()");
        thread.interrupt();
        log("work 스레드 인터럽트 상태1 = " + thread.isInterrupted());

    }

    static class MyTask implements Runnable {

        @Override
        public void run() {

            // 인터럽트 상태 변경 O 여기서 상태 바로 바꿈 이전은 체크 용도였다면 즉 이친구는 걍 초기화 역할 false로!
            while (!Thread.interrupted()) {
                log("작업 중");
            }

            // 얘는 false 왜 이전 예제에서는 상태가 터지면 바로 flase로 바꼈을까
            // 그 이유는 책 참고

            log("work 스레드 인터럽트 상태2 = " + Thread.currentThread().isInterrupted());

            try {
                log("자원 정리 시도");

                Thread.sleep(10000);
                log("자원 정리 완료");
            } catch (InterruptedException e) {
                log("자원 정리 실패 - 자원 정리 중 인터럽트 발생");
                log("work 스레드 인터럽트 상태3 = " + Thread.currentThread().isInterrupted());

            }

            log("작업 종료");

        }

    }

}
