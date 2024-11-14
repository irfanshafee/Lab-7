public class Main {
    public static void main(String[] args) {
        UserManager userManager = UserManager.getInstance();

        // Test Regular User
        User regularUser = userManager.authenticate("regularUsername", "password");
        if (regularUser != null) {
            ((ReadAccess) regularUser).viewContent();
        }

        // Test Power User
        PowerUser powerUser = (PowerUser) userManager.authenticate("powerUsername", "password");
        if (powerUser != null) {
            powerUser.viewContent();
            powerUser.addUser("newUserDetails");
        }

        // Test Admin User
        AdminUser adminUser = (AdminUser) userManager.authenticate("adminUsername", "password");
        if (adminUser != null) {
            adminUser.viewContent();
            adminUser.addUser("newAdminUserDetails");
            adminUser.modifySettings();
        }
    }
}
