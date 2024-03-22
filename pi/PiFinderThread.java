public class PiFinderThread extends Thread
{


    private PointCount countObj;
    private int trialCount;

    public PiFinderThread(PointCount countObj, int trialCount) {
        this.countObj = countObj;
        this.trialCount = trialCount;
    }

    @Override
    public void run() {
        super.run();
        for (int i = 0; i <trialCount ; i++) {

            double x = Math.random();
            double y = Math.random();
            if((Math.pow(x,2)+Math.pow(y,2))<=1)
                countObj.setCount(countObj.getCount()+1);


        }


    }
}
