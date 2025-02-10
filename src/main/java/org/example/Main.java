package org.example;

import arrays.NonRepeatingInteger;
import linkedlist.SinglyLinkedList;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        int[] numbers = {11, 11, 22, 33, 33,44};
        Integer result = NonRepeatingInteger.findFirstUnique(numbers);
        System.out.println(result);
    }



}