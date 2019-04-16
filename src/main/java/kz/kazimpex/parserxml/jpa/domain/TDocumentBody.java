package kz.kazimpex.parserxml.jpa.domain;

import lombok.Data;
import lombok.EqualsAndHashCode;
import org.hibernate.annotations.Cascade;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import java.io.File;
import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.Date;

/**
 * Created by IntelliJ IDEA.
 * User: a.kusein
 * Date: 10.04.2019
 * Time: 9:35
 * To change this template use File | Settings | File and Code Templates.
 */
@Entity
@Data
@Table(name = "t_document_body", schema = "test_docs")
public class TDocumentBody implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    private Long id;
    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "root_id", referencedColumnName = "id", foreignKey = @ForeignKey(name = "FK$TDOCUMENTROOT"))
    private TDocumentRoot root;
    private String creator;
    private String editor;
    private Timestamp createdAt;
    private Timestamp editedAt;
    private String pointTitle;
    private String doctype;
    private String subdivision;
    private String regNumber;
    private Timestamp regTstamp;
    private String respondent;
    private Timestamp ctrStartAt;
    private Timestamp ctrStopAt;
    private Integer reiterativeId;
    private String reiterativeDocument;
    private Boolean receivedFromWs;
    private Integer numberOfPages;
    private String aktenplanIndex;
    private String template;
    private Integer f_512be20;
    private Integer f_a18b360;
    private String f_1164f84;
    private String f_517bae1;
    private Integer fVersionNumber;
    private String f_1112b84;
    private String f_6124226;
    private String f_c144ea1;
    private String f_211a19f;
    private String f_01b986a;
    private String f_d1821f1;
    private String f_619d7c8;
    private String f_d1ef64d;
    private String f_91a30ab;
    private String f_d162acb;
    private Date f_416f97f;
    private Date f_7162598;
    private String f_a1a0501;
    private String f_013e5ba;
    private String f_d1f5912;
    private Integer fE16a968;
    private String f_d1086f4;
    private String f_11f9b70;
    private String f_21bee31;
    private Integer f_6140f63;
    private String f_41afa8c;
    private String f_1144b6b;
    private String f_719abfc;
    @Column(name = "f_7190c2a", columnDefinition = "TEXT")
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
    //    @ManyToOne
//    @JoinColumn(name = "f_f1d9e2d", referencedColumnName = "id", foreignKey = @ForeignKey(name = "FK$DDocLang"))
    private String f_f1d9e2d;
    private Integer f_e132be8;
    private Integer f_119a889;
    private Integer f_31efe17;
    @Column(name = "f_61f7ce1", columnDefinition = "TEXT")
    private String f_61f7ce1;
    @Column(name = "f_21cf180", columnDefinition = "TEXT")
    private String f_21cf180;
    private String f_f1a5daf;
    private String f_118f49d;
    private String f_61741ce;
    private String f_61de7d0;
    private String f_01dc74d;
    private String f_317d7ac;
    private String f_d13446c;
    private String f_1112b5c;
    private String f_a1bb234;
    private String f_51601f8;
    private String f_b1edc6b;
    private String f_31d5f82;
    private String f_f14b399;
    private String f_41be90d;
    private String f_910ca87;
    private String f_e1d4a4c;
    private String f_812595a;
    private Timestamp f_218fd6e;
    private String f_b114825;
    private String f_8103a47;
    private Timestamp f_e11b6ad;
    private String f_81cee9e;
    private Date f_b1cbb3e;
    private Date f_0152899;
    private Date f_71e61e1;
    private Boolean f_0124ea9;
    private Date f_611fa3a;
    private String f_4181cf3;
    private Timestamp f_01c3ecb;
    private String f_a16cf55;
    private String f_a1f3ad4;
    private String f_c1e51c5;
    private String f_81f195a;
    private String f_f1191df;
    private Date f_c1047fd;
    private String f_0126248;
    @Column(name = "f_f10aca9", columnDefinition = "TEXT")
    private String f_f10aca9;
    private String f_a1b4fda;
    private String f_412b102;
    private String f_b17cd29;
    private String f_81baaa6;
    private Date f_d1a323a;
    private String f_116a960;
    @Column(name = "f_018fa0d", columnDefinition = "TEXT")
    private String f_018fa0d;
    @Column(name = "f_61a410b", columnDefinition = "TEXT")
    private String f_61a410b;
    private String f_9148215;
    private Integer f_f13c5ea;
    private Timestamp f_118945d;
    private String f_11a93cc;
    private String f_61d605e;
    private String f_f1945d5;
    private String f_b18cb95;
    private String f_31f7b68;
    private String f_811cc63;
    @Column(name = "f_71a5738", columnDefinition = "TEXT")
    private String f_71a5738;
    private Boolean f_61080a8;
    private Boolean f_41b26fe;
    private String f_f1faec4;
    private Boolean f_a1a2ecc;
    private String f_a163fd1;
    private String f_11a8684;
    private String f_61747f0;
    private String f_41fba3c;
    private String f_b11ab59;
    private Integer f_61e013a;
    private Timestamp f_c16ebd5;
    private Timestamp f_7176eb0;
    private Timestamp f_41b6044;
    private Timestamp f_e1ef1f4;
    private String f_b15a6e7;
    private String f_e1bd204;
    private String f_51690d3;
    private Timestamp f_415a350;
    @Column(name = "f_3147dd7", columnDefinition = "TEXT")
    private String f_3147dd7;
    @Column(name = "f_916d9c2", columnDefinition = "TEXT")
    private String f_916d9c2;
    private String f_612bf16;
    private String f_810be61;
    private String f_e1744a5;
    private String f_21da282;
    private String f_a132bf2;
    private String f_2132dec;
    private String f_41407ad;
    private String f_b1e1137;
    private Timestamp f_612d180;
    private String f_b15a02e;
    private String f_61f0b14;
    private String f_8172a0d;
    private String f_e1f58c2;
    private String f_91abd5a;
    private String f_a188010;
    private String fTitle;
    private Integer f_c174820;
    private Integer f_914ea94;
    private String f_51c8224;
    private String f_01a1414;
    private Date f_2149494;
    @Column(name = "f_d13b321", columnDefinition = "TEXT")
    private String f_d13b321;
    private String f_717b3d2;
    private String f_511168a;
    private Boolean fNewversion;
    private String f_c11c227;
    private Boolean f_41b04ba;
    private String f_615ab98;
    private String f_61e8b2e;
    private String f_a1d098c;
    private String f_11292c6;
    private Date f_71567dc;
    private String f_516c7c3;
    private String f_51f8599;
    private String f_b1d7068;
    private File f_710f07e;
    private String f_61eb5c6;
    private String f_d175b87;
    private String f_c1699ba;
    private String f_b150e8e;
    private String fCommentnewversion;
    private String fTableSogl;
    private String fVersion;
    private String fVersionKz;
    private String fShortTitle;
    private String f_a1ebb32;
    private String f_71c7b54;
    private String f_f1b6492;
    private String f_416739a;
    private Date f_b10f779;
    private String f_d16785d;
    private String f_81fbc4a;
    @Column(name = "f_41a4d30", columnDefinition = "TEXT")
    private String f_41a4d30;
    @Column(name = "f_b1332ad", columnDefinition = "TEXT")
    private String f_b1332ad;
    private String f_51926e6;
    private String f_21e53f0;
    private String f_110039e;
    private Integer numberOfApplications;
    private String f_c1e008c;
    private Integer f_c1b48c8;
    private Integer f_01d0b5a;
    private String f_b1bcb9a;
    private String f_21795f0;
    private String f_c108795;
    private String f_0193cdc;
    private Boolean f_e19f9dc;
    private Boolean f_b13ee0f;
    private Boolean f_41d8952;
    private Boolean f_f11b350;
    private String f_e113887;
    private String f_c1df363;
    private String f_21e9ee1;
    private String f_f1a132f;
    private String f_21501c0;
    private String f_519e6cd;
    private String f_51f8283;
    private String f_8148b02;
    private String f_91ca174;
    private String f_419bb00;
    private String f_b1662f0;
    private String f_114ed9f;
    private Boolean f_71bd66d;
    private Boolean f_edited;
    private String f_41ba5d6;
    private Boolean f_219cf37;
    private Integer f_c174c0a;
    private Integer f_f14f982;
    private Integer f_e1c927f;
    private String f_f1866a6;
    private Date f_71d186f;
    private Date f_518d761;
    private String f_4142142;
    private String f_b1c28d7;
    private String f_617a5e4;
    private String f_b1cea85;
    private String f_b1db2e0;
    private String f_d10dea5;
    private String f_a1e2699;
    private String f_c1f320f;
    private String f_c19417a;
    private String f_817a9c2;
    private String f_c19c7b8;
    private String f_213ac91;
    private String f_01b1ce0;
    private String f_613df48;
    private String f_e13bbcd;
    private String f_01b4962;
    private String f_e13f7a4;
    private Date f_f14a0f1;
    private String f_51a7efb;
    private String f_216933e;
    @Column(name = "f_41526a6", columnDefinition = "TEXT")
    private String f_41526a6;
    private Timestamp f_2115f36;
    private String f_a1bdd0f;
    private String f_outgoing_id;
    @Column(name = "f_8163e7e", columnDefinition = "TEXT")
    private String f_8163e7e;
    @Column(name = "f_e102bf4", columnDefinition = "TEXT")
    private String f_e102bf4;
    private Float f_21dd76a;
    private String f_617dc28;
    private String f_01772b5;
    private String f_d19190f;
    private String f_01c4b1f;
    private String f_b1ed709;
    private String f_81b20e3;
    private String f_0158a26;
    private String f_e1343ff;
    private String f_61a302f;
    private String f_91f2f9f;
    private String f_f192968;
    private String f_b1689ca;
    private Integer f_b13a798;
    private String f_21518de;
    private String f_b17d60e;
    private String f_e15602a;
    private String f_a1aa2ab;
    private String f_c1f1ba4;
    private String f_4116307;
    private String f_b1b86c0;
    private String f_d1cfac1;
    private String f_91727ca;
    private String f_f1eef5a;
    private String f_818fdf9;
    private String f_a1ba734;
    private String f_21787de;
    @Column(name = "f_c193cb2", columnDefinition = "TEXT")
    private String f_c193cb2;
    private String f_31c237b;
    private String f_11c36e3;
    private String f_a16a492;
    private String f_e1f3d17;
    private String f_914b6fc;
    private String f_61cbe68;
    private String f_415a546;
    private String f_a16a54b;
    private String f_c19af22;
    private String f_014fb7f;
    private String f_1168c6f;
    private String f_f1f39e5;
    private String f_110a1e1;
    private Boolean f_b1eb499;
    private Boolean f_31b1230;
    private Boolean f_711de51;
    private String f_e19ae19;
    private String f_01a0ff3;
    private String f_3178434;
    private String f_7157da7;
    private String f_b1dae10;
    private String f_91877ec;
    private String f_4160d2d;
    private String f_015ac8a;
    private String f_e181b8f;
    private String f_5106d93;
    private String f_113c951;
    private String f_216c41c;
    private String f_111de62;
    private String f_01e8867;
    private String f_515f19c;
    private String f_510f8c4;
    private String f_d131ae5;
    private Timestamp f_11fb094;

    public TDocumentBody() {
    }
}