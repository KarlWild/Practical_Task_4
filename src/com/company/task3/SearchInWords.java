package com.company.task3;

import java.util.*;

/**
 * 3.	Проведите частотный анализ слов и символов из первой строки (строки выбираются произвольно). Определите символы, которые:
 * 	входят и в первую и во вторую строку,
 *  	входят в первую и не входят во вторую,
 *  	содержатся хотя бы в одной строке.
 * Для обозначенных заданий осуществите вывод по следующим параметрам:
 * 	символы должны выводиться в обычном порядке;
 * 	символы должны выводиться в обратном порядке;
 * 	символы должны выводиться в порядке возрастания циклического сдвига влево на n разрядов хеш-функции символа.
 */
public class SearchInWords {
    private Search search;

    public SearchInWords(int choice) {
        switch (choice) {
            case 1:
                search = new SearchInBothSentencesSimmilar();
                break;
            case 2:
                search = new SearchInBothSentencesNoneSimmilar();
                break;
            case 3:
                search = new SearchInAnySentence();
                break;
        }
    }

    public void outputList(Set<Character> storedCharacters, String[] sentences,int choice) {
        OutputList outputList = new OutputList(this);
        switch (choice){
            case 1:
                outputList.outputNormally(search(storedCharacters, sentences));
                break;
            case 2:
                outputList.outputReverse(search(storedCharacters, sentences));
                break;
            case 3:
                break;
        }
    }

    public Search getSearch() {
        return search;
    }

    private List<Character> search(Set<Character> storedCharacters, String[] sentences) {
        return search.Search(storedCharacters, sentences);
    }

    static class OutputList{
        private SearchInWords searchInWords;
        public OutputList(SearchInWords searchInWords){this.searchInWords = searchInWords;}
        public void outputNormally(List<Character> list){
            for(Character s : list) System.out.print(s.toString() + ' ');
            System.out.println();
        }
        public void outputReverse(List<Character> list){
            Collections.reverse(list);
            for(Character s : list) System.out.print(s.toString() + ' ');
            System.out.println();
        }

    }

}

class SearchInBothSentencesSimmilar implements Search {
    /**
     * sentences.length = 2
     * sentences[0] - первая строка
     * sentences[1] - вторая строка
     */
    @Override
    public List<Character> Search(Set<Character> storedCharacters, String[] sentences) {
        for (Character s : sentences[0].toCharArray()) {
            if (!storedCharacters.contains(s)) storedCharacters.add(s);
        }
        List<Character> simmilarCharacters = new ArrayList<>();
        for (Character s : sentences[1].toCharArray()) {
            if (storedCharacters.contains(s) && !simmilarCharacters.contains(s)) {
                simmilarCharacters.add(s);
            }
        }
        return simmilarCharacters;
    }
}

class SearchInBothSentencesNoneSimmilar implements Search {
    @Override
    public List<Character> Search(Set<Character> storedCharacters, String[] sentences) {
        for (Character s : sentences[0].toCharArray()) {
            if (!storedCharacters.contains(s)) storedCharacters.add(s);
        }
        List<Character> noneSimmilarCharacters = new ArrayList<>();
        for (Character s : sentences[1].toCharArray()) {
            if (!storedCharacters.contains(s) && !noneSimmilarCharacters.contains(s)) {
                noneSimmilarCharacters.add(s);
            }
        }
        return noneSimmilarCharacters;
    }
}

class SearchInAnySentence implements Search {
    @Override
    public List<Character> Search(Set<Character> storedCharacters, String[] sentences) {
        for (Character s : sentences[0].toCharArray()) {
            if (!storedCharacters.contains(s)) storedCharacters.add(s);
        }
        List<Character> anyCharacters = new ArrayList<>();
        anyCharacters.addAll(storedCharacters);
        for (Character s : sentences[1].toCharArray()) {
            if (!storedCharacters.contains(s)) {
                anyCharacters.add(s);
            }
        }
        return anyCharacters;
    }
}