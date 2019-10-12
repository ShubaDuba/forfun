package com.company;

public class Main {
    public static int binarySearch(int[] array, int numberToSearch) {
        int first = 0;
        int last = array.length - 1;
        int middle = first + (last - first) / 2;
        while (first <= last) {
            if (array[middle] == numberToSearch) {
                return middle;
            }
            else if (array[middle] < numberToSearch) {
                first = middle + 1;
            }
            else if (array[middle] > numberToSearch) {
                last = middle - 1;
            }

            middle = first + (last - first) / 2;
        }

        return -1;
    }

    public static void main(String[] args) {
        int[] array = new int[]{1, 4, 8, 12, 13, 38, 63, 69, 79, 91};
        System.out.println(binarySearch(array, 69));
    }
}
