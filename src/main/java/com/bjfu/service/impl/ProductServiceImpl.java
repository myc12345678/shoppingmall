package com.bjfu.service.impl;

import com.bjfu.dao.ClassificationDao;
import com.bjfu.dao.ProductDao;
import com.bjfu.entity.Classification;
import com.bjfu.entity.Product;
import com.bjfu.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    private ProductDao productDao;
    @Autowired
    private ClassificationDao classificationDao;

    @Override
    public Product findById(int id) {
        return productDao.getOne(id);
    }

    @Override
    public Page<Product> findAll(Pageable pageable) {
        return productDao.findAll(pageable);
    }

    /**
     * 查找特价公告商品
     *
     * @return
     */
    @Override
    public List<Product> findHotProduct() {
        return productDao.findByIsHot(1, null);
    }

    /**
     * 查找最新商品
     *
     * @param pageable
     * @return
     */
    @Override
    public List<Product> findNewProduct(Pageable pageable) {
        // 查找两周内上架的商品
        //        Calendar calendar = Calendar.getInstance();
        //        calendar.add(Calendar.DAY_OF_MONTH, -14);
        return productDao.findNew(pageable);
    }

    /**
     * 根据一级分类查找商品
     *
     * @param cid
     * @param pageable
     * @return
     */
    @Override
    public List<Product> findByCid(int cid, Pageable pageable) {
        //查找出所有二级分类
        List<Classification> sec = classificationDao.findByParentId(cid);
        List<Integer> secIds = new ArrayList<>();
        for (Classification classification : sec) {
            secIds.add(classification.getId());
        }
        return productDao.findByCsidIn(secIds, pageable);
    }

    /**
     * 根据二级分类查找商品
     *
     * @param csid
     * @param pageable
     * @return
     */
    @Override
    public List<Product> findByCsid(int csid, Pageable pageable) {
        return productDao.findByCsid(csid, pageable);
    }

    @Override
    public List<Product> findByCsid(int csid) {
        return productDao.findByCsid(csid);
    }

    @Override
    public void update(Product product) {
        productDao.save(product);
    }

    @Override
    public int create(Product product) {
        return productDao.save(product).getId();
    }

    @Override
    public void delById(int id) {
        productDao.deleteById(id);
    }

    @Override
    public List<Product> findByTitle(String title) {
        return productDao.findByTitle(title);
    }
}
