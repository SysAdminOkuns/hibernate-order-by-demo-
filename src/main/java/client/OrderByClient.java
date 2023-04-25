package client;

import java.util.Set;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import entity.Guide;
import entity.Student;

public class OrderByClient {
	public static void main(String[] args) {

		EntityManagerFactory emf = Persistence.createEntityManagerFactory(
				"hello-world");

		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();

		Guide guide = em.find(Guide.class, 1L);
		Set<Student> students = guide.getStudents();
		System.out.println(students);
		for (Student student : students) {
			System.out.println(student);
		}

		em.getTransaction().commit();
		em.close();
		emf.close();
	}
}