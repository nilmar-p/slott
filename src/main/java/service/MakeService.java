package service;

import dao.MakeDao;
import java.sql.SQLException;
import java.util.List;
import model.Make;

public class MakeService {

    private final MakeDao dao = new MakeDao();

    public List<Make> listMakes() throws SQLException {
        //rules
        return dao.readAll();
    }
    
}
