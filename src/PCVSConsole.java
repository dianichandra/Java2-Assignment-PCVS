//java library
import java.util.*;

/**
 * PCVS Console class to run the main class
 *
 * @author Putu Mas Diani Chandra
 */
public class PCVSConsole {

    /**
     * The main class to run the program
     *
     * @param args template arguments
     */
    public static void main(String[] args) {
        //Declare the scanner to be able to receive input from user
        Scanner input = new Scanner(System.in);

        //Declare a PCVS object to be able to access the method in pcvs later
        PCVS pcvs1 = new PCVS();

        //Declare the variables needed in this console
        String inputUsername,passInput, emailInput, fullNameInput, randStaffID, randVacID, icPass, vacExp, requestedDate;
        int numOpt = 1, vacBatchNum, vacQtyAvail, vacQtyAdministered = 0,choices = 0, choices2 = 0, vacIDChoice = 0, vacChoice = 0, batchChoice = 0, healthcareChoice = 0;
        char signupOption, batchContinue = ' ';

        //a while loop to looping through the whole program
        while (numOpt != 0) {
            System.out.println("\n======= Private Covid-19 Vaccination Scheme System =======");
            System.out.println("\n1. Sign up");
            System.out.println("2. Log In As Administrator");
            System.out.println("3. Log In As Patient");
            System.out.println("4. Display All User");
            System.out.println("5. Exit");
            System.out.print("\nEnter the number you'd like to choose: ");
            choices = input.nextInt();

            switch (choices){
                case 1:
                    System.out.print("Sign up as Admin or Patient? (A/P): ");
                    signupOption = input.next().charAt(0);
                    input.nextLine();


                    //if else condition is the user input char A or P
                    if((signupOption == 'A' || signupOption == 'a') || (signupOption == 'P' || signupOption == 'p')){
                        System.out.print("Enter username: ");
                        inputUsername = input.nextLine();


                        //checking the username whether it's been taken already or not
                        if (pcvs1.checkUsername(inputUsername)){
                            System.out.println("Username is taken. Please create another one.");

                        }

                        //condition where the username is unique
                        else{
                            System.out.print("Enter password: ");
                            passInput = input.nextLine();

                            System.out.print("Enter email: ");
                            emailInput = input.nextLine();

                            System.out.print("Enter full name: ");
                            fullNameInput = input.nextLine();

                            //condition if the user sign up as an administrator
                            if(signupOption == 'A' || signupOption == 'a') {
                                //giving the admin the random staff ID
                                randStaffID = pcvs1.randomStaffID();
                                //a new administrator object created based on user input
                                Administrator newAdmin = new Administrator(inputUsername, passInput, emailInput, fullNameInput, randStaffID);

                                System.out.println("\nHere are the list of the available Healthcare Centres: ");
                                //display only the name of healthcare centres
                                System.out.println(pcvs1.displayCentreName());
                                System.out.println("Input number you want to select here: ");
                                int centreOpt = input.nextInt();

                                //condition where the user input number of healthcare between 1 to 3
                                if (centreOpt > 0 && centreOpt < 4){
                                    //set the admin object to the healthcare centre selected
                                    pcvs1.getListOfCentreIdx(centreOpt-1).setNewAdmin(newAdmin);
                                    System.out.println("Administrator account successfully created with staff ID: " + randStaffID +
                                            ". \nRegistered at " + pcvs1.getListOfCentreIdx(centreOpt-1));

                                }
                                //condition if the user input number of healthcare other than 1 - 3
                                else {
                                    System.out.println("Invalid input. Please input the right number");
                                }

                                //adding the admin object to the arraylist of administrator
                                pcvs1.setListOfAdministrator(newAdmin);
                            }

                            //condition if the user signed up as patient
                            else {

                                System.out.print("Enter IC or passport number: ");
                                //receive the ic / passport from user input
                                icPass = input.nextLine();

                                //creating new patient object based on user input
                                Patient newPatient = new Patient(inputUsername, passInput, emailInput, fullNameInput, icPass);
                                //adding the new patient object to the arraylist of patient in pcvs
                                pcvs1.setListOfPatient(newPatient);

                                System.out.println("\nPatient account succesfully created.");
                            }
                        }
                    }

                    //condition if user input character other than A and P
                    else {
                        System.out.println("Invalid input. Please enter a character between 'A' and 'P' only");
                    }

                    break;

                //Log in as Administrator
                case 2:
                    input.nextLine();
                    System.out.print("Enter username: ");
                    inputUsername = input.nextLine();

                    System.out.print("Enter password: ");
                    passInput = input.nextLine();

                    //checking if the username and password are the same as the one that's stored.
                    if(pcvs1.checkAdminLogin(inputUsername, passInput)) {

                        //object of healthcare centre created by calling the method getHcAdmin in pcvs
                        //to get the admin's registered healthcare
                        HealthcareCentre healthcare1 = pcvs1.getHcOfAdmin(inputUsername);

                        System.out.println("\nSuccessfully logged in as Admin " + inputUsername);
                        //displaying the centre name where the admin has registered
                        System.out.println("Registered at " + healthcare1.getCentreName());
                        System.out.println("\nMenu:");
                        System.out.println("1. Record New Vaccine Batch");
                        System.out.println("2. View Vaccine Batch Information");
                        System.out.println("3. Back");
                        System.out.print("Enter number you want to select: ");
                        choices2 = input.nextInt();
                        input.nextLine();

                        switch (choices2) {
                            //record new vaccine batch
                            case 1:
                                //calling displayVaccineID method from pcvs to display the vaccine ID 
                                // that can be selected
                                System.out.println(pcvs1.displayVaccineID());
                                System.out.print("Enter number you want to select: ");
                                vacIDChoice = input.nextInt();
                                input.nextLine();
                                
                                //condition where the user choose vaccine number 1 to 3
                                if(vacIDChoice >= 1 && vacIDChoice <= 3){
                                    //displaying vaccine name and its manufacturer that the user selected
                                    System.out.println(pcvs1.displayVaccineDetail(vacIDChoice-1));
                                    
                                    System.out.print("Enter batch number: ");
                                    vacBatchNum = input.nextInt();
                                    input.nextLine();
                                    
                                    System.out.print("Enter expiry date (dd/mm/yyyy): ");
                                    vacExp = input.nextLine();

                                    System.out.print("Enter quantity of doses available: ");
                                    vacQtyAvail = input.nextInt();
                                    input.nextLine();

                                    //new batch object created to store a new batch based on user input
                                    Batch batch1 = new Batch(vacBatchNum,vacExp, vacQtyAvail, vacQtyAdministered);

                                    //adding the new batch to the healthcare
                                    pcvs1.setBatchToHC(healthcare1,batch1);
                                    
                                    //adding the new batch to the vaccine 
                                    pcvs1.setBatchToVaccine(vacIDChoice-1,batch1);

                                    //adding the healthcare object to the list of healthcare with vaccine
                                    pcvs1.setListOfHcWithVaccine(healthcare1);
                                    
                                    //display the details of the vaccine and batch that has been selected
                                    System.out.println("\nVaccine " + pcvs1.getVaccineIdx(vacIDChoice-1) + " successfully registered within batch " + vacBatchNum + ", expiry date of " + vacExp + " and quanityty available of " + vacQtyAvail);

                                }
                                
                                //if the user input vaccine number other than 1 to 3
                                else {
                                    System.out.println("Invalid input. Please enter the right number.");
                                }

                                break;

                                
                            //view batch information
                            case 2:
                                break;
                            
                            //going back to home menu
                            case 3:
                                break;
                        }


                    }
                    
                    //condition if the username and password inputted do not match any admin object stored
                    else {
                        System.out.println("\nAccount not found! \nPlease enter the right username and password.");

                    }

                break;
                    
                //Log in as patient
                case 3:
                    input.nextLine();
                    System.out.print("Enter username: ");
                    inputUsername = input.nextLine();

                    System.out.print("Enter password: ");
                    passInput = input.nextLine();

                    //checking if the username and password are the same as the one that's stored
                    if (pcvs1.checkPatientLogin(inputUsername, passInput)) {
                        //displaying the patient's first name by calling displayPatientFName method in pcvs
                        System.out.println("Successfully logged in as Patient " + pcvs1.displayPatientFName(inputUsername));
                        System.out.println("\nMenu: ");
                        System.out.println("1. Request vaccination appointment");
                        System.out.println("2. View vaccination Appointment status");
                        System.out.println("3. Back");
                        System.out.print("Select number: ");
                        choices2 = input.nextInt();
                        input.nextLine();

                        switch(choices2) {
                            //request vaccine appointment
                            case 1:
                                //while loop to keep showing the vaccines until the user proceed the batch
                                while (batchContinue != 'Y' && batchContinue != 'y') {
                                    System.out.println("\nHere's list of available vaccines: ");
                                    //displaying all the vaccines name and its manufacturer
                                    //that can be selected by the user
                                    System.out.println(pcvs1.displayAllVaccines());

                                    System.out.print("Enter number vaccine you want to select: ");
                                    vacChoice = input.nextInt();
                                    input.nextLine();

                                    //condition if the user input number of vaccine greater than 3
                                    if (vacChoice > 3) {
                                        System.out.println("Invalid input. Please input the right number.");
                                    }
                                    
                                    //condition if the user input number of vaccine between 1 to 3
                                    else {
                                        //displaying the detail of the vaccine that the user selected
                                        System.out.println(pcvs1.displayVaccineDetail(vacChoice - 1));
                                        
                                        //check if the vaccine selected has been registered in any healthcare
                                        //if not, then:
                                        if (!pcvs1.checkHcWithVac(vacChoice - 1)) {
                                            System.out.println("\nSorry ! There's no administered healthcare for that vaccine.");
                                            System.out.println("\nPlease select another vaccine !");
                                        }
                                        //if the vaccine has been registered in any healthcare, then:
                                        else{
                                            //display list of healthcare that offers the selected vaccine
                                            System.out.println("\t" + pcvs1.displayHcWithVac(vacChoice - 1));
                                            System.out.print("\nEnter the number of healthcare you choose: ");
                                            healthcareChoice = input.nextInt();
                                            input.nextLine();
                                            
                                            //condition if there's available batch that's not expired
                                            //if(pcvs1.checkExpVaccine(healthcareChoice, vacChoice)){
                                            if (!pcvs1.displayBatchInHC(healthcareChoice - 1, vacChoice - 1).equals("")) {
                                                //checking if the username and password are the same as the one that's stored.
                                                System.out.println(pcvs1.displayBatchInHC(healthcareChoice - 1, vacChoice - 1));
                                                System.out.print("Enter the number you want to select: ");
                                                batchChoice = input.nextInt();
                                                input.nextLine();
                                                
                                                //display the detail of the selected batch vaccine
                                                System.out.println(pcvs1.displayDetailVacBatch(healthcareChoice - 1, batchChoice, vacChoice - 1));
                                                
                                                System.out.print("\nProceed to take the batch? (Y/N):  ");
                                                //receiving the char user input
                                                batchContinue = input.nextLine().charAt(0);
                                            }
                                            //condition if all the batches are expired
                                            else {
                                                System.out.println("\n\tSorry, all the batches from this healthcare center are expired.");
                                            }
                                        }
                                    }
                                }
                                
                                //continue here if the user entered "Y" to proceed the batch
                                System.out.print("\nEnter the date for your appointment (dd/mm/yyyy): ");
                                requestedDate = input.nextLine();

                                //looping if the date requested by the user is after the batch vaccine expired date
                                while(pcvs1.checkReqDateWithBatch(requestedDate, healthcareChoice-1, batchChoice)){
                                    System.out.println("\nThe date you requested is after the expired date of the vaccine.\nInput another date!");
                                    System.out.print("\nEnter the date for your appointment (dd/mm/yyyy): ");
                                    requestedDate = input.nextLine();
                                }
                                
                                //calling the randomVaccinationID method to generate a random number for the vaccination
                                randVacID = pcvs1.randomVaccinationID();
                                
                                //a new vaccination object created to store the object based on the user input
                                Vaccination vaccination1 = new Vaccination(randVacID,requestedDate,"Pending",null);

                                //a new batch object created to store the batch thas has been proceeded by the user before
                                Batch batchForTheVaccination = pcvs1.getBatchRecordedInHC(healthcareChoice-1,batchChoice);

                                //a new patient object created to store the patient that logged in just now
                                Patient patientAccount = pcvs1.getPatient(inputUsername,passInput);

                                //adding the vaccination to the arraylist in the patient and batch class
                                pcvs1.setVaccination(vaccination1,batchForTheVaccination,patientAccount);

                                System.out.println("\nRegistered on date: " + requestedDate +
                                        "\n\tWe will confirm it and message you soon !");

                                //assign the x character to the batchContinue variable
                                //to loop again
                                batchContinue = 'x';
                                break;

                            //view vaccination appointment status
                            case 2:
                                break;

                            //back to the home menu
                            case 3:
                                break;

                            default:
                                System.out.println("Invalid input. Please enter the right number.");
                        }


                    }
                    //condition where the inputted username and password doesn't match
                    //in any of the patient's account stored
                    else {
                        System.out.println("\nAccount not found! \nPlease enter the right username and password.");
                    }
                    break;

                //display all user
                case 4:
                    System.out.println("Here's list of the users: ");
                    System.out.println("\n Aministrator: ");
                    //calling method to print all the admin full name
                    System.out.println(pcvs1.displayAllAdmin());
                    System.out.println("\n Patient: ");
                    //calling method to print all the patient full name
                    System.out.println(pcvs1.displayAllPatient());
                    break;

                //Exit
                case 5:
                    System.out.println("\nThank you for using this program !");
                    numOpt = 0;
                    break;

                default:
                    System.out.println("Invalid input. Please enter the right number.");
            }

        }
    }
}
