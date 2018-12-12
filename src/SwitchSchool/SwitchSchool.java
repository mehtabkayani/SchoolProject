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
import static Ui.Ui.menu;
import schoolmanagementproject.domain.Student;

/**
 *
 * @author mehtab kayani
 */
public class SwitchSchool {
    
    public static void SwitchMainMenu(int val){
        
        switch(val){
        
            case 0: 
                System.exit(0);
                break;
            case 1:
                menu();
                break;
            case 2:
                SchoolStatistics();
                break;
            default:
                System.out.println("Try again");
                break;
        }
        
    }
    
    public static void SwitchMenu(int val){
         SchoolManagementDaoImpl sdao = new SchoolManagementDaoImpl();
        // Student student = new Student();
         //Ui ui = new Ui();
        
        switch(val){
            case 0:
                System.exit(0);
                break;
            case 1:
                sdao.registerStudentToEducation(Ui.enterName(),Ui.enterGender(),Ui.enterAge(),Ui.enterId());
                
                break;
            case 2:
                sdao.registerTeacherToCourse(Ui.enterName(),Ui.enterAge(),Ui.enterGender(),Ui.enterId());
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
                Ui.showAll(sdao.findStudentsByCourse(Ui.enterId())); //FUNKAR INTE
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
                Ui.showAll(sdao.findTeacherByCourse(Ui.enterId()));     //FUNKAR INTE
                break;
            case 14:
                Ui.showAll(sdao.findTeacherByEducation(Ui.enterId()));
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
            case 19:
                sdao.updateStudentsName(Ui.enterId(), Ui.enterName());
                break;
            case 20:
                sdao.updateTeachersName(Ui.enterId(), Ui.enterName());
                break;
            case 21:
                sdao.removeStudent(Ui.enterId());
                break;
            case 22:
                sdao.removeTeacher(Ui.enterId());
                break;
            case 23:
                sdao.removeCourse(Ui.enterId());
                break;
            case 24:
                sdao.removeEducation(Ui.enterId());
                break;
           
            default :
                System.out.println("Wrong choice");
                break;
        }
    }
    
    public static void SwitchStats(int val){
        switch(val){
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
              //  Statistics.totalEducations();
                break;
            case 5:
                break;
            case 6:
                break;
            case 7:
                break;
            case 8:
                break;
            case 9:
                break;
            default:
                System.out.println("Try again");
                break;
        }
    }
}
