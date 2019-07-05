/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author User
 */
public class ArrayList_trabalho <E> implements List<E>{
    
    public static final int CAPACITY = 5;
    private E [] data;
    private int size = 0;

    public ArrayList_trabalho() {
        this(CAPACITY);
    }

    public ArrayList_trabalho(int capacity) {
        data = (E[]) new Object[capacity];
    }
    
    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    protected void checkIndex(int i, int n) {
        if(i < 0 || i >= n)
        throw new IndexOutOfBoundsException("The index "+i+" surpass the array size");
    }
    
    public E get(int i) {
        checkIndex(i,size);
        return data[i];
    }
    
        
    public E set(int i, E e){
        checkIndex(i, size);
        E temp = data[i];
        data[i] = e;
        return temp;
    }

    protected void resize(int capacity){
        E[] temp = (E[]) new Object[capacity];
        for (int i = 0; i < size; i++) {
            temp[i] = data[i];
            data = temp;
        }
    }
   
    public void add(int i, E e){
        checkIndex(i, size+1);
        if(size == data.length)
            resize(2 * data.length);
        for (int j = size-1; j >= i; j--) 
            data[j+1] = data[j];
        data[i] = e;
        size++;
    }

    public void add (E e){
        add(size, e);
    }
    
    
    public E remove(int i, E e) {
        checkIndex(i, size);
        E temp = data[i];
        for (int j = i; j < size-1; j++) 
            data[j] = data[j+1];
        data[size-1] = null;
        size--;
        return temp;
    }
    
    public String toString(){
        StringBuilder sb = new StringBuilder("( ");
        for (int i = 0; i < size; i++) {
            if(i > 0)
                sb.append(", ");
            sb.append(data[i]);
        }
        sb.append(" )");
        return sb.toString();
        
    }
    
}
