/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SwitchSchool;

import Ui.Ui;
import SchoolDao.SchoolManagementDao;
import SchoolDao.SchoolManagementDaoImpl;
import SchoolStatistics.Statistics;
import static Ui.Ui.SchoolStatistics;
import static Ui.Ui.mainMenu;
import static Ui.Ui.*;
import java.util.List;
import schoolmanagementproject.domain.Student;

/**
 *
 * @author mehtab kayani
 */
public class SwitchSchool {

    public static void SwitchMainMenu(int val) {
        boolean loop = true;
        while (loop) {
            switch (val) {

                case 0:
                    System.exit(0);
                    break;
                case 1:
                    Ui.managementMenu();
                    break;
                case 2:
                    SchoolStatistics();
                    break;
                default:
                    System.out.println("Try again");
                    mainMenu();
                    break;
            }
            loop = false;
        }
    }

    public static void SwitchManagement(int val) {
        boolean loop = true;
        while (loop) {
            switch (val) {
                case 0:
                    mainMenu();
                    break;
                case 1:
                    Ui.regMenu();
                    break;
                case 2:
                    Ui.findMenu();
                    break;
                case 3:
                    Ui.updateMenu();
                    break;
                case 4:
                    Ui.removeMenu();
                    break;
                default:
                    System.out.println("Wrong choise");
                    managementMenu();
                    break;
            }
            loop = false;
        }
    }

    public static void SwitchFind(int val) {
        SchoolManagementDaoImpl sdao = new SchoolManagementDaoImpl();
        // Student student = new Student();
        //Ui ui = new Ui();
        boolean loop = true;
        while (loop) {
            switch (val) {
                case 0:
                    managementMenu();
                    break;
                case 1:
                    Ui.showAll(sdao.showAllStudents());
                    break;
                case 2:
                    System.out.println("*********************************");
                    System.out.println("Which student are you looking for?");
                    sdao.findStudentById(Ui.enterId());
                    break;
                case 3:
                    Ui.showAll(sdao.findStudentByName(Ui.enterName()));
                    break;
                case 4:
                    System.out.println("****All COURSES****");
                    sdao.showCourseInfo();
                    System.out.println("ENTER THE COURSE ID TO SEE ALL THE STUDENTS IN THE COURSE...");
                    sdao.findStudentsByCourse(Ui.enterId());
                    break;
                case 5:
                    System.out.println("****ALL EDUCATION****");
                    sdao.showEducationinfo();
                    System.out.println("ENTER THE EDUCATION ID TO SEE ALL THE STUDENTS IN THE EDUCATION...");
                    Ui.showAll(sdao.findStudentsByEducation(Ui.enterId()));
                    break;
                case 6:
                    System.out.println("*****ALL TEACHERS****");
                    sdao.showTeacherInfo();
                    Ui.showAll(sdao.showAllTeachers());
                    break;
                case 7:
                    System.out.println("*********************************");
                    System.out.println("Which teacher are you looking for?");
                    sdao.findTeacherById(Ui.enterId());
                    break;
                case 8:
                    Ui.showAll(sdao.findTeacherByName(Ui.enterName()));
                    break;
                case 9:
                    System.out.println("****ALL COURSES****");
                    sdao.showCourseInfo();
                     System.out.println("ENTER THE COURSE ID TO SEE ALL TEACHERS IN THE COURSE...");
                    Ui.showAll(sdao.findTeacherByCourse(Ui.enterId()));
                    break;
                case 10:
                    System.out.println("****ALL EDUCATIONS***");
                    sdao.findTeacherByEducation(Ui.enterId());
                    System.out.println("ENTER THE EDUCATION ID TO SEE ALL THE TEACHERS IN THE EDUCATION...");
                    break;
                case 11:
                    Ui.showAll(sdao.showAllCourse());
                    break;
                case 12:
                    Ui.showAll(sdao.showAllEducations());
                    break;
                default:
                    System.out.println("Wrong choice");
                    findMenu();
                    break;
            }
            loop = false;
        }
        Ui.mainOrExit();
    }

    public static void SwitchRegister(int val) {
        SchoolManagementDaoImpl sdao = new SchoolManagementDaoImpl();
        boolean loop = true;
        while (loop) {
            switch (val) {
                case 0:
                    managementMenu();
                    break;
                case 1:
                    sdao.showEducationinfo();
                    sdao.registerStudentToEducation(Ui.enterName(), Ui.enterGender(), Ui.enterAge(), Ui.enterId());
                    break;
                case 2:
                    sdao.showCourseInfo();
                    sdao.registerTeacherToCourse(Ui.enterName(), Ui.enterAge(), Ui.enterGender(), Ui.enterId());
                    break;
                case 3:
                    System.out.println("****ALL COURSES****");
                    sdao.showCourseInfo();
                    System.out.println("<<<<Enter the Teacher ID followed by the Course ID>>>>");
                    sdao.addExistingTeacherToCourse(Ui.enterId(), Ui.enterId());
                    break;
                case 4:
                    sdao.registerEducation(Ui.enterName());
                    break;
                case 5:
                    sdao.registerCourseToEducation(Ui.enterName(), Ui.enterId());
                    break;
                case 6:
                    System.out.println("\n<<<<Enter the Course ID followed by the Education ID");
                    sdao.addExistingCourseToEducation(Ui.enterId(), Ui.enterId());
                    break;

                default:
                    System.out.println("Wrong choice...");
                    regMenu();
                    break;
            }
            loop = false;
        }
        Ui.mainOrExit();
    }

    public static void SwitchUpdate(int val) {
        SchoolManagementDaoImpl sdao = new SchoolManagementDaoImpl();
        // Student student = new Student();
        //Ui ui = new Ui();
        boolean loop = true;
        while (loop) {
            switch (val) {
                case 0:
                    managementMenu();
                    break;
                case 1:
                    System.out.println("****ALL STUDENTS****");
                    sdao.showStudentInfo();
                    sdao.updateStudentsName(Ui.enterId(), Ui.enterName());
                    break;
                case 2:
                    System.out.println("****ALL TEACHERS****");
                    sdao.showTeacherInfo();
                    sdao.updateTeachersName(Ui.enterId(), Ui.enterName());
                    break;
                case 3:
                    System.out.println("****ALL EDUCATIONS****");
                    sdao.showEducationinfo();
                    System.out.println("\n<<<<Enter the Student ID followed by the Education ID>>>>");
                    sdao.updateStudentEducation(Ui.enterId(), Ui.enterId());
                    break;
                case 4:
                    sdao.showCourseInfo();
                    System.out.println("\n<<<<Enter the Teacher ID followed by the Course ID>>>>");
                    sdao.updateRemoveTeacherCourse(Ui.enterId(), Ui.enterId());
                    break;

                default:
                    System.out.println("Wrong choice");
                    updateMenu();
                    break;
            }
            loop = false;
        }
        Ui.mainOrExit();
    }

    public static void SwitchRemove(int val) {
        SchoolManagementDaoImpl sdao = new SchoolManagementDaoImpl();
        // Student student = new Student();
        //Ui ui = new Ui();
        boolean loop = true;
        while (loop) {
            switch (val) {
                case 0:
                    managementMenu();
                    break;
                case 1:
                    System.out.println("****ALL STUDENTS****");
                    sdao.showStudentInfo();
                    sdao.removeStudent(Ui.enterId());
                    break;
                case 2:
                    System.out.println("****ALL TEACHERS****");
                    sdao.showTeacherInfo();
                    sdao.removeTeacher(Ui.enterId());
                    break;
                case 3:
                    sdao.removeCourse(Ui.enterId());
                    break;
                case 4:
                    sdao.removeEducation(Ui.enterId());
                    break;

                default:
                    System.out.println("Wrong choice");
                    removeMenu();
                    break;
            }
            loop = false;
        }
        Ui.mainOrExit();
    }

    
    public static void SwitchStats(int val) {
        boolean loop = true;
        while (loop) {
            switch (val) {
                case 0:
                    mainMenu();
                    break;
                case 1:
                     Statistics.totalStudent();
                    
                    break;
                case 2:
                    Statistics.totalTeachers();
                    break;
                case 3:
                    Statistics.totalCourses();
                    break;
                case 4:
                    Statistics.totalEducations();
                    break;
                case 5:
                    Statistics.numberOfMale();
                    break;
                case 6:
                    Statistics.numberOfFemale();
                    break;
                case 7:
                    Statistics.avarageAge();
                    break;
                case 8:
                    Statistics.highestAge();
                    break;
                case 9:
                    Statistics.lowestAge();
                    break;
                default:
                    System.out.println("Try again...");
                    SchoolStatistics();
                    break;
            }
            loop = false;
        }

        Ui.mainOrExit();

    }
}


/* public static void SwitchMenu(int val) {
        SchoolManagementDaoImpl sdao = new SchoolManagementDaoImpl();
        // Student student = new Student();
        //Ui ui = new Ui();
        boolean loop = true;
        while (loop) {
            switch (val) {
                case 0:
                    System.exit(0);
                    break;
                case 1:
                    sdao.showEducationinfo();
                    sdao.registerStudentToEducation(Ui.enterName(), Ui.enterGender(), Ui.enterAge(), Ui.enterId());
                    break;
                case 2:
                    sdao.showCourseInfo();
                    sdao.registerTeacherToCourse(Ui.enterName(), Ui.enterAge(), Ui.enterGender(), Ui.enterId());
                    break;
                case 3:
                    System.out.println("\n<<<<Enter the Teacher ID followed by the Course ID>>>>");
                    sdao.addExistingTeacherToCourse(Ui.enterId(), Ui.enterId());
                    break;
                case 4:
                    sdao.registerEducation(Ui.enterName());
                    break;
                case 5:
                    sdao.registerCourseToEducation(Ui.enterName(), Ui.enterId());
                    break;
                case 6:
                    System.out.println("\n<<<<Enter the Course ID followed by the Education ID");
                    sdao.addExistingCourseToEducation(Ui.enterId(), Ui.enterId());
                    break;
                case 7:
                    sdao.findStudentById(Ui.enterId());
                    break;
                case 8:
                    Ui.showAll(sdao.findStudentByName(Ui.enterName()));
                    break;
                case 9:

                    break;
                case 10:
                    Ui.showAll(sdao.findStudentsByEducation(Ui.enterId()));
                    break;
                case 11:
                    sdao.findTeacherById(Ui.enterId());
                    break;
                case 12:
                    Ui.showAll(sdao.findTeacherByName(Ui.enterName()));
                    break;
                case 13:
                    Ui.showAll(sdao.findTeacherByCourse(Ui.enterId()));
                    break;
                case 14:

                    break;
                case 15:
                    Ui.showAll(sdao.showAllStudents());
                    break;
                case 16:
                    Ui.showAll(sdao.showAllTeachers());
                    break;
                case 17:
                    Ui.showAll(sdao.showAllCourse());
                    break;
                case 18:
                    Ui.showAll(sdao.showAllEducations());
                    break;

               
                case 25:
                    sdao.findStudentsByCourse(Ui.enterId());
                    break;
                case 26:
                    sdao.findTeacherByEducation(Ui.enterId());
                    break;

                default:
                    System.out.println("Wrong choice");
                    break;
            }
            loop = false;
        }
        Ui.mainOrExit();
    }*/