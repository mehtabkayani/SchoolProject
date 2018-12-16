/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SchoolDao;

import java.util.List;
import schoolmanagementproject.domain.Course;
import schoolmanagementproject.domain.Education;
import schoolmanagementproject.domain.Student;
import schoolmanagementproject.domain.Teacher;

/**
 *
 * @author mehtab kayani
 */
public interface SchoolManagementDao {

    public void registerStudentToEducation(String name, String gender, int age, int id); //DONE

    public void registerTeacherToCourse(String name, int age, String gender, int id);    //DONE

    public void addExistingTeacherToCourse(int id, int id2);                            //DONE

    public void registerEducation(String name);                                        //DONE

    public void registerCourseToEducation(String name, int id);                        //DONE

    public void addExistingCourseToEducation(int id, int id2);                         //DONE

    public void findStudentById(int id);                                               //DONE

    public List<Student> findStudentsByCourse(int id);                                 //DONE

    public List<Student> findStudentByName(String name);                              //DONE

    public List<Student> findStudentsByEducation(int id);                               //DONE

    public void findTeacherById(int id);                                                //DONE

    public List<Teacher> findTeacherByName(String name);                                //Done

    public List<Teacher> findTeacherByCourse(int id);                                   //DONE

    public List<Teacher> findTeacherByEducation(int id);                                //DONE

    public List<Student> showAllStudents();                                            //DONE

    public List<Teacher> showAllTeachers();                                             //DONE

    public List<Course> showAllCourse();                                                //DONE

    public List<Education> showAllEducations();                                         //DONE
    
    public void showStudentInfo();
    
    public void showTeacherInfo();                                                      //DONE
    
    public void showEducationinfo();                                                    //DONE
    
    public void showCourseInfo();                                                       //DONE
    
    public boolean updateStudentsName(int id, String name);                         //DONE     
    
    public boolean updateStudentEducation(int id, int id2);
    
    public boolean updateRemoveTeacherCourse(int id, int id2);
    
    public boolean updateTeachersName(int id, String name);                         //DONE

    public boolean removeStudent(int id);                                              //DONE

    public boolean removeTeacher(int id);                                              //DONE

    public boolean removeCourse(int id);                                                //DONE

    public boolean removeEducation(int id);                                         //DONE

}
