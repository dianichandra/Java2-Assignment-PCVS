/**
 * @author Putu Mas Diani Chandra
 */
public abstract class User {
    private String username, password, email, fullName;

    /**
     * A constructor for the user class
     *
     * @param username store input of username
     * @param password store input of password
     * @param email store input of email
     * @param fullName store input of full name
     */
    public User(String username, String password, String email, String fullName){
        this.username = username;
        this.password = password;
        this.email = email;
        this.fullName = fullName;
    }

    /**
     * A getter for getting the username of the user
     *
     * @return username of the user
     */
    public String getUsername() {
        return username;
    }

    /**
     * A getter for getting the password of the user
     *
     * @return password of the user
     */
    public String getPassword() {
        return password;
    }

    /**
     * A getter for getting the email of the user
     *
     * @return email of the user
     */
    public String getEmail() {
        return email;
    }

    /**
     * A getter for getting the full name of the user
     *
     * @return full name of the user
     */
    public String getFullName() {
        return fullName;
    }

    /**
     * A setter to set the username of the user
     *
     * @param username store input of username
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * A setter to set the password of the user
     *
     * @param password store input of password
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * A setter to set the email of the user
     *
     * @param email store input of email
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * A setter to set the full name of the user
     *
     * @param fullName store input of full name
     */
    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    /**
     * A toString method to return the attributes of the user
     *
     * @return details of user
     */
    @Override
    public String toString() {
        return "User{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                ", fullName='" + fullName + '\'' +
                '}';
    }
}
