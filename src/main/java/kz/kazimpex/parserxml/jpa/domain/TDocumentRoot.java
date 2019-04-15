package kz.kazimpex.parserxml.jpa.domain;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "t_document_root", schema = "test_docs")
@Data
public class TDocumentRoot implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)
    private Integer id;
    private String xmlId;
    private String redactionId;
    private String doctypeId;
    private String title;

    public TDocumentRoot() {
    }
}
