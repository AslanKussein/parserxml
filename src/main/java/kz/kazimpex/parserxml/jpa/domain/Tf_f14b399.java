package kz.kazimpex.parserxml.jpa.domain;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by IntelliJ IDEA.
 * User: a.kusein
 * Date: 15.04.2019
 * Time: 16:06
 * To change this template use File | Settings | File and Code Templates.
 */
@Entity
@Data
@Table(name = "Tf_f14b399", schema = "test_docs")
public class Tf_f14b399 implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)
    private Long id;
    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name = "t_document_body_id", referencedColumnName = "id", foreignKey = @ForeignKey(name = "FK$Tf_f14b399"), nullable = false)
    private TDocumentBody tDocumentBody;
    private String structureId;
    private String structureValue;

    public Tf_f14b399() {
    }
}