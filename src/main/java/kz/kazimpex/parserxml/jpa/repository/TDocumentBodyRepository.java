package kz.kazimpex.parserxml.jpa.repository;

import kz.kazimpex.parserxml.jpa.domain.TDocumentBody;
import kz.kazimpex.parserxml.jpa.domain.TDocumentRoot;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface TDocumentBodyRepository extends JpaRepository<TDocumentBody, String> {

    @Query(value = "select nextval('test_docs.t_document_body_id_seq')", nativeQuery = true)
    Long getNextSeriesId();
}
