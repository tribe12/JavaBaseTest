package cn.wgh.Utils;

import org.apache.commons.lang3.StringUtils;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 解析Html中表格内容的方法
 * <p>
 * 主要针对Html中的一些table进行解析
 */
public class AnalysisHtmlTableUtil {
    private static String tr = "tr";
    private static String th = "th";
    private static String td = "td";
    private static String rowIndex = "rowIndex";
    private static String rankIndex = "rankIndex";

    /**
     * 得到某个内容在table中的行和列的位置
     *
     * @param table
     * @param text
     * @param tagName
     * @return
     */
    public static Map<String, Integer> getRowIndexAndRandIndex(Element table, String text, String tagName) {
        if (table != null) {
            Elements trs = table.select(tr);
            for (int i = 0; i < trs.size(); i++) {
                Elements tds = trs.get(i).select(tagName);
                for (int j = 0; j < tds.size(); j++) {
                    if (text.equals(tds.get(j).text())) {
                        Map<String, Integer> map = new HashMap<String, Integer>();
                        //行
                        map.put(rowIndex, i);
                        //列
                        map.put(rankIndex, j);
                        return map;
                    }
                }
            }
        }
        return null;
    }


    /**
     * 在table取第几列的第几行内容
     *
     * @param table
     * @param tdIndex
     * @param trIndex 行数
     * @param tagName 标签种类名
     * @return
     */
    public static String getTdTextByTableAndthIndexAndtrIndexAndTagName(Element table, int tdIndex, int trIndex, String tagName) {
        if (table != null) {
            Elements trs = table.select(tr);
            if (trs != null && !trs.isEmpty()) {
                Element tr1 = trs.get(trIndex);
                if (tr1 != null) {
                    Elements select = tr1.select(tagName);
                    Element element = select.get(tdIndex);
                    if (element != null) {
                        return StringUtils.remove(element.text(), ",");
                    }
                }
            }
        }
        return null;
    }

    /**
     * 在table取某个表头列名下的第几行内容
     *
     * @param table
     * @param thName
     * @param trIndex
     * @return
     */
    public static String getTdTextByTableAndthNameAndtrIndex(Element table, String thName,
                                                             int trIndex) {
        if (table != null) {
            String value = "";
            int tdIndex = 0;
            boolean findFlag = false;
            Elements ths = table.select(th);
            for (int i = 0; i < ths.size(); i++) {
                if (thName.equals(ths.get(i).text())) {
                    tdIndex = i;
                    findFlag = true;
                }
            }
            if (findFlag) {
                Elements trs = table.select(tr);
                for (int i = 0; i < trs.size(); i++) {
                    Elements tds = trs.get(i).select(td);
                    for (int j = 0; j < tds.size(); j++) {
                        if (i == trIndex && j == tdIndex) {
                            value = tds.get(tdIndex).text();
                        }
                    }
                }
                ths = null;
                trs = null;
                return value;
            }
        }
        return null;
    }


    /**
     * 在所有table中，指定某一行中，查找指定字符
     *
     * @param allTables
     * @param trText
     * @param rIndex
     * @return
     */
    public static String getTextByAllTableTr(Elements allTables, String trText,int rIndex){
        String text = null;
        if (allTables != null && allTables.isEmpty()) {
            for (Element table : allTables ) {
                if (table != null) {
                    text = getTdTextByTableAndthNameAndtrIndex(table,trText,rIndex);
                    if(StringUtils.isNotEmpty(text)){
                        return text;
                    }
                }
            }
        }
        return text;
    }


    /**
     * 根据表头查找表头偶下字段，查询范围为所有Table
     *
     * @param allTables
     * @param trText
     * @return
     */
    public static String getTextByAllTableTr(Elements allTables, String trText) {
        return getTextByAllTableTr(allTables, trText, 1);
    }


    /**
     * 获取table中指定类型的内容
     *
     * @param table
     * @param tagName
     * @return
     */
    public static List<String[]> getTableThOrTdStrArray(Element table, String tagName) {
        List<String[]> row = new ArrayList<String[]>();
        if (table != null) {
            Elements trs = table.select(tr);
            for (int i = 0; i < trs.size(); i++) {
                if (StringUtils.isNotEmpty(tagName)) {
                    Elements tds = trs.get(i).select(tagName);
                    if (tds != null && !tds.isEmpty()) {
                        String[] aa = new String[tds.size()];
                        for (int j = 0; j < tds.size(); j++) {
                            aa[j] = StringUtils.remove(tds.get(j).text(), ",");
                        }
                        row.add(aa);
                    }
                }
            }
        }
        return row;
    }


    /**
     * 获取某一个单元格后几位单元格内容
     *
     * @param doc
     * @param stdBlockSize
     * @param afterIndex
     * @return
     */
    public static String getTdTextByTdNameAndafterIndex(Document doc, String stdBlockSize, int afterIndex) {
        Elements elements = doc.getElementsMatchingText(stdBlockSize);
        if (StringUtils.isNotEmpty(stdBlockSize)) {
            int layerCount = elements.size();
            if (layerCount > afterIndex) {
                Element stdBlockSizeEle = elements.get(layerCount - afterIndex);
                Element after = stdBlockSizeEle.nextElementSibling();
                if (after == null) {
                    throw new NullPointerException("无数据-after");
                }
                Elements select = after.select(td);
                return select.text();
            }
        }
        return null;
    }


    /**
     * 获取下一个最近位置的table
     *
     * @param element
     * @return
     */
    public static Element getNextTable(Element element) {
        if (element != null) {
            String tagName = null;
            do {
                if (element != null) {
                    element = element.nextElementSibling();
                    if (element != null) {
                        tagName = element.tagName();
                    }
                } else {
                    return null;
                }
            } while (!"table".equals(tagName));
            return element;
        }
        return null;
    }


    /**
     * 通过内容和标签名获取下一个最近位置的table
     *
     * @param doc
     * @param text
     * @param tagName
     * @return
     */
    public static Element getNextTableByStrAndTag(Document doc, String text, String tagName) {
        if (doc != null && StringUtils.isNotEmpty(text) && StringUtils.isNotEmpty(tagName)) {
            //Elements elemens = doc.getElementsMatchingOwnText(text).select(tagName);
            Elements elemens = doc.select(tagName + ":matchesOwn(" + text + ")");
            if (elemens != null && !elemens.isEmpty()) {
                for (Element element : elemens) {
                    if (text.equals(element.ownText())) {
                        return getNextTable(element);
                    }
                }
            }
        }
        return null;
    }


    /**
     * 通过内容和标签名获取下一个最近位置的table直到下一个相同标签名
     *
     * @param doc
     * @param text
     * @param tagName
     * @return
     */
    public static Element getNextTablesByStrAndTagUntilTag(Document doc, String text, String tagName) {
        if (doc != null && StringUtils.isNotEmpty(text) && StringUtils.isNotEmpty(tagName)) {
            Elements elements = doc.select(tagName + ":matchesOwn(" + text + ")");
            if (elements != null && !elements.isEmpty()) {
                for (Element element : elements) {
                    if (text.equals(element.ownText())) {
                        return getNextTableUntilTag(element, tagName);
                    }
                }

            }
        }
        return null;
    }


    /**
     * 获取下一个最近位置的table直到下一个untilTagName标签名出现
     *
     * @param element
     * @param untilTagName
     * @return
     */
    public static Element getNextTableUntilTag(Element element, String untilTagName) {
        if (element != null) {
            String tagName = null;
            do {
                if (element != null) {
                    element = element.nextElementSibling();
                    if (element != null) {
                        tagName = element.tagName();
                        //如果找到下一个h3标签内容就停止
                        if (untilTagName.equals(tagName)) {
                            return null;
                        }
                    }
                } else {
                    return null;
                }
            } while (!"table".equals(tagName));
            return element;

        }
        return null;
    }




























































}
