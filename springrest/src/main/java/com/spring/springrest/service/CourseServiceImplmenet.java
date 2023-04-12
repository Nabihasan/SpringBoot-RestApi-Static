package com.spring.springrest.service;

import java.util.*;
//import java.util.*;import java.util.stream.Collector;
import java.util.stream.Collectors;

//import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

//import com.spring.springrest.dao.CourseDao;
import com.spring.springrest.entities.Course;
@Service
public class CourseServiceImplmenet implements CourseService {
	
	
	List<Course> list;
	


	
	public CourseServiceImplmenet() {
		list=new ArrayList<>();
		list.add(new Course(121,"java course","this is java code") );
		list.add(new Course(131,"python course","this is python code") );
	}
	@Override
	public List<Course> getCourses() {
		
		return list;
	}

	
	@Override
	public Course getCourse(long courseId) {
		Course c=null;
		for(Course course:list) {
			if(course.getId()==courseId) {
				c =course;
				break;
			}
		}
		return c;
	}

	@Override
	public Course addCourse(Course course) {
	list.add(course);
		
		return course;
	}

	@Override
	public Course updateCourse(Course course) {
		list.forEach(e->{
			if(e.getId()== course.getId()) {
				e.setTitle(course.getTitle());
				e.setDescription(course.getDescription());
			}
		});
		
		return course;
	}

	@Override
	public void deleteCourse(long parseLong) {
	list=this.list.stream().filter(e->e.getId()!=parseLong).collect(Collectors.toList());
	
	}


	

}
