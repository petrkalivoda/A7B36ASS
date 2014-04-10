/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package kwic.events;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Observable;

/**
 *
 * @author Petr Kalivoda
 */
public class ObservableList<E> extends Observable implements List<E> {
    
    public enum Event {
        ADD,
        REMOVE,
        UPDATE,
    }
    
    private List<E> l;
    
    public ObservableList(List<E> list) {
        l = list;
    }

    @Override
    public int size() {
        return l.size();
    }

    @Override
    public boolean isEmpty() {
        return l.isEmpty();
    }

    @Override
    public boolean contains(Object o) {
        return l.contains(o);
    }

    @Override
    public Iterator<E> iterator() {
        return l.iterator();
    }

    @Override
    public Object[] toArray() {
        return l.toArray();
    }

    @Override
    public <T> T[] toArray(T[] a) {
        return l.toArray(a);
    }

    @Override
    public boolean add(E e) {
        boolean b = l.add(e);
        setChanged();
        notifyObservers(Event.ADD);
        return b;
    }

    @Override
    public boolean remove(Object o) {
        boolean b = l.remove(o);
        setChanged();
        notifyObservers(Event.REMOVE);
        return b;
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        return l.containsAll(c);
    }

    @Override
    public boolean addAll(Collection<? extends E> c) {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean addAll(int index, Collection<? extends E> c) {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void clear() {
        throw new UnsupportedOperationException();
    }

    @Override
    public E get(int index) {
        return l.get(index);
    }

    @Override
    public E set(int index, E element) {
        E e = l.set(index, element);
        setChanged();
        notifyObservers(Event.UPDATE);
        return e;
    }

    @Override
    public void add(int index, E element) {
        l.add(index, element);
        setChanged();
        notifyObservers(Event.ADD);
    }

    @Override
    public E remove(int index) {
        E e = l.remove(index);
        setChanged();
        notifyObservers(Event.REMOVE);
        return e;
    }

    @Override
    public int indexOf(Object o) {
        return l.indexOf(o);
    }

    @Override
    public int lastIndexOf(Object o) {
        return l.lastIndexOf(o);
    }

    @Override
    public ListIterator<E> listIterator() {
        return l.listIterator();
    }

    @Override
    public ListIterator<E> listIterator(int index) {
        return l.listIterator(index);
    }

    @Override
    public List<E> subList(int fromIndex, int toIndex) {
        return l.subList(fromIndex, toIndex);
    }
    
}
