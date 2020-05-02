package sync;

public class U1901Thread extends Thread {
    U1901Bank bankWork;
    int intTrans;
    long lngSleep;

    U1901Thread(U1901Bank bank, int transcost, long timeout){
        this.bankWork = bank;
        this.intTrans = transcost;
        this.lngSleep = timeout;
    }

    @Override
    public void run(){
        bankWork.calc(this.intTrans, this.lngSleep);
    }
}
