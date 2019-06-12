package kz.kazimpex.parserxml;

import kz.kazimpex.parserxml.jpa.domain.TDocumentBody;
import org.w3c.dom.Element;

public class ParserItemList {
    /**
     * @desc insert itemslist
     */
    public static void fullBodyItemlist(Element element, TDocumentBody body) throws Exception {

        if (element.getAttribute("name").equalsIgnoreCase("creator")) {

        } else if (element.getAttribute("name").equalsIgnoreCase("editor")) {

        } else if (element.getAttribute("name").equalsIgnoreCase("subdivision")) {

        } else if (element.getAttribute("name").equalsIgnoreCase("respondent")) {
            if (element.getFirstChild() != null) {
                if (element.getChildNodes().getLength() > 0) {
                    throw new Exception(element.getAttribute("name"));
                }
                body.setRespondent(element.getFirstChild().getAttributes().getNamedItem("id").getNodeValue());
            }
        } else if (element.getAttribute("name").equalsIgnoreCase("received_from_ws")) {
            if (element.getFirstChild() != null) {
                if (element.getChildNodes().getLength() > 0) {
                    throw new Exception(element.getAttribute("name"));
                }
                body.setReceivedFromWs(Boolean.valueOf(element.getFirstChild().getAttributes().getNamedItem("id").getNodeValue()));
            }
        } else if (element.getAttribute("name").equalsIgnoreCase("f_e19f9dc")) {
            if (element.getFirstChild() != null) {
                if (element.getChildNodes().getLength() > 0) {
                    throw new Exception(element.getAttribute("name"));
                }
                body.setF_e19f9dc(Boolean.valueOf(element.getFirstChild().getAttributes().getNamedItem("id").getNodeValue()));
            }
        } else if (element.getAttribute("name").equalsIgnoreCase("template")) {
            if (element.getFirstChild() != null) {
                if (element.getChildNodes().getLength() > 0) {
                    throw new Exception(element.getAttribute("name"));
                }
                //TODO
//                throw new Exception("template");
                body.setTemplate(element.getFirstChild().getAttributes().getNamedItem("id").getNodeValue());
            }
//
        } else if (element.getAttribute("name").equalsIgnoreCase("f_d1ef64d")) {

        } else if (element.getAttribute("name").equalsIgnoreCase("f_91a30ab")) {

        } else if (element.getAttribute("name").equalsIgnoreCase("f_a1a0501")) {

        } else if (element.getAttribute("name").equalsIgnoreCase("f_013e5ba")) {

        } else if (element.getAttribute("name").equalsIgnoreCase("f_d1086f4")) {

        } else if (element.getAttribute("name").equalsIgnoreCase("f_11f9b70")) {

        } else if (element.getAttribute("name").equalsIgnoreCase("f_41afa8c")) {

        } else if (element.getAttribute("name").equalsIgnoreCase("f_1144b6b")) {

        } else if (element.getAttribute("name").equalsIgnoreCase("f_f1d9e2d")) {

        } else if (element.getAttribute("name").equalsIgnoreCase("f_f1a5daf")) {
            if (element.getFirstChild() != null) {
                if (element.getChildNodes().getLength() > 0) {
                    throw new Exception(element.getAttribute("name"));
                }
            }
        } else if (element.getAttribute("name").equalsIgnoreCase("f_118f49d")) {

        } else if (element.getAttribute("name").equalsIgnoreCase("f_61741ce")) {

        } else if (element.getAttribute("name").equalsIgnoreCase("f_61de7d0")) {

        } else if (element.getAttribute("name").equalsIgnoreCase("f_01dc74d")) {
            if (element.getFirstChild() != null) {
                if (element.getChildNodes().getLength() > 0) {
                    throw new Exception(element.getAttribute("name"));
                }
            }
        } else if (element.getAttribute("name").equalsIgnoreCase("f_317d7ac")) {
            if (element.getFirstChild() != null) {
                if (element.getChildNodes().getLength() > 0) {
                    throw new Exception(element.getAttribute("name"));
                }
            }
        } else if (element.getAttribute("name").equalsIgnoreCase("f_d13446c")) {
            if (element.getFirstChild() != null) {
                if (element.getChildNodes().getLength() > 0) {
                    throw new Exception(element.getAttribute("name"));
                }
            }
        } else if (element.getAttribute("name").equalsIgnoreCase("f_1112b5c")) {
            if (element.getFirstChild() != null) {
                if (element.getChildNodes().getLength() > 0) {
                    throw new Exception(element.getAttribute("name"));
                }
            }
        } else if (element.getAttribute("name").equalsIgnoreCase("f_31d5f82")) {

        } else if (element.getAttribute("name").equalsIgnoreCase("f_f14b399")) {

        } else if (element.getAttribute("name").equalsIgnoreCase("f_910ca87")) {
            if (element.getFirstChild() != null) {
                if (element.getChildNodes().getLength() > 0) {
                    throw new Exception(element.getAttribute("name"));
                }
            }
        } else if (element.getAttribute("name").equalsIgnoreCase("f_e1d4a4c")) {
            if (element.getFirstChild() != null) {
                if (element.getChildNodes().getLength() > 0) {
                    throw new Exception(element.getAttribute("name"));
                }
            }
        } else if (element.getAttribute("name").equalsIgnoreCase("f_812595a")) {
            if (element.getFirstChild() != null) {
                if (element.getChildNodes().getLength() > 0) {
                    throw new Exception(element.getAttribute("name"));
                }
            }
        } else if (element.getAttribute("name").equalsIgnoreCase("f_b114825")) {
            if (element.getFirstChild() != null) {
                if (element.getChildNodes().getLength() > 0) {
                    throw new Exception(element.getAttribute("name"));
                }
            }
        } else if (element.getAttribute("name").equalsIgnoreCase("f_8103a47")) {
            if (element.getFirstChild() != null) {
                if (element.getChildNodes().getLength() > 0) {
                    throw new Exception(element.getAttribute("name"));
                }
            }
        } else if (element.getAttribute("name").equalsIgnoreCase("f_0124ea9")) {
            if (element.getFirstChild() != null) {
                if (element.getChildNodes().getLength() > 0) {
                    throw new Exception(element.getAttribute("name"));
                }
                body.setF_0124ea9(Boolean.valueOf(element.getFirstChild().getAttributes().getNamedItem("id").getNodeValue()));
            }
        } else if (element.getAttribute("name").equalsIgnoreCase("f_a16cf55")) {
            if (element.getFirstChild() != null) {
                if (element.getChildNodes().getLength() > 0) {
                    throw new Exception(element.getAttribute("name"));
                }
                body.setF_a16cf55(element.getFirstChild().getAttributes().getNamedItem("id").getNodeValue());
            }
        } else if (element.getAttribute("name").equalsIgnoreCase("f_a1f3ad4")) {
            if (element.getFirstChild() != null) {
                if (element.getChildNodes().getLength() > 0) {
                    throw new Exception(element.getAttribute("name"));
                }
                body.setF_a1f3ad4(element.getFirstChild().getAttributes().getNamedItem("id").getNodeValue());
            }
        } else if (element.getAttribute("name").equalsIgnoreCase("f_f1191df")) {
            if (element.getFirstChild() != null) {
                if (element.getChildNodes().getLength() > 0) {
                    throw new Exception(element.getAttribute("name"));
                }
                body.setF_f1191df(element.getFirstChild().getAttributes().getNamedItem("id").getNodeValue());
            }
        } else if (element.getAttribute("name").equalsIgnoreCase("f_0126248")) {
            if (element.getFirstChild() != null) {
                if (element.getChildNodes().getLength() > 0) {
                    throw new Exception(element.getAttribute("name"));
                }
                body.setF_0126248(element.getFirstChild().getAttributes().getNamedItem("id").getNodeValue());
            }
        } else if (element.getAttribute("name").equalsIgnoreCase("f_f1945d5")) {
            if (element.getFirstChild() != null) {
                if (element.getChildNodes().getLength() > 0) {
                    throw new Exception(element.getAttribute("name"));
                }
                body.setF_f1945d5(element.getFirstChild().getAttributes().getNamedItem("id").getNodeValue());
            }
        } else if (element.getAttribute("name").equalsIgnoreCase("f_b18cb95")) {

        } else if (element.getAttribute("name").equalsIgnoreCase("f_31f7b68")) {
            if (element.getFirstChild() != null) {
                if (element.getChildNodes().getLength() > 0) {
                    throw new Exception(element.getAttribute("name"));
                }
                body.setF_31f7b68(element.getFirstChild().getAttributes().getNamedItem("id").getNodeValue());
            }
        } else if (element.getAttribute("name").equalsIgnoreCase("f_811cc63")) {

        } else if (element.getAttribute("name").equalsIgnoreCase("f_61080a8")) {
            if (element.getFirstChild() != null) {
                if (element.getChildNodes().getLength() > 0) {
                    throw new Exception(element.getAttribute("name"));
                }
                body.setF_61080a8(Boolean.valueOf(element.getFirstChild().getAttributes().getNamedItem("id").getNodeValue()));
            }
        } else if (element.getAttribute("name").equalsIgnoreCase("f_41b26fe")) {
            if (element.getFirstChild() != null) {
                if (element.getChildNodes().getLength() > 0) {
                    throw new Exception(element.getAttribute("name"));
                }
                body.setF_41b26fe(Boolean.valueOf(element.getFirstChild().getAttributes().getNamedItem("id").getNodeValue()));
            }
        } else if (element.getAttribute("name").equalsIgnoreCase("f_a1a2ecc")) {
            if (element.getFirstChild() != null) {
                if (element.getChildNodes().getLength() > 0) {
                    throw new Exception(element.getAttribute("name"));
                }
                body.setF_a1a2ecc(Boolean.valueOf(element.getFirstChild().getAttributes().getNamedItem("id").getNodeValue()));
            }
        } else if (element.getAttribute("name").equalsIgnoreCase("f_11a8684")) {
            if (element.getFirstChild() != null) {
                if (element.getChildNodes().getLength() > 0) {
                    throw new Exception(element.getAttribute("name"));
                }
                body.setF_11a8684(element.getFirstChild().getAttributes().getNamedItem("id").getNodeValue());
            }
        } else if (element.getAttribute("name").equalsIgnoreCase("f_810be61")) {
            if (element.getFirstChild() != null) {
                if (element.getChildNodes().getLength() > 0) {
                    throw new Exception(element.getAttribute("name"));
                }
                body.setF_810be61(element.getFirstChild().getAttributes().getNamedItem("id").getNodeValue());
            }
        } else if (element.getAttribute("name").equalsIgnoreCase("f_e1744a5")) {
            if (element.getFirstChild() != null) {
                if (element.getChildNodes().getLength() > 0) {
                    throw new Exception(element.getAttribute("name"));
                }
                body.setF_e1744a5(element.getFirstChild().getAttributes().getNamedItem("id").getNodeValue());
            }
        } else if (element.getAttribute("name").equalsIgnoreCase("f_21da282")) {
            if (element.getFirstChild() != null) {
                if (element.getChildNodes().getLength() > 0) {
                    throw new Exception(element.getAttribute("name"));
                }
                body.setF_21da282(element.getFirstChild().getAttributes().getNamedItem("id").getNodeValue());
            }
        } else if (element.getAttribute("name").equalsIgnoreCase("f_a132bf2")) {
            if (element.getFirstChild() != null) {
                if (element.getChildNodes().getLength() > 0) {
                    throw new Exception(element.getAttribute("name"));
                }
                body.setF_a132bf2(element.getFirstChild().getAttributes().getNamedItem("id").getNodeValue());
            }
        } else if (element.getAttribute("name").equalsIgnoreCase("f_2132dec")) {
            if (element.getFirstChild() != null) {
                if (element.getChildNodes().getLength() > 0) {
                    throw new Exception(element.getAttribute("name"));
                }
                body.setF_2132dec(element.getFirstChild().getAttributes().getNamedItem("id").getNodeValue());
            }
        } else if (element.getAttribute("name").equalsIgnoreCase("f_41407ad")) {
            if (element.getFirstChild() != null) {
                if (element.getChildNodes().getLength() > 0) {
                    throw new Exception(element.getAttribute("name"));
                }
                body.setF_41407ad(element.getFirstChild().getAttributes().getNamedItem("id").getNodeValue());
            }
        } else if (element.getAttribute("name").equalsIgnoreCase("f_b1e1137")) {
            if (element.getFirstChild() != null) {
                if (element.getChildNodes().getLength() > 0) {
                    throw new Exception(element.getAttribute("name"));
                }
                body.setF_b1e1137(element.getFirstChild().getAttributes().getNamedItem("id").getNodeValue());
            }
        } else if (element.getAttribute("name").equalsIgnoreCase("f_b15a02e")) {
            if (element.getFirstChild() != null) {
                if (element.getChildNodes().getLength() > 0) {
                    throw new Exception(element.getAttribute("name"));
                }
                body.setF_b15a02e(element.getFirstChild().getAttributes().getNamedItem("id").getNodeValue());
            }
        } else if (element.getAttribute("name").equalsIgnoreCase("f_61f0b14")) {
            if (element.getFirstChild() != null) {
                if (element.getChildNodes().getLength() > 0) {
                    throw new Exception(element.getAttribute("name"));
                }
                body.setF_61f0b14(element.getFirstChild().getAttributes().getNamedItem("id").getNodeValue());
            }
        } else if (element.getAttribute("name").equalsIgnoreCase("f_8172a0d")) {
            if (element.getFirstChild() != null) {
                if (element.getChildNodes().getLength() > 0) {
                    throw new Exception(element.getAttribute("name"));
                }
                body.setF_8172a0d(element.getFirstChild().getAttributes().getNamedItem("id").getNodeValue());
            }
        } else if (element.getAttribute("name").equalsIgnoreCase("f_a188010")) {
            if (element.getFirstChild() != null) {
                if (element.getChildNodes().getLength() > 0) {
                    throw new Exception(element.getAttribute("name"));
                }
                body.setF_a188010(element.getFirstChild().getAttributes().getNamedItem("id").getNodeValue());
            }
        } else if (element.getAttribute("name").equalsIgnoreCase("f_51c8224")) {
            if (element.getFirstChild() != null) {
                if (element.getChildNodes().getLength() > 0) {
                    throw new Exception(element.getAttribute("name"));
                }
                body.setF_51c8224(element.getFirstChild().getAttributes().getNamedItem("id").getNodeValue());
            }
        } else if (element.getAttribute("name").equalsIgnoreCase("f_newversion")) {
            if (element.getFirstChild() != null) {
                if (element.getChildNodes().getLength() > 0) {
                    throw new Exception(element.getAttribute("name"));
                }
                body.setFNewversion(Boolean.valueOf(element.getFirstChild().getAttributes().getNamedItem("id").getNodeValue()));
            }
        } else if (element.getAttribute("name").equalsIgnoreCase("f_41b04ba")) {
            if (element.getFirstChild() != null) {
                if (element.getChildNodes().getLength() > 0) {
                    throw new Exception(element.getAttribute("name"));
                }
                body.setF_41b04ba(Boolean.valueOf(element.getFirstChild().getAttributes().getNamedItem("id").getNodeValue()));
            }
        } else if (element.getAttribute("name").equalsIgnoreCase("f_b13ee0f")) {
            if (element.getFirstChild() != null) {
                if (element.getChildNodes().getLength() > 0) {
                    throw new Exception(element.getAttribute("name"));
                }
                body.setF_b13ee0f(Boolean.valueOf(element.getFirstChild().getAttributes().getNamedItem("id").getNodeValue()));
            }
        } else if (element.getAttribute("name").equalsIgnoreCase("f_41d8952")) {
            if (element.getFirstChild() != null) {
                if (element.getChildNodes().getLength() > 0) {
                    throw new Exception(element.getAttribute("name"));
                }
                body.setF_41d8952(Boolean.valueOf(element.getFirstChild().getAttributes().getNamedItem("id").getNodeValue()));
            }
        } else if (element.getAttribute("name").equalsIgnoreCase("f_f11b350")) {
            if (element.getFirstChild() != null) {
                if (element.getChildNodes().getLength() > 0) {
                    throw new Exception(element.getAttribute("name"));
                }
                body.setF_f11b350(Boolean.valueOf(element.getFirstChild().getAttributes().getNamedItem("id").getNodeValue()));
            }
        } else if (element.getAttribute("name").equalsIgnoreCase("f_615ab98")) {
            if (element.getFirstChild() != null) {
                if (element.getChildNodes().getLength() > 0) {
                    throw new Exception(element.getAttribute("name"));
                }
                body.setF_615ab98(element.getFirstChild().getAttributes().getNamedItem("id").getNodeValue());
            }
        } else if (element.getAttribute("name").equalsIgnoreCase("f_61e8b2e")) {
            if (element.getFirstChild() != null) {
                if (element.getChildNodes().getLength() > 0) {
                    throw new Exception(element.getAttribute("name"));
                }
                body.setF_61e8b2e(element.getFirstChild().getAttributes().getNamedItem("id").getNodeValue());
            }
        } else if (element.getAttribute("name").equalsIgnoreCase("f_a1d098c")) {
            if (element.getFirstChild() != null) {
                if (element.getChildNodes().getLength() > 0) {
                    throw new Exception(element.getAttribute("name"));
                }
                body.setF_a1d098c(element.getFirstChild().getAttributes().getNamedItem("id").getNodeValue());
            }
        } else if (element.getAttribute("name").equalsIgnoreCase("f_516c7c3")) {
            if (element.getFirstChild() != null) {
                if (element.getChildNodes().getLength() > 0) {
                    throw new Exception(element.getAttribute("name"));
                }
                body.setF_516c7c3(element.getFirstChild().getAttributes().getNamedItem("id").getNodeValue());
            }
        } else if (element.getAttribute("name").equalsIgnoreCase("f_51f8599")) {
            if (element.getFirstChild() != null) {
                if (element.getChildNodes().getLength() > 0) {
                    throw new Exception(element.getAttribute("name"));
                }
                body.setF_51f8599(element.getFirstChild().getAttributes().getNamedItem("id").getNodeValue());
            }
        } else if (element.getAttribute("name").equalsIgnoreCase("f_b1d7068")) {
            if (element.getFirstChild() != null) {
                if (element.getChildNodes().getLength() > 0) {
                    throw new Exception(element.getAttribute("name"));
                }
                body.setF_b1d7068(element.getFirstChild().getAttributes().getNamedItem("id").getNodeValue());
            }
        } else if (element.getAttribute("name").equalsIgnoreCase("f_710f07e")) {
            if (element.getFirstChild() != null) {
                if (element.getChildNodes().getLength() > 0) {
                    throw new Exception(element.getAttribute("name"));
                }
                throw new Exception("f_710f07e");
            }
//                body.setF_710f07e(element.getFirstChild().getAttributes().getNamedItem("id").getNodeValue());
        } else if (element.getAttribute("name").equalsIgnoreCase("f_c1699ba")) {
            if (element.getFirstChild() != null) {
                if (element.getChildNodes().getLength() > 0) {
                    throw new Exception(element.getAttribute("name"));
                }
                body.setF_c1699ba(element.getFirstChild().getAttributes().getNamedItem("id").getNodeValue());
            }
        } else if (element.getAttribute("name").equalsIgnoreCase("f_b150e8e")) {
            if (element.getFirstChild() != null) {
                if (element.getChildNodes().getLength() > 0) {
                    throw new Exception(element.getAttribute("name"));
                }
                body.setF_b150e8e(element.getFirstChild().getAttributes().getNamedItem("id").getNodeValue());
            }
        } else if (element.getAttribute("name").equalsIgnoreCase("f_table_sogl")) {
            if (element.getFirstChild() != null) {
                if (element.getChildNodes().getLength() > 0) {
                    throw new Exception(element.getAttribute("name"));
                }
                body.setFTableSogl(element.getFirstChild().getAttributes().getNamedItem("id").getNodeValue());
            }
        } else if (element.getAttribute("name").equalsIgnoreCase("f_71c7b54")) {
            if (element.getFirstChild() != null) {
                if (element.getChildNodes().getLength() > 0) {
                    throw new Exception(element.getAttribute("name"));
                }
                body.setF_71c7b54(element.getFirstChild().getAttributes().getNamedItem("id").getNodeValue());
            }
        } else if (element.getAttribute("name").equalsIgnoreCase("f_f1b6492")) {
            if (element.getFirstChild() != null) {
                if (element.getChildNodes().getLength() > 0) {
                    throw new Exception(element.getAttribute("name"));
                }
                body.setF_f1b6492(element.getFirstChild().getAttributes().getNamedItem("id").getNodeValue());
            }
        } else if (element.getAttribute("name").equalsIgnoreCase("f_416739a")) {
            if (element.getFirstChild() != null) {
                if (element.getChildNodes().getLength() > 0) {
                    throw new Exception(element.getAttribute("name"));
                }
                body.setF_416739a(element.getFirstChild().getAttributes().getNamedItem("id").getNodeValue());
            }
        } else if (element.getAttribute("name").equalsIgnoreCase("f_d16785d")) {
            if (element.getFirstChild() != null) {
                if (element.getChildNodes().getLength() > 0) {
                    throw new Exception(element.getAttribute("name"));
                }
                body.setF_d16785d(element.getFirstChild().getAttributes().getNamedItem("id").getNodeValue());
            }
        } else if (element.getAttribute("name").equalsIgnoreCase("f_d16785d")) {
            if (element.getFirstChild() != null) {
                if (element.getChildNodes().getLength() > 0) {
                    throw new Exception(element.getAttribute("name"));
                }
                throw new Exception("f_d16785d");
            }
//                body.setFD16785d(element.getFirstChild().getAttributes().getNamedItem("id").getNodeValue());
        } else if (element.getAttribute("name").equalsIgnoreCase("f_81fbc4a")) {
            if (element.getFirstChild() != null) {
                if (element.getChildNodes().getLength() > 0) {
                    throw new Exception(element.getAttribute("name"));
                }
                body.setF_81fbc4a(element.getFirstChild().getAttributes().getNamedItem("id").getNodeValue());
            }
        } else if (element.getAttribute("name").equalsIgnoreCase("f_110039e")) {
            if (element.getFirstChild() != null) {
                if (element.getChildNodes().getLength() > 0) {
                    throw new Exception(element.getAttribute("name"));
                }
                body.setF_110039e(element.getFirstChild().getAttributes().getNamedItem("id").getNodeValue());
            }
        } else if (element.getAttribute("name").equalsIgnoreCase("f_1164f84")) {

        } else if (element.getAttribute("name").equalsIgnoreCase("f_517bae1")) {

        } else if (element.getAttribute("name").equalsIgnoreCase("f_1112b84")) {
            if (element.getFirstChild() != null) {
                if (element.getChildNodes().getLength() > 0) {
                    throw new Exception(element.getAttribute("name"));
                }
            }
        } else if (element.getAttribute("name").equalsIgnoreCase("f_6124226")) {
            if (element.getFirstChild() != null) {
                if (element.getChildNodes().getLength() > 0) {
                    throw new Exception(element.getAttribute("name"));
                }
            }
        } else if (element.getAttribute("name").equalsIgnoreCase("f_211a19f")) {
            if (element.getFirstChild() != null) {
                if (element.getChildNodes().getLength() > 0) {
                    throw new Exception(element.getAttribute("name"));
                }
            }
        } else if (element.getAttribute("name").equalsIgnoreCase("f_c144ea1")) {
            if (element.getFirstChild() != null) {
                if (element.getChildNodes().getLength() > 0) {
                    throw new Exception(element.getAttribute("name"));
                }
            }
        } else if (element.getAttribute("name").equalsIgnoreCase("f_01b986a")) {
            if (element.getFirstChild() != null) {
                if (element.getChildNodes().getLength() > 0) {
                    throw new Exception(element.getAttribute("name"));
                }
            }
        } else if (element.getAttribute("name").equalsIgnoreCase("f_71f6e48")) {
            if (element.getFirstChild() != null) {
                if (element.getChildNodes().getLength() > 0) {
                    throw new Exception(element.getAttribute("name"));
                }
            }
        } else if (element.getAttribute("name").equalsIgnoreCase("f_61f64e5")) {
            if (element.getFirstChild() != null) {
                if (element.getChildNodes().getLength() > 0) {
                    throw new Exception(element.getAttribute("name"));
                }
            }
        } else if (element.getAttribute("name").equalsIgnoreCase("f_813bcf8")) {

        } else if (element.getAttribute("name").equalsIgnoreCase("f_21dee2e")) {

        } else if (element.getAttribute("name").equalsIgnoreCase("f_410ee30")) {
            if (element.getFirstChild() != null) {
                if (element.getChildNodes().getLength() > 0) {
                    throw new Exception(element.getAttribute("name"));
                }
                body.setF_410ee30(element.getFirstChild().getAttributes().getNamedItem("id").getNodeValue());
            }
        } else if (element.getAttribute("name").equalsIgnoreCase("f_c1ff57f")) {
            if (element.getFirstChild() != null) {
                if (element.getChildNodes().getLength() > 0) {
                    throw new Exception(element.getAttribute("name"));
                }
                body.setF_c1ff57f(element.getFirstChild().getAttributes().getNamedItem("id").getNodeValue());
            }
        } else if (element.getAttribute("name").equalsIgnoreCase("f_51926e6")) {
            if (element.getFirstChild() != null) {
                if (element.getChildNodes().getLength() > 0) {
                    throw new Exception(element.getAttribute("name"));
                }
                body.setF_51926e6(element.getFirstChild().getAttributes().getNamedItem("id").getNodeValue());
            }
        } else if (element.getAttribute("name").equalsIgnoreCase("f_21e53f0")) {
            if (element.getFirstChild() != null) {
                if (element.getChildNodes().getLength() > 0) {
                    throw new Exception(element.getAttribute("name"));
                }
                body.setF_21e53f0(element.getFirstChild().getAttributes().getNamedItem("id").getNodeValue());
            }
        } else if (element.getAttribute("name").equalsIgnoreCase("f_b1bcb9a")) {
            if (element.getFirstChild() != null) {
                if (element.getChildNodes().getLength() > 0) {
                    throw new Exception(element.getAttribute("name"));
                }
            }
        } else if (element.getAttribute("name").equalsIgnoreCase("f_21795f0")) {
            if (element.getFirstChild() != null) {
                if (element.getChildNodes().getLength() > 0) {
                    throw new Exception(element.getAttribute("name"));
                }
            }
        } else if (element.getAttribute("name").equalsIgnoreCase("f_c108795")) {
            if (element.getFirstChild() != null) {
                if (element.getChildNodes().getLength() > 0) {
                    throw new Exception(element.getAttribute("name"));
                }
            }
        } else if (element.getAttribute("name").equalsIgnoreCase("f_0193cdc")) {

        } else if (element.getAttribute("name").equalsIgnoreCase("f_e113887")) {
            if (element.getFirstChild() != null) {
                if (element.getChildNodes().getLength() > 0) {
                    throw new Exception(element.getAttribute("name"));
                }
            }
        } else if (element.getAttribute("name").equalsIgnoreCase("f_c1df363")) {
            if (element.getFirstChild() != null) {
                if (element.getChildNodes().getLength() > 0) {
                    throw new Exception(element.getAttribute("name"));
                }
            }
        } else if (element.getAttribute("name").equalsIgnoreCase("f_21e9ee1")) {
            if (element.getFirstChild() != null) {
                if (element.getChildNodes().getLength() > 0) {
                    throw new Exception(element.getAttribute("name"));
                }
            }
        } else if (element.getAttribute("name").equalsIgnoreCase("f_f1a132f")) {
            if (element.getFirstChild() != null) {
                if (element.getChildNodes().getLength() > 0) {
                    throw new Exception(element.getAttribute("name"));
                }
            }
        } else if (element.getAttribute("name").equalsIgnoreCase("f_21501c0")) {
            if (element.getFirstChild() != null) {
                if (element.getChildNodes().getLength() > 0) {
                    throw new Exception(element.getAttribute("name"));
                }
            }
        } else if (element.getAttribute("name").equalsIgnoreCase("f_51f8283")) {

        } else if (element.getAttribute("name").equalsIgnoreCase("f_8148b02")) {
            if (element.getFirstChild() != null) {
                if (element.getChildNodes().getLength() > 0) {
                    throw new Exception(element.getAttribute("name"));
                }
            }
        } else if (element.getAttribute("name").equalsIgnoreCase("f_91ca174")) {
            if (element.getFirstChild() != null) {
                if (element.getChildNodes().getLength() > 0) {
                    throw new Exception(element.getAttribute("name"));
                }
            }
        } else if (element.getAttribute("name").equalsIgnoreCase("f_419bb00")) {
            if (element.getFirstChild() != null) {
                if (element.getChildNodes().getLength() > 0) {
                    throw new Exception(element.getAttribute("name"));
                }
            }
        } else if (element.getAttribute("name").equalsIgnoreCase("f_b1662f0")) {
            if (element.getFirstChild() != null) {
                if (element.getChildNodes().getLength() > 0) {
                    throw new Exception(element.getAttribute("name"));
                }
            }
        } else if (element.getAttribute("name").equalsIgnoreCase("f_114ed9f")) {
            if (element.getFirstChild() != null) {
                if (element.getChildNodes().getLength() > 0) {
                    throw new Exception(element.getAttribute("name"));
                }
                body.setF_114ed9f(element.getFirstChild().getAttributes().getNamedItem("id").getNodeValue());
            }
        } else if (element.getAttribute("name").equalsIgnoreCase("f_71bd66d")) {
            if (element.getFirstChild() != null) {
                if (element.getChildNodes().getLength() > 0) {
                    throw new Exception(element.getAttribute("name"));
                }
                body.setF_71bd66d(Boolean.valueOf(element.getFirstChild().getAttributes().getNamedItem("id").getNodeValue()));
            }
        } else if (element.getAttribute("name").equalsIgnoreCase("f_edited")) {
            if (element.getFirstChild() != null) {
                if (element.getChildNodes().getLength() > 0) {
                    throw new Exception(element.getAttribute("name"));
                }
                body.setF_edited(Boolean.valueOf(element.getFirstChild().getAttributes().getNamedItem("id").getNodeValue()));
            }
        } else if (element.getAttribute("name").equalsIgnoreCase("f_41ba5d6")) {
            if (element.getFirstChild() != null) {
                if (element.getChildNodes().getLength() > 0) {
                    throw new Exception(element.getAttribute("name"));
                }
            }
        } else if (element.getAttribute("name").equalsIgnoreCase("f_219cf37")) {
            if (element.getFirstChild() != null) {
                if (element.getChildNodes().getLength() > 0) {
                    throw new Exception(element.getAttribute("name"));
                }
                body.setF_219cf37(Boolean.valueOf(element.getFirstChild().getAttributes().getNamedItem("id").getNodeValue()));
            }
        } else if (element.getAttribute("name").equalsIgnoreCase("f_1168c6f")) {
            if (element.getFirstChild() != null) {
                if (element.getChildNodes().getLength() > 0) {
                    throw new Exception(element.getAttribute("name"));
                }
            }
        } else if (element.getAttribute("name").equalsIgnoreCase("f_f1f39e5")) {
            if (element.getFirstChild() != null) {
                if (element.getChildNodes().getLength() > 0) {
                    throw new Exception(element.getAttribute("name"));
                }
            }
        } else if (element.getAttribute("name").equalsIgnoreCase("f_110a1e1")) {

        } else if (element.getAttribute("name").equalsIgnoreCase("f_b1eb499")) {
            if (element.getFirstChild() != null) {
                if (element.getChildNodes().getLength() > 0) {
                    throw new Exception(element.getAttribute("name"));
                }
                body.setF_b1eb499(Boolean.valueOf(element.getFirstChild().getAttributes().getNamedItem("id").getNodeValue()));
            }
        } else if (element.getAttribute("name").equalsIgnoreCase("f_7157da7")) {
            if (element.getFirstChild() != null) {
                if (element.getChildNodes().getLength() > 0) {
                    throw new Exception(element.getAttribute("name"));
                }
                body.setF_7157da7(element.getFirstChild().getAttributes().getNamedItem("id").getNodeValue());
            }
        } else if (element.getAttribute("name").equalsIgnoreCase("f_b1dae10")) {
            if (element.getFirstChild() != null) {
                if (element.getChildNodes().getLength() > 0) {
                    throw new Exception(element.getAttribute("name"));
                }
                body.setF_b1dae10(element.getFirstChild().getAttributes().getNamedItem("id").getNodeValue());
            }
        } else if (element.getAttribute("name").equalsIgnoreCase("f_4160d2d")) {
            if (element.getFirstChild() != null) {
                if (element.getChildNodes().getLength() > 0) {
                    throw new Exception(element.getAttribute("name"));
                }
                body.setF_4160d2d(element.getFirstChild().getAttributes().getNamedItem("id").getNodeValue());
            }
        } else if (element.getAttribute("name").equalsIgnoreCase("f_015ac8a")) {
            if (element.getFirstChild() != null) {
                if (element.getChildNodes().getLength() > 0) {
                    throw new Exception(element.getAttribute("name"));
                }
                body.setF_015ac8a(element.getFirstChild().getAttributes().getNamedItem("id").getNodeValue());
            }
        } else if (element.getAttribute("name").equalsIgnoreCase("f_113c951")) {
            if (element.getFirstChild() != null) {
                if (element.getChildNodes().getLength() > 0) {
                    throw new Exception(element.getAttribute("name"));
                }
                body.setF_113c951(element.getFirstChild().getAttributes().getNamedItem("id").getNodeValue());
            }
        } else if (element.getAttribute("name").equalsIgnoreCase("f_216c41c")) {
            if (element.getFirstChild() != null) {
                if (element.getChildNodes().getLength() > 0) {
                    throw new Exception(element.getAttribute("name"));
                }
                body.setF_216c41c(element.getFirstChild().getAttributes().getNamedItem("id").getNodeValue());
            }
        } else if (element.getAttribute("name").equalsIgnoreCase("f_111de62")) {
            if (element.getFirstChild() != null) {
                if (element.getChildNodes().getLength() > 0) {
                    throw new Exception(element.getAttribute("name"));
                }
                body.setF_111de62(element.getFirstChild().getAttributes().getNamedItem("id").getNodeValue());
            }
        } else if (element.getAttribute("name").equalsIgnoreCase("f_515f19c")) {
            if (element.getFirstChild() != null) {
                if (element.getChildNodes().getLength() > 0) {
                    throw new Exception(element.getAttribute("name"));
                }
                body.setF_515f19c(element.getFirstChild().getAttributes().getNamedItem("id").getNodeValue());
            }
        } else if (element.getAttribute("name").equalsIgnoreCase("f_31b1230")) {
            if (element.getFirstChild() != null) {
                if (element.getChildNodes().getLength() > 0) {
                    throw new Exception(element.getAttribute("name"));
                }
                body.setF_31b1230(Boolean.valueOf(element.getFirstChild().getAttributes().getNamedItem("id").getNodeValue()));
            }
        } else if (element.getAttribute("name").equalsIgnoreCase("f_711de51")) {
            if (element.getFirstChild() != null) {
                if (element.getChildNodes().getLength() > 0) {
                    throw new Exception(element.getAttribute("name"));
                }
                body.setF_711de51(Boolean.valueOf(element.getFirstChild().getAttributes().getNamedItem("id").getNodeValue()));
            }
        } else if (element.getAttribute("name").equalsIgnoreCase("f_e19ae19")) {
            if (element.getFirstChild() != null) {
                if (element.getChildNodes().getLength() > 0) {
                    throw new Exception(element.getAttribute("name"));
                }
                body.setF_e19ae19(element.getFirstChild().getAttributes().getNamedItem("id").getNodeValue());
            }
        } else if (element.getAttribute("name").equalsIgnoreCase("f_01a0ff3")) {
            if (element.getFirstChild() != null) {
                if (element.getChildNodes().getLength() > 0) {
                    throw new Exception(element.getAttribute("name"));
                }
                body.setF_01a0ff3(element.getFirstChild().getAttributes().getNamedItem("id").getNodeValue());
            }
        } else if (element.getAttribute("name").equalsIgnoreCase("f_510f8c4")) {
            if (element.getFirstChild() != null) {
                if (element.getChildNodes().getLength() > 0) {
                    throw new Exception(element.getAttribute("name"));
                }
                body.setF_510f8c4(element.getFirstChild().getAttributes().getNamedItem("id").getNodeValue());
            }
        } else if (element.getAttribute("name").equalsIgnoreCase("f_51690d3")) {
            if (element.getFirstChild() != null) {
                if (element.getChildNodes().getLength() > 0) {
                    throw new Exception(element.getAttribute("name"));
                }
                body.setF_51690d3(element.getFirstChild().getAttributes().getNamedItem("id").getNodeValue());
            }
        } else if (element.getAttribute("name").equalsIgnoreCase("aktenplan_index")) {
            if (element.getFirstChild() != null) {
                if (element.getChildNodes().getLength() > 0) {
                    throw new Exception(element.getAttribute("name"));
                }
                body.setAktenplanIndex(element.getFirstChild().getAttributes().getNamedItem("id").getNodeValue());
            }
        } else if (element.getAttribute("name").equalsIgnoreCase("f_01772b5")) {
            if (element.getFirstChild() != null) {
                if (element.getChildNodes().getLength() > 0) {
                    throw new Exception(element.getAttribute("name"));
                }
                body.setF_01772b5(element.getFirstChild().getAttributes().getNamedItem("id").getNodeValue());
            }
        } else if (element.getAttribute("name").equalsIgnoreCase("f_d19190f")) {
            if (element.getFirstChild() != null) {
                if (element.getChildNodes().getLength() > 0) {
                    throw new Exception(element.getAttribute("name"));
                }
                body.setF_d19190f(element.getFirstChild().getAttributes().getNamedItem("id").getNodeValue());
            }
        } else if (element.getAttribute("name").equalsIgnoreCase("f_21518de")) {
            if (element.getFirstChild() != null) {
                if (element.getChildNodes().getLength() > 0) {
                    throw new Exception(element.getAttribute("name"));
                }
                body.setF_21518de(element.getFirstChild().getAttributes().getNamedItem("id").getNodeValue());
            }
        } else if (element.getAttribute("name").equalsIgnoreCase("f_01c4b1f")) {
            if (element.getFirstChild() != null) {
                if (element.getChildNodes().getLength() > 0) {
                    throw new Exception(element.getAttribute("name"));
                }
                body.setF_01c4b1f(element.getFirstChild().getAttributes().getNamedItem("id").getNodeValue());
            }
        } else if (element.getAttribute("name").equalsIgnoreCase("f_b1ed709")) {
            if (element.getFirstChild() != null) {
                if (element.getChildNodes().getLength() > 0) {
                    throw new Exception(element.getAttribute("name"));
                }
                body.setF_b1ed709(element.getFirstChild().getAttributes().getNamedItem("id").getNodeValue());
            }
        } else if (element.getAttribute("name").equalsIgnoreCase("f_81b20e3")) {
            if (element.getFirstChild() != null) {
                if (element.getChildNodes().getLength() > 0) {
                    throw new Exception(element.getAttribute("name"));
                }
                body.setF_81b20e3(element.getFirstChild().getAttributes().getNamedItem("id").getNodeValue());
            }
        } else if (element.getAttribute("name").equalsIgnoreCase("f_e1343ff")) {
            if (element.getFirstChild() != null) {
                if (element.getChildNodes().getLength() > 0) {
                    throw new Exception(element.getAttribute("name"));
                }
                body.setF_e1343ff(element.getFirstChild().getAttributes().getNamedItem("id").getNodeValue());
            }
        } else if (element.getAttribute("name").equalsIgnoreCase("f_61a302f")) {
            if (element.getFirstChild() != null) {
                if (element.getChildNodes().getLength() > 0) {
                    throw new Exception(element.getAttribute("name"));
                }
                body.setF_61a302f(element.getFirstChild().getAttributes().getNamedItem("id").getNodeValue());
            }
        } else if (element.getAttribute("name").equalsIgnoreCase("f_91f2f9f")) {
            if (element.getFirstChild() != null) {
                if (element.getChildNodes().getLength() > 0) {
                    throw new Exception(element.getAttribute("name"));
                }
                body.setF_91f2f9f(element.getFirstChild().getAttributes().getNamedItem("id").getNodeValue());
            }
        } else if (element.getAttribute("name").equalsIgnoreCase("f_b1689ca")) {
            if (element.getFirstChild() != null) {
                if (element.getChildNodes().getLength() > 0) {
                    throw new Exception(element.getAttribute("name"));
                }
                body.setF_b1689ca(element.getFirstChild().getAttributes().getNamedItem("id").getNodeValue());
            }
        } else if (element.getAttribute("name").equalsIgnoreCase("f_b1b86c0")) {
            if (element.getFirstChild() != null) {
                if (element.getChildNodes().getLength() > 0) {
                    throw new Exception(element.getAttribute("name"));
                }
                body.setF_b1b86c0(element.getFirstChild().getAttributes().getNamedItem("id").getNodeValue());
            }
        } else if (element.getAttribute("name").equalsIgnoreCase("f_d1cfac1")) {
            if (element.getFirstChild() != null) {
                if (element.getChildNodes().getLength() > 0) {
                    throw new Exception(element.getAttribute("name"));
                }
                body.setF_d1cfac1(element.getFirstChild().getAttributes().getNamedItem("id").getNodeValue());
            }
        } else if (element.getAttribute("name").equalsIgnoreCase("f_31c237b")) {
            if (element.getFirstChild() != null) {
                if (element.getChildNodes().getLength() > 0) {
                    throw new Exception(element.getAttribute("name"));
                }
                body.setF_31c237b(element.getFirstChild().getAttributes().getNamedItem("id").getNodeValue());
            }
        } else if (element.getAttribute("name").equalsIgnoreCase("f_a16a492")) {
            if (element.getFirstChild() != null) {
                if (element.getChildNodes().getLength() > 0) {
                    throw new Exception(element.getAttribute("name"));
                }
                body.setF_a16a492(element.getFirstChild().getAttributes().getNamedItem("id").getNodeValue());
            }
        } else if (element.getAttribute("name").equalsIgnoreCase("f_e1f3d17")) {
            if (element.getFirstChild() != null) {
                if (element.getChildNodes().getLength() > 0) {
                    throw new Exception(element.getAttribute("name"));
                }
                body.setF_e1f3d17(element.getFirstChild().getAttributes().getNamedItem("id").getNodeValue());
            }
        } else if (element.getAttribute("name").equalsIgnoreCase("f_a1ba734")) {
            if (element.getFirstChild() != null) {
                if (element.getChildNodes().getLength() > 0) {
                    throw new Exception(element.getAttribute("name"));
                }
                body.setF_a1ba734(element.getFirstChild().getAttributes().getNamedItem("id").getNodeValue());
            }
        } else if (element.getAttribute("name").equalsIgnoreCase("f_21787de")) {
            if (element.getFirstChild() != null) {
                if (element.getChildNodes().getLength() > 0) {
                    throw new Exception(element.getAttribute("name"));
                }
                body.setF_21787de(element.getFirstChild().getAttributes().getNamedItem("id").getNodeValue());
            }
        } else if (element.getAttribute("name").equalsIgnoreCase("f_61747f0")) {
            if (element.getFirstChild() != null) {
                if (element.getChildNodes().getLength() > 0) {
                    throw new Exception(element.getAttribute("name"));
                }
                body.setF_61747f0(element.getFirstChild().getAttributes().getNamedItem("id").getNodeValue());
            }
        } else if (element.getAttribute("name").equalsIgnoreCase("f_b17d60e")) {
            if (element.getFirstChild() != null) {
                if (element.getChildNodes().getLength() > 0) {
                    throw new Exception(element.getAttribute("name"));
                }
                body.setF_b17d60e(element.getFirstChild().getAttributes().getNamedItem("id").getNodeValue());
            }
        } else if (element.getAttribute("name").equalsIgnoreCase("f_e15602a")) {
            if (element.getFirstChild() != null) {
                if (element.getChildNodes().getLength() > 0) {
                    throw new Exception(element.getAttribute("name"));
                }
                body.setF_e15602a(element.getFirstChild().getAttributes().getNamedItem("id").getNodeValue());
            }
        } else if (element.getAttribute("name").equalsIgnoreCase("f_c1f1ba4")) {
            if (element.getFirstChild() != null) {
                if (element.getChildNodes().getLength() > 0) {
                    throw new Exception(element.getAttribute("name"));
                }
                body.setF_c1f1ba4(element.getFirstChild().getAttributes().getNamedItem("id").getNodeValue());
            }
        } else if (element.getAttribute("name").equalsIgnoreCase("f_f192968")) {
            if (element.getFirstChild() != null) {
                if (element.getChildNodes().getLength() > 0) {
                    throw new Exception(element.getAttribute("name"));
                }
                body.setF_f192968(element.getFirstChild().getAttributes().getNamedItem("id").getNodeValue());
            }
        } else if (element.getAttribute("name").equalsIgnoreCase("f_615c66e")) {
            if (element.getFirstChild() != null) {
                if (element.getChildNodes().getLength() > 0) {
                    throw new Exception(element.getAttribute("name"));
                }
                body.setF_615c66e(element.getFirstChild().getAttributes().getNamedItem("id").getNodeValue());
            }
        } else if (element.getAttribute("name").equalsIgnoreCase("f_c1f84f6")) {
            if (element.getFirstChild() != null) {
                if (element.getChildNodes().getLength() > 0) {
                    throw new Exception(element.getAttribute("name"));
                }
                body.setF_c1f84f6(element.getFirstChild().getAttributes().getNamedItem("id").getNodeValue());
            }
        } else if (element.getAttribute("name").equalsIgnoreCase("f_d1fb220")) {
            if (element.getFirstChild() != null) {
                if (element.getChildNodes().getLength() > 0) {
                    throw new Exception(element.getAttribute("name"));
                }
                body.setF_d1fb220(element.getFirstChild().getAttributes().getNamedItem("id").getNodeValue());
            }
        } else if (element.getAttribute("name").equalsIgnoreCase("f_e1c4e15")) {
            if (element.getFirstChild() != null) {
                if (element.getChildNodes().getLength() > 0) {
                    throw new Exception(element.getAttribute("name"));
                }
                body.setF_e1c4e15(element.getFirstChild().getAttributes().getNamedItem("id").getNodeValue());
            }
        } else if (element.getAttribute("name").equalsIgnoreCase("f_115ad81")) {
            if (element.getFirstChild() != null) {
                if (element.getChildNodes().getLength() > 0) {
                    throw new Exception(element.getAttribute("name"));
                }
                body.setF_115ad81(element.getFirstChild().getAttributes().getNamedItem("id").getNodeValue());
            }
        } else if (element.getAttribute("name").equalsIgnoreCase("f_01a24fd")) {
            if (element.getFirstChild() != null) {
                if (element.getChildNodes().getLength() > 0) {
                    throw new Exception(element.getAttribute("name"));
                }
                body.setF_01a24fd(element.getFirstChild().getAttributes().getNamedItem("id").getNodeValue());
            }
        } else if (element.getAttribute("name").equalsIgnoreCase("f_311ce64")) {
            if (element.getFirstChild() != null) {
                if (element.getChildNodes().getLength() > 0) {
                    throw new Exception(element.getAttribute("name"));
                }
                body.setF_311ce64(element.getFirstChild().getAttributes().getNamedItem("id").getNodeValue());
            }
        } else if (element.getAttribute("name").equalsIgnoreCase("f_f1e62a4")) {
            if (element.getFirstChild() != null) {
                if (element.getChildNodes().getLength() > 0) {
                    throw new Exception(element.getAttribute("name"));
                }
                body.setF_f1e62a4(element.getFirstChild().getAttributes().getNamedItem("id").getNodeValue());
            }
        } else if (element.getAttribute("name").equalsIgnoreCase("f_81354da")) {
            if (element.getFirstChild() != null) {
                if (element.getChildNodes().getLength() > 0) {
                    throw new Exception(element.getAttribute("name"));
                }
                body.setF_81354da(element.getFirstChild().getAttributes().getNamedItem("id").getNodeValue());
            }
        } else if (element.getAttribute("name").equalsIgnoreCase("f_b17e536")) {
            if (element.getFirstChild() != null) {
                if (element.getChildNodes().getLength() > 0) {
                    throw new Exception(element.getAttribute("name"));
                }
                body.setF_b17e536(Boolean.valueOf(element.getFirstChild().getAttributes().getNamedItem("id").getNodeValue()));
            }
        } else if (element.getAttribute("name").equalsIgnoreCase("f_71d0034")) {
            if (element.getFirstChild() != null) {
                if (element.getChildNodes().getLength() > 0) {
                    throw new Exception(element.getAttribute("name"));
                }
                body.setF_71d0034(element.getFirstChild().getAttributes().getNamedItem("id").getNodeValue());
            }
        } else if (element.getAttribute("name").equalsIgnoreCase("f_f1a8493")) {
            if (element.getFirstChild() != null) {
                if (element.getChildNodes().getLength() > 0) {
                    throw new Exception(element.getAttribute("name"));
                }
                body.setF_f1a8493(element.getFirstChild().getAttributes().getNamedItem("id").getNodeValue());
            }
        } else if (element.getAttribute("name").equalsIgnoreCase("f_0128c2b")) {
            if (element.getFirstChild() != null) {
                if (element.getChildNodes().getLength() > 0) {
                    throw new Exception(element.getAttribute("name"));
                }
                body.setF_0128c2b(element.getFirstChild().getAttributes().getNamedItem("id").getNodeValue());
            }
        } else if (element.getAttribute("name").equalsIgnoreCase("f_617684e")) {
            if (element.getFirstChild() != null) {
                if (element.getChildNodes().getLength() > 0) {
                    throw new Exception(element.getAttribute("name"));
                }
                body.setF_617684e(element.getFirstChild().getAttributes().getNamedItem("id").getNodeValue());
            }
        } else if (element.getAttribute("name").equalsIgnoreCase("f_91206cf")) {
            if (element.getFirstChild() != null) {
                if (element.getChildNodes().getLength() > 0) {
                    throw new Exception(element.getAttribute("name"));
                }
                body.setF_91206cf(element.getFirstChild().getAttributes().getNamedItem("id").getNodeValue());
            }
        } else if (element.getAttribute("name").equalsIgnoreCase("f_0117892")) {
            if (element.getFirstChild() != null) {
                if (element.getChildNodes().getLength() > 0) {
                    throw new Exception(element.getAttribute("name"));
                }
                body.setF_0117892(element.getFirstChild().getAttributes().getNamedItem("id").getNodeValue());
            }
        } else if (element.getAttribute("name").equalsIgnoreCase("f_5160d55")) {
            if (element.getFirstChild() != null) {
                if (element.getChildNodes().getLength() > 0) {
                    throw new Exception(element.getAttribute("name"));
                }
                body.setF_5160d55(element.getFirstChild().getAttributes().getNamedItem("id").getNodeValue());
            }
        } else if (element.getAttribute("name").equalsIgnoreCase("f_f190f6d")) {
            if (element.getFirstChild() != null) {
                if (element.getChildNodes().getLength() > 0) {
                    throw new Exception(element.getAttribute("name"));
                }
                body.setF_f190f6d(element.getFirstChild().getAttributes().getNamedItem("id").getNodeValue());
            }
        } else if (element.getAttribute("name").equalsIgnoreCase("f_91731bb")) {
            if (element.getFirstChild() != null) {
                if (element.getChildNodes().getLength() > 0) {
                    throw new Exception(element.getAttribute("name"));
                }
                body.setF_91731bb(element.getFirstChild().getAttributes().getNamedItem("id").getNodeValue());
            }
        } else if (element.getAttribute("name").equalsIgnoreCase("f_b1b9b6b")) {
            if (element.getFirstChild() != null) {
                if (element.getChildNodes().getLength() > 0) {
                    throw new Exception(element.getAttribute("name"));
                }
                body.setF_b1b9b6b(element.getFirstChild().getAttributes().getNamedItem("id").getNodeValue());
            }
        } else if (element.getAttribute("name").equalsIgnoreCase("f_31db8dd")) {
            if (element.getFirstChild() != null) {
                if (element.getChildNodes().getLength() > 0) {
                    throw new Exception(element.getAttribute("name"));
                }
                body.setF_31db8dd(element.getFirstChild().getAttributes().getNamedItem("id").getNodeValue());
            }
        } else if (element.getAttribute("name").equalsIgnoreCase("f_e13283f")) {
            if (element.getFirstChild() != null) {
                if (element.getChildNodes().getLength() > 0) {
                    throw new Exception(element.getAttribute("name"));
                }
                body.setF_e13283f(element.getFirstChild().getAttributes().getNamedItem("id").getNodeValue());
            }
        } else if (element.getAttribute("name").equalsIgnoreCase("f_6132ec7")) {
            if (element.getFirstChild() != null) {
                if (element.getChildNodes().getLength() > 0) {
                    throw new Exception(element.getAttribute("name"));
                }
                body.setF_6132ec7(element.getFirstChild().getAttributes().getNamedItem("id").getNodeValue());
            }
        } else if (element.getAttribute("name").equalsIgnoreCase("f_91a65e5")) {
            if (element.getFirstChild() != null) {
                if (element.getChildNodes().getLength() > 0) {
                    throw new Exception(element.getAttribute("name"));
                }
                body.setF_91a65e5(element.getFirstChild().getAttributes().getNamedItem("id").getNodeValue());
            }
        } else if (element.getAttribute("name").equalsIgnoreCase("f_a1e9947")) {
            if (element.getFirstChild() != null) {
                if (element.getChildNodes().getLength() > 0) {
                    throw new Exception(element.getAttribute("name"));
                }
                body.setF_a1e9947(element.getFirstChild().getAttributes().getNamedItem("id").getNodeValue());
            }
        } else if (element.getAttribute("name").equalsIgnoreCase("f_317e523")) {
            if (element.getFirstChild() != null) {
                if (element.getChildNodes().getLength() > 0) {
                    throw new Exception(element.getAttribute("name"));
                }
                body.setF_317e523(element.getFirstChild().getAttributes().getNamedItem("id").getNodeValue());
            }
        } else if (element.getAttribute("name").equalsIgnoreCase("f_a1235e8")) {
            if (element.getFirstChild() != null) {
                if (element.getChildNodes().getLength() > 0) {
                    throw new Exception(element.getAttribute("name"));
                }
                body.setF_a1235e8(element.getFirstChild().getAttributes().getNamedItem("id").getNodeValue());
            }
        } else if (element.getAttribute("name").equalsIgnoreCase("f_f12af48")) {
            if (element.getFirstChild() != null) {
                if (element.getChildNodes().getLength() > 0) {
                    throw new Exception(element.getAttribute("name"));
                }
                body.setF_f12af48(element.getFirstChild().getAttributes().getNamedItem("id").getNodeValue());
            }
        } else if (element.getAttribute("name").equalsIgnoreCase("f_e1ea714")) {
            if (element.getFirstChild() != null) {
                if (element.getChildNodes().getLength() > 0) {
                    throw new Exception(element.getAttribute("name"));
                }
                body.setF_e1ea714(element.getFirstChild().getAttributes().getNamedItem("id").getNodeValue());
            }
        } else if (element.getAttribute("name").equalsIgnoreCase("f_f1134c2")) {
            if (element.getFirstChild() != null) {
                if (element.getChildNodes().getLength() > 0) {
                    throw new Exception(element.getAttribute("name"));
                }
                body.setF_f1134c2(Boolean.valueOf(element.getFirstChild().getAttributes().getNamedItem("id").getNodeValue()));
            }
        } else if (element.getAttribute("name").equalsIgnoreCase("f_d12082e")) {
            if (element.getFirstChild() != null) {
                if (element.getChildNodes().getLength() > 0) {
                    throw new Exception(element.getAttribute("name"));
                }
                body.setF_d12082e(element.getFirstChild().getAttributes().getNamedItem("id").getNodeValue());
            }
        } else if (element.getAttribute("name").equalsIgnoreCase("f_4197d8d")) {
            if (element.getFirstChild() != null) {
                if (element.getChildNodes().getLength() > 0) {
                    throw new Exception(element.getAttribute("name"));
                }
                body.setF_4197d8d(element.getFirstChild().getAttributes().getNamedItem("id").getNodeValue());
            }
        } else if (element.getAttribute("name").equalsIgnoreCase("f_a1094d9")) {
            if (element.getFirstChild() != null) {
                if (element.getChildNodes().getLength() > 0) {
                    throw new Exception(element.getAttribute("name"));
                }
                body.setF_a1094d9(element.getFirstChild().getAttributes().getNamedItem("id").getNodeValue());
            }
        } else if (element.getAttribute("name").equalsIgnoreCase("f_217c7c3")) {
            if (element.getFirstChild() != null) {
                if (element.getChildNodes().getLength() > 0) {
                    throw new Exception(element.getAttribute("name"));
                }
                body.setF_217c7c3(element.getFirstChild().getAttributes().getNamedItem("id").getNodeValue());
            }
        } else if (element.getAttribute("name").equalsIgnoreCase("f_71ccc4e")) {
            if (element.getFirstChild() != null) {
                if (element.getChildNodes().getLength() > 0) {
                    throw new Exception(element.getAttribute("name"));
                }
                body.setF_71ccc4e(element.getFirstChild().getAttributes().getNamedItem("id").getNodeValue());
            }
        } else if (element.getAttribute("name").equalsIgnoreCase("f_41d6e17")) {
            if (element.getFirstChild() != null) {
                if (element.getChildNodes().getLength() > 0) {
                    throw new Exception(element.getAttribute("name"));
                }
                body.setF_41d6e17(element.getFirstChild().getAttributes().getNamedItem("id").getNodeValue());
            }
        } else if (element.getAttribute("name").equalsIgnoreCase("f_e18f97f")) {
            if (element.getFirstChild() != null) {
                if (element.getChildNodes().getLength() > 0) {
                    throw new Exception(element.getAttribute("name"));
                }
                body.setF_e18f97f(element.getFirstChild().getAttributes().getNamedItem("id").getNodeValue());
            }
        } else if (element.getAttribute("name").equalsIgnoreCase("f_91b1931")) {
            if (element.getFirstChild() != null) {
                if (element.getChildNodes().getLength() > 0) {
                    throw new Exception(element.getAttribute("name"));
                }
                body.setF_91b1931(element.getFirstChild().getAttributes().getNamedItem("id").getNodeValue());
            }
        } else if (element.getAttribute("name").equalsIgnoreCase("f_5117f9f")) {
            if (element.getFirstChild() != null) {
                if (element.getChildNodes().getLength() > 0) {
                    throw new Exception(element.getAttribute("name"));
                }
                body.setF_5117f9f(element.getFirstChild().getAttributes().getNamedItem("id").getNodeValue());
            }
        } else if (element.getAttribute("name").equalsIgnoreCase("f_61a74c9")) {
            if (element.getFirstChild() != null) {
                if (element.getChildNodes().getLength() > 0) {
                    throw new Exception(element.getAttribute("name"));
                }
                body.setF_61a74c9(Boolean.valueOf(element.getFirstChild().getAttributes().getNamedItem("id").getNodeValue()));
            }
        } else if (element.getAttribute("name").equalsIgnoreCase("f_51ffc18")) {
            if (element.getFirstChild() != null) {
                if (element.getChildNodes().getLength() > 0) {
                    throw new Exception(element.getAttribute("name"));
                }
                body.setF_51ffc18(element.getFirstChild().getAttributes().getNamedItem("id").getNodeValue());
            }
        } else if (element.getAttribute("name").equalsIgnoreCase("f_9143a8b")) {
            if (element.getFirstChild() != null) {
                if (element.getChildNodes().getLength() > 0) {
                    throw new Exception(element.getAttribute("name"));
                }
                body.setF_9143a8b(element.getFirstChild().getAttributes().getNamedItem("id").getNodeValue());
            }
        } else if (element.getAttribute("name").equalsIgnoreCase("f_21961d1")) {
            if (element.getFirstChild() != null) {
                if (element.getChildNodes().getLength() > 0) {
                    throw new Exception(element.getAttribute("name"));
                }
                body.setF_21961d1(element.getFirstChild().getAttributes().getNamedItem("id").getNodeValue());
            }
        } else if (element.getAttribute("name").equalsIgnoreCase("f_61d7da1")) {
            if (element.getFirstChild() != null) {
                if (element.getChildNodes().getLength() > 0) {
                    throw new Exception(element.getAttribute("name"));
                }
                body.setF_61d7da1(element.getFirstChild().getAttributes().getNamedItem("id").getNodeValue());
            }
        } else if (element.getAttribute("name").equalsIgnoreCase("f_912bdc9")) {
            if (element.getFirstChild() != null) {
                if (element.getChildNodes().getLength() > 0) {
                    throw new Exception(element.getAttribute("name"));
                }
                body.setF_912bdc9(element.getFirstChild().getAttributes().getNamedItem("id").getNodeValue());
            }
        } else if (element.getAttribute("name").equalsIgnoreCase("f_913edef")) {
            if (element.getFirstChild() != null) {
                if (element.getChildNodes().getLength() > 0) {
                    throw new Exception(element.getAttribute("name"));
                }
                body.setF_913edef(element.getFirstChild().getAttributes().getNamedItem("id").getNodeValue());
            }
        } else if (element.getAttribute("name").equalsIgnoreCase("f_e19c908")) {
            if (element.getFirstChild() != null) {
                if (element.getChildNodes().getLength() > 0) {
                    throw new Exception(element.getAttribute("name"));
                }
//                body.setF_e13283f(element.getFirstChild().getAttributes().getNamedItem("id").getNodeValue());
            }
        } else if (element.getAttribute("name").equalsIgnoreCase("f_e178960")) {
            if (element.getFirstChild() != null) {
                if (element.getChildNodes().getLength() > 0) {
                    throw new Exception(element.getAttribute("name"));
                }
//                body.setF_e13283f(element.getFirstChild().getAttributes().getNamedItem("id").getNodeValue());
            }
        } else if (element.getAttribute("name").equalsIgnoreCase("f_01f4217")) {

        } else if (element.getAttribute("name").equalsIgnoreCase("f_e134017")) {

        } else if (element.getAttribute("name").equalsIgnoreCase("f_e1f4c72")) {

        } else if (element.getAttribute("name").equalsIgnoreCase("f_c1a5f64")) {

        } else if (element.getAttribute("name").equalsIgnoreCase("f_31e6165")) {

        } else if (element.getAttribute("name").equalsIgnoreCase("f_017ea0e")) {

        } else if (element.getAttribute("name").equalsIgnoreCase("f_a1bbbd0")) {

        } else if (element.getAttribute("name").equalsIgnoreCase("f_c1b334d")) {

        } else if (element.getAttribute("name").equalsIgnoreCase("f_81e7ece")) {

        } else if (element.getAttribute("name").equalsIgnoreCase("f_a17ec5c")) {

        } else if (element.getAttribute("name").equalsIgnoreCase("f_41ae2b2")) {

        } else if (element.getAttribute("name").equalsIgnoreCase("f_f17ee32")) {

        } else if (element.getAttribute("name").equalsIgnoreCase("f_fiostructure")) {

        } else if (element.getAttribute("name").equalsIgnoreCase("f_2155892")) {

        } else if (element.getAttribute("name").equalsIgnoreCase("f_1143df2")) {

        } else if (element.getAttribute("name").equalsIgnoreCase("f_d1ffcfd")) {

        } else if (element.getAttribute("name").equalsIgnoreCase("f_1119b0f")) {

        } else if (element.getAttribute("name").equalsIgnoreCase("f_d1f8a37")) {

        } else if (element.getAttribute("name").equalsIgnoreCase("f_c12cfac")) {

        } else if (element.getAttribute("name").equalsIgnoreCase("f_a1b73a8")) {

        } else if (element.getAttribute("name").equalsIgnoreCase("f_112b79c")) {

        } else if (element.getAttribute("name").equalsIgnoreCase("f_31fc45f")) {

        } else if (element.getAttribute("name").equalsIgnoreCase("f_b1a3034")) {

        } else if (element.getAttribute("name").equalsIgnoreCase("f_81eed8d")) {

        } else if (element.getAttribute("name").equalsIgnoreCase("f_d1970ba")) {

        } else if (element.getAttribute("name").equalsIgnoreCase("f_c19311b")) {

        } else if (element.getAttribute("name").equalsIgnoreCase("f_e158ee0")) {

        } else if (element.getAttribute("name").equalsIgnoreCase("f_c13b7f0")) {

        } else if (element.getAttribute("name").equalsIgnoreCase("f_41830e9")) {

        } else if (element.getAttribute("name").equalsIgnoreCase("f_21e81a6")) {

        } else if (element.getAttribute("name").equalsIgnoreCase("f_2130062")) {

        } else if (element.getAttribute("name").equalsIgnoreCase("f_b1fab9a")) {

        } else if (element.getAttribute("name").equalsIgnoreCase("f_31dc56b")) {

        } else if (element.getAttribute("name").equalsIgnoreCase("f_31f8f7c")) {

        } else if (element.getAttribute("name").equalsIgnoreCase("f_81a2a3c")) {

        } else if (element.getAttribute("name").equalsIgnoreCase("f_519145b")) {

        } else if (element.getAttribute("name").equalsIgnoreCase("f_d1c5f7d")) {

        } else if (element.getAttribute("name").equalsIgnoreCase("f_2190030")) {

        } else if (element.getAttribute("name").equalsIgnoreCase("f_d1193e2")) {

        } else if (element.getAttribute("name").equalsIgnoreCase("f_215b2e9")) {

        } else if (element.getAttribute("name").equalsIgnoreCase("f_11d6328")) {

        } else if (element.getAttribute("name").equalsIgnoreCase("f_d180879")) {

        } else if (element.getAttribute("name").equalsIgnoreCase("f_6117ead")) {

        } else if (element.getAttribute("name").equalsIgnoreCase("f_d1107e3")) {

        } else if (element.getAttribute("name").equalsIgnoreCase("f_f130ae4")) {

        } else if (element.getAttribute("name").equalsIgnoreCase("f_01692fa")) {

        } else if (element.getAttribute("name").equalsIgnoreCase("f_b12e0d5")) {

        } else if (element.getAttribute("name").equalsIgnoreCase("f_f1d8b64")) {

        } else if (element.getAttribute("name").equalsIgnoreCase("f_0190180")) {

        } else if (element.getAttribute("name").equalsIgnoreCase("f_31b92ad")) {

        } else if (element.getAttribute("name").equalsIgnoreCase("f_2149883")) {

        } else if (element.getAttribute("name").equalsIgnoreCase("f_a1cd4ff")) {

        } else if (element.getAttribute("name").equalsIgnoreCase("f_d151227")) {

        } else if (element.getAttribute("name").equalsIgnoreCase("f_6135ec8")) {

        } else if (element.getAttribute("name").equalsIgnoreCase("f_c11a6ab")) {

        } else if (element.getAttribute("name").equalsIgnoreCase("f_61fcfd3")) {

        } else if (element.getAttribute("name").equalsIgnoreCase("f_61ae463")) {

        } else if (element.getAttribute("name").equalsIgnoreCase("f_519e6cd")) {

        } else if (element.getAttribute("name").equalsIgnoreCase("f_41da707")) {

        } else if (element.getAttribute("name").equalsIgnoreCase("f_f1669da")) {

        } else if (element.getAttribute("name").equalsIgnoreCase("f_81cee9e")) {
            if (element.getFirstChild() != null) {
                if (element.getChildNodes().getLength() > 0) {
                    throw new Exception(element.getAttribute("name"));
                }
                body.setF_81cee9e(element.getFirstChild().getAttributes().getNamedItem("id").getNodeValue());
            }
        } else if (element.getAttribute("name").equalsIgnoreCase("f_01203db")) {
            if (element.getFirstChild() != null) {
                if (element.getChildNodes().getLength() > 0) {
                    throw new Exception(element.getAttribute("name"));
                }
                body.setF_01203db(element.getFirstChild().getAttributes().getNamedItem("id").getNodeValue());
            }
        } else if (element.getAttribute("name").equalsIgnoreCase("f_e15082a")) {
            if (element.getFirstChild() != null) {
                if (element.getChildNodes().getLength() > 0) {
                    throw new Exception(element.getAttribute("name"));
                }
                body.setF_e15082a(Integer.valueOf(element.getFirstChild().getAttributes().getNamedItem("id").getNodeValue()));
            }
        } else if (element.getAttribute("name").equalsIgnoreCase("f_415c2a6")) {
            if (element.getFirstChild() != null) {
                if (element.getChildNodes().getLength() > 0) {
                    throw new Exception(element.getAttribute("name"));
                }
                body.setF_415c2a6(element.getFirstChild().getAttributes().getNamedItem("id").getNodeValue());
            }
        } else if (element.getAttribute("name").equalsIgnoreCase("f_51c600b")) {
            if (element.getFirstChild() != null) {
                if (element.getChildNodes().getLength() > 0) {
                    throw new Exception(element.getAttribute("name"));
                }
                body.setF_51c600b(Integer.valueOf(element.getFirstChild().getAttributes().getNamedItem("id").getNodeValue()));
            }
        } else if (element.getAttribute("name").equalsIgnoreCase("f_715a73f")) {

        } else if (element.getAttribute("name").equalsIgnoreCase("f_c1bcdf1")) {

        } else if (element.getAttribute("name").equalsIgnoreCase("f_c1d356e")) {

        } else if (element.getAttribute("name").equalsIgnoreCase("f_516d040")) {

        } else if (element.getAttribute("name").equalsIgnoreCase("f_41dee64")) {

        } else if (element.getAttribute("name").equalsIgnoreCase("f_51dcb50")) {

        } else if (element.getAttribute("name").equalsIgnoreCase("f_b12220b")) {

        } else if (element.getAttribute("name").equalsIgnoreCase("f_415a5b5")) {

        } else if (element.getAttribute("name").equalsIgnoreCase("f_e18f309")) {

        } else if (element.getAttribute("name").equalsIgnoreCase("f_11ef657")) {

        } else if (element.getAttribute("name").equalsIgnoreCase("reiterative_document")) {
            if (element.getFirstChild() != null) {
                if (element.getChildNodes().getLength() > 0) {
                    throw new Exception(element.getAttribute("name"));
                }
                throw new Exception("reiterative_document");
            }
        }else if (element.getAttribute("name").equalsIgnoreCase("f_110ed59")) {
            if (element.getFirstChild() != null) {
                if (element.getChildNodes().getLength() > 0) {
                    throw new Exception(element.getAttribute("name"));
                }
                throw new Exception("f_110ed59");
            }
        }else if (element.getAttribute("name").equalsIgnoreCase("f_816fe90")) {
            if (element.getFirstChild() != null) {
                if (element.getChildNodes().getLength() > 0) {
                    throw new Exception(element.getAttribute("name"));
                }
                throw new Exception("f_816fe90");
            }
        } else if (element.getAttribute("name").equalsIgnoreCase("f_c155839")) {
            if (element.getFirstChild() != null) {
                if (element.getChildNodes().getLength() > 0) {
                    throw new Exception(element.getAttribute("name"));
                }
                throw new Exception("f_c155839");
            }
        } else if (element.getAttribute("name").equalsIgnoreCase("f_418ba99")) {

        } else if (element.getAttribute("name").equalsIgnoreCase("f_01594b0")) {
            if (element.getFirstChild() != null) {
                if (element.getChildNodes().getLength() > 0) {
                    throw new Exception(element.getAttribute("name"));
                }
                throw new Exception("f_01594b0");
            }
        } else if (element.getAttribute("name").equalsIgnoreCase("f_2128263")) {
            if (element.getFirstChild() != null) {
                if (element.getChildNodes().getLength() > 0) {
                    throw new Exception(element.getAttribute("name"));
                }
                throw new Exception("f_2128263");
            }
        } else if (element.getAttribute("name").equalsIgnoreCase("f_a1dbf4c")) {
            if (element.getFirstChild() != null) {
                if (element.getChildNodes().getLength() > 0) {
                    throw new Exception(element.getAttribute("name"));
                }
                throw new Exception("f_a1dbf4c");
            }
        } else if (element.getAttribute("name").equalsIgnoreCase("f_e14fb61")) {

        } else if (element.getAttribute("name").equalsIgnoreCase("f_018d364")) {
            if (element.getFirstChild() != null) {
                if (element.getChildNodes().getLength() > 0) {
                    throw new Exception(element.getAttribute("name"));
                }
                throw new Exception("f_018d364");
            }
        } else if (element.getAttribute("name").equalsIgnoreCase("f_f1e71c9")) {
            if (element.getFirstChild() != null) {
                if (element.getChildNodes().getLength() > 0) {
                    throw new Exception(element.getAttribute("name"));
                }
                throw new Exception("f_f1e71c9");
            }
        } else if (element.getAttribute("name").equalsIgnoreCase("f_61beb7b")) {
            if (element.getFirstChild() != null) {
                if (element.getChildNodes().getLength() > 0) {
                    throw new Exception(element.getAttribute("name"));
                }
                throw new Exception("f_61beb7b");
            }
        } else if (element.getAttribute("name").equalsIgnoreCase("f_11ef657")) {
            if (element.getFirstChild() != null) {
                if (element.getChildNodes().getLength() > 0) {
                    throw new Exception(element.getAttribute("name"));
                }
                throw new Exception("f_11ef657");
            }
        } else if (element.getAttribute("name").equalsIgnoreCase("f_a176820")) {

        } else if (element.getAttribute("name").equalsIgnoreCase("f_b12220b")) {
            if (element.getFirstChild() != null) {
                if (element.getChildNodes().getLength() > 0) {
                    throw new Exception(element.getAttribute("name"));
                }
                throw new Exception("f_b12220b");
            }
        } else if (element.getAttribute("name").equalsIgnoreCase("f_215f036")) {
            if (element.getFirstChild() != null) {
                if (element.getChildNodes().getLength() > 0) {
                    throw new Exception(element.getAttribute("name"));
                }
                throw new Exception("f_215f036");
            }
        } else if (element.getAttribute("name").equalsIgnoreCase("f_6197961")) {
            if (element.getFirstChild() != null) {
                if (element.getChildNodes().getLength() > 0) {
                    throw new Exception(element.getAttribute("name"));
                }
                throw new Exception("f_6197961");
            }
        } else if (element.getAttribute("name").equalsIgnoreCase("f_d16e334")) {
            if (element.getFirstChild() != null) {
                if (element.getChildNodes().getLength() > 0) {
                    throw new Exception(element.getAttribute("name"));
                }
                throw new Exception("f_d16e334");
            }
        } else if (element.getAttribute("name").equalsIgnoreCase("f_81f72f2")) {
            if (element.getFirstChild() != null) {
                if (element.getChildNodes().getLength() > 0) {
                    throw new Exception(element.getAttribute("name"));
                }
                throw new Exception("f_81f72f2");
            }
        } else if (element.getAttribute("name").equalsIgnoreCase("f_21fe761")) {
            if (element.getFirstChild() != null) {
                if (element.getChildNodes().getLength() > 0) {
                    throw new Exception(element.getAttribute("name"));
                }
                throw new Exception("f_21fe761");
            }
        } else if (element.getAttribute("name").equalsIgnoreCase("f_8129487")) {
            if (element.getFirstChild() != null) {
                if (element.getChildNodes().getLength() > 0) {
                    throw new Exception(element.getAttribute("name"));
                }
                throw new Exception("f_8129487");
            }
        } else if (element.getAttribute("name").equalsIgnoreCase("f_2182f2f")) {
            if (element.getFirstChild() != null) {
                if (element.getChildNodes().getLength() > 0) {
                    throw new Exception(element.getAttribute("name"));
                }
                throw new Exception("f_2182f2f");
            }
//                body.setReiterativeDocument(element.getFirstChild().getNodeValue());
        } else if (element.getAttribute("name").equalsIgnoreCase("f_a176f67")) {
            if (element.getFirstChild() != null) {
                if (element.getChildNodes().getLength() > 0) {
                    throw new Exception(element.getAttribute("name"));
                }
                throw new Exception("f_a176f67");
            }
//                body.setReiterativeDocument(element.getFirstChild().getNodeValue());
        } else if (element.getAttribute("name").equalsIgnoreCase("f_c1135be")) {
            if (element.getFirstChild() != null) {
                if (element.getChildNodes().getLength() > 0) {
                    throw new Exception(element.getAttribute("name"));
                }
                throw new Exception("f_c1135be");
            }
//                body.setReiterativeDocument(element.getFirstChild().getNodeValue());
        } else if (element.getAttribute("name").equalsIgnoreCase("f_c1a4c4f")) {
            if (element.getFirstChild() != null) {
                if (element.getChildNodes().getLength() > 0) {
                    throw new Exception(element.getAttribute("name"));
                }
                throw new Exception("f_c1a4c4f");
            }
        } else if (element.getAttribute("name").equalsIgnoreCase("f_51d32eb")) {
            if (element.getFirstChild() != null) {
                if (element.getChildNodes().getLength() > 0) {
                    throw new Exception(element.getAttribute("name"));
                }
                throw new Exception("f_51d32eb");
            }
        } else if (element.getAttribute("name").equalsIgnoreCase("f_d1e541f")) {
            if (element.getFirstChild() != null) {
                if (element.getChildNodes().getLength() > 0) {
                    throw new Exception(element.getAttribute("name"));
                }
                throw new Exception("f_d1e541f");
            }
        } else if (element.getAttribute("name").equalsIgnoreCase("f_e19a029")) {
            if (element.getFirstChild() != null) {
                if (element.getChildNodes().getLength() > 0) {
                    throw new Exception(element.getAttribute("name"));
                }
                body.setF_e19a029(element.getFirstChild().getAttributes().getNamedItem("id").getNodeValue());
            }
        } else if (element.getAttribute("name").equalsIgnoreCase("f_e1845ba")) {
            if (element.getFirstChild() != null) {
                if (element.getChildNodes().getLength() > 0) {
                    throw new Exception(element.getAttribute("name"));
                }
                body.setF_e1845ba(Boolean.valueOf(element.getFirstChild().getAttributes().getNamedItem("id").getNodeValue()));
            }
        } else if (element.getAttribute("name").equalsIgnoreCase("f_91b2d49")) {
            if (element.getFirstChild() != null) {
                if (element.getChildNodes().getLength() > 0) {
                    throw new Exception(element.getAttribute("name"));
                }
                throw new Exception("f_91b2d49");
            }
        } else if (element.getAttribute("name").equalsIgnoreCase("f_31b9072")) {
            if (element.getFirstChild() != null) {
                if (element.getChildNodes().getLength() > 0) {
                    throw new Exception(element.getAttribute("name"));
                }
                throw new Exception("f_31b9072");
            }
        } else if (element.getAttribute("name").equalsIgnoreCase("f_1167ce8")) {
            if (element.getFirstChild() != null) {
                if (element.getChildNodes().getLength() > 0) {
                    throw new Exception(element.getAttribute("name"));
                }
                throw new Exception("f_1167ce8");
            }
        } else {
            if (element.getParentNode().getNodeName().equalsIgnoreCase("document")) {
                throw new Exception("парсер добавь itemlist " + element.getAttribute("name"));
            }
        }
    }
}
