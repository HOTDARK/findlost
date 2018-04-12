package cn.one.findlost.controller.api;

import cn.one.findlost.pojo.Item;
import cn.one.findlost.service.ItemService;
import com.alibaba.fastjson.JSON;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@ResponseBody
@RequestMapping("/api/item")
public class ItemAPI {
    @Autowired
    ItemService itemService;

    @RequestMapping("/test")
    public String test(MultipartFile file) {
        Map map = new HashMap();
        map.put("xie", "1");
        map.put("xie2", "2");
        map.put("xie3", "3");
        return file.getOriginalFilename();
    }

    /**
     * 查询最新的失物10条
     *
     * @return
     */
    @RequestMapping(value = "/queryLasted", produces = "application/json; charset=utf-8")
    public String queryLasted() {
        List<Item> items = itemService.queryLasted();
        if (items != null | items.size() > 0) {
            System.out.println(JSON.toJSONString(items));
            return JSON.toJSONString(items);
        } else {
            return null;
        }
    }

    /**
     * 查询接下来的10条
     */
    @RequestMapping(value = "/queryNext", produces = "application/json; charset=utf-8")
    public String queryNext(int id) {

        if(id==0){
            return queryLasted();
        }
        return JSON.toJSONString(itemService.queryNext(id));
    }

    /**
     * @return
     */
    @RequestMapping("/add")
    public String addItem(String itemJson, @RequestParam MultipartFile[] photos,Item newItem) {
        if(newItem == null){
            newItem = JSON.parseObject(itemJson, Item.class);
        }
        System.out.println(newItem.toString());
        if (photos.length > 0) {
            System.out.println("有照片" + photos[0].getOriginalFilename());
            return itemService.addItem(newItem, photos)+"";
        } else {
            System.out.println("无照片");
            return itemService.addItem(newItem)+"";
        }
    }

    @RequestMapping(value = "/searchByType", produces = "application/json; charset=utf-8")
    public String search(int type, int current, HttpSession session){

        return itemService.searchByType(type,current);
    }

    @RequestMapping(value = "/searchByKey", produces = "application/json; charset=utf-8")
    public String search(String key,int current) {

        return itemService.searchByKey(key, current);

    }


    @RequestMapping("/chang")
    public String changeStatus(String id){

        return itemService.changeStatus(id);
    }

}
