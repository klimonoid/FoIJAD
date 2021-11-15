package list;

import java.util.Random;

public class Test {
    public static void main(String[] strings)
    {
        testMerge();
        System.out.println("--------------------------------------\n");
        testMergeWithSort();
    }

    public static void testBasicFunctionality() {
        List<Object> a = new List<>();
        for (int i = 0; i < 5; i++) {
            a.add(i + 1);
        }
        for (int i = 0; i < 2; i++) {
            a.add(null);
        }
        System.out.println(a);
        a.add(10, 7);
        System.out.println(a);
        a.remove(3);
        System.out.println(a);
        System.out.println(a.get(10));
        Object tmp = a.get(3);
        System.out.println(tmp);
        System.out.println("this is set: ");
        System.out.println(a.set(-1, 3));
        System.out.println(a);
        System.out.println(a.contains(10));
        System.out.println(a.indexOf(10));
        System.out.println(a.size());
    }

    public static void testMerge() {
        Random random = new Random();
        List<Integer> l1 = new List<>();
        for(int i = 0; i < 10; ++i) {
            l1.add(random.nextInt(30));
        }
        System.out.println(l1);
        List<Integer> l2 = new List<>();
        for(int i = 0; i < 10; ++i) {
            l2.add(random.nextInt(30));
        }
        System.out.println(l2);
        System.out.println(List.merge(l1, l2));
        System.out.println(List.merge(l2, l1));
    }

    public static void testMergeWithSort() {
        Random random = new Random();
        SortableList<Integer> l1 = new SortableList<>();
        for(int i = 0; i < 10; ++i) {
            l1.add(random.nextInt(30));
        }
        System.out.println(l1);
        SortableList<Integer> l2 = new SortableList<>();
        for(int i = 0; i < 10; ++i) {
            l2.add(random.nextInt(30));
        }
        System.out.println(l2);
        System.out.println(SortableList.mergeWithSort(l1, l2));
        System.out.println(SortableList.mergeWithSort(l2, l1));
    }
}
