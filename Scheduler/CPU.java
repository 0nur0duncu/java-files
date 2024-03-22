public class CPU {
    public void execute(Process process) {
        try {
            Thread.sleep(process.burstTime); // process burst time kadar bekletildi.
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(process.pid + " pid'li process " + process.burstTime + " burst time ile çalıştırıldı.");
    }
}