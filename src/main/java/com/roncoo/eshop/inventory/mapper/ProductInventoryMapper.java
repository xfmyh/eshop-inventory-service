package com.roncoo.eshop.inventory.mapper;

import com.roncoo.eshop.inventory.model.ProductInventory;
import org.apache.ibatis.annotations.*;


@Mapper
public interface ProductInventoryMapper {

    @Insert("insert into product_inventory(value,product_id) values(#{value},#{productId})")
    void add(ProductInventory productInventory);

    @Update("update product_inventory set value = #{value},product_id = #{productId} where id = #{id}")
    void update(ProductInventory productInventory);

    @Delete("delete from product_inventory where id = #{id}")
    void delete(Long id);

    @Select("select * from product_inventory where id = #{id}")
    @Results({
            @Result(column = "product_id",property = "productId"),
    })
    ProductInventory findById(Long id);

}
