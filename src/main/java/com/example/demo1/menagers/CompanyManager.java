package com.example.demo1.menagers;

import com.example.demo1.connection.DBConnectProvided;
import com.example.demo1.model.Company;
import com.example.demo1.model.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CompanyManager {
    private final Connection c = DBConnectProvided.getInstace().getConnection();
    private final UserManager userManager = new UserManager();

    public CompanyManager() {
        this.createCompanyTable();
    }


    private void createCompanyTable() {
        try (final Statement s = this.c.createStatement();
        ) {
            s.executeUpdate("CREATE TABLE IF NOT EXISTS company (id INT(11) AUTO_INCREMENT PRIMARY KEY NOT NULL,name VARCHAR(255) NOT NULL,fild INT(11),userID INT(11),FOREIGN KEY (userID) REFERENCES user(id));");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public Company save(Company company) {
        try (PreparedStatement preparedStatement = c.prepareStatement("insert into company (name, fild, userID) values (?, ?, ?)", Statement.RETURN_GENERATED_KEYS);
        ) {
            preparedStatement.setString(1, company.getName());
            preparedStatement.setInt(2, company.getFild());
            preparedStatement.setInt(3, company.getUserID().getId());

            int rowsAffected = preparedStatement.executeUpdate();

            if (rowsAffected == 0) {
                throw new SQLException("Insert failed, no rows affected.");
            }

            ResultSet generatedKeys = preparedStatement.getGeneratedKeys();

            if (generatedKeys.next()) {
                company.setId(generatedKeys.getInt(1));
            } else {
                throw new SQLException("Insert failed, no ID obtained.");
            }

            return company;
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

    private Company getCompanyOf(ResultSet s) {
        try {
            final int id = s.getInt("id");
            final String name = s.getString("name");
            final int fild = s.getInt("fild");
            int id1 = s.getInt("userID");
            return new Company(id, name, fild, userManager.getById(id1));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }


    public List<Company> getAll(String sqlPredicate) {
        List<Company> list = new ArrayList<>();
        try (PreparedStatement preparedStatement = c.prepareStatement("select * from company");
        ) {
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                list.add(getCompanyOf(resultSet));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    public Company getByName(String name) {
        try (PreparedStatement preparedStatement = c.prepareStatement("select * from company where name = ?");
        ) {
            preparedStatement.setString(1, name);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                return getCompanyOf(resultSet);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    public Company getById(int id) {
        try (PreparedStatement preparedStatement = c.prepareStatement("select * from company where id = ?");
        ) {
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                return getCompanyOf(resultSet);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    public List<Company> getCompanysByUserId(int id) {
        try (PreparedStatement preparedStatement = c.prepareStatement("select * from company where userID = ?");
        ) {
            List<Company> list = new ArrayList<>();
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                list.add( getCompanyOf(resultSet));
            }
            return list;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }


    public void update(Company company) {
        try (PreparedStatement preparedStatement = c.prepareStatement("update company set name = ? , fild = ? ,userID =? where id =?");
        ) {
            preparedStatement.setString(1, company.getName());
            preparedStatement.setInt(2, company.getFild());
            preparedStatement.setInt(3, company.getUserID().getId());
            preparedStatement.setInt(4, company.getId());
            preparedStatement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void deleteUserOfCompany(Company company ) {
        try (PreparedStatement preparedStatement = c.prepareStatement("update company set userID =null where id =?");
        ) {
            preparedStatement.setInt(4, company.getId());
            preparedStatement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void delete(String name) {
        try (PreparedStatement preparedStatement = c.prepareStatement("delete from company where name = ?");
        ) {
            preparedStatement.setString(1, name);
            preparedStatement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    // Inside CompanyManager class
    public void updateCompanyById(int companyId, String newName, int newField) {
        try (PreparedStatement preparedStatement = c.prepareStatement("UPDATE company SET name = ?, fild = ? WHERE id = ?");
        ) {
            preparedStatement.setString(1, newName);
            preparedStatement.setInt(2, newField);
            preparedStatement.setInt(3, companyId);
            int updatedRows = preparedStatement.executeUpdate();

            if (updatedRows > 0) {
                System.out.println("Company updated successfully.");
            } else {
                System.out.println("No company found with the specified ID.");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public User getUsersById(int companyId) {
        List<User> userList = new ArrayList<>();

        try (PreparedStatement preparedStatement = c.prepareStatement("SELECT * FROM user WHERE id = ?");
        ) {
            preparedStatement.setInt(1, companyId);
            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                User user = userManager.getUserOf(resultSet);
                return user;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    public void deleteCompanyById(int id) {
        try (PreparedStatement preparedStatement = c.prepareStatement("DELETE FROM company WHERE id = ?");
        ) {
            preparedStatement.setInt(1,id);
            int deletedRows = preparedStatement.executeUpdate();

            if (deletedRows > 0) {
                System.out.println("User with ID " + id + " deleted successfully.");
            } else {
                System.out.println("No user found with the specified ID.");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
