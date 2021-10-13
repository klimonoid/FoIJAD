package list;

import utils.Utils;

public class NumberList extends List<Number>{

    public void orderedAdd(Number value) {
        if (size == 0) {
            size = 1;
            head = new Node<>(value);
            tail = head;
        } else {
            if (Utils.compareTo(head.value, value) > 0) {
                Node<Number> tmp = new Node<>(value);
                tmp.next = head;
                head = tmp;
            } else {
                Node<Number> q = head;
                boolean added = false;
                while (q.next != null) {
                    // Value of q.next bigger than value => add between q and q.next
                    if (Utils.compareTo(q.next.value, value) > 0) {
                        Node<Number> tmp = new Node<>(value);
                        tmp.next = q.next;
                        q.next = tmp;
                        added = true;
                    }
                    q = q.next;
                }
                if (!added) {
                    tail.next = new Node<>(value);
                    tail = tail.next;
                }
            }
        }
        this.size += 1;
    }

    public void sort() {
        NumberList res = new NumberList();
        Node<Number> q = head;
        while (q != null) {
            res.orderedAdd(q.value);
            q = q.next;
        }
        head = res.head;
        tail = res.tail;
        size = res.size;
    }


}
