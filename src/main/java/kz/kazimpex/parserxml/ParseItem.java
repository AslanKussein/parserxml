package kz.kazimpex.parserxml;

import kz.kazimpex.parserxml.jpa.domain.TDocumentBody;
import org.w3c.dom.Element;

import java.sql.Timestamp;

import static kz.kazimpex.parserxml.MainParser.*;

public class ParseItem {
    /**
     * @desc insert item
     */
    public static void fullBodyItem(Element element, TDocumentBody body) throws Exception {

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
        } else if (element.getAttribute("name").equalsIgnoreCase("f_612bf16")) {
            if (element.getFirstChild() != null)
                body.setF_612bf16(element.getFirstChild().getNodeValue());
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
        } else if (element.getAttribute("name").equalsIgnoreCase("f_21bee31")) {
            if (element.getFirstChild() != null)
                body.setF_21bee31(element.getFirstChild().getNodeValue());
        } else if (element.getAttribute("name").equalsIgnoreCase("f_6140f63")) {
            if (element.getFirstChild() != null)
                body.setF_6140f63(Integer.valueOf(element.getFirstChild().getNodeValue()));
        } else if (element.getAttribute("name").equalsIgnoreCase("f_c174c0a")) {
            if (element.getFirstChild() != null)
                body.setF_c174c0a(Integer.valueOf(element.getFirstChild().getNodeValue()));
        } else if (element.getAttribute("name").equalsIgnoreCase("f_f1866a6")) {
            if (element.getFirstChild() != null)
                body.setF_f1866a6(element.getFirstChild().getNodeValue());
        } else if (element.getAttribute("name").equalsIgnoreCase("f_71d186f")) {
            if (element.getFirstChild() != null)
                body.setF_71d186f(stringToDate(element.getFirstChild().getNodeValue()));
        } else if (element.getAttribute("name").equalsIgnoreCase("f_518d761")) {
            if (element.getFirstChild() != null)
                body.setF_518d761(stringToDate(element.getFirstChild().getNodeValue()));
        } else if (element.getAttribute("name").equalsIgnoreCase("f_4142142")) {
            if (element.getFirstChild() != null)
                body.setF_4142142(element.getFirstChild().getNodeValue());
        } else if (element.getAttribute("name").equalsIgnoreCase("f_b1c28d7")) {
            if (element.getFirstChild() != null)
                body.setF_b1c28d7(element.getFirstChild().getNodeValue());
        } else if (element.getAttribute("name").equalsIgnoreCase("f_617a5e4")) {
            if (element.getFirstChild() != null)
                body.setF_617a5e4(element.getFirstChild().getNodeValue());
        } else if (element.getAttribute("name").equalsIgnoreCase("f_b1cea85")) {
            if (element.getFirstChild() != null)
                body.setF_b1cea85(element.getFirstChild().getNodeValue());
        } else if (element.getAttribute("name").equalsIgnoreCase("f_b1db2e0")) {
            if (element.getFirstChild() != null)
                body.setF_b1db2e0(element.getFirstChild().getNodeValue());
        } else if (element.getAttribute("name").equalsIgnoreCase("f_d10dea5")) {
            if (element.getFirstChild() != null)
                body.setF_d10dea5(element.getFirstChild().getNodeValue());
        } else if (element.getAttribute("name").equalsIgnoreCase("f_a1e2699")) {
            if (element.getFirstChild() != null)
                body.setF_a1e2699(element.getFirstChild().getNodeValue());
        } else if (element.getAttribute("name").equalsIgnoreCase("f_c1f320f")) {
            if (element.getFirstChild() != null)
                body.setF_c1f320f(element.getFirstChild().getNodeValue());
        } else if (element.getAttribute("name").equalsIgnoreCase("f_c19417a")) {
            if (element.getFirstChild() != null)
                body.setF_c19417a(element.getFirstChild().getNodeValue());
        } else if (element.getAttribute("name").equalsIgnoreCase("f_f14f982")) {
            if (element.getFirstChild() != null)
                body.setF_f14f982(Integer.valueOf(element.getFirstChild().getNodeValue()));
        } else if (element.getAttribute("name").equalsIgnoreCase("f_e1c927f")) {
            if (element.getFirstChild() != null)
                body.setF_e1c927f(Integer.valueOf(element.getFirstChild().getNodeValue()));
        } else if (element.getAttribute("name").equalsIgnoreCase("f_817a9c2")) {
            if (element.getFirstChild() != null)
                body.setF_817a9c2(element.getFirstChild().getNodeValue());
        } else if (element.getAttribute("name").equalsIgnoreCase("f_c19c7b8")) {
            if (element.getFirstChild() != null)
                body.setF_c19c7b8(element.getFirstChild().getNodeValue());
        } else if (element.getAttribute("name").equalsIgnoreCase("f_213ac91")) {
            if (element.getFirstChild() != null)
                body.setF_213ac91(element.getFirstChild().getNodeValue());
        } else if (element.getAttribute("name").equalsIgnoreCase("f_01b1ce0")) {
            if (element.getFirstChild() != null)
                body.setF_01b1ce0(element.getFirstChild().getNodeValue());
        } else if (element.getAttribute("name").equalsIgnoreCase("f_613df48")) {
            if (element.getFirstChild() != null)
                body.setF_613df48(element.getFirstChild().getNodeValue());
        } else if (element.getAttribute("name").equalsIgnoreCase("f_e13bbcd")) {
            if (element.getFirstChild() != null)
                body.setF_e13bbcd(element.getFirstChild().getNodeValue());
        } else if (element.getAttribute("name").equalsIgnoreCase("f_f14a0f1")) {
            if (element.getFirstChild() != null)
                body.setF_f14a0f1(stringToDate(element.getFirstChild().getNodeValue()));
        } else if (element.getAttribute("name").equalsIgnoreCase("f_01b4962")) {
            if (element.getFirstChild() != null)
                body.setF_01b4962(element.getFirstChild().getNodeValue());
        } else if (element.getAttribute("name").equalsIgnoreCase("f_e13f7a4")) {
            if (element.getFirstChild() != null)
                body.setF_e13f7a4(element.getFirstChild().getNodeValue());
        } else if (element.getAttribute("name").equalsIgnoreCase("f_51a7efb")) {
            if (element.getFirstChild() != null)
                body.setF_51a7efb(element.getFirstChild().getNodeValue());
        } else if (element.getAttribute("name").equalsIgnoreCase("f_216933e")) {
            if (element.getFirstChild() != null)
                body.setF_216933e(element.getFirstChild().getNodeValue());
        } else if (element.getAttribute("name").equalsIgnoreCase("f_41526a6")) {
            if (element.getFirstChild() != null)
                body.setF_41526a6(element.getFirstChild().getNodeValue());
        } else if (element.getAttribute("name").equalsIgnoreCase("f_2115f36")) {
            if (element.getFirstChild() != null)
                body.setF_2115f36(Timestamp.valueOf(element.getFirstChild().getNodeValue()));
        } else if (element.getAttribute("name").equalsIgnoreCase("f_a1bdd0f")) {
            if (element.getFirstChild() != null)
                body.setF_a1bdd0f(element.getFirstChild().getNodeValue());
        } else if (element.getAttribute("name").equalsIgnoreCase("f_outgoing_id")) {
            if (element.getFirstChild() != null)
                body.setF_outgoing_id(element.getFirstChild().getNodeValue());
        } else if (element.getAttribute("name").equalsIgnoreCase("f_8163e7e")) {
            if (element.getFirstChild() != null)
                body.setF_8163e7e(element.getFirstChild().getNodeValue());
        } else if (element.getAttribute("name").equalsIgnoreCase("f_617dc28")) {
            if (element.getFirstChild() != null)
                body.setF_617dc28(element.getFirstChild().getNodeValue());
        } else if (element.getAttribute("name").equalsIgnoreCase("f_a16a54b")) {
            if (element.getFirstChild() != null)
                body.setF_a16a54b(element.getFirstChild().getNodeValue());
        } else if (element.getAttribute("name").equalsIgnoreCase("f_c19af22")) {
            if (element.getFirstChild() != null)
                body.setF_c19af22(element.getFirstChild().getNodeValue());
        } else if (element.getAttribute("name").equalsIgnoreCase("f_014fb7f")) {
            if (element.getFirstChild() != null)
                body.setF_014fb7f(element.getFirstChild().getNodeValue());
        } else if (element.getAttribute("name").equalsIgnoreCase("f_412b102")) {
            if (element.getFirstChild() != null)
                body.setF_412b102(element.getFirstChild().getNodeValue());
        } else if (element.getAttribute("name").equalsIgnoreCase("f_b17cd29")) {
            if (element.getFirstChild() != null)
                body.setF_b17cd29(element.getFirstChild().getNodeValue());
        } else if (element.getAttribute("name").equalsIgnoreCase("f_81baaa6")) {
            if (element.getFirstChild() != null)
                body.setF_81baaa6(element.getFirstChild().getNodeValue());
        } else if (element.getAttribute("name").equalsIgnoreCase("f_3178434")) {
            if (element.getFirstChild() != null)
                body.setF_3178434(element.getFirstChild().getNodeValue());
        } else if (element.getAttribute("name").equalsIgnoreCase("f_91877ec")) {
            if (element.getFirstChild() != null)
                body.setF_91877ec(element.getFirstChild().getNodeValue());
        } else if (element.getAttribute("name").equalsIgnoreCase("f_e181b8f")) {
            if (element.getFirstChild() != null)
                body.setF_e181b8f(element.getFirstChild().getNodeValue());
        } else if (element.getAttribute("name").equalsIgnoreCase("f_5106d93")) {
            if (element.getFirstChild() != null)
                body.setF_5106d93(element.getFirstChild().getNodeValue());
        } else if (element.getAttribute("name").equalsIgnoreCase("f_01e8867")) {
            if (element.getFirstChild() != null)
                body.setF_01e8867(element.getFirstChild().getNodeValue());
        } else if (element.getAttribute("name").equalsIgnoreCase("f_d131ae5")) {
            if (element.getFirstChild() != null)
                body.setF_d131ae5(element.getFirstChild().getNodeValue());
        } else if (element.getAttribute("name").equalsIgnoreCase("f_41fba3c")) {
            if (element.getFirstChild() != null)
                body.setF_41fba3c(element.getFirstChild().getNodeValue());
        } else if (element.getAttribute("name").equalsIgnoreCase("f_41b6044")) {
            if (element.getFirstChild() != null)
                body.setF_41b6044(Timestamp.valueOf(element.getFirstChild().getNodeValue()));
        } else if (element.getAttribute("name").equalsIgnoreCase("f_e1ef1f4")) {
            if (element.getFirstChild() != null)
                body.setF_e1ef1f4(Timestamp.valueOf(element.getFirstChild().getNodeValue()));
        } else if (element.getAttribute("name").equalsIgnoreCase("f_7176eb0")) {
            if (element.getFirstChild() != null)
                body.setF_7176eb0(Timestamp.valueOf(element.getFirstChild().getNodeValue()));
        } else if (element.getAttribute("name").equalsIgnoreCase("f_11fb094")) {
            if (element.getFirstChild() != null)
                body.setF_11fb094(Timestamp.valueOf(element.getFirstChild().getNodeValue()));
        } else if (element.getAttribute("name").equalsIgnoreCase("f_61e013a")) {
            if (element.getFirstChild() != null)
                body.setF_61e013a(Integer.valueOf(element.getFirstChild().getNodeValue()));
        } else if (element.getAttribute("name").equalsIgnoreCase("f_b11ab59")) {
            if (element.getFirstChild() != null)
                body.setF_b11ab59(element.getFirstChild().getNodeValue());
        } else if (element.getAttribute("name").equalsIgnoreCase("f_916d9c2")) {
            if (element.getFirstChild() != null)
                body.setF_916d9c2(element.getFirstChild().getNodeValue());
        } else if (element.getAttribute("name").equalsIgnoreCase("f_21dd76a")) {
            if (element.getFirstChild() != null)
                body.setF_21dd76a(Float.parseFloat(element.getFirstChild().getNodeValue()));
        } else if (element.getAttribute("name").equalsIgnoreCase("f_e102bf4")) {
            if (element.getFirstChild() != null)
                body.setF_e102bf4(element.getFirstChild().getNodeValue());
        } else if (element.getAttribute("name").equalsIgnoreCase("f_415a546")) {
            if (element.getFirstChild() != null)
                body.setF_415a546(element.getFirstChild().getNodeValue());
        } else if (element.getAttribute("name").equalsIgnoreCase("f_b13a798")) {
            if (element.getFirstChild() != null)
                body.setF_b13a798(Integer.valueOf(element.getFirstChild().getNodeValue()));
        } else if (element.getAttribute("name").equalsIgnoreCase("f_4116307")) {
            if (element.getFirstChild() != null)
                body.setF_4116307(element.getFirstChild().getNodeValue());
        } else if (element.getAttribute("name").equalsIgnoreCase("f_61cbe68")) {
            if (element.getFirstChild() != null)
                body.setF_61cbe68(element.getFirstChild().getNodeValue());
        } else if (element.getAttribute("name").equalsIgnoreCase("f_914b6fc")) {
            if (element.getFirstChild() != null)
                body.setF_914b6fc(element.getFirstChild().getNodeValue());
        } else if (element.getAttribute("name").equalsIgnoreCase("f_91727ca")) {
            if (element.getFirstChild() != null)
                body.setF_91727ca(element.getFirstChild().getNodeValue());
        } else if (element.getAttribute("name").equalsIgnoreCase("f_f1eef5a")) {
            if (element.getFirstChild() != null)
                body.setF_f1eef5a(element.getFirstChild().getNodeValue());
        } else if (element.getAttribute("name").equalsIgnoreCase("f_11c36e3")) {
            if (element.getFirstChild() != null)
                body.setF_11c36e3(element.getFirstChild().getNodeValue());
        }else if (element.getAttribute("name").equalsIgnoreCase("f_818fdf9")) {
            if (element.getFirstChild() != null)
                body.setF_818fdf9(element.getFirstChild().getNodeValue());
        }else if (element.getAttribute("name").equalsIgnoreCase("f_c193cb2")) {
            if (element.getFirstChild() != null)
                body.setF_c193cb2(element.getFirstChild().getNodeValue());
        }else if (element.getAttribute("name").equalsIgnoreCase("f_a1aa2ab")) {
            if (element.getFirstChild() != null)
                body.setF_a1aa2ab(element.getFirstChild().getNodeValue());
        }else if (element.getAttribute("name").equalsIgnoreCase("f_0158a26")) {
            if (element.getFirstChild() != null)
                body.setF_0158a26(element.getFirstChild().getNodeValue());
        } else {
            if (element.getParentNode().getNodeName().equalsIgnoreCase("document")) {
                throw new Exception("парсер добавь item " + element.getAttribute("name"));
            }
        }
    }
}