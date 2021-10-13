package map;

import list.List;

public interface MapInterface {
    void put(Object key, Object value);
    Object get(Object key);
    Object get(Object key, Object byDefault);
    Object remove(Object key);
    boolean keyContains(Object key);
    List getKeys();
    List getValues();
    List getEntries();
    int size();
    boolean isEmpty();
}
