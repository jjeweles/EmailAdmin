package emailadmin;

import java.util.Scanner;

public class EmailAdmin {

    public static void main(String[] args) {
        createNewEmail();
    }

    public static void createNewEmail() {
        Scanner userInput = new Scanner(System.in);
        System.out.print("Enter first name: ");
        String firstName = userInput.nextLine();
        System.out.print("Enter last name: ");
        String lastName = userInput.nextLine();
        Email user = new Email(firstName, lastName);
        System.out.println(user.showInfo());
    }
}
