import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;

public class MultiLevelQueue {
    public static void main(String[] args) {
        CPU cpu = new CPU();

        int numProcessesPerQueue = 1000;

        Queue<Process> rr1Queue = generateQueue(numProcessesPerQueue);
        Queue<Process> rr2Queue = generateQueue(numProcessesPerQueue);
        Queue<Process> fcfsQueue = generateQueue(numProcessesPerQueue);

        ProcessScheduler rr1Scheduler = new ProcessScheduler(rr1Queue, 8, 16, cpu);
        ProcessScheduler rr2Scheduler = new ProcessScheduler(rr2Queue, 16, 32, cpu);
        ProcessScheduler fcfsScheduler = new ProcessScheduler(fcfsQueue, Integer.MAX_VALUE, Integer.MAX_VALUE, cpu);

        rr1Scheduler.start();
        rr2Scheduler.start();
        fcfsScheduler.start();

        try {
            rr1Scheduler.join();
            rr2Scheduler.join();
            fcfsScheduler.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        calculateAverages(rr1Queue, "RR1");
        calculateAverages(rr2Queue, "RR2");
        calculateAverages(fcfsQueue, "FCFS");

        System.out.println("Simulation completed.");
    }

    private static Queue<Process> generateQueue(int numProcesses) {
        Queue<Process> queue = new LinkedList<>();
        Random random = new Random();

        for (int pid = 0; pid < numProcesses; pid++) {
            int burstTime = random.nextInt(20) + 1;
            queue.add(new Process(pid, burstTime));
        }

        return queue;
    }

    private static void calculateAverages(Queue<Process> queue, String queueName) {
        int totalWaitingTime = 0;
        int totalTurnaroundTime = 0;

        for (Process process : queue) {
            totalWaitingTime += process.waitingTime;
            totalTurnaroundTime += process.turnaroundTime;
        }

        double avgWaitingTime = (double) totalWaitingTime / queue.size();
        double avgTurnaroundTime = (double) totalTurnaroundTime / queue.size();

        System.out.println("Average Waiting Time for " + queueName + ": " + avgWaitingTime);
        System.out.println("Average Turnaround Time for " + queueName + ": " + avgTurnaroundTime);
    }
}
