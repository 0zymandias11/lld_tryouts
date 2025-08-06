package Controller;

import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

import CoreClasses.Row;
import CoreClasses.Table;

public class TableController {
    Table table;
    public TableController(Table table) {
        this.table = table;
    }


    public String getTableId() {
        return this.table.getTableId();
    }

    public Row createRow(String rowId, HashMap<String, String> row2Cols){
        Row newRow = new Row(rowId, row2Cols);
        table.setRow(rowId, newRow);
        return newRow;
    }

    public Row getRow(String rowId){
        return  this.table.getRow(rowId);
    }

    public void updateRow(String rowId, String columnId, String value)throws Exception{
        Row row = this.table.getRow(rowId);
        if(row!=null){
            row.setColumn(columnId, value);
        }
        else{
            throw new Exception("Row with ID " + rowId + " does not exist in table " + this.table.getTableId());
        } 
    }

    public void deleteRow(String rowId) throws Exception{
        Row row = this.table.getRow(rowId);
        if(row != null){
            this.table.Rows.remove(rowId);
        } else {
            throw new Exception("Row with ID " + rowId + " does not exist in table " + this.table.getTableId());
        }
    }

    public List<Row> filterRow(String columnId, String value){
        return table.Rows.values().stream()
        .filter(row-> value.equals(row.getColumns().get(columnId)))
        .collect(Collectors.toList());
    }
}
