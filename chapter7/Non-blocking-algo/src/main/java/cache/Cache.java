package cache;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.function.BiFunction;

/**
 * @author evrnsky
 * @version 0.1
 * @since 29.11.2016
 * @param <T> type of values which may contains this cache.
 * Thread safe cache, which provide thread safe by using concurrent map.
 */
public class Cache<T extends Model> {

    /**
     * Thread safe map.
     */
    private ConcurrentMap<Long, T> cache;

    /**
     * Default.
     */
    public Cache() {
        this.cache = new ConcurrentHashMap<>();
    }

    /**
     * Add to the cache new model.
     * @param model instance of model class or it subclasses.
     */
    public void add(T model) {
        this.cache.put(model.getId(), model);
    }

    /**
     * Update model at the cache by check version of model.
     * If version is equals update model, otherwise throw exception.
     * @param model instance of model class or it subclasses.
     * @throws OptimisticException if version is difference.
     */
    public void update(T model) throws OptimisticException {
        this.cache.computeIfPresent(model.getId(), new BiFunction<Long, T, T>() {
            @Override
            public T apply(Long aLong, T oldModel) {
                if (model.getVersion() == oldModel.getVersion()) {
                    model.updateVersion();
                    return model;
                } else {
                    throw new OptimisticException("Version is difference.");
                }
            }
        });
    }

    /**
     * Remove model from cache.
     * @param model instance of model class or it subclasses.
     * @return true if object was removed from map, otherwise false.
     */
    public boolean delete(T model) {
        return this.cache.remove(model.getId(), model);
    }


    /**
     * Return element from cache.
     * @param id of searchable element.
     * @return null or object which is position for key.
     */
    public T get(long id) {
        return this.cache.get(id);
    }
}
