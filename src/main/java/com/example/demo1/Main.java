//package com.example.demo1;
//
//import java.util.Scanner;
//
//// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
//// then press Enter. You can now see whitespace characters in your code.
//public class Main {
//    private static Scanner s = new Scanner(System.in);
//
////    public static void main(String[] args) {
////        CompanyManager companyManager = new CompanyManager();
////        UserManager userManager = new UserManager();
////
////        Scanner scanner = new Scanner(System.in);
////        boolean isRun = true;
////
////        while (isRun) {
////            System.out.println("Menu:");
////            System.out.println("0. Exit");
////            System.out.println("1. Add Company");
////            System.out.println("2. Add User");
////            System.out.println("3. Update Company by ID");
////            System.out.println("4. Print all Companies");
////            System.out.println("5. Companies by ID");
////            System.out.println("6. Print all Users");
////            System.out.println("7. Print Users by CompanyID");
////            System.out.println("8. Delete User by ID");
////
////            System.out.print("Please input your choice: ");
////            int choice = scanner.nextInt();
////            scanner.nextLine();  // Consume newline
////
////            switch (choice) {
////                case 0:
////                    isRun = false;
////                    break;
////                case 1:
////                    System.out.print("Enter company name: ");
////                    String companyName = scanner.nextLine();
////                    System.out.print("Enter field: ");
////                    int field = scanner.nextInt();
////                    int userId = 1;  // Assuming a user ID (change this based on your actual implementation)
////                    Company newCompany = new Company(0, companyName, field, userManager.getById(userId));
////                    companyManager.save(newCompany);
////                    System.out.println("Company added successfully.");
////                    break;
////                case 2:
////                    System.out.print("Enter user name: ");
////                    String userName = scanner.nextLine();
////                    System.out.print("Enter age: ");
////                    int age = scanner.nextInt();
////                    User newUser = new User(0, userName, age);
////                    userManager.save(newUser);
////                    System.out.println("User added successfully.");
////                    break;
////                case 3:
////                    System.out.print("Enter the company ID to update: ");
////                    int companyIdToUpdate = scanner.nextInt();
////                    scanner.nextLine();  // Consume newline
////
////                    System.out.print("Enter the new name for the company: ");
////                    String newCompanyName = scanner.nextLine();
////
////                    System.out.print("Enter the new field for the company: ");
////                    int newField = scanner.nextInt();
////                    scanner.nextLine();  // Consume newline
////
////                    companyManager.updateCompanyById(companyIdToUpdate, newCompanyName, newField);
////                    break;
////                case 4:
////                    List<Company> companies = companyManager.getAll("");
////                    for (Company company : companies) {
////                        System.out.println(company);
////                    }
////                    break;
////                case 5:
////                    // Print a company by ID (implement this based on your actual requirements)
////                    break;
////                case 6:
////                    List<User> users = userManager.getAll();
////                    for (User user : users) {
////                        System.out.println(user);
////                    }
////                    break;
////                case 7:
////                    System.out.print("Enter the company ID to retrieve users: ");
////                    int companyIdToRetrieveUsers = scanner.nextInt();
////                    scanner.nextLine();  // Consume newline
////
////                    List<User> usersForCompany = companyManager.getUsersByCompanyId(companyIdToRetrieveUsers);
////
////                    if (usersForCompany.isEmpty()) {
////                        System.out.println("No users found for the specified company ID.");
////                    } else {
////                        System.out.println("Users for Company ID " + companyIdToRetrieveUsers + ":");
////                        for (User user : usersForCompany) {
////                            System.out.println(user);
////                        }
////                    }
////                    break;
////                case 8:
////                    System.out.print("Enter the user ID to delete: ");
////                    int userIdToDelete = scanner.nextInt();
////                    scanner.nextLine();  // Consume newline
////
////                    userManager.deleteUserById(userIdToDelete);
////                    break;
////                default:
////                    System.out.println("Invalid choice. Please try again.");
////                    break;
////            }
////        }
////
////        scanner.close();
////    }
//
//    public static void main(String[] args) {
//        CompanyManager companyManager = new CompanyManager();
//        UserManager userManager = new UserManager();
//        User user = userManager.getAll().get(0);
//        // Create a new company
//        Company newCompany = new Company(0, "Sample Company", 12345 , user);
//
//        // Save the company to the database
//        Company savedCompany = companyManager.save(newCompany);
//        System.out.println("Saved company: " + savedCompany);
//
//        // Retrieve the company by name
//        Company retrievedCompanyByName = companyManager.getByName("Sample Company");
//        System.out.println("Company retrieved by name: " + retrievedCompanyByName);
//
//        // Update the company's field and user ID
//        retrievedCompanyByName.setFild(54321);
//        retrievedCompanyByName.setUserID(user);
//        companyManager.update(retrievedCompanyByName);
//        System.out.println("Company updated: " + retrievedCompanyByName);
//
//        // Get all companies
//        List<Company> allCompanies = companyManager.getAll("");
//        System.out.println("All companies: " + allCompanies);
//
//        // Delete the company by name
////        companyManager.delete("Sample Company");
//        System.out.println("Company deleted with name: Sample Company");
//
//    }
//
//
////    public static void main(String[] args) {
////        // Create an instance of the UserManager
////        UserManager userManager = new UserManager();
////
////        // Create a new user
////        User newUser = new User(0, "John Doe", 30);
////
////        // Save the user to the database
////        User savedUser = userManager.save(newUser);
////        System.out.println("Saved user: " + savedUser);
////
////        // Retrieve the user by ID
////        User retrievedUserById = userManager.getById(savedUser.getId());
////        System.out.println("User retrieved by ID: " + retrievedUserById);
////
////        // Retrieve the user by name
////        User retrievedUserByName = userManager.getByName("John Doe");
////        System.out.println("User retrieved by name: " + retrievedUserByName);
////
////        // Update the user's age
////        retrievedUserById.setAge(31);
////        userManager.update(retrievedUserById);
////        System.out.println("User updated: " + retrievedUserById);
////
////    }
//
//
//}