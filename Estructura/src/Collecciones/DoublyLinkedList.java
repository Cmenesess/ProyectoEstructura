/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Collecciones;

import java.util.Iterator;
import java.util.ListIterator;



/**
 *
 * @author carloshumbertomenesesmurillo
 */
public class DoublyLinkedList<E> implements List<E> {
    public Node<E> first;
    public Node<E> last;
    public int current;

    public List<E> slicing(int start, int end) {
        if(start>=end || end>= current) return new DoublyLinkedList<>();
        List<E> lista= new DoublyLinkedList<>();
        Node<E> primero= first;
        for(int i=0;i<end;i++){
            if(i>=start){
                lista.addLast(primero.data);
            }
            primero=primero.next;
        }
        return lista;
        
    }
    private class Node<E>{
        public E data;
        public Node<E> next;
        public Node<E> previous;
        public Node(E elemento){
            data=elemento;
        }
    }
    // Ejercicio 7
    private void removeNNodes(Node<E> p, int n){
        Node<E> siguiente=p.next;
        for(int i=0;i<n;i++){
            if(siguiente!=null){
                siguiente=eliminarNode(siguiente,"Desc");
                siguiente=siguiente.next;
            } 
        }
    }
    //Ejercicio 3 
    public boolean esPalíndromoRecursivo(){
        return esPalíndromoRecursivo(this.first,this.last);
    }
    //Ejercicio 3 con la recursividad
    private boolean esPalíndromoRecursivo(Node<E> first,Node<E> last){
        if(!first.data.equals(last.data) || first==null) return false;
        if(first==last || first.previous==last) return true;
        return esPalíndromoRecursivo(first.next,last.previous);
    }
    //Ejercicio 4
    public void reversarRecursivo(){
        reversarRecursivo(this.first,this.last);
    }
    //Ejercicio 4 con la recursividad
    private void reversarRecursivo(Node<E> first,Node<E> last){
        if(first!=last && first.previous!=last){
            E info= last.data;
            last.data=first.data;
            first.data=info;
            reversarRecursivo(first.next,last.previous);
        }
        
    }
    //Ejercicio 5 de la forma iterativa
    public void removeALLiterativa(E element){
        Node<E> primero= first;
        Node<E> ultimo=last;
        int tm=current;
        int veces_recorrido=0;
        if(element!=null){
             while(primero!=ultimo && primero.previous!=ultimo){
                System.out.println(this);
                 System.out.println(primero.data);
                 System.out.println(ultimo.data);
                if(primero.data.equals(element)){
                    primero=eliminarNode(primero,"Ascendente");
                }if(ultimo.data.equals(element)){
                    ultimo=eliminarNode(ultimo,"Descendente");
                }if(veces_recorrido!=0 || !primero.data.equals(element)){
                    primero=primero.next;
                }if(veces_recorrido!=0 || !ultimo.data.equals(element)){
                    ultimo=ultimo.previous;
                }
                veces_recorrido++;
            }
        }    
    }
    // Funcion auxiliar para el ejercicio 5
    private Node<E> eliminarNode(Node<E> eliminar,String forma){
        if(eliminar==first){
            removeFirst();
            return first;
        }else if(eliminar==last){
            removeLast();
            return last;
        } else{
            Node<E> previo=eliminar.previous;
            previo.next=eliminar.next;
            eliminar.next.previous=previo;
            eliminar.data=null;
            eliminar.next=null;
            eliminar.previous=null;
            current--;
            if(forma.equals("Ascendente")){
                return previo;
            }
            return previo.previous;
        }
    }
    //Ejercicio 5 de forma recursiva
    public void removeAllRecursivo(E element){
        removeAllRecursivo(first,last,element);
    }
    // Funcion para el ejercicio 5 recursivo
    private void removeAllRecursivo(Node<E> primero,Node<E> Final,E element) {
         if(primero!=Final && primero.previous!=Final && element!=null){
            if(primero.data.equals(element)){
                primero=eliminarNode(primero,"Ascendente");
            }else{
                primero=primero.next;
            }
            if(Final.data.equals(element)){
                Final=eliminarNode(Final,"Descendente");
            }else{
                Final=Final.previous;
            }
            removeAllRecursivo(primero,Final,element);
         }
    }
    // Ejercicio 6 de forma iterativa
    public DoublyLinkedList<Integer> elementosComunes (DoublyLinkedList<Integer> descendente){
        DoublyLinkedList<Integer> repetido= new DoublyLinkedList<>();
        Node<Integer> primerNode=(Node<Integer>)this.first;
        Node<Integer> ultimo=(Node<Integer>) descendente.last;
        while(primerNode!=null || ultimo!=null){
                if(primerNode.data > ultimo.data){
                    ultimo=ultimo.previous;
                }else if(ultimo.data > primerNode.data){
                    primerNode=primerNode.next;
                }else if(primerNode.data.equals(ultimo.data)){
                    repetido.addLast(primerNode.data);
                    ultimo=ultimo.previous;
                    primerNode=primerNode.next;
                }
            }
        return repetido;
    }
    //Funcion 8 de forma recursiva
    public boolean isReverse(DoublyLinkedList<E> l){
        if(l.size()!=this.size() && l!=null) return false;
        return isReverse(l.first,l.last,this.first,this.last);
    }
    //Funcion auxiliar para lograr la recursividad del ejercicio 8
    public boolean isReverse(Node<E> datoinicio,Node<E> datofin,Node<E> dato2_inicio,Node<E> dato2_fin){
        if(!dato2_inicio.data.equals(datofin.data) || !dato2_fin.data.equals(datoinicio.data)){
            return false;
         }else if(datoinicio==datofin || dato2_inicio.previous==dato2_fin){
            return true;
        }else{
            return isReverse(datoinicio.next,datofin.previous,dato2_inicio.next,dato2_fin.previous);
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
            first.previous=elemento;
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
            elemento.previous=last;
            last=elemento;
        }
        current++;
        return true;
    }

    @Override
    public boolean add(E element, int index) {
        if(index>=current || index<0 || element==null) {
            return false;
        }else if(index== 0){
            return addFirst(element);
        }else if(index== current){
            return addLast(element);
        }
        Node<E> actual= getNode(index);
        Node<E> previo=actual.previous;
        Node<E> elemento= new Node<>(element);
        actual.previous=elemento;
        previo.next=elemento;
        elemento.next=actual;
        elemento.previous=previo;
        current++;
        return true;
    }

    @Override
    public E get(int index) {
        if(index>=current || index<0)  throw new ArrayIndexOutOfBoundsException("Un indice mayor al numero de elementos");
        return getNode(index).data;
    }
    private Node<E> getNode(int index){
        Node<E> primero= first.next;
        for(int i=0;i<=index;i++){
            primero=primero.next;
        }
        return primero;
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
        if(first==last) {
            first.data=null;
            first=last=null;
        }else if(index== 0){
            removeFirst();
            return true;
        }else if(index== current-1){
            removeLast();
            return true;
        } else{
            Node<E> actual= getNode(index);
            Node<E> previo=actual.previous;
            previo.next=actual.next;
            actual.next.previous=previo;
            actual.next=null;
            actual.data=null;
            actual.previous=null;
            actual=null;
        }
        current--;
        return true;
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

    @Override
    public boolean removeFirst() {
        if(isEmpty()) return false;
        if(first==last) {
            first.data=null;
            first=last=null ;
        } else{
            Node<E> temporal=first;
            first=first.next;
            first.previous=null;
            temporal.data=null;
            temporal.next=null;
        }
        current--;
        return true;
    }

    @Override
    public boolean removeLast() {
        if(isEmpty()) return false;
        if(first== last){
            first.data=null;
            first=last=null;
        }else{
            last.data=null;
            Node<E> prev=last.previous;
            last.previous=null;
            prev.next=null;
            last=prev;
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
    public void agregarElementos(E array[]){
        for(E i :array){
            this.addLast(i);
        }
    }
}
    
