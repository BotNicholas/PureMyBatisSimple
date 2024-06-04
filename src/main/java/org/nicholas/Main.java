package org.nicholas;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.nicholas.mappers.StudentMapper;
import org.nicholas.models.Student;

import java.io.IOException;
import java.io.Reader;

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
        Reader reader = Resources.getResourceAsReader("mybatis/SqlMapConfig.xml");
        SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(reader);
        SqlSession session = sessionFactory.openSession();
        StudentMapper mapper = session.getMapper(StudentMapper.class);

        Student student = new Student(0, "Mohammad", "It", 80, 984803322, "Mohamad@gmail.com");
        mapper.insert(student);

        session.commit();
        session.close();
    }
}