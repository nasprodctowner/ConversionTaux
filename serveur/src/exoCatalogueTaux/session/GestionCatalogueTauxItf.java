package exoCatalogueTaux.session;

import exoCatalogueTaux.entity.UtilisateurEntity;

import javax.ejb.Remote;

@Remote
public interface GestionCatalogueTauxItf {

    public boolean connect(String name, String password);
    public void create(String mA, String mB, float nouveauTaux);
    public void update(String mA, String mB, float nouveauTaux);
    public int delete(String mA, String mB);
}
