package com.parking.system.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;

/**
 * Created by 41988 on 2017/7/8.
 */
public class AbstractDAOImpl {
    protected Connection conn;
    protected PreparedStatement pstmt;

    public AbstractDAOImpl(Connection conn) {
        this.conn = conn;
    }
}
