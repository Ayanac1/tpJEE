package metier;
import dao.daoVolatile.CreditDao;
import lombok.Data;
import model.Credit;

@Data
public class CreditMetier {
    CreditDao creditDao;

    public Credit calculer_Mensualite(long idCredit)throws Exception{
        var credit= creditDao.trouverParId(idCredit);
        if(credit==null)
            throw new Exception("l id est introuvable");
        else {
            double taux = credit.getTaux_Mensuel();
             taux = taux/1200;
             double capital = credit.getCapilate_Emprunt();
             int nbr_mois = credit.getNombre_mois();
             double mensualite= (capital*taux)/(1-(Math.pow((1+taux),-1*nbr_mois)));
             mensualite = Math.round(mensualite*100)/100;
             credit.setMensualite(mensualite);
        }        return credit;
    }
}
