package cn.one.findlost.dao;

import cn.one.findlost.pojo.Item;
import cn.one.findlost.pojo.ItemExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ItemMapper {
    int countByExample(ItemExample example);

    int deleteByExample(ItemExample example);

    int deleteByPrimaryKey(Long itemid);

    int insert(Item record);

    int insertSelective(Item record);

    List<Item> selectByExample(ItemExample example);

    Item selectByPrimaryKey(Long itemid);

    int updateByExampleSelective(@Param("record") Item record, @Param("example") ItemExample example);

    int updateByExample(@Param("record") Item record, @Param("example") ItemExample example);

    int updateByPrimaryKeySelective(Item record);

    int updateByPrimaryKey(Item record);
    List<Item> queryNext(Long itemid);

    List<Item> queryLasted();

    int insertItem(Item item);

    List<Item> selectType(int i, int type, int current);

    String selectImageId(Long id);

    int changeStaus(Long id);
}