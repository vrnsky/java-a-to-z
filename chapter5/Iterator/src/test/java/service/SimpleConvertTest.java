package service;

import org.junit.Test;

import java.util.*;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

/**
 * Unit test for SimpleConvert.java.
 * It test additional operation for iterators.
 */
public class SimpleConvertTest {

    /**
     * When try convert iterator of iterator should check that all value get correct.
     */
    @Test
    public void whenTryConvertTwoNestIteratorShouldCheckThatConvertIteratorReturnCorrectValues() {

        //Assign block
        SimpleConvert iterator = new SimpleConvert();
        List<Integer> one = new ArrayList<>(Arrays.asList(1,2,3,4));
        List<Integer> two = new ArrayList<>(Arrays.asList(8,9,5,6));
        List<Integer> three = new ArrayList<>(Arrays.asList(7,10,11,12));
        List<Iterator<Integer>> list = new ArrayList<>(Arrays.asList(one.iterator(), two.iterator(), three.iterator()));
        int[] expected = new int[]{1,2,3,4,8,9,5,6,7,10,11,12};

        //Action block
        Iterator<Integer> converted = iterator.convert(list.iterator());
        int index = 0;
        int[] actual = new int[expected.length];

        while(converted.hasNext()) {
            actual[index++] = converted.next();
        }

        //Assert block
        assertThat(Arrays.toString(actual), is(Arrays.toString(expected)));
    }

    /**
     * When try give converter null should check that app throw exception.
     */
    @Test(expected = IllegalArgumentException.class)
    public void whenTryGiveNullToTheConverterShouldCheckThatConverterThrowException() {

        //Assign block
        SimpleConvert converter = new SimpleConvert();

        //Action block
        converter.convert(null);
    }

    /**
     * When try give empty list should check that iterator return false.
     */
    @Test
    public void whenTryGiveEmptyListToTheConvertShouldSomethingCheck() {

        //Assign block
        SimpleConvert iterator = new SimpleConvert();
        List<Integer> one = new ArrayList<>();
        List<Iterator<Integer>> list = new ArrayList<>(Arrays.asList(one.iterator()));

        //Action block
        Iterator<Integer> converted = iterator.convert(list.iterator());

        //Assert block
        assertThat(converted.hasNext(), is(false));
    }

}

