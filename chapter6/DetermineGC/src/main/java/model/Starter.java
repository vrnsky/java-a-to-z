package model;

/**
 * @author evrnsky
 * @version 0.1
 * @since 21.09.2016
 */
public class Starter {

    /**
     * Model of user.
     */
    private static final class User {

        /**
         * First name of user.
         */
        private String firstName;

        /**
         * Surname of user.
         */
        private String surName;

        /**
         * Age of user.
         */
        private int age;

        /**
         * Create a new user with given params.
         * @param firstName of user.
         * @param surName of user.
         * @param age of user.
         */
        public User(String firstName, String surName, int age) {
            this.firstName = firstName;
            this.surName = surName;
            this.age = age;
        }

        /**
         * This method calls before GC remove object from heap.
         * @throws Throwable if something was wrong.
         */
        @Override
        public void finalize() throws Throwable {
            super.finalize();
            System.out.println("User object was destroyed");
        }
    }

    /**
     * Entry point at the program.
     * @param args
     */
    public static void main(String[] args) {
      new Starter().tryGC();
    }

    /**
     * Create a many object which not used. JVM watch this situation and call
     * garbage collection mechanism which remove not used object or at the program not contains
     * reference to object.
     */
    private void tryGC() {
        for(int index = 0; index < 10000; index++) {
            User user = new User(String.format("%s", index), String.format("%s", index), index);
        }
    }

}
