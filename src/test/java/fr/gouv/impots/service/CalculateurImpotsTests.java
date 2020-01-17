package fr.gouv.impots.service;

import fr.gouv.impots.model.AutoEntreprise;
import fr.gouv.impots.model.Entreprise;
import fr.gouv.impots.model.SAS;
import org.junit.Before;
import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

public class CalculateurImpotsTests {

    public static final String SIRET_AE = "12345678";
    public static final String SIRET_SAS = "87654321";
    public static final String DENOMINATION_AE = "PHILIPPE SIMO";
    public static final String DENOMINATION_SAS = "ZEROFILTRE";
    public static final double CHIFFRE_AFFAIRE_AE = 75000;
    public static final double CHIFFRE_AFFAIRE_SAS = 300000;
    public static double IMPOTS_ATTENDUS_AE = 18750;
    public static double IMPOTS_ATTENDUS_SAS = 99000;

    Entreprise autoEntreprise = new AutoEntreprise();
    Entreprise sas = new SAS();
    CalculateurImpots calculateur;

    @Before
    public void initialisation() {
        autoEntreprise.setSiret(SIRET_AE);
        autoEntreprise.setDenomination(DENOMINATION_AE);
        autoEntreprise.setChiffreAffaire(CHIFFRE_AFFAIRE_AE);
        sas.setSiret(SIRET_SAS);
        sas.setDenomination(DENOMINATION_SAS);
        sas.setChiffreAffaire(CHIFFRE_AFFAIRE_SAS);
    }

    @Test
    public void shouldReturnExpectedTaxForAE() {
        calculateur = new CalculateurImpotsAE();
        assertEquals(calculateur.calculer(autoEntreprise.getChiffreAffaire()), IMPOTS_ATTENDUS_AE);

    }

    @Test
    public void shouldReturnExpectedTaxForSAS() {
        calculateur = new CalculateurImpotsSAS();
        assertEquals(calculateur.calculer(sas.getChiffreAffaire()), IMPOTS_ATTENDUS_SAS);

    }


}
