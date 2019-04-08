package kz.kazimpex.parserxml.domain.repositories;

import kz.kazimpex.parserxml.domain.Documentolog;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface DocumentologRepositories extends MongoRepository<Documentolog, Long> {
    Documentolog findFirstByName(String name);
}
