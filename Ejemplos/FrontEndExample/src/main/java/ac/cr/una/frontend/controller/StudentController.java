/*
 * Copyright (C) 2016 mguzmana
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 * 
 * Universidad Nacional de Costa Rica, Prof: Maikol Guzman Alan.
 */
package ac.cr.una.frontend.controller;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.databind.JsonMappingException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import ac.cr.una.frontend.Constants;
import ac.cr.una.frontend.model.Student;
import ac.cr.una.frontend.service.StudentService;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.AbstractButton;
import javax.swing.JButton;

/**
 * Student Controller
 *
 * @author mguzmana
 */
public class StudentController implements ActionListener {

    private JTextField searchTermTextField = new JTextField(26);
    private DefaultTableModel tableModel;
    private StudentService studentService;
    private Object[][] students;
    private JButton filterButton;
    private JButton addStudentButton;

    /**
     * Main Constructor
     *
     * @param searchTermTextField
     * @param tableModel
     *
     * @throws com.fasterxml.jackson.core.JsonGenerationException
     * @throws com.fasterxml.jackson.databind.JsonMappingException
     * @throws java.io.IOException
     */
    public StudentController(JTextField searchTermTextField,
            DefaultTableModel tableModel, JButton filterButton,
            JButton addStudentButton) throws JsonGenerationException,
            JsonMappingException, IOException, Exception {

        super();
        studentService = new StudentService();
        students = studentService.loadStudentsObjWrapper();

        this.searchTermTextField = searchTermTextField;
        this.tableModel = tableModel;
        this.filterButton = filterButton;
        this.addStudentButton = addStudentButton;

        // Load the table with the list of students
        tableModel.setDataVector(students, Constants.TABLE_HEADER);
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        if (filterButton.equals(actionEvent.getSource())) {
            String searchTerm = searchTermTextField.getText();

            //Method to search items
            updateTableSearchTerms(searchTerm);
        } else if (addStudentButton.equals(actionEvent.getSource())) {

            try {
                // Datos de prueba
                Random rand = new Random();
                int n = rand.nextInt(50) + 1;

                Student student = new Student();
                student.setName("David " + n);
                student.setCourse("Fundamentos de Progra");
                student.setRating("B-");

                studentService.createStudent(student);
                
                // Llamamos otra vez al webservice para cargar lo actual
                students = studentService.loadStudentsObjWrapper();
                updateTableSearchTerms("");
                
            } catch (JsonMappingException ex) {
                Logger.getLogger(StudentController.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                Logger.getLogger(StudentController.class.getName()).log(Level.SEVERE, null, ex);
            } catch (Exception ex) {
                Logger.getLogger(StudentController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    }

    private void updateTableSearchTerms(String searchTerm) {
        if (searchTerm != null && !"".equals(searchTerm)
                && students != null && students.length > 1) {
            Object[][] newData = new Object[students.length][];
            int idx = 0;
            for (Object[] obj : students) {
                String fullText = obj[0].toString() + obj[1].toString()
                        + obj[2].toString() + obj[3].toString();

                if (fullText.contains(searchTerm.trim())) {
                    newData[idx++] = obj;
                }
            }
            tableModel.setDataVector(newData, Constants.TABLE_HEADER);
        } else {
           
            tableModel.setDataVector(students, Constants.TABLE_HEADER);
        }
    }

}
