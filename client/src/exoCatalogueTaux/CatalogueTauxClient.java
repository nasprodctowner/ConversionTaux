package exoCatalogueTaux;


import exoCatalogueTaux.session.ConsulterTauxItf;
import exoCatalogueTaux.session.GestionCatalogueTauxItf;
import exoCatalogueTaux.session.UtilisateurItf;

import javax.naming.InitialContext;
import java.util.*;

public class CatalogueTauxClient {

    private static GestionCatalogueTauxItf refGestionCatalogueTauxBEAN ;
    private static UtilisateurItf refUtilisateurBEAN ;
    private static ConsulterTauxItf refConsulterTauxBEAN ;

    public static void main(String[] args) throws Exception {

		try {

			InitialContext ctx = new InitialContext();
            refGestionCatalogueTauxBEAN = (GestionCatalogueTauxItf) ctx.lookup("GestionCatalogueTaux");
            refUtilisateurBEAN = (UtilisateurItf) ctx.lookup("GestionUtilisateur");
            refConsulterTauxBEAN = (ConsulterTauxItf) ctx.lookup("ConsulterTaux");
		} catch (Exception ex) {
			System.err.println("erreur dans le lookup");
			ex.printStackTrace();
		}

		Scanner scanner = new Scanner(System.in);

		/*
		System.out.println("1-Conversion 2-Create 3-Read 4-Update 5-Delete");
		int choix = scanner.nextInt();

		switch (choix) {
			case 1:
				System.out.println("Monnaie A ?");
				String mA = scanner.nextLine();


				System.out.println("Monnaie B ?");
				String mB = scanner.nextLine();


				System.out.println("Montant ?");
				float montant = scanner.nextFloat();

				System.out.println("Montant convertit : ");
				System.out.println(refBeanCata.conversion(mA, mB, montant));

				break;

			case 3:

				System.out.println("Monnaie A ?");
				String mA3 = scanner.nextLine();

				System.out.println("Monnaie B ?");
				String mB3 = scanner.nextLine();

				System.out.println("Le taux est : ");
				System.out.println(refBeanCata.read(mA3, mB3));
				break;
		}*/

        /*
        System.out.println("Monnaie A ?");
        String mA3 = scanner.nextLine();

        System.out.println("Monnaie B ?");
        String mB3 = scanner.nextLine();

        System.out.println("Taux ?");
        float taux = scanner.nextFloat();

        refBeanCata.create(mA3,mB3,taux);

        System.out.println("Entrée créé !" );*/

        /*
        System.out.println("Nom A ?");
        String nom = scanner.nextLine();

        System.out.println("Password ?");
        String password = scanner.nextLine();

        refUtilisateurBEAN.create(nom,password);

        System.out.println("Entrée créé !" );
        */


        /*
        System.out.println("Monnaie A ?");
        String mA3 = scanner.nextLine();

        System.out.println("Monnaie B ?");
        String mB3 = scanner.nextLine();

        System.out.println("Le taux est : ");
        System.out.println(refConsulterTauxBEAN.read(mA3, mB3));
        */

        /*
        System.out.println("Monnaie A ?");
        String mA = scanner.nextLine();


        System.out.println("Monnaie B ?");
        String mB = scanner.nextLine();


        System.out.println("Montant ?");
        float montant = scanner.nextFloat();

        System.out.println("Montant convertit : ");
        System.out.println(refConsulterTauxBEAN.conversion(mA, mB, montant));*/

        System.out.println("Name ?");
        String name = scanner.nextLine();


        System.out.println("Password ?");
        String password = scanner.nextLine();

        if (refGestionCatalogueTauxBEAN.connect(name,password)){

            System.out.println("Connecté !");

            System.out.println("Monnaie A ?");
            String mA3 = scanner.nextLine();

            System.out.println("Monnaie B ?");
            String mB3 = scanner.nextLine();

            System.out.println("Taux ?");
            float taux = scanner.nextFloat();

            refGestionCatalogueTauxBEAN.create(mA3,mB3,taux);
            System.out.println("Entrée créé !" );
        }else {
            System.out.println("Creation impossible car non connecté!" );
        }




	}

}
