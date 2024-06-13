package org.nicholas.mappers;

import org.nicholas.models.Student;

import java.util.List;

public interface StudentMapper {
    void insert(Student student);

    List<Student> getAll();
    Student getById(int id);
}
