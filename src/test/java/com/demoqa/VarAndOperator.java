package com.demoqa;

public class VarAndOperator {
    public static void main(String[] args) {
        byte b = -128; // диапазон от -128 до 127!
        short s = 32767; // –32768 до 32767
        int i = 2147483647; // -2 147 483 648 до 2 147 483 647
        long l = 9223372036854775807L; // 9 223 372 036 854 775 808 до 9 223 372 036 854 775 807
        char c = (char) -1;//0 до 65536

        //Переполнение

        int o = i + 1;
        System.out.println("Переполнение = " + o);

        //Математические операции
        int a = 10;
        int plus = a + 2;
        int minus = a - 2;
        int mult = a * 2;
        int div = a / 2;
        int rem = a % 3;
        System.out.println("Результат сложения " + a + " и 2" + " = " + plus);
        System.out.println("Результат вычитания " + a + " и 2" + " = " + minus);
        System.out.println("Результат умножения " + a + " и 2" + " = " + mult);
        System.out.println("Результат деления " + a + " и 2" + " = " + div);
        System.out.println("Результат получение остатка от деления " + a + " и 2" + " = " + rem);

        //Логические операции

        int q = 8;
        int w = 10;
        int e = 10;
        System.out.println(q > w);
        System.out.println(q < w);
        System.out.println(w <= e);
        System.out.println(w >= e);
        System.out.println(q == w);

        //Операции с различными типами данных

        int r = 10;
        double t = 1;

        System.out.println(r + t);


    }
}