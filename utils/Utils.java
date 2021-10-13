package utils;

import java.math.BigDecimal;
import java.util.*;

import list.List;

public class Utils {
    public static int compareTo(Number n1, Number n2) {
        // ignoring null handling
        BigDecimal b1 = BigDecimal.valueOf(n1.doubleValue());
        BigDecimal b2 = BigDecimal.valueOf(n2.doubleValue());
        return b1.compareTo(b2);
    }

    public static List merge(List l1, List l2) {
        List l3 = new List(l1);
        l3.mergeWith(l2);
        return l3;
    }

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
        for(Map.Entry<String, Integer> entry : frequencies.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }
}
