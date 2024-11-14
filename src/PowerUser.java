class PowerUser extends User implements WriteAccess {
    public PowerUser(String userID, String username, String email, String password) {
        super(userID, username, email, password, "Power");
    }

    @Override
    public void addUser(String userDetails) {
        System.out.println("Adding user: " + userDetails);
    }
}
