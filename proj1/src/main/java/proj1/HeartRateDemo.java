package proj1;

import java.util.ArrayList;
import java.util.Scanner;

public class HeartRateDemo {
    public static void main(String[] args) {
        // Create an ArrayList of PersonHeartRate objects to store each saved person the user inputs and a string used to loop
        ArrayList<PersonHeartRate> heartRateList = new ArrayList<PersonHeartRate>();
        String continueInput;

        // A do - while loop, to allow continued inputs of names and birth dates until the user chooses to quit
        do {
            // Scanners to get inputs from the user and Strings to store the inputs as
            Scanner firstNameInput = new Scanner(System.in);
            System.out.println("Please enter your first name.");
            String firstNameEntered = firstNameInput.nextLine();

            Scanner lastNameInput = new Scanner(System.in);
            System.out.println("Please enter your last name.");
            String lastNameEntered = lastNameInput.nextLine();

            Scanner birthDateInput = new Scanner(System.in);
            System.out.println("Please enter your date of birth, as all numbers separated by dashes. ie) mm-dd-yyyy");
            String birthDateEntered = birthDateInput.nextLine();

            DateOfBirth dateOfBirth = new DateOfBirth();
            // Splits the user's input for their birthday on the dash - character
            String[] birthDateArray = birthDateEntered.split("-");
            // Then parses them into ints and sets the fields of dateOfBirth
            dateOfBirth.setMonth(Integer.parseInt(birthDateArray[0]));
            dateOfBirth.setDay(Integer.parseInt(birthDateArray[1]));
            dateOfBirth.setYear(Integer.parseInt(birthDateArray[2]));

            // Creates a new personHeartRate object, and assigns each field to the pieces entered by the user
            PersonHeartRate personHeartRate = new PersonHeartRate(firstNameEntered, lastNameEntered, dateOfBirth);
            heartRateList.add(personHeartRate);

            Scanner continuePrompt = new Scanner(System.in);
            System.out.println("Type \"q\" to quit, or press enter key to continue");
            continueInput = continuePrompt.nextLine();
        // if the user just presses enter or inputs anything other than q to quit, it will loop through again
        } while (!continueInput.equalsIgnoreCase("q"));

        // finally, once the loop is exited, loop through the ArrayList, calling printData method on each stored personHeartRate
        for (PersonHeartRate pHR : heartRateList) {
            pHR.printData();
        }
    }
}
