/**
 * Inheritance from the user class
 *
 * @author Putu Mas Diani Chandra
 */
public class Administrator extends User{
    private String staffID;

    /**
     * A constructor for the administrator class
     *
     * @param username store input of username
     * @param password store input of password
     * @param email store input of email
     * @param fullName store input of full name
     * @param staffID store input of staff ID
     */
    public Administrator(String username, String password, String email, String fullName, String staffID){
        //super from the parent class
        super(username, password, email, fullName);
        this.staffID = staffID;
    }

    /**
     * A getter for getting the ID of the staff administrator
     *
     * @return the staff ID of administrator
     */
    public String getStaffID() {
        return staffID;
    }

    /**
     * A setter to set the staffID of the administrator user
     *
     * @param staffID
     */
    public void setStaffID(String staffID) {
        this.staffID = staffID;
    }

    /**
     * A toString method to return the attributes of the administrator user
     *
     * @return details of the administrator
     */
    @Override
    public String toString() {
        return "Administrator with " +
                "staffID of " + staffID;
    }
}
