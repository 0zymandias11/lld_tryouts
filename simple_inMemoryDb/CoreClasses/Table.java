package CoreClasses;

import java.util.Date;
import java.util.HashMap;

public class Table {
    String TableId;
    public HashMap<String, Row> Rows;
    Date CreatedAt;

    public Table(String tableId, HashMap<String, Row> rows) {
        this.TableId = tableId;
        this.Rows = rows;
        this.CreatedAt = new Date();
    }

    public String getTableId(){
        return this.TableId;
    }

    public Date getCreatedAt() {
        return this.CreatedAt;
    }

    public Row getRow(String rowId) {
        return this.Rows.get(rowId);
    }

    public Row setRow(String rowId, Row row) {
        this.Rows.put(rowId, row);
        return row;
    }
}
