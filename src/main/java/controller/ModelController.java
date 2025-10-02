package controller;

import java.sql.SQLException;
import java.util.List;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import model.Make;
import model.Model;
import service.ModelService;

public class ModelController {

    private static final ModelService service = new ModelService();

    //list
    public static List<Model> getAllModels() throws SQLException {
        return service.listModels();
    }

    public static List<Model> getModelsByMake(Make make) throws SQLException {
        return service.listModelsByMake(make);
    }

    public static Model getModel(int id) throws SQLException {
        return service.listModelById(id);
    }

    //create
    public static int createModel(JTextField fieldRegisterName, JComboBox comboMakeRegister) throws SQLException {
        Model model = new Model();
        Make make = (Make) comboMakeRegister.getSelectedItem();

        if (comboMakeRegister.getSelectedIndex() < 0) {
            JOptionPane.showMessageDialog(
                    null,
                    "ERRO: você deve escolher uma fabricante!",
                    "Algo deu errado",
                    JOptionPane.ERROR_MESSAGE
            );
            return 0;
        } else if (fieldRegisterName.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(
                    null,
                    "ERRO: você deve dar um nome para o modelo!",
                    "Algo deu errado",
                    JOptionPane.ERROR_MESSAGE
            );
            return 0;
        }

        model.setName(fieldRegisterName.getText().trim().toUpperCase());
        model.setMake(make);

        return service.createModel(model);
    }

}
