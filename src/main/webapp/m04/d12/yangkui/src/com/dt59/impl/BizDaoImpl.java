/**
 * Project Name:Demo_dt59_pinhong_01
 * File Name:BizDaoImpl.java
 * Package Name:com.dt59.imp
 * Date:2018年4月12日下午7:05:52
 * Copyright (c) 2018, bluemobi All Rights Reserved.
 */

package com.dt59.impl;

import java.util.ArrayList;
import java.util.List;

import com.dt59.dao.BaseDao;
import com.dt59.dao.BizDao;
import com.dt59.entity.News;
import com.dt59.entity.Product;

/**
 * Description:   <br/>
 * Date:     2018年4月12日 下午7:05:52 <br/>
 * @author   YangKui
 * @version
 * @see
 */
public class BizDaoImpl extends BaseDao implements BizDao {
   
    @Override
    public List<News> getAllNews() {
        List<News> listnews=new ArrayList<News>();
        //  Auto-generated method stub
        try {
            String sql="SELECT * FROM news";
            pst=getCon().prepareStatement(sql);
            rs=pst.executeQuery();
            while(rs.next()){
                News ns=new News();
                ns.setNid(rs.getInt(1));
                ns.setNtitle(rs.getString(2));
                ns.setNcontent(rs.getString(3));
                ns.setNdate(rs.getDate(4));
                listnews.add(ns);
            }
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }finally{
            close(con,pst,rs);
        }
        return listnews;
    }

    @Override
    public List<Product> getAllProduct() {
        List<Product> listpro=new ArrayList<Product>();
        //  Auto-generated method stub
        try {
            String sql="SELECT * FROM product";
            pst=getCon().prepareStatement(sql);
            rs=pst.executeQuery();
            while(rs.next()){
                Product pro=new Product();
                pro.setPid(rs.getInt(1));
                pro.setPname(rs.getString(2));
                pro.setPbrand(rs.getString(3));
                pro.setPmodel(rs.getString(4));
                pro.setPrice(rs.getDouble(5));
                pro.setPpicture(rs.getString(6));
                pro.setPdes(rs.getString(7));
                listpro.add(pro);
            }
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }finally{
            close(con,pst,rs);
        }
        return listpro;
    }

}

