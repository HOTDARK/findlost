package cn.one.findlost.pojo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Message implements Serializable{

    private String toId;
    private String fromId;
    private List<String> messageList;
    private Userinfo toUser;//发送者那方的信息
    private String date;
    private boolean type;
    private int itemId;

    public Message(String toId, String fromId){
        this.toId = toId;
        this.fromId = fromId;
        messageList = new ArrayList<String>();
    }

    public String getToId() {
        return toId;
    }

    public void setToId(String toId) {
        this.toId = toId;
    }

    public String getFromId() {
        return fromId;
    }

    public void setFromId(String fromId) {
        this.fromId = fromId;
    }

    public List getMessageList() {
        return messageList;
    }

    public void setMessageList(List messageList) {
        this.messageList = messageList;
    }

    public Userinfo getToUser() {
        return toUser;
    }
    public void setToUser(Userinfo toUser) {
        this.toUser = toUser;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public boolean isType() {
        return type;
    }

    public void setType(boolean type) {
        this.type = type;
    }

    public int getItemId() {
        return itemId;
    }

    public void setItemId(int itemId) {
        this.itemId = itemId;
    }

    /**
     * 添加一条消息
     * @param text
     */
    public void add(String text){
        messageList.add(text);
    }

    @Override
    public String toString() {
        return "Message{" +
                "toId='" + toId + '\'' +
                ", fromId='" + fromId + '\'' +
                ", messageList=" + messageList +
                ", toUser=" + toUser +
                ", date='" + date + '\'' +
                ", type=" + type +
                ", itemId='" + itemId + '\'' +
                '}';
    }
}
