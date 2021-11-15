package list;

public interface ListInterface<T> {
    void add (T value);
    Object remove (Integer index);
    Object get(Integer index);
    Object set(T value, Integer index);
    Integer size();
    boolean isEmpty();
    boolean contains(T value);
    Integer indexOf(T value);
}
