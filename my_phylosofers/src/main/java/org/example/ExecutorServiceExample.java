package org.example;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

import java.util.concurrent.Callable;
import java.util.concurrent.Executors;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.Arrays;
import java.util.List;

public class ExecutorServiceExample {

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(3);

        // Определяем задачи
        Callable<Void> task1 = () -> {
            System.out.println("Задача 1 выполняется в потоке " + Thread.currentThread().getName());
            return null; // Callable<Void> требует возвращения значения, поэтому здесь возвращается null
        };

        Callable<Void> task2 = () -> {
            System.out.println("Задача 2 выполняется в потоке " + Thread.currentThread().getName());
            return null;
        };

        Callable<Void> task3 = () -> {
            System.out.println("Задача 3 выполняется в потоке " + Thread.currentThread().getName());
            return null;
        };

        // Отправляем задачи на выполнение
        List<Callable<Void>> tasks = Arrays.asList(task1, task2, task3);

        try {
            List<Future<Void>> results = executorService.invokeAll(tasks);

            // Можно использовать results, чтобы проверить статус выполнения каждой задачи
            for (Future<Void> result : results) {
                if (result.isDone()) {
                    System.out.println("Задача выполнена успешно");
                } else {
                    System.out.println("Задача не выполнена");
                }
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Завершаем работу ExecutorService
        executorService.shutdown();
    }
}