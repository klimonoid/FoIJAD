package map;

public class Pair {
    private Object value1;
    private Object value2;

    Pair(Object v1, Object v2) {
        value1 = v1;
        value2 = v2;
    }

    @Override
    public String toString() {
        return "(" + this.value1 + ", " + this.value2 + ")";
    }
}
