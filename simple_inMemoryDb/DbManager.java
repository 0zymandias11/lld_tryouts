import java.util.HashMap;
import java.util.List;

import Controller.DbController;
import Controller.TableController;
import CoreClasses.Db;
import CoreClasses.Row;
import CoreClasses.Table;

public class DbManager {
    public static void main(String args[]) throws Exception{
        Db db = new Db("db1", new HashMap<>());
        DbController dbController = new DbController(db);
        // 2. Create a table
        String tableName = "Users";
        System.out.println("Creating table: " + tableName);
        dbController.createTable(tableName);
        System.out.println("Current tables: " + dbController.listTables());

        Table usersTable = dbController.getTable(tableName);
        System.out.println("Retrieved table: " + usersTable.getTableId());

        TableController tableCtrl = new TableController(usersTable);
        HashMap<String, String> row1Cols = new HashMap<>();
        row1Cols.put("id", "1");
        row1Cols.put("name", "Alice");
        row1Cols.put("age", "30");
        tableCtrl.createRow("1", row1Cols);

        HashMap<String, String> row2Cols = new HashMap<>();
        row2Cols.put("id", "2");
        row2Cols.put("name", "Bob");
        row2Cols.put("age", "25");

        tableCtrl.createRow("2", row2Cols);

        System.out.println("Row 1 data: " + tableCtrl.getRow("1").getColumns());
        System.out.println("Row 2 data: " + tableCtrl.getRow("2").getColumns());

        System.out.println("Filtering rows where age=26...");
        List<Row> filtered = tableCtrl.filterRow("age", "26");
        filtered.forEach(r -> System.out.println("Matched Row ID: " + r.getRowId() + ", cols=" + r.getColumns()));


        System.out.println("Deleting row with ID '1'...");
        tableCtrl.deleteRow("1");
        System.out.println("Row 1 exists after delete? " + (tableCtrl.getRow("1") != null));
    }
}
