package com.company;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.function.DoubleFunction;
import java.util.function.IntPredicate;


public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        String[] inputSplit = sc.nextLine().split(" ");
        ArrayList<Integer> userInputs = new ArrayList<>();

        for (int i = 0; i < inputSplit.length; i++) {
            String s = inputSplit[i];
            userInputs.add(Integer.parseInt(s));
        }

        System.out.println("1) Vypsat všechna čísla dělitelná 11");
        System.out.println("2) Vypsat všechna čísla, jejichž druhá mocnina končí na znak 3");
        System.out.println("3) Vypsat dvojnásobky všech čísel");
        System.out.println("4) Vypsat 80 % z každého čísla zaokrouhlenou na nejbližší desítku nahoru");

        int optionChoose = sc.nextInt();

        if (optionChoose == 1) System.out.println(goThrough(userInputs, i -> i % 11 == 0));
        if (optionChoose == 2) System.out.println(goThrough(userInputs, i -> ((int) Math.pow(i, 3) + "").endsWith("3")));
        if (optionChoose == 3) System.out.println(swap(userInputs, i -> 2 * i));
        if (optionChoose == 4) System.out.println(swap(userInputs, i -> (Math.ceil(i / 100 * 80))));
        else {
            System.out.println("nevalidní možnost");
        }

    }

    public static ArrayList<Integer> goThrough(ArrayList<Integer> list, IntPredicate by) {
        ArrayList<Integer> listNew = new ArrayList<>();
        for (int j = 0; j < list.size(); j++) {
            int i = list.get(j);
            if (by.test(i)) {
                listNew.add(i);
            }
        }
        return listNew;
    }

    public static ArrayList<Double> swap(ArrayList<Integer> list, DoubleFunction<Double> by) {
        ArrayList<Double> listNew = new ArrayList<>();
        for (int j = 0; j < list.size(); j++) {
            int i = list.get(j);
            listNew.add(by.apply(i));
        }
        return listNew;
    }
}