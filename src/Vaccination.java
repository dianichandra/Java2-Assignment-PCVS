/**
 * @author Putu Mas Diani Chandra
 */
public class Vaccination {
    private String vaccinationID, appointmentDate, status, remarks;

    /**
     * A constructor for the vaccination class
     *
     * @param vaccinationID store input of the id of vaccinations
     * @param appointmentDate store input of the appointment date of vaccinations
     * @param status store input of the status of vaccinations
     * @param remarks store input of the remarks of vaccinations
     */
    public Vaccination(String vaccinationID, String appointmentDate, String status, String remarks){
        this.vaccinationID = vaccinationID;
        this.appointmentDate = appointmentDate;
        this.status = status;
        this.remarks = remarks;
    }

    /**
     * A getter for getting the ID of the vaccination
     *
     * @return id of the vaccination
     */
    public String getVaccinationID() {
        return vaccinationID;
    }

    /**
     * A getter for getting the appointment date of the vaccination
     *
     * @return appointment date of the vaccination
     */
    public String getAppointmentDate() {
        return appointmentDate;
    }

    /**
     * A getter for getting the status of the vaccination
     *
     * @return status of the vaccination
     */
    public String getStatus() {
        return status;
    }

    /**
     * A getter for getting the remarks of the vaccination
     *
     * @return remarks of the vaccination
     */
    public String getRemarks() {
        return remarks;
    }

    /**
     * A setter to set the ID of the vaccination
     *
     * @param vaccinationID store input of vaccination ID
     */
    public void setVaccinationID(String vaccinationID) {
        this.vaccinationID = vaccinationID;
    }

    /**
     * A setter to set the appointment date of the vaccination
     *
     * @param appointmentDate store input of appointment date of vaccination
     */
    public void setAppointmentDate(String appointmentDate) {
        this.appointmentDate = appointmentDate;
    }

    /**
     * A setter to set the status of the vaccination
     *
     * @param status store input of vaccination
     */
    public void setStatus(String status) {
        this.status = status;
    }

    /**
     * A setter to set the remarks of the vaccination
     *
     * @param remarks store input of the vaccination
     */
    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    /**
     * A toString method to display the details of the vaccination
     *
     * @return details of the vaccination
     */
    @Override
    public String toString() {
        return "Vaccination{" +
                "vaccinationID='" + vaccinationID + '\'' +
                ", appointmentDate='" + appointmentDate + '\'' +
                ", status='" + status + '\'' +
                ", remarks='" + remarks + '\'' +
                '}';
    }
}
