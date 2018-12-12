/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SchoolDao;

import Ui.Ui;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import schoolmanagementproject.domain.Course;
import schoolmanagementproject.domain.Education;
import schoolmanagementproject.domain.Student;
import schoolmanagementproject.domain.Teacher;

/**
 *
 * @author mehtab kayani
 */
public class SchoolManagementDaoImpl implements SchoolManagementDao {

    EntityManagerFactory emf = Persistence.createEntityManagerFactory("PU");

    @Override
    public void registerStudentToEducation(String name, String gender, int age, int id) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        Student student = new Student(name, age, gender);
        em.persist(student);
        Education edu = em.find(Education.class, id);
        edu.addStudent(student);
        em.persist(edu);
        em.getTransaction().commit();
        em.close();

    }

    @Override
    public void registerTeacherToCourse(String name, int age, String gender, int id) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        Teacher teacher = new Teacher(name, age, gender);
        em.persist(teacher);
        Course course = em.find(Course.class, id);
        course.addTeacher(teacher);
        em.persist(course);
        em.getTransaction().commit();
        em.close();
    }

    @Override
    public void registerEducation(String name) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        Education education = new Education(name);
        em.persist(education);
        em.getTransaction().commit();
        em.close();
    }

    @Override
    public void registerCourseToEducation(String name, int id) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        Course course = new Course(name);
        Education education = em.find(Education.class, id);
        education.addCourse(course);
        em.persist(course);
        em.persist(education);
        em.getTransaction().commit();
        em.close();
    }

    @Override
    public List<Education> showAllEducations() {
        EntityManager em = emf.createEntityManager();
        List<Education> list = em.createNamedQuery("showAllE", Education.class).getResultList();
        return list;
    }

    @Override
    public boolean removeStudent(int id) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        Student student = em.find(Student.class, id);
        em.remove(student);
        em.getTransaction().commit();
        em.close();
        return true;
    }

    @Override
    public boolean removeTeacher(int id) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        Teacher teacher = em.find(Teacher.class, id);
        em.remove(teacher);
        em.getTransaction().commit();
        em.close();
        return true;
    }

    @Override
    public boolean removeCourse(int id) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        Course course = em.find(Course.class, id);
        em.remove(course);
        em.getTransaction().commit();
        em.close();
        return true;

    }

////    @Override
////    public boolean removeEducation(int id) {
////        EntityManager em = emf.createEntityManager();
////        em.getTransaction().begin();
////        Education education = em.find(Education.class, id);
////        em.remove(education);
////        em.getTransaction().commit();
////        em.close();
////        return true;
////    }
    @Override
    public boolean removeEducation(int id) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        Education education = em.find(Education.class, id);
        List<Student> list = education.getStudents();
        for (Student student : list) {
            student.setEducation(null);

        }
        em.remove(education);
        em.getTransaction().commit();
        em.close();
        return true;
    }

    @Override
    public void addExistingCourseToEducation(int id, int id2) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        Course course = em.find(Course.class, id);
        Education education = em.find(Education.class, id2);

        education.addCourse(course);
        em.persist(education);
        em.getTransaction().commit();
        em.close();
    }

    @Override
    public void addExistingTeacherToCourse(int id, int id2) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        Teacher teacher = em.find(Teacher.class, id);
        Course course = em.find(Course.class, id2);

        course.addTeacher(teacher);
        em.persist(course);
        em.getTransaction().commit();
        em.close();
    }

    @Override
    public void findStudentById(int id) {
        EntityManager em = emf.createEntityManager();
        Student student = em.find(Student.class, id);
        System.out.println(student);

    }

    @Override
    public List<Student> findStudentsByCourse(int id) {
        EntityManager em = emf.createEntityManager();

        //FUNKAR INTE
        return null;
    }

    @Override
    public List<Student> findStudentsByEducation(int id) {
        EntityManager em = emf.createEntityManager();
        Education education = em.find(Education.class, id);
        List<Student> list = education.getStudents();
        return list;
    }

    @Override
    public List<Teacher> findTeacherByCourse(int id) {
        EntityManager em = emf.createEntityManager();
        Course course = em.find(Course.class, id);
        List<Teacher> list = course.getTeachers();
        return list;
    }

    @Override
    public void findTeacherById(int id) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        Teacher teacher = em.find(Teacher.class, id);
        System.out.println(teacher);
        em.getTransaction().commit();
        em.close();
    }

    @Override
    public List<Student> findStudentByName(String name) {
        EntityManager em = emf.createEntityManager();
        Query query = em.createNamedQuery("showByName", Student.class);
        query.setParameter("name", "%" + name + "%");
        List<Student> list = query.getResultList();
        em.close();
        return list;
    }

    @Override
    public List<Teacher> findTeacherByName(String name) {
        EntityManager em = emf.createEntityManager();
        Query query = em.createNamedQuery("showByTName", Teacher.class);
        query.setParameter("name", "%" + name + "%");
        List<Teacher> list = query.getResultList();
        em.close();
        return list;

    }

    @Override
    public List<Teacher> findTeacherByEducation(int id) {
        //FUNKAR INTE
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Student> showAllStudents() {
        EntityManager em = emf.createEntityManager();
        List<Student> list = em.createNamedQuery("showAll", Student.class).getResultList();
        em.close();
        return list;
    }

    @Override
    public List<Teacher> showAllTeachers() {
        EntityManager em = emf.createEntityManager();
        List<Teacher> list = em.createNamedQuery("showAllT", Teacher.class).getResultList();
        return list;
    }

    @Override
    public List<Course> showAllCourse() {
        EntityManager em = emf.createEntityManager();
        List<Course> list = em.createNamedQuery("showAllC", Course.class).getResultList();
        return list;
    }

    @Override
    public boolean updateStudentsName(int id, String name) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        Student student = em.find(Student.class, id);
        student.setName(name);
        em.persist(student);
        em.getTransaction().commit();
        em.close();
        return true;
    }

    @Override
    public boolean updateTeachersName(int id, String name) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        Teacher teacher = em.find(Teacher.class, id);
        teacher.setName(name);
        em.persist(teacher);
        em.getTransaction().commit();
        em.close();
        return true;

    }

}
