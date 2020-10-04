package com.roncoo.eshop.inventory.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.roncoo.eshop.inventory.mapper.ProductInventoryMapper;
import com.roncoo.eshop.inventory.model.ProductInventory;
import com.roncoo.eshop.inventory.service.ProductInventoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

@Service
public class ProductInventoryServiceImpl implements ProductInventoryService {

    @Autowired
    private ProductInventoryMapper productInventoryMapper;

    @Autowired
    private JedisPool jedisPool;

    @Override
    public void add(ProductInventory productInventory) {
        productInventoryMapper.add(productInventory);
        Jedis jedis = jedisPool.getResource();
        jedis.set("product_inventory:" + productInventory.getProductId()+":", JSONObject.toJSONString(productInventory));
    }

    @Override
    public void update(ProductInventory productInventory) {
        productInventoryMapper.update(productInventory);
        Jedis jedis = jedisPool.getResource();
        jedis.set("product_inventory:" + productInventory.getProductId()+":", JSONObject.toJSONString(productInventory));

    }

    @Override
    public void delete(Long id) {
        ProductInventory productInventory = findById(id);
        productInventoryMapper.delete(id);
        Jedis jedis = jedisPool.getResource();
        jedis.del("product_inventory:" + productInventory.getProductId()+":");

    }

    @Override
    public ProductInventory findById(Long id) {
        return productInventoryMapper.findById(id);
    }
}
