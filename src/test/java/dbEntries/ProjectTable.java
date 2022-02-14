package dbEntries;

import core.DataBaseService;
import org.testng.log4testng.Logger;

import java.sql.ResultSet;

public class ProjectTable {
    public static Logger logger = Logger.getLogger(ProjectTable.class);

    DataBaseService dataBaseService;

    public ProjectTable(DataBaseService dataBaseService) {
        this.dataBaseService = dataBaseService;
    }

    public void createTable() {
        logger.info("Создаем таблицу project");

        String createTableSQL = "CREATE TABLE projects (" +
                "id SERIAL PRIMARY KEY, " +
                "project CHARACTER VARYING(30), " +
                "announcement CHARACTER VARYING(30)"+
                ");";

        dataBaseService.executeSQL(createTableSQL);
    }

    public void dropTable() {
        logger.info("Удаляем таблицу project");

        String dropTableProjectsSQL = "DROP TABLE projects;";

        dataBaseService.executeSQL(dropTableProjectsSQL);
    }

    public ResultSet getProjectByID(int id) {
        String sql = "SELECT * FROM projects WHERE id = " + id + ";";

        return dataBaseService.executeQuery(sql);
    }

    public void addProject(String project, String announcement) {
        logger.info("Добавляем запись в таблицу projects");

        String insertTableSQL = "INSERT INTO public.projects(" +
                "project, announcement)" +
                "VALUES ('" + project + "', '" + announcement+"');";

        dataBaseService.executeSQL(insertTableSQL);
    }
}
