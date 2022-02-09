package tests.api.dbTests;

import DBEntries.CustomersTable;
import baseEntity.BaseDB;
import core.DataBaseService;
import org.apache.log4j.Logger;
import org.testng.annotations.Test;

import java.sql.ResultSet;
import java.sql.SQLException;

public class DBTest extends BaseDB {
    public static Logger logger = Logger.getLogger(DataBaseService.class);

    @Test
    public void firstTest() {
        dataBaseService.executeSQL("select * from customers;");
        dataBaseService.executeQuery("select * from customers;");
    }

    @Test
    public void secondTest(){
        CustomersTable customersTable = new CustomersTable(dataBaseService);

        ResultSet rs = customersTable.getAllCustomers();

        try {
            while (rs.next()){
                String id = rs.getString("id");
                String firstname = rs.getString("firstname");
                String lastname = rs.getString("lastname");
                String email = rs.getString("email");
                int age = rs.getInt(5);

                logger.info("userid: " + id);
                logger.info("firstname: " + firstname);
                logger.info("lastname: " + lastname);
                logger.info("email: " + email);
                logger.info("age: " + age);
            }
        } catch (SQLException e){
            logger.error(e.toString());
        }
    }

    @Test
    public void thirdTest(){
        CustomersTable customersTable = new CustomersTable(dataBaseService);

        customersTable.dropTable();
        customersTable.createTable();

        customersTable.addCustomer("Иван", "Иванов", "ivanov@test.com", 28);
        customersTable.addCustomer("Петр", "Петров", "petrov@test.com", 38);
        customersTable.addCustomer("Марина", "Стасевич", "marina@test.com", 23);

        ResultSet rs = customersTable.getAllCustomers();
        try {
            while (rs.next()) {
                String id = rs.getString("id");
                String firstname = rs.getString("firstname");
                String lastname = rs.getString("lastname");
                String email = rs.getString("email");
                int age = rs.getInt(5);

                logger.info("userid: " + id);
                logger.info("firstname: " + firstname);
                logger.info("lastname: " + lastname);
                logger.info("email: " + email);
                logger.info("age: " + age);
            }
        } catch (SQLException e) {
            logger.error(e.toString());
        }
    }
}

