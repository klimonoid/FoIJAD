package utils;

import list.List;

import java.util.Scanner;

public class Test {
    public static void main(String[] strings)
    {
        testParsing();
    }

    private static void testMerge() {
        List<Object> a = new List<>();
        for (int i = 0; i < 2; i++) {
            a.add(i + 1);
        }
        List<Object> b = new List<>();
        for (int i = 0; i < 2; i++) {
            b.add(-(i + 1));
        }

        List<Object> aa = new List<>(a);

        System.out.println(a.toString());
        System.out.println(aa.toString());
        System.out.println(b.toString());
        a.mergeWith(b);
        System.out.println(a.toString());
    }

    private static void testParsing() {
        Scanner in = new Scanner(System.in);
        System.out.println("Enter a line of words:");
        String inp = in.nextLine();
        Utils.parseString(inp);
    }
}
