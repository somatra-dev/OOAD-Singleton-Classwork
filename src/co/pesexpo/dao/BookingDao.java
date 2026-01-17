package co.pesexpo.dao;

import co.pesexpo.domain.Book;
import co.pesexpo.domain.Product;

import java.sql.SQLException;
import java.util.List;

public interface BookingDao {

    List<Book> findAll() throws SQLException;

}
