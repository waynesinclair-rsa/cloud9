package com.sqs.qe.steps;

import com.sqs.qe.DataBase;
import net.thucydides.core.annotations.Step;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class AlbumSteps {

    private DataBase db;
    private PreparedStatement insertStatement;
    private PreparedStatement existsStatement;
    private PreparedStatement countStatement;

    private ArtistsSteps artistsSteps;

    public AlbumSteps() throws Exception{
        db = new DataBase();
        insertStatement = db.conn.prepareStatement("insert into albums (title, artistid) values (?, ?)");
        existsStatement = db.conn.prepareStatement("select albumid from albums where title = ?");
        countStatement = db.conn.prepareStatement("select count(*) from albums");

        artistsSteps = new ArtistsSteps();
    }

    @Step
    public int count() throws Exception {
        ResultSet rs = countStatement.executeQuery();
        if ( rs.next() ) return rs.getInt(1);
        return -1;
    }

    @Step
    public int add(String title, String artist) throws Exception {
        int id = artistsSteps.add(artist);

        insertStatement.setString(1, title);
        insertStatement.setInt(2, id);
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
