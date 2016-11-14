package storage;

import java.util.Collections;
import java.util.List;

/**
 * @author evrnsky
 * @version 0.1
 * @since 13.10.2016
 */
public class UserStorage {

    private List<User> userList;

    public UserStorage() {
        this.userList = Collections.synchronizedList(userList);
    }

    public User getById(String id) {
        User user = null;
        for(User client : userList) {
            if(client.getId().equals(id)) {
                user = client;
            }
        }
        return user;
    }

    public void editUser(User user) {

    }

    public boolean remove(String id) {
        return this.userList.remove(this.getById(id));
    }
}
