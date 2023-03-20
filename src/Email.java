import java.util.Scanner;

public class Email {
    private String firstName;
    private String lastName;
    private String password;
    private String department;
    private String alternateEmail;
    private String email;
    private int mailboxCapacity;
    private int defaultPasswordLength = 10;
    private String companySuffix;

    // Constructor to receive the first name and last name
    public Email(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.department = setDepartment();
        this.password = randomPassword(defaultPasswordLength);
        companySuffix = ((department == "") ? "company.com" : department + ".company.com");
        email = firstName.toLowerCase() + "." + lastName.toLowerCase() + "@" + companySuffix;
        System.out.println("Your password is: " + this.password);
    }

    private String randomPassword(int length) {
        String passwordSet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789!@#$%";
        char[] password = new char[length];
        for (int i = 0; i < length; i++) {
            int rand = (int) (Math.random() * passwordSet.length());
            password[i] = passwordSet.charAt(rand);
        }
        return new String(password);
    }

    private String setDepartment() {
        String department = "";
        System.out.print(
                "New worker: " + firstName
                        + "\nEnter deptartment code:\n1 for Sales\n2 for Development\n3 for Accounting\n0 for none\nEnter department code: ");
        Scanner in = new Scanner(System.in);
        int depChoice = in.nextInt();
        if (depChoice == 1) {
            department = "sales";
        } else if (depChoice == 2) {
            department = "dev";
        } else if (depChoice == 3) {
            department = "acct";
        }
        in.close();
        return department;
    }

    // Set the mailbox capacity
    public void setMailboxCapacity(int capacity) {
        this.mailboxCapacity = capacity;
    }

    public int getMailboxCapacity() {
        return mailboxCapacity;
    }

    // Set the alternate email
    public void setAlternateEmail(String altEmail) {
        this.alternateEmail = altEmail;
    }

    public String getAlternateEmail() {
        return alternateEmail;
    }

    // Change the password
    public void changePassword(String password) {
        this.password = password;
    }

    public String getPassword() {
        return password;
    }

    public String showInfo() {
        return "DISPLAY NAME: " + firstName + " " + lastName +
                "\nCOMPANY EMAIL: " + email + "\nMAILBOX CAPACITY: " + mailboxCapacity + "mb";
    }
}
