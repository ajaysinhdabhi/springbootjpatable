package com.luv2code.crudopdemo;

import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.luv2code.crudopdemo.dao.StudentDao;
import com.luv2code.crudopdemo.entity.Student;

@SpringBootApplication
public class CrudopdemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(CrudopdemoApplication.class, args);
	}
	
	@Bean
	public CommandLineRunner commandLineRunner(StudentDao studentDao) {

		return runner -> {
//			createStudent(studentDao);
			createMultipleStudents(studentDao);
//			readStudent(studentDao);
//			queryForStudents(studentDao);
//			queryForStudentsByLastName(studentDao);
//			updateStudent(studentDao);
//			deleteStudent(studentDao);
//			deleteAllStudents(studentDao);
		};
	}

	private void deleteAllStudents(StudentDao studentDao) {
		System.out.println("Deleting all students");
		int numRowsDeleted = studentDao.deleteAll();
		System.out.println("Deleted row count: " + numRowsDeleted);
		
	}

	private void deleteStudent(StudentDao studentDao) {
		int studentId = 3;
		System.out.println("Deleting student id: " + studentId);
		studentDao.delete(studentId);
		
	}

	private void updateStudent(StudentDao studentDao) {
		// retrieve student based on the id: primary key
				int studentId = 1;
				System.out.println("Getting student with id: " + studentId);
				Student myStudent = studentDao.findById(studentId);

				// change first name to "harshraj"
				System.out.println("Updating student ...");
				myStudent.setFirstName("harshraj");

				// update the student
				studentDao.update(myStudent);

				// display the updated student
				System.out.println("Updated student: " + myStudent);
		
	}

	private void queryForStudentsByLastName(StudentDao studentDao) {

		// get a list of students
		List<Student> theStudents = studentDao.findByLastName("hirani");

		// display list of students
		for (Student tempStudent : theStudents) {
			System.out.println(tempStudent);
		}
		
	}

	private void queryForStudents(StudentDao studentDao) {
		// get a list of students
				List<Student> theStudents = studentDao.findAll();

				// display list of students
				for (Student tempStudent : theStudents) {
					System.out.println(tempStudent);
				}
		
	}

	private void readStudent(StudentDao studentDao) {
		// create  a student object
				System.out.println("Creating new student object ...");
				Student tempStudent = new Student("axar", "patel", "axar@gmail.com");

				// save the student
				System.out.println("Saving the student ...");
				studentDao.save(tempStudent);

				// display id of the saved student
				int theId = tempStudent.getId();
				System.out.println("Saved student. Generated id: " + theId);

				// retrieve student based on the id: primary key
				System.out.println("Retrieving student with id: " + theId);
				Student myStudent = studentDao.findById(theId);

				// display student
				System.out.println("Found the student: " + myStudent);
		
	}

	private void createMultipleStudents(StudentDao studentDao) {
		// create multiple students
		System.out.println("Creating 3 student objects ...");
		Student tempStudent1 = new Student("manthan", "hirani", "manthan@gmail.com");
		Student tempStudent2 = new Student("ved", "patel", "ved@gmail.com");
		Student tempStudent3 = new Student("soham", "patel", "soham@gmail.com");
		
		// save the student objects
				System.out.println("Saving the students ...");
				studentDao.save(tempStudent1);
				studentDao.save(tempStudent2);
				studentDao.save(tempStudent3);
		
	}

	private void createStudent(StudentDao studentDao) {
		
		
		// create the student object
				System.out.println("Creating new student object ...");
				Student tempStudent=new Student("ajay", "dabhi", "ajay@gmail.com");
				
				// save the student object
				System.out.println("Saving the student ...");
				studentDao.save(tempStudent);
				

				// display id of the saved student
				System.out.println("Saved student. Generated id: " + tempStudent.getId());
	
		
	}
	

		
			
	
	


}
