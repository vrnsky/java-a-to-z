package service;

import java.util.NoSuchElementException;
import java.util.Optional;

/**
 * Model of storage which determine how to data hold and access to all value at the array.
 * @author evrnsky
 * @version 1.0.
 */
public abstract class AbstractStorage<T extends Base> implements Store {

    /**
     * At this place hold all values.
     */
    private SimpleArray<T> values;

    /**
     * Construct new storage with given capacity.
     * @param capacity size of simple array.
     */
    public AbstractStorage(int capacity) {
        this.values = new SimpleArray<>(capacity);
    }

    /**
     * Default constructor.
     */
    public AbstractStorage() {
        this(10);
    }

    /**
     * Add new value to the simple array.
     * @param value object which will insert to the simple array.
     */
    public void add(T value) {
        this.values.add(value);
    }


    /**
     * Return object which id is equals given id.
     * @param id of searching item.
     * @return item if it was find at the storage, otherwise false.
     */
    public T get(String id) {
        Optional<T> value = this.findValueById(id);
        if(!value.isPresent()) {
            throw new NoSuchElementException("Element with given id not exist at the storage");
        } else {
            return value.get();
        }
    }


    /**
     * Remove object with given id from storage.
     * @param id of remove item.
     */
    public void remove(String id) {
       Optional<T> value = this.findValueById(id);
       if(!value.isPresent()) {
           throw new NoSuchElementException("Element with given id not exist at the storage!");
       } else {
           for(int index = 0; index < this.values.size(); index++) {
               if(value.get().equals(this.values.get(index))) {
                   this.values.delete(index);
                   break;
               }
           }
       }
    }


    /**
     * Find at the storage id with given id and set to the given value.
     * @param id of item.
     * @param newValue new version of item in storage.
     */
    public void update(String id, T newValue) {
        Optional<T> value = this.findValueById(id);
        if(!value.isPresent()) {
            throw new NoSuchElementException("Given element not exist at the storage");
        } else {
            for(int index = 0; index < this.values.size(); index++) {
                if(value.get().equals(this.values.get(index))) {
                    this.values.update(index, newValue);
                    break;
                }
            }
        }
    }

    /**
     * Find at the storage element with given id.
     * @param id of searching item.
     * @return instance of object which id is equals given id or Optional.empty
     */
    private Optional<T> findValueById(String id) {
        Optional<T> result = Optional.empty();
        for(int index = 0; index < this.values.size(); index++) {
            T value = this.values.get(index);
            if(value != null) {
                if (value.getId().equals((id))){
                    result = Optional.of(this.values.get(index));
                    break;
                }
            }
        }
        return result;
    }
}
