package kz.kazimpex.parserxml;

import kz.kazimpex.parserxml.jpa.domain.*;
import kz.kazimpex.parserxml.jpa.repository.*;
import lombok.var;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Date;

import static com.google.common.base.Strings.isNullOrEmpty;
import static kz.kazimpex.parserxml.ParseItem.fullBodyItem;
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
    @Autowired
    TF21e81a6Repository tf21e81a6Repository;
    @Autowired
    TF31dc56bRepository tf31dc56bRepository;
    @Autowired
    TF1168c6fRepository tf1168c6fRepository;
    @Autowired
    TChildListRepository tChildListRepository;
    @Autowired
    TF2130062Repository tf2130062Repository;
    @Autowired
    TF0190180Repository tf0190180Repository;
    @Autowired
    TF31b92adRepository tf31b92adRepository;
    @Autowired
    TF2149883Repository tf2149883Repository;
    @Autowired
    TF41830e9Repository tf41830e9Repository;
    @Autowired
    TFa1cd4ffRepository tFa1cd4ffRepository;
    @Autowired
    TFc13b7f0Repository tFc13b7f0Repository;
    @Autowired
    TFd151227Repository tFd151227Repository;
    @Autowired
    TF6135ec8Repository tf6135ec8Repository;
    @Autowired
    TFc11a6abRepository tFc11a6abRepository;
    @Autowired
    TF61fcfd3Repository tf61fcfd3Repository;
    @Autowired
    TF61ae463Repository tf61ae463Repository;
    @Autowired
    TF519e6cdRepository tf519e6cdRepository;
    @Autowired
    TF715a73fRepository tf715a73fRepository;
    @Autowired
    TFC1bcdf1Repository tfc1bcdf1Repository;
    @Autowired
    TFe158ee0Repository tFe158ee0Repository;
    @Autowired
    TFc19311bRepository tFc19311bRepository;
    @Autowired
    TFd1970baRepository tFd1970baRepository;
    @Autowired
    TF81eed8dRepository tf81eed8dRepository;
    @Autowired
    TFb1a3034Repository tFb1a3034Repository;
    @Autowired
    TF31fc45fRepository tf31fc45fRepository;
    @Autowired
    TF1119b0fRepository tf1119b0fRepository;


    private static Date asDate(LocalDate localDate) {
        return Date.from(localDate.atStartOfDay().atZone(ZoneId.systemDefault()).toInstant());
    }


    public static Date stringToDate(String str) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate dateTime = LocalDate.parse(str, formatter);
        return asDate(dateTime);
    }

    public static Date stringToDate2(String str) {
        String pattern = str.length() == 19 ? "yyyy-MM-dd HH:mm:ss" : "yyyy-MM-dd HH:mm";
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(pattern);
        LocalDate dateTime = LocalDate.parse(str, formatter);
        return asDate(dateTime);
    }

    public static String getValueByName(Element root, String value) throws Exception {
        if (!isNullOrEmpty(value)) {
            if (root.getAttributes().getNamedItem(value) != null) {
                return root.getAttributes().getNamedItem(value).getNodeValue();
            }
            return null;
        }
        throw new Exception("Пустой value");
    }

    public static String getValueByNameAndIterator(NodeList list, int i, String tagName) throws Exception {
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

    public static Timestamp stringToTimestamp(String nodeValue) {
        if (!isNullOrEmpty(nodeValue)) {
            return Timestamp.valueOf(nodeValue);
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

                if (ch.getAttribute("id").equalsIgnoreCase("outgoing_number")) {
                    if (ch.getFirstChild() != null)
                        signFields.setOutgoing_date(ch.getFirstChild().getNodeValue());
                }
                if (ch.getAttribute("id").equalsIgnoreCase("outgoing_date")) {
                    if (ch.getFirstChild() != null)
                        signFields.setOutgoing_date(ch.getFirstChild().getNodeValue());
                }
                if (ch.getAttribute("id").equalsIgnoreCase("short_content")) {
                    if (ch.getFirstChild() != null)
                        signFields.setShort_content(ch.getFirstChild().getNodeValue());
                }
                if (ch.getFirstChild() != null)
                    signFields.setValue(ch.getFirstChild().getNodeValue());

                tSignFieldsRepository.saveAndFlush(signFields);
            }
        }
    }

    /**
     * @param element;
     * @param body;
     * @desc childslist;
     */
    private void fullbodyChildList(Element element, TDocumentBody body) throws Exception {
        if (element.getFirstChild() != null && element.getFirstChild().getNodeValue() != null) {
            for (String s : element.getFirstChild().getNodeValue().split(",")) {
                TChildList tStructure = new TChildList();
                tStructure.setTDocumentBody(body);
                tStructure.setStructureId(s);
                tChildListRepository.saveAndFlush(tStructure);
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


    @Transactional(rollbackFor = Exception.class)
    public void run() throws Exception {
//        String path = "c78dcb38-5b95-49e6-bb1e-5a9006f00076.xml";

//        File folder = new File("C:\\Users\\a.kusein\\Desktop\\xml_2018_February\\Исходящий документ\\");
        File folder = new File("C:\\Users\\a.kusein\\Desktop\\xml_2018_February\\Входящий документ\\");
//        File folder = new File("C:\\Users\\a.kusein\\Desktop\\xml_2018_February\\test\\\\");
        File[] listOfFiles = folder.listFiles();
        var k = 0;
        assert listOfFiles != null;
        for (File file : listOfFiles) {
            k += 1;
            parseData(file, k);
        }
    }

    private void parseData(File file, int l) throws Exception {
        if (file.isFile()) {
            System.out.println(l + " " + file.getName());
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
                        if (element.getNodeName().equalsIgnoreCase("childslist")) {
                            fullbodyChildList(element, body);
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
                            } else if (element.getAttribute("name").equalsIgnoreCase("f_f1d8b64")) {
                                insertTFF1d8b64(element, body);
                            } else if (element.getAttribute("name").equalsIgnoreCase("f_31dc56b")) {
                                insertTF31dc56b(element, body);
                            } else if (element.getAttribute("name").equalsIgnoreCase("f_21e81a6")) {
                                insertTF21e81a6(element, body);
                            } else if (element.getAttribute("name").equalsIgnoreCase("f_1168c6f")) {
                                insertTF1168c6f(element, body);
                            } else if (element.getAttribute("name").equalsIgnoreCase("f_2130062")) {
                                insertTF2130062(element, body);
                            } else if (element.getAttribute("name").equalsIgnoreCase("f_0190180")) {
                                insertTF0190180(element, body);
                            } else if (element.getAttribute("name").equalsIgnoreCase("f_31b92ad")) {
                                insertTF31b92ad(element, body);
                            } else if (element.getAttribute("name").equalsIgnoreCase("f_2149883")) {
                                insertTF2149883(element, body);
                            } else if (element.getAttribute("name").equalsIgnoreCase("f_41830e9")) {
                                insertTF41830e9(element, body);
                            } else if (element.getAttribute("name").equalsIgnoreCase("f_a1cd4ff")) {
                                insertTFa1cd4ff(element, body);
                            } else if (element.getAttribute("name").equalsIgnoreCase("f_c13b7f0")) {
                                insertTFc13b7f0(element, body);
                            } else if (element.getAttribute("name").equalsIgnoreCase("f_d151227")) {
                                insertTFd151227(element, body);
                            } else if (element.getAttribute("name").equalsIgnoreCase("f_6135ec8")) {
                                insertTF6135ec8(element, body);
                            } else if (element.getAttribute("name").equalsIgnoreCase("f_c11a6ab")) {
                                insertTFc11a6ab(element, body);
                            } else if (element.getAttribute("name").equalsIgnoreCase("f_61fcfd3")) {
                                insertTF61fcfd3(element, body);
                            } else if (element.getAttribute("name").equalsIgnoreCase("f_61ae463")) {
                                insertTF61ae463(element, body);
                            } else if (element.getAttribute("name").equalsIgnoreCase("f_519e6cd")) {
                                insertTF519e6cd(element, body);
                            } else if (element.getAttribute("name").equalsIgnoreCase("f_715a73f")) {
                                insertTF715a73f(element, body);
                            } else if (element.getAttribute("name").equalsIgnoreCase("f_c1bcdf1")) {
                                insertTFC1bcdf1(element, body);
                            } else if (element.getAttribute("name").equalsIgnoreCase("f_e158ee0")) {
                                insertTFe158ee0(element, body);
                            } else if (element.getAttribute("name").equalsIgnoreCase("f_c19311b")) {
                                insertTFc19311b(element, body);
                            } else if (element.getAttribute("name").equalsIgnoreCase("f_d1970ba")) {
                                insertTFd1970ba(element, body);
                            } else if (element.getAttribute("name").equalsIgnoreCase("f_81eed8d")) {
                                insertTF81eed8d(element, body);
                            } else if (element.getAttribute("name").equalsIgnoreCase("f_b1a3034")) {
                                insertTFb1a3034(element, body);
                            } else if (element.getAttribute("name").equalsIgnoreCase("f_31fc45f")) {
                                insertTF31fc45f(element, body);
                            } else if (element.getAttribute("name").equalsIgnoreCase("f_1119b0f")) {
                                insertTF1119b0f(element, body);
                            }
                        }
                    }
                }
            }
        }
    }


    /**
     * @param element;
     * @param body;
     * @desc f_1119b0f;
     */
    private void insertTF1119b0f(Element element, TDocumentBody body) {
        NodeList list = element.getChildNodes();
        for (int j = 0; j < list.getLength(); j++) {
            Element main = (Element) list.item(j);
            if (main.getFirstChild() != null) {
                TF1119b0f tStructure = new TF1119b0f();
                tStructure.setTDocumentBody(body);
                tStructure.setStructureId(main.getAttribute("id"));
                tStructure.setStructureValue(main.getFirstChild().getNodeValue());
                tf1119b0fRepository.saveAndFlush(tStructure);
            }
        }
    }

    /**
     * @param element;
     * @param body;
     * @desc f_31fc45f;
     */
    private void insertTF31fc45f(Element element, TDocumentBody body) {
        NodeList list = element.getChildNodes();
        for (int j = 0; j < list.getLength(); j++) {
            Element main = (Element) list.item(j);
            if (main.getFirstChild() != null) {
                TF31fc45f tStructure = new TF31fc45f();
                tStructure.setTDocumentBody(body);
                tStructure.setStructureId(main.getAttribute("id"));
                tStructure.setStructureValue(main.getFirstChild().getNodeValue());
                tf31fc45fRepository.saveAndFlush(tStructure);
            }
        }
    }

    /**
     * @param element;
     * @param body;
     * @desc f_b1a3034;
     */
    private void insertTFb1a3034(Element element, TDocumentBody body) {
        NodeList list = element.getChildNodes();
        for (int j = 0; j < list.getLength(); j++) {
            Element main = (Element) list.item(j);
            if (main.getFirstChild() != null) {
                TFb1a3034 tStructure = new TFb1a3034();
                tStructure.setTDocumentBody(body);
                tStructure.setStructureId(main.getAttribute("id"));
                tStructure.setStructureValue(main.getFirstChild().getNodeValue());
                tFb1a3034Repository.saveAndFlush(tStructure);
            }
        }
    }

    /**
     * @param element;
     * @param body;
     * @desc f_81eed8d;
     */
    private void insertTF81eed8d(Element element, TDocumentBody body) {
        NodeList list = element.getChildNodes();
        for (int j = 0; j < list.getLength(); j++) {
            Element main = (Element) list.item(j);
            if (main.getFirstChild() != null) {
                TF81eed8d tStructure = new TF81eed8d();
                tStructure.setTDocumentBody(body);
                tStructure.setStructureId(main.getAttribute("id"));
                tStructure.setStructureValue(main.getFirstChild().getNodeValue());
                tf81eed8dRepository.saveAndFlush(tStructure);
            }
        }
    }

    /**
     * @param element;
     * @param body;
     * @desc f_d1970ba;
     */
    private void insertTFd1970ba(Element element, TDocumentBody body) {
        NodeList list = element.getChildNodes();
        for (int j = 0; j < list.getLength(); j++) {
            Element main = (Element) list.item(j);
            if (main.getFirstChild() != null) {
                TFd1970ba tStructure = new TFd1970ba();
                tStructure.setTDocumentBody(body);
                tStructure.setStructureId(main.getAttribute("id"));
                tStructure.setStructureValue(main.getFirstChild().getNodeValue());
                tFd1970baRepository.saveAndFlush(tStructure);
            }
        }
    }

    /**
     * @param element;
     * @param body;
     * @desc f_c19311b;
     */
    private void insertTFc19311b(Element element, TDocumentBody body) {
        NodeList list = element.getChildNodes();
        for (int j = 0; j < list.getLength(); j++) {
            Element main = (Element) list.item(j);
            if (main.getFirstChild() != null) {
                TFc19311b tStructure = new TFc19311b();
                tStructure.setTDocumentBody(body);
                tStructure.setStructureId(main.getAttribute("id"));
                tStructure.setStructureValue(main.getFirstChild().getNodeValue());
                tFc19311bRepository.saveAndFlush(tStructure);
            }
        }
    }

    /**
     * @param element;
     * @param body;
     * @desc f_e158ee0;
     */
    private void insertTFe158ee0(Element element, TDocumentBody body) {
        NodeList list = element.getChildNodes();
        for (int j = 0; j < list.getLength(); j++) {
            Element main = (Element) list.item(j);
            if (main.getFirstChild() != null) {
                TFe158ee0 tStructure = new TFe158ee0();
                tStructure.setTDocumentBody(body);
                tStructure.setStructureId(main.getAttribute("id"));
                tStructure.setStructureValue(main.getFirstChild().getNodeValue());
                tFe158ee0Repository.saveAndFlush(tStructure);
            }
        }
    }

    /**
     * @param element;
     * @param body;
     * @desc f_c1bcdf1;
     */
    private void insertTFC1bcdf1(Element element, TDocumentBody body) {
        NodeList list = element.getChildNodes();
        for (int j = 0; j < list.getLength(); j++) {
            Element main = (Element) list.item(j);
            if (main.getFirstChild() != null) {
                TFC1bcdf1 tStructure = new TFC1bcdf1();
                tStructure.setTDocumentBody(body);
                tStructure.setStructureId(main.getAttribute("id"));
                tStructure.setStructureValue(main.getFirstChild().getNodeValue());
                tfc1bcdf1Repository.saveAndFlush(tStructure);
            }
        }
    }

    /**
     * @param element;
     * @param body;
     * @desc f_715a73f;
     */
    private void insertTF715a73f(Element element, TDocumentBody body) {
        NodeList list = element.getChildNodes();
        for (int j = 0; j < list.getLength(); j++) {
            Element main = (Element) list.item(j);
            if (main.getFirstChild() != null) {
                TF715a73f tStructure = new TF715a73f();
                tStructure.setTDocumentBody(body);
                tStructure.setStructureId(main.getAttribute("id"));
                tStructure.setStructureValue(main.getFirstChild().getNodeValue());
                tf715a73fRepository.saveAndFlush(tStructure);
            }
        }
    }

    /**
     * @param element;
     * @param body;
     * @desc f_519e6cd;
     */
    private void insertTF519e6cd(Element element, TDocumentBody body) {
        NodeList list = element.getChildNodes();
        for (int j = 0; j < list.getLength(); j++) {
            Element main = (Element) list.item(j);
            if (main.getFirstChild() != null) {
                TF519e6cd tStructure = new TF519e6cd();
                tStructure.setTDocumentBody(body);
                tStructure.setStructureId(main.getAttribute("id"));
                tStructure.setStructureValue(main.getFirstChild().getNodeValue());
                tf519e6cdRepository.saveAndFlush(tStructure);
            }
        }
    }

    /**
     * @param element;
     * @param body;
     * @desc f_61ae463;
     */
    private void insertTF61ae463(Element element, TDocumentBody body) {
        NodeList list = element.getChildNodes();
        for (int j = 0; j < list.getLength(); j++) {
            Element main = (Element) list.item(j);
            if (main.getFirstChild() != null) {
                TF61ae463 tStructure = new TF61ae463();
                tStructure.setTDocumentBody(body);
                tStructure.setStructureId(main.getAttribute("id"));
                tStructure.setStructureValue(main.getFirstChild().getNodeValue());
                tf61ae463Repository.saveAndFlush(tStructure);
            }
        }
    }

    /**
     * @param element;
     * @param body;
     * @desc f_61fcfd3;
     */
    private void insertTF61fcfd3(Element element, TDocumentBody body) {
        NodeList list = element.getChildNodes();
        for (int j = 0; j < list.getLength(); j++) {
            Element main = (Element) list.item(j);
            if (main.getFirstChild() != null) {
                TF61fcfd3 tStructure = new TF61fcfd3();
                tStructure.setTDocumentBody(body);
                tStructure.setStructureId(main.getAttribute("id"));
                tStructure.setStructureValue(main.getFirstChild().getNodeValue());
                tf61fcfd3Repository.saveAndFlush(tStructure);
            }
        }
    }

    /**
     * @param element;
     * @param body;
     * @desc f_c11a6ab;
     */
    private void insertTFc11a6ab(Element element, TDocumentBody body) {
        NodeList list = element.getChildNodes();
        for (int j = 0; j < list.getLength(); j++) {
            Element main = (Element) list.item(j);
            if (main.getFirstChild() != null) {
                TFc11a6ab tStructure = new TFc11a6ab();
                tStructure.setTDocumentBody(body);
                tStructure.setStructureId(main.getAttribute("id"));
                tStructure.setStructureValue(main.getFirstChild().getNodeValue());
                tFc11a6abRepository.saveAndFlush(tStructure);
            }
        }
    }

    /**
     * @param element;
     * @param body;
     * @desc f_6135ec8;
     */
    private void insertTF6135ec8(Element element, TDocumentBody body) {
        NodeList list = element.getChildNodes();
        for (int j = 0; j < list.getLength(); j++) {
            Element main = (Element) list.item(j);
            if (main.getFirstChild() != null) {
                TF6135ec8 tStructure = new TF6135ec8();
                tStructure.setTDocumentBody(body);
                tStructure.setStructureId(main.getAttribute("id"));
                tStructure.setStructureValue(main.getFirstChild().getNodeValue());
                tf6135ec8Repository.saveAndFlush(tStructure);
            }
        }
    }

    /**
     * @param element;
     * @param body;
     * @desc f_d151227;
     */
    private void insertTFd151227(Element element, TDocumentBody body) {
        NodeList list = element.getChildNodes();
        for (int j = 0; j < list.getLength(); j++) {
            Element main = (Element) list.item(j);
            if (main.getFirstChild() != null) {
                TFd151227 tStructure = new TFd151227();
                tStructure.setTDocumentBody(body);
                tStructure.setStructureId(main.getAttribute("id"));
                tStructure.setStructureValue(main.getFirstChild().getNodeValue());
                tFd151227Repository.saveAndFlush(tStructure);
            }
        }
    }

    /**
     * @param element;
     * @param body;
     * @desc f_c13b7f0;
     */
    private void insertTFc13b7f0(Element element, TDocumentBody body) {
        NodeList list = element.getChildNodes();
        for (int j = 0; j < list.getLength(); j++) {
            Element main = (Element) list.item(j);
            if (main.getFirstChild() != null) {
                TFc13b7f0 tStructure = new TFc13b7f0();
                tStructure.setTDocumentBody(body);
                tStructure.setStructureId(main.getAttribute("id"));
                tStructure.setStructureValue(main.getFirstChild().getNodeValue());
                tFc13b7f0Repository.saveAndFlush(tStructure);
            }
        }
    }

    /**
     * @param element;
     * @param body;
     * @desc f_a1cd4ff;
     */
    private void insertTFa1cd4ff(Element element, TDocumentBody body) {
        NodeList list = element.getChildNodes();
        for (int j = 0; j < list.getLength(); j++) {
            Element main = (Element) list.item(j);
            if (main.getFirstChild() != null) {
                TFa1cd4ff tStructure = new TFa1cd4ff();
                tStructure.setTDocumentBody(body);
                tStructure.setStructureId(main.getAttribute("id"));
                tStructure.setStructureValue(main.getFirstChild().getNodeValue());
                tFa1cd4ffRepository.saveAndFlush(tStructure);
            }
        }
    }

    /**
     * @param element;
     * @param body;
     * @desc f_41830e9;
     */
    private void insertTF41830e9(Element element, TDocumentBody body) {
        NodeList list = element.getChildNodes();
        for (int j = 0; j < list.getLength(); j++) {
            Element main = (Element) list.item(j);
            if (main.getFirstChild() != null) {
                TF41830e9 tStructure = new TF41830e9();
                tStructure.setTDocumentBody(body);
                tStructure.setStructureId(main.getAttribute("id"));
                tStructure.setStructureValue(main.getFirstChild().getNodeValue());
                tf41830e9Repository.saveAndFlush(tStructure);
            }
        }
    }

    /**
     * @param element;
     * @param body;
     * @desc f_2149883;
     */
    private void insertTF2149883(Element element, TDocumentBody body) {
        NodeList list = element.getChildNodes();
        for (int j = 0; j < list.getLength(); j++) {
            Element main = (Element) list.item(j);
            if (main.getFirstChild() != null) {
                TF2149883 tStructure = new TF2149883();
                tStructure.setTDocumentBody(body);
                tStructure.setStructureId(main.getAttribute("id"));
                tStructure.setStructureValue(main.getFirstChild().getNodeValue());
                tf2149883Repository.saveAndFlush(tStructure);
            }
        }
    }

    /**
     * @param element;
     * @param body;
     * @desc f_31b92ad;
     */
    private void insertTF31b92ad(Element element, TDocumentBody body) {
        NodeList list = element.getChildNodes();
        for (int j = 0; j < list.getLength(); j++) {
            Element main = (Element) list.item(j);
            if (main.getFirstChild() != null) {
                TF31b92ad tStructure = new TF31b92ad();
                tStructure.setTDocumentBody(body);
                tStructure.setStructureId(main.getAttribute("id"));
                tStructure.setStructureValue(main.getFirstChild().getNodeValue());
                tf31b92adRepository.saveAndFlush(tStructure);
            }
        }
    }

    /**
     * @param element;
     * @param body;
     * @desc f_0190180;
     */
    private void insertTF0190180(Element element, TDocumentBody body) {
        NodeList list = element.getChildNodes();
        for (int j = 0; j < list.getLength(); j++) {
            Element main = (Element) list.item(j);
            if (main.getFirstChild() != null) {
                TF0190180 tStructure = new TF0190180();
                tStructure.setTDocumentBody(body);
                tStructure.setStructureId(main.getAttribute("id"));
                tStructure.setStructureValue(main.getFirstChild().getNodeValue());
                tf0190180Repository.saveAndFlush(tStructure);
            }
        }
    }

    /**
     * @param element;
     * @param body;
     * @desc f_2130062;
     */
    private void insertTF2130062(Element element, TDocumentBody body) {
        NodeList list = element.getChildNodes();
        for (int j = 0; j < list.getLength(); j++) {
            Element main = (Element) list.item(j);
            if (main.getFirstChild() != null) {
                TF2130062 tStructure = new TF2130062();
                tStructure.setTDocumentBody(body);
                tStructure.setStructureId(main.getAttribute("id"));
                tStructure.setStructureValue(main.getFirstChild().getNodeValue());
                tf2130062Repository.saveAndFlush(tStructure);
            }
        }
    }

    /**
     * @param element;
     * @param body;
     * @desc f_f1d8b64;
     */
    private void insertTF1168c6f(Element element, TDocumentBody body) {
        NodeList list = element.getChildNodes();
        for (int j = 0; j < list.getLength(); j++) {
            Element main = (Element) list.item(j);
            if (main.getFirstChild() != null) {
                TF1168c6f tStructure = new TF1168c6f();
                tStructure.setTDocumentBody(body);
                tStructure.setStructureId(main.getAttribute("id"));
                tStructure.setStructureValue(main.getFirstChild().getNodeValue());
                tf1168c6fRepository.saveAndFlush(tStructure);
            }
        }
    }

    /**
     * @param element;
     * @param body;
     * @desc f_f1d8b64;
     */
    private void insertTF21e81a6(Element element, TDocumentBody body) {
        NodeList list = element.getChildNodes();
        for (int j = 0; j < list.getLength(); j++) {
            Element main = (Element) list.item(j);
            if (main.getFirstChild() != null) {
                TF21e81a6 tStructure = new TF21e81a6();
                tStructure.setTDocumentBody(body);
                tStructure.setStructureId(main.getAttribute("id"));
                tStructure.setStructureValue(main.getFirstChild().getNodeValue());
                tf21e81a6Repository.saveAndFlush(tStructure);
            }
        }
    }

    /**
     * @param element;
     * @param body;
     * @desc f_f1d8b64;
     */
    private void insertTF31dc56b(Element element, TDocumentBody body) {
        NodeList list = element.getChildNodes();
        for (int j = 0; j < list.getLength(); j++) {
            Element main = (Element) list.item(j);
            if (main.getFirstChild() != null) {
                TF31dc56b tStructure = new TF31dc56b();
                tStructure.setTDocumentBody(body);
                tStructure.setStructureId(main.getAttribute("id"));
                tStructure.setStructureValue(main.getFirstChild().getNodeValue());
                tf31dc56bRepository.saveAndFlush(tStructure);
            }
        }
    }

    /**
     * @param element;
     * @param body;
     * @desc f_f1d8b64;
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
     * @param element;
     * @param body;
     * @desc f_b12e0d5;
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
     * @param element;
     * @param body;
     * @desc f_b1fab9a;
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
     * @param element;
     * @param body;
     * @desc f_31f8f7c;
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
     * @param element;
     * @param body;
     * @desc F_519145b;
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
     * @param element;
     * @param body;
     * @desc f_d1c5f7d;
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
     * @param element;
     * @param body;
     * @desc f_2190030;
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
     * @param element;
     * @param body;
     * @desc f_d1193e2;
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
     * @param element;
     * @param body;
     * @desc f_215b2e9;
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
     * @param element;
     * @param body;
     * @desc f_11d6328;
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
     * @param element;
     * @param body;
     * @desc f_d180879;
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
     * @param element;
     * @param body;
     * @desc f_6117ead;
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
     * @param element;
     * @param body;
     * @desc f_d1107e3;
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
     * @param element;
     * @param body;
     * @desc f_f130ae4;
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
     * @param element;
     * @param body;
     * @desc f_01692fa;
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
