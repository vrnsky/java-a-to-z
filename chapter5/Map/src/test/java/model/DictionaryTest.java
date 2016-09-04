package model;

import org.junit.Ignore;
import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

/**
 * Created by Egor on 04.09.2016.
 */
public class DictionaryTest {

    @Test
    public void whenTryAddValueToTheDictionaryShouldCheckThatValueWasAdd() {
        Dictionary<String, String> dictionary = new Dictionary<>();
        dictionary.insert("Google", "Billion");
        assertThat(dictionary.get("Google"), is("Billion"));
    }

    @Test
    public void whenTryAddValueToTheDictionaryShouldCheckByCallContainsMethod() {
        Dictionary<String, String> dictionary = new Dictionary<>();
        dictionary.insert("Java", "8");
        assertThat(dictionary.contains("Java"), is(true));
    }

    @Test
    public void whenTryUpdateValueAtTheDictionaryShouldCheckThatValueWasUpdate() {
        Dictionary<String, String> dictionary = new Dictionary<>();
        dictionary.insert("key1", "value1");
        dictionary.insert("key1", "value2");
        assertThat(dictionary.get("key1"), is("value2"));
    }

    @Test
    public void whenTryInsertValueAndRemoveShouldCheckThatValueWasRemoved() {
        Dictionary<String, String> dictionary = new Dictionary<>();
        dictionary.insert("key", "value");
        boolean removed = dictionary.delete("key");
        assertThat(removed, is(true));
    }

    @Test(expected = IllegalStateException.class)
    public void whenTryCheckThatInDictionaryContainsNullElementShouldCheckThatMethodThrowException() {
        Dictionary<String, String> dictionary = new Dictionary<>();
        dictionary.contains(null);
    }

    @Test
    public void whenTryUsingIteratorForMovingAcrossDictionaryShouldCheckThatIteratorWorksCorrect() {
        Dictionary<String, String> dictionary = new Dictionary<>();
        dictionary.insert("key1", "value1");
        assertThat(dictionary.next(), is("value1"));
    }

    @Test
    public void whenTryUsingIteratorShouldCheckThatMethodHasNextReturnFalseIfMapIsEmpty() {
        Dictionary<String, String> dictionary = new Dictionary<>();
        assertThat(dictionary.hasNext(), is(false));
    }

    @Test
    public void whenTryCallSizeMethodShouldCheckThatReturnSizeOfDictionary() {
        Dictionary<String, String> dictionary = new Dictionary<>();
        dictionary.insert("key1", "value1");
        assertThat(dictionary.size(), is(1));
    }
}
