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
 * Time: 19:17
 * To change this template use File | Settings | File and Code Templates.
 */
@Entity
@Data
@Table(name = "t_e_sign", schema = "test_docs")
public class TESign implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)
    private Long id;
    private Long decisionId;
    private String dn;
    private String type;
    private String edsType;
    private String ca;
    @Column(name = "sign", columnDefinition="TEXT")
    private String sign;
    private String status;

    public TESign() {
    }
}