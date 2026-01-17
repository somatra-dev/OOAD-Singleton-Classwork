package co.pesexpo.dao;

import co.pesexpo.domain.Product;

import java.sql.SQLException;
import java.util.List;

public interface ProductDao {

    List<Product> findAll() throws SQLException;

}
