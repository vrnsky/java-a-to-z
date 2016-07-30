package model;

/**
 * Model of edit checker.
 */
public class EditChecker implements Checker {

    /**
     * Check that given user exit in given users array.
     * @param users list of users.
     * @param user user for checking.
     * @return true if list have given user, otherwise false.
     */
    @Override
    public boolean check(User[] users, User user) {
        boolean canEdit = false;
        for(User existUser : users) {
            if(existUser != null) {
                if (compareAge(existUser, user) && compareId(existUser, user) && compareName(existUser, user)) {
                    canEdit = true;
                }
            }
        }
        return canEdit;
    }

    /**
     * Check that name is equals.
     * @param user from array.
     * @param other given user.
     * @return true if name is equals, otherwise false.
     */
    private boolean compareName(User user, User other) {
        return user.getName().equals(other.getName());
    }

    /**
     * Check that id is equals.
     * @param user from array.
     * @param other given user.
     * @return true if name is equals, otherwise false.
     */
    private boolean compareId(User user, User other) {
        return user.getId() == other.getId();
    }

    /**
     * Check that ages is equals.
     * @param user from array.
     * @param other given user.
     * @return true if age is equals, otherwise false.
     */
    private boolean compareAge(User user, User other) {
        return user.getAge() == other.getAge();
    }
}
