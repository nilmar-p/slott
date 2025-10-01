package dao;

import db.Database;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;
import model.Make;

public class MakeDao {

    //CRUD
    public int create(Make make) throws SQLException {
        String SQL = "insert into make (name) values (?)";
        PreparedStatement pst = Database.getConnection().prepareStatement(SQL);

        pst.setString(1, make.getName());

        return pst.executeUpdate();
    }

    public int update(Make make) throws SQLException {
        String SQL = "update make set name =? where id =?";
        PreparedStatement pst = Database.getConnection().prepareStatement(SQL);

        pst.setString(1, make.getName());
        pst.setInt(2, make.getId());

        return pst.executeUpdate();
    }

    public int delete(Make make) throws SQLException {
        String SQL = "delete from make where id =?";
        PreparedStatement pst = Database.getConnection().prepareStatement(SQL);

        pst.setInt(1, make.getId());

        return pst.executeUpdate();
    }

    public List<Make> readAll() throws SQLException {
        String SQL = "select * from make order by name";
        PreparedStatement pst = Database.getConnection().prepareStatement(SQL);

        ResultSet rs = pst.executeQuery();

        List<Make> makeList = new LinkedList<>();

        while (rs.next()) {
            makeList.add(createObject(rs));
        }

        return makeList;
    }

    public Make readMake(int id) throws SQLException {
        String SQL = "select * from make where id =?";
        PreparedStatement pst = Database.getConnection().prepareStatement(SQL);

        pst.setInt(1, id);

        ResultSet rs = pst.executeQuery();

        return (rs.next() ? createObject(rs) : null);
    }

    //
    private Make createObject(ResultSet rs) throws SQLException {
        Make m = new Make();

        m.setId(rs.getInt("id"));
        m.setName(rs.getString("name"));

        return m;
    }
}
