import java.awt.Desktop;
import java.awt.Font;
import java.io.File;
import java.io.FileOutputStream;
import java.sql.Date;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.UUID;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JInternalFrame.java to edit this template
 */

/**
 *
 * @author Guillermo
 */
public class MEDICO extends javax.swing.JInternalFrame {

    Connection coneccionsql;
    Statement sentenciasql;
    DefaultTableModel modelo_tabla;  
    Integer id_medico;
    /**
     * Creates new form MEDICO
     */
    public MEDICO() {
        initComponents();
        botonEditar.setVisible(false);
        BotonGuardar.setVisible(true);
        botonBorrar.setVisible(false);
        coneccionsql = conectar.getConnection();
        llenarTablar();
    }

    public void llenarTablar() {
        try {
            //encabezados de la tabla
            String[] titulos = {"ID", "Matricula", "Nombre", "Especialidad"};
            String stsql = "SELECT medico.id_medico, medico.matricula, medico.nombre, medico.especialidad FROM medico";

            modelo_tabla = new DefaultTableModel(null, titulos);
            sentenciasql = coneccionsql.createStatement();
            ResultSet rs = sentenciasql.executeQuery(stsql);

            //arreglo fila, para almacenar registros
            String[] fila = new String[4];
            //while para insertar registros en la tabla
            while (rs.next()) {
                fila[0] = rs.getString("id_medico");
                fila[1] = rs.getString("matricula");
                fila[2] = rs.getString("nombre");
                fila[3] = rs.getString("especialidad");
                modelo_tabla.addRow(fila);
            }

            //agrego el default model
            TablaMedico.setModel(modelo_tabla);

            //definir el ancho de las columnas
            int[] anchos = {10, 100, 100, 100};
            for (int i = 0; i < TablaMedico.getColumnCount(); i++) {
                TablaMedico.getColumnModel().getColumn(i).setPreferredWidth(anchos[i]);
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        BotonGuardar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        TablaMedico = new javax.swing.JTable();
        botonEditar = new javax.swing.JButton();
        botonBorrar = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        campoEspecialidad = new javax.swing.JTextField();
        campoMatricula = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        campoNombre = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();

        setClosable(true);

        BotonGuardar.setText("GUARDAR");
        BotonGuardar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                BotonGuardarMouseClicked(evt);
            }
        });

        TablaMedico.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        TablaMedico.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TablaMedicoMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(TablaMedico);

        botonEditar.setText("EDITAR");
        botonEditar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                botonEditarMouseClicked(evt);
            }
        });

        botonBorrar.setText("BORRAR");
        botonBorrar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                botonBorrarMouseClicked(evt);
            }
        });

        jLabel3.setText("ESPECIALIDADES:");

        jLabel1.setText("MATRICULA:");

        jLabel6.setText("REGISTRAR MEDICOS:");

        jLabel2.setText("NOMBRE:");

        jLabel4.setText("listado de Medicos");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addComponent(BotonGuardar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(botonEditar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(botonBorrar))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addComponent(jLabel6))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel1)
                            .addComponent(jLabel3))
                        .addGap(56, 56, 56)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(campoNombre)
                            .addComponent(campoMatricula)
                            .addComponent(campoEspecialidad, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 30, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 427, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(12, 12, 12))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(jLabel4))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(9, 9, 9)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(campoMatricula, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(campoNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2))
                        .addGap(26, 26, 26)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(campoEspecialidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(51, 51, 51)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(BotonGuardar)
                            .addComponent(botonEditar)
                            .addComponent(botonBorrar)))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 222, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(52, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void BotonGuardarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BotonGuardarMouseClicked
        try{
            String cedula = campoMatricula.getText();
            String nombre = campoNombre.getText();
            String limite_compra = campoEspecialidad.getText();

            String sqlguardar = "INSERT INTO medico (matricula, nombre, especialidad) VALUES (?, ?, ?)";
            PreparedStatement ps = coneccionsql.prepareStatement(sqlguardar);
            ps.setString(1, cedula);
            ps.setString(2, nombre);
            ps.setString(3, limite_compra);

            int n = ps.executeUpdate();
            if (n > 0) {
                campoMatricula.setText("");
                campoNombre.setText("");
                campoEspecialidad.setText("");

                llenarTablar();
                JOptionPane.showMessageDialog(this, "Se guardó correctamente");
            } else {
                JOptionPane.showMessageDialog(this, "Error al guardar");
            }
            ps.close();
        }catch (Exception e) {
            System.out.println(e);
            JOptionPane.showMessageDialog(rootPane, "Error: No se podo registrar al cliente!");
    }//GEN-LAST:event_BotonGuardarMouseClicked
    }
    private void TablaMedicoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TablaMedicoMouseClicked
        if (evt.getButton() == 1) {
            int fila = TablaMedico.getSelectedRow();
            try {
                String stsql = "SELECT id_medico, matricula, nombre, especialidad FROM medico\n WHERE id_medico = " + TablaMedico.getValueAt(fila, 0);
                sentenciasql = coneccionsql.createStatement();
                ResultSet rs = sentenciasql.executeQuery(stsql);
                rs.next();

                id_medico = rs.getInt("id_medico");
                campoMatricula.setText(rs.getString("matricula"));
                campoNombre.setText(rs.getString("nombre"));
                campoEspecialidad.setText(rs.getString("especialidad"));

                botonEditar.setVisible(true);
                BotonGuardar.setVisible(false);
                botonBorrar.setVisible(true);

            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Error: " + e.getMessage());
            }
        }
    }//GEN-LAST:event_TablaMedicoMouseClicked

    private void botonEditarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_botonEditarMouseClicked
        try {
            String cedula = campoMatricula.getText();
            String nombre = campoNombre.getText();
            String limite_compra = campoEspecialidad.getText();

            //Guardar en la base de datos
            String stactualizar = "UPDATE medico SET matricula=?, nombre=?, especialidad=? WHERE id_medico=?";
            PreparedStatement ps = coneccionsql.prepareStatement(stactualizar);
            ps.setString(1, cedula);
            ps.setString(2, nombre);
            ps.setString(3, limite_compra);
            ps.setInt(4, id_medico);

            int n = ps.executeUpdate();
            if (n > 0) {
                //limpiar formulario
                campoMatricula.setText("");
                campoNombre.setText("");
                campoEspecialidad.setText("");

                //reiniciar el estado de los botones
                BotonGuardar.setVisible(false);
                botonEditar.setVisible(true);

                llenarTablar();
                JOptionPane.showMessageDialog(this, "Se actualizo correctamente");
            } else {
                JOptionPane.showMessageDialog(this, "Error al actualizar");
            }
            ps.close();

        } catch (Exception e) {
            System.err.println(e);
            JOptionPane.showMessageDialog(rootPane, "Error: No se podo Editar al cliente!");
        }
    }//GEN-LAST:event_botonEditarMouseClicked

    private void botonBorrarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_botonBorrarMouseClicked
        try {

            //Borrar registro en la base de datos
            String stborrar = "DELETE FROM medico WHERE id_medico =" + id_medico;
            PreparedStatement ps = coneccionsql.prepareStatement(stborrar);
            int n = ps.executeUpdate();
            if (n > 0) {
                JOptionPane.showMessageDialog(this, "Se borro correctamente");
            } else {
                JOptionPane.showMessageDialog(this, "Error al borrar");
            }
            ps.close();

            llenarTablar();
            //limpiar formulario
            campoMatricula.setText("");
            campoNombre.setText("");
            campoEspecialidad.setText("");

            //Reiniciar el estado de los botones
            BotonGuardar.setVisible(true);
            botonEditar.setVisible(false);
            botonBorrar.setVisible(false);

        } catch (Exception e) {
            System.err.println(e);
        }
    }//GEN-LAST:event_botonBorrarMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BotonGuardar;
    private javax.swing.JTable TablaMedico;
    private javax.swing.JButton botonBorrar;
    private javax.swing.JButton botonEditar;
    private javax.swing.JTextField campoEspecialidad;
    private javax.swing.JTextField campoMatricula;
    private javax.swing.JTextField campoNombre;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
