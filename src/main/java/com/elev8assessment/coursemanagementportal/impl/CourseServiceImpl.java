package com.elev8assessment.coursemanagementportal.impl;

import com.elev8assessment.coursemanagementportal.entity.Course;
import com.elev8assessment.coursemanagementportal.repository.CourseRepository;
import com.elev8assessment.coursemanagementportal.service.CourseService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CourseServiceImpl implements CourseService {

    private CourseRepository courseRepository;

    public CourseServiceImpl(CourseRepository courseRepository) {
        this.courseRepository = courseRepository;
    }

    @Override
    public List<Course> getAllCourses() {

        return courseRepository.findAll();
    }


    @Override
    public Course getCourse(Long id) {

        Optional<Course> optionalCourse = courseRepository.findById(id);

        if(optionalCourse.isPresent()) {
            Course course = optionalCourse.get();

            return course;
        }
        return null;
    }

    @Override
    public void updateCourse(Course course) {
        courseRepository.save(course);
    }

    @Override
    public void saveCourse(String courseName, String courseCode, String courseDescription) {
        // Store
        Course course = new Course();
        course.setCourseName(courseName);
        course.setCourseCode(courseCode);
        course.setCourseDescription(courseDescription);

        courseRepository.save(course);

    }

    @Override
    public void deleteCourse(Long id) {
        courseRepository.deleteById(id);
    }

 }
