package exoCatalogueTaux.session;

import javax.ejb.Remote;

@Remote
public interface UtilisateurItf {

    public void create(String name, String password);
    public String read(String name);
    public void update(String name, String newPassword);
    public int delete(String name);
}
