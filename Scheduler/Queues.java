import java.util.Queue;
import java.util.Random;
import java.util.LinkedList;

public class Queues {
    public static void main(String[] args) {
        CPU cpu = new CPU();

        int kuyrukBasinaProcessSayisi = 1000;

        Queue<Process> rr1Kuyrugu = generateQueue(kuyrukBasinaProcessSayisi);
        Queue<Process> rr2Kuyrugu = generateQueue(kuyrukBasinaProcessSayisi);
        Queue<Process> fcfsKuyrugu = generateQueue(kuyrukBasinaProcessSayisi);

        ProcessScheduler rr1Scheduler = new ProcessScheduler(rr1Kuyrugu, 8, 0.6, cpu);
        ProcessScheduler rr2Scheduler = new ProcessScheduler(rr2Kuyrugu, 16, 0.3, cpu);
        ProcessScheduler fcfsScheduler = new ProcessScheduler(fcfsKuyrugu, Integer.MAX_VALUE, 0.1, cpu);

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

        System.out.println("Simülasyon Tamamlandı...");
    }

    private static Queue<Process> generateQueue(int processSayisi) {
        Queue<Process> queue = new LinkedList<>();
        Random random = new Random();

        for (int pid = 1; pid <= processSayisi; pid++) {
            int burstTime = random.nextInt(20) + 1;
            queue.add(new Process(pid, burstTime));
        }

        return queue;
    }
}