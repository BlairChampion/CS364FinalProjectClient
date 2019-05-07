public class Worker implements Runnable{

    private long factor;
    private long result;

    public long getResult(){
        return result;
    }

    public Worker(long factor){
        this.factor = factor;
    }

    private static int getFactor(Long a){
        if (a%2 == 0){
            return 2;
        }
        for (int i = 3; i <= (a/2); i=i+2 ) {
            if (a%i == 0){
                return i;
            }
        }
        return 0;
    }

    @Override
    public void run() {
        this.result = getFactor(factor);
    }

}
