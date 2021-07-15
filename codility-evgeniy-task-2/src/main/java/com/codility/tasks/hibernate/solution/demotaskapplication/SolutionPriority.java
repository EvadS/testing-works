package com.codility.tasks.hibernate.solution.demotaskapplication;

import java.util.Comparator;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.function.Function;
import java.util.stream.Collectors;

public class SolutionPriority {
    public static void main(String[] args) {
        int res = new Solution().solution("ccaaffddecee");
        System.out.println(res);

        res = new Solution().solution("aaaabbbb");
        System.out.println(res);
    }

    public int solution(String S) {
        PriorityQueue<Long> itemList = countChars(S);
        int result = 0;
        while (!itemList.isEmpty()) {
            Long value = itemList.poll();
            if(itemList.isEmpty()) {
                return result;
            }
            if(value.equals(itemList.peek())) {
                if(value > 1) {
                    itemList.offer(value - 1);
                }
                result++;
            }
        }
        return result;
    }
    public static PriorityQueue<Long> countChars(String arg) {
        Map<Character, Long> charactersCount = arg.chars().mapToObj(value -> (char) value)
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        Comparator<Long> longComparator = Comparator.comparingLong(value -> value);
        PriorityQueue<Long> longs = new PriorityQueue<>(longComparator.reversed());
        longs.addAll(charactersCount.values());
        return longs;
    }
}
