import java.util.Queue;

public class ProcessScheduler extends Thread {
    Queue<Process> queue;
    int quantumTimeRR1;
    int quantumTimeRR2;
    CPU cpu;

    public ProcessScheduler(Queue<Process> queue, int quantumTimeRR1, int quantumTimeRR2, CPU cpu) {
        this.queue = queue;
        this.quantumTimeRR1 = quantumTimeRR1;
        this.quantumTimeRR2 = quantumTimeRR2;
        this.cpu = cpu;
    }

    public void run() {
        while (!queue.isEmpty()) {
            Process process = queue.poll();
            long startTime = System.currentTimeMillis();
            int executionTime = determineExecutionTime(process);

            synchronized (cpu) {
                cpu.execute(process, executionTime);
            }

            long endTime = System.currentTimeMillis();

            process.turnaroundTime = (int) endTime - (int) startTime;
            process.waitingTime = process.turnaroundTime - process.burstTime;

            System.out.println("Process " + process.pid + " Turnaround Time: " + process.turnaroundTime);
            System.out.println("Process " + process.pid + " Waiting Time: " + process.waitingTime);
        }
    }

    private int determineExecutionTime(Process process) {
        double rand = Math.random();

        if (rand < 0.6) {
            return Math.min(process.burstTime, quantumTimeRR1);
        } else if (rand < 0.9) {
            return Math.min(process.burstTime, quantumTimeRR2);
        } else {
            return process.burstTime;
        }
    }
}