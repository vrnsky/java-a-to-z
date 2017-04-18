package cache;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsNull.notNullValue;
import static org.junit.Assert.assertThat;

/**
 * @author evrnsky
 * @version 0.1
 * @since 18.04.2017
 *
 * This unit test for Model.java
 */
public class ModelTest {

    /**
     * When try create a model should check that all is ok.
     * @throws Exception if some error happened.
     */
    @Test
    public void whenTryCreateAModelShouldCheckThatAllIsOk() throws Exception {
        Model model = new Model();
        assertThat(model, is(notNullValue()));
    }

    /**
     * When try create a model and update version should check that all is ok.
     */
    @Test
    public void whenTryUpdateVersionShouldCheckThatVersionUpdated() {
        Model model = new Model();
        model.updateVersion();
        assertThat(model.getVersion(), is(1));
    }

    /**
     * When try get id should check that id is good.
     */
    @Test
    public void whenTryGetIdShouldCheckThatIdGood() {
        Model model = new Model();
        assertThat(model.getId(), is(notNullValue()));
    }
}