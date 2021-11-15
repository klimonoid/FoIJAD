package list;

public class List<T> implements ListInterface<T> {

    protected static class Node<t> {
        t value;
        Node<t> next;

        Node() {
            value = null;
            next = null;
        }

        Node(t value) {
            this.value = value;
            next = null;
        }

        @Override
        public String toString() {
            return value.toString();
        }
    }

    protected Integer size;
    protected Node<T> head;
    protected Node<T> tail;

    public List() {
        size = 0;
        head = null;
        tail = null;
    }

    public List(T value) {
        size = 1;
        head = new Node<>(value);
        tail = head;
    }

    public List(List<T> l) {
        if (l.size != 0) {
            size = l.size;
            head = l.head;
            Node<T> q = head;
            Node<T> qq = l.head.next;
            while(qq != null) {
                q.next = new Node<>(qq.value);
                qq = qq.next;
                q = q.next;
            }
            tail = q;
        } else {
            size = 0;
            head = null;
            tail = null;
        }
    }

    public void add(T value) {
        if (size == 0) {
            size = 1;
            head = new Node<>(value);
            tail = head;
        } else {
            tail.next = new Node<>(value);
            size += 1;
            tail = tail.next;
        }
    }

    public void add(T value, Integer index) {
        if (index > 0 && index <= size) {
            Node<T> q = head;
            for (int i = 0; i < index - 1; i++) {
                q = q.next;
            }
            Node<T> tmp = q.next;
            q.next = new Node<>(value);
            q.next.next = tmp;
            if (index.equals(size)) {
                tail = tail.next;
            }
            size += 1;
        }
    }

    public T remove(Integer index) {
        Node<T> res;
        if (index == 0) {
            res = head;
            head = head.next;
        } else {
            Node<T> q = head;
            if (index.equals(size)) {
                while (q.next != null) {
                    if (q.next.next != null) {
                        q = q.next;
                    } else {
                        break;
                    }
                }
                res = tail;
                tail = q;
            } else {
                for (int i = 0; i < index - 1; i++) {
                    if (q.next != null) {
                        q = q.next;
                    } else {
                        return null;
                    }
                }
                res = q.next;
                q.next = q.next.next;
            }
        }
        size -= 1;
        return res.value;
    }

    public T get(Integer index) {
        Node<T> q = head;
        for (int i = 0; i < index; i++) {
            if (q.next != null) {
                q = q.next;
            } else {
                return null;
            }
        }
        return q.value;
    }

    public Object set(T value, Integer index) {
        Node<T> q = head;
        for (int i = 0; i < index; i++) {
            if (q.next != null) {
                q = q.next;
            } else {
                return null;
            }
        }
        Object res = q.value;
        q.value = value;
        return res;
    }

    public Integer size() { return this.size; }

    public boolean isEmpty() {
        return (size <= 0);
    }

    public boolean contains(T value) {
        Node<T> q = head;
        while (q != null) {
            if (q.value != null) {
                if (q.value.equals(value)) {
                    return true;
                }
            } else {
                if (value == null) {
                    return true;
                }
            }
            q = q.next;
        }
        return false;
    }

    public Integer indexOf(T value) {
        int index = -1;
        boolean found = false;
        Node<T> q = head;
        while (q != null) {
            index += 1;
            if (q.value != null) {
                if (q.value.equals(value)) {
                    found = true;
                    break;
                }
            } else {
                if (value == null) {
                    found = true;
                    break;
                }
            }
            q = q.next;
        }
        return found? index : -1;
    }

    public static <T> List<T> merge(List<T> toStartList, List<T> toEndList) {
        if(toStartList.isEmpty()) {
            return toEndList;
        }
        if (toEndList.isEmpty()) {
            return toStartList;
        }
        List<T> res = new List<>(toStartList);
        for(Integer i = 0; i < toEndList.size(); ++i) {
            res.add(toEndList.get(i));
        }
        return res;
    }

    @Override
    public String toString() {
        if (size == 0) {
            return "";
        } else {
            StringBuilder res = new StringBuilder();
            Node<T> q = head;
            while (q != null) {
                res.append(q.value).append(" -> ");
                q = q.next;
            }
            return res + "| " + this.size;
        }
    }
}