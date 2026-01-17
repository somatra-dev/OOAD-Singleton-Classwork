package co.pesexpo;

import co.pesexpo.config.DatabaseResourceConfig;
import co.pesexpo.dao.BookingDao;
import co.pesexpo.dao.ProductDao;
import co.pesexpo.dao.StudentDao;
import co.pesexpo.dao.impl.BookDaoImpl;
import co.pesexpo.dao.impl.ProductDaoImpl;
import co.pesexpo.dao.impl.StudentDaoImpl;

import java.sql.Connection;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        while (running) {
            System.out.println("\n===== MENU =====");
            System.out.println("1. Book");
            System.out.println("2. Student");
            System.out.println("3. Product");
            System.out.println("0. Exit");
            System.out.print("Choose option: ");

            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    handleBook();
                    break;
                case 2:
                    handleStudent();
                    break;
                case 3:
                    handleProduct();
                    break;
                case 0:
                    running = false;
                    System.out.println("Exiting application...");
                    break;
                default:
                    System.out.println("Invalid choice. Try again.");
            }
        }

        scanner.close();
    }

    private static void handleBook() {
        System.out.println("📘 Book menu");
        try {
            BookingDao bookingDao = new BookDaoImpl();
            bookingDao.findAll().forEach(System.out::println);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void handleStudent() {
        System.out.println("🎓 Student menu");
        try {
            StudentDao studentDao = new StudentDaoImpl();
            studentDao.findAll().forEach(System.out::println);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void handleProduct() {
        System.out.println("🛒 Product menu");
        try {
            ProductDao productDao = new ProductDaoImpl();
            productDao.findAll().forEach(System.out::println);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

