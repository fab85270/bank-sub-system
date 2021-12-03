package loan.bank.service;

import loan.bank.exception.LoanProposalException;
import loan.commons.dto.LoanProposalDTO;

import java.time.LocalDate;

public interface TreatmentService {


    LoanProposalDTO setLastInfos(LoanProposalDTO proposal, LocalDate birthdate, double salary, double amount, double debtRatio) throws LoanProposalException.LoanProposalRefusedException, LoanProposalException.LoanProposalBankNotFoundException;

}
