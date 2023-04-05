package presentation;

import lombok.Data;
import metier.CreditMetier;
@Data
public class CreditController implements ICreditController {
    CreditMetier creditMetier;
    public void afficher_Mensualite(Long idCredit) throws Exception{
        var creditAvecmensualite =creditMetier.calculer_Mensualite(idCredit);
        System.out.println(creditAvecmensualite);
    }

}
