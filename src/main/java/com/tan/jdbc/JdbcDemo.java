package com.tan.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class JdbcDemo {
    public static void main(String[] args) throws Exception {
        //注册数据库驱动
        DriverManager.registerDriver(new com.mysql.jdbc.Driver());
        //获取数据库连接
        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/spring","root","qwe.23456");
        //获取数据库预处理对象
        PreparedStatement pr = conn.prepareStatement("select * from account");
        //执行SQL语句，得到结果集
        ResultSet rs = pr.executeQuery();
        //遍历结果集
        while (rs.next()){
            System.out.println(rs.getString("name"));
        }
        //释放资源
        rs.close();
        pr.close();
        conn.close();
    }
}
