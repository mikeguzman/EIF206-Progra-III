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
import org.hibernate.Query;
import org.hibernate.Session;

/**
 *
 * @author mguzmana
 */
public class StudentDAOHibernateImpl implements StudentDAO {

    private final Session session = HibernateUtil.getSessionFactory().openSession();

    @Override
    public Student findById(int id) {
        Student student = null;
        Query query = session.createQuery("from Student where id = :id ");
        query.setParameter("id", id);

        if (query.list().size() > 0) {
            student = (Student) query.list().get(0);
        }

        return student;
    }

    @Override
    public Student save(Student student) {
        session.beginTransaction();
        session.save(student);
        session.getTransaction().commit();

        return student;
    }

}
