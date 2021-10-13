package map;

public class Test {
    public static void main(String[] strings)
    {
        Map myMap = new Map();
        System.out.println(myMap.getKeys());
        System.out.println(myMap.getValues());
        System.out.println(myMap.getEntries());
        System.out.println(myMap.size());
        System.out.println(myMap.isEmpty());

        String k = "";
        String v = "";
        for (int i = 0; i < 10; i++) {
            k = k + "k";
            v = v + "v";
            myMap.put(k, v);
        }
        System.out.println(myMap.getKeys().toString());
        System.out.println(myMap.getValues().toString());
        System.out.println(myMap.getEntries().toString());
        System.out.println(myMap.size());
        System.out.println(myMap.isEmpty());

        System.out.println(myMap.get("kakashechka", "poop"));
        System.out.println(myMap.get("kkkk"));
        myMap.put("kkkkkkkk", "kakashka");
        System.out.println(myMap.remove("kk"));

        System.out.println(myMap.getKeys().toString());
        System.out.println(myMap.getValues().toString());
        System.out.println(myMap.getEntries().toString());
        System.out.println(myMap.size());
        System.out.println(myMap.isEmpty());
    }
}