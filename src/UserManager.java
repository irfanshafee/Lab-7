import java.util.HashMap;
import java.io.*;
import java.util.Map;

class UserManager {
    private static UserManager instance;
    private Map<String, User> users = new HashMap<>();
    private Map<String, AdminUser> admins = new HashMap<>();

    private UserManager() {
        loadUsers();
        loadAdmins();
    }

    public static UserManager getInstance() {
        if (instance == null) {
            instance = new UserManager();
        }
        return instance;
    }

    private void loadUsers() {
        // Load users from User.csv
        try (BufferedReader br = new BufferedReader(new FileReader("User.csv"))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] details = line.split(",");
                User user = new User(details[0], details[1], details[2], details[3], details[4]);
                users.put(details[1], user);
            }
        } catch (IOException e) {
            System.out.println("Error loading users: " + e.getMessage());
        }
    }

    private void loadAdmins() {
        // Load admins from Admin.csv
        try (BufferedReader br = new BufferedReader(new FileReader("Admin.csv"))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] details = line.split(",");
                AdminUser admin = new AdminUser(details[0], details[1], details[2], details[3]);
                admins.put(details[1], admin);
            }
        } catch (IOException e) {
            System.out.println("Error loading admins: " + e.getMessage());
        }
    }

    public User authenticate(String username, String password) {
        if (admins.containsKey(username) && admins.get(username).getPassword().equals(password)) {
            return admins.get(username);
        } else if (users.containsKey(username) && users.get(username).getPassword().equals(password)) {
            return users.get(username);
        }
        return null;
    }
}