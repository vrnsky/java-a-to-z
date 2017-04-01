package model;

/**
 * @author evrnsky
 * @version 0.1
 * @since 25.09.2016
 * Concrete version of cache.
 */
public class SimpleCache extends AbstractCache {

    /**
     * Simple cache.
     * @param method describe method for loading.
     */
    public SimpleCache(LoadMethod method) {
        super(method);
    }
}
