package kz.kazimpex.parserxml.jpa.domain;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;

/**
 * Created by IntelliJ IDEA.
 * User: a.kusein
 * Date: 15.04.2019
 * Time: 19:09
 * To change this template use File | Settings | File and Code Templates.
 */
@Entity
@Data
@Table(name = "T_F_F130ae4", schema = "test_docs")
public class TFF130ae4 implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)
    private Long id;
    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name = "t_document_body_id", referencedColumnName = "id", foreignKey = @ForeignKey(name = "FK$T_F_F130ae4"), nullable = false)
    private TDocumentBody tDocumentBody;
    private String structureId;
    private String structureValue;

    public TFF130ae4() {
    }
}