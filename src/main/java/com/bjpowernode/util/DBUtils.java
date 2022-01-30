package com.bjpowernode.util;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

public class DBUtils {
    private DBUtils(){}

    private static SqlSessionFactory sqlSessionFactory = null;
    static{
        String mybatis = "mybatis.xml";
        InputStream ins = null;
        try {
            ins = Resources.getResourceAsStream(mybatis);
            SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
            sqlSessionFactory = builder.build(ins);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    private static ThreadLocal<SqlSession> t = new ThreadLocal<SqlSession>();

    /**
     * 创建单例的SqlSessionFactory，返回SqlSession
     * @return
     */
    public static SqlSession getSqlSession(){
        SqlSession sqlSession = t.get();
        if (sqlSession == null) {
            sqlSession = sqlSessionFactory.openSession();
        }
        return sqlSession;
    }

    public static void closeSqlSession(SqlSession sqlSession){
        if (sqlSession != null){
            sqlSession.close();
            t.remove();
        }

    }
}
