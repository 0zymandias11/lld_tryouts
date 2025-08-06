package CoreClasses;

import java.util.Date;
import java.util.HashMap;

public class Row{
    String RowId;
    HashMap<String, String> Columns;
    Date CreatedAt;
    Date updatedAt;

    public Row(String rowId, HashMap<String, String> columns) {
        this.RowId = rowId;
        this.Columns = columns;
        this.CreatedAt = new Date();
        this.updatedAt = new Date();
    }

    public String getRowId(){
        return this.RowId;
    }

    public void setColumn(String columnName, String value) {    
        this.Columns.put(columnName, value);
        this.updatedAt = new Date();
    }

    public HashMap<String, String> getColumns() {
        return this.Columns;
    }

    public Date getCreatedAt() {
        return this.CreatedAt;
    }
    public Date getUpdatedAt() {
        return this.updatedAt;
    }

}