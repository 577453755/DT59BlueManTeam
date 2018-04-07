/**
 * Project Name:workspace1
 * File Name:BaseDao.java
 * Package Name:lession180328.dao
 * Date:2018年3月28日下午3:40:15
 * Copyright (c) 2018, bluemobi All Rights Reserved.
 */

package m03.d30.lvwei.lession180330.dao;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Properties;

/**
 * Description: <br/>
 * Date: 2018年3月28日 下午3:40:15 <br/>
 * 
 * @author lvwei
 * @version
 * @see
 */
public class BaseDao {
    protected Connection con = null;// 连接通道

    protected PreparedStatement pst = null;// 预编译

    protected ResultSet rs = null;// 结果集

    static String driver;

    static String url;

    static String username;

    static String userpwd;
    static {
        init();// 加载不同属性文件的“键”
    }

    // 初始化数据库连接
    public static void init() {
        Properties pro = new Properties();// Properties提供加属性文件的方法和读取属性文件中键的方法
        String path = "database.properties";// 属性文件的位置
        try {
            InputStream ist = BaseDao.class.getClassLoader().getResourceAsStream(path);// 把属性文件以流的方式输出
            pro.load(ist);// 加载二进流
            driver = pro.getProperty("driver");
            url = pro.getProperty("url");
            username = pro.getProperty("username");
            userpwd = pro.getProperty("password");
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }
    }

    // 连接方式
    public Connection getCon() {
        try {
            Class.forName(driver);
            con = DriverManager.getConnection(url, username, userpwd);
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }
        return con;
    }

    // 关闭的方法
    public void close(Connection con, PreparedStatement pst, ResultSet rs) {
        try {
            if (rs != null) {
                rs.close();
            }
            if (pst != null) {
                pst.close();
            }
            if (con != null) {
                con.close();
            }
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }
    }

    // 判断
    public int controlDml(String sql, Object[] obj) {
        int flag = 0;
        try {
            pst = getCon().prepareStatement(sql);
            if (obj != null) {
                for (int i = 0; i < obj.length; i++) {
                    pst.setObject(i + 1, obj[i]);// 赋值
                }
            }
            flag = pst.executeUpdate();
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        } finally {
            close(con, pst, rs);
        }
        return flag;
    }
}
