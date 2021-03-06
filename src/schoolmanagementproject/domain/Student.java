/**
 * This file was generated by the Jeddict
 */
package schoolmanagementproject.domain;

import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

/**
 * @author mehtab kayani
 */

@NamedQueries({
        @NamedQuery(name="showByName",query = ("Select a From Student a Where a.name Like :name")),
        @NamedQuery(name="showAll", query = ("Select a From Student a")),

})


@Entity
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Basic
    private String name;

    @Basic
    private String gender;

    @Basic
    private int age;

    @ManyToOne
    @JoinColumn(nullable = true)
    private Education education;

    public Student() {
    }

    public Student(String name, int age, String gender) {
        this.name = name;
        this.gender = gender;
        this.age = age;
    }
    
    

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return this.gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public int getAge() {
        return this.age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Education getEducation() {
        return this.education;
    }

    public void setEducation(Education education) {
        this.education = education;
    }

    @Override
    public String toString() {
        return "Student ID: " + id + ", Name:" + name  + ", Age: " + age + ", Gender: " + gender + ", Education: " + education.getName();
    }
    
    

}