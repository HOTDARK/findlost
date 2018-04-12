package cn.one.findlost.utils;

import cn.one.findlost.pojo.Item;
import com.alibaba.fastjson.JSON;
import org.apache.solr.client.solrj.SolrQuery;
import org.apache.solr.client.solrj.SolrServer;
import org.apache.solr.client.solrj.SolrServerException;
import org.apache.solr.client.solrj.impl.HttpSolrServer;
import org.apache.solr.client.solrj.response.QueryResponse;
import org.apache.solr.common.SolrDocument;
import org.apache.solr.common.SolrDocumentList;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class SolrUtils {

    public static String searchBykey(String key, int current) throws SolrServerException {
        //创建服务端链接
        SolrServer server = new HttpSolrServer("http://localhost:8080/solr");

        SolrQuery query = new SolrQuery();
        query.setQuery(key);

        query.set("df", "item_remark");
        query.setSort("id", SolrQuery.ORDER.desc);

        if(current <0){
            current = 0;
        }
        query.setStart(current * 10);
        query.setRows(10);

        QueryResponse response = server.query(query);
        SolrDocumentList results = response.getResults();

        List<Item> list = new ArrayList<>();
        for (SolrDocument document :
                results) {

            Item item = new Item();
            item.setItemid(Long.getLong((String)document.get("id")));
            item.setCreatebyid((String)document.get("item_name"));//field设置错误，这是creatByID
            item.setUsername((String)document.get("item_username"));
            item.setRemark((String)document.get("item_remark"));
            item.setIamgeId((String)document.get("item_image_id"));
            item.setDate((String)document.get("item_date"));
            item.setType(Integer.parseInt((String)document.get("item_type")));
            item.setStatus(Integer.parseInt((String)document.get("item_status")));

            list.add(item);
        }
        return JSON.toJSONString(list);
    }

    @Test
    public  void searchBykey() throws SolrServerException {
        //创建服务端链接
        SolrServer server = new HttpSolrServer("http://localhost:8080/solr");

        SolrQuery query = new SolrQuery();
        query.setQuery("谢中");

        query.set("df", "item_remark");
        query.setSort("id", SolrQuery.ORDER.desc);

        int current=0;
        query.setStart(current * 10);
        query.setRows(10);

        QueryResponse response = server.query(query);
        SolrDocumentList results = response.getResults();

        List<Item> list = new ArrayList<>();
        for (SolrDocument document :
                results) {

            Item item = new Item();
            item.setItemid(Long.getLong((String)document.get("id")));
            item.setCreatebyid((String)document.get("item_name"));//field设置错误，这是creatByID
            item.setUsername((String)document.get("item_username"));
            item.setRemark((String)document.get("item_remark"));
            item.setIamgeId((String)document.get("item_image_id"));
            item.setDate((String)document.get("item_date"));
            item.setType(Integer.parseInt((String)document.get("item_type")));
            item.setStatus(Integer.parseInt((String)document.get("item_status")));

            list.add(item);
        }
        System.out.println(JSON.toJSONString(list));
    }


}
