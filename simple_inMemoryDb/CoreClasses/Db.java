package CoreClasses;

import java.util.Date;
import java.util.HashMap;

public class Db {
    String DbId;
    public HashMap<String, Table> Tables;
    Date CreatedAt;

    public Db(String dbId, HashMap<String, Table> tables) {
        this.DbId = dbId;
        this.Tables = tables;
        this.CreatedAt = new Date();
    }

    public String getDbId() {
        return this.DbId;
    }
    

    public Date getCreatedAt() {
        return this.CreatedAt;
    }   

    public Table getTable(String tableId) {
        return this.Tables.get(tableId);
    }

    public void setTable(String tableId, Table table) {
        this.Tables.put(tableId, table);
    }
}
