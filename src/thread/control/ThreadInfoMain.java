package thread.control;

import thread.start.HelloRunnable;

import static util.MyLogger.log;

public class ThreadInfoMain {
    public static void main(String[] args) {
        // main 스레드
        Thread mainThread = Thread.currentThread();

        log("mainThread = " + mainThread);
        log("mainThread.threadId()=" + mainThread.threadId());
        log("mainThread.getName()=" + mainThread.getName());

        // 우선순위가 높을 수록 더 많이 실행될 수 있음 운영체제가 알아서 하기때문에 우리가 조정할 일은 없음
        log("mainThread.getPriority()=" + mainThread.getPriority());
        log("mainThread.getThreadGroup()=" + mainThread.getThreadGroup());
        log("mainThread.getState()=" + mainThread.getState());

        System.out.println();

        // my스레드
        Thread myThread = new Thread(new HelloRunnable(), "myThread");

        log("myThread = " + myThread);
        log("myThread.threadId()=" + myThread.threadId());
        log("myThread.getName()=" + myThread.getName());
        log("myThread.getPriority()=" + myThread.getPriority());

        // 스레드 그룹은 잘 사용하지 않음 이런게 있구나!
        log("myThread.getThreadGroup()=" + myThread.getThreadGroup());

        // 스레드 생성만 하고 실행 안하면 new임!
        log("myThread.getState()=" + myThread.getState());
    }
}
