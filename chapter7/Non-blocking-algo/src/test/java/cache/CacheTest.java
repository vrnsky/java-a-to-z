package cache;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

/**
 * @author evrnsky
 * @version 0.1
 * @since 18.04.2017
 * <p>
 * This unit test for Cache.java
 */
class CacheTest {

    /**
     * When try update model with difference version should check that app throw exception.
     */
    @Test
    void whenTryUpdateModelVersionIsDifferenceShouldCheckThatThrowException() {
        Assertions.assertThrows(OptimisticException.class, () -> {
            Cache<Model> cache = new Cache<>();
            Model one = new Model();
            Model two = new Model();
            two.setId(one.getId());
            cache.add(one);
            two.updateVersion();
            cache.update(two);
        });
    }

    /**
     * When try to add element should check that all added.
     */
    @Test
    void whenTryAddElementShouldCheckThatAllIsOk() {
        Cache<Model> models = new Cache<>();
        Model model = new Model();
        models.add(model);
        assertThat(models.get(model.getId()), is(model));
    }
}