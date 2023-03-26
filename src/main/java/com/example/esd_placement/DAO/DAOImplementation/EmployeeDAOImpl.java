package com.example.esd_placement.DAO.DAOImplementation;

import com.example.esd_placement.Bean.Employee;
import com.example.esd_placement.DAO.EmployeeDAO;
import com.example.esd_placement.Util.HibernateSessionUtil;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.ArrayList;
import java.util.List;

public class EmployeeDAOImpl implements EmployeeDAO {
    @Override
    public boolean addEmployee(Employee empobj) {
        try (Session session = HibernateSessionUtil.getSession()) {  // session created got access of hibernate session object
            Transaction transaction = session.beginTransaction();
            // transaction initiated
            // System.out.println(placObj.getOrg_name());
            //  System.out.println(placObj.getDomain());
            session.persist(empobj);                                 // using session object to save java object into MySQL
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
    public Employee login(Employee employee) {
        try (Session session = HibernateSessionUtil.getSession()) {
            String employeeEmail = employee.getEmail();
            String employeePassword = employee.getPassword();
            List<Object> result = new ArrayList<Object>(
                    session.createQuery(
                                    "FROM Employee WHERE email = :employeeEmail AND password = :employeePassword"
                            )
                            .setParameter("employeeEmail", employeeEmail)
                            .setParameter("employeePassword", employeePassword)
                            .list()

            );
            if (result.size() == 0)
                return null;
            else{
                Employee emp =  (Employee) result.get(0);
                if(emp.getDepartment().getDepartmentID() == 1){
                    return emp;
                }
                else {
                    return null;
                }
            }
//            else {
//                Employee e = (Employee) result.get(0);
//                String dep = e.getDepartment().toString();
//                if (dep == "ml") {
//                    return e;
//                }
//            }
//            else
//                return (Employee) result.get(0);
        }
        catch (HibernateException exception) {
            System.out.println(exception.getLocalizedMessage());
        }

        return null;
    }
}
