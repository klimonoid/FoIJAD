package utils;

import java.math.BigDecimal;
import java.util.*;

import employee.*;

public class Utils {
    public static int compareTo(Number n1, Number n2) {
        // ignoring null handling
        BigDecimal b1 = BigDecimal.valueOf(n1.doubleValue());
        BigDecimal b2 = BigDecimal.valueOf(n2.doubleValue());
        return b1.compareTo(b2);
    }

    public static list.List merge(list.List l1, list.List l2) {
        list.List l3 = new list.List(l1);
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

    public static List<Employee> createShortList() {
        List<Employee> res = new LinkedList<>();
        employee.Director director = new Director(new ClassicEmployeeBuilder());

        res.add(director.makeEmployee("Klim", "Fedorov", 20,
                Employee.Gender.MALE, Employee.Role.MANAGER, "Java", "klim.fedorov@firma.ru",
                "+71234567890", "Granatniy st. 11/1", "Moscow","Moscow", 123001));
        res.add(director.makeEmployee("Nil", "Polsky", 19,
                Employee.Gender.MALE, Employee.Role.STAFF, "Java", "nil.polsky@firma.ru",
                "+74561237890", "Oktiabrskaya st. 13", "Krasnogorsk",
                "Moscow area", 123456));
        res.add(director.makeEmployee("Daria", "Ignasheva", 20,
                Employee.Gender.FEMALE, Employee.Role.EXECUTIVE, "C++", "daria.ignasheva@firma.ru",
                "+77894561230", "Moskovskaya st. 118", "Tver",
                "Tver area", 456123));
        res.add(director.makeEmployee("Daria", "Pankratova", 20,
                Employee.Gender.FEMALE, Employee.Role.EXECUTIVE, "C++", "daria.pankratova@firma.ru",
                "+79456123660", "Ostrovskiy st. 64", "Kazan",
                "Republic of Tatarstan", 412356));
        res.add(director.makeEmployee("Vladimir", "Shubkin", 18,
                Employee.Gender.MALE, Employee.Role.MANAGER, "C#", "vladimir.shubkin@firma.ru",
                "+79456321660", "School st. 2", "Barnaul",
                "Altai region", 432156));
        res.add(director.makeEmployee("Tatiana", "Volik", 18,
                Employee.Gender.MALE, Employee.Role.MANAGER, "Art", "tatiana.volik@firma.ru",
                "+79456321660", "Severnaya St. 3", "Alushta",
                "Republic of Crimea", 432516));
        res.add(director.makeEmployee("Svetlana", "Aniuhina", 19,
                Employee.Gender.MALE, Employee.Role.MANAGER, "Art", "svetlana.aniuhina@yandex.ru",
                "+79456321660", "Severnaya St. 3", "Alushta",
                "Republic of Crimea", 432516));
        return res;
    }
}
