package com.lcl.hw.utils;

import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.Date;

/**
 * Created by Rain on 2017/3/15 15:21.
 */
public class test{
    public static void main1(String[] args) {
        String driver = "oracle.jdbc.driver.OracleDriver";
        String url = "jdbc:Oracle:thin:@localhost:1521:lcl";
        Statement stmt = null;
        ResultSet res = null;
        Connection conn = null;
        CallableStatement proc = null;
        String sql = " select * from userinfo";

        try {
            Class.forName(driver);
            conn = DriverManager.getConnection(url, "test1", "lcl");
            stmt = conn.createStatement();
            res = stmt.executeQuery(sql);
            while(res.next())
            {
                System.out.println(res.toString());
            }

        } catch (ClassNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }


    public static void main(String[] args) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date = new Date();
        System.out.println(date.getYear()+","+date.getTime()+","+date.getMonth());
        String d = sdf.format(new Date(date.getYear()-1,date.getMonth(),date.getDate(),date.getHours(),date.getMinutes(),date.getSeconds()));
        System.out.println(d);
        System.out.println(sdf.format(new Date()));
        HashMap map = new HashMap();
        map.put(null,1);
        ArrayList arrayList =new ArrayList();
        arrayList.add(null);
        LinkedList linkedList =new LinkedList();
        linkedList.add(1);
        ////linkedList.add(2);
        //linkedList.add(1);
        //linkedList.offer("offer");
        //linkedList.offerFirst(null);
        System.out.println(linkedList.size());
        System.out.println(linkedList.peek());
        System.out.println(linkedList.element());
        System.out.println(linkedList.toString());
    }
}
