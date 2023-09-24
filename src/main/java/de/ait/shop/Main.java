package de.ait.shop;


import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import de.ait.shop.controller.UserController;
import de.ait.shop.repositories.UsersRepository;
import de.ait.shop.repositories.impl.UsersRepositoryJdbsImpl;
import de.ait.shop.services.UsersService;
import de.ait.shop.services.impl.UsersServiceImpl;
import de.ait.shop.validation.EmailValidator;
import de.ait.shop.validation.PasswordValidator;
import de.ait.shop.validation.impl.EmailValidatorRegexImpl;
import de.ait.shop.validation.impl.PasswordValidatorRegexImpl;
import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.sql.DataSource;
import java.util.Scanner;



public class Main {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        ApplicationContext context = new ClassPathXmlApplicationContext("context.xml");
        UserController controller = context.getBean(UserController.class);

/*  ************************

    //DataSource dataSource = createDataSource();
    HikariConfig config = getHikariConfig();
    DataSource dataSourceConfig = new HikariDataSource(config);


        EmailValidator emailValidator = new EmailValidatorRegexImpl();
        PasswordValidator passwordValidator = new PasswordValidatorRegexImpl();
        Scanner scanner = new Scanner(System.in);
        UsersRepository usersRepository = new UsersRepositoryJdbsImpl(dataSourceConfig);
        UsersService usersService = new UsersServiceImpl(usersRepository, emailValidator, passwordValidator);
        UserController controller = new UserController(scanner,usersService);

*******************************
 */



        long before = System.currentTimeMillis();

        boolean isRun = true;

        while (isRun) {
            String command = scanner.nextLine(); // считываем команду

            switch (command) {
                case "/addUser" ->  // если это команда на регистрацию
                        controller.addUser(); // регистрируем пользователя
                case "/users" ->  // если это команда на получение пользователей
                        controller.getAllUsers();
                case "/exit" -> isRun = false;
            }
        }
        long after = System.currentTimeMillis();
        System.out.println(after - before);

    }

    private static HikariConfig getHikariConfig() {
        HikariConfig config = new HikariConfig();
        config.setDriverClassName("org.h2.Driver");
        config.setJdbcUrl("jdbc:h2:file:~/databases/lessonThree_db;AUTO_SERVER=TRUE");
        config.setUsername("admin");
        config.setPassword("qwerty007");
        return config;
    }

    private static DataSource createDataSource() {
        BasicDataSource dataSource = new BasicDataSource();
        dataSource.setDriverClassName("org.h2.Driver");
        dataSource.setUrl("jdbc:h2:file:~/databases/lessonThree_db;AUTO_SERVER=TRUE");
        dataSource.setUsername("admin");
        dataSource.setPassword("qwerty007");
        return dataSource;
    }
}