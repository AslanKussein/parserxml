package kz.kazimpex.parserxml.jpa.domain;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.File;
import java.io.Serializable;
import java.sql.Timestamp;

@Entity
@Table(name = "t_document_root", schema = "docs")
@Data
public class TDocumentRoot implements Serializable {

    @Id
    private String id;
    private String redactionId;
    private String doctypeId;
    private String title;
    private String creator;
    private String editor;
    private Timestamp createdAt;
    private Timestamp editedAt;
    private String pointTitle;
    private String doctype;
    private String regNumber;
    private Timestamp regTstamp;
    private String respondent;
    private Timestamp ctrStartAt;
    private Timestamp ctrStopAt;
    private Integer reiterative_id;
    private String reiterativeDocument;
    private Boolean receivedFromWs;
    private Integer numberOfPages;
    private String aktenplanIndex;
    private File template;
    private Integer f_512be20;
    private Integer f_a18b360;
    private Integer f_1164f84;
    private Integer f_517bae1;
    private Integer fVersionNumber;
    private Integer f_1112b84;
    private Integer f_6124226;
    private Integer f_c144ea1;
    private Integer f_211a19f;
    private Integer f_01b986a;
    private String f_d1821f1;
    private String f_619d7c8;
    private String f_d1ef64d;
    private String f_91a30ab;
    private String f_d162acb;
    private String f_416f97f;
    private String f_7162598;
    private String f_a1a0501;
    private String f_013e5ba;
    private String f_d1f5912;
    private Integer f_e16a968;
    private String f_d1086f4;
    private String f_11f9b70;
    private String f_21bee31;
    private Integer f_6140f63;
    private String f_41afa8c;
    private String f_1144b6b;
    private String f_719abfc;
    private String f_7190c2a;
    private String f_01ef95d;
    private String f_5128b2e;
    private String f_71f6e48;
    private String f_61f64e5;
    private String f_d1aab66;
    private String f_a19607f;
    private String f_d1e4597;
    private Timestamp f_0120489;
    private Timestamp f_813edeb;
    private String f_813bcf8;
    private String f_21dee2e;
    private String f_410ee30;
    private String f_c1ff57f;
    private Integer f_91f4590;
    private String f_512b542;
    private String f_71db8bd;
    private String f_e14dda1;

    public TDocumentRoot() {
    }
}
