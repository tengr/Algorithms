package com.atlassian.codetest.grad;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;

/**
 * Some more advanced tests
 *
 * These check union, intersection and symmetric difference
 */
public class ExtendedSetTest {

    private ExtendedSetImpl<String> createCollection(String... args)
    {
        return new ExtendedSetImpl<String>(args.length, Arrays.asList(args));
    }

    /**
     * Test the Union of two disjoint sets
     */
    @Test
    public void testDisjointUnion()
    {
        final ExtendedSet<String> firstExtendedSet = createCollection("a", "b");
        final ExtendedSet<String> secondExtendedSet = createCollection("c", "d");

        final ExtendedSet<String> union = firstExtendedSet.union(secondExtendedSet);

        assertTrue(union.contains("a"));
        assertTrue(union.contains("b"));
        assertTrue(union.contains("c"));
        assertTrue(union.contains("d"));
        assertEquals(4, union.size());
    }

    /**
     * Test the Union of two overlapping sets
     */
    @Test
    public void testOverlappingUnion()
    {
        final ExtendedSet<String> firstExtendedSet = createCollection("a", "b", "c");
        final ExtendedSet<String> secondExtendedSet = createCollection("c", "d", "e");

        final ExtendedSet<String> union = firstExtendedSet.union(secondExtendedSet);

        assertTrue(union.contains("a"));
        assertTrue(union.contains("b"));
        assertTrue(union.contains("c"));
        assertTrue(union.contains("d"));
        assertTrue(union.contains("e"));

        assertEquals(5, union.size());
    }

    /**
     * Test the Union of two identical sets
     */
    @Test
    public void testIdenticalUnion()
    {
        final ExtendedSet<String> firstExtendedSet = createCollection("a", "b", "c");
        final ExtendedSet<String> secondExtendedSet = createCollection("a", "b", "c");

        final ExtendedSet<String> union = firstExtendedSet.union(secondExtendedSet);

        assertTrue(union.contains("a"));
        assertTrue(union.contains("b"));
        assertTrue(union.contains("c"));

        assertEquals(3, union.size());
    }

    /**
     * Test the Union of an empty set
     */
    @Test
    public void testEmptySecondSetUnion()
    {
        final ExtendedSet<String> firstExtendedSet = createCollection("a", "b", "c");
        final ExtendedSet<String> secondExtendedSet = createCollection();

        final ExtendedSet<String> union = firstExtendedSet.union(secondExtendedSet);

        assertTrue(union.contains("a"));
        assertTrue(union.contains("b"));
        assertTrue(union.contains("c"));

        assertEquals(3, union.size());

    }

    /**
     * Test the Union of an empty set
     */
    @Test
    public void testEmptyFirstSetUnion()
    {
        final ExtendedSet<String> firstExtendedSet = createCollection();
        final ExtendedSet<String> secondExtendedSet = createCollection("a", "b", "c");

        final ExtendedSet<String> union = firstExtendedSet.union(secondExtendedSet);

        assertTrue(union.contains("a"));
        assertTrue(union.contains("b"));
        assertTrue(union.contains("c"));

        assertEquals(3, union.size());
    }

    /**
     * Test the Union of two empty sets
     */
    @Test
    public void testEmptyUnion()
    {
        final ExtendedSet<String> firstExtendedSet = createCollection();
        final ExtendedSet<String> secondExtendedSet = createCollection();

        final ExtendedSet<String> union = firstExtendedSet.union(secondExtendedSet);

        assertEquals(0, union.size());
    }

    /**
     * Test the Intersection of two disjoint sets
     */
    @Test
    public void testDisjointIntersection()
    {
        final ExtendedSet<String> firstExtendedSet = createCollection("a", "b");
        final ExtendedSet<String> secondExtendedSet = createCollection("c", "d");

        final ExtendedSet<String> intersection = firstExtendedSet.intersect(secondExtendedSet);

        assertEquals(0, intersection.size());
    }

    /**
     * Test the Intersection of two overlapping sets
     */
    @Test
    public void testOverlappingIntersection()
    {
        final ExtendedSet<String> firstExtendedSet = createCollection("a", "b", "c");
        final ExtendedSet<String> secondExtendedSet = createCollection("c", "d", "e");

        final ExtendedSet<String> intersection = firstExtendedSet.intersect(secondExtendedSet);

        assertTrue(intersection.contains("c"));

        assertEquals(1, intersection.size());
    }

    /**
     * Test the Intersection of two identical sets
     */
    @Test
    public void testIdenticalIntersection()
    {
        final ExtendedSet<String> firstExtendedSet = createCollection("a", "b", "c");
        final ExtendedSet<String> secondExtendedSet = createCollection("a", "b", "c");

        final ExtendedSet<String> intersection = firstExtendedSet.intersect(secondExtendedSet);

        assertTrue(intersection.contains("a"));
        assertTrue(intersection.contains("b"));
        assertTrue(intersection.contains("c"));

        assertEquals(3, intersection.size());
    }

    /**
     * Test the Intersection of an empty set
     */
    @Test
    public void testEmptySecondSetIntersection()
    {
        final ExtendedSet<String> firstExtendedSet = createCollection("a", "b", "c");
        final ExtendedSet<String> secondExtendedSet = createCollection();

        final ExtendedSet<String> intersection = firstExtendedSet.intersect(secondExtendedSet);

        assertEquals(0, intersection.size());
    }

    /**
     * Test the Intersection of an empty set
     */
    @Test
    public void testEmptyFirstSetIntersection()
    {
        final ExtendedSet<String> firstExtendedSet = createCollection();
        final ExtendedSet<String> secondExtendedSet = createCollection("a", "b", "c");

        final ExtendedSet<String> intersection = firstExtendedSet.intersect(secondExtendedSet);

        assertEquals(0, intersection.size());
    }

    /**
     * Test the Intersection of two empty sets
     */
    @Test
    public void testEmptyIntersection()
    {
        final ExtendedSet<String> firstExtendedSet = createCollection();
        final ExtendedSet<String> secondExtendedSet = createCollection();

        final ExtendedSet<String> intersection = firstExtendedSet.intersect(secondExtendedSet);

        assertEquals(0, intersection.size());
    }

    /**
     * Test the symmetric difference of two disjoint sets
     */
    @Test
    public void testDisjointSymmetricDifference()
    {
        final ExtendedSet<String> firstExtendedSet = createCollection("a", "b");
        final ExtendedSet<String> secondExtendedSet = createCollection("c", "d");

        final ExtendedSet<String> difference = firstExtendedSet.symmetricDifference(secondExtendedSet);

        assertTrue(difference.contains("a"));
        assertTrue(difference.contains("b"));
        assertTrue(difference.contains("c"));
        assertTrue(difference.contains("d"));

        assertEquals(4, difference.size());
    }

    /**
     * Test the Symmetric difference of two overlapping sets
     */
    @Test
    public void testOverlappingSymmetricDifference()
    {
        final ExtendedSet<String> firstExtendedSet = createCollection("a", "b", "c");
        final ExtendedSet<String> secondExtendedSet = createCollection("c", "d", "e");

        final ExtendedSet<String> difference = firstExtendedSet.symmetricDifference(secondExtendedSet);

        assertTrue(difference.contains("a"));
        assertTrue(difference.contains("b"));
        assertFalse(difference.contains("c"));
        assertTrue(difference.contains("d"));
        assertTrue(difference.contains("e"));

        assertEquals(4, difference.size());
    }

    /**
     * Test the Symmetric difference of two identical sets
     */
    @Test
    public void testIdenticalSymmetricDifference()
    {
        final ExtendedSet<String> firstExtendedSet = createCollection("a", "b", "c");
        final ExtendedSet<String> secondExtendedSet = createCollection("a", "b", "c");

        final ExtendedSet<String> difference = firstExtendedSet.symmetricDifference(secondExtendedSet);

        assertEquals(0, difference.size());
    }

    /**
     * Test the Symmetric difference of an empty set
     */
    @Test
    public void testEmptySecondSetSymmetricDifference()
    {
        final ExtendedSet<String> firstExtendedSet = createCollection("a", "b", "c");
        final ExtendedSet<String> secondExtendedSet = createCollection();

        final ExtendedSet<String> difference = firstExtendedSet.symmetricDifference(secondExtendedSet);

        assertTrue(difference.contains("a"));
        assertTrue(difference.contains("b"));
        assertTrue(difference.contains("c"));
        assertEquals(3, difference.size());
    }

    /**
     * Test the Symmetric difference of an empty set
     */
    @Test
    public void testEmptyFirstSetSymmetricifference()
    {
        final ExtendedSet<String> firstExtendedSet = createCollection();
        final ExtendedSet<String> secondExtendedSet = createCollection("a", "b", "c");

        final ExtendedSet<String> difference = firstExtendedSet.symmetricDifference(secondExtendedSet);

        assertTrue(difference.contains("a"));
        assertTrue(difference.contains("b"));
        assertTrue(difference.contains("c"));
        assertEquals(3, difference.size());
    }

    /**
     * Test the Symmetric difference of two empty sets
     */
    @Test
    public void testEmptySymmetricDifference()
    {
        final ExtendedSet<String> firstExtendedSet = createCollection();
        final ExtendedSet<String> secondExtendedSet = createCollection();

        final ExtendedSet<String> union = firstExtendedSet.union(secondExtendedSet);

        assertEquals(0, union.size());
    }

    @Test
    public void testIteratorAfterUnion()
    {
        final ExtendedSet<String> firstExtendedSet = createCollection("a", "b");
        final ExtendedSet<String> secondExtendedSet = createCollection("b", "c");
        final ExtendedSet<String> union = firstExtendedSet.union(secondExtendedSet);

        final List<String> iterValues = new ArrayList<String>();
        for (String setElement : union)
        {
            iterValues.add(setElement);
        }

        assertTrue(iterValues.contains("a"));
        assertTrue(iterValues.contains("b"));
        assertTrue(iterValues.contains("c"));
        assertEquals(iterValues.size(), 3);
    }

    @Test
    public void testIteratorAfterSymmetricDiff()
    {
        final ExtendedSet<String> firstExtendedSet = createCollection("a", "b");
        final ExtendedSet<String> secondExtendedSet = createCollection("b", "c");
        final ExtendedSet<String> union = firstExtendedSet.symmetricDifference(secondExtendedSet);

        final List<String> iterValues = new ArrayList<String>();
        for (String setElement : union)
        {
            iterValues.add(setElement);
        }

        assertTrue(iterValues.contains("a"));
        assertTrue(iterValues.contains("c"));
        assertEquals(iterValues.size(), 2);
    }

    @Test
    public void testIteratorAfterIntersection()
    {
        final ExtendedSet<String> firstExtendedSet = createCollection("a", "b", "c");
        final ExtendedSet<String> secondExtendedSet = createCollection("b", "c", "d");
        final ExtendedSet<String> union = firstExtendedSet.intersect(secondExtendedSet);

        final List<String> iterValues = new ArrayList<String>();
        for (String setElement : union)
        {
            iterValues.add(setElement);
        }

        assertTrue(iterValues.contains("b"));
        assertTrue(iterValues.contains("c"));
        assertEquals(iterValues.size(), 2);
    }
}
