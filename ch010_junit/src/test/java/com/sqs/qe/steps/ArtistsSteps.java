package com.sqs.qe.steps;

import com.sqs.qe.DataBase;
import net.thucydides.core.annotations.Step;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class ArtistsSteps {
    DataBase db;
    PreparedStatement insertStatement;
    PreparedStatement existsStatement;
    PreparedStatement countStatement;

    public ArtistsSteps() throws Exception{
        db = new DataBase();
        insertStatement = db.conn.prepareStatement("insert into artists (name) values (?)");
        existsStatement = db.conn.prepareStatement("select artistid from artists where name = ?");
    }

    @Step
    public int count() throws Exception {
        ResultSet rs = countStatement.executeQuery();
        if ( rs.next() ) return rs.getInt(1);
        return -1;
    }

    @Step
    public int add(String name) throws Exception {
        insertStatement.setString(1, name);
        insertStatement.executeUpdate();
        ResultSet rs = db.qry("select last_insert_rowid()");
        if ( rs.next()) return rs.getInt(1);
        return -1;
    }

    @Step
    public int getId(String name) throws Exception {
        existsStatement.setString(1, name);
        ResultSet rs = existsStatement.executeQuery();
        if ( rs.next() ) return rs.getInt(1);
        return -1;
    }

}
