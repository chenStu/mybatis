package cjs.test;

import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import cjs.entity.User;

public class test {

	@Test
	public void findUserById() throws Exception {
		// �����ļ�
		String resource = "SqlMapConfig.xml";
		// �õ������ļ���
		InputStream inputStream = Resources.getResourceAsStream(resource);
		// �����Ự����������mybatis�������ļ���Ϣ
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		// ͨ�������õ�SqlSession
		SqlSession sqlSession = sqlSessionFactory.openSession();
		// ͨ��SqlSession�������ݿ�
		// ��һ��������ӳ���ļ���statement��id������namespace+"."+statement��id
		// �ڶ���������ָ����ӳ���ļ�����ƥ���parameterType���͵Ĳ���
		// sqlSession.selectOne(satement, parameter)�������ӳ���ļ�����ƥ��resultType���͵Ķ���
		User user = sqlSession.selectOne("test.findUserById", 1);

		System.out.println(user);

		// �ͷ���Դ
		sqlSession.close();
	}

}
