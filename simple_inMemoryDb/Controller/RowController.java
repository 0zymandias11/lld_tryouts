package Controller;

import java.util.Date;
import java.util.HashMap;

import CoreClasses.Row;

public class RowController {
    Row row;
    RowController(Row row) {
        this.row = row;
    }
    
    public String getRowId(){
        return this.row.getRowId();
    }

    public void setColumn(String columnName, String value) {
        this.row.setColumn(columnName, value);
    }

    public String getColumn(String columnName) {
        return this.row.getColumns().get(columnName);
    }   
    public HashMap<String, String> getColumns() {
        return this.row.getColumns();
    }

    public Date getCreatedAt() {
        return this.row.getCreatedAt();
    }

    public Date getUpdatedAt() {
        return this.row.getUpdatedAt();
    }

}
