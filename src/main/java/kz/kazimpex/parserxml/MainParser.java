package kz.kazimpex.parserxml;

import kz.kazimpex.parserxml.jpa.domain.*;
import kz.kazimpex.parserxml.jpa.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Date;

import static com.google.common.base.Strings.isNullOrEmpty;

@Service
public class MainParser {

    @Autowired
    TDocumentRootRepository tDocumentRootRepository;
    @Autowired
    TDocumentBodyRepository tDocumentBodyRepository;
    @Autowired
    TDecisionRepository tDecisionRepository;
    @Autowired
    TSignFieldsRepository tSignFieldsRepository;
    @Autowired
    TESignRepository teSignRepository;
    @Autowired
    TStructureRepository tStructureRepository;
    @Autowired
    TF31f8f7cRepository tf31f8f7cRepository;
    @Autowired
    TF519145bRepository tf519145bRepository;
    @Autowired
    TFD1c5f7dRepository tfd1c5f7dRepository;
    @Autowired
    TF2190030Repository tf2190030Repository;
    @Autowired
    TFD1193e2Repository tfd1193e2Repository;
    @Autowired
    TF215b2e9Repository tf215b2e9Repository;
    @Autowired
    TF11d6328Repository tf11d6328Repository;
    @Autowired
    TFD180879Repository tfd180879Repository;

    private static Date asDate(LocalDate localDate) {
        return Date.from(localDate.atStartOfDay().atZone(ZoneId.systemDefault()).toInstant());
    }


    private Date stringToDate(String str) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate dateTime = LocalDate.parse(str, formatter);
        return asDate(dateTime);
    }

    private static Date stringToDate2(String str) {
        String pattern = str.length() == 19 ? "yyyy-MM-dd HH:mm:ss" : "yyyy-MM-dd HH:mm";
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(pattern);
        LocalDate dateTime = LocalDate.parse(str, formatter);
        return asDate(dateTime);
    }

    private static String getValueByName(Element root, String value) throws Exception {
        if (!isNullOrEmpty(value)) {
            if (root.getAttributes().getNamedItem(value) != null) {
                return root.getAttributes().getNamedItem(value).getNodeValue();
            }
            return null;
        }
        throw new Exception("Пустой value");
    }

    private static String getValueByNameAndIterator(NodeList list, int i, String tagName) throws Exception {
        if (!isNullOrEmpty(tagName)) {
            if (list.item(i).getAttributes().getNamedItem(tagName) != null) {
                return list.item(i).getAttributes().getNamedItem(tagName).getNodeValue();
            }
            return null;
        }
        throw new Exception("Пустой value");
    }

    private Integer stringToInteger(String val) {
        if (!isNullOrEmpty(val)) {
            return Integer.parseInt(val);
        }
        return null;
    }

    /***
     * @desc сохраняем root тег;
     * @param root;
     */
    private TDocumentRoot insertRoot(Element root, NodeList list) throws Exception {
        TDocumentRoot tDocumentRoot = new TDocumentRoot();
        tDocumentRoot.setXmlId(getValueByName(root, "id"));
        tDocumentRoot.setDoctypeId(getValueByName(root, "doctype_id"));
        tDocumentRoot.setRedactionId(getValueByName(root, "redaction_id"));

        NodeList subList = list.item(0).getChildNodes();

        if (subList != null && subList.item(0) != null) {
            if (isNullOrEmpty(subList.item(0).getNodeValue())) throw new Exception("Парсер сломался же!!");
            tDocumentRoot.setTitle(subList.item(0).getNodeValue());
        }
        tDocumentRootRepository.saveAndFlush(tDocumentRoot);

        return tDocumentRoot;
    }

    /**
     * @desc insert itemslist
     */
    private void fullBodyItemlist(Element element, TDocumentBody body) throws Exception {

        if (element.getAttribute("name").equalsIgnoreCase("creator")) {
            if (element.getFirstChild() != null)
                body.setCreator(element.getFirstChild().getAttributes().getNamedItem("id").getNodeValue());
        } else if (element.getAttribute("name").equalsIgnoreCase("editor")) {
            if (element.getFirstChild() != null)
                body.setEditor(element.getFirstChild().getAttributes().getNamedItem("id").getNodeValue());
        } else if (element.getAttribute("name").equalsIgnoreCase("subdivision")) {
            if (element.getFirstChild() != null)
                body.setSubdivision(element.getFirstChild().getAttributes().getNamedItem("id").getNodeValue());
        } else if (element.getAttribute("name").equalsIgnoreCase("respondent")) {
            if (element.getFirstChild() != null)
                body.setRespondent(element.getFirstChild().getAttributes().getNamedItem("id").getNodeValue());
        } else if (element.getAttribute("name").equalsIgnoreCase("received_from_ws")) {
            if (element.getFirstChild() != null)
                body.setReceivedFromWs(Boolean.valueOf(element.getFirstChild().getAttributes().getNamedItem("id").getNodeValue()));
        } else if (element.getAttribute("name").equalsIgnoreCase("aktenplan_index")) {
            if (element.getFirstChild() != null)
                body.setAktenplanIndex(element.getFirstChild().getAttributes().getNamedItem("id").getNodeValue());
        } else if (element.getAttribute("name").equalsIgnoreCase("template")) {
            if (element.getFirstChild() != null) {
                //TODO
//                throw new Exception("template");
                body.setTemplate(element.getFirstChild().getAttributes().getNamedItem("id").getNodeValue());
            }
//
        } else if (element.getAttribute("name").equalsIgnoreCase("f_d1ef64d")) {
            if (element.getFirstChild() != null)
                body.setF_d1ef64d(element.getFirstChild().getAttributes().getNamedItem("id").getNodeValue());
        } else if (element.getAttribute("name").equalsIgnoreCase("f_91a30ab")) {
            if (element.getFirstChild() != null)
                body.setF_91a30ab(element.getFirstChild().getAttributes().getNamedItem("id").getNodeValue());
        } else if (element.getAttribute("name").equalsIgnoreCase("f_a1a0501")) {
            if (element.getFirstChild() != null)
                body.setF_a1a0501(element.getFirstChild().getAttributes().getNamedItem("id").getNodeValue());
        } else if (element.getAttribute("name").equalsIgnoreCase("f_013e5ba")) {
            if (element.getFirstChild() != null)
                body.setF_013e5ba(element.getFirstChild().getAttributes().getNamedItem("id").getNodeValue());
        } else if (element.getAttribute("name").equalsIgnoreCase("f_d1086f4")) {
            if (element.getFirstChild() != null)
                body.setF_d1086f4(element.getFirstChild().getAttributes().getNamedItem("id").getNodeValue());
        } else if (element.getAttribute("name").equalsIgnoreCase("f_11f9b70")) {
            if (element.getFirstChild() != null)
                body.setF_11f9b70(element.getFirstChild().getAttributes().getNamedItem("id").getNodeValue());
        } else if (element.getAttribute("name").equalsIgnoreCase("f_21bee31")) {
            if (element.getFirstChild() != null)
                body.setF_21bee31(element.getFirstChild().getAttributes().getNamedItem("id").getNodeValue());
        } else if (element.getAttribute("name").equalsIgnoreCase("f_6140f63")) {
            if (element.getFirstChild() != null)
                body.setF_6140f63(stringToInteger(element.getFirstChild().getAttributes().getNamedItem("id").getNodeValue()));
        } else if (element.getAttribute("name").equalsIgnoreCase("f_41afa8c")) {
            if (element.getFirstChild() != null)
                body.setF_41afa8c(element.getFirstChild().getAttributes().getNamedItem("id").getNodeValue());
        } else if (element.getAttribute("name").equalsIgnoreCase("f_1144b6b")) {
            if (element.getFirstChild() != null)
                body.setF_1144b6b(element.getFirstChild().getAttributes().getNamedItem("id").getNodeValue());
        } else if (element.getAttribute("name").equalsIgnoreCase("f_f1d9e2d")) {
            if (element.getFirstChild() != null) {
                body.setF_f1a5daf(element.getFirstChild().getAttributes().getNamedItem("id").getNodeValue());
//                body.setDDocLang(new DDocLang(new BigDecimal(element.getFirstChild().getAttributes().getNamedItem("id").getNodeValue())));
            }
        } else if (element.getAttribute("name").equalsIgnoreCase("f_0190180")) {
            if (element.getFirstChild() != null) {
                //TODO document
//                    throw new Exception("f_0190180");
                body.setF_0190180(element.getFirstChild().getAttributes().getNamedItem("id").getNodeValue());
            }
        } else if (element.getAttribute("name").equalsIgnoreCase("f_01692fa")) {
            if (element.getFirstChild() != null) {
                //TODO document
                body.setF_01692fa(element.getFirstChild().getAttributes().getNamedItem("id").getNodeValue());
//                    throw new Exception("f_01692fa");
            }
        } else if (element.getAttribute("name").equalsIgnoreCase("f_f1a5daf")) {
            if (element.getFirstChild() != null)
                body.setF_f1a5daf(element.getFirstChild().getAttributes().getNamedItem("id").getNodeValue());
        } else if (element.getAttribute("name").equalsIgnoreCase("f_118f49d")) {
            if (element.getFirstChild() != null)
                body.setF_118f49d(element.getFirstChild().getAttributes().getNamedItem("id").getNodeValue());
        } else if (element.getAttribute("name").equalsIgnoreCase("f_61741ce")) {
            if (element.getFirstChild() != null)
                body.setF_61741ce(element.getFirstChild().getAttributes().getNamedItem("id").getNodeValue());
        } else if (element.getAttribute("name").equalsIgnoreCase("f_61de7d0")) {
            if (element.getFirstChild() != null)
                body.setF_61de7d0(element.getFirstChild().getAttributes().getNamedItem("id").getNodeValue());
        } else if (element.getAttribute("name").equalsIgnoreCase("f_01dc74d")) {
            if (element.getFirstChild() != null)
                body.setF_01dc74d(element.getFirstChild().getAttributes().getNamedItem("id").getNodeValue());
        } else if (element.getAttribute("name").equalsIgnoreCase("f_317d7ac")) {
            if (element.getFirstChild() != null)
                body.setF_317d7ac(element.getFirstChild().getAttributes().getNamedItem("id").getNodeValue());
        } else if (element.getAttribute("name").equalsIgnoreCase("f_d13446c")) {
            if (element.getFirstChild() != null)
                body.setF_d13446c(element.getFirstChild().getAttributes().getNamedItem("id").getNodeValue());
        } else if (element.getAttribute("name").equalsIgnoreCase("f_1112b5c")) {
            if (element.getFirstChild() != null)
                body.setF_1112b5c(element.getFirstChild().getAttributes().getNamedItem("id").getNodeValue());
        } else if (element.getAttribute("name").equalsIgnoreCase("f_31d5f82")) {
            if (element.getFirstChild() != null)
                body.setF_31d5f82(element.getFirstChild().getAttributes().getNamedItem("id").getNodeValue());
        } else if (element.getAttribute("name").equalsIgnoreCase("f_f14b399")) {
            if (element.getFirstChild() != null)
                body.setF_f14b399(element.getFirstChild().getAttributes().getNamedItem("id").getNodeValue());
        } else if (element.getAttribute("name").equalsIgnoreCase("f_910ca87")) {
            if (element.getFirstChild() != null)
                body.setF_910ca87(element.getFirstChild().getAttributes().getNamedItem("id").getNodeValue());
        } else if (element.getAttribute("name").equalsIgnoreCase("f_e1d4a4c")) {
            if (element.getFirstChild() != null)
                body.setF_e1d4a4c(element.getFirstChild().getAttributes().getNamedItem("id").getNodeValue());
        } else if (element.getAttribute("name").equalsIgnoreCase("f_812595a")) {
            if (element.getFirstChild() != null)
                body.setF_812595a(element.getFirstChild().getAttributes().getNamedItem("id").getNodeValue());
        } else if (element.getAttribute("name").equalsIgnoreCase("f_b114825")) {
            if (element.getFirstChild() != null)
                body.setF_b114825(element.getFirstChild().getAttributes().getNamedItem("id").getNodeValue());
        } else if (element.getAttribute("name").equalsIgnoreCase("f_8103a47")) {
            if (element.getFirstChild() != null)
                body.setF_8103a47(element.getFirstChild().getAttributes().getNamedItem("id").getNodeValue());
        } else if (element.getAttribute("name").equalsIgnoreCase("f_0124ea9")) {
            if (element.getFirstChild() != null)
                body.setF_0124ea9(Boolean.valueOf(element.getFirstChild().getAttributes().getNamedItem("id").getNodeValue()));
        } else if (element.getAttribute("name").equalsIgnoreCase("f_a16cf55")) {
            if (element.getFirstChild() != null)
                body.setF_a16cf55(element.getFirstChild().getAttributes().getNamedItem("id").getNodeValue());
        } else if (element.getAttribute("name").equalsIgnoreCase("f_a1f3ad4")) {
            if (element.getFirstChild() != null)
                body.setF_a1f3ad4(element.getFirstChild().getAttributes().getNamedItem("id").getNodeValue());
        } else if (element.getAttribute("name").equalsIgnoreCase("f_c1bcdf1")) {
            if (element.getFirstChild() != null)
                body.setF_c1bcdf1(element.getFirstChild().getAttributes().getNamedItem("id").getNodeValue());
        } else if (element.getAttribute("name").equalsIgnoreCase("f_f1191df")) {
            if (element.getFirstChild() != null)
                body.setF_f1191df(element.getFirstChild().getAttributes().getNamedItem("id").getNodeValue());
        } else if (element.getAttribute("name").equalsIgnoreCase("f_0126248")) {
            if (element.getFirstChild() != null)
                body.setF_0126248(element.getFirstChild().getAttributes().getNamedItem("id").getNodeValue());
        } else if (element.getAttribute("name").equalsIgnoreCase("f_e158ee0")) {
            if (element.getFirstChild() != null)
                body.setF_e158ee0(element.getFirstChild().getAttributes().getNamedItem("id").getNodeValue());
        } else if (element.getAttribute("name").equalsIgnoreCase("f_c19311b")) {
            if (element.getFirstChild() != null)
                body.setF_c19311b(element.getFirstChild().getAttributes().getNamedItem("id").getNodeValue());
        } else if (element.getAttribute("name").equalsIgnoreCase("f_f1945d5")) {
            if (element.getFirstChild() != null)
                body.setF_f1945d5(element.getFirstChild().getAttributes().getNamedItem("id").getNodeValue());
        } else if (element.getAttribute("name").equalsIgnoreCase("f_b18cb95")) {
            if (element.getFirstChild() != null)
                body.setF_b18cb95(element.getFirstChild().getAttributes().getNamedItem("id").getNodeValue());
        } else if (element.getAttribute("name").equalsIgnoreCase("f_31f7b68")) {
            if (element.getFirstChild() != null)
                body.setF_31f7b68(element.getFirstChild().getAttributes().getNamedItem("id").getNodeValue());
        } else if (element.getAttribute("name").equalsIgnoreCase("f_811cc63")) {
            if (element.getFirstChild() != null)
                body.setF_811cc63(element.getFirstChild().getAttributes().getNamedItem("id").getNodeValue());
        } else if (element.getAttribute("name").equalsIgnoreCase("f_61080a8")) {
            if (element.getFirstChild() != null)
                body.setF_61080a8(Boolean.valueOf(element.getFirstChild().getAttributes().getNamedItem("id").getNodeValue()));
        } else if (element.getAttribute("name").equalsIgnoreCase("f_41b26fe")) {
            if (element.getFirstChild() != null)
                body.setF_41b26fe(Boolean.valueOf(element.getFirstChild().getAttributes().getNamedItem("id").getNodeValue()));
        } else if (element.getAttribute("name").equalsIgnoreCase("f_a1a2ecc")) {
            if (element.getFirstChild() != null)
                body.setF_a1a2ecc(Boolean.valueOf(element.getFirstChild().getAttributes().getNamedItem("id").getNodeValue()));
        } else if (element.getAttribute("name").equalsIgnoreCase("f_11a8684")) {
            if (element.getFirstChild() != null)
                body.setF_11a8684(element.getFirstChild().getAttributes().getNamedItem("id").getNodeValue());
        } else if (element.getAttribute("name").equalsIgnoreCase("f_6117ead")) {
            if (element.getFirstChild() != null)
                body.setF_6117ead(element.getFirstChild().getAttributes().getNamedItem("id").getNodeValue());
        } else if (element.getAttribute("name").equalsIgnoreCase("f_810be61")) {
            if (element.getFirstChild() != null)
                body.setF_810be61(element.getFirstChild().getAttributes().getNamedItem("id").getNodeValue());
        } else if (element.getAttribute("name").equalsIgnoreCase("f_e1744a5")) {
            if (element.getFirstChild() != null)
                body.setF_e1744a5(element.getFirstChild().getAttributes().getNamedItem("id").getNodeValue());
        } else if (element.getAttribute("name").equalsIgnoreCase("f_21da282")) {
            if (element.getFirstChild() != null)
                body.setF_21da282(element.getFirstChild().getAttributes().getNamedItem("id").getNodeValue());
        } else if (element.getAttribute("name").equalsIgnoreCase("f_a132bf2")) {
            if (element.getFirstChild() != null)
                body.setF_a132bf2(element.getFirstChild().getAttributes().getNamedItem("id").getNodeValue());
        } else if (element.getAttribute("name").equalsIgnoreCase("f_2132dec")) {
            if (element.getFirstChild() != null)
                body.setF_2132dec(element.getFirstChild().getAttributes().getNamedItem("id").getNodeValue());
        } else if (element.getAttribute("name").equalsIgnoreCase("f_41407ad")) {
            if (element.getFirstChild() != null)
                body.setF_41407ad(element.getFirstChild().getAttributes().getNamedItem("id").getNodeValue());
        } else if (element.getAttribute("name").equalsIgnoreCase("f_b1e1137")) {
            if (element.getFirstChild() != null)
                body.setF_b1e1137(element.getFirstChild().getAttributes().getNamedItem("id").getNodeValue());
        } else if (element.getAttribute("name").equalsIgnoreCase("f_b12e0d5")) {
            if (element.getFirstChild() != null)
                body.setF_b12e0d5(element.getFirstChild().getAttributes().getNamedItem("id").getNodeValue());
        } else if (element.getAttribute("name").equalsIgnoreCase("f_b15a02e")) {
            if (element.getFirstChild() != null)
                body.setF_b15a02e(element.getFirstChild().getAttributes().getNamedItem("id").getNodeValue());
        } else if (element.getAttribute("name").equalsIgnoreCase("f_61f0b14")) {
            if (element.getFirstChild() != null)
                body.setF_61f0b14(element.getFirstChild().getAttributes().getNamedItem("id").getNodeValue());
        } else if (element.getAttribute("name").equalsIgnoreCase("f_8172a0d")) {
            if (element.getFirstChild() != null)
                body.setF_8172a0d(element.getFirstChild().getAttributes().getNamedItem("id").getNodeValue());
        } else if (element.getAttribute("name").equalsIgnoreCase("f_f1d8b64")) {
            if (element.getFirstChild() != null)
                body.setF_f1d8b64(element.getFirstChild().getAttributes().getNamedItem("id").getNodeValue());
        } else if (element.getAttribute("name").equalsIgnoreCase("f_a188010")) {
            if (element.getFirstChild() != null)
                body.setF_a188010(element.getFirstChild().getAttributes().getNamedItem("id").getNodeValue());
        } else if (element.getAttribute("name").equalsIgnoreCase("f_51c8224")) {
            if (element.getFirstChild() != null)
                body.setF_51c8224(element.getFirstChild().getAttributes().getNamedItem("id").getNodeValue());
        } else if (element.getAttribute("name").equalsIgnoreCase("f_newversion")) {
            if (element.getFirstChild() != null)
                body.setFNewversion(Boolean.valueOf(element.getFirstChild().getAttributes().getNamedItem("id").getNodeValue()));
        } else if (element.getAttribute("name").equalsIgnoreCase("f_41b04ba")) {
            if (element.getFirstChild() != null)
                body.setF_41b04ba(Boolean.valueOf(element.getFirstChild().getAttributes().getNamedItem("id").getNodeValue()));
        } else if (element.getAttribute("name").equalsIgnoreCase("f_d1107e3")) {
            if (element.getFirstChild() != null)
                body.setF_d1107e3(element.getFirstChild().getAttributes().getNamedItem("id").getNodeValue());
        } else if (element.getAttribute("name").equalsIgnoreCase("f_f130ae4")) {
            if (element.getFirstChild() != null)
                body.setF_f130ae4(element.getFirstChild().getAttributes().getNamedItem("id").getNodeValue());
        } else if (element.getAttribute("name").equalsIgnoreCase("f_615ab98")) {
            if (element.getFirstChild() != null)
                body.setF_615ab98(element.getFirstChild().getAttributes().getNamedItem("id").getNodeValue());
        } else if (element.getAttribute("name").equalsIgnoreCase("f_61e8b2e")) {
            if (element.getFirstChild() != null)
                body.setF_61e8b2e(element.getFirstChild().getAttributes().getNamedItem("id").getNodeValue());
        } else if (element.getAttribute("name").equalsIgnoreCase("f_a1d098c")) {
            if (element.getFirstChild() != null)
                body.setF_a1d098c(element.getFirstChild().getAttributes().getNamedItem("id").getNodeValue());
        } else if (element.getAttribute("name").equalsIgnoreCase("f_516c7c3")) {
            if (element.getFirstChild() != null)
                body.setF_516c7c3(element.getFirstChild().getAttributes().getNamedItem("id").getNodeValue());
        } else if (element.getAttribute("name").equalsIgnoreCase("f_51f8599")) {
            if (element.getFirstChild() != null)
                body.setF_51f8599(element.getFirstChild().getAttributes().getNamedItem("id").getNodeValue());
        } else if (element.getAttribute("name").equalsIgnoreCase("f_b1d7068")) {
            if (element.getFirstChild() != null)
                body.setF_b1d7068(element.getFirstChild().getAttributes().getNamedItem("id").getNodeValue());
        } else if (element.getAttribute("name").equalsIgnoreCase("f_710f07e")) {
            if (element.getFirstChild() != null) {
                throw new Exception("f_710f07e");
            }
//                body.setF_710f07e(element.getFirstChild().getAttributes().getNamedItem("id").getNodeValue());
        } else if (element.getAttribute("name").equalsIgnoreCase("f_c1699ba")) {
            if (element.getFirstChild() != null)
                body.setF_c1699ba(element.getFirstChild().getAttributes().getNamedItem("id").getNodeValue());
        } else if (element.getAttribute("name").equalsIgnoreCase("f_b150e8e")) {
            if (element.getFirstChild() != null)
                body.setF_b150e8e(element.getFirstChild().getAttributes().getNamedItem("id").getNodeValue());
        } else if (element.getAttribute("name").equalsIgnoreCase("f_table_sogl")) {
            if (element.getFirstChild() != null)
                body.setFTableSogl(element.getFirstChild().getAttributes().getNamedItem("id").getNodeValue());
        } else if (element.getAttribute("name").equalsIgnoreCase("f_71c7b54")) {
            if (element.getFirstChild() != null)
                body.setF_71c7b54(element.getFirstChild().getAttributes().getNamedItem("id").getNodeValue());
        } else if (element.getAttribute("name").equalsIgnoreCase("f_f1b6492")) {
            if (element.getFirstChild() != null)
                body.setF_f1b6492(element.getFirstChild().getAttributes().getNamedItem("id").getNodeValue());
        } else if (element.getAttribute("name").equalsIgnoreCase("f_416739a")) {
            if (element.getFirstChild() != null)
                body.setF_416739a(element.getFirstChild().getAttributes().getNamedItem("id").getNodeValue());
        } else if (element.getAttribute("name").equalsIgnoreCase("f_d16785d")) {
            if (element.getFirstChild() != null)
                body.setF_d16785d(element.getFirstChild().getAttributes().getNamedItem("id").getNodeValue());
        } else if (element.getAttribute("name").equalsIgnoreCase("f_d16785d")) {
            if (element.getFirstChild() != null) {
                throw new Exception("f_d16785d");
            }
//                body.setFD16785d(element.getFirstChild().getAttributes().getNamedItem("id").getNodeValue());
        } else if (element.getAttribute("name").equalsIgnoreCase("f_81fbc4a")) {
            if (element.getFirstChild() != null)
                body.setF_81fbc4a(element.getFirstChild().getAttributes().getNamedItem("id").getNodeValue());
        } else if (element.getAttribute("name").equalsIgnoreCase("f_110039e")) {
            if (element.getFirstChild() != null)
                body.setF_110039e(element.getFirstChild().getAttributes().getNamedItem("id").getNodeValue());
        } else if (element.getAttribute("name").equalsIgnoreCase("f_1164f84")) {
            if (element.getFirstChild() != null)
                body.setF_1164f84(element.getFirstChild().getAttributes().getNamedItem("id").getNodeValue());
        } else if (element.getAttribute("name").equalsIgnoreCase("f_517bae1")) {
            if (element.getFirstChild() != null)
                body.setF_517bae1(element.getFirstChild().getAttributes().getNamedItem("id").getNodeValue());
        } else if (element.getAttribute("name").equalsIgnoreCase("f_1112b84")) {
            if (element.getFirstChild() != null)
                body.setF_1112b84(element.getFirstChild().getAttributes().getNamedItem("id").getNodeValue());
        } else if (element.getAttribute("name").equalsIgnoreCase("f_6124226")) {
            if (element.getFirstChild() != null)
                body.setF_6124226(element.getFirstChild().getAttributes().getNamedItem("id").getNodeValue());
        } else if (element.getAttribute("name").equalsIgnoreCase("f_211a19f")) {
            if (element.getFirstChild() != null)
                body.setF_211a19f(element.getFirstChild().getAttributes().getNamedItem("id").getNodeValue());
        } else if (element.getAttribute("name").equalsIgnoreCase("f_c144ea1")) {
            if (element.getFirstChild() != null)
                body.setF_c144ea1(element.getFirstChild().getAttributes().getNamedItem("id").getNodeValue());
        } else if (element.getAttribute("name").equalsIgnoreCase("f_01b986a")) {
            if (element.getFirstChild() != null)
                body.setF_01b986a(element.getFirstChild().getAttributes().getNamedItem("id").getNodeValue());
        } else if (element.getAttribute("name").equalsIgnoreCase("f_71f6e48")) {
            if (element.getFirstChild() != null)
                body.setF_71f6e48(element.getFirstChild().getAttributes().getNamedItem("id").getNodeValue());
        } else if (element.getAttribute("name").equalsIgnoreCase("f_61f64e5")) {
            if (element.getFirstChild() != null)
                body.setF_61f64e5(element.getFirstChild().getAttributes().getNamedItem("id").getNodeValue());
        } else if (element.getAttribute("name").equalsIgnoreCase("f_813bcf8")) {
            if (element.getFirstChild() != null)
                body.setF_813bcf8(element.getFirstChild().getAttributes().getNamedItem("id").getNodeValue());
        } else if (element.getAttribute("name").equalsIgnoreCase("f_21dee2e")) {
            if (element.getFirstChild() != null)
                body.setF_21dee2e(element.getFirstChild().getAttributes().getNamedItem("id").getNodeValue());
        } else if (element.getAttribute("name").equalsIgnoreCase("f_410ee30")) {
            if (element.getFirstChild() != null)
                body.setF_410ee30(element.getFirstChild().getAttributes().getNamedItem("id").getNodeValue());
        } else if (element.getAttribute("name").equalsIgnoreCase("f_c1ff57f")) {
            if (element.getFirstChild() != null)
                body.setF_c1ff57f(element.getFirstChild().getAttributes().getNamedItem("id").getNodeValue());
        }else if (element.getAttribute("name").equalsIgnoreCase("f_51926e6")) {
            if (element.getFirstChild() != null)
                body.setF_51926e6(element.getFirstChild().getAttributes().getNamedItem("id").getNodeValue());
        }else if (element.getAttribute("name").equalsIgnoreCase("f_21e53f0")) {
            if (element.getFirstChild() != null)
                body.setF_21e53f0(element.getFirstChild().getAttributes().getNamedItem("id").getNodeValue());
        } else if (element.getAttribute("name").equalsIgnoreCase("f_b1fab9a")) {

        } else if (element.getAttribute("name").equalsIgnoreCase("f_31f8f7c")) {

        } else if (element.getAttribute("name").equalsIgnoreCase("f_519145b")) {

        } else if (element.getAttribute("name").equalsIgnoreCase("f_d1c5f7d")) {

        } else if (element.getAttribute("name").equalsIgnoreCase("f_2190030")) {

        } else if (element.getAttribute("name").equalsIgnoreCase("f_d1193e2")) {

        } else if (element.getAttribute("name").equalsIgnoreCase("f_215b2e9")) {

        } else if (element.getAttribute("name").equalsIgnoreCase("f_11d6328")) {

        } else if (element.getAttribute("name").equalsIgnoreCase("f_d180879")) {

        } else if (element.getAttribute("name").equalsIgnoreCase("f_81cee9e")) {
            if (element.getFirstChild() != null)
                body.setF_81cee9e(element.getFirstChild().getAttributes().getNamedItem("id").getNodeValue());
        } else if (element.getAttribute("name").equalsIgnoreCase("reiterative_document")) {
            if (element.getFirstChild() != null) {
                throw new Exception("reiterative_document");
            }
//                body.setReiterativeDocument(element.getFirstChild().getNodeValue());
        } else {
            if (element.getParentNode().getNodeName().equalsIgnoreCase("document")) {
                throw new Exception("парсер добавь itemlist " + element.getAttribute("name"));
            }
        }
    }

    /**
     * @desc insert item
     */
    private void fullBodyItem(Element element, TDocumentBody body) throws Exception {

        if (element.getAttribute("name").equalsIgnoreCase("created_at")) {
            if (element.getFirstChild() != null)
                body.setCreatedAt(stringToTimestamp(element.getFirstChild().getNodeValue()));
        } else if (element.getAttribute("name").equalsIgnoreCase("edited_at")) {
            if (element.getFirstChild() != null)
                body.setEditedAt(stringToTimestamp(element.getFirstChild().getNodeValue()));
        } else if (element.getAttribute("name").equalsIgnoreCase("point_title")) {
            if (element.getFirstChild() != null)
                body.setPointTitle(element.getFirstChild().getNodeValue());
        } else if (element.getAttribute("name").equalsIgnoreCase("doctype")) {
            if (element.getFirstChild() != null)
                body.setDoctype(element.getFirstChild().getNodeValue());
        } else if (element.getAttribute("name").equalsIgnoreCase("reg_number")) {
            if (element.getFirstChild() != null)
                body.setRegNumber(element.getFirstChild().getNodeValue());
        } else if (element.getAttribute("name").equalsIgnoreCase("reg_tstamp")) {
            if (element.getFirstChild() != null)
                body.setRegTstamp(stringToTimestamp(element.getFirstChild().getNodeValue()));
        } else if (element.getAttribute("name").equalsIgnoreCase("ctr_start_at")) {
            if (element.getFirstChild() != null)
                body.setCtrStartAt(stringToTimestamp(element.getFirstChild().getNodeValue()));
        } else if (element.getAttribute("name").equalsIgnoreCase("ctr_stop_at")) {
            if (element.getFirstChild() != null)
                body.setCtrStopAt(stringToTimestamp(element.getFirstChild().getNodeValue()));
        } else if (element.getAttribute("name").equalsIgnoreCase("reiterative_id")) {
            if (element.getFirstChild() != null)
                body.setReiterativeId(stringToInteger(element.getFirstChild().getNodeValue()));
        } else if (element.getAttribute("name").equalsIgnoreCase("number_of_pages")) {
            if (element.getFirstChild() != null)
                body.setNumberOfPages(stringToInteger(element.getFirstChild().getNodeValue()));
        } else if (element.getAttribute("name").equalsIgnoreCase("f_512be20")) {
            if (element.getFirstChild() != null)
                body.setF_512be20(stringToInteger(element.getFirstChild().getNodeValue()));
        } else if (element.getAttribute("name").equalsIgnoreCase("f_a18b360")) {
            if (element.getFirstChild() != null)
                body.setF_a18b360(stringToInteger(element.getFirstChild().getNodeValue()));
        } else if (element.getAttribute("name").equalsIgnoreCase("f_version_number")) {
            if (element.getFirstChild() != null)
                body.setFVersionNumber(stringToInteger(element.getFirstChild().getNodeValue()));
        } else if (element.getAttribute("name").equalsIgnoreCase("f_d1821f1")) {
            if (element.getFirstChild() != null)
                body.setF_d1821f1(element.getFirstChild().getNodeValue());
        } else if (element.getAttribute("name").equalsIgnoreCase("f_619d7c8")) {
            if (element.getFirstChild() != null)
                body.setF_619d7c8(element.getFirstChild().getNodeValue());
        } else if (element.getAttribute("name").equalsIgnoreCase("f_d162acb")) {
            if (element.getFirstChild() != null)
                body.setF_d162acb(element.getFirstChild().getNodeValue());
        } else if (element.getAttribute("name").equalsIgnoreCase("f_416f97f")) {
            if (element.getFirstChild() != null)
                body.setF_416f97f(stringToDate(element.getFirstChild().getNodeValue()));
        } else if (element.getAttribute("name").equalsIgnoreCase("f_7162598")) {
            if (element.getFirstChild() != null)
                body.setF_7162598(stringToDate(element.getFirstChild().getNodeValue()));
        } else if (element.getAttribute("name").equalsIgnoreCase("f_d1f5912")) {
            if (element.getFirstChild() != null)
                body.setF_d1f5912(element.getFirstChild().getNodeValue());
        } else if (element.getAttribute("name").equalsIgnoreCase("f_e16a968")) {
            if (element.getFirstChild() != null)
                body.setFE16a968(stringToInteger(element.getFirstChild().getNodeValue()));
        } else if (element.getAttribute("name").equalsIgnoreCase("f_719abfc")) {
            if (element.getFirstChild() != null)
                body.setF_719abfc(element.getFirstChild().getNodeValue());
        } else if (element.getAttribute("name").equalsIgnoreCase("f_7190c2a")) {
            if (element.getFirstChild() != null)
                body.setF_7190c2a(element.getFirstChild().getNodeValue());
        } else if (element.getAttribute("name").equalsIgnoreCase("f_01ef95d")) {
            if (element.getFirstChild() != null)
                body.setF_01ef95d(element.getFirstChild().getNodeValue());
        } else if (element.getAttribute("name").equalsIgnoreCase("f_5128b2e")) {
            if (element.getFirstChild() != null)
                body.setF_5128b2e(element.getFirstChild().getNodeValue());
        } else if (element.getAttribute("name").equalsIgnoreCase("f_d1aab66")) {
            if (element.getFirstChild() != null)
                body.setF_d1aab66(element.getFirstChild().getNodeValue());
        } else if (element.getAttribute("name").equalsIgnoreCase("f_a19607f")) {
            if (element.getFirstChild() != null)
                body.setF_a19607f(element.getFirstChild().getNodeValue());
        } else if (element.getAttribute("name").equalsIgnoreCase("f_d1e4597")) {
            if (element.getFirstChild() != null)
                body.setF_d1e4597(element.getFirstChild().getNodeValue());
        } else if (element.getAttribute("name").equalsIgnoreCase("f_0120489")) {
            if (element.getFirstChild() != null)
                body.setF_0120489(stringToTimestamp(element.getFirstChild().getNodeValue()));
        } else if (element.getAttribute("name").equalsIgnoreCase("f_813edeb")) {
            if (element.getFirstChild() != null)
                body.setF_813edeb(stringToTimestamp(element.getFirstChild().getNodeValue()));
        } else if (element.getAttribute("name").equalsIgnoreCase("f_91f4590")) {
            if (element.getFirstChild() != null)
                body.setF_91f4590(Integer.valueOf(element.getFirstChild().getNodeValue()));
        } else if (element.getAttribute("name").equalsIgnoreCase("f_512b542")) {
            if (element.getFirstChild() != null)
                body.setF_512b542(element.getFirstChild().getNodeValue());
        } else if (element.getAttribute("name").equalsIgnoreCase("f_71db8bd")) {
            if (element.getFirstChild() != null)
                body.setF_71db8bd(element.getFirstChild().getNodeValue());
        } else if (element.getAttribute("name").equalsIgnoreCase("f_e14dda1")) {
            if (element.getFirstChild() != null)
                body.setF_e14dda1(element.getFirstChild().getNodeValue());
        } else if (element.getAttribute("name").equalsIgnoreCase("f_e132be8")) {
            if (element.getFirstChild() != null)
                body.setF_e132be8(Integer.valueOf(element.getFirstChild().getNodeValue()));
        } else if (element.getAttribute("name").equalsIgnoreCase("f_119a889")) {
            if (element.getFirstChild() != null)
                body.setF_119a889(Integer.valueOf(element.getFirstChild().getNodeValue()));
        } else if (element.getAttribute("name").equalsIgnoreCase("f_31efe17")) {
            if (element.getFirstChild() != null)
                body.setF_31efe17(Integer.valueOf(element.getFirstChild().getNodeValue()));
        } else if (element.getAttribute("name").equalsIgnoreCase("f_61f7ce1")) {
            if (element.getFirstChild() != null)
                body.setF_61f7ce1(element.getFirstChild().getNodeValue());
        } else if (element.getAttribute("name").equalsIgnoreCase("f_21cf180")) {
            if (element.getFirstChild() != null)
                body.setF_21cf180(element.getFirstChild().getNodeValue());
        } else if (element.getAttribute("name").equalsIgnoreCase("f_0190180")) {
            if (element.getFirstChild() != null)
                body.setF_0190180(element.getFirstChild().getNodeValue());
        } else if (element.getAttribute("name").equalsIgnoreCase("f_01692fa")) {
            if (element.getFirstChild() != null)
                body.setF_01692fa(element.getFirstChild().getNodeValue());
        } else if (element.getAttribute("name").equalsIgnoreCase("f_a1bb234")) {
            if (element.getFirstChild() != null)
                body.setF_a1bb234(element.getFirstChild().getNodeValue());
        } else if (element.getAttribute("name").equalsIgnoreCase("f_51601f8")) {
            if (element.getFirstChild() != null)
                body.setF_51601f8(element.getFirstChild().getNodeValue());
        } else if (element.getAttribute("name").equalsIgnoreCase("f_b1edc6b")) {
            if (element.getFirstChild() != null)
                body.setF_b1edc6b(element.getFirstChild().getNodeValue());
        } else if (element.getAttribute("name").equalsIgnoreCase("f_41be90d")) {
            if (element.getFirstChild() != null)
                body.setF_41be90d(element.getFirstChild().getNodeValue());
        } else if (element.getAttribute("name").equalsIgnoreCase("f_218fd6e")) {
            if (element.getFirstChild() != null)
                body.setF_218fd6e(stringToTimestamp(element.getFirstChild().getNodeValue()));
        } else if (element.getAttribute("name").equalsIgnoreCase("f_e11b6ad")) {
            if (element.getFirstChild() != null)
                body.setF_e11b6ad(stringToTimestamp(element.getFirstChild().getNodeValue()));
        } else if (element.getAttribute("name").equalsIgnoreCase("f_b1cbb3e")) {
            if (element.getFirstChild() != null)
                body.setF_b1cbb3e(stringToDate(element.getFirstChild().getNodeValue()));
        } else if (element.getAttribute("name").equalsIgnoreCase("f_0152899")) {
            if (element.getFirstChild() != null)
                body.setF_0152899(stringToDate(element.getFirstChild().getNodeValue()));
        } else if (element.getAttribute("name").equalsIgnoreCase("f_71e61e1")) {
            if (element.getFirstChild() != null)
                body.setF_71e61e1(stringToDate(element.getFirstChild().getNodeValue()));
        } else if (element.getAttribute("name").equalsIgnoreCase("f_611fa3a")) {
            if (element.getFirstChild() != null)
                body.setF_611fa3a(stringToDate(element.getFirstChild().getNodeValue()));
        } else if (element.getAttribute("name").equalsIgnoreCase("f_4181cf3")) {
            if (element.getFirstChild() != null)
                body.setF_4181cf3(element.getFirstChild().getNodeValue());
        } else if (element.getAttribute("name").equalsIgnoreCase("f_01c3ecb")) {
            if (element.getFirstChild() != null)
                body.setF_01c3ecb(stringToTimestamp(element.getFirstChild().getNodeValue()));
        } else if (element.getAttribute("name").equalsIgnoreCase("f_c1e51c5")) {
            if (element.getFirstChild() != null)
                body.setF_c1e51c5(element.getFirstChild().getNodeValue());
        } else if (element.getAttribute("name").equalsIgnoreCase("f_81f195a")) {
            if (element.getFirstChild() != null)
                body.setF_81f195a(element.getFirstChild().getNodeValue());
        } else if (element.getAttribute("name").equalsIgnoreCase("f_c1047fd")) {
            if (element.getFirstChild() != null)
                body.setF_c1047fd(stringToDate(element.getFirstChild().getNodeValue()));
        } else if (element.getAttribute("name").equalsIgnoreCase("f_f10aca9")) {
            if (element.getFirstChild() != null)
                body.setF_f10aca9(element.getFirstChild().getNodeValue());
        } else if (element.getAttribute("name").equalsIgnoreCase("f_a1b4fda")) {
            if (element.getFirstChild() != null)
                body.setF_a1b4fda(element.getFirstChild().getNodeValue());
        } else if (element.getAttribute("name").equalsIgnoreCase("f_d1a323a")) {
            if (element.getFirstChild() != null)
                body.setF_d1a323a(stringToDate(element.getFirstChild().getNodeValue()));
        } else if (element.getAttribute("name").equalsIgnoreCase("f_116a960")) {
            if (element.getFirstChild() != null)
                body.setF_116a960(element.getFirstChild().getNodeValue());
        } else if (element.getAttribute("name").equalsIgnoreCase("f_018fa0d")) {
            if (element.getFirstChild() != null)
                body.setF_018fa0d(element.getFirstChild().getNodeValue());
        } else if (element.getAttribute("name").equalsIgnoreCase("f_61a410b")) {
            if (element.getFirstChild() != null)
                body.setF_61a410b(element.getFirstChild().getNodeValue());
        } else if (element.getAttribute("name").equalsIgnoreCase("f_9148215")) {
            if (element.getFirstChild() != null)
                body.setF_9148215(element.getFirstChild().getNodeValue());
        } else if (element.getAttribute("name").equalsIgnoreCase("f_f13c5ea")) {
            if (element.getFirstChild() != null)
                body.setF_f13c5ea(Integer.valueOf(element.getFirstChild().getNodeValue()));
        } else if (element.getAttribute("name").equalsIgnoreCase("f_118945d")) {
            if (element.getFirstChild() != null)
                body.setF_118945d(stringToTimestamp(element.getFirstChild().getNodeValue()));
        } else if (element.getAttribute("name").equalsIgnoreCase("f_11a93cc")) {
            if (element.getFirstChild() != null)
                body.setF_11a93cc(element.getFirstChild().getNodeValue());
        } else if (element.getAttribute("name").equalsIgnoreCase("f_61d605e")) {
            if (element.getFirstChild() != null)
                body.setF_61d605e(element.getFirstChild().getNodeValue());
        } else if (element.getAttribute("name").equalsIgnoreCase("f_71a5738")) {
            if (element.getFirstChild() != null)
                body.setF_71a5738(element.getFirstChild().getNodeValue());
        } else if (element.getAttribute("name").equalsIgnoreCase("f_f1faec4")) {
            if (element.getFirstChild() != null)
                body.setF_f1faec4(element.getFirstChild().getNodeValue());
        } else if (element.getAttribute("name").equalsIgnoreCase("f_a163fd1")) {
            if (element.getFirstChild() != null)
                body.setF_a163fd1(element.getFirstChild().getNodeValue());
        } else if (element.getAttribute("name").equalsIgnoreCase("f_c16ebd5")) {
            if (element.getFirstChild() != null)
                body.setF_c16ebd5(stringToTimestamp(element.getFirstChild().getNodeValue()));
        } else if (element.getAttribute("name").equalsIgnoreCase("f_b15a6e7")) {
            if (element.getFirstChild() != null)
                body.setF_b15a6e7(element.getFirstChild().getNodeValue());
        } else if (element.getAttribute("name").equalsIgnoreCase("f_e1bd204")) {
            if (element.getFirstChild() != null)
                body.setF_e1bd204(element.getFirstChild().getNodeValue());
        } else if (element.getAttribute("name").equalsIgnoreCase("f_415a350")) {
            if (element.getFirstChild() != null)
                body.setF_415a350(stringToTimestamp(element.getFirstChild().getNodeValue()));
        } else if (element.getAttribute("name").equalsIgnoreCase("f_3147dd7")) {
            if (element.getFirstChild() != null)
                body.setF_3147dd7(element.getFirstChild().getNodeValue());
        } else if (element.getAttribute("name").equalsIgnoreCase("f_612d180")) {
            if (element.getFirstChild() != null)
                body.setF_612d180(stringToTimestamp(element.getFirstChild().getNodeValue()));
        } else if (element.getAttribute("name").equalsIgnoreCase("f_e1f58c2")) {
            if (element.getFirstChild() != null)
                body.setF_e1f58c2(element.getFirstChild().getNodeValue());
        } else if (element.getAttribute("name").equalsIgnoreCase("f_91abd5a")) {
            if (element.getFirstChild() != null)
                body.setF_91abd5a(element.getFirstChild().getNodeValue());
        } else if (element.getAttribute("name").equalsIgnoreCase("f_title")) {
            if (element.getFirstChild() != null)
                body.setFTitle(element.getFirstChild().getNodeValue());
        } else if (element.getAttribute("name").equalsIgnoreCase("f_c174820")) {
            if (element.getFirstChild() != null)
                body.setF_c174820(Integer.valueOf(element.getFirstChild().getNodeValue()));
        } else if (element.getAttribute("name").equalsIgnoreCase("f_914ea94")) {
            if (element.getFirstChild() != null)
                body.setF_914ea94(Integer.valueOf(element.getFirstChild().getNodeValue()));
        } else if (element.getAttribute("name").equalsIgnoreCase("f_01a1414")) {
            if (element.getFirstChild() != null)
                body.setF_01a1414(element.getFirstChild().getNodeValue());
        } else if (element.getAttribute("name").equalsIgnoreCase("f_2149494")) {
            if (element.getFirstChild() != null)
                body.setF_2149494(stringToDate(element.getFirstChild().getNodeValue()));
        } else if (element.getAttribute("name").equalsIgnoreCase("f_d13b321")) {
            if (element.getFirstChild() != null)
                body.setF_d13b321(element.getFirstChild().getNodeValue());
        } else if (element.getAttribute("name").equalsIgnoreCase("f_717b3d2")) {
            if (element.getFirstChild() != null)
                body.setF_717b3d2(element.getFirstChild().getNodeValue());
        } else if (element.getAttribute("name").equalsIgnoreCase("f_511168a")) {
            if (element.getFirstChild() != null)
                body.setF_511168a(element.getFirstChild().getNodeValue());
        } else if (element.getAttribute("name").equalsIgnoreCase("f_c11c227")) {
            if (element.getFirstChild() != null)
                body.setF_c11c227(element.getFirstChild().getNodeValue());
        } else if (element.getAttribute("name").equalsIgnoreCase("f_11292c6")) {
            if (element.getFirstChild() != null)
                body.setF_11292c6(element.getFirstChild().getNodeValue());
        } else if (element.getAttribute("name").equalsIgnoreCase("f_71567dc")) {
            if (element.getFirstChild() != null)
                body.setF_71567dc(stringToDate(element.getFirstChild().getNodeValue()));
        } else if (element.getAttribute("name").equalsIgnoreCase("f_61eb5c6")) {
            if (element.getFirstChild() != null)
                body.setF_61eb5c6(element.getFirstChild().getNodeValue());
        } else if (element.getAttribute("name").equalsIgnoreCase("f_d175b87")) {
            if (element.getFirstChild() != null)
                body.setF_d175b87(element.getFirstChild().getNodeValue());
        } else if (element.getAttribute("name").equalsIgnoreCase("f_commentnewversion")) {
            if (element.getFirstChild() != null)
                body.setFCommentnewversion(element.getFirstChild().getNodeValue());
        } else if (element.getAttribute("name").equalsIgnoreCase("f_version")) {
            if (element.getFirstChild() != null)
                body.setFVersion(element.getFirstChild().getNodeValue());
        } else if (element.getAttribute("name").equalsIgnoreCase("f_version_kz")) {
            if (element.getFirstChild() != null)
                body.setFVersionKz(element.getFirstChild().getNodeValue());
        } else if (element.getAttribute("name").equalsIgnoreCase("f_short_title")) {
            if (element.getFirstChild() != null)
                body.setFShortTitle(element.getFirstChild().getNodeValue());
        } else if (element.getAttribute("name").equalsIgnoreCase("f_a1ebb32")) {
            if (element.getFirstChild() != null)
                body.setF_a1ebb32(element.getFirstChild().getNodeValue());
        } else if (element.getAttribute("name").equalsIgnoreCase("f_b10f779")) {
            if (element.getFirstChild() != null)
                body.setF_b10f779(stringToDate(element.getFirstChild().getNodeValue()));
        } else if (element.getAttribute("name").equalsIgnoreCase("f_41a4d30")) {
            if (element.getFirstChild() != null)
                body.setF_41a4d30(element.getFirstChild().getNodeValue());
        } else if (element.getAttribute("name").equalsIgnoreCase("number_of_applications")) {
            if (element.getFirstChild() != null)
                body.setNumberOfApplications(Integer.valueOf(element.getFirstChild().getNodeValue()));
        } else if (element.getAttribute("name").equalsIgnoreCase("f_c1e008c")) {
            if (element.getFirstChild() != null)
                body.setF_c1e008c(element.getFirstChild().getNodeValue());
        } else if (element.getAttribute("name").equalsIgnoreCase("f_c1b48c8")) {
            if (element.getFirstChild() != null)
                body.setF_c1b48c8(Integer.valueOf(element.getFirstChild().getNodeValue()));
        } else if (element.getAttribute("name").equalsIgnoreCase("f_01d0b5a")) {
            if (element.getFirstChild() != null)
                body.setF_01d0b5a(Integer.valueOf(element.getFirstChild().getNodeValue()));
        }else if (element.getAttribute("name").equalsIgnoreCase("f_b1332ad")) {
            if (element.getFirstChild() != null)
                body.setF_b1332ad(element.getFirstChild().getNodeValue());
        }
//        else {
//            if (element.getParentNode().getNodeName().equalsIgnoreCase("document")) {
//                throw new Exception("парсер добавь item " + element.getAttribute("name"));
//            }
//        }
    }

    /**
     * @desc insert item
     */
    private void fullBodyDecisionList(Element element, TDocumentRoot root) throws Exception {


        NodeList list = element.getChildNodes();
        for (int j = 0; j < list.getLength(); j++) {
            Element main = (Element) list.item(j);

            NodeList mainList = main.getElementsByTagName("*");
            TDecision decision = new TDecision();
            decision.setId(tDecisionRepository.getNextSeriesId());
            decision.setRoot(root);

            for (int k = 0; k < mainList.getLength(); k++) {
                Element ch = (Element) mainList.item(k);


                if (k == 0) {
                    decision.setWsTitle(ch.getAttribute("name"));
                } else {
                    if (ch.getAttribute("name").equalsIgnoreCase("id")) {
                        if (ch.getFirstChild() != null)
                            decision.setXmlId(ch.getFirstChild().getNodeValue());
                    }
                    if (ch.getAttribute("name").equalsIgnoreCase("author_id")) {
                        if (ch.getFirstChild() != null)
                            decision.setAuthorId(ch.getFirstChild().getNodeValue());
                    }
                    if (ch.getAttribute("name").equalsIgnoreCase("author")) {
                        if (ch.getFirstChild() != null)
                            decision.setAuthor(ch.getFirstChild().getNodeValue());
                    }
                    if (ch.getAttribute("name").equalsIgnoreCase("tstamp")) {
                        if (ch.getFirstChild() != null)
                            decision.setTstamp(stringToDate2(ch.getFirstChild().getNodeValue()));
                    }
                    if (ch.getAttribute("name").equalsIgnoreCase("text")) {
                        if (ch.getFirstChild() != null)
                            decision.setText(ch.getFirstChild().getNodeValue());
                    }
                    if (ch.getAttribute("name").equalsIgnoreCase("text_kz")) {
                        if (ch.getFirstChild() != null)
                            decision.setTextKz(ch.getFirstChild().getNodeValue());
                    }
                    if (ch.getAttribute("name").equalsIgnoreCase("comment")) {
                        if (ch.getFirstChild() != null)
                            decision.setComment(ch.getFirstChild().getNodeValue());
                    }
                    if (ch.getAttribute("name").equalsIgnoreCase("files")) {
                        if (ch.getFirstChild() != null)
                            decision.setFiles(ch.getFirstChild().getNodeValue());
                    }
                    if (ch.getAttribute("name").equalsIgnoreCase("custom_fields")) {
                        if (ch.getFirstChild() != null)
                            decision.setCustomFields(ch.getFirstChild().getNodeValue());
                    }
                    if (ch.getAttribute("name").equalsIgnoreCase("sign_fields")) {
                        if (ch.getFirstChild() != null)
                            fullTSignFields(ch, decision);
                    }
                    if (ch.getAttribute("name").equalsIgnoreCase("sign")) {
                        if (ch.getFirstChild() != null)
                            decision.setSign(ch.getFirstChild().getNodeValue());
                    }
                    if (ch.getAttribute("name").equalsIgnoreCase("e_sign")) {
                        if (ch.getFirstChild() != null)
                            fullTESign(ch, decision);
                    }
                    if (ch.getAttribute("name").equalsIgnoreCase("eds_format")) {
                        if (ch.getFirstChild() != null)
                            decision.setEdsFormat(ch.getFirstChild().getNodeValue());
                    }
                }
            }
            tDecisionRepository.saveAndFlush(decision);
        }
    }

    /**
     * @desc insert TSignFields
     */
    private void fullTSignFields(Element element, TDecision decision) {

        NodeList subList = element.getElementsByTagName("*");

        for (int k = 0; k < subList.getLength(); k++) {
            Element ch = (Element) subList.item(k);
            if (ch != null) {
                TSignFields signFields = new TSignFields();
                signFields.setDecisionId(decision.getId());
                signFields.setItemId(Integer.valueOf(ch.getAttribute("id")));
                if (ch.getFirstChild() != null)
                    signFields.setValue(ch.getFirstChild().getNodeValue());

                tSignFieldsRepository.saveAndFlush(signFields);
            }
        }
    }

    /**
     * @desc insert TSignFields
     */
    private void fullTESign(Element element, TDecision decision) throws Exception {

        NodeList subList = element.getElementsByTagName("*");
        TESign signFields = new TESign();
        signFields.setDecisionId(decision.getId());
        for (int k = 0; k < subList.getLength(); k++) {
            Element ch = (Element) subList.item(k);
            if (ch != null) {

                if (ch.getAttribute("id").equalsIgnoreCase("dn")) {
                    if (ch.getFirstChild() != null)
                        signFields.setDn(ch.getFirstChild().getNodeValue());
                }
                if (ch.getAttribute("id").equalsIgnoreCase("type")) {
                    if (ch.getFirstChild() != null)
                        signFields.setType(ch.getFirstChild().getNodeValue());
                }
                if (ch.getAttribute("id").equalsIgnoreCase("eds_type")) {
                    if (ch.getFirstChild() != null)
                        signFields.setEdsType(ch.getFirstChild().getNodeValue());
                }
                if (ch.getAttribute("id").equalsIgnoreCase("ca")) {
                    if (ch.getFirstChild() != null)
                        signFields.setCa(ch.getFirstChild().getNodeValue());
                }
                if (ch.getAttribute("id").equalsIgnoreCase("sign")) {
                    if (ch.getFirstChild() != null)
                        signFields.setSign(ch.getFirstChild().getNodeValue());
                }
                if (ch.getAttribute("id").equalsIgnoreCase("status")) {
                    if (ch.getFirstChild() != null)
                        signFields.setStatus(ch.getFirstChild().getNodeValue());
                }

                teSignRepository.saveAndFlush(signFields);
            }
        }
    }

    private Timestamp stringToTimestamp(String nodeValue) {
        if (!isNullOrEmpty(nodeValue)) {
            return Timestamp.valueOf(nodeValue);
        }
        return null;
    }


    public void run() throws Exception {
//        String path = "c78dcb38-5b95-49e6-bb1e-5a9006f00076.xml";

//        File folder = new File("C:\\\\Users\\\\a.kusein\\\\Desktop\\\\xml_2018_February\\\\Внутренний документ\\\\");
        File folder = new File("C:\\Users\\a.kusein\\Desktop\\xml_2018_February\\Заявка ОРМ\\\\");
        File[] listOfFiles = folder.listFiles();

        for (File file : listOfFiles) {
            parseData(file);
        }
    }
    @Transactional(rollbackFor = Throwable.class)
    void parseData(File file) throws Exception {
        if (file.isFile()) {
            System.out.println(file.getName());
            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
            DocumentBuilder db = dbf.newDocumentBuilder();
            Document document = db.parse(file);


            Element root = document.getDocumentElement();

            TDocumentRoot tDocumentRoot = insertRoot(root, root.getElementsByTagName("item"));

            TDocumentBody body = new TDocumentBody();
            body.setRoot(tDocumentRoot);
            body.setId(tDocumentBodyRepository.getNextSeriesId());
            NodeList nodeList = document.getElementsByTagName("*");
            for (int i = 0; i < nodeList.getLength(); i++) {
                Element element = (Element) nodeList.item(i);
                if (!element.getNodeName().equalsIgnoreCase("document")) {
                    if (!element.getAttribute("name").equalsIgnoreCase("title")) {
                        if (element.getNodeName().equalsIgnoreCase("itemslist")) {
                            fullBodyItemlist(element, body);
                        } else if (element.getNodeName().equalsIgnoreCase("item")) {
                            fullBodyItem(element, body);
                        }
                    }
                }
            }
            tDocumentBodyRepository.saveAndFlush(body);

            for (int i = 0; i < nodeList.getLength(); i++) {
                Element element = (Element) nodeList.item(i);
                if (!element.getNodeName().equalsIgnoreCase("document")) {
                    if (!element.getAttribute("name").equalsIgnoreCase("title")) {
                        if (element.getNodeName().equalsIgnoreCase("decisionslist")) {
                            fullBodyDecisionList(element, tDocumentRoot);
                        }
                    }
                }
            }

            for (int i = 0; i < nodeList.getLength(); i++) {
                Element element = (Element) nodeList.item(i);
                if (!element.getNodeName().equalsIgnoreCase("document")) {
                    if (!element.getAttribute("name").equalsIgnoreCase("title")) {
                        if (element.getNodeName().equalsIgnoreCase("itemslist")) {
                            if (element.getAttribute("name").equalsIgnoreCase("f_b1fab9a")) {
                                insertStructure(element, body);
                            } else if (element.getAttribute("name").equalsIgnoreCase("f_31f8f7c")) {
                                insertF_31f8f7c(element, body);
                            } else if (element.getAttribute("name").equalsIgnoreCase("f_519145b")) {
                                insertTF519145b(element, body);
                            } else if (element.getAttribute("name").equalsIgnoreCase("f_d1c5f7d")) {
                                insertTf_d1c5f7d(element, body);
                            } else if (element.getAttribute("name").equalsIgnoreCase("f_2190030")) {
                                insertTf_2190030(element, body);
                            } else if (element.getAttribute("name").equalsIgnoreCase("f_215b2e9")) {
                                insertTF215b2e9(element, body);
                            } else if (element.getAttribute("name").equalsIgnoreCase("f_11d6328")) {
                                insertTf_11d6328(element, body);
                            } else if (element.getAttribute("name").equalsIgnoreCase("f_d1193e2")) {
                                insertT_F_D1193e2(element, body);
                            } else if (element.getAttribute("name").equalsIgnoreCase("f_d180879")) {
                                insertTf_d180879(element, body);
                            }
                        }
                    }
                }
            }
        }
    }

    /**
     * f_b1fab9a;
     *
     * @param element
     * @param body
     */
    private void insertStructure(Element element, TDocumentBody body) {
        NodeList list = element.getChildNodes();
        for (int j = 0; j < list.getLength(); j++) {
            Element main = (Element) list.item(j);
            if (main.getFirstChild() != null) {
                TStructure tStructure = new TStructure();
                tStructure.setTDocumentBody(body);
                tStructure.setStructureId(main.getAttribute("id"));
                tStructure.setStructureValue(main.getFirstChild().getNodeValue());
                tStructureRepository.saveAndFlush(tStructure);
            }
        }
    }

    /**
     * f_31f8f7c
     *
     * @param element
     * @param body
     */
    private void insertF_31f8f7c(Element element, TDocumentBody body) {
        NodeList list = element.getChildNodes();
        for (int j = 0; j < list.getLength(); j++) {
            Element main = (Element) list.item(j);
            if (main.getFirstChild() != null) {
                TF31f8f7c tStructure = new TF31f8f7c();
                tStructure.setTDocumentBody(body);
                tStructure.setStructureId(main.getAttribute("id"));
                tStructure.setStructureValue(main.getFirstChild().getNodeValue());
                tf31f8f7cRepository.saveAndFlush(tStructure);
            }
        }
    }

    /**
     * F_519145b
     *
     * @param element
     * @param body
     */
    private void insertTF519145b(Element element, TDocumentBody body) {
        NodeList list = element.getChildNodes();
        for (int j = 0; j < list.getLength(); j++) {
            Element main = (Element) list.item(j);
            if (main.getFirstChild() != null) {
                TF519145b tStructure = new TF519145b();
                tStructure.setTDocumentBody(body);
                tStructure.setStructureId(main.getAttribute("id"));
                tStructure.setStructureValue(main.getFirstChild().getNodeValue());
                tf519145bRepository.saveAndFlush(tStructure);
            }
        }
    }

    /**
     * f_d1c5f7d
     *
     * @param element
     * @param body
     */
    private void insertTf_d1c5f7d(Element element, TDocumentBody body) {
        NodeList list = element.getChildNodes();
        for (int j = 0; j < list.getLength(); j++) {
            Element main = (Element) list.item(j);
            if (main.getFirstChild() != null) {
                TFD1c5f7d tStructure = new TFD1c5f7d();
                tStructure.setTDocumentBody(body);
                tStructure.setStructureId(main.getAttribute("id"));
                tStructure.setStructureValue(main.getFirstChild().getNodeValue());
                tfd1c5f7dRepository.saveAndFlush(tStructure);
            }
        }
    }

    /**
     * f_2190030
     *
     * @param element
     * @param body
     */
    private void insertTf_2190030(Element element, TDocumentBody body) {
        NodeList list = element.getChildNodes();
        for (int j = 0; j < list.getLength(); j++) {
            Element main = (Element) list.item(j);
            if (main.getFirstChild() != null) {
                TF2190030 tStructure = new TF2190030();
                tStructure.setTDocumentBody(body);
                tStructure.setStructureId(main.getAttribute("id"));
                tStructure.setStructureValue(main.getFirstChild().getNodeValue());
                tf2190030Repository.saveAndFlush(tStructure);
            }
        }
    }

    /**
     * f_d1193e2
     *
     * @param element
     * @param body
     */
    private void insertT_F_D1193e2(Element element, TDocumentBody body) {
        NodeList list = element.getChildNodes();
        for (int j = 0; j < list.getLength(); j++) {
            Element main = (Element) list.item(j);
            if (main.getFirstChild() != null) {
                TFD1193e2 tStructure = new TFD1193e2();
                tStructure.setTDocumentBody(body);
                tStructure.setStructureId(main.getAttribute("id"));
                tStructure.setStructureValue(main.getFirstChild().getNodeValue());
                tfd1193e2Repository.saveAndFlush(tStructure);
            }
        }
    }

    /**
     * f_215b2e9
     *
     * @param element
     * @param body
     */
    private void insertTF215b2e9(Element element, TDocumentBody body) {
        NodeList list = element.getChildNodes();
        for (int j = 0; j < list.getLength(); j++) {
            Element main = (Element) list.item(j);
            if (main.getFirstChild() != null) {
                TF215b2e9 tStructure = new TF215b2e9();
                tStructure.setTDocumentBody(body);
                tStructure.setStructureId(main.getAttribute("id"));
                tStructure.setStructureValue(main.getFirstChild().getNodeValue());
                tf215b2e9Repository.saveAndFlush(tStructure);
            }
        }
    }

    /**
     * f_11d6328
     *
     * @param element
     * @param body
     */
    private void insertTf_11d6328(Element element, TDocumentBody body) {
        NodeList list = element.getChildNodes();
        for (int j = 0; j < list.getLength(); j++) {
            Element main = (Element) list.item(j);
            if (main.getFirstChild() != null) {
                TF11d6328 tStructure = new TF11d6328();
                tStructure.setTDocumentBody(body);
                tStructure.setStructureId(main.getAttribute("id"));
                tStructure.setStructureValue(main.getFirstChild().getNodeValue());
                tf11d6328Repository.saveAndFlush(tStructure);
            }
        }
    }


    /**
     * f_d180879
     *
     * @param element
     * @param body
     */
    private void insertTf_d180879(Element element, TDocumentBody body) {
        NodeList list = element.getChildNodes();
        for (int j = 0; j < list.getLength(); j++) {
            Element main = (Element) list.item(j);
            if (main.getFirstChild() != null) {
                TFD180879 tStructure = new TFD180879();
                tStructure.setTDocumentBody(body);
                tStructure.setStructureId(main.getAttribute("id"));
                tStructure.setStructureValue(main.getFirstChild().getNodeValue());
                tfd180879Repository.saveAndFlush(tStructure);
            }
        }
    }

}
