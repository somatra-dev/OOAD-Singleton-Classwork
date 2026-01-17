package co.pesexpo.dao.impl;

import co.pesexpo.config.DatabaseResourceConfig;
import co.pesexpo.dao.StudentDao;
import co.pesexpo.domain.Book;
import co.pesexpo.domain.Student;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class StudentDaoImpl implements StudentDao {

    private final Connection connection;

    public StudentDaoImpl() {
        // call singleton (instance)
        this.connection = DatabaseResourceConfig.getInstance().getConnection();
    }

    @Override
    public List<Student> findAll() throws SQLException {
        String sql = "SELECT * FROM students";
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(sql);
        List<Student> students = new ArrayList<>();
        while (resultSet.next()) {
            Student student = new Student();
            student.setId(resultSet.getInt("id"));
            student.setFirstName(resultSet.getString("first_name"));
            student.setLastName(resultSet.getString("last_name"));
            student.setAge(resultSet.getInt("age"));
            student.setGrade(resultSet.getString("grade"));
            students.add(student);
        }
        return students;
    }
}
