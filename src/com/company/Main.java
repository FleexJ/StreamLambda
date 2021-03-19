package com.company;

import jdk.dynalink.Operation;

import javax.lang.model.element.Element;
import java.beans.Expression;
import java.lang.reflect.Array;
import java.util.*;
import java.util.concurrent.Callable;
import java.util.function.BiFunction;
import java.util.function.DoubleFunction;
import java.util.function.Function;
import java.util.function.UnaryOperator;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {

    //Одна функция, которая выполняет любую операцию над двумя числами
    public static double calculate(double a, double b, BiFunction<Double, Double, Double> function) {
        return function.apply(a, b);
    }

    //Распарсить запрос на переменная - значение, игнорировать значения null
    public static String z2208() {
        List<String> list = Arrays.asList("name", "Ivanov", "country", "Ukraine", "city", "Kiev", "age", null);
        String result = "";
        for (int i = 0; i < list.size(); i++) {
            if (i % 2 != 0 && list.get(i) != null) {
                result += list.get(i - 1) + " = '" + list.get(i) + "' and ";
            }
        }
        return result.substring(0, result.length() - 4);
    }

    //Взять от строки только числа без букв
    public static void z1908() {
        String file1 = "12 text var2 14 8v 1";
        String file2 = Arrays.stream(file1.split(" "))
                .filter(s -> s.matches("^\\d+$"))
                .collect(Collectors.joining(" "));
        System.out.println(file2);
    }

    //Подсчитать количество слов в тексте
    public static void z1907() {
        String file1 = "The ASCII table was created for the exchange of information via teletype. The set included non-printable characters used as commands to control the TTY. Similar commands were used in other pre-computer messaging tools (Morse code, semaphore alphabet), taking into account the specifics of the device.\n" +
                "Most of the ASCII control characters soon lost their purpose and are not used in modern computer systems.";
        int count = file1.split("\\W+").length;
        System.out.println(count);
    }

    //Считать с клавиатуры несколько строк, составить частотный словарь на основе этих строк
    public static void z1016() {
        Scanner scanner = new Scanner(System.in);
        HashMap<String, Integer> hashMap = new HashMap<>();
        for (int i = 0; i < 10; i++) {
            System.out.print("Input " + (i + 1) + " string: ");
            String word = scanner.nextLine();
            hashMap.merge(word, 1, Integer::sum);
        }
        scanner.close();
        hashMap.forEach((key,v) -> System.out.println(key + ":\t" + v));
    }

    //Распарсить текст на символы, составить частотный словарь на основе символов
    public static void z1821() {
        String file1 = "The ASCII table was created for the exchange of information via teletype. The set included non-printable characters used as commands to control the TTY. Similar commands were used in other pre-computer messaging tools (Morse code, semaphore alphabet), taking into account the specifics of the device.\n" +
                "Most of the ASCII control characters soon lost their purpose and are not used in modern computer systems.";
        HashMap<String, Integer> hashMap = new HashMap<>();
        Arrays.stream(file1.split(""))
                .sorted()
                .forEach(s -> {
                    if (s.equals("\n"))
                        hashMap.merge("\\n", 1, Integer::sum);
                    else
                        hashMap.merge(s, 1, Integer::sum);
                });
        for (Map.Entry<String, Integer> entry : hashMap.entrySet()) {
            System.out.println(entry.getKey() + ":\t" + entry.getValue());
        }
    }


    //Распасрить текст на слова через пробел, в новой строке должны быть эти слова, длина которых больше 6, деление через ','
    public static void z1925() {
        String file1 = "The ASCII table was created for the exchange of information via teletype";
        String file2 = Arrays.stream(file1.split(" "))
                .filter(s -> s.length() > 6)
                .collect(Collectors.joining(","));
        System.out.println(file2);
    }

    public static void main(String[] args) {
//        BiFunction<Double, Double, Double> sum = (a, b) -> a + b;
//        BiFunction<Double, Double, Double> mult = (a, b) -> a * b;
//        BiFunction<Double, Double, Double> div = (a, b) -> a / b;
//        BiFunction<Double, Double, Double> diff = (a, b) -> a - b;
//        BiFunction<Double, Double, Double> sqrt = (a, b) -> Math.pow(a, 1 / b);
//        BiFunction<Double, Double, Double> sqr = (a, b) -> Math.pow(a, b);
//        BiFunction<Double, Double, Double> d117 = (a, b) -> Math.pow((a + b) / (a + 117), 2);
//        System.out.println(
//                "Sum: " +
//                calculate(10, 30, sum)
//        );
//        System.out.println(
//                "Mult: " +
//                calculate(5, 5, mult)
//        );
//        System.out.println(
//                "Div: " +
//                        calculate(25, 5, div)
//        );
//        System.out.println(
//                "Diff: " +
//                        calculate(10, 5, diff)
//        );
//        System.out.println(
//                "Sqrt: " +
//                        calculate(125, 3, sqrt)
//        );
//        System.out.println(
//                "Sqr: " +
//                        calculate(5, 3, sqr)
//        );
//        System.out.println(
//                "d117: " +
//                        calculate(3, 5, d117)
//        );

//        System.out.println(z2208());

//        z1908();

//        z1907();

//        z1016();

        z1821();

//        z1925();
    }
}
