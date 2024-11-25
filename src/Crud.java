import config.HibernateConfig;
import models.Personas;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.math.BigDecimal;

public class Crud {

    public void createComponentes(String nombre, String apellido, BigDecimal salario) {
        try (Session session = HibernateConfig.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();

            Personas personas = new Personas(nombre, apellido, salario);
            session.save(personas);

            transaction.commit();
        } catch (Exception e) {
            System.out.println("Error while creating personas: " + e.getMessage());
        }
    }


    public void readComponentes(String nombre) {
        try (Session session = HibernateConfig.getSessionFactory().openSession()) {
            session.beginTransaction();
            String hql = "FROM Personas WHERE nombre = :nombre";
            Personas persona = session.createQuery(hql, Personas.class)
                    .setParameter("nombre", nombre)
                    .uniqueResult();

            if (persona != null) {
                System.out.println(persona);
            } else {
                System.out.println("Persona with name " + nombre + " not found.");
            }

            session.getTransaction().commit();
        }
    }

    public void updateComponentes(String nombre, String newApellido, BigDecimal newSalario) {
        try (Session session = HibernateConfig.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            String hql = "FROM Personas WHERE nombre = :nombre";
            Personas persona = session.createQuery(hql, Personas.class)
                    .setParameter("nombre", nombre)
                    .uniqueResult();

            if (persona != null) {
                persona.setApellido(newApellido);
                persona.setSalario(newSalario);
                session.update(persona);
            }
            System.out.println("Persona actualizada correctamente");
            transaction.commit();
        } catch (Exception e) {
            System.out.println("Error while updating Componentes: " + e.getMessage());
        }
    }

    public void deleteComponentes(String nombre) {
        try (Session session = HibernateConfig.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            String hql = "FROM Personas WHERE nombre = :nombre";
            Personas persona = session.createQuery(hql, Personas.class)
                    .setParameter("nombre", nombre)
                    .uniqueResult();

            if (persona != null) {
                session.delete(persona);
                System.out.println("Persona borrada correctamente");
            }
            transaction.commit();
        } catch (Exception e) {
            System.out.println("Error while deleting Componentes: " + e.getMessage());
        }
    }
}
