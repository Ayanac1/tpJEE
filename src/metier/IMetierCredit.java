package metier;

import model.Credit;

public interface IMetierCredit {
    Credit calculer_Mensualite(Long idCredit)throws Exception;
}
