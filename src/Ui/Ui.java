/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ui;

import static SwitchSchool.SwitchSchool.SwitchMenu;
import static SwitchSchool.SwitchSchool.SwitchStats;
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
        System.out.println("1.School Management");
        System.out.println("2.School Statistics");
        System.out.println("0.Exit");
        return readNumber("Choose above what you want to do...");

    }

    public static int menu() {
        int val;
        System.out.println("*******School Management*******");
        System.out.println("1. Register a new Student");
        System.out.println("2. Register a new Teacher");
        System.out.println("3. Add a Teacher to a course");
        System.out.println("4. Register a new Education");
        System.out.println("5. Register a new Course");
        System.out.println("6. Add a course to an Education");
        System.out.println("7. Find Student by ID");
        System.out.println("8. Find Student by Name");
        System.out.println("9. Find Students by Course"); //FUNKAR INTE
        System.out.println("10.Find Students by Education");
        System.out.println("11.Find Teacher by ID");
        System.out.println("12.Find Teacher by Name");
        System.out.println("13.Find Teachers by Course");
        System.out.println("14.Find Teachers by Education"); //FUNKAR INTE
        System.out.println("15.Show all Students ");
        System.out.println("16.Show all Teachers");
        System.out.println("17.Show all Courses");
        System.out.println("18.Show all Educations");
        System.out.println("19.Update Students name");
        System.out.println("20.Update Teacher ??");
        System.out.println("21.Remove Student");
        System.out.println("22.Remove Teacher");
        System.out.println("23.Remove Course");
        System.out.println("24.Remove Education");
        System.out.println("0.Exit the program");
        System.out.println("***********************");
        val = readNumber("Choose above what you want to do...");
        SwitchMenu(val);
        return val;
    }

    public static int SchoolStatistics() {
        int val;
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
}
