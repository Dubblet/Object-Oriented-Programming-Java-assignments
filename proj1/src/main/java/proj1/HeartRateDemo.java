package proj1;

import java.util.ArrayList;
import java.util.Scanner;

public class HeartRateDemo {
    public static void main(String[] args) {
            ArrayList<PersonHeartRate> heartRateList = new ArrayList<PersonHeartRate>();
            String continueInput;

            do {
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
                String[] birthDateArray = birthDateEntered.split("-");
                dateOfBirth.setMonth(Integer.parseInt(birthDateArray[0]));
                dateOfBirth.setDay(Integer.parseInt(birthDateArray[1]));
                dateOfBirth.setYear(Integer.parseInt(birthDateArray[2]));

                PersonHeartRate personHeartRate = new PersonHeartRate(firstNameEntered, lastNameEntered, dateOfBirth);
                heartRateList.add(personHeartRate);

                Scanner continuePrompt = new Scanner(System.in);
                System.out.println("Type \"q\" to quit, or press enter key to continue");
                continueInput = continuePrompt.nextLine();
            } while (!continueInput.equalsIgnoreCase("q"));
            for (PersonHeartRate pHR : heartRateList) {
                pHR.printData();
            }
    }
}
