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

        Reader reader = Resources.getResourceAsReader("mybatis/SqlMapConfig.xml");
        SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(reader);
        SqlSession session = sessionFactory.openSession();

        StudentMapper mapper = session.getMapper(StudentMapper.class);


        mapper.getAll().forEach(System.out::println);
        System.out.println();

        Student student = new Student();
        student.setName("zara");
        student.setBranch("EEE");
        student.setEmail("zara@gmail.com");
        student.setPercentage(90);
        student.setPhone(123412341);

        mapper.insert(student);


        mapper.getAll().forEach(System.out::println);
        System.out.println();

        System.out.println(mapper.getById(5));
        System.out.println();


        Student oldStudent = mapper.getById(5);
        oldStudent.setName(oldStudent.getName() + "_COPY");
        mapper.update(oldStudent);

        mapper.getAll().forEach(System.out::println);
        System.out.println();


        mapper.delete(11);
        mapper.getAll().forEach(System.out::println);
        System.out.println();

        session.commit();
        session.close();
    }
}