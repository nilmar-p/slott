package util;

import controller.MakeController;
import controller.ModelController;
import enums.Color;
import java.sql.SQLException;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import model.Make;
import model.Model;

public class Helper {

    //VehiclesDialog
    public static void refreshVehiclesDialog(JComboBox comboMake, JComboBox comboMakeRegister, JTable tableModels, JTextField fieldRegisterName) {
        DefaultTableModel tableModel = (DefaultTableModel) tableModels.getModel();
        tableModel.setRowCount(0); //clean tableModel

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

        fieldRegisterName.setText("");
    }

    public static void refreshModelsTableByFilter(JComboBox comboMake, JComboBox comboModel, JCheckBox checkModel, JTable tableModels) {
        DefaultTableModel tableModel = (DefaultTableModel) tableModels.getModel();
        tableModel.setRowCount(0);

        if (!checkModel.isSelected()) {
            try {
                for (Model md : ModelController.getModelsByMake((Make) comboMake.getSelectedItem())) {
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

            return;
        }

        try {
            Model md = ModelController.getModel(((Model) comboModel.getSelectedItem()).getId());
            tableModel.addRow(new Object[]{md.getName(), md.getMake().getName()});
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

    //menu
    public static void insertEntryOnTable() {

    }

    //new entry
    public static void refreshNewEntryDialog(JComboBox comboMake, JComboBox comboColor) {
        DefaultComboBoxModel cm = new DefaultComboBoxModel<>(Color.values());
        comboColor.setModel(cm);
        comboColor.setSelectedItem(Color.WHITE);
        
        try {
            DefaultComboBoxModel cmMake = new DefaultComboBoxModel(MakeController.getAllMakes().toArray());
            comboMake.setModel(cmMake);
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

    //
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

        if (comboModel.getModel().getSize() < 1) {
            comboModel.setEnabled(false);
            return;
        }

        comboModel.setEnabled(true);
    }

    public static void fillComboModelByMake(JComboBox comboMake, JComboBox comboModel, JCheckBox checkModel) {
        fillComboModelByMake(comboMake, comboModel);

        if (comboModel.getModel().getSize() < 1) {
            comboModel.setEnabled(false);
            checkModel.setEnabled(false);
            checkModel.setSelected(false);
            return;
        }

        comboModel.setEnabled(true);
        checkModel.setEnabled(true);
        checkModel.setSelected(true);
    }
}
