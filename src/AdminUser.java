class AdminUser extends User implements AdminPrivileges {
    public AdminUser(String userID, String username, String email, String password) {
        super(userID, username, email, password, "Admin");
    }

    @Override
    public void addUser(String userDetails) {
        System.out.println("Admin adding user: " + userDetails);
    }

    @Override
    public void modifySettings() {
        System.out.println("Modifying system settings...");
    }
}
