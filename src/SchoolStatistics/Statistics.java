package SchoolStatistics;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import schoolmanagementproject.domain.Course;
import schoolmanagementproject.domain.Student;
import schoolmanagementproject.domain.Teacher;

/**
 *
 * @author mehtab kayani
 */
public class Statistics {
   static EntityManagerFactory emf = Persistence.createEntityManagerFactory("PU");
    
    public static void totalStudent(){
     EntityManager em = emf.createEntityManager();
     Query query = em.createQuery("Select Count(a.id) From Student a", Student.class);
     // List<Student> list = query.getResultList();
    int n = ((Number)query.getSingleResult()).intValue();
       System.out.println("The total Students are: " + n);
    }
    
    public static void totalTeachers(){
        EntityManager em = emf.createEntityManager();
        Query query = em.createQuery("Select Count(a.id)From Teacher a", Teacher.class);
        List<Teacher> list = query.getResultList();
        System.out.println("Total no. of teachers are: " + list);
    }
    
    public static void totalCourses(){
        EntityManager em = emf.createEntityManager();
        Query query = em.createQuery("Select Count(a.id)From Course a",Course.class);
        List<Course> list = query.getResultList();
        System.out.println("The total no. of courses are: " + list);
    }
    
   // public static void total
}
