package com.example.demo1.menagers;

import com.example.demo1.connection.DBConnectProvided;
import com.example.demo1.constants.Constants;
import com.example.demo1.model.User;

import java.io.File;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class UserManager {

    private static final Connection connection = DBConnectProvided.getInstace().getConnection();

    public UserManager() {
        this.createTable();
    }

    private void createTable() {
        try (final Statement statement = connection.createStatement();) {

            statement.executeUpdate("CREATE table if not EXists user(id int(11) auto_increment primary key not null,name varchar(255) not null,age int(8) , imageName varchar(255));");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public User getById(final int id) {
        try (final PreparedStatement statement = connection.prepareStatement("select * from user where id = ?;");) {
            statement.setInt(1, id);
            final ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                return this.getUserOf(resultSet);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public List<User> searchByName(String name) {
        try (final PreparedStatement statement = connection.prepareStatement(
                "SELECT * FROM user WHERE name LIKE ? OR name LIKE ? OR name LIKE ? OR name LIKE ?")) {
            statement.setString(1, "%" + name);
            statement.setString(2, name + "%");
            statement.setString(3, "%" + name + "%");
            statement.setString(4, name);
            final ResultSet resultSet = statement.executeQuery();
            List<User> res = new ArrayList<>();
            while (resultSet.next()) {
                res.add(this.getUserOf(resultSet));
            }
            return res;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public List<User> getAll() {
        final List<User> list = new ArrayList<>();
        try (final PreparedStatement statement = connection.prepareStatement("select * from user;");) {
            final ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {

                list.add(this.getUserOf(resultSet));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    User getUserOf(final ResultSet s) {
        try {
            final int id = s.getInt("id");
            final String name = s.getString("name");
            final int age = s.getInt("age");
            String imageName = s.getString("imageName");
            return new User(id, name, age, imageName);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public User getByName(final String name) {
        try (final PreparedStatement preparedStatement = connection.prepareStatement("select * from user where name = ?");) {
            preparedStatement.setString(1, name);
            final ResultSet resultSet1 = preparedStatement.executeQuery();
            if (resultSet1.next()) {
                return this.getUserOf(resultSet1);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public void update(final User user) {
        try (final PreparedStatement preparedStatement = connection.prepareStatement("update user set name = ? ,age = ? where id = ?");) {
            preparedStatement.setString(1, user.getName());
            preparedStatement.setInt(2, user.getAge());
            preparedStatement.setInt(3, user.getId());
            preparedStatement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public User create(final User user) {
        try (final PreparedStatement sql = connection.prepareStatement("insert into user (name, age ,imageName) values (? ,? ,?)", Statement.RETURN_GENERATED_KEYS);) {
            sql.setString(1, user.getName());
            sql.setInt(2, user.getAge());
            sql.setString(3, user.getImageName());
            sql.executeUpdate();
            ResultSet generatedKeys = sql.getGeneratedKeys();
            if (generatedKeys.next()) {
                user.setId(generatedKeys.getInt(1));
                return user;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public void deleteUserById(final int id) {
        deleteImageOfUser(id);
        try (final PreparedStatement preparedStatement = connection.prepareStatement("delete from user where id = ?");) {
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public boolean deleteImageOfUser(int id) {
        User byId = getById(id);
        if (byId != null) {
            String imagePath = Constants.IMAGE_DIRECTORY_PATH + byId.getImageName();
            File file = new File(imagePath);
            if (file.exists() && file.isFile()) {
                if (!file.delete()) {
                    return true;
                }
            }
        }
        return false;
    }
}
