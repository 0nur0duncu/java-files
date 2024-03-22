public class Driver {


    public static void main(String[] args) {

        MutableInteger sum = new MutableInteger();
        int upper = 1000;
        Thread threadObj = new Summation(upper,sum);
        threadObj.start();
        Thread threadObj2 = new Summation(2000,sum);
        threadObj2.start();
        for (int i = 0; i <1000 ; i++) {
            System.out.println(sum.getValue());
        }

        try{
            threadObj.join();
        }
        catch (Exception e)
        {

            System.out.println(e.getMessage());

        }

        System.out.println("Finally "+sum.getValue());


    }


}
