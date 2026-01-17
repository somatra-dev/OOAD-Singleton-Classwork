package co.pesexpo.dao.impl;

import co.pesexpo.config.DatabaseResourceConfig;
import co.pesexpo.dao.ProductDao;
import co.pesexpo.domain.Product;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ProductDaoImpl implements ProductDao {
    private final Connection connection;

    public ProductDaoImpl() {
        // call singleton (instance)
        this.connection = DatabaseResourceConfig.getInstance().getConnection();
    }

    @Override
    public List<Product> findAll() throws SQLException {
        String sql = "SELECT * FROM products";
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(sql);
        List<Product> products = new ArrayList<>();
        while (resultSet.next()) {
            Product product = new Product();
            product.setId(resultSet.getInt("id"));
            product.setCode(resultSet.getString("code"));
            product.setName(resultSet.getString("name"));
            product.setPrice(resultSet.getBigDecimal("price"));
            products.add(product);
        }
        return products;
    }

}
