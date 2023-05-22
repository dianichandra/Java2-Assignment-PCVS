

import java.util.ArrayList;

/**
 * @author Putu Mas Diani Chandra
 */
public class Batch {
    private int batchNo, quantityAvailable, quantityAdministered;
    private String expiryDate;

    //array list to sore the vaccination from aggregation
    private ArrayList<Vaccination> listOfVaccinations;
    
    
    /**
     * A constructor for the batch class
     *
     * @param batchNo store input of the no of batch
     * @param expiryDate store input of the expiry date of batch
     * @param quantityAvailable store input of the quantity available of batch
     * @param quantityAdministered store input of the quantity administered of batch
     */
    public Batch(int batchNo, String expiryDate, int quantityAvailable, int quantityAdministered){
        this.batchNo = batchNo;
        this.expiryDate = expiryDate;
        this.quantityAvailable = quantityAvailable;
        this.quantityAdministered = quantityAdministered;
        this.listOfVaccinations = new ArrayList<>();
    }

    /**
     * A getter for getting the no of the batch
     *
     * @return no of batch
     */
    public int getBatchNo() {
        return batchNo;
    }

    /**
     * A getter for getting the expiry date of the batch
     *
     * @return expiry date of batch
     */
    public String getExpiryDate() {
        return expiryDate;
    }

    /**
     * A getter for getting the quantity available of the batch
     *
     * @return quantity available of batch
     */
    public int getQuantityAvailable() {
        return quantityAvailable;
    }

    /**
     * A getter for getting the quantity administered of the batch
     *
     * @return quantity administered of batch
     */
    public int getQuantityAdministered() {
        return quantityAdministered;
    }

    /**
     * A getter for getting the list of the vaccination aggregation
     *
     * @return list of the vaccination aggregation
     */
    public ArrayList<Vaccination> getNewVaccinations() {
        return listOfVaccinations;
    }
    

    /**
     * A setter to set the no of the batch
     *
     * @param batchNo store input of batch no
     */
    public void setBatchNo(int batchNo) {
        this.batchNo = batchNo;
    }

    /**
     * A setter to set the expiry date of the batch
     *
     * @param expiryDate store input of expiry date
     */
    public void setExpiryDate(String expiryDate) {
        this.expiryDate = expiryDate;
    }

    /**
     * A setter to set the available quantity of the batch
     *
     * @param quantityAvailable store input of available quantity
     */
    public void setQuantityAvailable(int quantityAvailable) {
        this.quantityAvailable = quantityAvailable;
    }

    /**
     * A setter to set the administered quantity of the batch
     *
     * @param quantityAdministered store input of administered quantity
     */
    public void setQuantityAdministered(int quantityAdministered) {
        this.quantityAdministered = quantityAdministered;
    }

    /**
     * A setter to add vaccination object to the vaccination list
     *
     * @param newVaccination to store vaccination object
     */
    public void setNewVaccination(Vaccination newVaccination){
        this.listOfVaccinations.add(newVaccination);
    }
    
    /**
     * A toString method to display the details of the batch
     *
     * @return details of the batch
     */
    @Override
    public String toString() {
        return "Batch {" +
                "batchNo =" + batchNo +
                ", expiryDate =" + expiryDate +
                ", quantityAvailable =" + quantityAvailable +
                ", quantityAdministered =" + quantityAdministered +
                '}';
    }
}
