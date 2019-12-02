package rc.springbootmongodb.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import rc.springbootmongodb.model.Hotel;

import java.util.Optional;

@Repository
public interface HotelRepository extends MongoRepository<Hotel, String>{
    Optional<Hotel> findById(String id);
}
