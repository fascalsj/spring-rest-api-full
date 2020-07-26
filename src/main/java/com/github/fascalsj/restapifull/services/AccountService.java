package com.github.fascalsj.restapifull.services;

import com.github.fascalsj.restapifull.entity.Account;
import com.github.fascalsj.restapifull.repository.AccountRepository;
import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class AccountService {

    @Autowired
    AccountRepository accountRepository;

    public Account save(Account account) {
        account.setPassword(DigestUtils.sha3_512Hex(account.getPassword()));
        return accountRepository.save(account);
    }

    public List<Account> findAll() {
        return accountRepository.findAll();
    }

    public Account findById(Integer id) {
        return accountRepository.findAccountById(id);
    }


}
