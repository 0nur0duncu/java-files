public class CPU {
    public void execute(Process process, int executionTime) {
        try {
            Thread.sleep(executionTime);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(process.pid + " pid'li process " + process.burstTime + " burst time ile çalıştırıldı.");
    }
}