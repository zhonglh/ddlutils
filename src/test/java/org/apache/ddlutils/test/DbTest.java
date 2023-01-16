package org.apache.ddlutils.test;


import org.apache.ddlutils.model.*;
import org.junit.Test;

import java.sql.Connection;
import java.sql.Types;
import java.util.Arrays;
import java.util.Map;
import java.util.stream.Collectors;

public class DbTest extends DdlUtilsBaseTest {

    @Test
    public void testCreateTable(){
        /*Database database = new Database();

        Table table = new Table();
        table.setName("test20230106");

        Column column0 = new Column();
        column0.setName("id");
        column0.setDescription("ID");
        column0.setTypeCode(Types.BIGINT);
        column0.setRequired(true);
        column0.setPrimaryKey(true);

        Column column1 = new Column();
        column1.setName("aa");
        column1.setDescription("AAA");
        column1.setTypeCode(Types.VARCHAR);
        column1.setRequired(true);
        column1.setSize("80");

        Column column2 = new Column();
        column2.setName("bb");
        column2.setDescription("年龄");
        column2.setTypeCode(Types.INTEGER);
        column2.setRequired(true);
        column2.setSize("3");


        Column column3 = new Column();
        column3.setName("cc");
        column3.setDescription("工资");
        column3.setTypeCode(Types.DECIMAL);
        column3.setRequired(true);
        column3.setSize("3,2");

        table.addColumn(column0);
        table.addColumn(column1);
        table.addColumn(column2);
        table.addColumn(column3);

        UniqueIndex uniqueIndex = new UniqueIndex();
        uniqueIndex.setName("unique1");
        IndexColumn indexColumn1 = new IndexColumn();
        indexColumn1.setColumn(column1);
        IndexColumn indexColumn2 = new IndexColumn();
        indexColumn2.setColumn(column2);
        uniqueIndex.addColumn(indexColumn1);
        uniqueIndex.addColumn(indexColumn2);
        table.addIndex(uniqueIndex);

        NonUniqueIndex nonUniqueIndex = new NonUniqueIndex();
        nonUniqueIndex.setName("nonunique");
        nonUniqueIndex.addColumn(indexColumn1);
        table.addIndex(nonUniqueIndex);

        database.addTable(table);

        this.platform.createModel(database,false , false);*/
    }



    @Test
    public void testAlterTable(){
        /*Database database = new Database();

        Table table = new Table();
        table.setName("test20230106");

        Column column0 = new Column();
        column0.setName("id");
        column0.setDescription("ID11");
        column0.setTypeCode(Types.BIGINT);
        column0.setRequired(true);
        column0.setPrimaryKey(true);

        Column column1 = new Column();
        column1.setName("aa");
        column1.setDescription("AAA22");
        column1.setTypeCode(Types.VARCHAR);
        column1.setRequired(true);
        column1.setSize("10");

        Column column2 = new Column();
        column2.setName("bb1");
        column2.setDescription("年龄");
        column2.setTypeCode(Types.INTEGER);
        column2.setRequired(false);
        column2.setSize("10");

        table.addColumn(column0);
        table.addColumn(column1);
        table.addColumn(column2);

        UniqueIndex uniqueIndex = new UniqueIndex();
        uniqueIndex.setName("unique1");
        IndexColumn indexColumn1 = new IndexColumn();
        indexColumn1.setColumn(column1);
        IndexColumn indexColumn2 = new IndexColumn();
        indexColumn2.setColumn(column2);
        uniqueIndex.addColumn(indexColumn1);
        uniqueIndex.addColumn(indexColumn2);
        table.addIndex(uniqueIndex);
        database.addTable(table);
        Connection connection = platform.borrowConnection();

        try {
            Database currentModel = platform.readModelFromDatabase(connection, database.getName());

            platform.alterModel(currentModel, database, false);
        } finally {
            platform.returnConnection(connection);
        }*/

    }
}
