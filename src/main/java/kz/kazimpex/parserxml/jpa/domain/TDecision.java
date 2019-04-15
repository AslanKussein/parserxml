package kz.kazimpex.parserxml.jpa.domain;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.Date;

/**
 * Created by IntelliJ IDEA.
 * User: a.kusein
 * Date: 10.04.2019
 * Time: 17:23
 * To change this template use File | Settings | File and Code Templates.
 */
@Entity
@Data
@Table(name = "t_decision", schema = "test_docs")
public class TDecision implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id   @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)
    private Long id;
    @ManyToOne(cascade=CascadeType.ALL)
    @JoinColumn(name = "root_id", referencedColumnName = "id", foreignKey = @ForeignKey(name = "FK$TDOCUMENTROOTDEC"))
    private TDocumentRoot root;
    private String wsTitle;
    private String xmlId;
    private String authorId;
    private String author;
    private Date tstamp;
    @Column(name = "text", columnDefinition = "TEXT")
    private String text;
    @Column(name = "text_Kz", columnDefinition = "TEXT")
    private String textKz;
    @Column(name = "comment", columnDefinition = "TEXT")
    private String comment;
    private String files;
    private String customFields;
    @Column(name = "sign", columnDefinition="TEXT")
    private String sign;
    private String edsFormat;

    public TDecision() {
    }
}