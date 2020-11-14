package Collecciones;

import java.util.Iterator;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author carloshumbertomenesesmurillo
 */
public class SimplyLinkedList<E> implements List<E> {
    private Node<E> first;
    private Node<E> last;
    private int current;
    public SimplyLinkedList(){
        first= last= null;
        current=0;
    }

    public Iterator<E> iteratorStep(int start,int step) {
            Iterator<E> it = new Iterator<E>() {
                private Node<E> i=nodeIndex(start);
                int posicion=start;
                @Override
                public boolean hasNext() {
                    return i!=null;
                } 
                @Override
                public E next() {
                    E temp=i.data;
                    posicion+=step;
                    i=nodeIndex(posicion);
                    return temp;
                } 
            };
            return it; 
    }

    
    private class Node<E>{
        private E data;
        private Node<E> next ;
        public Node(E data){
            this.data= data;
        }
    }
    @Override
    public boolean addFirst(E element) {
        if(element== null) return false;
        Node<E> elemento= new Node<>(element);
        if(isEmpty()) {
            first=last=elemento;
        }else{
            elemento.next=first; 
            first=elemento;
        }
        current++;
        return true;
    
    }

    @Override
    public boolean addLast(E element) {
        if(element== null) return false;
        Node<E> elemento= new Node<>(element);
        if(isEmpty()) {
            first=last=elemento;
        }else{
            last.next=elemento;
            last=elemento;
        }
        current++;
        return true;
    }

    @Override
    public boolean add(E element, int index) {
        if(index>current || index<0 || element==null)  return false;
        if(index==0){
            return addFirst(element);
        }else if(index==current){
            return addLast(element);
        }else{
            Node<E> previo= getprevious(index);
            Node<E> siguiente= previo.next;
            Node<E> elemento= new Node<>(element);
            previo.next= elemento;
            elemento.next=siguiente;
        }
        current++;
        return true;
    }
    
    @Override
    public E get(int index) {
        if(index>=current || index<0)  throw new ArrayIndexOutOfBoundsException("Un indice mayor al numero de elementos");
        return getprevious(index).next.data;
    }
    @Override
    public int size() {
        return current;
    }

    @Override
    public boolean isEmpty() {
        return first== null && last== null;
    }

    @Override
    public boolean remove(int index) {
        if(isEmpty()) return false;
        if(index==0){
            return removeFirst();
        }
        if(index==current-1){
            return removeLast();
        }
        if(first==last) {
            first.data=null;
            first=last=null ;
        } else{
            Node<E> previo= getprevious(index);
            Node<E> siguiente= previo.next;
            previo.next=siguiente.next;
            siguiente.data=null;
            siguiente.next=null;
            siguiente=null;
        }
        current--;
        return true;
    }
    @Override
    public boolean removeFirst() {
        if(isEmpty()) return false;
        if(first==last) {
            first.data=null;
            first=last=null ;
        } else{
            Node<E> temporal=first;
            first=first.next;
            temporal.data=null;
            temporal.next=null;
        }
        current--;
        return true;
    }

    private Node<E> getprevious(Node <E> p){
        Node<E> primero= first;
        while(primero!=null && !primero.next.equals(p)){
            primero=primero.next;
        }
        return primero;
    }
    private Node<E> getprevious(int index){
        Node<E> primero= first;
        for(int i=0;i<index-1;i++){
            primero=primero.next;
        }
        return primero;
    }
    private Node<E> nodeIndex(int index){
        if(isEmpty() || index>=current || index<0) return null;
        Node<E> primero= first;
        int i=0;
        while(i<index){
            primero=primero.next;
            i++;
        }
        return primero;
    }
    
    @Override
    public boolean removeLast() {
        if(isEmpty()) return false;
        if(first== last){
            first.data=null;
            first=last=null;
        }else{
            Node<E> previous= getprevious(last);
            System.out.println(previous.data);
            last.data=null;
            last.next=null;
            last=previous;
        }
        current--;
        return true;
    }

    @Override
    public E getFirst() {
        if(isEmpty()) return null;
        return first.data;
    }

    @Override
    public E getLAst() {
        if(isEmpty()) return null;
        return last.data;
    }
    @Override
    public String toString(){
        if(isEmpty()) return "[ ]";
        StringBuilder sb= new StringBuilder();
        sb.append("[");
        Node<E> primero= first;
        while(primero != last){
            sb.append(primero.data);
            sb.append(",");
            primero=primero.next;
        }
        sb.append(last.data);
        sb.append(']');
        return sb.toString();
    }
    @Override
    public boolean contains(E element) {
        if(element ==null) return false;
        Node<E> primero= first;
        while(primero != null){
            if(primero.data.equals(element)) return true;
            primero=primero.next;
        }
        return false;
    }
    public void agregarElementos(E array[]){
        for(E i :array){
            this.addLast(i);
        }
    }
}
