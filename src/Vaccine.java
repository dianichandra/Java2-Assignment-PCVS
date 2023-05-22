import java.util.ArrayList;

/**
 * @author Putu Mas Diani Chandra
 */
public class Vaccine {
    private String vaccineID, manufacturer, vaccineName;

    //array list to sore the batch from aggregation
    private ArrayList<Batch> listBatch;

    /**
     * A constructor for the vaccine class
     *
     * @param vaccineID store input of the id of vaccines
     * @param manufacturer store input of the manufacturer of vaccines
     * @param vaccineName store input of the name of vaccines
     */
    public Vaccine(String vaccineID, String manufacturer, String vaccineName){
        this.vaccineID = vaccineID;
        this.manufacturer = manufacturer;
        this.vaccineName = vaccineName;
        this.listBatch = new ArrayList<>();
    }

    /**
     * A getter for getting the ID of the vaccine
     *
     * @return id of the vaccine
     */
    public String getVaccineID() {
        return vaccineID;
    }

    /**
     * A getter for getting the manufacturer of the vaccine
     *
     * @return manufacturer of the vaccine
     */
    public String getManufacturer() {
        return manufacturer;
    }

    /**
     * A getter for getting the name of the vaccine
     *
     * @return name of the vaccine
     */
    public String getVaccineName() {
        return vaccineName;
    }

    /**
     * A getter for getting the list of the batch aggregation
     *
     * @return list of the batch aggregation
     */
    public ArrayList<Batch> getListBatch() {
        return listBatch;
    }

    /**
     * A setter to set the id of the vaccine
     *
     * @param vaccineID store input of vaccine id
     */
    public void setVaccineID(String vaccineID) {
        this.vaccineID = vaccineID;
    }

    /**
     * A setter to set the manufacturer of the vaccine
     *
     * @param manufacturer store input of vaccine's manufacturer
     */
    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    /**
     * A setter to set the name of the vaccine
     *
     * @param vaccineName store input of vaccine's name
     */
    public void setVaccineName(String vaccineName) {
        this.vaccineName = vaccineName;
    }

    /**
     * A setter to add batch object to the batch list
     *
     * @param newBatch to store vaccination object
     */
    public void setNewBatch(Batch newBatch) {
        this.listBatch.add(newBatch);
    }

    /**
     * A toString method to display the details of the vaccines
     *
     * @return details of the patient
     */
    @Override
    public String toString() {
        return "with vaccineID = " + vaccineID  +
                ", manufacturer = " + manufacturer +
                ", and vaccineName = " + vaccineName;
    }
}
