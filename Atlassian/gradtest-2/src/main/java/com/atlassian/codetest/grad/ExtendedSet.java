package com.atlassian.codetest.grad;

import java.util.Iterator;
import java.util.Set;

/**
 * A structure that holds an unordered group of unique items.
 */
public interface ExtendedSet<T> extends Set<T>
{
    /**
     * Return a new Set with the contents of both sets.
     *
     * @param secondSetExtension The set to combine with
     * @return a new Set that is the union of both sets
     */
    ExtendedSet<T> union(Set<T> secondSetExtension);

    /**
     * Return a Set that contains all elements that are present in both this set and the second set.
     *
     * @param secondSetExtension The set we want to calculate the intersection with
     * @return a new Set that is the intersection of both sets
     */
    ExtendedSet<T> intersect(Set<T> secondSetExtension);

    /**
     * Return a Set that contains all elements which are in one set or the other but not in both.
     *
     * @param secondSetExtension The set we want to calculate the difference with
     * @return a new Set that is the symmetric difference of both sets
     */
    ExtendedSet<T> symmetricDifference(Set<T> secondSetExtension);

    /**
     * This method adds a new element to the ExtendedSet.
     * It should return true if the element is added.
     * It should return false if adding the element fails for any reason, including the element already being present
     * or the set being at max capacity.
     *
     * @return true if the element is successfully added to the set, or false otherwise
     */
    boolean add(T e);

    /**
     * Return iterator that iterates over the set
     *
     * @return an iterator that iterates over the set
     */
    Iterator<T> iterator();

    /**
     * Return the number of elements in the set
     *
     * @returns the size of the set
     */
    int size();
}
