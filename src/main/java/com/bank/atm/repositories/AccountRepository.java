package com.bank.atm.repositories;

import com.bank.atm.model.Account;
import lombok.SneakyThrows;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;


@Repository
public interface AccountRepository extends JpaRepository<Account, Integer> {

    @SneakyThrows
    @Transactional
    default Account insert(Account account) {
        save(account);
        return account;
    }

    Account findAccountByNumber(String number);

    Account findAccountByNumberAndPin(String number, String pin);

    @Transactional
    default void debit(Account account, int amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException("amount should be positive");
        }
        if (account.getBalance() < amount) {
            throw new IllegalStateException("Not enough money to debit");
        }
        account.setBalance(account.getBalance() - amount);
    }

}
