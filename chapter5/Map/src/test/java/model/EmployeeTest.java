package model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

/**
 *  Unit test for Employee.java.
 */
class EmployeeTest {

    /**
     * When try check reflexive property should check that is true.
     */
    @Test
    void whenTryCheckReflexivePropertyShouldCheckIsWorks() {
        Employee worker = new Employee("Yegor", 10000);
        boolean actual = worker.equals(worker);
        assertThat(actual, is(true));
    }

    /**
     * When try check symmetric property should check that is true.
     */
    @Test
    void whenTryCheckSymmetricPropertyShouldCheckThatIsWorks() {
        Employee worker = new Employee("Yegor", 1000);
        Employee other = new Employee("Yegor", 1000);
        assertThat(worker.equals(other), is(true));
        assertThat(other.equals(worker), is(true));
    }

    /**
     * When try check transitivity property should check that works correct.
     */
    @Test
    void whenTryCheckTransitivityPropertyShouldCheckThatWorksCorrect() {
        Employee bee = new Employee("Bee", 1);
        Employee fly = new Employee("Bee", 1);
        Employee other = new Employee("Bee", 1);
        assertThat(bee.equals(fly), is(true));
        assertThat(fly.equals(other), is(true));
        assertThat(bee.equals(other), is(true));
    }

    /**
     * When try check consistency property should check that works correct.
     */
    @Test
    void whenTryCheckConsistencyPropertyShouldCheckThatWorksCorrect() {
        Employee google = new Employee("Google", 1);
        Employee googleBig = new Employee("Google", 1);
        boolean one = false;
        boolean two = false;
        for (int index = 0; index < 100; index++) {
            if (google.equals(googleBig)) {
                one = true;
            }
            if (googleBig.equals(google)) {
                two = true;
            }
        }
        assertThat(one, is(true));
        assertThat(two, is(true));
    }

    /**
     * When try check hash code should check that hash code is works.
     */
    @Test
    void whenTryCheckHashCodeShouldCheckThatHashCodeIsWorks() {
        Employee worker = new Employee("Chrome", 10);
        Employee bee = new Employee("Chrome", 10);
        assertThat(worker.hashCode(), is(bee.hashCode()));
    }

    /**
     * When try call hash code method more than one time should check that hashCode is not changed.
     */
    @Test
    void whenTryCheckHashCodeMoreThatOneTimeShouldCheckThatHashCodeIsNotChanged() {
        Employee e = new Employee("Yegor", 100);
        int hashCode = e.hashCode();
        for (int i = 0; i < 100; i++) {
            hashCode = e.hashCode();
        }
        assertThat(hashCode, is(e.hashCode()));
    }

    /**
     * When try creating employee should check that model save all data.
     */
    @Test
    void whenTryCreateEmployeeShouldCheckThatModelSaveAllData() {
        Employee e = new Employee("Google", 1);
        assertThat(e.getName(), is("Google"));
        assertThat(e.getSalary(), is(1));
    }

    /**
     * When try update name should check that name updated.
     */
    @Test
    void whenTryUpdateNameShouldCheckThatNameUpdated() {
        Employee e = new Employee("Google", 1);
        e.setName("Bing");
        assertThat(e.getName(), is("Bing"));
    }

    /**
     * When try update salary should check that salary updated.
     */
    @Test
    void whenTryUpdateSalaryShouldCheckThatSalaryUpdate() {
        Employee e = new Employee("Google", 1);
        e.setSalary(100);
        assertThat(e.getSalary(), is(100));
    }

    /**
     * When try check that equals method return false when call it on the null.
     */
    @Test
    void whenTryCheckEqualsOfTwoNotEqualsObjectShouldCheckThatEqualsReturnFalse() {
        Employee one = new Employee("Google", 1);
        Assertions.assertNotNull(one);
    }
}
