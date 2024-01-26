package com.elev8assessment.coursemanagementportal.controller;

import com.elev8assessment.coursemanagementportal.entity.Course;
import com.elev8assessment.coursemanagementportal.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping(value="/courseportal")
public class CourseController {

    @Autowired
    private CourseService courseService;

    @RequestMapping(value = "")
    public ModelAndView home() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("course/index");
        return modelAndView;
    }

    @RequestMapping(value = "/view", method = RequestMethod.GET)
    public ModelAndView view(@RequestParam(value = "id") Long id) {

        Course course = courseService.getCourse(id);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("course/view_course");
        modelAndView.addObject("course", course);
        return modelAndView;
    }


    @RequestMapping(value = "/create", method = RequestMethod.GET)
    public ModelAndView create() {
        ModelAndView modelAndView = new ModelAndView();

        modelAndView.setViewName("course/createcourse");

        return modelAndView;
    }


    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public ModelAndView register(@RequestParam(value = "courseName") String courseName,
                                 @RequestParam(value = "courseCode") String courseCode,
                                       @RequestParam(value="courseDescription") String courseDescription) {

        courseService.saveCourse(courseName, courseCode, courseDescription);

        ModelAndView modelAndView = new ModelAndView();
        List<Course> courseList = courseService.getAllCourses();

        modelAndView.setViewName("course/courselist");
        modelAndView.addObject("courses", courseList);

        return modelAndView;
    }


    @RequestMapping(value = "/courseslist", method = RequestMethod.GET)
    public ModelAndView courselist() {
        ModelAndView modelAndView = new ModelAndView();

        List<Course> courseList = courseService.getAllCourses();
        modelAndView.setViewName("course/courselist");
        modelAndView.addObject("courses", courseList);
        return modelAndView;
    }



    @RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
    public ModelAndView edit(@PathVariable(value = "id") Long id) {

        Course course = courseService.getCourse(id);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("course/editcourse");
        modelAndView.addObject("course", course);
        return modelAndView;
    }

    @RequestMapping(value = "/update/{id}", method = RequestMethod.POST)
    public ModelAndView update(Course course,
                               @PathVariable(value = "id") long id) {

        course.setId(id);
        courseService.updateCourse(course);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("course/view_course");
        modelAndView.addObject("course", course);
        return modelAndView;
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
    public ModelAndView delete(@PathVariable(value = "id") long id) {

        ModelAndView modelAndView = new ModelAndView();

        courseService.deleteCourse(id);
//        System.out.println("Course deleted successfully");

        List<Course> courseList = courseService.getAllCourses();
        modelAndView.setViewName("course/courselist");
        modelAndView.addObject("courses", courseList);
        return modelAndView;

    }


}