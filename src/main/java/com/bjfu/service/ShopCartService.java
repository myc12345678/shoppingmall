package com.bjfu.service;

import com.bjfu.entity.CartItem;
import com.bjfu.entity.OrderItem;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * 购物车
 */
public interface ShopCartService {
    String NAME_PREFIX = "shop_cart_";

    /**
     * 加购物车
     *
     * @param
     */
    void addCart(CartItem cartItem, HttpServletRequest request) throws Exception;

    /**
     * 移除
     *
     * @param cartItem
     * @param request
     */
    void remove(CartItem cartItem, HttpServletRequest request) throws Exception;

    /**
     * 查看购物车
     *
     * @param request
     * @return
     */
    List<OrderItem> listCart(HttpServletRequest request) throws Exception;
}
