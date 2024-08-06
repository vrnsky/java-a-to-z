package cache;


import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsNull.notNullValue;

/**
 * @author evrnsky
 * @version 0.1
 * @since 18.04.2017
 *
 * This unit test for Model.java
 */
class ModelTest {

    /**
     * When try to create a model should check that all is ok.
     * @throws Exception if some error happened.
     */
    @Test
    void whenTryCreateAModelShouldCheckThatAllIsOk() throws Exception {
        Model model = new Model();
        assertThat(model, is(notNullValue()));
    }

    /**
     * When try to create a model and update version should check that all is ok.
     */
    @Test
    void whenTryUpdateVersionShouldCheckThatVersionUpdated() {
        Model model = new Model();
        model.updateVersion();
        assertThat(model.getVersion(), is(1));
    }

    /**
     * When try to get id should check that id is good.
     */
    @Test
    void whenTryGetIdShouldCheckThatIdGood() {
        Model model = new Model();
        assertThat(model.getId(), is(notNullValue()));
    }
}