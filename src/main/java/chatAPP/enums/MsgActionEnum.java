package chatAPP.enums;

public enum  MsgActionEnum {
    CONNECT(1, "Initialization"),
    CHAT(2, "chat message"),
    SIGNED(3, "sign message"),
    KEEPALIVE(4, "keep heart");

    public final Integer type;
    public final String content;

    MsgActionEnum(Integer type, String content) {
        this.type = type;
        this.content = content;
    }
}
