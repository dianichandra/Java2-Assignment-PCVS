//java library
import java.util.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 * PCVS class to store all method needed in the pcvs console class
 *
 * @author Putu Mas Diani Chandra
 */
public class PCVS {
    
    //declaring the arraylist of the classed that will be used later
    private ArrayList<HealthcareCentre> listOfHcWithVaccine = new ArrayList<>();
    private ArrayList<HealthcareCentre> listOfCentre = new ArrayList<>();
    private ArrayList<Vaccine> listOfVaccine = new ArrayList<>();
    private ArrayList<Patient> listOfPatient = new ArrayList<>();
    private ArrayList<Administrator> listOfAdministrator = new ArrayList<>();
    
    //creating the object for patient and administrator to access some methods in that class
    private Patient patient1 = new Patient("-","-","-","-","-");
    private Administrator administrator1 = new Administrator("-","-","-","-","-");
    
    public PCVS(){
        
        //hardcode of the healthcare registered
        listOfCentre.add(new HealthcareCentre("Udayana University Hospital", "Jl. Rumah Sakit Unud, Jimbaran, Kuta Selatan"));
        listOfCentre.add(new HealthcareCentre("Bali Royal Hospital", "Jl. Tantular No. 6, Renon, Denpasar"));
        listOfCentre.add(new HealthcareCentre("Surya Husada Hospital", "Jl. Pulau Serangan No. 7, Dauh Puri Kelod, Denpasar"));
        
        //hardcode of the vaccine registered
        listOfVaccine.add(new Vaccine("V001", "ModernaTX,Inc.", "Moderna(mRNA-1273)"));
        listOfVaccine.add(new Vaccine("V002", "Pfizer,Inc. and BioNTech", "Pfizer(BNT162B2)"));
        listOfVaccine.add(new Vaccine("V003", "University of Oxford", "AstraZeneca(AZD1222)"));
    }

    /**
     * Adding an object of patient to the patient list
     * 
     * @param patient receive patient object
     */
    public void setListOfPatient(Patient patient) {
        this.listOfPatient.add(patient);
    }

    /**
     * Adding an object of administrator to the administrator list
     * 
     * @param admin receive administrator object
     */
    public void setListOfAdministrator(Administrator admin) {
        this.listOfAdministrator.add(admin);
    }

    /**
     * Adding the batch object to the batch list in healthcare class
     * 
     * @param healthcare receive healthcare object
     * @param batch receive batch object
     */
    public void setBatchToHC(HealthcareCentre healthcare, Batch batch){
        healthcare.setNewBatch(batch);
    }


    /**
     * Adding the batch object to the batch list in healthcare class
     * 
     * @param vacID receive input of vaccine index / number choosen by the user
     * @param batch receive batch object
     */
    public void setBatchToVaccine(int vacID, Batch batch){
        getVaccineIdx(vacID).setNewBatch(batch);
    }

    /**
     * Adding the vaccination object in the patient and batch class
     * Also decrease the quantity of the vaccine
     * 
     * @param vaccination receive vaccination object
     * @param batch receive batch object
     * @param patient receive patient object
     */
    public void setVaccination(Vaccination vaccination, Batch batch, Patient patient){
        patient.getNewVaccinations().add(vaccination);
        batch.getNewVaccinations().add(vaccination);
        batch.setQuantityAvailable(batch.getQuantityAvailable()-1);
    }

    /**
     * Adding the healthcare that register a vaccine to the healthcare with vaccine list
     *
     * @param healthcare receive healthcare centre object
     */
    public void setListOfHcWithVaccine(HealthcareCentre healthcare) {
        this.listOfHcWithVaccine.add(healthcare);
    }

    /**
     * Getting the arraylist of the administrator
     *
     * @return arraylist of the administrator
     */
    public ArrayList<Administrator> getListOfAdministrator() {
        return listOfAdministrator;
    }

    /**
     * Getting the arraylist of the administrator
     *
     * @return arraylist of the patient
     */
    public ArrayList<Patient> getListOfPatient() {
        return listOfPatient;
    }

    /**
     * Getting the arraylist of the healthcare centre
     *
     * @return arraylist of healthcare centre
     */
    public ArrayList<HealthcareCentre> getListOfCentre() {
        return listOfCentre;
    }

    /**
     * Getting the arraylist of the healthcare centre that has vaccine registered based on the index
     *
     * @param centreIndex receive input of number of centre chosen that will be used as the index
     * @return the object in the arraylist of the healthcare centre that has vaccine indicated by the index
     */
    public HealthcareCentre getListOfHCIdx(int centreIndex) {
        return listOfHcWithVaccine.get(centreIndex);
    }

    public ArrayList<HealthcareCentre> getListOfHcWithVaccine() {
        return listOfHcWithVaccine;
    }
    
    public ArrayList<String> getListHcWithVacIdx(int vacChoice){
    	ArrayList<String> hcNameList = new ArrayList<>();
	    	checkHcWithVac(vacChoice);
	    	for(int i = 0; i < listOfHcWithVaccine.size(); i ++) {
	    		hcNameList.add(String.valueOf(listOfHcWithVaccine.get(i).getCentreName()));
	    	}
    	return hcNameList;
    }
    
    
    
    
    public ArrayList<String> getHcNew(int vacIndex){
    	ArrayList<String> hcNameList = new ArrayList<>();
        //calling the function to check if there are any vaccine batches registered
        checkHcWithVac(vacIndex);

        //if there are any vaccine batches registered, display the healthcare that offer the batch
        for (int i = 0; i < listOfHcWithVaccine.size(); i++){
        	hcNameList.add(String.valueOf(listOfHcWithVaccine.get(i).getCentreName()));
        }

        return hcNameList;

    }

    public ArrayList<Vaccine> getListVaccine(){
    	return listOfVaccine;
    }
    
    public ArrayList<String> getVaccineID() {
    	ArrayList<String> vacIdList = new ArrayList<>();
    	for(int i = 0; i < listOfVaccine.size(); i++) {
    		vacIdList.add(listOfVaccine.get(i).getVaccineID());
    	}
    	return vacIdList;
    }
    
    public ArrayList<String> getHcWithVacName() {
    	ArrayList<String> hcNameList = new ArrayList<>();
    	for(int i = 0; i < listOfHcWithVaccine.size(); i++) {
    		hcNameList.add(listOfVaccine.get(i).getVaccineID());
    	}
    	return hcNameList;
    }
    
    public boolean checkBatch(int hccChoice, int vacChoice){
        //looping through the batch in selected healthcare
        for (int i = 0; i < getListOfHCIdx(hccChoice).getNewBatch().size(); i++) {
            //a batch object created to access some method in batch class
            //also getting the batch in the selected healthcare and store it in batch object
            Batch batch1 = getListOfHCIdx(hccChoice).getNewBatch().get(i);

            //check if there's any batch in the selected healthcare and the batch is not expired
            if (getVaccineIdx(vacChoice).getListBatch().contains(batch1) && getExpBasedByBatch(batch1).isAfter(LocalDate.now())) {
                //condition to get only the batch that has not expired
                if (checkExpVaccine(hccChoice, vacChoice)) {
                    return true;
                }
            }
        }
        return false;
    }
    
    public ArrayList<String> getListBatchNo(int hccChoice, int vacChoice){
    	ArrayList<String> batchList = new ArrayList<>();
    	for (int i = 0; i < getListOfHCIdx(hccChoice).getNewBatch().size(); i++) {
            //a batch object created to access some method in batch class
            //also getting the batch in the selected healthcare and store it in batch object
            Batch batch1 = getListOfHCIdx(hccChoice).getNewBatch().get(i);
	    	//checkBatch(hccChoice,vacChoice);
	    	//for(int i = 0; i < listOfHcWithVaccine.size(); i ++) {
	    	//if(checkExpVaccine(hccChoice, vacChoice)) {
            if(getExpBasedByBatch(batch1).isAfter(LocalDate.now())) {
	    		batchList.add(String.valueOf(batch1.getBatchNo()));
	    	}
	    }
    	return batchList;
    }
    
    
    public int getQuantity(int hccChoice, int batchChoice) {
    	for (int i = 0; i < getListOfHCIdx(hccChoice).getNewBatch().size(); i++) {
            Batch batch1 = getListOfHCIdx(hccChoice).getNewBatch().get(batchChoice);
	    	
            return batch1.getQuantityAvailable();
	    }
    	return 0;
    }
    
    public String getDate(int hccChoice, int batchChoice) {
    	for (int i = 0; i < getListOfHCIdx(hccChoice).getNewBatch().size(); i++) {
            Batch batch1 = getListOfHCIdx(hccChoice).getNewBatch().get(batchChoice);
	    	
            return batch1.getExpiryDate();
	    }
    	return null;
    }
    
    /**
     * Getting the arraylist of the administrator by index
     *
     * @param centreIndex receive input of number of centre chosen that will be used as the index
     * @return the object in the arraylist of the healthcare centre indicated by the index
     */
    public HealthcareCentre getListOfCentreIdx(int centreIndex) {
        return listOfCentre.get(centreIndex);
    }

    /**
     * Getting the arraylist of the vaccine by index
     *
     * @param vacIndex receive input of number of vaccine chosen that will be used as the index
     * @return the object in the arraylist of the vaccine indicated by the index
     */
    public Vaccine getVaccineIdx(int vacIndex){
        return listOfVaccine.get(vacIndex);
    }

    /**
     * Displaying centre name of the list of healthcare centres
     *
     * @return a string that contains the healthcare centre name
     */
    public String displayCentreName(){
        String nameDisplay = "";
        for(int i = 0; i < listOfCentre.size(); i++){
            nameDisplay = nameDisplay + (i+1) + ". " + listOfCentre.get(i).getCentreName() + "\n";
        }
        return nameDisplay;
    }

    /**
     * Generating random number for administrator's staff ID
     *
     * @return staff ID
     */
    public static String randomStaffID() {
        //declare minimum and maximum number
        //to determine the scope random number of the staffID
        int min = 100;
        int max = 200;

        //using math.floor to generate a random number
        //between the minimum and maximum number decided
        int staffID = (int) Math.floor(Math.random()*(max-min+1)+min);
        return "ADM" + staffID;

    }

    /**
     * Displaying the list of vaccine names and its manufacturers
     *
     * @return a string that contains the vaccine names and manufacturers
     */
    public String displayAllVaccines(){
        String vaccineDisplay = "";
        for(int i = 0; i < listOfVaccine.size(); i++){
            vaccineDisplay = vaccineDisplay + (i+1) + ". " + listOfVaccine.get(i).getVaccineName() + " by " + listOfVaccine.get(i).getManufacturer() + "\n";
        }
        return vaccineDisplay;
    }

    /**
     *  Displaying the list of the vaccine's id number
     *
     * @return a string that contains the list of vaccine IDs
     */
    public String displayVaccineID(){
        String vaccineDisplay = "";
        for(int i = 0; i < listOfVaccine.size(); i++){
            vaccineDisplay = vaccineDisplay + (i+1) + ". " + listOfVaccine.get(i).getVaccineID() + "\n";
        }
        return vaccineDisplay;
    }

    /**
     * Display the vaccine detail based on the index of the vaccine list
     *
     * @param index receive index number
     * @return a string that contain one of the vaccine name and manufacturer in the vaccine list based on the index
     */
    public String displayVaccineDetail(int index){
        return  "\nVaccine with name of " + listOfVaccine.get(index).getVaccineName() + " by " + listOfVaccine.get(index).getManufacturer() + " selected.";
    }

    // this method will validate an available username.
    // so, the username will be unique for each admin and patient.

    /**
     * Checking if the username inputted is unique or has been used
     *
     * @param username receive username input from the user
     * @return boolean of true if the username inputted has been used
     */
    public boolean checkUsername(String username){
        //looping the patient list
        for (int i = 0; i < getListOfPatient().size(); i++){
            //get the patient in patient list one by one
            patient1 = getListOfPatient().get(i);
        }
        //looping the administrator list
        for (int j = 0; j < getListOfAdministrator().size(); j++){
            //get the administrator in administrator list one by one
            administrator1 = getListOfAdministrator().get(j);
        }
        // return the value of boolean true
        return (username.equals(administrator1.getUsername())) || (username.equals(patient1.getUsername()));
    }

    /**
     * Checking the login process of the admin whether it matches with admin objects stored in the admin list
     *
     * @param username receive username input from the user
     * @param password receive password input from the user
     *
     * @return boolean true if it matches with any admin object in the list, boolean false if it's not
     */
    public boolean checkAdminLogin(String username, String password){
        for (int i = 0; i < getListOfCentre().size(); i++){
            for (int j = 0; j < getListOfCentreIdx(i).getNewAdmin().size(); j++){
                //compare the username and password with username and password in the object in the list
                if((Objects.equals(getListOfCentreIdx(i).getNewAdmin().get(j).getUsername(), username)) && Objects.equals(getListOfCentreIdx(i).getNewAdmin().get(j).getPassword(), password)){
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * Checking the login process of the patient whether it matches with patient objects stored in the patient list
     *
     * @param username receive username input from the user
     * @param password receive password input from the user
     * @return boolean true if it matches with any admin object in the list, boolean false if it's not
     */
    public boolean checkPatientLogin(String username, String password){
        for (int i = 0; i < getListOfPatient().size(); i++){
            //compare the username and password with username and password in the object in the list
            if(Objects.equals(getListOfPatient().get(i).getUsername(), username) && Objects.equals(getListOfPatient().get(i).getPassword(), password)){
                return true;
            }
        }
        return false;
    }

    /**
     *  Getting the healthcare of the admin by username
     *
     * @param username receive username input from the user
     * @return the healthcare where the admin registered
     */
    public HealthcareCentre getHcOfAdmin(String username){
        //looping through the list of healthcare centre
        for (int i = 0; i < getListOfCentre().size(); i++){
            //looping through the admin object that registered in the healthcare centre
            for (int j = 0; j < getListOfCentreIdx(i).getNewAdmin().size(); j++){
                //check if the username inputted is equal to the admin object stored
                if (getListOfCentreIdx(i).getNewAdmin().get(j).getUsername().equals(username)){
                    return getListOfCentreIdx(i);
                }
            }
        }
        return null;
    }

    /**
     * Displaying the first name of the patient based on the username input
     *
     * @param username receive username input from the user
     * @return first name of patient
     */
    public String displayPatientFName(String username){
        String fNameOfPatient = "";
        //looping through the list of patient
        for (int i = 0; i < getListOfPatient().size(); i++){
            //check if the username inputted is the same as in the patient list
            if(Objects.equals(getListOfPatient().get(i).getUsername(), username)){
                //getting the full name of the patient
                fNameOfPatient = getListOfPatient().get(i).getFullName();
            }
        }
        return fNameOfPatient;
    }

    /**
     *  Displaying a list of healthcare that has vaccine registered to it
     *
     * @param vacIndex receive index of vaccine
     * @return a string that contains a list of healthcare that offer the vaccine
     */
    public String displayHcWithVac(int vacIndex){
        String displayHc = "";
        //calling the function to check if there are any vaccine batches registered
        checkHcWithVac(vacIndex);

        //if there are any vaccine batches registered, display the healthcare that offer the batch
        for (int i = 0; i < listOfHcWithVaccine.size(); i++){
                displayHc = displayHc + "\nHere's list of Healthcare that offer that vaccine: \n(" + (i + 1) + "). " + listOfHcWithVaccine.get(i);
        }

        return displayHc;

    }

    /**
     * Checking the healthcare whether it has vaccine batch registered or not
     *
     * @param vacIndex receive index of vaccine
     * @return boolean true if there's any batch registered, boolean false if not
     */
    public boolean checkHcWithVac(int vacIndex){
        for (int i = 0; i < getVaccineIdx(vacIndex).getListBatch().size(); i++){
            for (int k = 0; k < getListOfCentre().size(); k++){
                Batch batch1 = getVaccineIdx(vacIndex).getListBatch().get(i);
                HealthcareCentre healthcare1 = getListOfCentre().get(k);

                if ((healthcare1.getNewBatch().contains(batch1)) && (!listOfHcWithVaccine.contains(healthcare1)))
                    listOfHcWithVaccine.add(healthcare1);
                    return true;
            }
        }
        return false;
    }

    /**
     * Getting the expired date of the vaccine batch selected
     *
     * @param vacIdx receive index of vaccine
     * @return formatted expired date of the batch
     */
    public LocalDate getBatchExpiredDate(int vacIdx){
        for (int i = 0; i < getVaccineIdx(vacIdx).getListBatch().size(); i++) {
            Batch batch1 = getVaccineIdx(vacIdx).getListBatch().get(i);

            //a formatter to change the inputted date from string into local date
            DateTimeFormatter formatDate = DateTimeFormatter.ofPattern("d/M/yyyy");
            return LocalDate.parse( batch1.getExpiryDate(), formatDate);
        }
        return null;
    }

    /**
     * Checking the expired date of the vaccine batch
     *
     * @param hccChoice receive index of healthcare by the user
     * @param vacChoice receive index of vaccine by the user
     * @return boolean status of whether the batch expired date has passed today's date
     */
    public boolean checkExpVaccine(int hccChoice, int vacChoice){
        boolean vacStatus = false;
        LocalDate dateNow = LocalDate.now();

        for (int i = 0; i < getListOfCentre().size(); i++) {
            // looping through the list of batch in the selected healthcare
            for (int j = 0; j < getListOfHCIdx(hccChoice).getNewBatch().size(); j++){
                //condition if the batch's expired date is after today's date
                if (getBatchExpiredDate(vacChoice).isAfter(dateNow)){
                    vacStatus = true;
                }
            }
        }
        return vacStatus;
    }

    /**
     * Getting the vaccine batch's expired date based on the batch
     *
     * @param batch receive batch object
     * @return formatted expired date of the batch
     */
    public LocalDate getExpBasedByBatch(Batch batch){
        DateTimeFormatter formatDate = DateTimeFormatter.ofPattern("d/M/yyyy");
        return LocalDate.parse(batch.getExpiryDate(), formatDate);
    }

    /**
     * Getting and displaying a list of batch that's available in the selected healthcare
     *
     * @param hccChoice receive index of centre by the user
     * @param vacChoice receive index of vaccine by the user
     * @return a string contains a list of available batch in selected healthcare
     */
    public String displayBatchInHC(int hccChoice, int vacChoice){
        String listBatchInHC = "";
        //looping through the batch in selected healthcare
        for (int i = 0; i < getListOfHCIdx(hccChoice).getNewBatch().size(); i++) {
            //a batch object created to access some method in batch class
            //also getting the batch in the selected healthcare and store it in batch object
            Batch batch1 = getListOfHCIdx(hccChoice).getNewBatch().get(i);

            //check if there's any batch in the selected healthcare and the batch is not expired
            if (getVaccineIdx(vacChoice).getListBatch().contains(batch1) && getExpBasedByBatch(batch1).isAfter(LocalDate.now())) {
                //condition to get only the batch that has not expired
                if (checkExpVaccine(hccChoice, vacChoice)) {
                    listBatchInHC = listBatchInHC + "\n(" + batch1.getBatchNo() + "). " + batch1;
                }
            }
        }
        return listBatchInHC;
    }

    /**
     * Displaying the full detail of the selected vaccine batch
     *
     * @param hcIndex receive index of centre by the user
     * @param batchChoice receive index of batch by the user
     * @param vaccIndex receive index of vaccine by the user
     * @return a string contains the batch details
     */
    public String displayDetailVacBatch(int hcIndex, int batchChoice, int vaccIndex) {
        String displayDetail = "", getExp;
        int getQAdministered, getBatch;

        //getting the list of healthcare that have vaccine by index and store it in a healthcare object
        HealthcareCentre healthcare1 = getListOfHCIdx(hcIndex);

        //looping through the batches
        for (int j = 0; j < healthcare1.getNewBatch().size(); j++) {
            //check if the batch number is the same as the selected batch
            if (Objects.equals(healthcare1.getNewBatch().get(j).getBatchNo(), batchChoice)) {
                //getting the batch number
                getBatch = healthcare1.getNewBatch().get(j).getBatchNo();
                //getting the batch's expired date
                getExp = healthcare1.getNewBatch().get(j).getExpiryDate();
                //getting quantity administered
                getQAdministered = healthcare1.getNewBatch().get(j).getQuantityAvailable();
                displayDetail = "Here's the detail: " + "\n \tVaccine name: " + getVaccineIdx(vaccIndex).getVaccineName() +"\n \tBatch: " + getBatch + "\n\tquantity available: " + getQAdministered +
                        "\n\tVaccine Expired Date: " + getExp;
            }
        }
        return displayDetail;
    }

    /**
     * Getting the batch that registered just now in the healthcare that has vaccine
     *
     * @param hcIndex receive index of centre
     * @param batchChoice receive index of batch
     * @return batch object that registered just now
     */
    public Batch getBatchRecordedInHC(int hcIndex, int batchChoice){
        ////getting the list of healthcare that have vaccine by index and store it in a healthcare object
        HealthcareCentre healthcare1 = getListOfHCIdx(hcIndex);
        //looping through the batch in selected healthcare
        for (int j = 0; j < healthcare1.getNewBatch().size(); j++){
            //check if the batch no is equals as the number chosen by user
            if (Objects.equals(healthcare1.getNewBatch().get(j).getBatchNo(), batchChoice)){
                return healthcare1.getNewBatch().get(j);
            }
        }
        return null;
    }

    /**
     * Checking the requested date for the vaccine batch appointment
     *
     * @param requestedDate receive requested date from the user
     * @param hcIndex receive index of healthcare
     * @param batchChoice receive index of batch
     * @return boolean true if the requested is after the batch's expired date
     */
    public boolean checkReqDateWithBatch(String requestedDate, int hcIndex,int batchChoice){
        LocalDate reqDateFormatted = LocalDate.parse(requestedDate, DateTimeFormatter.ofPattern("d/M/yyyy"));

        Batch batch1 = getBatchRecordedInHC(hcIndex,batchChoice);
        LocalDate batchExp = getExpBasedByBatch(batch1);

        return reqDateFormatted.isAfter(batchExp);
    }

    /**
     * Generating random number for vaccination's ID
     *
     * @return
     */
    public String randomVaccinationID() {
        //declare minimum and maximum number
        //to determine the scope random number of the vaccination ID
        int min = 1;
        int max = 100;

        //using math.floor to generate a random number
        //between the minimum and maximum number decided
        int vaccinationID = (int) Math.floor(Math.random()*(max-min+1)+min);
        return "VCN" + vaccinationID;
    }

    /**
     * Getting the patient object based on username and password from the patient list
     *
     * @param username receive input username from user
     * @param password receive input password from user
     * @return patient object in list of the patient
     */
    public Patient getPatient(String username, String password){
        for (int i = 0; i < getListOfPatient().size(); i++){
            //Patient patient1 = getListOfPatient().get(i);
            // validates login by comparing the username and password inputted
            // with patient's username and password
            if(Objects.equals(getListOfPatient().get(i).getUsername(), username) && Objects.equals(getListOfPatient().get(i).getPassword(), password)){
                return getListOfPatient().get(i);
            }
        }
        return null;
    }

    /**
     * Displaying the list of registered administrator user
     *
     * @return a string of the registered admin list
     */
    public String displayAllAdmin(){
        String userDisplay = "";
        for(int i=0; i < getListOfAdministrator().size(); i++){
            userDisplay = userDisplay + (i+1) +". " + getListOfAdministrator().get(i).getFullName();
        }
        return userDisplay;
    }

    /**
     * Displaying the list of registered patient user
     *
     * @return a string of the registered patient list
     */
    public String displayAllPatient(){
        String userDisplay = "";
        for (int i = 0; i< getListOfPatient().size(); i++){
            userDisplay = userDisplay + (i+1) + ". " + getListOfPatient().get(i).getFullName();
        }
        return userDisplay;
    }
}


