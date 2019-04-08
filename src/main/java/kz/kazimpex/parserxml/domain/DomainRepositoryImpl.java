package kz.kazimpex.parserxml.domain;

import com.mongodb.WriteResult;
import com.mongodb.client.result.UpdateResult;
import kz.kazimpex.parserxml.domain.repositories.DocumentologRepositories;
import kz.kazimpex.parserxml.domain.repositories.DocumentologRepositoryCustom;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.index.IndexOperations;
import org.springframework.data.mongodb.core.index.IndexResolver;
import org.springframework.data.mongodb.core.index.MongoPersistentEntityIndexResolver;
import org.springframework.data.mongodb.core.mapping.MongoMappingContext;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;

public class DomainRepositoryImpl implements DocumentologRepositoryCustom {

    @Autowired
    MongoTemplate mongoTemplate;
    @Autowired
    MongoMappingContext mongoMappingContext;

    @Override
    public int updateDomain(String name) {
        Query query = new Query(Criteria.where("name").is(name));
        Update update = new Update();
        update.set("name", name);

        UpdateResult result = mongoTemplate.updateFirst(query, update, Documentolog.class);

        return (int) result.getMatchedCount();
    }

    @EventListener(ApplicationReadyEvent.class)
	 public void initIndicesAfterStartup() {

	     IndexOperations indexOps = mongoTemplate.indexOps(Documentolog.class);

	     IndexResolver resolver = new MongoPersistentEntityIndexResolver(mongoMappingContext);
	     resolver.resolveIndexFor(Documentolog.class).forEach(indexOps::ensureIndex);
	}
}
