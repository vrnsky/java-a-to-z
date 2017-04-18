package cache;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * @author evrnsky
 * @version 0.1
 * @since 18.04.2017
 *
 * This unit test for Cache.java
 */
public class CacheTest {

    /**
     * When try update model with difference version should check that app throw exception.
     * @throws Exception if some error happened.
     */
    @Test(expected = OptimisticException.class)
    public void whenTryUpdateModelVersionIsDifferenceShouldCheckThatThrowException() throws Exception {
        Cache<Model> cache = new Cache<>();
        Model one = new Model();
        Model two = new Model();
        two.setId(one.getId());
        cache.add(one);
        two.updateVersion();
        cache.update(two);
    }

    /**
     * When try add element should check that all added.
     * @throws Exception if some error happened.
     */
    @Test
    public void whenTryAddElementShouldCheckThatAllIsOk() throws Exception {
        Cache<Model> models = new Cache<>();
        Model model = new Model();
        models.add(model);
        assertThat(models.get(model.getId()), is(model));
    }
}