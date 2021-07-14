package com.codility.tasks.hibernate.solution.demotaskapplication;

import java.util.*;

public class Solution {
    public static LinkedList<Item> countChars(String arg) {
        LinkedList<Item> itemList = new LinkedList<>();

        String res = "";
        boolean[] counted = new boolean[arg.length()];
        for (int i = 0; i < counted.length; i++) {
            if (!counted[i]) {
                char c = arg.charAt(i);
                int counter = 1;
                for (int j = i + 1; j < counted.length; j++) {
                    if (arg.charAt(j) == c) {
                        counter++;
                        counted[j] = true;
                    }
                }
                res += counter + "" + c;

                Item item = new Item(c, counter);
                itemList.add(item);

            }
        }
        return itemList;
    }

    public static void main(String[] args) {
        int res = new Solution().solution("ccaaffddecee");
        System.out.println(res);

        res = new Solution().solution("aaaabbbb");
        System.out.println(res);
    }

    public int solution(String S) {
        LinkedList<Item> itemList = countChars(S);
        itemList.sort(Comparator.comparing(Item::getCountLetters).reversed());

        int result = 0;

        int previousCount = -1;

        while (!itemList.isEmpty()) {
            Item item = itemList.pop();

            if (itemList.isEmpty()) {
                return result;
            }

            if (item.getCountLetters() == itemList.getFirst().getCountLetters()) {
                if (item.getCountLetters() > 1) {
                    itemList.push(new Item(item.letter, item.countLetters - 1));
                    itemList.sort(Comparator.comparing(Item::getCountLetters).reversed());
                }
                result++;
            }
        }

        return result;
    }
}


class Item {
    char letter;
    int countLetters;

    public Item() {
    }

    public Item(char letter, int countLetters) {
        this.letter = letter;
        this.countLetters = countLetters;
    }

    public char getLetter() {
        return letter;
    }

    public void setLetter(char letter) {
        this.letter = letter;
    }

    public int getCountLetters() {
        return countLetters;
    }

    public void setCountLetters(int countLetters) {
        this.countLetters = countLetters;
    }
}
