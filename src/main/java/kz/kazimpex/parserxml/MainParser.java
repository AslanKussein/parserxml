package kz.kazimpex.parserxml;

import kz.kazimpex.parserxml.jpa.domain.TDocumentRoot;
import kz.kazimpex.parserxml.jpa.repository.TDocumentRootRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;

import static com.google.common.base.Strings.isNullOrEmpty;

@Service
public class MainParser{

    @Autowired
    TDocumentRootRepository tDocumentRootRepository;

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

    /***
     * @desc сохраняем root тег;
     * @param root;
     */
    private void insertRoot(Element root) throws Exception {
        TDocumentRoot tDocumentRoot = new TDocumentRoot();
        tDocumentRoot.setId(getValueByName(root, "id"));
        tDocumentRoot.setDoctypeId(getValueByName(root, "doctype_id"));
        tDocumentRoot.setRedactionId(getValueByName(root, "redaction_id"));
        tDocumentRootRepository.save(tDocumentRoot);
    }

    @Transactional
    public void run() throws Exception {


        String path = "C:\\Users\\a.kusein\\Desktop\\xml_2018_February\\Внутренний документ\\c78dcb38-5b95-49e6-bb1e-5a9006f00076.xml";

        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        DocumentBuilder db = dbf.newDocumentBuilder();
        Document document = db.parse(new File(path));


        Element root = document.getDocumentElement();

        insertRoot(root);



        NodeList nodeList = root.getElementsByTagName("item");

        System.out.println(nodeList.getLength());

        for (int x = 0, size = nodeList.getLength(); x < size; x++) {
            NodeList subList = nodeList.item(x).getChildNodes();

            if (subList != null && subList.item(x) != null) {
                System.out.println(subList.item(x).getNodeValue());
            }
            System.out.println(getValueByNameAndIterator(nodeList, x, "name"));
            System.out.println(getValueByNameAndIterator(nodeList, x, "title"));
            System.out.println(getValueByNameAndIterator(nodeList, x, "type"));
        }

//        nodeList = root.getElementsByTagName("itemslist");
//
//        System.out.println(nodeList.getLength());
//
//        for (int x = 0, size = nodeList.getLength(); x < size; x++) {
//            NodeList subList = nodeList.item(x).getChildNodes();
//
//            if (subList != null && subList.item(x) != null) {
//                System.out.println(subList.item(x).getNodeValue());
//            }
//            System.out.println(getValueByNameAndIterator(nodeList, x, "name"));
//            System.out.println(getValueByNameAndIterator(nodeList, x, "title"));
//        }
    }
}
