package sync;

import jdk.swing.interop.SwingInterOpUtils;

import java.util.TreeMap;

public class U1901Bank {
    int intTo;
    int intFrom = 220;

    synchronized void calc(int intTransaction, long lngTimeout){
        System.out.printf("Before all:%s, to:%d, from:%d\n", Thread.currentThread().getName(), intTo, intFrom);
        intFrom -= intTransaction;
        try {
            Thread.sleep(lngTimeout);
        }catch (InterruptedException e){
            e.printStackTrace();
        }
        intTo += intTransaction;
        System.out.printf("After all:%s, to:%d, from:%d\n", Thread.currentThread().getName(), intTo, intFrom);
    }

}
