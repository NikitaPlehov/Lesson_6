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
        logger.info("Создаем таблицу Case");

        String createTableSQL = "CREATE TABLE Case (" +
                "id SERIAL PRIMARY KEY, " +
                "title CHARACTER VARYING(30), " +  ");";

        dataBaseService.executeSQL(createTableSQL);
    }

    public void dropTable() {
        logger.info("Удаляем таблицу Case");

        String dropTableCaseSQL = "DROP TABLE Case;";

        dataBaseService.executeSQL(dropTableCaseSQL);
    }

    public ResultSet getCaseByID(int id) {
        String sql = "SELECT * FROM Case WHERE id = " + id + ";";

        return dataBaseService.executeQuery(sql);
    }

    public void addCase(String title) {
        logger.info("Добавляем запись в таблицу Case");

        String insertTableSQL = "INSERT INTO public.Case(" +
                "VALUES ('" + title + "');";

        dataBaseService.executeSQL(insertTableSQL);
    }
}
