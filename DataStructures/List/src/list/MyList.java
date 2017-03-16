package list;

public interface MyList<E> {

    void add(E data);
    void add(int index, E data);
    E get(int index);
    E remove(int index);
    int indexOf(E data);
    boolean contains(E data);
    int size();
    void print();

}


