package kz.kazimpex.parserxml;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;

import static com.google.common.base.Strings.isNullOrEmpty;

public class MainParser {

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

    public static void main(String[] args) throws Exception {
        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        DocumentBuilder db = dbf.newDocumentBuilder();
        Document document = db.parse(new File("xml/1.xml"));

        String id, redactionId, doctypeId;

        Element root = document.getDocumentElement();
        //TODO создаем root элемент
        id = getValueByName(root, "id");
        redactionId = getValueByName(root, "redaction_id");
        doctypeId = getValueByName(root, "doctype_id");


        NodeList nodeList = root.getElementsByTagName("item");

        System.out.println(nodeList.getLength());

        for (int x = 0, size = nodeList.getLength(); x < size; x++) {
            NodeList subList = nodeList.item(x).getChildNodes();

            if (subList != null && subList.item(x) != null) {
                System.out.println(subList.item(x).getNodeValue());
            }
            System.out.println(getValueByNameAndIterator(nodeList, x, "name"));
            System.out.println(getValueByNameAndIterator(nodeList, x, "title"));
        }

        nodeList = root.getElementsByTagName("itemslist");

        System.out.println(nodeList.getLength());

        for (int x = 0, size = nodeList.getLength(); x < size; x++) {
            NodeList subList = nodeList.item(x).getChildNodes();

            if (subList != null && subList.item(x) != null) {
                System.out.println(subList.item(x).getNodeValue());
            }
            System.out.println(getValueByNameAndIterator(nodeList, x, "name"));
            System.out.println(getValueByNameAndIterator(nodeList, x, "title"));
        }
    }
}
