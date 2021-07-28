package fr.esgi.educationmanager.authentification;

import fr.esgi.educationmanager.authentification.domain.Account;
import fr.esgi.educationmanager.authentification.domain.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AddAccount {

    private final AccountRepository accountRepository;

    @Autowired
    public AddAccount(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    public Account execute(Account account) {
        return accountRepository.save(account);
    }
}
