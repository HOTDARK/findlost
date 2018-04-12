package cn.one.findlost.service;

import cn.one.findlost.dao.ItemMapper;
import cn.one.findlost.pojo.Item;
import cn.one.findlost.utils.SolrUtils;
import com.alibaba.fastjson.JSON;
import org.apache.solr.client.solrj.SolrServerException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Service
public class ItemServiceImpl implements ItemService {

    @Autowired
    ItemMapper mapper;

    @Override
    public List<Item> queryNext(int id) {
        List<Item> list = mapper.queryNext(Long.valueOf(id));
        setImageId(list);
        return list;
    }

    @Override
    public List<Item> queryLasted() {
        List<Item> items = mapper.queryLasted();
        setImageId(items);
        if (items != null | items.size() > 0) {
            for (Item item :
                    items) {
                System.out.println(item.getIamgeId());
            }
            return items;
        }
        return null;
    }

    @Override
    public int addItem(Item newItem) {
        if (newItem != null) {
            if (newItem.getCreatebyid() == null | "".equals(newItem.getCreatebyid())) {
                return -1;
            }
            return mapper.insertItem(newItem);
        } else {
            return -1;
        }
    }

    @Override
    public int addItem(Item newItem, MultipartFile[] photos) {
        String imageId = "";
        for (MultipartFile file :
                photos) {
            if (!file.isEmpty()) {
                //取得文件名称，包含后缀名
                File fiel = new File("/usr/image/" + file.getOriginalFilename());
                try {
                    if (!fiel.exists()) {
                        fiel.createNewFile();
                    }

                    file.transferTo(fiel);
                    imageId = imageId + "," + file.getOriginalFilename();
                } catch (IOException e) {
                    e.printStackTrace();
                    return -1;
                }
            }
        }
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        String format1 = format.format(new Date());

        newItem.setIamgeId(imageId);
        newItem.setDate(format1);
        newItem.setStatus(0);

        return addItem(newItem);
    }

    @Override
    public String searchByKey(String key, int current) {
        String json = null;
        try {
            System.out.println("key"+key);
            json = SolrUtils.searchBykey(key, current);
        } catch (SolrServerException e) {

            e.printStackTrace();
            return null;
        }

        return json;
    }

    @Override
    public String searchByType(int type, int current) {
        if (current <= 0) {
            current = 1;
        }
        System.out.println("type + " + type);
        List<Item> list = mapper.selectType(type, (current - 1) * 10, current * 10);
        setImageId(list);
        return JSON.toJSONString(list);
    }

    public void setImageId(List<Item> items) {

        for (Item item :
                items) {
            String s = mapper.selectImageId(item.getItemid());
            item.setIamgeId(s);
        }

    }

    @Override
    public String changeStatus(String id) {

        return mapper.changeStaus(Long.getLong(id)) + "";
    }
}
