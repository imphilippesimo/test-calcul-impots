package fr.gouv.impots.service;

public class CalculateurImpotsSAS implements CalculateurImpots {

    public double calculer(double chiffreAffaire) {
        return 0.33 * chiffreAffaire;
    }
}
