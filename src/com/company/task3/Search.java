package com.company.task3;

import java.util.List;
import java.util.Scanner;
import java.util.Set;

public interface Search {
    Scanner sc = new Scanner(System.in);

    List<Character> Search(Set<Character> storedCharacters, String[] sentences);
}
