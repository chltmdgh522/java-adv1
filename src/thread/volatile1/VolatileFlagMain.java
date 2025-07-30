package thread.volatile1;

import static util.MyLogger.log;
import static util.ThreadUtils.sleep;

public class VolatileFlagMain {
    public static void main(String[] args) {
        MyTask task = new MyTask();
        Thread t = new Thread(task, "work");

        log("runFlag = " + task.runFlag);

        t.start();

        sleep(1000);
        log("runFlag를 false로 변경 시도");
        task.runFlag = false;

        log("runFlag = " + task.runFlag);

        log("main 종료");
    }

    static class MyTask implements Runnable {
        // boolean runFlag = true;

        // 캐시 메모리를 직접 사용하지 않아 성능이 느려질 수 있음 필요할때만 사용
        // 즉 바꾼값을 바로 적용
        volatile boolean runFlag = true;

        @Override
        public void run() {
            log("task 시작");

            while (runFlag) {
                // rungFlag가 false로 변하면 탈출

            }
            log("task 종료");
        }
    }

}
