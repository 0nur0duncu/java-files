public class Process {
    int pid;
    int burstTime;
    int waitingTime;
    int turnaroundTime;

    public Process(int pid, int burstTime) {
        this.pid = pid;
        this.burstTime = burstTime;
        this.waitingTime = 0;
        this.turnaroundTime = 0;
    }
}
