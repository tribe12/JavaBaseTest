package cn.wgh.Utils;


import org.apache.commons.lang3.StringUtils;


/**
 * Created by wgh on 2020/11/15.
 */
public class StoreValueUtil {

    /**
     * 将字符串截取储存单位，换算为单位为M的Double值
     *
     * @param storeValue
     * @param unitBase 单位换算倍数为1024或1000
     * @return
     */
    public static Double getDoubleSubStroreUnit(String storeValue, Double unitBase){
        Double storeValueD = 0d;
        try{
            if (StringUtils.isNotEmpty(storeValue)) {
                if(storeValue.contains("K")){
                    storeValue = StringUtils.substringBeforeLast(storeValue,"K");
                    storeValueD = Double.parseDouble(storeValue)/unitBase;
                }else if(storeValue.contains("M")){
                    storeValue = StringUtils.substringBeforeLast(storeValue,"M");
                    storeValueD = Double.parseDouble(storeValue);
                }else if(storeValue.contains("G")){
                    storeValue = StringUtils.substringBeforeLast(storeValue,"G");
                    storeValueD = Double.parseDouble(storeValue)*unitBase;
                }else if(storeValue.contains("T")){
                    storeValue = StringUtils.substringBeforeLast(storeValue,"T");
                    storeValueD = Double.parseDouble(storeValue)*unitBase*unitBase;
                }else if(storeValue.contains("P")){
                    storeValue = StringUtils.substringBeforeLast(storeValue,"P");
                    storeValueD = Double.parseDouble(storeValue)*unitBase*unitBase*unitBase;
                }else if(storeValue.contains("E")){
                    storeValue = StringUtils.substringBeforeLast(storeValue,"E");
                    storeValueD = Double.parseDouble(storeValue)*unitBase*unitBase*unitBase*unitBase;
                }else if(storeValue.contains("Z")){
                    storeValue = StringUtils.substringBeforeLast(storeValue,"Z");
                    storeValueD = Double.parseDouble(storeValue)*unitBase*unitBase*unitBase*unitBase*unitBase;
                }else if(storeValue.contains("Y")){
                    storeValue = StringUtils.substringBeforeLast(storeValue,"Y");
                    storeValueD = Double.parseDouble(storeValue)*unitBase*unitBase*unitBase*unitBase*unitBase*unitBase;
                }else if(storeValue.contains("D")){
                    storeValue = StringUtils.substringBeforeLast(storeValue,"D");
                    storeValueD = Double.parseDouble(storeValue)*unitBase*unitBase*unitBase*unitBase*unitBase*unitBase*unitBase;
                }else if(storeValue.contains("N")){
                    storeValue = StringUtils.substringBeforeLast(storeValue,"N");
                    storeValueD = Double.parseDouble(storeValue)*unitBase*unitBase*unitBase*unitBase*unitBase*unitBase*unitBase*unitBase;
                }
            }else{
                storeValueD = Double.parseDouble(storeValue);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return storeValueD;
    }




}