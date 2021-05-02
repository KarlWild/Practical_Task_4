package com.company;

import com.company.task1.Person;
import com.company.task2.CheckDate;
import com.company.task3.SearchInWords;
import com.company.task4.BinaryTree;

import java.text.ParseException;
import java.util.HashSet;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws ParseException {
        Person person = new Person(2001,6,27);
        System.out.println(person.toString("короткий"));
        System.out.println(person.toString("средний"));
        System.out.println(person.toString("полный"));

        System.out.println("введите дату в формате Год Месяц День");
        Scanner sc = new Scanner(System.in);
        int year = sc.nextInt();
        int month = sc.nextInt();
        int day = sc.nextInt();
        CheckDate checkDate = new CheckDate(year,month,day);
        System.out.println("введите Часы Минуты");
        int hours = sc.nextInt();
        int min = sc.nextInt();
        CheckDate checkDate1 = new CheckDate(hours, min);

        System.out.println("3 задание");

        SearchInWords search = new SearchInWords(1);
        System.out.println("Проведите частотный анализ слов и символов из первой строки (строки");
        System.out.println("выбираются произвольно). Определите символы, которые:");
        String[] array = new String[]{"Проведите частотный анализ слов и символов из первой строки (строки",
                "выбираются произвольно). Определите символы, которые:"};
        search.outputList(new HashSet<>(), array, 1);
        search.outputList(new HashSet<>(), array, 2);

        search = new SearchInWords(2);
        search.outputList(new HashSet<>(), array, 1);
        search.outputList(new HashSet<>(), array, 2);

        search = new SearchInWords(3);
        search.outputList(new HashSet<>(), array, 1);
        search.outputList(new HashSet<>(), array, 2);

        System.out.println("4 задание");
        BinaryTree tree = new BinaryTree();
        tree.insertNode(6);
        tree.insertNode(8);
        tree.insertNode(5);
        tree.insertNode(8);
        tree.insertNode(2);
        tree.insertNode(9);
        tree.insertNode(7);
        tree.insertNode(4);
        tree.insertNode(10);
        tree.insertNode(3);
        tree.insertNode(1);
        tree.printTree();
        System.out.println("Обратный обход");
        tree.postOrder(tree.getRootNode());
        System.out.println("\nПрямой обход");
        tree.preOrder(tree.getRootNode());
        System.out.println("\nЦентрированный обход");
        tree.inOrder(tree.getRootNode());
    }
}
