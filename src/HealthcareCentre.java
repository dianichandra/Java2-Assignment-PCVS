import java.util.ArrayList;

/**
 * @author Putu Mas Diani Chandra
 */
public class HealthcareCentre {
    private String centreName, address;

    //array list to sore the administrators from aggregation
    private ArrayList<Administrator> listAdmin;

    //array list to sore the batch from aggregation
    private ArrayList<Batch> listBatch;

    /**
     * A constructor for the healthcare centre class
     *
     * @param centreName store input of the name of healthcare centre
     * @param address store input of the address of healthcare centre
     */
    public HealthcareCentre(String centreName, String address){
        this.centreName = centreName;
        this.address = address;
        this.listAdmin = new ArrayList<>();
        this.listBatch = new ArrayList<>();
    }

    /**
     * A getter for getting the address of the healthcare centre
     *
     * @return address of the healthcare centre
     */
    public String getAddress() {
        return address;
    }

    /**
     * A getter for getting the name of the healthcare centre
     *
     * @return name of the healthcare centre
     */
    public String getCentreName() {
        return centreName;
    }

    /**
     * A setter to set the address of the healthcare centre
     *
     * @param address store input of address of healthcare centre
     */
    public void setAddress(String address) {
        this.address = address;
    }

    /**
     *  A setter to set the name of the healthcare centre
     *
     * @param centreName store input of name of the healthcare centre
     */
    public void setCentreName(String centreName) {
        this.centreName = centreName;
    }

    /**
     * A setter to add administrator object to the admin list of aggregation
     *
     * @param newAdmin to store admin object
     */
    public void setNewAdmin(Administrator newAdmin){
        this.listAdmin.add(newAdmin);
    }

    /**
     * A setter to add batch object to the batch list of aggregation
     *
     * @param batch to store batch object
     */
    public void setNewBatch(Batch batch) {
        this.listBatch.add(batch);
    }

    /**
     * A getter for getting the list of the administrator aggregation
     *
     * @return list of administrator aggregation
     */
    public ArrayList<Administrator> getNewAdmin(){
        return listAdmin;
    }

    /**
     * A getter for getting the list of the batch aggregation
     *
     * @return list of batch aggregation
     */
    public ArrayList<Batch> getNewBatch() {
        return listBatch;
    }

    /**
     * A toString method to display the details of the healthcare centre
     *
     * @return details of the healthcare centre
     */
    @Override
    public String toString() {
        return centreName + " with address on " + address;
    }
}
