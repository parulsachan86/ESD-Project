package com.example.esd_placement.DAO.DAOImplementation;

import com.example.esd_placement.Bean.Department;
import com.example.esd_placement.Util.HibernateSessionUtil;
import com.example.esd_placement.DAO.DepartmentDAO;
import com.example.esd_placement.Util.HibernateSessionUtil;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class DepartmentDAOImpl implements DepartmentDAO {
    @Override
    public boolean addDepartment(Department department) {

        try (Session session = HibernateSessionUtil.getSession()){
            Transaction transaction = session.beginTransaction();
            session.persist(department);
            transaction.commit();
            return true;
        }
        catch (HibernateException exception) {
            System.out.println(exception.getLocalizedMessage());
            return false;
        }
    }
}
