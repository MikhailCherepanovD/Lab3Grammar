package org.example;

import java.util.ArrayList;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    static GrammarGenerator generator;
    static GrammarChecker checker;
    public static ArrayList<String> preprocessStr(String str) {

        str=str.trim();
        String lastChar = str.substring(str.length() - 1);

        str = str.substring(0, str.length() - 1);
        str = str.replaceAll("[^a-zA-Z0-9 -]", "");

        ArrayList<String> result = new ArrayList<>();
        // Разделяем строку по пробелам
        String[] words = str.split("\\s+");

        for (String word : words) {
            word=word.toLowerCase();
            result.add(word);
        }

        result.add(lastChar);
        for (int i = 0; i < result.size(); i++) {
            String word = result.get(i);
            if (word.equalsIgnoreCase("hadn't") || word.equalsIgnoreCase("hadnt")) {
                // Заменяем "hadn't" на "had not"
                result.set(i, "had");
                // Вставляем "not" после "had"
                result.add(i + 1, "not");
            }
        }
        return result;
    }


    public static boolean CheckStr(String str) {
        if(str.length()==0){
            return false;
        }
        ArrayList<String> tokens = new ArrayList<>();
        tokens= preprocessStr(str);
        checker.setTokens(tokens);

        String lastWord=tokens.get(tokens.size()-1);
        try {
            if(lastWord.equals("?")) {
                checker.SentenceQ();
                System.out.println("Вопросительное предложение в Past perfect passive voice!");
            }
            else if(lastWord.equals(".") && tokens.contains("not")) {
                checker.SentenceN();

                System.out.println("Отрицательное предложение в Past perfect passive voice!");
            }
            else if(lastWord.equals(".")) {
                checker.SentenceP();
                System.out.println("Утвердительное предложение в Past perfect passive voice!");
            }
            else {
                System.out.println("Предложение в моем подмножестве языка всегда должно заканчиваться точкой или вопросительным знаком!\n " +
                        "Попробуйте еще раз.");
            }
            return true;
        } catch (RuntimeException e) {
            String message = e.getMessage();
            switch (message) {
                case "0":
                    System.out.println("Предложение не является предложением в Past perfect passive voice, \n" +
                            "Или взяты слова не из выбранного подмножества языка.");
                    break;
                case "1" :
                    System.out.println("Предложение не является предложением в Past perfect passive voice, \n" +
                            "Или взяты слова не из выбранного подмножества языка.");
                    break;
                case "2":
                    System.out.println("Основная часть предложения распознана корректно, но в придаточной части допущены ошибки!\n " +
                            "Придаточная часть может находится только в Past simple!");
                    break;
                default:
                    System.out.println("Неизвестная ошибка!");
                    break;
            }
            return false;
        }

    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        checker = new GrammarChecker();
        generator = new GrammarGenerator();
        boolean flag;
/*        for(int i=0;i<1000;i++){
            String newSent = generator.GenerateP();
            String newSent1 = generator.GenerateN();
            String newSent2 = generator.GenerateQ();
            flag=CheckStr(newSent);
            if(!flag)
                System.out.println(newSent);
            flag=CheckStr(newSent1);
            if(!flag)
                System.out.println(newSent);
            flag=CheckStr(newSent2);
            if(!flag)
                System.out.println(newSent);
        }*/
        while(true){
            System.out.println("\nДля проверки предложения введите 1;\n" +
                    "Для генерации введите 2;\n" +
                    "Для выхода введите Q");
            String action = scanner.nextLine();
            if(action.equals("1")) {// проверить
                System.out.println("Введите предложение:");
                String str = scanner.nextLine();
                CheckStr(str);
            }
            else if(action.equals("2")) {// сгенерировать
                System.out.println("Для генерации утвердительного предложения введите 1:\n" +
                        "Для генерации отрицательного предложения введите 2:\n" +
                        "Для генерации вопросительного предложения введите 3:");

                String str = scanner.nextLine();
                String newSent;
                if(str.equals("1")) {
                    newSent = generator.GenerateP();
                }
                else if(str.equals("2")) {
                    newSent = generator.GenerateN();
                }
                else if(str.equals("3")) {
                    newSent = generator.GenerateQ();
                }
                else{
                    System.out.println("Некорректный ввод! Попробуйте снова:");
                    break;
                }

                System.out.println(newSent);
            }
            else if(action.equals("Q")) {// выход
                break;
            }
            else{
                System.out.println("Некорректный ввод! Попробуйте снова:");
            }
        }

    }
}




/*Terrible  Terrible Terrible Terrible Terrible Terrible He had been believed cat before she chewed confidently before she chewed confidently before she chewed confidently before she chewed confidently before she chewed confidently.
 */
