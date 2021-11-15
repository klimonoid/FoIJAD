package utils;

import java.lang.reflect.Array;
import java.math.BigDecimal;
import java.util.*;

import employee.*;

public class Utils {
    public static void parseString(String inp) {
        String[] words = inp.split("\s+");

        Map<String, Integer> frequencies = new TreeMap<>();
        for (String w : words) {
            if (frequencies.containsKey(w)) {
                frequencies.put(w, frequencies.get(w) + 1);
            } else {
                frequencies.put(w, 1);
            }
        }
        System.out.println("Task 1:");
        for (Map.Entry<String, Integer> entry : frequencies.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }

        Map<String, Integer> noMulti = new HashMap<>();
        for (String w : words) {
            if (!noMulti.containsKey(w)) {
                noMulti.put(w, 1);
            }
        }
        String res = noMulti.keySet().toString();
        System.out.println("Task 2:");
        System.out.println(res);
    }
}
