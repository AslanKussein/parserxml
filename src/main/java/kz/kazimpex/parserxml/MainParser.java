package kz.kazimpex.parserxml;

import kz.kazimpex.parserxml.jpa.domain.*;
import kz.kazimpex.parserxml.jpa.repository.*;
import lombok.var;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
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
    @Autowired
    TF41da707Repository tf41da707Repository;
    @Autowired
    Tff1669daRepository tff1669daRepository;
    @Autowired
    Tf118f49dRepository tf118f49dRepository;
    @Autowired
    TF61741ceRepository tf61741ceRepository;
    @Autowired
    Tf112b79cRepository tf112b79cRepository;
    @Autowired
    Tfa1b73a8Repository tfa1b73a8Repository;
    @Autowired
    Tfd1f8a37Repository tfd1f8a37Repository;
    @Autowired
    Tfc12cfacRepository tfc12cfacRepository;
    @Autowired
    Tf31e6165Repository tf31e6165Repository;
    @Autowired
    Tfd1ffcfdRepository tfd1ffcfdRepository;
    @Autowired
    Tf1143df2Repository tf1143df2Repository;
    @Autowired
    Tf2155892Repository tf2155892Repository;
    @Autowired
    Tfc1b334dRepository tfc1b334dRepository;
    @Autowired
    Tfa17ec5cRepository tfa17ec5cRepository;
    @Autowired
    TffiostructureRepository tffiostructureRepository;
    @Autowired
    Tff17ee32Repository tff17ee32Repository;
    @Autowired
    Tf81e7eceRepository tf81e7eceRepository;
    @Autowired
    Tf41ae2b2Repository tf41ae2b2Repository;
    @Autowired
    Tf01f4217Repository tf01f4217Repository;
    @Autowired
    Tfc1a5f64Repository tfc1a5f64Repository;
    @Autowired
    Tfe1f4c72Repository tfe1f4c72Repository;
    @Autowired
    Tfe134017Repository tfe134017Repository;
    @Autowired
    Tf017ea0eRepository tf017ea0eRepository;
    @Autowired
    Tfa1bbbd0Repository tfa1bbbd0Repository;
    @Autowired
    Tfc1d356eRepository tfc1d356eRepository;
    @Autowired
    Tf_516d040Repository tf_516d040Repository;
    @Autowired
    Tf_41dee64Repository tf_41dee64Repository;
    @Autowired
    Tf_51dcb50Repository tf_51dcb50Repository;
    @Autowired
    Tf_b12220bRepository tf_b12220bRepository;
    @Autowired
    Tf_415a5b5Repository tf_415a5b5Repository;
    @Autowired
    Tf_e18f309Repository tf_e18f309Repository;

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

    //    @Transactional(rollbackFor = Exception.class)
    public void run() throws Exception {
//        String path = "c78dcb38-5b95-49e6-bb1e-5a9006f00076.xml";

//        File folder = new File("C:\\Users\\a.kusein\\Desktop\\xml_2018_February\\Исходящий документ\\");
//        File folder = new File("C:\\Users\\a.kusein\\Desktop\\xml_2018_February\\Обращения юридических лиц");
        File folder = new File("C:\\Users\\a.kusein\\Desktop\\xml_2018_February\\Исходящий документ");
//        File folder = new File("C:\\Users\\a.kusein\\Desktop\\xml_2018_February\\test\\\\");
        File[] listOfFiles = folder.listFiles();
        var k = 0;
        assert listOfFiles != null;
        for (File file : listOfFiles) {
            k += 1;
            parseData(file, k);
        }
        System.out.println("done");
    }

    private void parseData(File file, int l) throws Exception {
        if (file.isFile()) {
            System.out.println(l + " " + file.getName());
            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
            DocumentBuilder db = dbf.newDocumentBuilder();
            Document document = db.parse(file);
            TDocumentRoot root2 = tDocumentRootRepository.findByXmlId(file.getName().replace(".xml", ""));
            if (root2 != null) {
                return;
            }


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
                            } else if (element.getAttribute("name").equalsIgnoreCase("f_41da707")) {
                                insertTF41da707(element, body);
                            } else if (element.getAttribute("name").equalsIgnoreCase("f_f1669da")) {
                                insertTff1669da(element, body);
                            } else if (element.getAttribute("name").equalsIgnoreCase("f_118f49d")) {
                                insertTf118f49d(element, body);
                            } else if (element.getAttribute("name").equalsIgnoreCase("f_61741ce")) {
                                insertTF61741ce(element, body);
                            } else if (element.getAttribute("name").equalsIgnoreCase("f_112b79c")) {
                                insertTf112b79c(element, body);
                            } else if (element.getAttribute("name").equalsIgnoreCase("f_a1b73a8")) {
                                insertTfa1b73a8(element, body);
                            } else if (element.getAttribute("name").equalsIgnoreCase("f_d1f8a37")) {
                                insertTfd1f8a37(element, body);
                            } else if (element.getAttribute("name").equalsIgnoreCase("f_c12cfac")) {
                                insertTfc12cfac(element, body);
                            } else if (element.getAttribute("name").equalsIgnoreCase("f_31e6165")) {
                                insertTf31e6165(element, body);
                            } else if (element.getAttribute("name").equalsIgnoreCase("f_d1ffcfd")) {
                                insertTfd1ffcfd(element, body);
                            } else if (element.getAttribute("name").equalsIgnoreCase("f_1143df2")) {
                                insertTf1143df2(element, body);
                            } else if (element.getAttribute("name").equalsIgnoreCase("f_2155892")) {
                                insertTf2155892(element, body);
                            } else if (element.getAttribute("name").equalsIgnoreCase("f_c1b334d")) {
                                insertTfc1b334d(element, body);
                            } else if (element.getAttribute("name").equalsIgnoreCase("f_a17ec5c")) {
                                insertTfa17ec5c(element, body);
                            } else if (element.getAttribute("name").equalsIgnoreCase("f_fiostructure")) {
                                insertTffiostructure(element, body);
                            } else if (element.getAttribute("name").equalsIgnoreCase("f_f17ee32")) {
                                insertTff17ee32(element, body);
                            } else if (element.getAttribute("name").equalsIgnoreCase("f_81e7ece")) {
                                insertTf81e7ece(element, body);
                            } else if (element.getAttribute("name").equalsIgnoreCase("f_41ae2b2")) {
                                insertTf41ae2b2(element, body);
                            } else if (element.getAttribute("name").equalsIgnoreCase("f_01f4217")) {
                                insertTf01f4217(element, body);
                            } else if (element.getAttribute("name").equalsIgnoreCase("f_01f4217")) {
                                insertTfc1a5f64(element, body);
                            } else if (element.getAttribute("name").equalsIgnoreCase("f_c1a5f64")) {
                                insertTfc1a5f64(element, body);
                            } else if (element.getAttribute("name").equalsIgnoreCase("f_e1f4c72")) {
                                insertTfe1f4c72(element, body);
                            } else if (element.getAttribute("name").equalsIgnoreCase("f_e134017")) {
                                insertTfe134017(element, body);
                            } else if (element.getAttribute("name").equalsIgnoreCase("f_017ea0e")) {
                                insertTf017ea0e(element, body);
                            } else if (element.getAttribute("name").equalsIgnoreCase("f_a1bbbd0")) {
                                insertTfa1bbbd0(element, body);
                            } else if (element.getAttribute("name").equalsIgnoreCase("f_c1d356e")) {
                                insertTfc1d356e(element, body);
                            } else if (element.getAttribute("name").equalsIgnoreCase("f_516d040")) {
                                insertTf_516d040(element, body);
                            } else if (element.getAttribute("name").equalsIgnoreCase("f_41dee64")) {
                                insertTf_41dee64(element, body);
                            } else if (element.getAttribute("name").equalsIgnoreCase("f_51dcb50")) {
                                insertTf_51dcb50(element, body);
                            } else if (element.getAttribute("name").equalsIgnoreCase("f_b12220b")) {
                                insertTf_b12220b(element, body);
                            } else if (element.getAttribute("name").equalsIgnoreCase("f_415a5b5")) {
                                insertTf_415a5b5(element, body);
                            } else if (element.getAttribute("name").equalsIgnoreCase("f_e18f309")) {
                                insertTf_e18f309(element, body);
                            } else if (element.getAttribute("name").equalsIgnoreCase("f_418ba99")) {
                                insertTf_418ba99(element, body);
                            }else if (element.getAttribute("name").equalsIgnoreCase("f_e14fb61")) {
                                insertTf_e14fb61(element, body);
                            }else if (element.getAttribute("name").equalsIgnoreCase("f_a176820")) {
                                insertTf_a176820(element, body);
                            }else if (element.getAttribute("name").equalsIgnoreCase("f_11ef657")) {
                                insertTf_11ef657(element, body);
                            }
                        }
                    }
                }
            }
        }
    }

    @Autowired
    Tf_418ba99Repository tf_418ba99Repository;
    @Autowired
    Tf_e14fb61Repository tf_e14fb61Repository;
    @Autowired
    Tf_a176820Repository tf_a176820Repository;
    @Autowired
    Tf_11ef657Repository tf_11ef657Repository;

    /**
     * @param element;
     * @param body;
     * @desc f_11ef657;
     */
    private void insertTf_11ef657(Element element, TDocumentBody body) {
        NodeList list = element.getChildNodes();
        for (int j = 0; j < list.getLength(); j++) {
            Element main = (Element) list.item(j);
            if (main.getFirstChild() != null) {
                Tf_11ef657 tStructure = new Tf_11ef657();
                tStructure.setTDocumentBody(body);
                tStructure.setStructureId(main.getAttribute("id"));
                tStructure.setStructureValue(main.getFirstChild().getNodeValue());
                tf_11ef657Repository.saveAndFlush(tStructure);
            }
        }
    }

    /**
     * @param element;
     * @param body;
     * @desc f_a176820;
     */
    private void insertTf_a176820(Element element, TDocumentBody body) {
        NodeList list = element.getChildNodes();
        for (int j = 0; j < list.getLength(); j++) {
            Element main = (Element) list.item(j);
            if (main.getFirstChild() != null) {
                Tf_a176820 tStructure = new Tf_a176820();
                tStructure.setTDocumentBody(body);
                tStructure.setStructureId(main.getAttribute("id"));
                tStructure.setStructureValue(main.getFirstChild().getNodeValue());
                tf_a176820Repository.saveAndFlush(tStructure);
            }
        }
    }

    /**
     * @param element;
     * @param body;
     * @desc f_418ba99;
     */
    private void insertTf_418ba99(Element element, TDocumentBody body) {
        NodeList list = element.getChildNodes();
        for (int j = 0; j < list.getLength(); j++) {
            Element main = (Element) list.item(j);
            if (main.getFirstChild() != null) {
                Tf_418ba99 tStructure = new Tf_418ba99();
                tStructure.setTDocumentBody(body);
                tStructure.setStructureId(main.getAttribute("id"));
                tStructure.setStructureValue(main.getFirstChild().getNodeValue());
                tf_418ba99Repository.saveAndFlush(tStructure);
            }
        }
    }

    /**
     * @param element;
     * @param body;
     * @desc f_e14fb61;
     */
    private void insertTf_e14fb61(Element element, TDocumentBody body) {
        NodeList list = element.getChildNodes();
        for (int j = 0; j < list.getLength(); j++) {
            Element main = (Element) list.item(j);
            if (main.getFirstChild() != null) {
                Tf_e14fb61 tStructure = new Tf_e14fb61();
                tStructure.setTDocumentBody(body);
                tStructure.setStructureId(main.getAttribute("id"));
                tStructure.setStructureValue(main.getFirstChild().getNodeValue());
                tf_e14fb61Repository.saveAndFlush(tStructure);
            }
        }
    }

    /**
     * @param element;
     * @param body;
     * @desc f_e18f309;
     */
    private void insertTf_e18f309(Element element, TDocumentBody body) {
        NodeList list = element.getChildNodes();
        for (int j = 0; j < list.getLength(); j++) {
            Element main = (Element) list.item(j);
            if (main.getFirstChild() != null) {
                Tf_e18f309 tStructure = new Tf_e18f309();
                tStructure.setTDocumentBody(body);
                tStructure.setStructureId(main.getAttribute("id"));
                tStructure.setStructureValue(main.getFirstChild().getNodeValue());
                tf_e18f309Repository.saveAndFlush(tStructure);
            }
        }
    }

    /**
     * @param element;
     * @param body;
     * @desc f_415a5b5;
     */
    private void insertTf_415a5b5(Element element, TDocumentBody body) {
        NodeList list = element.getChildNodes();
        for (int j = 0; j < list.getLength(); j++) {
            Element main = (Element) list.item(j);
            if (main.getFirstChild() != null) {
                Tf_415a5b5 tStructure = new Tf_415a5b5();
                tStructure.setTDocumentBody(body);
                tStructure.setStructureId(main.getAttribute("id"));
                tStructure.setStructureValue(main.getFirstChild().getNodeValue());
                tf_415a5b5Repository.saveAndFlush(tStructure);
            }
        }
    }

    /**
     * @param element;
     * @param body;
     * @desc f_b12220b;
     */
    private void insertTf_b12220b(Element element, TDocumentBody body) {
        NodeList list = element.getChildNodes();
        for (int j = 0; j < list.getLength(); j++) {
            Element main = (Element) list.item(j);
            if (main.getFirstChild() != null) {
                Tf_b12220b tStructure = new Tf_b12220b();
                tStructure.setTDocumentBody(body);
                tStructure.setStructureId(main.getAttribute("id"));
                tStructure.setStructureValue(main.getFirstChild().getNodeValue());
                tf_b12220bRepository.saveAndFlush(tStructure);
            }
        }
    }

    /**
     * @param element;
     * @param body;
     * @desc f_51dcb50;
     */
    private void insertTf_51dcb50(Element element, TDocumentBody body) {
        NodeList list = element.getChildNodes();
        for (int j = 0; j < list.getLength(); j++) {
            Element main = (Element) list.item(j);
            if (main.getFirstChild() != null) {
                Tf_51dcb50 tStructure = new Tf_51dcb50();
                tStructure.setTDocumentBody(body);
                tStructure.setStructureId(main.getAttribute("id"));
                tStructure.setStructureValue(main.getFirstChild().getNodeValue());
                tf_51dcb50Repository.saveAndFlush(tStructure);
            }
        }
    }

    /**
     * @param element;
     * @param body;
     * @desc f_41dee64;
     */
    private void insertTf_41dee64(Element element, TDocumentBody body) {
        NodeList list = element.getChildNodes();
        for (int j = 0; j < list.getLength(); j++) {
            Element main = (Element) list.item(j);
            if (main.getFirstChild() != null) {
                Tf_41dee64 tStructure = new Tf_41dee64();
                tStructure.setTDocumentBody(body);
                tStructure.setStructureId(main.getAttribute("id"));
                tStructure.setStructureValue(main.getFirstChild().getNodeValue());
                tf_41dee64Repository.saveAndFlush(tStructure);
            }
        }
    }

    /**
     * @param element;
     * @param body;
     * @desc f_516d040;
     */
    private void insertTf_516d040(Element element, TDocumentBody body) {
        NodeList list = element.getChildNodes();
        for (int j = 0; j < list.getLength(); j++) {
            Element main = (Element) list.item(j);
            if (main.getFirstChild() != null) {
                Tf_516d040 tStructure = new Tf_516d040();
                tStructure.setTDocumentBody(body);
                tStructure.setStructureId(main.getAttribute("id"));
                tStructure.setStructureValue(main.getFirstChild().getNodeValue());
                tf_516d040Repository.saveAndFlush(tStructure);
            }
        }
    }

    /**
     * @param element;
     * @param body;
     * @desc f_c1d356e;
     */
    private void insertTfc1d356e(Element element, TDocumentBody body) {
        NodeList list = element.getChildNodes();
        for (int j = 0; j < list.getLength(); j++) {
            Element main = (Element) list.item(j);
            if (main.getFirstChild() != null) {
                Tfc1d356e tStructure = new Tfc1d356e();
                tStructure.setTDocumentBody(body);
                tStructure.setStructureId(main.getAttribute("id"));
                tStructure.setStructureValue(main.getFirstChild().getNodeValue());
                tfc1d356eRepository.saveAndFlush(tStructure);
            }
        }
    }

    /**
     * @param element;
     * @param body;
     * @desc f_a1bbbd0;
     */
    private void insertTfa1bbbd0(Element element, TDocumentBody body) {
        NodeList list = element.getChildNodes();
        for (int j = 0; j < list.getLength(); j++) {
            Element main = (Element) list.item(j);
            if (main.getFirstChild() != null) {
                Tfa1bbbd0 tStructure = new Tfa1bbbd0();
                tStructure.setTDocumentBody(body);
                tStructure.setStructureId(main.getAttribute("id"));
                tStructure.setStructureValue(main.getFirstChild().getNodeValue());
                tfa1bbbd0Repository.saveAndFlush(tStructure);
            }
        }
    }

    /**
     * @param element;
     * @param body;
     * @desc f_017ea0e;
     */
    private void insertTf017ea0e(Element element, TDocumentBody body) {
        NodeList list = element.getChildNodes();
        for (int j = 0; j < list.getLength(); j++) {
            Element main = (Element) list.item(j);
            if (main.getFirstChild() != null) {
                Tf017ea0e tStructure = new Tf017ea0e();
                tStructure.setTDocumentBody(body);
                tStructure.setStructureId(main.getAttribute("id"));
                tStructure.setStructureValue(main.getFirstChild().getNodeValue());
                tf017ea0eRepository.saveAndFlush(tStructure);
            }
        }
    }

    /**
     * @param element;
     * @param body;
     * @desc f_e134017;
     */
    private void insertTfe134017(Element element, TDocumentBody body) {
        NodeList list = element.getChildNodes();
        for (int j = 0; j < list.getLength(); j++) {
            Element main = (Element) list.item(j);
            if (main.getFirstChild() != null) {
                Tfe134017 tStructure = new Tfe134017();
                tStructure.setTDocumentBody(body);
                tStructure.setStructureId(main.getAttribute("id"));
                tStructure.setStructureValue(main.getFirstChild().getNodeValue());
                tfe134017Repository.saveAndFlush(tStructure);
            }
        }
    }

    /**
     * @param element;
     * @param body;
     * @desc f_e1f4c72;
     */
    private void insertTfe1f4c72(Element element, TDocumentBody body) {
        NodeList list = element.getChildNodes();
        for (int j = 0; j < list.getLength(); j++) {
            Element main = (Element) list.item(j);
            if (main.getFirstChild() != null) {
                Tfe1f4c72 tStructure = new Tfe1f4c72();
                tStructure.setTDocumentBody(body);
                tStructure.setStructureId(main.getAttribute("id"));
                tStructure.setStructureValue(main.getFirstChild().getNodeValue());
                tfe1f4c72Repository.saveAndFlush(tStructure);
            }
        }
    }

    /**
     * @param element;
     * @param body;
     * @desc f_c1a5f64;
     */
    private void insertTfc1a5f64(Element element, TDocumentBody body) {
        NodeList list = element.getChildNodes();
        for (int j = 0; j < list.getLength(); j++) {
            Element main = (Element) list.item(j);
            if (main.getFirstChild() != null) {
                Tfc1a5f64 tStructure = new Tfc1a5f64();
                tStructure.setTDocumentBody(body);
                tStructure.setStructureId(main.getAttribute("id"));
                tStructure.setStructureValue(main.getFirstChild().getNodeValue());
                tfc1a5f64Repository.saveAndFlush(tStructure);
            }
        }
    }

    /**
     * @param element;
     * @param body;
     * @desc f_01f4217;
     */
    private void insertTf01f4217(Element element, TDocumentBody body) {
        NodeList list = element.getChildNodes();
        for (int j = 0; j < list.getLength(); j++) {
            Element main = (Element) list.item(j);
            if (main.getFirstChild() != null) {
                Tf01f4217 tStructure = new Tf01f4217();
                tStructure.setTDocumentBody(body);
                tStructure.setStructureId(main.getAttribute("id"));
                tStructure.setStructureValue(main.getFirstChild().getNodeValue());
                tf01f4217Repository.saveAndFlush(tStructure);
            }
        }
    }

    /**
     * @param element;
     * @param body;
     * @desc f_41ae2b2;
     */
    private void insertTf41ae2b2(Element element, TDocumentBody body) {
        NodeList list = element.getChildNodes();
        for (int j = 0; j < list.getLength(); j++) {
            Element main = (Element) list.item(j);
            if (main.getFirstChild() != null) {
                Tf41ae2b2 tStructure = new Tf41ae2b2();
                tStructure.setTDocumentBody(body);
                tStructure.setStructureId(main.getAttribute("id"));
                tStructure.setStructureValue(main.getFirstChild().getNodeValue());
                tf41ae2b2Repository.saveAndFlush(tStructure);
            }
        }
    }

    /**
     * @param element;
     * @param body;
     * @desc f_81e7ece;
     */
    private void insertTf81e7ece(Element element, TDocumentBody body) {
        NodeList list = element.getChildNodes();
        for (int j = 0; j < list.getLength(); j++) {
            Element main = (Element) list.item(j);
            if (main.getFirstChild() != null) {
                Tf81e7ece tStructure = new Tf81e7ece();
                tStructure.setTDocumentBody(body);
                tStructure.setStructureId(main.getAttribute("id"));
                tStructure.setStructureValue(main.getFirstChild().getNodeValue());
                tf81e7eceRepository.saveAndFlush(tStructure);
            }
        }
    }

    /**
     * @param element;
     * @param body;
     * @desc f_f17ee32;
     */
    private void insertTff17ee32(Element element, TDocumentBody body) {
        NodeList list = element.getChildNodes();
        for (int j = 0; j < list.getLength(); j++) {
            Element main = (Element) list.item(j);
            if (main.getFirstChild() != null) {
                Tff17ee32 tStructure = new Tff17ee32();
                tStructure.setTDocumentBody(body);
                tStructure.setStructureId(main.getAttribute("id"));
                tStructure.setStructureValue(main.getFirstChild().getNodeValue());
                tff17ee32Repository.saveAndFlush(tStructure);
            }
        }
    }

    /**
     * @param element;
     * @param body;
     * @desc f_fiostructure;
     */
    private void insertTffiostructure(Element element, TDocumentBody body) {
        NodeList list = element.getChildNodes();
        for (int j = 0; j < list.getLength(); j++) {
            Element main = (Element) list.item(j);
            if (main.getFirstChild() != null) {
                Tffiostructure tStructure = new Tffiostructure();
                tStructure.setTDocumentBody(body);
                tStructure.setStructureId(main.getAttribute("id"));
                tStructure.setStructureValue(main.getFirstChild().getNodeValue());
                tffiostructureRepository.saveAndFlush(tStructure);
            }
        }
    }

    /**
     * @param element;
     * @param body;
     * @desc f_a17ec5c;
     */
    private void insertTfa17ec5c(Element element, TDocumentBody body) {
        NodeList list = element.getChildNodes();
        for (int j = 0; j < list.getLength(); j++) {
            Element main = (Element) list.item(j);
            if (main.getFirstChild() != null) {
                Tfa17ec5c tStructure = new Tfa17ec5c();
                tStructure.setTDocumentBody(body);
                tStructure.setStructureId(main.getAttribute("id"));
                tStructure.setStructureValue(main.getFirstChild().getNodeValue());
                tfa17ec5cRepository.saveAndFlush(tStructure);
            }
        }
    }

    /**
     * @param element;
     * @param body;
     * @desc f_c1b334d;
     */
    private void insertTfc1b334d(Element element, TDocumentBody body) {
        NodeList list = element.getChildNodes();
        for (int j = 0; j < list.getLength(); j++) {
            Element main = (Element) list.item(j);
            if (main.getFirstChild() != null) {
                Tfc1b334d tStructure = new Tfc1b334d();
                tStructure.setTDocumentBody(body);
                tStructure.setStructureId(main.getAttribute("id"));
                tStructure.setStructureValue(main.getFirstChild().getNodeValue());
                tfc1b334dRepository.saveAndFlush(tStructure);
            }
        }
    }

    /**
     * @param element;
     * @param body;
     * @desc f_2155892;
     */
    private void insertTf2155892(Element element, TDocumentBody body) {
        NodeList list = element.getChildNodes();
        for (int j = 0; j < list.getLength(); j++) {
            Element main = (Element) list.item(j);
            if (main.getFirstChild() != null) {
                Tf2155892 tStructure = new Tf2155892();
                tStructure.setTDocumentBody(body);
                tStructure.setStructureId(main.getAttribute("id"));
                tStructure.setStructureValue(main.getFirstChild().getNodeValue());
                tf2155892Repository.saveAndFlush(tStructure);
            }
        }
    }

    /**
     * @param element;
     * @param body;
     * @desc f_1143df2;
     */
    private void insertTf1143df2(Element element, TDocumentBody body) {
        NodeList list = element.getChildNodes();
        for (int j = 0; j < list.getLength(); j++) {
            Element main = (Element) list.item(j);
            if (main.getFirstChild() != null) {
                Tf1143df2 tStructure = new Tf1143df2();
                tStructure.setTDocumentBody(body);
                tStructure.setStructureId(main.getAttribute("id"));
                tStructure.setStructureValue(main.getFirstChild().getNodeValue());
                tf1143df2Repository.saveAndFlush(tStructure);
            }
        }
    }

    /**
     * @param element;
     * @param body;
     * @desc f_d1ffcfd;
     */
    private void insertTfd1ffcfd(Element element, TDocumentBody body) {
        NodeList list = element.getChildNodes();
        for (int j = 0; j < list.getLength(); j++) {
            Element main = (Element) list.item(j);
            if (main.getFirstChild() != null) {
                Tfd1ffcfd tStructure = new Tfd1ffcfd();
                tStructure.setTDocumentBody(body);
                tStructure.setStructureId(main.getAttribute("id"));
                tStructure.setStructureValue(main.getFirstChild().getNodeValue());
                tfd1ffcfdRepository.saveAndFlush(tStructure);
            }
        }
    }

    /**
     * @param element;
     * @param body;
     * @desc f_31e6165;
     */
    private void insertTf31e6165(Element element, TDocumentBody body) {
        NodeList list = element.getChildNodes();
        for (int j = 0; j < list.getLength(); j++) {
            Element main = (Element) list.item(j);
            if (main.getFirstChild() != null) {
                Tf31e6165 tStructure = new Tf31e6165();
                tStructure.setTDocumentBody(body);
                tStructure.setStructureId(main.getAttribute("id"));
                tStructure.setStructureValue(main.getFirstChild().getNodeValue());
                tf31e6165Repository.saveAndFlush(tStructure);
            }
        }
    }

    /**
     * @param element;
     * @param body;
     * @desc f_c12cfac;
     */
    private void insertTfc12cfac(Element element, TDocumentBody body) {
        NodeList list = element.getChildNodes();
        for (int j = 0; j < list.getLength(); j++) {
            Element main = (Element) list.item(j);
            if (main.getFirstChild() != null) {
                Tfc12cfac tStructure = new Tfc12cfac();
                tStructure.setTDocumentBody(body);
                tStructure.setStructureId(main.getAttribute("id"));
                tStructure.setStructureValue(main.getFirstChild().getNodeValue());
                tfc12cfacRepository.saveAndFlush(tStructure);
            }
        }
    }

    /**
     * @param element;
     * @param body;
     * @desc f_d1f8a37;
     */
    private void insertTfd1f8a37(Element element, TDocumentBody body) {
        NodeList list = element.getChildNodes();
        for (int j = 0; j < list.getLength(); j++) {
            Element main = (Element) list.item(j);
            if (main.getFirstChild() != null) {
                Tfd1f8a37 tStructure = new Tfd1f8a37();
                tStructure.setTDocumentBody(body);
                tStructure.setStructureId(main.getAttribute("id"));
                tStructure.setStructureValue(main.getFirstChild().getNodeValue());
                tfd1f8a37Repository.saveAndFlush(tStructure);
            }
        }
    }

    /**
     * @param element;
     * @param body;
     * @desc f_a1b73a8;
     */
    private void insertTfa1b73a8(Element element, TDocumentBody body) {
        NodeList list = element.getChildNodes();
        for (int j = 0; j < list.getLength(); j++) {
            Element main = (Element) list.item(j);
            if (main.getFirstChild() != null) {
                Tfa1b73a8 tStructure = new Tfa1b73a8();
                tStructure.setTDocumentBody(body);
                tStructure.setStructureId(main.getAttribute("id"));
                tStructure.setStructureValue(main.getFirstChild().getNodeValue());
                tfa1b73a8Repository.saveAndFlush(tStructure);
            }
        }
    }

    /**
     * @param element;
     * @param body;
     * @desc f_112b79c;
     */
    private void insertTf112b79c(Element element, TDocumentBody body) {
        NodeList list = element.getChildNodes();
        for (int j = 0; j < list.getLength(); j++) {
            Element main = (Element) list.item(j);
            if (main.getFirstChild() != null) {
                Tf112b79c tStructure = new Tf112b79c();
                tStructure.setTDocumentBody(body);
                tStructure.setStructureId(main.getAttribute("id"));
                tStructure.setStructureValue(main.getFirstChild().getNodeValue());
                tf112b79cRepository.saveAndFlush(tStructure);
            }
        }
    }

    /**
     * @param element;
     * @param body;
     * @desc f_61741ce;
     */
    private void insertTF61741ce(Element element, TDocumentBody body) {
        NodeList list = element.getChildNodes();
        for (int j = 0; j < list.getLength(); j++) {
            Element main = (Element) list.item(j);
            if (main.getFirstChild() != null) {
                TF61741ce tStructure = new TF61741ce();
                tStructure.setTDocumentBody(body);
                tStructure.setStructureId(main.getAttribute("id"));
                tStructure.setStructureValue(main.getFirstChild().getNodeValue());
                tf61741ceRepository.saveAndFlush(tStructure);
            }
        }
    }

    /**
     * @param element;
     * @param body;
     * @desc f_41da707;
     */
    private void insertTf118f49d(Element element, TDocumentBody body) {
        NodeList list = element.getChildNodes();
        for (int j = 0; j < list.getLength(); j++) {
            Element main = (Element) list.item(j);
            if (main.getFirstChild() != null) {
                Tf118f49d tStructure = new Tf118f49d();
                tStructure.setTDocumentBody(body);
                tStructure.setStructureId(main.getAttribute("id"));
                tStructure.setStructureValue(main.getFirstChild().getNodeValue());
                tf118f49dRepository.saveAndFlush(tStructure);
            }
        }
    }

    /**
     * @param element;
     * @param body;
     * @desc f_41da707;
     */
    private void insertTff1669da(Element element, TDocumentBody body) {
        NodeList list = element.getChildNodes();
        for (int j = 0; j < list.getLength(); j++) {
            Element main = (Element) list.item(j);
            if (main.getFirstChild() != null) {
                Tff1669da tStructure = new Tff1669da();
                tStructure.setTDocumentBody(body);
                tStructure.setStructureId(main.getAttribute("id"));
                tStructure.setStructureValue(main.getFirstChild().getNodeValue());
                tff1669daRepository.saveAndFlush(tStructure);
            }
        }
    }

    /**
     * @param element;
     * @param body;
     * @desc f_41da707;
     */
    private void insertTF41da707(Element element, TDocumentBody body) {
        NodeList list = element.getChildNodes();
        for (int j = 0; j < list.getLength(); j++) {
            Element main = (Element) list.item(j);
            if (main.getFirstChild() != null) {
                TF41da707 tStructure = new TF41da707();
                tStructure.setTDocumentBody(body);
                tStructure.setStructureId(main.getAttribute("id"));
                tStructure.setStructureValue(main.getFirstChild().getNodeValue());
                tf41da707Repository.saveAndFlush(tStructure);
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
