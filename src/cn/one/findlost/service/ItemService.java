package cn.one.findlost.service;

import cn.one.findlost.pojo.Item;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface ItemService {

    List<Item> queryLasted();

    List<Item> queryNext(int id);

    int addItem(Item newItem);

    int addItem(Item newItem, MultipartFile[] photos);

    String searchByKey(String key, int current);

    String searchByType(int type, int current);

    String changeStatus(String id);
}
