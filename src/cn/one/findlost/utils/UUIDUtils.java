package cn.one.findlost.utils;

import java.util.UUID;

public class UUIDUtils {
    public static String getUUID(){
        UUID uuid = UUID.randomUUID();
        String strUuid = uuid.toString();
        strUuid = strUuid.replace("-","");
        return strUuid;
    }
}
