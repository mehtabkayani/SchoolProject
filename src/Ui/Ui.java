/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ui;

import static SwitchSchool.SwitchSchool.SwitchFind;
import static SwitchSchool.SwitchSchool.SwitchMainMenu;
import static SwitchSchool.SwitchSchool.SwitchManagement;
import static SwitchSchool.SwitchSchool.SwitchRegister;
import static SwitchSchool.SwitchSchool.SwitchRemove;
import static SwitchSchool.SwitchSchool.SwitchStats;
import static SwitchSchool.SwitchSchool.SwitchUpdate;
import java.util.List;
import java.util.Scanner;
import schoolmanagementproject.domain.Education;
import schoolmanagementproject.domain.Student;

/**
 *
 * @author mehtab kayani
 */
public class Ui {

    static Scanner scan = new Scanner(System.in);

    public static int mainMenu() {
        int val;
        System.out.println("********MAIN MENU*********");
        System.out.println("1.School Management");
        System.out.println("2.School Statistics");
        System.out.println("0.Exit");
        System.out.println("**************************");
        val = readNumber("Choose above what you want to do...");
        SwitchMainMenu(val);
        return val;
    }

    public static int managementMenu() {
        int val;
        System.out.println("*********Management System*********");
        System.out.println("1.Register/Add Entity");
        System.out.println("2.Find Entity");
        System.out.println("3.Update Entity");
        System.out.println("4.Remove Entity");
        System.out.println("0.Back to main menu");
        System.out.println("***********************************");

        val = readNumber("Choose above what you want to do...");
        SwitchManagement(val);
        return val;

    }

    public static int regMenu() {
        int val;
        System.out.println("*******Register Menu*******");
        System.out.println("1. Register a new Student");
        System.out.println("2. Register a new Teacher");
        System.out.println("3. Add a Teacher to a course");
        System.out.println("4. Register a new Education");
        System.out.println("5. Register a new Course");
        System.out.println("6. Add a course to an Education");
        System.out.println("0. Back to previous menu");
        System.out.println("***************************");
        val = readNumber("Choose something");
        SwitchRegister(val);
        return val;
    }

    public static int findMenu() {
        int val;
        System.out.println("*******Information Menu*******");
        System.out.println("1.Find all Students ");
        System.out.println("2.Find Student by ID");
        System.out.println("3.Find Student by Name");
        System.out.println("4.Find Students by Course");
        System.out.println("5.Find Students by Education");
        System.out.println("6.Find all Teachers");
        System.out.println("7.Find Teacher by ID");
        System.out.println("8.Find Teacher by Name");
        System.out.println("9.Find Teachers by Course");
        System.out.println("10.Find Teachers by Education");
        System.out.println("11.Find all Courses");
        System.out.println("12.Find all Educations");
        System.out.println("0. Back to previous menu");
        System.out.println("******************************");
        val = readNumber("Choose something..");
        SwitchFind(val);
        return val;
    }

    public static int updateMenu() {
        int val;
        System.out.println("******Update Menu*******");
        System.out.println("1.Update Students name");
        System.out.println("2.Update Teachers name");
        System.out.println("3.Update students education");
        System.out.println("4.Update teacher course");
        System.out.println("0.Back to previous menu");
        System.out.println("************************");
        val = readNumber("Choose something");
        SwitchUpdate(val);
        return val;
    }

    public static int removeMenu() {
        int val;
        System.out.println("******Remove Menu*******");
        System.out.println("1.Remove Student");
        System.out.println("2.Remove Teacher");
        System.out.println("3.Remove Course");
        System.out.println("4.Remove Education");
        System.out.println("0. Back to previous menu");
        System.out.println("************************");
        val = readNumber("Choose something");
        SwitchRemove(val);
        return val;
    }

    public static int SchoolStatistics() {
        int val;
        System.out.println("*******Statistics Menu********");
        System.out.println("1.Total Students");
        System.out.println("2.Total Teachers");
        System.out.println("3.Total Courses");
        System.out.println("4.Total Educations");
        System.out.println("5.Total Male Students/Teachers");
        System.out.println("6.Total Female Students/Teacher");
        System.out.println("7.Avarage age of Students/Teachers");
        System.out.println("8.Highest age of Student/Teacher");
        System.out.println("9.Lowest age of Student/Teacher");
        System.out.println("0.Back to Main menu");
        System.out.println("*******************************");
        val = readNumber("Choose above what you want to do...");
        SwitchStats(val);
        return val;
    }

    public static String enterName() {
        return readText("Enter name");
    }

    public static String enterGender() {
        return readText("Enter gender");
    }

    public static int enterAge() {
        return readNumber("Enter age:");
    }

    public static int enterId() {
        return readNumber("Enter Id: ");
    }

    public static String readText(String t) {

        boolean loop = true;

        while (loop) {
            try {
                System.out.println(t);
                String name = scan.nextLine();
                return name;
            } catch (Exception e) {
                System.out.println("Try again");
            }

        }
        return null;
    }

    public static int readNumber(String s) {
        boolean loop = true;
        int id = 0;
        while (loop) {
            try {
                System.out.println(s);
                id = scan.nextInt();
                scan.nextLine();
                loop = false;
            } catch (Exception e) {
                scan.nextLine();
                System.out.println("Only digits are allowed!!");
            }
        }
        return id;
    }

    public static <T> void showAll(List<T> list) {
        System.out.println("\n********LIST OF INFORAMTION********");
        for (T elements : list) {
            System.out.println(elements);
        }
        System.out.println("***************************");

    }

    public static void mainOrExit() {
        System.out.println("Back to main menu, enter 'y'");
        System.out.println("Exit the program, enter 'n'");
        String val = scan.nextLine().toLowerCase();
        if (val.equalsIgnoreCase("Y")) {
            SwitchMainMenu(mainMenu());
        } else if (val.equalsIgnoreCase("N")) {
            System.exit(0);
        } else {
            System.out.println("Try again");
            mainOrExit();
        }
    }
}
