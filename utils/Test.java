package utils;

import list.List;

public class Test {
    public static void main(String[] strings)
    {
        List<Object> a = new List<Object>();
        for (int i = 0; i < 2; i++) {
            a.add(i + 1);
        }
        List<Object> b = new List<Object>();
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
}