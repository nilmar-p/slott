package controller;

import java.sql.SQLException;
import java.util.List;
import model.Make;
import model.Model;
import service.MakeService;

public class MakeController {

    private static final MakeService service = new MakeService();

    public static List<Make> getAllMakes() throws SQLException {
        return service.listMakes();
    }


}
