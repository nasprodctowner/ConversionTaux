package exoCatalogueTaux.session;

import javax.ejb.Remote;

@Remote
public interface ConversionTauxItf {

    public float conversion(String mA, String mB, float montant);
    public void create(String mA, String mB, float nouveauTaux);
    public float read(String mA, String mB);
    public void update(String mA, String mB, float nouveauTaux);
    public int delete(String mA, String mB);
}
