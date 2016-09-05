package model;

/**
 * Model of employer.
 */
public class Employee {

    /**
     * Name of employer.
     */
    private String name;

    /**
     * Salary for current employer.
     */
    private int salary;

    /**
     * Create a new employer with given name and salary.
     * @param name of employee.
     * @param salary for employee.
     */
    public Employee(String name, int salary) {
        this.name = name;
        this.salary = salary;
    }

    /**
     * Return true if name and salary equals for the given object.
     * @param object for compare.
     * @return true if objects are equals, otherwise false.
     */
    @Override
    public boolean equals(Object object) {
        if(object == this) {
            return true;
        }
        if(object == null) {
            return false;
        }

        Employee employee = (Employee)object;
        return employee.name.equals(this.name) && employee.salary == salary;
    }

    /**
     * Return hash code of this object.
     * @return hash code of this object.
     */
    @Override
    public int hashCode() {
       int result = 17;
       result = 31 * result + this.salary;
       int nameHashCode = this.name == null ? 0 : name.hashCode();
       result = 31 * result + nameHashCode;
       return result;
    }

    /**
     * Return name of this employee.
     * @return name of employee.
     */
    public String getName() {
        return this.name;
    }

    /**
     * Update name of employee.
     * @param name new version of employee name.
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Return salary for this employee.
     * @return
     */
    public int getSalary() {
        return this.salary;
    }

    /**
     * Update salary for this employee.
     * @param salary new version of salary.
     */
    public void setSalary(int salary) {
        this.salary = salary;
    }
}
