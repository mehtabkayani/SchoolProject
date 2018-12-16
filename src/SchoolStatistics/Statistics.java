package SchoolStatistics;

import java.util.List;
import java.util.Scanner;
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
public class Statistics {

    static Scanner scan = new Scanner(System.in);
    static EntityManagerFactory emf = Persistence.createEntityManagerFactory("PU");

    public static void totalStudent() {
        EntityManager em = emf.createEntityManager();
        Query query = em.createQuery("Select Count(a.id) From Student a", Student.class);
        // List<Student> list = query.getResultList();
        int n = ((Number) query.getSingleResult()).intValue();
        System.out.println("**********************************");
        System.out.println("THE TOTAL NO. OF STUDENTS ARE: " + n);
        System.out.println("**********************************");
    }

    public static void totalTeachers() {
        EntityManager em = emf.createEntityManager();
        Query query = em.createQuery("Select Count(a.id)From Teacher a", Teacher.class);
        List<Teacher> list = query.getResultList();
        System.out.println("*************************************");
        System.out.println("THE TOTAL NO. OF TEACHERS ARE: " + list);
        System.out.println("*************************************");
    }

    public static void totalCourses() {
        EntityManager em = emf.createEntityManager();
        Query query = em.createQuery("Select Count(a.id)From Course a", Course.class);
        List<Course> list = query.getResultList();
        System.out.println("*************************************");
        System.out.println("THE TOTAL NO. OF COURSES ARE: " + list);
        System.out.println("*************************************");
    }

    public static void totalEducations() {
        EntityManager em = emf.createEntityManager();
        Query query = em.createQuery("Select Count(a.id)From Education a", Education.class);
        int n = ((Number) query.getSingleResult()).intValue();
        System.out.println("*************************************");
        System.out.println("THE TOTAL NO. OF EDUCATIONS ARE: " + n);
        System.out.println("*************************************");

    }

    public static void numberOfMale() {

        switch (input()) {
            case 1: {
                EntityManager em = emf.createEntityManager();
                Query query = em.createQuery("Select Count(a.gender) From Student a Where a.gender Like 'm%'", Student.class);
                List<Student> list = query.getResultList();
                System.out.println("*************************************");
                System.out.println("THE TOTAL NO. OF MALE STUDENTS ARE: " + list);
                System.out.println("*************************************");
                break;
            }
            case 2: {
                EntityManager em = emf.createEntityManager();
                Query query = em.createQuery("Select Count(a.gender) From Teacher a Where a.gender Like 'm%'", Teacher.class);
                List<Teacher> list = query.getResultList();
                System.out.println("*************************************");
                System.out.println("THE TOTAL NO. OF MALE TEACHERS ARE: " + list);
                System.out.println("*************************************");
                break;
            }
            default:
                numberOfMale();
                break;
        }

    }

    public static void numberOfFemale() {
        switch (input()) {
            case 1: {
                EntityManager em = emf.createEntityManager();
                Query query = em.createQuery("Select Count(a.gender) From Student a Where a.gender like 'f%'", Student.class);
                List<Student> list = query.getResultList();
                System.out.println("********************************************");
                System.out.println("THE TOTAL NO. FEMALE STUDENTS ARE: " + list);
                System.out.println("********************************************");
                break;
            }
            case 2: {
                EntityManager em = emf.createEntityManager();
                Query query = em.createQuery("Select Count(a.gender)From Teacher a Where a.gender like 'f%'", Teacher.class);
                List<Teacher> list = query.getResultList();
                System.out.println("********************************************");
                System.out.println("THE TOTAL NO. OF FEMALE TEACHERS ARE: " + list);
                System.out.println("********************************************");
                break;
            }

        }
    }

    public static void avarageAge() {
        EntityManager em = emf.createEntityManager();
        switch (input()) {

            case 1: {
                Query query = em.createQuery("Select AVG(a.age)From Student a", Student.class);
                List<Student> list = query.getResultList();
                System.out.println("********************************************");
                System.out.println("THE AVARAGE AGE OF THE STUDENTS ARE: " + list);
                System.out.println("********************************************");
                break;
            }
            case 2: {
                Query query = em.createQuery("Select AVG(a.age)From Teacher a", Teacher.class);
                List<Teacher> list = query.getResultList();
                System.out.println("********************************************");
                System.out.println("THE AVARAGE AGE OF THE TEACHERS ARE: " + list);
                System.out.println("********************************************");
                break;
            }
            default:
                System.out.println("Try again");
                avarageAge();
                break;

        }
    }
    
    public static void highestAge(){
        EntityManager em = emf.createEntityManager();
        switch(input()){
            case 1:{
                Query query = em.createQuery("Select MAX(a.age)From Student a",Student.class);
                List<Student> list = query.getResultList();
                System.out.println("********************************************");
                System.out.println("THE HIGHEST AGE OF THE STUDENTS IS: " + list);
                System.out.println("********************************************");
                break;
            }
            case 2: {
                Query query = em.createQuery("Select MAX(a.age)From Teacher a", Teacher.class);
                List<Teacher> list = query.getResultList();
                System.out.println("********************************************");
                System.out.println("THE HIGHEST AGE OF THE TEACHERS IS: " + list);
                System.out.println("********************************************");
                break;
            }
            default:
                highestAge();
                break;
        }
    }
    
    public static void lowestAge(){
        EntityManager em = emf.createEntityManager();
        switch(input()){
            case 1:{
                Query query = em.createQuery("Select MIN(a.age)From Student a", Student.class);
                List<Student> list = query.getResultList();
                System.out.println("********************************************");
                System.out.println("THE LOWEST AGE OF THE STUDENTS IS:" + list);
                System.out.println("********************************************");
                break;
            }
            case 2:{
                Query query = em.createQuery("Select MIN(a.age) From Teacher a", Teacher.class);
                List<Teacher> list = query.getResultList();
                System.out.println("********************************************");
                System.out.println("THE LOWEST AGE OF THE TEACHERS IS: " + list);
                System.out.println("********************************************");
                break;
            }
            default:
                System.out.println("Try again");
                lowestAge();
        }
    }

    public static int input() {
        System.out.println("**********");
        System.out.println("1.Students");
        System.out.println("2.Teachers");
        System.out.println("**********");
        int val = scan.nextInt();
        scan.nextLine();

        return val;
    }

}
