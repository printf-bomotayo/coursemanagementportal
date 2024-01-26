package com.elev8assessment.coursemanagementportal.repository;

import com.elev8assessment.coursemanagementportal.entity.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CourseRepository extends JpaRepository<Course, Long> {
}
