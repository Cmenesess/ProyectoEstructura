package Collecciones;

public interface List <E>{
    boolean addFirst(E element);
    boolean addLast(E element);
    boolean add(E element, int index);
    E get(int index);
    int size();
    boolean isEmpty();
    boolean remove(int index);
    boolean contains(E element);
    boolean removeFirst();
    boolean removeLast();
    E getFirst();
    E getLAst();
}
