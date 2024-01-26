package com.elev8assessment.coursemanagementportal.entity;

import jakarta.persistence.*;

@Entity
public class Course {

    public Course() {

    }

    public Course(String courseName, String courseCode, String courseDescription) {
        super();
        this.courseName = courseName;
        this.courseCode = courseCode;
        this.courseDescription = courseDescription;
    }

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.TABLE)
    private Long id;

    @Column(name="course_name", nullable =false)
    private String courseName;
    @Column(name="course_code", nullable = false)
    private String courseCode;

    @Column(name="course_description")
    private String courseDescription;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public String getCourseCode() {
        return courseCode;
    }

    public void setCourseCode(String courseCode) {
        this.courseCode = courseCode;
    }

    public String getCourseDescription() {
        return courseDescription;
    }

    public void setCourseDescription(String courseDescription) {
        this.courseDescription = courseDescription;
    }
}
