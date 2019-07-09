package cjs.test;

import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import cjs.entity.User;
import cjs.mapper.UserMapper;

class UserMapperTest {
	private SqlSessionFactory sqlSessionFactory;

	@BeforeEach
	void setUp() throws Exception {
		String resource = "SqlMapConfig.xml";
		// �õ������ļ���
		InputStream inputStream = Resources.getResourceAsStream(resource);
		// �����Ự����������mybatis�������ļ���Ϣ
		sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
	}

	@Test
	void testFindUserById() throws Exception {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		// ����UserMapper����mybatis�Զ�����mapper�������
		UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
		User user = userMapper.findUserById(1);
		System.out.println(user);
		sqlSession.close();
	}

	@Test
	void testInsertUser() throws Exception{
		SqlSession sqlSession = sqlSessionFactory.openSession();
		// ����UserMapper����mybatis�Զ�����mapper�������
		UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
		User user = new User();
		user.setName("root");
		user.setAge(21);
		userMapper.insertUser(user);
		System.out.println(user.getId());
		sqlSession.commit();
		sqlSession.close();
	}
}
