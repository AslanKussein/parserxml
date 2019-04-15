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
import static kz.kazimpex.parserxml.ParserItemList.fullBodyItemlist;

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
    @Autowired
    TF6117eadRepository tf6117eadRepository;
    @Autowired
    TFD1107e3Repository tfd1107e3Repository;
    @Autowired
    TFF130ae4Repository tff130ae4Repository;
    @Autowired
    TF01692faRepository tf01692faRepository;
    @Autowired
    TFB12e0d5Repository tfb12e0d5Repository;
    @Autowired
    TFF1d8b64Repository tff1d8b64Repository;

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

    public static Integer stringToInteger(String val) {
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
        } else if (element.getAttribute("name").equalsIgnoreCase("f_b1332ad")) {
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

    @Transactional(rollbackFor = Exception.class)
    public void run() throws Exception {
//        String path = "c78dcb38-5b95-49e6-bb1e-5a9006f00076.xml";

        File folder = new File("C:\\\\Users\\\\a.kusein\\\\Desktop\\\\xml_2018_February\\\\Внутренний документ\\\\");
//        File folder = new File("C:\\Users\\a.kusein\\Desktop\\xml_2018_February\\test\\\\");
        File[] listOfFiles = folder.listFiles();

        assert listOfFiles != null;
        for (File file : listOfFiles) {
            parseData(file);
        }
    }

    private void parseData(File file) throws Exception {
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
                            } else if (element.getAttribute("name").equalsIgnoreCase("f_6117ead")) {
                                insertTF6117ead(element, body);
                            } else if (element.getAttribute("name").equalsIgnoreCase("f_d1107e3")) {
                                insertTFD1107e3(element, body);
                            } else if (element.getAttribute("name").equalsIgnoreCase("f_f130ae4")) {
                                insertTFF130ae4(element, body);
                            } else if (element.getAttribute("name").equalsIgnoreCase("f_01692fa")) {
                                insertTF01692fa(element, body);
                            } else if (element.getAttribute("name").equalsIgnoreCase("f_b12e0d5")) {
                                insertTFB12e0d5(element, body);
                            }else if (element.getAttribute("name").equalsIgnoreCase("f_f1d8b64")) {
                                insertTFF1d8b64(element, body);
                            }
                        }
                    }
                }
            }
        }
    }



    /**
     * f_f1d8b64;
     *
     * @param element
     * @param body
     */
    private void insertTFF1d8b64(Element element, TDocumentBody body) {
        NodeList list = element.getChildNodes();
        for (int j = 0; j < list.getLength(); j++) {
            Element main = (Element) list.item(j);
            if (main.getFirstChild() != null) {
                TFF1d8b64 tStructure = new TFF1d8b64();
                tStructure.setTDocumentBody(body);
                tStructure.setStructureId(main.getAttribute("id"));
                tStructure.setStructureValue(main.getFirstChild().getNodeValue());
                tff1d8b64Repository.saveAndFlush(tStructure);
            }
        }
    }

    /**
     * f_b12e0d5;
     *
     * @param element
     * @param body
     */
    private void insertTFB12e0d5(Element element, TDocumentBody body) {
        NodeList list = element.getChildNodes();
        for (int j = 0; j < list.getLength(); j++) {
            Element main = (Element) list.item(j);
            if (main.getFirstChild() != null) {
                TFB12e0d5 tStructure = new TFB12e0d5();
                tStructure.setTDocumentBody(body);
                tStructure.setStructureId(main.getAttribute("id"));
                tStructure.setStructureValue(main.getFirstChild().getNodeValue());
                tfb12e0d5Repository.saveAndFlush(tStructure);
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

    /**
     * f_6117ead
     *
     * @param element
     * @param body
     */
    private void insertTF6117ead(Element element, TDocumentBody body) {
        NodeList list = element.getChildNodes();
        for (int j = 0; j < list.getLength(); j++) {
            Element main = (Element) list.item(j);
            if (main.getFirstChild() != null) {
                TF6117ead tStructure = new TF6117ead();
                tStructure.setTDocumentBody(body);
                tStructure.setStructureId(main.getAttribute("id"));
                tStructure.setStructureValue(main.getFirstChild().getNodeValue());
                tf6117eadRepository.saveAndFlush(tStructure);
            }
        }
    }

    /**
     * f_d1107e3
     *
     * @param element
     * @param body
     */
    private void insertTFD1107e3(Element element, TDocumentBody body) {
        NodeList list = element.getChildNodes();
        for (int j = 0; j < list.getLength(); j++) {
            Element main = (Element) list.item(j);
            if (main.getFirstChild() != null) {
                TFD1107e3 tStructure = new TFD1107e3();
                tStructure.setTDocumentBody(body);
                tStructure.setStructureId(main.getAttribute("id"));
                tStructure.setStructureValue(main.getFirstChild().getNodeValue());
                tfd1107e3Repository.saveAndFlush(tStructure);
            }
        }
    }

    /**
     * f_f130ae4
     *
     * @param element
     * @param body
     */
    private void insertTFF130ae4(Element element, TDocumentBody body) {
        NodeList list = element.getChildNodes();
        for (int j = 0; j < list.getLength(); j++) {
            Element main = (Element) list.item(j);
            if (main.getFirstChild() != null) {
                TFF130ae4 tStructure = new TFF130ae4();
                tStructure.setTDocumentBody(body);
                tStructure.setStructureId(main.getAttribute("id"));
                tStructure.setStructureValue(main.getFirstChild().getNodeValue());
                tff130ae4Repository.saveAndFlush(tStructure);
            }
        }
    }


    /**
     * f_01692fa
     *
     * @param element
     * @param body
     */
    private void insertTF01692fa(Element element, TDocumentBody body) {
        NodeList list = element.getChildNodes();
        for (int j = 0; j < list.getLength(); j++) {
            Element main = (Element) list.item(j);
            if (main.getFirstChild() != null) {
                TF01692fa tStructure = new TF01692fa();
                tStructure.setTDocumentBody(body);
                tStructure.setStructureId(main.getAttribute("id"));
                tStructure.setStructureValue(main.getFirstChild().getNodeValue());
                tf01692faRepository.saveAndFlush(tStructure);
            }
        }
    }

}
