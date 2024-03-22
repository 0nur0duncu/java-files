public class DrivePiFinder {


    final static  int THREADCOUNT =8;
    final static  double TRIALCOUNT = 10E6;
    public static void main(String[] args) throws InterruptedException {

        Thread [] threadArray= new Thread[THREADCOUNT];
        PointCount [] pointCounts=new PointCount[THREADCOUNT];
        double globalSum= 0.0;
        double pi=0.0;

        for (int i = 0; i <THREADCOUNT ; i++) {
            pointCounts[i] = new PointCount();
            threadArray[i] = new PiFinderThread(pointCounts[i],(int)TRIALCOUNT/THREADCOUNT);
            threadArray[i].start();

        }
        for (int i = 0; i <THREADCOUNT ; i++) {
            threadArray[i].join();
        }
        for (int i = 0; i <THREADCOUNT ; i++) {
            globalSum+=pointCounts[i].getCount();
        }

        pi=4.0*globalSum/TRIALCOUNT;
        System.out.printf("The Pi we found is %e for trialCount %e\n",pi, TRIALCOUNT);



    }
}
