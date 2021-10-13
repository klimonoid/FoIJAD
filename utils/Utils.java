package utils;

import java.math.BigDecimal;
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
}
