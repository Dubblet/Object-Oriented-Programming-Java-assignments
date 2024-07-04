package proj1;

import java.time.LocalDate;

public class PersonHeartRate {
    // Fields
    private String firstName;
    private String lastName;
    private DateOfBirth dateOfBirth;

    /**
     * Constructor for all 3 params.
     * @param firstName The person's first name.
     * @param lastName The person's last name.
     * @param dateOfBirth The person's date of birth.
     */
    public PersonHeartRate(String firstName, String lastName, DateOfBirth dateOfBirth) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.dateOfBirth = dateOfBirth;
    }

    // Getters and Setters for each field

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public DateOfBirth getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(DateOfBirth dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    /**
     * Method that calculates a person's age given their birthdate compared to the current date.
     * @param dateOfBirth The person's date of birth.
     * @return An int, of the person's age.
     */
    public int calculateAge(DateOfBirth dateOfBirth) {
        LocalDate currentDate = LocalDate.now();
        int age = currentDate.getYear() - dateOfBirth.getYear();
        if (currentDate.getMonthValue() < dateOfBirth.getMonth()) {
            age -= 1;
        } else if (currentDate.getMonthValue() == dateOfBirth.getMonth()) {
            if (currentDate.getDayOfMonth() < dateOfBirth.getDay()) {
                age -= 1;
            }
        }
        return age;
    }

    /**
     * Method that calculates the max heartrate for a given age.
     * @param age The person's age in years.
     * @return An int, the highest BPM safe for the given age.
     */
    public int maxBPM(int age) {
        return 220 - age;
    }

    /**
     * Method that calculates a safe range to target while exercising.
     * @param maxBPM The maximum heart rate at a given age a person should safely have.
     * @return A String, with the lower and upper range of heart rates to target.
     */
    public String bPMRange(int maxBPM) {
        int lowerRange = (int) (maxBPM * 0.5);
        int upperRange = (int) (maxBPM * 0.85);
        return lowerRange + " - " + upperRange;
    }

    /**
     * Method that prints out a saved name, maximum heart rate, and range of BPM to target while exercising.
     */
    public void printData() {
        int age = calculateAge(getDateOfBirth());
        int maxHeartRate = maxBPM(age);
        System.out.println(getLastName() + ", " + getFirstName());
        System.out.println("Max heart rate: " + maxHeartRate);
        System.out.println("Target heart rate: " + bPMRange(maxHeartRate));
    }
}
