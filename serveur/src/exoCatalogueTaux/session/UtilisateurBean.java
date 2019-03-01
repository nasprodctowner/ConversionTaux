package exoCatalogueTaux.session;

import exoCatalogueTaux.entity.UtilisateurEntity;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless(mappedName="GestionUtilisateur")
public class UtilisateurBean implements UtilisateurItf {

    @PersistenceContext(unitName="utilisateurPU")
    private EntityManager em;

    @Override
    public void create(String name, String password) {
        UtilisateurEntity utilisateur = new UtilisateurEntity(name,password);

        em.persist(utilisateur);
        em.flush();
    }

    @Override
    public String read(String name) {
        return "";
    }

    @Override
    public void update(String name, String newPassword) {

    }

    @Override
    public int delete(String name) {
        return 0;
    }
}
