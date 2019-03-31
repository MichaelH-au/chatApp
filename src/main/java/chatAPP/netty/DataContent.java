package chatAPP.netty;

import java.io.Serializable;

public class DataContent implements Serializable {

    private static final long serialVersionUID = -3262340694396513811L;

    private Integer action;
    private ChatMsg chatMsg;
    private String extand;

    public Integer getAction() {
        return action;
    }

    public void setAction(Integer action) {
        this.action = action;
    }

    public ChatMsg getChatMsg() {
        return chatMsg;
    }

    public void setChatMsg(ChatMsg chatMsg) {
        this.chatMsg = chatMsg;
    }

    public String getExtand() {
        return extand;
    }

    public void setExtand(String extand) {
        this.extand = extand;
    }
}
