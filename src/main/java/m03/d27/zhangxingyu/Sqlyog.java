/**
 * Project Name:lession1
 * File Name:sqlyog.java
 * Package Name:d03.m26
 * Date:2018��3��26������4:13:30
 * Copyright (c) 2018, bluemobi All Rights Reserved.
 */

package d03.m26;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Description: <br/>
 * Date: 2018��3��26�� ����4:13:30 <br/>
 * 
 * @author zhangxingyu
 * @version
 * @see
 */
public class Sqlyog {

    public static void main(String[] args) {
        Sqlyog tt = new Sqlyog();
        List<Info> list = tt.getAllInfo();
        for (Info ff : list) {
            System.out.println(ff.getId() + "\t" + ff.getName() + "\t" + ff.getAge());
        }
        Info info = new Info();
        Scanner sc = new Scanner(System.in);
        System.out.println("���������������");
        info.setName(sc.next());
        System.out.println("������������䣺");
        info.setAge(sc.nextInt());
        boolean flag = tt.add(info);
        System.out.println("��ӵĽ����" + flag);
        // System.out.println("������Ҫɾ�����:");
        // int id = sc.nextInt();
        // int flag = tt.deleteInfo(id);
        // if (flag > 0) {
        // System.out.println("ɾ���ɹ�!");
        // } else {
        // System.out.println("ɾ��ʧ�ܣ�");
        // }
        sc.close();
    }

    Connection con = null;

    PreparedStatement pst = null;

    ResultSet rs = null;

    private String url = "jdbc:mysql://localhost:3306/mydata";

    // ���ӷ���
    public Connection getCon() {
        try {
            // ��������
            Class.forName("com.mysql.jdbc.Driver");
            // ����������
            con = DriverManager.getConnection(url, "root", "root");
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }
        return con;
    }

    public void close(Connection con, Statement stt, ResultSet rs) {
        try {
            if (rs != null) {
                rs.close();
            }
            if (stt != null) {
                stt.close();
            }
            if (con != null) {
                con.close();
            }
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }
    }

    // ��ѯ�ķ���
    public List<Info> getAllInfo() {
        List<Info> list = new ArrayList<Info>();
        try {
            String sql = "SELECT * FROM info";
            pst = getCon().prepareStatement(sql);

            // ִ��
            rs = pst.executeQuery(sql);
            while (rs.next()) {
                Info ff = new Info();
                ff.setId(rs.getInt("id"));
                ff.setName(rs.getString("name"));
                ff.setAge(rs.getInt("age"));
                list.add(ff);
            }
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }
        return list;
    }

    public boolean add(Info ff) {
        boolean flag = false;
        try {
            String sql = "INSERT INTO info(NAME,age) VALUES(?,?)";
            pst = getCon().prepareStatement(sql);
            pst.setString(1, ff.getName());
            pst.setInt(2, ff.getAge());
            // ִ��
            flag = pst.execute();
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        } finally {
            close(con, pst, rs);
        }
        return flag;
    }

    public int deleteInfo(int id) {
        int flag = 0;
        try {
            String sql = "DELETE FROM info WHERE id=?";
            pst = getCon().prepareStatement(sql);
            // ��ֵ
            pst.setInt(1, id);
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
