package com.bank.atm.repositories;

import com.bank.atm.model.Account;
import lombok.SneakyThrows;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

@Repository
@RepositoryRestResource(
        collectionResourceRel = "doctors",
        itemResourceRel = "doctor"
)
public interface AccountRepository extends JpaRepository<Account, Integer> {

    @SneakyThrows
    @Transactional
    default Account insert(Account account) {
        save(account);
        return account;
    }

    Account findAccountByNumber(String number);

    Account findAccountByNumberAndPin(String number, String pin);


}
