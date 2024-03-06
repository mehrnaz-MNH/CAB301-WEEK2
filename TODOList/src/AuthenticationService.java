import java.util.ArrayList;

public class AuthenticationService implements IAuthenticationService {
    private ArrayList<User> users;

    // Constructor to initialize the users list with the default user
    public AuthenticationService() {
        users = new ArrayList<>();
        // Adding a default user for demonstration purposes
        users.add(new User("defaultUser", "defaultPassword"));
    }

    @Override
    public User signUp(String username, String password) {
        // Check if the username is already taken
        for (User user : users) {
            if (user.getUsername().equals(username)) {
                return null; // Username is taken, return null
            }
        }

        // Username is not taken, add a new user to the list and return the user
        User newUser = new User(username, password);
        users.add(newUser);
        return newUser;
    }

    @Override
    public User logIn(String username, String password) {
        // Check if the username and password match for any user
        for (User user : users) {
            if (user.getUsername().equals(username) && user.getPassword().equals(password)) {
                return user; // Username and password match, return the user
            }
        }

        return null; // Username or password is incorrect, return null
    }
}