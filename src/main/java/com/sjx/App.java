package com.sjx;

import com.sjx.dao.StuMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.InputStream;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {

        try {
            InputStream is = Resources.getResourceAsStream("mybatis-config.xml");
            SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(is);
            SqlSession sqlSession = sqlSessionFactory.openSession();

            //mybatis通过JDK的动态代理方式，在启动加载配置文件时
            //根据配置的mapper.xml去生成该接口的实现类
            StuMapper stuMapper = sqlSession.getMapper(StuMapper.class);
            System.out.println("信息表中有："+stuMapper.count()+"条数据!");
            sqlSession.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
