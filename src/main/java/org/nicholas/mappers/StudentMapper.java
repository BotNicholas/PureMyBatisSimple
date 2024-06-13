package org.nicholas.mappers;

import org.apache.ibatis.annotations.*;
import org.nicholas.models.Student;

import java.util.List;

public interface StudentMapper {
     final String GET_ALL = "select * from student";
     final String GET_BY_ID = "select * from student where ID = #{id}";
     final String DELETE_BY_ID = "delete from student where ID = #{id}";
     final String INSERT = "insert into student (NAME, BRANCH, PERCENTAGE, PHONE, EMAIL) values (#{name}, #{branch}, #{percentage}, #{phone}, #{email})";
     final String UPDATE = "update student set NAME = #{name}, BRANCH = #{branch}, PERCENTAGE = #{percentage} PHONE = #{phone}, EMAIL = #{email} where ID = #{id}";

     @Select(GET_ALL)
//     @ResultMap() <--- is used for existing ResultMap (from XML)
     @Results(value = {
             @Result(property = "id", column = "ID"),
             @Result(property = "name", column = "NAME"),
             @Result(property = "branch", column = "BRANCH"),
             @Result(property = "percentage", column = "PERCENTAGE"),
             @Result(property = "phone", column = "PHONE"),
             @Result(property = "email", column = "EMAIL")
     })
     List<Student> getAll();

     @Select(GET_BY_ID)
     @Results(value = {
             @Result(property = "id", column = "ID"),
             @Result(property = "name", column = "NAME"),
             @Result(property = "branch", column = "BRANCH"),
             @Result(property = "percentage", column = "PERCENTAGE"),
             @Result(property = "phone", column = "PHONE"),
             @Result(property = "email", column = "EMAIL")
     })
    Student getById(int id);

     @Insert(INSERT)
     @Options(useGeneratedKeys = true, keyProperty = "id") // Equivalent for Hibernate's @GeneratedValue annotation. Here useGeneratedKeys say that DB generated id, and we must insert ito object's id property
     void insert(Student student);

     @Update(UPDATE)
     void update(Student student);

     @Delete(DELETE_BY_ID)
     void delete(int id);
}
