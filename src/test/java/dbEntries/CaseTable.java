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
        logger.info("Создаем таблицу cases");

        String createTableSQL = "CREATE TABLE cases (" +
                "id SERIAL PRIMARY KEY, " +
                "title CHARACTER VARYING(30), " +
                "preconditions CHARACTER VARYING(30) " +
                ");";

        dataBaseService.executeSQL(createTableSQL);
    }

    public void dropTable() {
        logger.info("Удаляем таблицу cases");

        String dropTableMilestonesSQL = "DROP TABLE cases;";

        dataBaseService.executeSQL(dropTableMilestonesSQL);
    }

    public ResultSet getCaseByID(int id) {
        String sql = "SELECT * FROM cases WHERE id = " + id + ";";

        return dataBaseService.executeQuery(sql);
    }

    public void addCase(String title, String preconditions) {
        logger.info("Добавляем запись в таблицу cases");

        String insertTableSQL = "INSERT INTO public.cases(" +
                "title, preconditions)" +
                "VALUES ('" + title + "', '" + preconditions +"');";

        dataBaseService.executeSQL(insertTableSQL);
    }
}
