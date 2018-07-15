package com.deletetask;

import java.sql.SQLException;

public interface JDBCservice {
     public void delete(String systemusername) throws SQLException;
}
