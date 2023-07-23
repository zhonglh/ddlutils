package org.apache.ddlutils.context;

import java.util.ArrayList;
import java.util.List;

/**
 * 修改时要删除的表的个数
 */
public class AlertThreadLocal {

    private static final ThreadLocal<List<String>> DROP_TABLE_NAME = new ThreadLocal<List<String>>(){
        @Override
        public List<String> initialValue(){
            return new ArrayList<>();
        }

    };

    public static List<String> getDropTableNames(){
        return DROP_TABLE_NAME.get();
    }

    public static void setDropTableNames(List<String> names){
        DROP_TABLE_NAME.set(names);
    }

    public static void removeDropTableNames(){
        DROP_TABLE_NAME.remove();
    }

}
