package spikeking.github.com.testrxandroid;

/**
 * Created by lumin on 2017/3/21.
 */

public class Student {

    String name;

    Course[] courses ;

    public Student(String name){
        this.name = name;
    }

    public Student(String name,Course[] courses){
        this.name = name;
        this.courses = courses;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Course[] getCourses() {
        return courses;
    }

    public void setCourses(Course[] courses) {
        this.courses = courses;
    }



}
