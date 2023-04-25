package com.example.cruddemo;

import com.example.cruddemo.dao.StudentDAO;
import com.example.cruddemo.entity.Student;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class CruddemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(CruddemoApplication.class, args);

	}

	@Bean
	public CommandLineRunner commandLineRunner(StudentDAO studentDAO){
		return runner -> {
			createStudent(studentDAO);

			//readStudent(studentDAO);



			//queryForStudentsByLastName(studentDAO);

			//updateStudents(studentDAO);

			//deleteStudent(studentDAO);

			//deleteAllStudents(studentDAO);
		};
	}

	private void deleteAllStudents(StudentDAO studentDAO) {
		studentDAO.deleteAll();
	}

	private void deleteStudent(StudentDAO studentDAO) {
		//Buscar aluno por id
		int studentId = 1;
		System.out.println("Buscando por aluno");

		//remover aluno
		studentDAO.delete(studentId);

	}

	private void updateStudents(StudentDAO studentDAO) {
		//buscar aluno por id
		int studentId = 1;
		System.out.println("Buscando aluno com id :"+studentId);
		Student myStudent = studentDAO.findById(studentId);

		//mudar o primeiro nome
		System.out.println("Atualizando aluno");
		myStudent.setFirstname("Paulo");

		//fazer o update
		studentDAO.update(myStudent);

		//mostrar o update
		System.out.println(myStudent);

	}

	private void queryForStudentsByLastName(StudentDAO studentDAO) {
		//lista de alunos
		List<Student> theStudents = studentDAO.findByLastName("Doe");

		//display da lista

		for (Student tempStudent : theStudents){
			System.out.println(tempStudent);
		}
	}

	private void queryForStudents(StudentDAO studentDAO) {
		//lista de alunos
		List<Student> theStudents = studentDAO.findAll();

		//display da lista

		for (Student tempStudent : theStudents){
			System.out.println(tempStudent);
		}
	}

	private void readStudent(StudentDAO studentDAO) {

		//criar obj alunos
		System.out.println("Criando Aluno");
		Student tempStudent = new Student("Eduardo","Pereira","edupereira123@gmmail.com");

		//salvar alunos
		System.out.println("Salvando aluno");
		studentDAO.save(tempStudent);
		//mostrar id alunos
		int theId = tempStudent.getId();
		System.out.println("Aluno salvo, id: "+ theId);

		//buscar aluno pelo id
		System.out.println("Buscando Aluno com id: "+theId);
		Student myStudent = studentDAO.findById(theId);

		//mostrar aluno buscado

		System.out.println("Aluno encontrado: "+ myStudent);
	}

	private void createStudents(StudentDAO studentDAO) {

		//criar o obj do aluno
		System.out.println("Criando Aluno");
		Student tempStudent1 = new Student("Eduardo","Pereira","edupereira123@gmmail.com");
		Student tempStudent2 = new Student("Jhon","Doe","Jhondoe@gmmail.com");
		Student tempStudent3 = new Student("Pedro","Henrrique","ph132@gmmail.com");

		System.out.println("Salvando alunos");
		studentDAO.save(tempStudent1);
		studentDAO.save(tempStudent2);
		studentDAO.save(tempStudent3);
	}

	private void createStudent(StudentDAO studentDAO) {

		//criar o obj do aluno
		System.out.println("Criando Aluno");
		Student tempStudent = new Student("Joâo","Pereira","joaopereira123@gmmail.com");


		//salvar o obj do aluno
		System.out.println("Salvando aluno");
		studentDAO.save(tempStudent);

		//display o id do aluno salvo
		System.out.println("Id do aluno salvo: "+ tempStudent.getId());

	}
}
