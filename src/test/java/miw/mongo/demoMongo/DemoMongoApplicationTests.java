package miw.mongo.demoMongo;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import miw.mongo.demoMongo.dto.TaskDTO;
import miw.mongo.demoMongo.persistence.documents.Task;
import miw.mongo.demoMongo.persistence.repositories.TaskRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DemoMongoApplicationTests {

	@Autowired
	public TaskRepository repo; 
	
	@Test
	public void contextLoads() {
	}

	@Test
	public void userRepositoryFindTest() {
		List<Task> tareas = repo.findAll();
		assertEquals(tareas.size(), 0);
	}
	
	@Test
	public void userRepositoryFindDTOTest() {
			Task tarea = new Task();
			tarea.setName("Pepe");
			tarea.setState("aceptado");
			repo.save(tarea);
		
		List<TaskDTO> listaDTOS = repo.findIdAndNameByName("Pepe");
		
		for(TaskDTO t: listaDTOS) {
			System.out.println(t);
		}
		
	}
}
