package Controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import CoreClasses.Db;
import CoreClasses.Table;

public class DbController {
    Db db;
    public DbController(Db db){
        this.db = db;
    }

    public String getDbId(){
        return this.db.getDbId();
    }

    public void createTable(String tableId) {
        db.setTable(tableId, new Table(tableId, new HashMap<>()));
    }

        public Table getTable(String tableId) {
        return db.getTable(tableId);
    }

    /**
     * Drop (remove) a table from the database.
     */
    public void dropTable(String tableId) {
        db.Tables.remove(tableId);
    }

    /**
     * List all table IDs in the database.
     */
    public List<String> listTables() {
        return new ArrayList<>(db.Tables.keySet());
    }
}
