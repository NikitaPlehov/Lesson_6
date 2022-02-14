package dbEntries;

import core.DataBaseService;
import org.testng.log4testng.Logger;
import java.sql.ResultSet;


public class MilestoneTable {
    public static Logger logger = Logger.getLogger(MilestoneTable.class);

    DataBaseService dataBaseService;

    public MilestoneTable(DataBaseService dataBaseService) {
        this.dataBaseService = dataBaseService;
    }

    public void createTable() {
        logger.info("Создаем таблицу milestone");

        String createTableSQL = "CREATE TABLE milestone (" +
                "id SERIAL PRIMARY KEY, " +
                "milestone CHARACTER VARYING(30), " +
                "reference CHARACTER VARYING(30), " +
                "description CHARACTER VARYING(30) " +
                ");";

        dataBaseService.executeSQL(createTableSQL);
    }

    public void dropTable() {
        logger.info("Удаляем таблицу milestones");

        String dropTableMilestonesSQL = "DROP TABLE milestone;";

        dataBaseService.executeSQL(dropTableMilestonesSQL);
    }

    public ResultSet getMilestoneByID(int id) {
        String sql = "SELECT * FROM milestone WHERE id = " + id + ";";

        return dataBaseService.executeQuery(sql);
    }

    public void addMilestone(String milestone, String reference, String description) {
        logger.info("Добавляем запись в таблицу milestones");

        String insertTableSQL = "INSERT INTO public.milestone(" +
                "milestone, reference, description)" +
                "VALUES ('" + milestone + "', '" + reference+"', '" + description+"');";

        dataBaseService.executeSQL(insertTableSQL);
    }
}
