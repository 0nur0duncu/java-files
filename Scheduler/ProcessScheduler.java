import java.util.Queue;

public class ProcessScheduler extends Thread {
    Queue<Process> queue;
    int quantumTime;
    double percentage;
    CPU cpu;

    public ProcessScheduler(Queue<Process> queue, int quantumTime, double percentage, CPU cpu) {
        this.queue = queue;
        this.quantumTime = quantumTime;
        this.percentage = percentage;
        this.cpu = cpu;
    }

    @Override
    public void run() {
        while (!queue.isEmpty()) {
            Process process = queue.poll();
            process.turnaroundTime = (int)System.currentTimeMillis();
            cpu.execute(process);
            process.turnaroundTime = (int)System.currentTimeMillis() - process.turnaroundTime;
            process.waitingTime = process.turnaroundTime - process.burstTime;
            System.out.println("Process " + process.pid + " Turnaround Time: " + process.turnaroundTime);
            System.out.println("Process " + process.pid + " Waiting Time: " + process.waitingTime);
        }
    }
}