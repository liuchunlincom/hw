/**
 * Created by Rain on 2017/3/22 9:54.
 */
public class MyThresd2 extends Thread {
    private long i=0;
    public void run(){
        while (true){
            i++;
            System.out.println(i);
        }
    }

    public static void main(String[] args) {
        MyThresd2 myThresd = new MyThresd2();
        myThresd.start();
        //Thread.sleep(1000);
        myThresd.suspend();
        System.out.println("main end");
        //myThresd.resume();
    }
}
