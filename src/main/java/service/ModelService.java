package service;

import dao.ModelDao;
import java.sql.SQLException;
import java.util.List;
import model.Make;
import model.Model;

public class ModelService {
    
    private final ModelDao dao = new ModelDao();

    //list
    public List<Model> listModels() throws SQLException {
        //rules
        return dao.readAll();
    }
    
    public List<Model> listModelsByMake(Make make) throws SQLException {
        //rules
        return dao.readByMake(make);
    }
    
    public Model listModelById(int id) throws SQLException {
        return dao.readModel(id);
    }

    //create
    public int createModel(Model model) throws SQLException {
        //rules
        return dao.create(model);
    }
}
