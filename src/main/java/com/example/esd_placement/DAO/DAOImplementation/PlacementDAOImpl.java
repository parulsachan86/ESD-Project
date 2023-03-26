package com.example.esd_placement.DAO.DAOImplementation;

import com.example.esd_placement.Bean.Placement;
import com.example.esd_placement.DAO.PlacementDAO;
import com.example.esd_placement.Util.HibernateSessionUtil;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class PlacementDAOImpl implements PlacementDAO {
    @Override
    public boolean addPlacement(Placement placObj) {
        try(Session session = HibernateSessionUtil.getSession()){  // session created got access of hibernate session object
            Transaction transaction = session.beginTransaction();
            // transaction initiated
//            String domain_temp=placObj.getDomain();
//            if(domain_temp=="None"){
//                placObj.setDomain(null);
//            }
//            System.out.println(placObj.getOrg_name());
//            System.out.println(placObj.getDomain());
            session.save(placObj);                                 // using session object to save java object into MySQL
            transaction.commit();                                  // committing transaction
            return true;
        }
        catch (HibernateException exception) {
            // if Hibernate Exception occurs return false
            // for related exception we can maintain separate logger / Sysout messages for easy debugging
            System.out.println("Hibernate Exception");
            System.out.print(exception.getLocalizedMessage());
            return false;
        }
        catch (Exception e){
            //generalized exception class for any IO / Arithmetic Exception
            System.out.print(e.getLocalizedMessage());
            return false;
        }
    }
}
