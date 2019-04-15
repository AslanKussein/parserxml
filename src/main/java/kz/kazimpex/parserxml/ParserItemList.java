package kz.kazimpex.parserxml;

import kz.kazimpex.parserxml.jpa.domain.TDocumentBody;
import org.w3c.dom.Element;

import static kz.kazimpex.parserxml.MainParser.stringToInteger;

public class ParserItemList {
    /**
     * @desc insert itemslist
     */
    public static void fullBodyItemlist(Element element, TDocumentBody body) throws Exception {

        if (element.getAttribute("name").equalsIgnoreCase("creator")) {
            if (element.getFirstChild() != null) {
                if (element.getChildNodes().getLength() > 1) {
                    throw new Exception(element.getAttribute("name"));
                }
                body.setCreator(element.getFirstChild().getAttributes().getNamedItem("id").getNodeValue());
            }
        } else if (element.getAttribute("name").equalsIgnoreCase("editor")) {
            if (element.getFirstChild() != null) {
                if (element.getChildNodes().getLength() > 1) {
                    throw new Exception(element.getAttribute("name"));
                }
                body.setEditor(element.getFirstChild().getAttributes().getNamedItem("id").getNodeValue());
            }
        } else if (element.getAttribute("name").equalsIgnoreCase("subdivision")) {
            if (element.getFirstChild() != null) {
                if (element.getChildNodes().getLength() > 1) {
                    throw new Exception(element.getAttribute("name"));
                }
                body.setSubdivision(element.getFirstChild().getAttributes().getNamedItem("id").getNodeValue());
            }
        } else if (element.getAttribute("name").equalsIgnoreCase("respondent")) {
            if (element.getFirstChild() != null) {
                if (element.getChildNodes().getLength() > 1) {
                    throw new Exception(element.getAttribute("name"));
                }
                body.setRespondent(element.getFirstChild().getAttributes().getNamedItem("id").getNodeValue());
            }
        } else if (element.getAttribute("name").equalsIgnoreCase("received_from_ws")) {
            if (element.getFirstChild() != null) {
                if (element.getChildNodes().getLength() > 1) {
                    throw new Exception(element.getAttribute("name"));
                }
                body.setReceivedFromWs(Boolean.valueOf(element.getFirstChild().getAttributes().getNamedItem("id").getNodeValue()));
            }
        } else if (element.getAttribute("name").equalsIgnoreCase("aktenplan_index")) {
            if (element.getFirstChild() != null) {
                if (element.getChildNodes().getLength() > 1) {
                    throw new Exception(element.getAttribute("name"));
                }
                body.setAktenplanIndex(element.getFirstChild().getAttributes().getNamedItem("id").getNodeValue());
            }
        } else if (element.getAttribute("name").equalsIgnoreCase("template")) {
            if (element.getFirstChild() != null) {
                if (element.getChildNodes().getLength() > 1) {
                    throw new Exception(element.getAttribute("name"));
                }
                //TODO
//                throw new Exception("template");
                body.setTemplate(element.getFirstChild().getAttributes().getNamedItem("id").getNodeValue());
            }
//
        } else if (element.getAttribute("name").equalsIgnoreCase("f_d1ef64d")) {
            if (element.getFirstChild() != null) {
                if (element.getChildNodes().getLength() > 1) {
                    throw new Exception(element.getAttribute("name"));
                }
                body.setF_d1ef64d(element.getFirstChild().getAttributes().getNamedItem("id").getNodeValue());
            }
        } else if (element.getAttribute("name").equalsIgnoreCase("f_91a30ab")) {
            if (element.getFirstChild() != null) {
                if (element.getChildNodes().getLength() > 1) {
                    throw new Exception(element.getAttribute("name"));
                }
                body.setF_91a30ab(element.getFirstChild().getAttributes().getNamedItem("id").getNodeValue());
            }
        } else if (element.getAttribute("name").equalsIgnoreCase("f_a1a0501")) {
            if (element.getFirstChild() != null) {
                if (element.getChildNodes().getLength() > 1) {
                    throw new Exception(element.getAttribute("name"));
                }
                body.setF_a1a0501(element.getFirstChild().getAttributes().getNamedItem("id").getNodeValue());
            }
        } else if (element.getAttribute("name").equalsIgnoreCase("f_013e5ba")) {
            if (element.getFirstChild() != null) {
                if (element.getChildNodes().getLength() > 1) {
                    throw new Exception(element.getAttribute("name"));
                }
                body.setF_013e5ba(element.getFirstChild().getAttributes().getNamedItem("id").getNodeValue());
            }
        } else if (element.getAttribute("name").equalsIgnoreCase("f_d1086f4")) {
            if (element.getFirstChild() != null) {
                if (element.getChildNodes().getLength() > 1) {
                    throw new Exception(element.getAttribute("name"));
                }
                body.setF_d1086f4(element.getFirstChild().getAttributes().getNamedItem("id").getNodeValue());
            }
        } else if (element.getAttribute("name").equalsIgnoreCase("f_11f9b70")) {
            if (element.getFirstChild() != null) {
                if (element.getChildNodes().getLength() > 1) {
                    throw new Exception(element.getAttribute("name"));
                }
                body.setF_11f9b70(element.getFirstChild().getAttributes().getNamedItem("id").getNodeValue());
            }
        } else if (element.getAttribute("name").equalsIgnoreCase("f_21bee31")) {
            if (element.getFirstChild() != null) {
                if (element.getChildNodes().getLength() > 1) {
                    throw new Exception(element.getAttribute("name"));
                }
                body.setF_21bee31(element.getFirstChild().getAttributes().getNamedItem("id").getNodeValue());
            }
        } else if (element.getAttribute("name").equalsIgnoreCase("f_6140f63")) {
            if (element.getFirstChild() != null) {
                if (element.getChildNodes().getLength() > 1) {
                    throw new Exception(element.getAttribute("name"));
                }
                body.setF_6140f63(stringToInteger(element.getFirstChild().getAttributes().getNamedItem("id").getNodeValue()));
            }
        } else if (element.getAttribute("name").equalsIgnoreCase("f_41afa8c")) {
            if (element.getFirstChild() != null) {
                if (element.getChildNodes().getLength() > 1) {
                    throw new Exception(element.getAttribute("name"));
                }
                body.setF_41afa8c(element.getFirstChild().getAttributes().getNamedItem("id").getNodeValue());
            }
        } else if (element.getAttribute("name").equalsIgnoreCase("f_1144b6b")) {
            if (element.getFirstChild() != null) {
                if (element.getChildNodes().getLength() > 1) {
                    throw new Exception(element.getAttribute("name"));
                }
                body.setF_1144b6b(element.getFirstChild().getAttributes().getNamedItem("id").getNodeValue());
            }
        } else if (element.getAttribute("name").equalsIgnoreCase("f_f1d9e2d")) {
            if (element.getFirstChild() != null) {
                if (element.getChildNodes().getLength() > 1) {
                    throw new Exception(element.getAttribute("name"));
                }
                body.setF_f1a5daf(element.getFirstChild().getAttributes().getNamedItem("id").getNodeValue());
//                body.setDDocLang(new DDocLang(new BigDecimal(element.getFirstChild().getAttributes().getNamedItem("id").getNodeValue())));
            }
        } else if (element.getAttribute("name").equalsIgnoreCase("f_0190180")) {
            if (element.getFirstChild() != null) {
                //TODO document
//                    throw new Exception("f_0190180");
                if (element.getChildNodes().getLength() > 1) {
                    throw new Exception(element.getAttribute("name"));
                }
                body.setF_0190180(element.getFirstChild().getAttributes().getNamedItem("id").getNodeValue());
            }
        }  else if (element.getAttribute("name").equalsIgnoreCase("f_f1a5daf")) {
            if (element.getFirstChild() != null) {
                if (element.getChildNodes().getLength() > 1) {
                    throw new Exception(element.getAttribute("name"));
                }
                body.setF_f1a5daf(element.getFirstChild().getAttributes().getNamedItem("id").getNodeValue());
            }
        } else if (element.getAttribute("name").equalsIgnoreCase("f_118f49d")) {
            if (element.getFirstChild() != null) {
                if (element.getChildNodes().getLength() > 1) {
                    throw new Exception(element.getAttribute("name"));
                }
                body.setF_118f49d(element.getFirstChild().getAttributes().getNamedItem("id").getNodeValue());
            }
        } else if (element.getAttribute("name").equalsIgnoreCase("f_61741ce")) {
            if (element.getFirstChild() != null) {
                if (element.getChildNodes().getLength() > 1) {
                    throw new Exception(element.getAttribute("name"));
                }
                body.setF_61741ce(element.getFirstChild().getAttributes().getNamedItem("id").getNodeValue());
            }
        } else if (element.getAttribute("name").equalsIgnoreCase("f_61de7d0")) {
            if (element.getFirstChild() != null) {
                if (element.getChildNodes().getLength() > 1) {
                    throw new Exception(element.getAttribute("name"));
                }
                body.setF_61de7d0(element.getFirstChild().getAttributes().getNamedItem("id").getNodeValue());
            }
        } else if (element.getAttribute("name").equalsIgnoreCase("f_01dc74d")) {
            if (element.getFirstChild() != null) {
                if (element.getChildNodes().getLength() > 1) {
                    throw new Exception(element.getAttribute("name"));
                }
                body.setF_01dc74d(element.getFirstChild().getAttributes().getNamedItem("id").getNodeValue());
            }
        } else if (element.getAttribute("name").equalsIgnoreCase("f_317d7ac")) {
            if (element.getFirstChild() != null) {
                if (element.getChildNodes().getLength() > 1) {
                    throw new Exception(element.getAttribute("name"));
                }
                body.setF_317d7ac(element.getFirstChild().getAttributes().getNamedItem("id").getNodeValue());
            }
        } else if (element.getAttribute("name").equalsIgnoreCase("f_d13446c")) {
            if (element.getFirstChild() != null) {
                if (element.getChildNodes().getLength() > 1) {
                    throw new Exception(element.getAttribute("name"));
                }
                body.setF_d13446c(element.getFirstChild().getAttributes().getNamedItem("id").getNodeValue());
            }
        } else if (element.getAttribute("name").equalsIgnoreCase("f_1112b5c")) {
            if (element.getFirstChild() != null) {
                if (element.getChildNodes().getLength() > 1) {
                    throw new Exception(element.getAttribute("name"));
                }
                body.setF_1112b5c(element.getFirstChild().getAttributes().getNamedItem("id").getNodeValue());
            }
        } else if (element.getAttribute("name").equalsIgnoreCase("f_31d5f82")) {
            if (element.getFirstChild() != null) {
                if (element.getChildNodes().getLength() > 1) {
                    throw new Exception(element.getAttribute("name"));
                }
                body.setF_31d5f82(element.getFirstChild().getAttributes().getNamedItem("id").getNodeValue());
            }
        } else if (element.getAttribute("name").equalsIgnoreCase("f_f14b399")) {
            if (element.getFirstChild() != null) {
                if (element.getChildNodes().getLength() > 1) {
                    throw new Exception(element.getAttribute("name"));
                }
                body.setF_f14b399(element.getFirstChild().getAttributes().getNamedItem("id").getNodeValue());
            }
        } else if (element.getAttribute("name").equalsIgnoreCase("f_910ca87")) {
            if (element.getFirstChild() != null) {
                if (element.getChildNodes().getLength() > 1) {
                    throw new Exception(element.getAttribute("name"));
                }
                body.setF_910ca87(element.getFirstChild().getAttributes().getNamedItem("id").getNodeValue());
            }
        } else if (element.getAttribute("name").equalsIgnoreCase("f_e1d4a4c")) {
            if (element.getFirstChild() != null) {
                if (element.getChildNodes().getLength() > 1) {
                    throw new Exception(element.getAttribute("name"));
                }
                body.setF_e1d4a4c(element.getFirstChild().getAttributes().getNamedItem("id").getNodeValue());
            }
        } else if (element.getAttribute("name").equalsIgnoreCase("f_812595a")) {
            if (element.getFirstChild() != null) {
                if (element.getChildNodes().getLength() > 1) {
                    throw new Exception(element.getAttribute("name"));
                }
                body.setF_812595a(element.getFirstChild().getAttributes().getNamedItem("id").getNodeValue());
            }
        } else if (element.getAttribute("name").equalsIgnoreCase("f_b114825")) {
            if (element.getFirstChild() != null) {
                if (element.getChildNodes().getLength() > 1) {
                    throw new Exception(element.getAttribute("name"));
                }
                body.setF_b114825(element.getFirstChild().getAttributes().getNamedItem("id").getNodeValue());
            }
        } else if (element.getAttribute("name").equalsIgnoreCase("f_8103a47")) {
            if (element.getFirstChild() != null) {
                if (element.getChildNodes().getLength() > 1) {
                    throw new Exception(element.getAttribute("name"));
                }
                body.setF_8103a47(element.getFirstChild().getAttributes().getNamedItem("id").getNodeValue());
            }
        } else if (element.getAttribute("name").equalsIgnoreCase("f_0124ea9")) {
            if (element.getFirstChild() != null) {
                if (element.getChildNodes().getLength() > 1) {
                    throw new Exception(element.getAttribute("name"));
                }
                body.setF_0124ea9(Boolean.valueOf(element.getFirstChild().getAttributes().getNamedItem("id").getNodeValue()));
            }
        } else if (element.getAttribute("name").equalsIgnoreCase("f_a16cf55")) {
            if (element.getFirstChild() != null) {
                if (element.getChildNodes().getLength() > 1) {
                    throw new Exception(element.getAttribute("name"));
                }
                body.setF_a16cf55(element.getFirstChild().getAttributes().getNamedItem("id").getNodeValue());
            }
        } else if (element.getAttribute("name").equalsIgnoreCase("f_a1f3ad4")) {
            if (element.getFirstChild() != null) {
                if (element.getChildNodes().getLength() > 1) {
                    throw new Exception(element.getAttribute("name"));
                }
                body.setF_a1f3ad4(element.getFirstChild().getAttributes().getNamedItem("id").getNodeValue());
            }
        } else if (element.getAttribute("name").equalsIgnoreCase("f_c1bcdf1")) {
            if (element.getFirstChild() != null) {
                if (element.getChildNodes().getLength() > 1) {
                    throw new Exception(element.getAttribute("name"));
                }
                body.setF_c1bcdf1(element.getFirstChild().getAttributes().getNamedItem("id").getNodeValue());
            }
        } else if (element.getAttribute("name").equalsIgnoreCase("f_f1191df")) {
            if (element.getFirstChild() != null) {
                if (element.getChildNodes().getLength() > 1) {
                    throw new Exception(element.getAttribute("name"));
                }
                body.setF_f1191df(element.getFirstChild().getAttributes().getNamedItem("id").getNodeValue());
            }
        } else if (element.getAttribute("name").equalsIgnoreCase("f_0126248")) {
            if (element.getFirstChild() != null) {
                if (element.getChildNodes().getLength() > 1) {
                    throw new Exception(element.getAttribute("name"));
                }
                body.setF_0126248(element.getFirstChild().getAttributes().getNamedItem("id").getNodeValue());
            }
        } else if (element.getAttribute("name").equalsIgnoreCase("f_e158ee0")) {
            if (element.getFirstChild() != null) {
                if (element.getChildNodes().getLength() > 1) {
                    throw new Exception(element.getAttribute("name"));
                }
                body.setF_e158ee0(element.getFirstChild().getAttributes().getNamedItem("id").getNodeValue());
            }
        } else if (element.getAttribute("name").equalsIgnoreCase("f_c19311b")) {
            if (element.getFirstChild() != null) {
                if (element.getChildNodes().getLength() > 1) {
                    throw new Exception(element.getAttribute("name"));
                }
                body.setF_c19311b(element.getFirstChild().getAttributes().getNamedItem("id").getNodeValue());
            }
        } else if (element.getAttribute("name").equalsIgnoreCase("f_f1945d5")) {
            if (element.getFirstChild() != null) {
                if (element.getChildNodes().getLength() > 1) {
                    throw new Exception(element.getAttribute("name"));
                }
                body.setF_f1945d5(element.getFirstChild().getAttributes().getNamedItem("id").getNodeValue());
            }
        } else if (element.getAttribute("name").equalsIgnoreCase("f_b18cb95")) {
            if (element.getFirstChild() != null) {
                if (element.getChildNodes().getLength() > 1) {
                    throw new Exception(element.getAttribute("name"));
                }
                body.setF_b18cb95(element.getFirstChild().getAttributes().getNamedItem("id").getNodeValue());
            }
        } else if (element.getAttribute("name").equalsIgnoreCase("f_31f7b68")) {
            if (element.getFirstChild() != null) {
                if (element.getChildNodes().getLength() > 1) {
                    throw new Exception(element.getAttribute("name"));
                }
                body.setF_31f7b68(element.getFirstChild().getAttributes().getNamedItem("id").getNodeValue());
            }
        } else if (element.getAttribute("name").equalsIgnoreCase("f_811cc63")) {
            if (element.getFirstChild() != null) {
                if (element.getChildNodes().getLength() > 1) {
                    throw new Exception(element.getAttribute("name"));
                }
                body.setF_811cc63(element.getFirstChild().getAttributes().getNamedItem("id").getNodeValue());
            }
        } else if (element.getAttribute("name").equalsIgnoreCase("f_61080a8")) {
            if (element.getFirstChild() != null) {
                if (element.getChildNodes().getLength() > 1) {
                    throw new Exception(element.getAttribute("name"));
                }
                body.setF_61080a8(Boolean.valueOf(element.getFirstChild().getAttributes().getNamedItem("id").getNodeValue()));
            }
        } else if (element.getAttribute("name").equalsIgnoreCase("f_41b26fe")) {
            if (element.getFirstChild() != null) {
                if (element.getChildNodes().getLength() > 1) {
                    throw new Exception(element.getAttribute("name"));
                }
                body.setF_41b26fe(Boolean.valueOf(element.getFirstChild().getAttributes().getNamedItem("id").getNodeValue()));
            }
        } else if (element.getAttribute("name").equalsIgnoreCase("f_a1a2ecc")) {
            if (element.getFirstChild() != null) {
                if (element.getChildNodes().getLength() > 1) {
                    throw new Exception(element.getAttribute("name"));
                }
                body.setF_a1a2ecc(Boolean.valueOf(element.getFirstChild().getAttributes().getNamedItem("id").getNodeValue()));
            }
        } else if (element.getAttribute("name").equalsIgnoreCase("f_11a8684")) {
            if (element.getFirstChild() != null) {
                if (element.getChildNodes().getLength() > 1) {
                    throw new Exception(element.getAttribute("name"));
                }
                body.setF_11a8684(element.getFirstChild().getAttributes().getNamedItem("id").getNodeValue());
            }
        } else if (element.getAttribute("name").equalsIgnoreCase("f_810be61")) {
            if (element.getFirstChild() != null) {
                if (element.getChildNodes().getLength() > 1) {
                    throw new Exception(element.getAttribute("name"));
                }
                body.setF_810be61(element.getFirstChild().getAttributes().getNamedItem("id").getNodeValue());
            }
        } else if (element.getAttribute("name").equalsIgnoreCase("f_e1744a5")) {
            if (element.getFirstChild() != null) {
                if (element.getChildNodes().getLength() > 1) {
                    throw new Exception(element.getAttribute("name"));
                }
                body.setF_e1744a5(element.getFirstChild().getAttributes().getNamedItem("id").getNodeValue());
            }
        } else if (element.getAttribute("name").equalsIgnoreCase("f_21da282")) {
            if (element.getFirstChild() != null) {
                if (element.getChildNodes().getLength() > 1) {
                    throw new Exception(element.getAttribute("name"));
                }
                body.setF_21da282(element.getFirstChild().getAttributes().getNamedItem("id").getNodeValue());
            }
        } else if (element.getAttribute("name").equalsIgnoreCase("f_a132bf2")) {
            if (element.getFirstChild() != null) {
                if (element.getChildNodes().getLength() > 1) {
                    throw new Exception(element.getAttribute("name"));
                }
                body.setF_a132bf2(element.getFirstChild().getAttributes().getNamedItem("id").getNodeValue());
            }
        } else if (element.getAttribute("name").equalsIgnoreCase("f_2132dec")) {
            if (element.getFirstChild() != null) {
                if (element.getChildNodes().getLength() > 1) {
                    throw new Exception(element.getAttribute("name"));
                }
                body.setF_2132dec(element.getFirstChild().getAttributes().getNamedItem("id").getNodeValue());
            }
        } else if (element.getAttribute("name").equalsIgnoreCase("f_41407ad")) {
            if (element.getFirstChild() != null) {
                if (element.getChildNodes().getLength() > 1) {
                    throw new Exception(element.getAttribute("name"));
                }
                body.setF_41407ad(element.getFirstChild().getAttributes().getNamedItem("id").getNodeValue());
            }
        } else if (element.getAttribute("name").equalsIgnoreCase("f_b1e1137")) {
            if (element.getFirstChild() != null) {
                if (element.getChildNodes().getLength() > 1) {
                    throw new Exception(element.getAttribute("name"));
                }
                body.setF_b1e1137(element.getFirstChild().getAttributes().getNamedItem("id").getNodeValue());
            }
        }  else if (element.getAttribute("name").equalsIgnoreCase("f_b15a02e")) {
            if (element.getFirstChild() != null) {
                if (element.getChildNodes().getLength() > 1) {
                    throw new Exception(element.getAttribute("name"));
                }
                body.setF_b15a02e(element.getFirstChild().getAttributes().getNamedItem("id").getNodeValue());
            }
        } else if (element.getAttribute("name").equalsIgnoreCase("f_61f0b14")) {
            if (element.getFirstChild() != null) {
                if (element.getChildNodes().getLength() > 1) {
                    throw new Exception(element.getAttribute("name"));
                }
                body.setF_61f0b14(element.getFirstChild().getAttributes().getNamedItem("id").getNodeValue());
            }
        } else if (element.getAttribute("name").equalsIgnoreCase("f_8172a0d")) {
            if (element.getFirstChild() != null) {
                if (element.getChildNodes().getLength() > 1) {
                    throw new Exception(element.getAttribute("name"));
                }
                body.setF_8172a0d(element.getFirstChild().getAttributes().getNamedItem("id").getNodeValue());
            }
        }  else if (element.getAttribute("name").equalsIgnoreCase("f_a188010")) {
            if (element.getFirstChild() != null) {
                if (element.getChildNodes().getLength() > 1) {
                    throw new Exception(element.getAttribute("name"));
                }
                body.setF_a188010(element.getFirstChild().getAttributes().getNamedItem("id").getNodeValue());
            }
        } else if (element.getAttribute("name").equalsIgnoreCase("f_51c8224")) {
            if (element.getFirstChild() != null) {
                if (element.getChildNodes().getLength() > 1) {
                    throw new Exception(element.getAttribute("name"));
                }
                body.setF_51c8224(element.getFirstChild().getAttributes().getNamedItem("id").getNodeValue());
            }
        } else if (element.getAttribute("name").equalsIgnoreCase("f_newversion")) {
            if (element.getFirstChild() != null) {
                if (element.getChildNodes().getLength() > 1) {
                    throw new Exception(element.getAttribute("name"));
                }
                body.setFNewversion(Boolean.valueOf(element.getFirstChild().getAttributes().getNamedItem("id").getNodeValue()));
            }
        } else if (element.getAttribute("name").equalsIgnoreCase("f_41b04ba")) {
            if (element.getFirstChild() != null) {
                if (element.getChildNodes().getLength() > 1) {
                    throw new Exception(element.getAttribute("name"));
                }
                body.setF_41b04ba(Boolean.valueOf(element.getFirstChild().getAttributes().getNamedItem("id").getNodeValue()));
            }
        }   else if (element.getAttribute("name").equalsIgnoreCase("f_615ab98")) {
            if (element.getFirstChild() != null) {
                if (element.getChildNodes().getLength() > 1) {
                    throw new Exception(element.getAttribute("name"));
                }
                body.setF_615ab98(element.getFirstChild().getAttributes().getNamedItem("id").getNodeValue());
            }
        } else if (element.getAttribute("name").equalsIgnoreCase("f_61e8b2e")) {
            if (element.getFirstChild() != null) {
                if (element.getChildNodes().getLength() > 1) {
                    throw new Exception(element.getAttribute("name"));
                }
                body.setF_61e8b2e(element.getFirstChild().getAttributes().getNamedItem("id").getNodeValue());
            }
        } else if (element.getAttribute("name").equalsIgnoreCase("f_a1d098c")) {
            if (element.getFirstChild() != null) {
                if (element.getChildNodes().getLength() > 1) {
                    throw new Exception(element.getAttribute("name"));
                }
                body.setF_a1d098c(element.getFirstChild().getAttributes().getNamedItem("id").getNodeValue());
            }
        } else if (element.getAttribute("name").equalsIgnoreCase("f_516c7c3")) {
            if (element.getFirstChild() != null) {
                if (element.getChildNodes().getLength() > 1) {
                    throw new Exception(element.getAttribute("name"));
                }
                body.setF_516c7c3(element.getFirstChild().getAttributes().getNamedItem("id").getNodeValue());
            }
        } else if (element.getAttribute("name").equalsIgnoreCase("f_51f8599")) {
            if (element.getFirstChild() != null) {
                if (element.getChildNodes().getLength() > 1) {
                    throw new Exception(element.getAttribute("name"));
                }
                body.setF_51f8599(element.getFirstChild().getAttributes().getNamedItem("id").getNodeValue());
            }
        } else if (element.getAttribute("name").equalsIgnoreCase("f_b1d7068")) {
            if (element.getFirstChild() != null) {
                if (element.getChildNodes().getLength() > 1) {
                    throw new Exception(element.getAttribute("name"));
                }
                body.setF_b1d7068(element.getFirstChild().getAttributes().getNamedItem("id").getNodeValue());
            }
        } else if (element.getAttribute("name").equalsIgnoreCase("f_710f07e")) {
            if (element.getFirstChild() != null) {
                if (element.getChildNodes().getLength() > 1) {
                    throw new Exception(element.getAttribute("name"));
                }
                throw new Exception("f_710f07e");
            }
//                body.setF_710f07e(element.getFirstChild().getAttributes().getNamedItem("id").getNodeValue());
        } else if (element.getAttribute("name").equalsIgnoreCase("f_c1699ba")) {
            if (element.getFirstChild() != null) {
                if (element.getChildNodes().getLength() > 1) {
                    throw new Exception(element.getAttribute("name"));
                }
                body.setF_c1699ba(element.getFirstChild().getAttributes().getNamedItem("id").getNodeValue());
            }
        } else if (element.getAttribute("name").equalsIgnoreCase("f_b150e8e")) {
            if (element.getFirstChild() != null) {
                if (element.getChildNodes().getLength() > 1) {
                    throw new Exception(element.getAttribute("name"));
                }
                body.setF_b150e8e(element.getFirstChild().getAttributes().getNamedItem("id").getNodeValue());
            }
        } else if (element.getAttribute("name").equalsIgnoreCase("f_table_sogl")) {
            if (element.getFirstChild() != null) {
                if (element.getChildNodes().getLength() > 1) {
                    throw new Exception(element.getAttribute("name"));
                }
                body.setFTableSogl(element.getFirstChild().getAttributes().getNamedItem("id").getNodeValue());
            }
        } else if (element.getAttribute("name").equalsIgnoreCase("f_71c7b54")) {
            if (element.getFirstChild() != null) {
                if (element.getChildNodes().getLength() > 1) {
                    throw new Exception(element.getAttribute("name"));
                }
                body.setF_71c7b54(element.getFirstChild().getAttributes().getNamedItem("id").getNodeValue());
            }
        } else if (element.getAttribute("name").equalsIgnoreCase("f_f1b6492")) {
            if (element.getFirstChild() != null) {
                if (element.getChildNodes().getLength() > 1) {
                    throw new Exception(element.getAttribute("name"));
                }
                body.setF_f1b6492(element.getFirstChild().getAttributes().getNamedItem("id").getNodeValue());
            }
        } else if (element.getAttribute("name").equalsIgnoreCase("f_416739a")) {
            if (element.getFirstChild() != null) {
                if (element.getChildNodes().getLength() > 1) {
                    throw new Exception(element.getAttribute("name"));
                }
                body.setF_416739a(element.getFirstChild().getAttributes().getNamedItem("id").getNodeValue());
            }
        } else if (element.getAttribute("name").equalsIgnoreCase("f_d16785d")) {
            if (element.getFirstChild() != null) {
                if (element.getChildNodes().getLength() > 1) {
                    throw new Exception(element.getAttribute("name"));
                }
                body.setF_d16785d(element.getFirstChild().getAttributes().getNamedItem("id").getNodeValue());
            }
        } else if (element.getAttribute("name").equalsIgnoreCase("f_d16785d")) {
            if (element.getFirstChild() != null) {
                if (element.getChildNodes().getLength() > 1) {
                    throw new Exception(element.getAttribute("name"));
                }
                throw new Exception("f_d16785d");
            }
//                body.setFD16785d(element.getFirstChild().getAttributes().getNamedItem("id").getNodeValue());
        } else if (element.getAttribute("name").equalsIgnoreCase("f_81fbc4a")) {
            if (element.getFirstChild() != null) {
                if (element.getChildNodes().getLength() > 1) {
                    throw new Exception(element.getAttribute("name"));
                }
                body.setF_81fbc4a(element.getFirstChild().getAttributes().getNamedItem("id").getNodeValue());
            }
        } else if (element.getAttribute("name").equalsIgnoreCase("f_110039e")) {
            if (element.getFirstChild() != null) {
                if (element.getChildNodes().getLength() > 1) {
                    throw new Exception(element.getAttribute("name"));
                }
                body.setF_110039e(element.getFirstChild().getAttributes().getNamedItem("id").getNodeValue());
            }
        } else if (element.getAttribute("name").equalsIgnoreCase("f_1164f84")) {
            if (element.getFirstChild() != null) {
                if (element.getChildNodes().getLength() > 1) {
                    throw new Exception(element.getAttribute("name"));
                }
                body.setF_1164f84(element.getFirstChild().getAttributes().getNamedItem("id").getNodeValue());
            }
        } else if (element.getAttribute("name").equalsIgnoreCase("f_517bae1")) {
            if (element.getFirstChild() != null) {
                if (element.getChildNodes().getLength() > 1) {
                    throw new Exception(element.getAttribute("name"));
                }
                body.setF_517bae1(element.getFirstChild().getAttributes().getNamedItem("id").getNodeValue());
            }
        } else if (element.getAttribute("name").equalsIgnoreCase("f_1112b84")) {
            if (element.getFirstChild() != null) {
                if (element.getChildNodes().getLength() > 1) {
                    throw new Exception(element.getAttribute("name"));
                }
                body.setF_1112b84(element.getFirstChild().getAttributes().getNamedItem("id").getNodeValue());
            }
        } else if (element.getAttribute("name").equalsIgnoreCase("f_6124226")) {
            if (element.getFirstChild() != null) {
                if (element.getChildNodes().getLength() > 1) {
                    throw new Exception(element.getAttribute("name"));
                }
                body.setF_6124226(element.getFirstChild().getAttributes().getNamedItem("id").getNodeValue());
            }
        } else if (element.getAttribute("name").equalsIgnoreCase("f_211a19f")) {
            if (element.getFirstChild() != null) {
                if (element.getChildNodes().getLength() > 1) {
                    throw new Exception(element.getAttribute("name"));
                }
                body.setF_211a19f(element.getFirstChild().getAttributes().getNamedItem("id").getNodeValue());
            }
        } else if (element.getAttribute("name").equalsIgnoreCase("f_c144ea1")) {
            if (element.getFirstChild() != null) {
                if (element.getChildNodes().getLength() > 1) {
                    throw new Exception(element.getAttribute("name"));
                }
                body.setF_c144ea1(element.getFirstChild().getAttributes().getNamedItem("id").getNodeValue());
            }
        } else if (element.getAttribute("name").equalsIgnoreCase("f_01b986a")) {
            if (element.getFirstChild() != null) {
                if (element.getChildNodes().getLength() > 1) {
                    throw new Exception(element.getAttribute("name"));
                }
                body.setF_01b986a(element.getFirstChild().getAttributes().getNamedItem("id").getNodeValue());
            }
        } else if (element.getAttribute("name").equalsIgnoreCase("f_71f6e48")) {
            if (element.getFirstChild() != null) {
                if (element.getChildNodes().getLength() > 1) {
                    throw new Exception(element.getAttribute("name"));
                }
                body.setF_71f6e48(element.getFirstChild().getAttributes().getNamedItem("id").getNodeValue());
            }
        } else if (element.getAttribute("name").equalsIgnoreCase("f_61f64e5")) {
            if (element.getFirstChild() != null) {
                if (element.getChildNodes().getLength() > 1) {
                    throw new Exception(element.getAttribute("name"));
                }
                body.setF_61f64e5(element.getFirstChild().getAttributes().getNamedItem("id").getNodeValue());
            }
        } else if (element.getAttribute("name").equalsIgnoreCase("f_813bcf8")) {
            if (element.getFirstChild() != null) {
                if (element.getChildNodes().getLength() > 1) {
                    throw new Exception(element.getAttribute("name"));
                }
                body.setF_813bcf8(element.getFirstChild().getAttributes().getNamedItem("id").getNodeValue());
            }
        } else if (element.getAttribute("name").equalsIgnoreCase("f_21dee2e")) {
            if (element.getFirstChild() != null) {
                if (element.getChildNodes().getLength() > 1) {
                    throw new Exception(element.getAttribute("name"));
                }
                body.setF_21dee2e(element.getFirstChild().getAttributes().getNamedItem("id").getNodeValue());
            }
        } else if (element.getAttribute("name").equalsIgnoreCase("f_410ee30")) {
            if (element.getFirstChild() != null) {
                if (element.getChildNodes().getLength() > 1) {
                    throw new Exception(element.getAttribute("name"));
                }
                body.setF_410ee30(element.getFirstChild().getAttributes().getNamedItem("id").getNodeValue());
            }
        } else if (element.getAttribute("name").equalsIgnoreCase("f_c1ff57f")) {
            if (element.getFirstChild() != null) {
                if (element.getChildNodes().getLength() > 1) {
                    throw new Exception(element.getAttribute("name"));
                }
                body.setF_c1ff57f(element.getFirstChild().getAttributes().getNamedItem("id").getNodeValue());
            }
        } else if (element.getAttribute("name").equalsIgnoreCase("f_51926e6")) {
            if (element.getFirstChild() != null) {
                if (element.getChildNodes().getLength() > 1) {
                    throw new Exception(element.getAttribute("name"));
                }
                body.setF_51926e6(element.getFirstChild().getAttributes().getNamedItem("id").getNodeValue());
            }
        } else if (element.getAttribute("name").equalsIgnoreCase("f_21e53f0")) {
            if (element.getFirstChild() != null) {
                if (element.getChildNodes().getLength() > 1) {
                    throw new Exception(element.getAttribute("name"));
                }
                body.setF_21e53f0(element.getFirstChild().getAttributes().getNamedItem("id").getNodeValue());
            }
        } else if (element.getAttribute("name").equalsIgnoreCase("f_b1fab9a")) {

        } else if (element.getAttribute("name").equalsIgnoreCase("f_31f8f7c")) {

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

        }  else if (element.getAttribute("name").equalsIgnoreCase("f_f1d8b64")) {

        } else if (element.getAttribute("name").equalsIgnoreCase("f_81cee9e")) {
            if (element.getFirstChild() != null) {
                if (element.getChildNodes().getLength() > 1) {
                    throw new Exception(element.getAttribute("name"));
                }
                body.setF_81cee9e(element.getFirstChild().getAttributes().getNamedItem("id").getNodeValue());
            }
        } else if (element.getAttribute("name").equalsIgnoreCase("reiterative_document")) {
            if (element.getFirstChild() != null) {
                if (element.getChildNodes().getLength() > 1) {
                    throw new Exception(element.getAttribute("name"));
                }
                throw new Exception("reiterative_document");
            }
//                body.setReiterativeDocument(element.getFirstChild().getNodeValue());
        } else {
            if (element.getParentNode().getNodeName().equalsIgnoreCase("document")) {
                throw new Exception("парсер добавь itemlist " + element.getAttribute("name"));
            }
        }
    }
}
