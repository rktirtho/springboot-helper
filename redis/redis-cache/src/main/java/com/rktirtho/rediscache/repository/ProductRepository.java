package com.rktirtho.rediscache.repository;

import com.rktirtho.rediscache.entity.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ProductRepository {

    private static final String PRODUCT_HASH = "product";
    @Autowired
    private RedisTemplate redisTemplate;


    public Product save(Product product){
        redisTemplate.opsForHash().put(PRODUCT_HASH, product.getId(), product);
        return product;
    }

    public List<Product> findAll(){
        return redisTemplate.opsForHash().values(PRODUCT_HASH);
    }

    public Product findById(int id){
        return (Product) redisTemplate.opsForHash().get(PRODUCT_HASH, id);
    }

    public String deleteProduct(int id){
        redisTemplate.opsForHash().delete(PRODUCT_HASH,id);
        return "product removed !!";
    }
}
