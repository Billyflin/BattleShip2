package com.spm.battleship.data;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Statement;

public abstract class ConectionData {
    String DB_URL;
    String USER;
    String PASS;
    protected String QUERY;
    protected Connection connection;
    protected Statement statement;
    protected PreparedStatement preparedStatement;
}
