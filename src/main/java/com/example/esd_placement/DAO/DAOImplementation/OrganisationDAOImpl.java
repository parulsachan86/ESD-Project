package com.example.esd_placement.DAO.DAOImplementation;

import com.example.esd_placement.Bean.Organisation;

import com.example.esd_placement.DAO.OrganisationDAO;

import com.example.esd_placement.Util.HibernateSessionUtil;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.ArrayList;
import java.util.List;

public class OrganisationDAOImpl implements OrganisationDAO {
    @Override
    public boolean addOrganisation(Organisation Orgobj) {
        try (Session session = HibernateSessionUtil.getSession()) {  // session created got access of hibernate session object
            Transaction transaction = session.beginTransaction();
            // transaction initiated
//            System.out.println(placObj.getOrg_name());
            //  System.out.println(placObj.getDomain());
            session.persist(Orgobj);                                 // using session object to save java object into MySQL
            transaction.commit();                                  // committing transaction
            return true;
        } catch (HibernateException exception) {
            // if Hibernate Exception occurs return false
            // for related exception we can maintain separate logger / Sysout messages for easy debugging
            System.out.println("Hibernate Exception");
            System.out.print(exception.getLocalizedMessage());
            return false;
        } catch (Exception e) {
            //generalized exception class for any IO / Arithmetic Exception
            System.out.print(e.getLocalizedMessage());
            return false;
        }
    }

    @Override
    public Organisation getOrgByID(int id) {
        try (Session session = HibernateSessionUtil.getSession()) {
            return session.get(Organisation.class, id);
        } catch (HibernateException exception) {
            System.out.println(exception.getLocalizedMessage());
        }
        return null;
    }

    @Override
    public List<Organisation> getOrganisationList() {
        try (Session session = HibernateSessionUtil.getSession()) {
            List<Organisation> organisationList = new ArrayList<>();
            for (final Object d : session.createQuery("from Organisation ").list()) {
                organisationList.add((Organisation) d);
            }
            return organisationList;

        } catch (HibernateException exception) {
            System.out.print(exception.getLocalizedMessage());
            return null;
        }
    }
}

