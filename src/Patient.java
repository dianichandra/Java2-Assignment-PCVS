import java.util.ArrayList;

/**
 * Inheritance from the user class
 *
 * @author Putu Mas Diani Chandra
 */
public class Patient extends User{
    private String ICPassport;

    //array list to sore the vaccination from aggregation
    private ArrayList<Vaccination> listOfVaccinations;

    /**
     * A constructor for the patient class
     *
     * @param username store input of username
     * @param password store input of password
     * @param email store input of email
     * @param fullName store input of full name
     * @param ICPassport store input of IC or passport
     */
    public Patient(String username, String password, String email, String fullName, String ICPassport){
        //super from the parent class
        super(username, password, email, fullName);
        this.ICPassport = ICPassport;
        this.listOfVaccinations = new ArrayList<>();
    }

    /**
     * A getter for getting the IC or passport of the patient user
     *
     * @return the IC or passport of the patient user
     */
    public String getICPassport() {
        return ICPassport;
    }

    /**
     * A getter for getting the list of the vaccinations
     *
     * @return list of vaccinations
     */
    public ArrayList<Vaccination> getNewVaccinations() {
        return listOfVaccinations;
    }

    /**
     * A setter to set the ic / passport of the user patient
     *
     * @param ICPassport store input of IC or passport
     */
    public void setICPassport(String ICPassport) {
        this.ICPassport = ICPassport;
    }

    /**
     * A setter to add vaccination object to the vaccination list
     *
     * @param vaccinations to store vaccination object
     */
    public void setNewVaccinations(Vaccination vaccinations){
        this.listOfVaccinations.add(vaccinations);
    }

    /**
     * A toString method to return the attributes of the patient user
     *
     * @return details of the patient
     */
    @Override
    public String toString() {
        return "Patient{" +
                "ICPassport='" + ICPassport + '\'' +
                '}';
    }
}
