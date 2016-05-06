package com.atlassian.codetest.grad;
import java.util.Hashmap;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;

/**
 * Basic tests to check creation, add, size and iterator
 */
public class BasicSetTest {

    private ExtendedSetImpl<String> createCollection(String... args)
    {
        return new ExtendedSetImpl<String>(args.length, Arrays.asList(args));
    }

    /**
     * Test the set creation
     */
    @Test
    public void testSetCreation()
    {
        final ExtendedSet<String> extendedSet = createCollection("a", "b");
        assertTrue(extendedSet.contains("a"));
        assertTrue(extendedSet.contains("b"));
        assertFalse(extendedSet.contains("c"));
        assertFalse(extendedSet.contains("d"));
        assertEquals(2, extendedSet.size());
    }

    @Test
    public void testAdd()
    {
        final ExtendedSet<String> extendedSet = new ExtendedSetImpl<String>(5);
        extendedSet.add("c");
        assertTrue(extendedSet.contains("c"));
    }

    /**
     * Verify that a failed add returns false
     */
    @Test
    public void testFailedAdd()
    {
        final ExtendedSet<String> extendedSet = new ExtendedSetImpl<String>(5);
        assertTrue(extendedSet.add("a"));
        assertFalse(extendedSet.add("a"));
    }

    @Test
    public void testAddSize()
    {
        final ExtendedSet<String> extendedSet = new ExtendedSetImpl<String>(5);
        assertEquals(0, extendedSet.size());

        extendedSet.add("a");
        assertEquals(1, extendedSet.size());

        extendedSet.add("b");
        assertEquals(2, extendedSet.size());

        extendedSet.add("a"); //already present
        assertEquals(2, extendedSet.size());
    }

    @Test
    public void testAddingOverCapacity()
    {
        final ExtendedSet<String> extendedSet = new ExtendedSetImpl<String>(1);
        assertTrue(extendedSet.add("a"));
        assertEquals(extendedSet.size(), 1);

        assertFalse(extendedSet.add("b"));

        assertEquals(extendedSet.size(), 1);
        assertFalse(extendedSet.contains("b"));
        assertTrue(extendedSet.contains("a"));
    }

    @Test
    public void testIteratorOnAFullSet()
    {
        final ExtendedSet<String> extendedSet = createCollection("a", "b", "c");

        final List<String> iterValues = new ArrayList<String>();
        int elementsAdded = 0;
        for (String setElement : extendedSet)
        {
            iterValues.add(setElement);
            elementsAdded++;
        }

        assertTrue(iterValues.contains("a"));
        assertTrue(iterValues.contains("b"));
        assertTrue(iterValues.contains("c"));
        assertEquals(elementsAdded, 3);
    }

    @Test
    public void testIteratorOnHalfFullSet()
    {
        final ExtendedSet<String> extendedSet = new ExtendedSetImpl<String>(10);
        extendedSet.add("a");
        extendedSet.add("b");
        extendedSet.add("c");

        final List<String> results = new ArrayList<String>();
        int elementsAdded = 0;

        final Iterator<String> iter = extendedSet.iterator();
        while (iter.hasNext()) {
            results.add(iter.next());
            elementsAdded++;
        }

        assertEquals(elementsAdded, 3);
        assertTrue(results.contains("a"));
        assertTrue(results.contains("b"));
        assertTrue(results.contains("c"));
    }

    @Test
    public void testIteratorSize0Set()
    {
        final ExtendedSet<String> extendedSet = createCollection();
        final Iterator iter = extendedSet.iterator();
        assertFalse(iter.hasNext());
    }

    @Test
    public void testIteratorEmptySet()
    {
        final ExtendedSet<String> extendedSet = new ExtendedSetImpl<String>(5);
        final Iterator iter = extendedSet.iterator();
        assertFalse(iter.hasNext());
    }
}
