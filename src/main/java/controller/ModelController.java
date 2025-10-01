package controller;

import java.sql.SQLException;
import java.util.List;
import model.Make;
import model.Model;
import service.ModelService;

public class ModelController {

    private static final ModelService service = new ModelService();

    public static List<Model> getAllModels() throws SQLException {
        return service.listModels();
    }

    public static List<Model> getModelsByMake(Make make) throws SQLException {
        return service.listModelsByMake(make);
    }
}
