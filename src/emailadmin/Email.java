package emailadmin;

import java.util.Scanner;

public class Email {
    private final String firstName;
    private final String lastName;
    private String password;
    private final String email;
    private int mailCapacity = 500;
    private String altEmail = "";

    // Constructor to receive name;
    public Email(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
        System.out.println("\nNew Employee Added: " + firstName + " " + lastName);

        // Call method to ask for deparment
        String department = setDepartment();

        // Call method to ask for capacity
        int mailCapacity = setMailCapacity();

        // Call method to set password
        int defaultPasswordLength = 8;
        this.password = setPassword(defaultPasswordLength);

        // Combine first and last name to create email address
        String companyName = "KodeSourc";
        email = firstName.toLowerCase() + "." + lastName.toLowerCase() + "@" + department + "." + companyName.toLowerCase() + ".com";
    }

    // Ask user for department
    private String setDepartment() {
        System.out.print("\nDEPARTMENT CODES:\n1 for Sales\n2 for Development\n3 for Accounting\n0 for None\nEnter department code: ");
        Scanner userInput = new Scanner(System.in);
        int departmentOption = userInput.nextInt();
        if (departmentOption == 1) {
            return "sales";
        } else if (departmentOption == 2) {
            return "dev";
        } else if (departmentOption == 3) {
            return "accounting";
        } else {
            System.out.println("Invalid department, please try again");
            return setDepartment();
        }
    }

    // Generate random password
    private String setPassword(int length) {
        String charSet = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890!@#$%^&*()";
        char[] password = new char[length];
        for (int i = 0; i < length; i++) {
            int random = (int) (Math.random() * charSet.length());
            password[i] = charSet.charAt(random);
        }
        return new String(password);
    }

    // Set mailbox capacity
    public int setMailCapacity() {
        Scanner userInput = new Scanner(System.in);
        System.out.print("\nEnter mailbox capacity (mbs): ");
        int mailCapacity = userInput.nextInt();
        this.mailCapacity = mailCapacity;

        return mailCapacity;
    }

    // Set alternative email
    public void setAltEmail(String altEmail) {
        this.altEmail = altEmail;
    }

    // Change your password
    public void setNewPassword(String newPassword) {
        this.password = newPassword;
    }

    // Getters for methods
    public int getMailCapacity() {
        return mailCapacity;
    }

    public String getAltEmail() {
        return altEmail;
    }

    public String getPassword() {
        return password;
    }

    public String showInfo() {
        return "\nFirst Name: " + firstName +
                "\nLast Name: " + lastName +
                "\nEmail: " + email +
                "\nPassword: " + password +
                "\nMail Capacity: " + mailCapacity + "mb";
    }
}
