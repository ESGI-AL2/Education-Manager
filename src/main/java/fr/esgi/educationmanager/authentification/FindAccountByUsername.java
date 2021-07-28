package fr.esgi.educationmanager.authentification;


import fr.esgi.educationmanager.authentification.domain.Account;
import fr.esgi.educationmanager.authentification.domain.AccountRepository;
import fr.esgi.educationmanager.authentification.execptions.AccountWithUsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class FindAccountByUsername {

    private final AccountRepository accountRepository;

    public FindAccountByUsername(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    public Account execute(String username){
        return accountRepository.findPlayerByUsername(username)
                .orElseThrow(() -> new AccountWithUsernameNotFoundException(username));
    }
}
