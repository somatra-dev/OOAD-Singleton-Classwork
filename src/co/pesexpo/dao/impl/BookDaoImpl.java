package co.pesexpo.dao.impl;

import co.pesexpo.config.DatabaseResourceConfig;
import co.pesexpo.dao.BookingDao;
import co.pesexpo.domain.Book;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class BookDaoImpl implements BookingDao {

    private final Connection connection;

    public BookDaoImpl() {
        // call singleton (instance)
        this.connection = DatabaseResourceConfig.getInstance().getConnection();
    }

    @Override
    public List<Book> findAll() throws SQLException {
        String sql = "SELECT * FROM books";
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(sql);
        List<Book> books = new ArrayList<>();
        while (resultSet.next()) {
            Book book = new Book();
            book.setId(resultSet.getInt("id"));
            book.setTitle(resultSet.getString("title"));
            book.setAuthor(resultSet.getString("author"));
            book.setPublishAt(resultSet.getDate("publish_at"));
            books.add(book);
        }
        return books;
    }
}
