package dao;

import db.Database;
import enums.Color;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;
import model.Make;
import model.Model;
import model.Vehicle;

public class VehicleDao {
    //CRUD

    public int create(Vehicle vehicle) throws SQLException {
        String SQL = "insert into vehicle (id_make, id_model, color, year, description) values (?, ?, ?, ?, ?)";
        PreparedStatement pst = Database.getConnection().prepareStatement(SQL);

        pst.setObject(1, vehicle.getMake().getId());
        pst.setObject(2, vehicle.getModel().getId());
        pst.setObject(3, vehicle.getColor());
        pst.setObject(4, vehicle.getYear());
        pst.setObject(5, vehicle.getDescription());

        return pst.executeUpdate();
    }

    public int update(Vehicle vehicle) throws SQLException {
        String SQL = "update vehicle set id_make =?, id_model =?, color =?, year =?, description =? where id =?";
        PreparedStatement pst = Database.getConnection().prepareStatement(SQL);

        pst.setObject(1, vehicle.getMake().getId());
        pst.setObject(2, vehicle.getModel().getId());
        pst.setObject(3, vehicle.getColor());
        pst.setObject(4, vehicle.getYear());
        pst.setObject(5, vehicle.getDescription());
        pst.setObject(6, vehicle.getId());

        return pst.executeUpdate();
    }

    public int delete(Vehicle vehicle) throws SQLException {
        String SQL = "delete from vehicle where id =?";
        PreparedStatement pst = Database.getConnection().prepareStatement(SQL);

        pst.setInt(1, vehicle.getId());

        return pst.executeUpdate();
    }

    public List<Vehicle> readAll() throws SQLException {
        String SQL = "select * from vehicle";
        PreparedStatement pst = Database.getConnection().prepareStatement(SQL);

        ResultSet rs = pst.executeQuery();

        List<Vehicle> vehicleList = new LinkedList<>();

        while (rs.next()) {
            vehicleList.add(createObject(rs));
        }

        return vehicleList;
    }

    public Vehicle readVehicle(int id) throws SQLException {
        String SQL = "select * from vehicle where id=?";
        PreparedStatement pst = Database.getConnection().prepareStatement(SQL);

        pst.setInt(1, id);

        ResultSet rs = pst.executeQuery();

        return (rs.next() ? createObject(rs) : null);
    }

    //
    private Vehicle createObject(ResultSet rs) throws SQLException {
        Vehicle vehicle = new Vehicle();
        
        MakeDao makeDao = new MakeDao();
        Make make = makeDao.readMake(rs.getInt("id_make"));
        
        ModelDao modelDao = new ModelDao();
        Model model = modelDao.readModel(rs.getInt("id_model"));
        
        vehicle.setId(rs.getInt("id"));
        vehicle.setMake(make);
        vehicle.setModel(model);
        vehicle.setColor(Color.valueOf(rs.getString("color")));
        vehicle.setYear(rs.getInt("year"));
        vehicle.setDescription(rs.getString("description"));
        
        return vehicle;
    }
}
