/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;


import SwitchSchool.SwitchSchool;
import static Ui.Ui.mainMenu;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import schoolmanagementproject.domain.Course;
import schoolmanagementproject.domain.Education;

/**
 *
 * @author mehtab kayani
 */
public class main {

    public static void main(String[] args) {
//        EntityManagerFactory emf = Persistence.createEntityManagerFactory("PU");
//        EntityManager em = emf.createEntityManager();
//        
//        em.getTransaction().begin();
//  
//        em.getTransaction().commit();
//        em.close();
        
        SwitchSchool.SwitchMainMenu(mainMenu());
    }

}
