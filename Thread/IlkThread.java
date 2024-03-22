public class IlkThread implements Runnable
{
    private int id;
    public IlkThread(int id)
    {
        this.id = id;

    }

    @Override
    public void run() {
        System.out.println("Hello, I am Thread "+id +" Good Bye \n");
    }

    public static void main(String[] args) {

        IlkThread t1= new IlkThread(1);
        IlkThread t2= new IlkThread(2);
        Thread thdr1=new Thread(t1);
        Thread thdr2=new Thread(t2);
        thdr1.start();
        thdr2.start();



    }
}

