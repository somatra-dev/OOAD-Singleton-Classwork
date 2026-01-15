package co.pesexpo;

import co.pesexpo.config.DatabaseResourceConfig;
import java.sql.Connection;

public class Main {

    public static void main(String[] args) {

        // Place 1: Get singleton instance
        Connection conn1 = DatabaseResourceConfig.getInstance().getConnection();
        System.out.println("Place 1: " + conn1);

        // Place 2: Get singleton instance
        Connection conn2 = DatabaseResourceConfig.getInstance().getConnection();
        System.out.println("Place 2: " + conn2);

        // Place 3: Get singleton instance
        Connection conn3 = DatabaseResourceConfig.getInstance().getConnection();
        System.out.println("Place 3: " + conn3);

        // Place 4: Get singleton instance
        Connection conn4 = DatabaseResourceConfig.getInstance().getConnection();
        System.out.println("Place 4: " + conn4);

        // Place 5: Get singleton instance
        Connection conn5 = DatabaseResourceConfig.getInstance().getConnection();
        System.out.println("Place 5: " + conn5);

        // All connections are the same object
        System.out.println("\nAll same instance? " + (conn1 == conn2 && conn2 == conn3 && conn3 == conn4 && conn4 == conn5));
    }
}
