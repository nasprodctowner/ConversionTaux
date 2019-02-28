package exoCatalogueTaux.session;

import exoCatalogueTaux.entity.ConversionTauxEntity;

import javax.ejb.Stateless;
import javax.persistence.*;
import java.util.Collection;

@Stateless (mappedName="GestionCatalogueTaux")
public class ConversionTauxBean implements ConversionTauxItf {

    @PersistenceContext (unitName="catalogueTauxPU")
    private EntityManager em;

    @Override
    public float conversion(String mA, String mB, float montant) {
        ConversionTauxEntity conversionTauxEntity = (ConversionTauxEntity) em.createQuery("SELECT c FROM ConversionTauxEntity c WHERE c.monnaieA = :mA AND c.monnaieB = :mB")
                .setParameter("mA",mA)
                .setParameter("mB",mB)
                .getSingleResult();

        return montant * conversionTauxEntity.getTaux();
    }

    @Override
    public void create(String mA, String mB, float nouveauTaux) {

        ConversionTauxEntity conversionTauxEntity = new ConversionTauxEntity(mA,mB,nouveauTaux);
        em.persist(conversionTauxEntity);
        em.flush();

    }

    @Override
    public float read(String mA, String mB) {
        ConversionTauxEntity conversionTauxEntity = (ConversionTauxEntity) em.createQuery("SELECT c FROM ConversionTauxEntity c WHERE c.monnaieA = :mA AND c.monnaieB = :mB")
                .setParameter("mA",mA)
                .setParameter("mB",mB)
                .getSingleResult();

        return conversionTauxEntity.getTaux();
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
