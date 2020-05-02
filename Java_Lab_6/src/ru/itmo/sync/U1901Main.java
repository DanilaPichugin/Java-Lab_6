package ru.itmo.sync;

public class U1901Main {
    public static void main(String... args) {
        var bankMain = new U1901Bank();
        var threadOne = new U1901Thread(bankMain, 100, 2000);
        threadOne.setName("Thread Bank One");
        threadOne.setPriority(Thread.MAX_PRIORITY);
        threadOne.start();

        var threadTwo = new U1901Thread(bankMain, 50, 300);
        threadTwo.setName("Thread Bank Two");
        threadTwo.setPriority(Thread.MAX_PRIORITY);
        threadTwo.start();

        System.out.printf("Current thread:\n " + Thread.currentThread().getName());
    }
}
