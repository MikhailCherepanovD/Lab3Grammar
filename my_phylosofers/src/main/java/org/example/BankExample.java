package org.example;

public class BankExample {
    public static void main(String[] args) {
        BankAccount sharedAccount = new BankAccount(1000);

        // Создаем два потока, которые будут выполнять транзакции на одном банковском счете
        Thread thread1 = new Thread(new BankTransaction(sharedAccount), "Thread 1");
        Thread thread2 = new Thread(new BankTransaction(sharedAccount), "Thread 2");

        // Запускаем потоки
        thread1.start();
        thread2.start();

        try {
            // Ждем завершения потоков
            thread1.join();
            thread2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Выводим конечный баланс счета
        System.out.println("Final balance: " + sharedAccount.getBalance());
    }
}
