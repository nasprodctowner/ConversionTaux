package exoCatalogueTaux.session;

import exoCatalogueTaux.entity.ConversionTauxEntity;
import exoCatalogueTaux.entity.UtilisateurEntity;

import javax.ejb.Stateful;
import javax.ejb.Stateless;
import javax.persistence.*;
import java.util.Collection;
import java.util.List;

@Stateful (mappedName="GestionCatalogueTaux")
public class GestionCatalogueTauxBean implements GestionCatalogueTauxItf {

    @PersistenceContext (unitName="gestionCatalogueTauxPU")
    private EntityManager em;

    private boolean isConnected = false;

    @Override
    public boolean connect(String name, String password) {

        try {
            List utilisateurs =  em.createQuery ("SELECT c FROM UtilisateurEntity c WHERE c.name = :name AND c.password = :password ")
                    .setParameter("name",name)
                    .setParameter("password",password)
                    .getResultList();

                    isConnected = !utilisateurs.isEmpty();
                    System.out.println("Connecté !");
        }catch (Exception e){
            System.out.println("Erreur");
        }

        return isConnected;
    }

    @Override
    public void create(String mA, String mB, float nouveauTaux) {

        if (isConnected) {
            ConversionTauxEntity conversionTauxEntity = new ConversionTauxEntity(mA, mB, nouveauTaux);
            em.persist(conversionTauxEntity);
            em.flush();
        }
        else {
            System.out.println("pas connecté");
        }

    }

    @Override
    public void update(String mA, String mB, float nouveauTaux) {
        ConversionTauxEntity conversionTauxEntity = (ConversionTauxEntity) em.createQuery("SELECT c FROM ConversionTauxEntity c WHERE c.monnaieA = :mA AND c.monnaieB = :mB")
                .setParameter("mA",mA)
                .setParameter("mB",mB)
                .getSingleResult();

        conversionTauxEntity.setTaux(nouveauTaux);
    }

    @Override
    public int delete(String mA, String mB) {

        int deleted =  em.createQuery("DELETE FROM ConversionTauxEntity c WHERE c.monnaieA = :mA AND c.monnaieB = :mB")
                .setParameter("mA",mA)
                .setParameter("mB",mB)
                .executeUpdate();

        return deleted;

    }

}
