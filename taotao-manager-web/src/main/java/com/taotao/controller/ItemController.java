package com.taotao.controller;

import com.taotao.common.pojo.TaotaoResult;
import com.taotao.pojo.TbItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.taotao.common.pojo.EasyUIDataGridResult;
import com.taotao.service.ItemService;

@Controller
public class ItemController {
    @Autowired
    private ItemService itemService;

    //url:/item/list
    //method:get
    //参数：page,rows
    //返回值:json
    @RequestMapping(value = "/item/list", method = RequestMethod.GET)
    @ResponseBody
    public EasyUIDataGridResult getItemList(Integer page, Integer rows) {
        //1.引入服务
        //2.注入服务
        //3.调用服务的方法
        return itemService.getItemList(page, rows);
    }

    @RequestMapping("/item/save")
    @ResponseBody
    public TaotaoResult saveItem(TbItem item, String desc) {
        TaotaoResult result = itemService.saveItem(item, desc);
        return result;
    }

    @RequestMapping("/rest/item/delete")
    @ResponseBody
    public TaotaoResult deleteItem(String ids) {
        String[] split = ids.split(",");
        for (String s : split) {
            Long id = Long.valueOf(s);
            itemService.deleteById(id);
        }
        return TaotaoResult.ok();
    }
}
