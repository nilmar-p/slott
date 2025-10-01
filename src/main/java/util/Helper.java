package util;

import controller.MakeController;
import controller.ModelController;
import java.sql.SQLException;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import model.Make;
import model.Model;

public class Helper {

    //VehiclesDialog
    public static void fillCombos(JComboBox comboMake, JComboBox comboMakeRegister) {
        try {
            DefaultComboBoxModel cmMake = new DefaultComboBoxModel(MakeController.getAllMakes().toArray());
            comboMake.setModel(cmMake);

            comboMakeRegister.setModel(cmMake);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(
                    null,
                    "ERRO: não foi possível carregar as informações no formulário! \n"
                    + ex.getMessage(),
                    "Algo deu errado",
                    JOptionPane.ERROR_MESSAGE
            );
        }

    }

    public static void fillComboModelByMake(JComboBox comboMake, JComboBox comboModel) {
        Make mk = (Make) comboMake.getSelectedItem();

        try {
            DefaultComboBoxModel cmModel = new DefaultComboBoxModel(ModelController.getModelsByMake(mk).toArray());
            comboModel.setModel(cmModel);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(
                    null,
                    "ERRO: não foi possível carregar as informações no formulário! \n"
                    + ex.getMessage(),
                    "Algo deu errado",
                    JOptionPane.ERROR_MESSAGE
            );
        }
    }

    public static void fillTableVehicles(JTable tableModels) {
        DefaultTableModel tableModel = (DefaultTableModel) tableModels.getModel();

        try {
            for (Model md : ModelController.getAllModels()) {
                tableModel.addRow(new Object[]{md.getName(), md.getMake().getName()});
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(
                    null,
                    "ERRO: não foi possível carregar os registros na tabela! \n"
                    + ex.getMessage(),
                    "Algo deu errado",
                    JOptionPane.ERROR_MESSAGE
            );
        }

    }

    //methods
}
