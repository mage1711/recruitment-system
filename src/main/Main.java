package main;

import enums.AccountType;

import java.util.Scanner;

public class Main {
    public static AccountType currentAccountType = null;
    public static Account currentAccount = null;

    public static void main(String[] args) {
        Database.init();
        // login
        Scanner input = new Scanner(System.in);
        System.out.println("Select account type");
        System.out.println("1. Applicant");
        System.out.println("2. Recruiter");
        System.out.println("3. Admin");
        int accountType = input.nextInt();
        UserFactory userFactory = new UserFactory();
        String email;
        String password;
        switch (accountType) {
            case 1:
                userFactory.setType(AccountType.Applicant);
                Applicant applicant = (Applicant) userFactory.createUser();
                System.out.println("Enter email: ");
                input.nextLine();
                email = input.nextLine();
                System.out.println("Enter password: ");
                password = input.nextLine();

                if (applicant.login(email, password)) {
                    Main.currentAccount = applicant;
                    Main.currentAccountType = AccountType.Applicant;
                    System.out.println("Hoooray! You are now logged in as: " + applicant.getName());
                }
                break;
            case 2:
                userFactory.setType(AccountType.Recruiter);
                Recruiter recruiter = (Recruiter) userFactory.createUser();
                System.out.println("Enter email: ");
                input.nextLine();
                email = input.nextLine();
                System.out.println("Enter password: ");
                password = input.nextLine();

                if (recruiter.login(email, password)) {
                    Main.currentAccount = recruiter;
                    Main.currentAccountType = AccountType.Recruiter;
                    System.out.println("Hoooray! You are now logged in as: " + recruiter.getName());
                }
                break;
            case 3:
                Admin admin = new Admin();
                System.out.println("Enter email: ");
                input.nextLine();
                email = input.nextLine();
                System.out.println("Enter password: ");
                password = input.nextLine();

                if (admin.login(email, password)) {
                    Main.currentAccount = admin;
                    Main.currentAccountType = AccountType.Admin;
                    System.out.println("Hoooray! You are now logged in as: " + admin.getName());
                }
                break;
            default:
                System.out.println("Invalid input");
        }
    }
}
