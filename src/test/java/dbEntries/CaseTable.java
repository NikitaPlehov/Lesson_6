package dbEntries;

import core.DataBaseService;
import org.testng.log4testng.Logger;

import java.sql.ResultSet;

public class CaseTable {
    public static Logger logger = Logger.getLogger(CaseTable.class);

    DataBaseService dataBaseService;

    public CaseTable(DataBaseService dataBaseService) {
        this.dataBaseService = dataBaseService;
    }

    public void createTable() {
        logger.info("Создаем таблицу milestones");

        String createTableSQL = "CREATE TABLE testcase (" +
                "id SERIAL PRIMARY KEY, " +
                "title CHARACTER VARYING(30), " +  ");";

        dataBaseService.executeSQL(createTableSQL);
    }

    public void dropTable() {
        logger.info("Удаляем таблицу testcase");

        String dropTableMilestonesSQL = "DROP TABLE testcase;";

        dataBaseService.executeSQL(dropTableMilestonesSQL);
    }

    public ResultSet getMilestoneByID(int id) {
        String sql = "SELECT * FROM testcase WHERE id = " + id + ";";

        return dataBaseService.executeQuery(sql);
    }

    public void addTestcase(String title, String preconditions) {
        logger.info("Добавляем запись в таблицу testcase");

        String insertTableSQL = "INSERT INTO public.testcase(" +
                "title, preconditions)" +
                "VALUES ('" + title + "');";

        dataBaseService.executeSQL(insertTableSQL);
    }
}
