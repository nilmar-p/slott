package dao;

import db.Database;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;
import model.Make;
import model.Model;

public class ModelDao {
    //CRUD

    public int create(Model model) throws SQLException {
        String SQL = "insert into model (name, id_make) values (?, ?)";
        PreparedStatement pst = Database.getConnection().prepareStatement(SQL);

        pst.setObject(1, model.getName());
        pst.setObject(2, model.getMake().getId());

        return pst.executeUpdate();
    }

    public int update(Model model) throws SQLException {
        String SQL = "update model set name =?, id_make =? where id =?";
        PreparedStatement pst = Database.getConnection().prepareStatement(SQL);

        pst.setObject(1, model.getName());
        pst.setObject(2, model.getMake().getId());
        pst.setObject(3, model.getId());

        return pst.executeUpdate();
    }

    public int delete(Model model) throws SQLException {
        String SQL = "delete from model where id =?";
        PreparedStatement pst = Database.getConnection().prepareStatement(SQL);

        pst.setInt(1, model.getId());

        return pst.executeUpdate();
    }

    public List<Model> readAll() throws SQLException {
        String SQL = "select * from model order by name";
        PreparedStatement pst = Database.getConnection().prepareStatement(SQL);

        ResultSet rs = pst.executeQuery();

        List<Model> modelList = new LinkedList<>();

        while (rs.next()) {
            modelList.add(createObject(rs));
        }

        return modelList;
    }

    public Model readModel(int id) throws SQLException {
        String SQL = "select * from model where id=?";
        PreparedStatement pst = Database.getConnection().prepareStatement(SQL);

        pst.setInt(1, id);

        ResultSet rs = pst.executeQuery();

        return (rs.next() ? createObject(rs) : null);
    }

    //
    private Model createObject(ResultSet rs) throws SQLException {
        Model m = new Model();

        MakeDao md = new MakeDao();
        Make make = md.readMake(rs.getInt("id_make"));

        m.setId(rs.getInt("id"));
        m.setName(rs.getString("name"));
        m.setMake(make);

        return m;
    }
}
