package cn.wgh.enumTest;

/**
 * @author wgh
 * @date 2017/10/20
 */
public enum AttachmentEnum {

    LEAVE("1","LEAVE"),

    SIGN_RECORD("2","SIGN_RECORD");

    private String key;

    private String value;

    AttachmentEnum(String key, String value) {
        this.key=key;
        this.value=value;
    }

    public String getKey(){
        return key;
    }

    public String getValue(){
        return value;
    }
}
