package co.pesexpo.dao;

import co.pesexpo.domain.Product;
import co.pesexpo.domain.Student;

import java.sql.SQLException;
import java.util.List;

public interface StudentDao {

    List<Student> findAll() throws SQLException;
}
