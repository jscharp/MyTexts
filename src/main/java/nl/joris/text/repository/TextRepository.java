package nl.joris.text.repository;

import nl.joris.text.Text;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface TextRepository extends CrudRepository<Text, Long> {

    List<Text> findByContentContaining(String searchQuery);
}
