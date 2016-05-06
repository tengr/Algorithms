package com.atlassian.codetest.grad;

import java.util.AbstractSet;
import java.util.Collection;
import java.util.Iterator;
import java.util.Set;

public class ExtendedSetImpl<T> extends AbstractSet<T> implements ExtendedSet<T> {
	protected Object[] arr;
	protected int size;	
	
    public ExtendedSetImpl(int maxCapacity) {
        super();
        arr = new Object[maxCapacity];
        this.size = 0;
    }

    public ExtendedSetImpl(int maxCapacity, Collection<? extends T> collection) {
        super();
        arr = new Object[maxCapacity];   		
        Object[] temp = collection.toArray();
        int idx = 0;
        for(idx = 0; idx < temp.length; idx++) arr[idx] = temp[idx];
        size = idx;
    }

    public boolean add(T e) {
    	if(size() == arr.length) return false;
    	if(this.contains(e)) return false;
    	arr[size++] = e;
        //throw new UnsupportedOperationException();
        return true;
    }

    /**
     * Implementing an iterator here will allow you (and our tests) to use several methods inherited from Set, including
     * contains(T) and addAll(Collection<T>)
     */
    public Iterator<T> iterator() {
        return new Iterator<T>() {

            //In Java, Iterator instance data goes here
        	int idx = 0;

            public boolean hasNext() {
                return idx < size();
            }

            public T next() {
                if(hasNext()) return (T)arr[idx++];
                return null;
            }
        };
    }

    public int size() {
        return this.size;
    }

    public ExtendedSet<T> union(Set<T> secondSetExtension) {
        //ExtendedSet<T> res = new ExtendedSet<T>(secondSetExtension);
        return null;
    }

    public ExtendedSet<T> intersect(Set<T> secondSetExtension) {
        return null;
    }

    public ExtendedSet<T> symmetricDifference(Set<T> secondSetExtension) {
        return null;
    }
}
