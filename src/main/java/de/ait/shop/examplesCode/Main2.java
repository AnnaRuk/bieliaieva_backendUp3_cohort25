package de.ait.shop.examplesCode;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;


public class Main2 {

    /*
    public static void main(String[] args) {

        try {

            // пподключение к базе
            Connection connection = DriverManager.getConnection("jdbc:h2:file:~/databases/shop_db;AUTO_SERVER=TRUE",
                    "admin", "qwerty007");

            Statement statement = connection.createStatement(); // создали объект для отправки запроса в базу данных

            long before = System.currentTimeMillis();

            // внутри каждого потока начинаем делать 100 000 записей в одну базу
            // 10 потоков, каждый поток будет писать 100 000 записей в базу
            try (ExecutorService service = Executors.newFixedThreadPool(5)){// мы создаем 5 потоков
                for (int j = 0; j < 10; j++) {
                    // ставим задачу в очередь
                    service.submit(() -> {
                        // сама задача - сделать 10 000 запросов в базу
                        for (int i = 0; i <= 10_000; i++) {
                            try {
                                int affectedRow = statement.executeUpdate("insert into account(first_name, last_name, email, password) " +
                                        "values ('Marsel', 'Sidikov', 'temp@gmail.com', 'qwerty008')");

                                System.out.println(connection + " " + Thread.currentThread().getName() + ": Строк добавлено " + affectedRow);

                            } catch (SQLException e) {
                                System.out.println(e.getMessage());
                            }
                        }
                    });

                }
            }

            long after = System.currentTimeMillis();
            System.out.println(after - before);



        } catch (SQLException e) {
            throw new IllegalStateException(e);
        }
    }*/
    }
