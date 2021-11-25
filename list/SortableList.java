package list;


public class SortableList<T extends Comparable<T>> extends List<T> {


    public void orderedAdd(T value) {
        if (size == 0) {
            head = new Node<>(value);
            tail = head;
        } else {
            if (head.value.compareTo(value) > 0) {
                Node<T> tmp = new Node<>(value);
                tmp.next = head;
                head = tmp;
            } else {
                if (tail.value.compareTo(value) <= 0) {
                    tail.next = new Node<>(value);
                    tail = tail.next;
                } else {
                    Node<T> tmp = new Node<>(value);
                    Node<T> q = head;
                    while(q.next.value.compareTo(value) < 0) {
                        q = q.next;
                    }
                    tmp.next = q.next;
                    q.next = tmp;
                }
            }
        }
        size += 1;
    }

    public boolean isSorted() {
        T valueBefore = get(0);
        for (int i = 1; i < size; ++i) {
            T value = get(i);
            if (valueBefore.compareTo(value) <= 0) {
                valueBefore = value;
            } else {
                return false;
            }
        }
        return true;
    }

    public void sort() {
        SortableList<T> res = new SortableList<>();
        Node<T> q = head;
        while (q != null) {
            res.orderedAdd(q.value);
            q = q.next;
        }
        head = res.head;
        tail = res.tail;
        size = res.size;
    }

    public static <T extends Comparable<T>> SortableList<T> mergeWithSort(SortableList<T> toStartList, SortableList<T> toEndList) {
        if(toStartList.isEmpty()) {
            return toEndList;
        }
        if (toEndList.isEmpty()) {
            return toStartList;
        }
        if (!toStartList.isSorted()) {
            toStartList.sort();
        }
        if (!toEndList.isSorted()) {
            toEndList.sort();
        }
        SortableList<T> res = new SortableList<>();
        for(Integer i = 0; i < toStartList.size(); ++i) {
            res.orderedAdd(toStartList.get(i));
        }
        for(Integer i = 0; i < toEndList.size(); ++i) {
            res.orderedAdd(toEndList.get(i));
        }
        return res;
    }
}
