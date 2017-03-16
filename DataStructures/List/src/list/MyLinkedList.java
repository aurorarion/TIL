package list;

public class MyLinkedList<E> implements MyList<E> {

    // atomic method of linked list
    private int length;
    private Node<E> head;   // first
    private Node<E> tail;   // last

    public MyLinkedList() {
        this.length = 0;
    }

    private void linkHead(E item) {
        Node<E> h = this.head;
        Node<E> newNode = new Node<E>(null, item, h);

        this.head = newNode;
        if(h == null) {
            this.tail = newNode;
        } else {
            h.prev = newNode;
        }
        length++;
    }

    private void linkTail(E item) {
        Node<E> t = this.tail;
        Node<E> newNode = new Node<E>(t, item, null);

        this.tail = newNode;
        if(t == null) {
            this.head = newNode;
        } else {
            t.next = newNode;
        }
        length++;
    }

    private void linkBefore(Node<E> succ, E item) {
        Node<E> t = succ.prev;
        Node<E> newNode = new Node<E>(t, item, succ);

        succ.prev = newNode;

        if(t == null) {
            this.head = newNode;
        } else {
            t.next = newNode;
        }
        length++;
    }

    private E unlinkHead() {
        E ret = this.head.data;
        Node<E> next = this.head.next;

        this.head = next;

        if(next == null) {
            this.tail = null;
        } else {
            next.prev = null;
        }
        length--;

        return ret;
    }

    private E unlinkTail() {
        E ret = this.tail.data;
        Node<E> prev = this.tail.prev;

        this.tail = prev;

        if(prev == null) {
            this.head = null;
        } else {
            prev.next = null;
        }
        length--;

        return ret;
    }

    private E unlinkNode(Node<E> node) {
        E ret = node.data;
        Node<E> prev = node.prev, next = node.next;

        node = null;

        if(prev == null) {
            this.head = next;
        } else {
            prev.next = next;
        }

        if(next == null) {
            this.tail = prev;
        } else {
            next.prev = prev;
        }
        length--;

        return ret;
    }

    private boolean checkIndexRange(int index) {
        return index >= 0 && index < length;
    }

    private Node<E> node(int index) {
        if (!checkIndexRange(index)) {
            throw new IndexOutOfBoundsException();
        }
        Node<E> ret;
        if(index < length / 2) {
            ret = this.head;
            for(int i = 0; i < index; i++) {
                ret = ret.next;
            }
        } else {
            ret = this.tail;
            for(int i = 0; i < length - 1 - index; i++) {
                ret = ret.prev;
            }
        }
        return ret;
    }

    @Override
    public void add(E data) {
        linkTail(data);
    }

    @Override
    public void add(int index, E data) {
        if(!checkIndexRange(index)){
            throw new IndexOutOfBoundsException();
        }

        if(index == 0) {
            linkHead(data);
        } else if(index == length -1) {
            linkTail(data);
        } else {
            linkBefore(node(index), data);
        }
    }

    @Override
    public E get(int index) {
        return node(index).data;
    }

    @Override
    public E remove(int index) {
        if(!checkIndexRange(index)){
            throw new IndexOutOfBoundsException();
        }

        if(index == 0) {
            return unlinkHead();
        } else if(index == length -1) {
            return unlinkTail();
        } else {
            return unlinkNode(node(index));
        }
    }

    @Override
    public int indexOf(E data) {
        Node<E> temp = this.head;

        for(int i=0; i < length; i++) {
            if(temp.data.equals(data)) {
                return i;
            } else {
                temp = temp.next;
            }
        }
        return -1;
    }

    @Override
    public boolean contains(E data) {
        return indexOf(data) > -1;
    }

    @Override
    public int size() {
        return length;
    }

    @Override
    public void print() {
        Node<E> temp = head;
        while(temp != null) {
            System.out.println(temp);
            temp = temp.next;
        }
    }

    private static class Node<E> {
        E data;
        Node<E> next;
        Node<E> prev;

        Node(Node<E> prev, E data, Node<E> next) {
            this.data = data;
            this.prev = prev;
            this.next = next;
        }

        @Override
        public String toString() {
            return "[" + data + "]";
        }
    }
}