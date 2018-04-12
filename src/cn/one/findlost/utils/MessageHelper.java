package cn.one.findlost.utils;

import cn.one.findlost.pojo.Message;

import java.util.HashMap;
import java.util.Map;

public class MessageHelper {
    private static Map<String,Message> messageMap;

    private MessageHelper() {
        messageMap = new HashMap();
    }
    private static MessageHelper message = new MessageHelper();

    static MessageHelper getMessageQueen() {
        return message;
}

    public static Message getMessage(String flag){
        Message message = messageMap.get(flag);
        messageMap.remove(flag);
        return message;
    }
    public void addMessage(Message mes){
        messageMap.put(mes.getToId(),mes);
    }

}
