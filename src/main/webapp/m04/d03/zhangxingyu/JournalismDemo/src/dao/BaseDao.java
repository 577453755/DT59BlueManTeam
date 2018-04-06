/**
 * Project Name:Jsp
 * File Name:BeseDao.java
 * Package Name:dao
 * Date:2018��4��6������9:43:16
 * Copyright (c) 2018, bluemobi All Rights Reserved.
 */

package dao;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Properties;

/**
 * Description: <br/>
 * Date: 2018��4��6�� ����9:43:16 <br/>
 * 
 * @author zhangxingyu
 * @version
 * @see
 */
public class BaseDao {
    protected Connection con = null;// ����ͨ��

    protected PreparedStatement pst = null;// Ԥ����

    protected ResultSet rs = null;// �����

    static String driver;

    static String url;

    static String username;

    static String userpwd;
    static {
        init();// ���ز�ͬ�����ļ��ġ�����
    }

    // ��ʼ�����ݿ�����
    public static void init() {
        Properties pro = new Properties();// Properties�ṩ�������ļ��ķ����Ͷ�ȡ�����ļ��м��ķ���
        String path = "database.properties";// �����ļ���λ��
        try {
            InputStream ist = BaseDao.class.getClassLoader().getResourceAsStream(path);// �������ļ������ķ�ʽ���
            pro.load(ist);// ���ض�����
            driver = pro.getProperty("driver");
            url = pro.getProperty("url");
            username = pro.getProperty("username");
            userpwd = pro.getProperty("password");
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }
    }

    // ���ӷ�ʽ
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

    // �رյķ���
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

    // �ж�
    public int controlDml(String sql, Object[] obj) {
        int flag = 0;
        try {
            pst = getCon().prepareStatement(sql);
            if (obj != null) {
                for (int i = 0; i < obj.length; i++) {
                    pst.setObject(i + 1, obj[i]);// ��ֵ
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
