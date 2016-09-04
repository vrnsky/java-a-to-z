package model;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

/**
 * Unit test for Dictionary.java
 */
public class DictionaryTest {

    /**
     * When try add value to the dictionary should check that value was added.
     */
    @Test
    public void whenTryAddValueToTheDictionaryShouldCheckThatValueWasAdd() {
        Dictionary<String, String> dictionary = new Dictionary<>();
        dictionary.insert("Google", "Billion");
        assertThat(dictionary.get("Google"), is("Billion"));
    }

    /**
     * When try add value to the dictionary should check that value was added by call contains method.
     */
    @Test
    public void whenTryAddValueToTheDictionaryShouldCheckByCallContainsMethod() {
        Dictionary<String, String> dictionary = new Dictionary<>();
        dictionary.insert("Java", "8");
        assertThat(dictionary.contains("Java"), is(true));
    }

    /**
     * When try update value at the dictionary should check that value was update.
     */
    @Test
    public void whenTryUpdateValueAtTheDictionaryShouldCheckThatValueWasUpdate() {
        Dictionary<String, String> dictionary = new Dictionary<>();
        dictionary.insert("key1", "value1");
        dictionary.insert("key1", "value2");
        assertThat(dictionary.get("key1"), is("value2"));
    }

    /**
     * When try insert value and remove should check that value was removed.
     */
    @Test
    public void whenTryInsertValueAndRemoveShouldCheckThatValueWasRemoved() {
        Dictionary<String, String> dictionary = new Dictionary<>();
        dictionary.insert("key", "value");
        boolean removed = dictionary.delete("key");
        assertThat(removed, is(true));
    }

    /**
     * When try check that in dictionary contains null value should check that method throw exception.
     */
    @Test(expected = IllegalStateException.class)
    public void whenTryCheckThatInDictionaryContainsNullElementShouldCheckThatMethodThrowException() {
        Dictionary<String, String> dictionary = new Dictionary<>();
        dictionary.contains(null);
    }

    /**
     * When try using iterator for moving across dictionary should check that iterator works correct.
     */
    @Test
    public void whenTryUsingIteratorForMovingAcrossDictionaryShouldCheckThatIteratorWorksCorrect() {
        Dictionary<String, String> dictionary = new Dictionary<>();
        dictionary.insert("key1", "value1");
        assertThat(dictionary.next(), is("value1"));
    }

    /**
     * When try using iterator on empty dictionary should check that method has next return false.
     */
    @Test
    public void whenTryUsingIteratorShouldCheckThatMethodHasNextReturnFalseIfMapIsEmpty() {
        Dictionary<String, String> dictionary = new Dictionary<>();
        assertThat(dictionary.hasNext(), is(false));
    }

    /**
     * When try call size method should check that method return size of dictionary.
     */
    @Test
    public void whenTryCallSizeMethodShouldCheckThatReturnSizeOfDictionary() {
        Dictionary<String, String> dictionary = new Dictionary<>();
        dictionary.insert("key1", "value1");
        assertThat(dictionary.size(), is(1));
    }
}
