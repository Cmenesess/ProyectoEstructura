package Collecciones;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author carloshumbertomenesesmurillo
 */
public class ArrayList<E> implements List<E> {
    private  E[] array;
    private int current;
    
    public ArrayList(){
        array = (E[]) new Object [10];
        current=0;
    }
    public ArrayList(int casillas) throws Exception{
        if(casillas<=0) throw new Exception("Numero no valido");
        array = (E[]) new Object [casillas];
        current=0;
    }
    @Override
    public boolean addFirst(E element) {
        if(element==null) return false;
        if(current==array.length) addCapacity(1,0);
        else{
            for(int i=current; i>0;i--){
                array[i]=array[i-1]; 
            }
        }           
        array[0]=element;
        current++;
        return true;
        
    }

    @Override
    public boolean addLast(E element) {
        if(element == null) return false;
        if(current == array.length) addCapacity(0,0);
        array[current++]=element;
        return true;
    }
    private void addCapacity(int offset, int start) {
        E[] tmp = (E[]) new Object[array.length + (array.length * 2 / 3)];
        if (start > 0){
            for (int i = 0; i < start; i++){
                tmp[i] = array[i];
            }
        }
        for (int i = start; i < array.length; i++) {
            tmp[i + offset] = array[i];
        }
        array = tmp;
    }
    @Override
    public boolean add(E element, int index) {
        if (element == null) return false;      
        if (index < 0 || index>current) return false;
        if (index == current) {
            return this.addLast(element);
        }
        if (index == 0 ) {
            return this.addFirst(element);
        }
        if (current == array.length) {
            addCapacity(1,index); 
        }else{
            for (int i = current - 1; i >= index; i--) {
                array[i + 1] = array[i];
            }
        }
        array[index] = element;
        current ++;
        return true;
    }


    @Override
    public E get(int index) throws IndexOutOfBoundsException {
       if(index <0|| index>current) throw new IndexOutOfBoundsException();
       return array[index];
    }

    @Override
    public int size() {
        return current;
    }

    @Override
    public boolean isEmpty() {
        return current==0;
    }

    @Override
    public boolean remove(int index) {
        if(0>index || index>=current) throw  new ArrayIndexOutOfBoundsException();
        if (isEmpty())  return false;
        for(int i=index; i<current-1;i++){
             array[i]=array[i+1];
         }
        array[--current]=null;
        return true;        
    }

    @Override
    public boolean contains(E element) {
        if(element == null) return false;
        for(int i=0;i<current;i++)
            if(array[i].equals(element)) return true;
        return false;
    }

    @Override
    public boolean removeFirst() {
        if(isEmpty()) return false;
        for(int i=0; i<current-1;i++)
            array[i]=array[i+1];
        array[--current]=null;
        return true;
    }

    @Override
    public boolean removeLast() {
        if(isEmpty()) return false;
        array[--current]=null;
        return true;
    }

    @Override
    public E getFirst() {
        if(isEmpty()) return null;
        return array[0];
    }

    @Override
    public E getLAst() {
        if(isEmpty()) return null;
        return array[current-1];
    }
    @Override
    public String toString(){
        StringBuilder sb= new StringBuilder();
        sb.append("[");
        for (int i=0; i<current-1;i++){
            sb.append(array[i]);
            sb.append(",");
        }
        if(!isEmpty()){
            sb.append(array[current-1]);
        }
        sb.append(']');
        return sb.toString();
    }
    @Override
    public boolean equals(Object o){
        if(o== null) return false;
        if(this == o) return true;
        if(this.getClass()!= o.getClass()) return false;
        ArrayList<E> otro= (ArrayList<E>)o;
        if(this.size()!= otro.size()) return false;
        for(int i=0;i<this.size();i++) 
            if(!array[i].equals(otro.array[i])) return false;
        return true;
    }
    public List<E> slicing(int start, int end) {
        if(start>=end || end>=current) return new ArrayList<>();
        List<E> lista= new ArrayList<>();
        for(int i=start;i<end;i++){
            lista.addLast(this.array[i]);
            
        }
        return lista;
    }
}