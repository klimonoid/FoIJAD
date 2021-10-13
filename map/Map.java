package map;

import list.List;

public class Map implements MapInterface {

    private Integer size = 0;
    private List keys = new List();
    private List values = new List();
    private Object byDefault = null;

    public void put(Object key, Object value) {
        if (!keys.contains(key)) {
            keys.add(key);
            values.add(value);
            size++;
        } else {
            values.set(value, keys.indexOf(key));
        }
    }

    public Object get(Object key) {
        Integer index = keys.indexOf(key);
        if (index != -1) {
            return values.get(index);
        } else {
            return byDefault;
        }
    }

    public Object get(Object key, Object byDefault) {
        this.byDefault = byDefault;
        Integer index = keys.indexOf(key);
        if (index != -1) {
            return values.get(index);
        } else {
            return byDefault;
        }
    }

    public Object remove(Object key) {
        Integer index = keys.indexOf(key);
        Object res = values.remove(index);
        keys.remove(index);
        size--;
        return res;
    }

    public boolean keyContains(Object key) {
        return keys.contains(keys);
    }

    public List getKeys() {
        return keys;
    }

    public List getValues() {
        return values;
    }

    public List getEntries() {
        List res = new List();
        for (int i = 0; i < keys.size(); i++) {
            res.add(new Pair(keys.get(i), values.get(i)));
        }
        return res;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return (size == 0);
    }
}
