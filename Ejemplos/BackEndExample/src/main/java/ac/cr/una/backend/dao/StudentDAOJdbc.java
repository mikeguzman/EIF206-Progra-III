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
package ac.cr.una.backend.dao;

import ac.cr.una.backend.model.Student;
import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author mguzmana
 */
public class StudentDAOJdbc implements StudentDAO {

    private Connection dbConnection = null;
    private Statement statement = null;

    public StudentDAOJdbc() throws SQLException {
        dbConnection = JdbcUtil.getDBConnection();
        statement = (Statement) dbConnection.createStatement();
    }

    @Override
    public Student findById(int id) {
        Student student = null;
        String selectTableSQL = "SELECT ID, NAME, COURSE, RATING from STUDENT";

        try {
            // execute select SQL stetement
            ResultSet rs = statement.executeQuery(selectTableSQL);

            if (rs != null) {
                student = new Student();
                while (rs.next()) {

                    student.setId(rs.getInt("ID"));
                    student.setName(rs.getString("NAME"));
                    student.setCourse(rs.getString("COURSE"));
                    student.setRating(rs.getString("RATING"));

                }
            }

        } catch (SQLException ex) {
            Logger.getLogger(StudentDAOJdbc.class.getName()).log(Level.SEVERE, null, ex);
        } finally {

            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException ex) {
                    Logger.getLogger(StudentDAOJdbc.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

            if (dbConnection != null) {
                try {
                    dbConnection.close();
                } catch (SQLException ex) {
                    Logger.getLogger(StudentDAOJdbc.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

        }

        return student;

    }

    @Override
    public Student save(Student student) {
        String insertTableSQL = "INSERT INTO STUDENT"
                + "(NAME, COURSE, RATING) " + "VALUES"
                + "('" + student.getName() + "','"
                + student.getCourse() + "','" + student.getRating() + "')";

        try {
            // execute insert SQL stetement
            statement.executeUpdate(insertTableSQL);

        } catch (SQLException ex) {
            Logger.getLogger(StudentDAOJdbc.class.getName()).log(Level.SEVERE, null, ex);
        } finally {

            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException ex) {
                    Logger.getLogger(StudentDAOJdbc.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

            if (dbConnection != null) {
                try {
                    dbConnection.close();
                } catch (SQLException ex) {
                    Logger.getLogger(StudentDAOJdbc.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

        }

        return student;

    }

}
