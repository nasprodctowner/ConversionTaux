package exoCatalogueTaux.session;


import javax.ejb.Remote;

@Remote
public interface ConsulterTauxItf {

    public float conversion(String mA, String mB, float montant);
    public float read(String mA, String mB);
}
