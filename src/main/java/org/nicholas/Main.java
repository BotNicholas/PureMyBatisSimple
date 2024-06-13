package org.nicholas;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.nicholas.mappers.StudentMapper;
import org.nicholas.models.Student;

import java.io.IOException;
import java.io.Reader;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
//        Without Mapper Interface
//        Reader reader = Resources.getResourceAsReader("mybatis/SqlMapConfig.xml"); //Resources class makes it easier to load different resources from classpath and other resources
//        SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(reader);
//        SqlSession session = sessionFactory.openSession();
//
//        Student student = new Student(0, "Mohammad", "It", 80, 984803322, "Mohamad@gmail.com");
//
//        session.insert("StudentNamespace.insert", student);
////        session.insert("insert", student);
//        System.out.println("Record has been inserted successfully!");
//        session.commit();
//        session.close();


//        With mapper interface
//        Reader reader = Resources.getResourceAsReader("mybatis/SqlMapConfig.xml");
//        SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(reader);
//        SqlSession session = sessionFactory.openSession();
//        StudentMapper mapper = session.getMapper(StudentMapper.class);
//
//        Student student = new Student(0, "Mohammad", "It", 80, 984803322, "Mohamad@gmail.com");
//        mapper.insert(student);
//
//        session.commit();
//        session.close();


//        SELECT WITHOUT MAPPER INTERFACE
//        Reader reader = Resources.getResourceAsReader("mybatis/SqlMapConfig.xml");
//        SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(reader);
//        SqlSession session = sessionFactory.openSession();
//
//        List<Student> students = session.selectList("StudentNamespace.getAll");
//
//        students.forEach(System.out::println);
//        System.out.println();
//
//        Student student = session.selectOne("StudentNamespace.getById", 1);
//
//        System.out.println(student);
//
//        session.commit();
//        session.close();

//        SELECT WITH MAPPER INTERFACE
//        Reader reader = Resources.getResourceAsReader("mybatis/SqlMapConfig.xml");
//        SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(reader);
//        SqlSession session = sessionFactory.openSession();
//        StudentMapper mapper = session.getMapper(StudentMapper.class);
//
//        mapper.getAll().forEach(System.out::println);
//        System.out.println();
//
//        System.out.println(mapper.getById(1));



//        UPDATE WITHOUT MAPPER INTERFACE
//        Reader reader = Resources.getResourceAsReader("mybatis/SqlMapConfig.xml");
//        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
//        SqlSession sqlSession = sqlSessionFactory.openSession();
//
//        Student student = sqlSession.selectOne("StudentNamespace.getById", 1);
//        System.out.println("Current student: " + student);
//
//        student.setName(student.getName() + "_COPY");
//
//        sqlSession.update("StudentNamespace.update", student);
//        sqlSession.commit();
////        sqlSession.close();
//
//        Student newStudent = sqlSession.selectOne("StudentNamespace.getById", 1);
//        System.out.println("New student: " + newStudent);
//        sqlSession.commit();
//        sqlSession.close();

//        UPDATE WITH MAPPER INTERFACE
        Reader reader = Resources.getResourceAsReader("mybatis/SqlMapConfig.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
        SqlSession sqlSession = sqlSessionFactory.openSession();
        StudentMapper studentMapper = sqlSession.getMapper(StudentMapper.class);

        Student student = studentMapper.getById(1);
        System.out.println("Current student: " + student);

        student.setName(student.getName() + "_COPY");

        studentMapper.update(student);
//        sqlSession.commit();
//        sqlSession.close();

        Student newStudent = studentMapper.getById(1);
        System.out.println("New student: " + newStudent);
        sqlSession.commit();
        sqlSession.close();
    }
}