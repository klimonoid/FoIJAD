package list;

public class Test {
    public static void main(String[] strings)
    {
        List<Object> a = new List<Object>();
        for (int i = 0; i < 5; i++) {
            a.add(i + 1);
        }
        for (int i = 0; i < 2; i++) {
            a.add(null);
        }
        System.out.println(a.toString());
        a.add(10, 7);
        System.out.println(a.toString());
        a.remove(3);
        System.out.println(a.toString());
        System.out.println(a.get(10));
        Object tmp = a.get(3);
        System.out.println(tmp);
        System.out.println("this is set: ");
        System.out.println(a.set(-1, 3));
        System.out.println(a.toString());
        System.out.println(a.contains(10));
        System.out.println(a.indexOf(10));
        System.out.println(a.size());
    }
}
