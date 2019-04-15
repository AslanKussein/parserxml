package kz.kazimpex.parserxml.jpa.domain;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;

/**
 * Created by IntelliJ IDEA.
 * User: a.kusein
 * Date: 10.04.2019
 * Time: 17:54
 * To change this template use File | Settings | File and Code Templates.
 */
@Entity
@Data
@Table(name = "t_sign_fields", schema = "test_docs")
public class TSignFields implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)
    private Long id;
//    @ManyToOne(optional = false)
//    @JoinColumn(name = "decision_id", referencedColumnName = "id", foreignKey = @ForeignKey(name = "FK$TDecision"))
    private Long decisionId;
    private Integer itemId;
    private String value;

    public TSignFields() {
    }
}