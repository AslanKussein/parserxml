package kz.kazimpex.parserxml.jpa.domain;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;

/**
 * Created by IntelliJ IDEA.
 * User: a.kusein
 * Date: 16.04.2019
 * Time: 9:39
 * To change this template use File | Settings | File and Code Templates.
 */
@Entity
@Data
@Table(name = "T_F_31dc56b", schema = "test_docs")
public class TF31dc56b implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)
    private Long id;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "t_document_body_id", referencedColumnName = "id", foreignKey = @ForeignKey(name = "FK$TF31dc56b"), nullable = false)
    private TDocumentBody tDocumentBody;
    private String structureId;
    @Column(name = "structure_Value", columnDefinition = "TEXT")
    private String structureValue;

    public TF31dc56b() {
    }
}