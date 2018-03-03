package miw.mongo.demoMongo.persistence.repositories;


import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import miw.mongo.demoMongo.dto.TaskDTO;
import miw.mongo.demoMongo.persistence.documents.Task;

public interface TaskRepository extends MongoRepository<Task, String>{

	@Query(value = "{'name':?0}", fields = "{'_id':0,'name':1}")
	List<TaskDTO> findIdAndNameByName(String name);
}
