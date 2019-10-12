package com.company;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {
    public static List<Integer> sortConverse(List<List<Integer>> initialList) {
        return initialList.stream()
                .flatMap(List::stream)
                .sorted()
                .collect(Collectors.toList());
    }

    public static void main(String[] args) {
        List<List<Integer>> listOfLists = new ArrayList<>(5);
        listOfLists.add(Stream.of(5, 3).collect(Collectors.toList()));
        listOfLists.add(Stream.of(6, 2).collect(Collectors.toList()));
        listOfLists.add(Stream.of(9, 1).collect(Collectors.toList()));
        List<Integer> sorted = sortConverse(listOfLists);
        sorted.stream().forEach(System.out::println);
    }
}
