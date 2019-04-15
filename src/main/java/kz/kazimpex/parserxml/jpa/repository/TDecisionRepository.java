package kz.kazimpex.parserxml.jpa.repository;

import kz.kazimpex.parserxml.jpa.domain.TDecision;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

/**
 * Created by IntelliJ IDEA.
 * User: a.kusein
 * Date: 10.04.2019
 * Time: 18:04
 * To change this template use File | Settings | File and Code Templates.
 */
public interface TDecisionRepository extends JpaRepository<TDecision, Long> {

    @Query(value = "select nextval('test_docs.t_decision_id_seq')", nativeQuery = true)
    Long getNextSeriesId();
}