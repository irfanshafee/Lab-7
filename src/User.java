public class User implements ReadAccess{


    private String userID;
    private String username;
    private String email;
    private String password;
    private String userType;

    public User(String userID, String username, String email, String password, String userType) {
        this.userID = userID;
        this.username = username;
        this.email = email;
        this.password = password;
        this.userType = userType;
    }

    public String getPassword() {
        return password;
    }

    @Override
    public void viewContent() {
        System.out.println("Reading contents from User.csv...");
    }
}
