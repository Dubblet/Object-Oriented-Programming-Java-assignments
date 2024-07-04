package proj1;

import java.time.LocalDate;

public class PersonHeartRate {
    private String firstName;
    private String lastName;
    private DateOfBirth dateOfBirth;

    public PersonHeartRate(String firstName, String lastName, DateOfBirth dateOfBirth) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.dateOfBirth = dateOfBirth;
    }

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

    public int maxBPM(int age) {
        return 220 - age;
    }

    public String bPMRange(int maxBPM) {
        int lowerRange = (int) (maxBPM * 0.5);
        int upperRange = (int) (maxBPM * 0.85);
        return lowerRange + " - " + upperRange;
    }

    public void printData() {
        int age = calculateAge(getDateOfBirth());
        int maxHeartRate = maxBPM(age);
        System.out.println(getLastName() + ", " + getFirstName());
        System.out.println("Max heart rate: " + maxHeartRate);
        System.out.println("Target heart rate: " + bPMRange(maxHeartRate));
    }
}
