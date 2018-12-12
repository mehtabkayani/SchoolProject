package schoolmanagementproject;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import schoolmanagementproject.domain.Course;
import schoolmanagementproject.domain.Education;
import schoolmanagementproject.domain.Student;
import schoolmanagementproject.domain.Teacher;

/**
 *
 * @author mehtab kayani
 */
public class SchoolManagementProject {

    public static void main(String[] args) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("PU");
        EntityManager em = emf.createEntityManager();
        
         
        
        em.getTransaction().begin();
       
     
               List<Education> z = em.createQuery("Select a From Education a", Education.class).getResultList();
        for (Education education : z) {
            System.out.println(education);
        }
        
            em.getTransaction().commit();
        em.close();
    }
        
        //Education edu = em.find(Education.class, 3);
        
//        Teacher b = em.find(Teacher.class, 1);
//        Course x = em.find(Course.class, 6);
//        Education edu = em.find(Education.class,3 );
//       b.addCourse(x);
//       em.persist(b);



    

}
