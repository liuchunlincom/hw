/**
 * Created by Rain on 2017/3/20 15:56.
 */
public class MyThread extends Thread{

    int count = 0;
    int getCount(){
        return this.count;
    }
    public synchronized void run(){
        try {
            /*System.out.println("this.currentThread().getName()--->"+this.currentThread().getName());
            System.out.println("this.currentThread().isAlive()--->"+this.currentThread().isAlive());
            System.out.println("this.d()--->"+this.getName());
            System.out.println("this.isAlive()--->"+this.isAlive());
            System.out.println("Thread.currentThread().getName()--->"+Thread.currentThread().getName());
            System.out.println("Thread.currentThread().isAlive()--->"+Thread.currentThread().isAlive());*/
            sleep(1000);
            for(count=0;count<=10;count++){
suspend();
                System.out.println(this.getName()+"---->"+getCount());
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        MyThread thread = new MyThread();
        MyThread thread2 = new MyThread();
        MyThread thread3 = new MyThread();
        MyThread thread4 = new MyThread();
        MyThread thread5 = new MyThread();
        thread.start();
        thread.start();
        thread.start();
        thread.start();
        thread.start();

    }
}
