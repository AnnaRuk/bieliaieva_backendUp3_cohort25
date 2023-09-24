package de.ait.shop.repositories.impl;

import com.zaxxer.hikari.HikariConfig;
import de.ait.shop.models.User;
import de.ait.shop.repositories.UsersRepository;
import org.springframework.jdbc.core.RowMapper;

import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;



public class UsersRepositoryJdbsImpl implements UsersRepository {

    private final DataSource dataSource;


    //language=SQL
    private static final String SQL_INSERT = "insert into users (email, password) VALUES ( EMAIL=?, PASSWORD=? ) ";


    public UsersRepositoryJdbsImpl(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    private static final RowMapper<User> USER_ROW_MAPPER = (row, rowNumber) -> {
            Long id = row.getLong("id");
            String email = row.getString("email");
            String password = row.getString("password");
            return new User(email,password);
        };


    @Override
    public User findById(Long id) {
        return null;
    }

    @Override
    public List<User> findAll()  {
      /*  JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
        String SQL_SELECT_ALL = "select * from users";
        return jdbcTemplate.query(SQL_SELECT_ALL,USER_ROW_MAPPER);
       */
        List<User> users = new ArrayList<>();
        try {

        Connection connection = dataSource.getConnection();
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery("select * from USERS");
        while (resultSet.next()){
            User event = new User(resultSet.getLong("id"),
                    resultSet.getString("email"),
                    resultSet.getString("password")
            );
            users.add(event);

        }
            statement.close();
            connection.close();

    } catch (SQLException e) {
            throw new IllegalStateException(e);
    }
        return users;
    }



    @Override
    public void save(User model)  {
        try {
        String email = model.getEmail();
        String password = model.getPassword();
        String sql = "INSERT INTO users(email, password) " +
                "VALUES ('" + email + "', '" + password + "')";
        Connection connection = dataSource.getConnection();
        Statement statement = connection.createStatement();

        int result = statement.executeUpdate(sql);
            statement.close();
            connection.close();
    } catch (SQLException e) {
        throw new IllegalStateException(e);
    }




//        SimpleJdbcInsert jdbcInsert = new SimpleJdbcInsert(dataSource)
//                .usingGeneratedKeyColumns("id");
//        jdbcInsert.withTableName("users");
//        Map<String, Object> parameters = new HashMap<>();
//        parameters.put("email", model.getEmail());
//        parameters.put("password", model.getPassword());
//
//        long generatedId =  jdbcInsert.executeAndReturnKey(parameters).longValue();
//        model.setId(generatedId);







//        try{
//            Class.forName("org.h2.Driver");
//        } catch (ClassNotFoundException e){
//            throw new IllegalStateException(e);
//        }
//        try {
//            Connection connection = DriverManager
//                    .getConnection("jdbc:h2:file:~/databases/lessonThree_db;AUTO_SERVER=TRUE",
//                            "admin","qwerty007");
//            Statement statement = connection.createStatement();
//            int resultSet = statement.executeUpdate("insert into USERS(email, password) VALUES ( 'anna2@gmail.com','qwerty002' )");
//
//        } catch (SQLException e){
//            throw new IllegalStateException(e);
//
//        }

    }

    @Override
    public void deleteById(Long id) {

    }

    @Override
    public void update(User model) {

    }

    @Override
    public User findOneByEmail(String email) {
        return null;
    }


}
