package zhewuzhou.me.concurrency;

public class GCSaveExample {
    public static GCSaveExample SAVE_HOOK = null;

    public void isAlive(){
        System.out.println("Yes, I am still alive!");
    }

    @Override
    protected void finalize() throws Throwable {
        super.finalize();
        System.out.println("Finalize methode execute!");
        SAVE_HOOK = this;
    }

    public static void main(String[] args) throws InterruptedException {
        //1st time save
        SAVE_HOOK = new GCSaveExample();
        SAVE_HOOK = null;
        System.gc();
        Thread.sleep(500);
        if(SAVE_HOOK != null){
            SAVE_HOOK.isAlive();
        } else {
            System.out.println("No, I am dead(This is not expected) :( !");
        }

        //the second time
        SAVE_HOOK = null;
        System.gc();
        Thread.sleep(500);
        if(SAVE_HOOK != null){
            SAVE_HOOK.isAlive();
        } else {
            System.out.println("No, I am dead :( !");
        }
    }
}
