/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Collecciones;

import java.util.Iterator;

/**
 *
 * @author carloshumbertomenesesmurillo
 */
public class CircularDoublyLinkedList<E> implements List<E>,Iterable<E>{
    private class Node<E> {
        private E data;
        private Node<E> previous,next;
        private Node(E elemento){
            data=elemento;
        }
    }
    private Node<E> raiz;
    private int current;

    public Node<E> getRaiz() {
        return raiz;
    }

    public int getCurrent() {
        return current;
    }
    
    @Override
    public Iterator<E> iterator() {
        return new Iterator<E>(){
            Node<E> p=raiz.next;
            public boolean hasNext(){
                return !isEmpty();
            }
            
            public E next(){
                E tmp=p.data;
                p=p.next;
                return tmp;
            }
        };
    }

    @Override
    public boolean addFirst(E element) {
        if(element== null) return false;
        Node<E> nuevo=new Node(element);
        if(isEmpty()) {
            nuevo.next=nuevo;
            nuevo.previous=nuevo;            
            raiz=nuevo;
        }else{
            Node<E> primero=raiz.next;
            nuevo.next=primero;
            primero.previous=nuevo;
            raiz.next=nuevo;
            nuevo.previous=raiz;     
        }
        current++;
        return true;
    }
    @Override
    public boolean addLast(E element) {
        if(element== null) return false;
        Node<E> ultimo=new Node(element);
        if(isEmpty()) {
            ultimo.next=ultimo;
            ultimo.previous=ultimo;            
            raiz=ultimo;
        }else{
            Node<E> primero=raiz.next;
            primero.previous=ultimo;
            ultimo.next=primero;
            raiz.next=ultimo;
            ultimo.previous=raiz;
            raiz=ultimo;  
        }
        current++;
        return true;
    }

    @Override
    public boolean add(E element, int index) {
        if(isEmpty() || index<0 || index>=current || element==null) return false;
        if(index== 0){
            addFirst(element);
            return true;
        }else if(index== current){
            addLast(element);
            return true;
        }else{
            Node<E> posicion=getNode(index);
            Node<E> nuevo= new Node<E>(element);
            nuevo.previous=posicion.previous;
            posicion.previous.next=nuevo;
            posicion.previous=nuevo;
            nuevo.next=posicion;        
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
        return raiz== null;
    }

    @Override
    public boolean remove(int index) {
       if(isEmpty()) return false;
        if(raiz.next==raiz) {
           raiz.data=null;
           raiz.next=null;
           raiz.previous=null;
           raiz=null;
        }else if(index== 0){
            return removeFirst();
        }else if(index== current-1){
            return removeLast();
        } else{
            Node<E> actual= getNode(index);
            actual.data=null;
            actual.next.previous=actual.previous;
            actual.previous.next=actual.next;
            actual.next=null;
            actual.previous=null;
            actual=null;
        }
        current--;
        return true;
    }
    private Node<E> getNode(int index){
        Node<E> n=raiz;
        for(int i=0;i<=index;i++){
            n=n.next;
        }
        return n;
    }
    @Override
    public boolean contains(E element) {
        if(isEmpty()|| element==null) return false;
        Node<E> n=raiz;
        do{
            if(n.data.equals(element)){
                return true;
            }
            n=n.next;
        }while(n!=raiz);
        return false;
    }

    @Override
    public boolean removeFirst() {
       if(isEmpty()) return false;
       if(raiz.next==raiz){
           raiz.data=null;
           raiz.next=null;
           raiz.previous=null;
           raiz=null;
       }else{
           Node<E> primero=raiz.next;
           primero.data=null;
           raiz.next=primero.next;
           primero.next.previous=raiz;
           primero.next=null;
           primero.previous=null;
           primero=null;      
       }
       current--;
       return true;
    }

    @Override
    public boolean removeLast() {
       if(isEmpty()) return false;
       if(raiz.next==raiz){
           raiz.data=null;
           raiz.next=null;
           raiz.previous=null;
           raiz=null;
       }else{
           raiz.data=null;
           Node<E> primero=raiz.next;
           Node<E> penultimo=raiz.previous;
           penultimo.next=primero;
           primero.previous=penultimo;
           raiz.next=null;
           raiz.previous=null;
           raiz=penultimo;
           
       }
       current--;
       return true;
    }

    @Override
    public E getFirst() {
        if(isEmpty()) throw new IllegalStateException("La lista está vacía");
        return raiz.next.data;
    }

    @Override
    public E getLAst() {
        if(isEmpty()) throw new IllegalStateException("La lista está vacía");
        return raiz.data;
    }
    public String toString(){
        if(isEmpty()) return "[ ]";
        StringBuilder sb= new StringBuilder();
        sb.append("[");
        Node<E> primero= raiz.next;
        while(primero!=raiz){
            sb.append(primero.data);
            sb.append(",");
            primero=primero.next;
        }
        sb.append(raiz.data);
        sb.append(']');
        return sb.toString();
    }
    
}
