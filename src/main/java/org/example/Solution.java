package org.example;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;

import static java.lang.Integer.parseInt;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;


public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        int linesCount = parseInt(bufferedReader.readLine().trim());

        List<String> lines = IntStream.range(0, linesCount).mapToObj(i -> {
                    try {
                        return bufferedReader.readLine();
                    } catch (IOException ex) {
                        throw new RuntimeException(ex);
                    }
                })
                .collect(toList());

        List<String> result = Result.aPlusB(lines);

        bufferedWriter.write(
                result.stream()
                        .collect(joining("\n"))
                        + "\n"
        );

        bufferedReader.close();
        bufferedWriter.close();
    }
}

class Result {

    /*
     * Complete the 'aPlusB' function below.
     *
     * The function is expected to return a STRING_ARRAY.
     * The function accepts STRING_ARRAY lines as parameter.
     */

    public static List<String> aPlusB(List<String> lines) {
        // Get the first item to indicate the number of lines to iterator over
        int numAdditions = Integer.parseInt(lines.get(0));

        List<Integer> savedResult = new ArrayList<>();
        for(int i = 1 ; i< numAdditions;i++){
            String nums = lines.get(i);
            String[] items = nums.split(" ");
            int sum = Integer.parseInt(items[0]) + Integer.parseInt(items[1]);
            savedResult.add(sum);
        }

        return savedResult.stream().map(i-> i.toString()).collect(toList());
    }

}

