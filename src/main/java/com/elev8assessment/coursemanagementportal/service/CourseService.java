package com.elev8assessment.coursemanagementportal.service;

import com.elev8assessment.coursemanagementportal.entity.Course;

import java.util.List;

public interface CourseService {

    List<Course> getAllCourses();

    void saveCourse(String courseName, String courseCode, String courseDescription);

    Course getCourse(Long id);

    void updateCourse(Course course);

    void deleteCourse(Long id);
}
