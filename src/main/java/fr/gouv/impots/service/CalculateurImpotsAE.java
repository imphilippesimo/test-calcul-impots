package fr.gouv.impots.service;

public class CalculateurImpotsAE implements CalculateurImpots {

    public double calculer(double chiffreAffaire) {
        return 0.25 * chiffreAffaire;
    }
}
