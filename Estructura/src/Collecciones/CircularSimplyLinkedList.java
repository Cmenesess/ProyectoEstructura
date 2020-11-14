/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Collecciones;

/**
 *
 * @author carloshumbertomenesesmurillo
 */
public class CircularSimplyLinkedList<E> implements List<E>{
    private class Node<E> {
        public E data;
        public Node<E> next;
        public Node(E elemento){
            data=elemento;
        }
    }
    public Node<E> last;
    public int current;
    @Override
    public boolean addFirst(E element) {
        Node<E> nodo= new Node<>(element);
        if(element ==null){
            return false;
        }else if(isEmpty()){
            last=nodo;
            nodo.next=nodo;
        }else{
            nodo.next=last.next;
            last.next=nodo;
        }
        current++;
        return true;
    }

    @Override
    public boolean addLast(E element) {
        Node <E> nodo= new Node<>(element);
        if(element== null){
            return false;
        }else if(isEmpty()){
            last=nodo;
            nodo.next=nodo;
        }else{
            nodo.next=last.next;
            last.next=nodo;
            last=nodo;
        }
        current++;
        return true;
    }

    @Override
    public boolean add(E element, int index) {
        if(isEmpty() || index<0 || index>current || element==null) return false;
        if(index== 0){
            addFirst(element);
            return true;
        }else if(index==current){
            addLast(element);
            return true;
        }else{
            Node<E> previo=getPrevio(index);
            Node<E> nuevo= new Node<E>(element);
            nuevo.next=previo.next;
            previo.next=nuevo;
        }
        current++;
        return true;
    }

    @Override
    public E get(int index) {
        if(isEmpty() || index<0 || index>=current) return null; //poner excepcion
        return getNode(index).data;
    }

    @Override
    public int size() {
        return current;
    }

    @Override
    public boolean isEmpty() {
        return last== null;
    }

    @Override
    public boolean remove(int index) {
        if(isEmpty() || index>current || index<0) return false;
        if(index== 0){
            return removeFirst();
        }else if(index== current-1){
            return removeLast();
        } else{
            Node<E> previo= getPrevio(index);
            Node<E> eliminar=previo.next;
            eliminar.data=null;
            previo.next=eliminar.next;
            eliminar.next=null;
        }
        current--;
        return true;
    }
    

    @Override
    public boolean contains(E element) {
        if(element==null || current==0) return false;
        Node<E> p=last.next;
        do{
            if(p.data.equals(element)){
                return true;
            }
            p=p.next;
            
        }while(p!=last.next);
        return false;
    }

    @Override
    public boolean removeFirst() {
       if(isEmpty()) return false;
       if(last.next==last){
            last.data=null;
            last.next=null;
            last=null;
       }else{
           Node<E> primero= last.next;
           last.next=primero.next;
           primero.data=null;
           primero.next=null;      
       }
       current--;
       return true;
    }

    @Override
    public boolean removeLast() {
        if(isEmpty()) return false;
        if(last.next==last){
            last.data=null;
            last.next=null;
            last=null;
        }else{
            last.data=null;
            Node<E>prev= getPrevio(last);
            prev.next=last.next;
            last.next=null;
            last=prev;
        }
        --current;
        return true;
    }

    @Override
    public E getFirst() {
        if(isEmpty()) throw new IllegalStateException("La lista está vacía");
        return last.next.data;
    }

    @Override
    public E getLAst() {
        if(isEmpty()) throw new IllegalStateException("La lista está vacía");
        return last.data;
    }
    private Node<E> getPrevio(Node<E> p){
        if(isEmpty()||p==null) return null;
        Node<E> q =this.last;
        do{
            if(q.next==p) return q;
            q=q.next;
        }while(q!=last);
        return null;
    }
    private Node<E> getPrevio(int index){
        Node<E> n=last;
        for(int i=0;i<index;i++){
            n=n.next;
        }
        return n;
    }
    
    
    private Node<E> getNode(int index){
        Node<E> n=last;
        for(int i=0;i<=index;i++){
            n=n.next;
        }
        return n;
    }
        public String toString(){
        if(isEmpty()) return "[ ]";
        StringBuilder sb= new StringBuilder();
        sb.append("[");
        Node<E> primero= last.next;
        while(primero!=last){
            sb.append(primero.data);
            sb.append(",");
            primero=primero.next;
        }
        sb.append(last.data);
        sb.append(']');
        return sb.toString();
    }
    
    
}
