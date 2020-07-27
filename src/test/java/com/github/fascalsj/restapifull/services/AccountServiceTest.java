package com.github.fascalsj.restapifull.services;


import com.github.fascalsj.restapifull.entity.Account;
import com.github.fascalsj.restapifull.repository.AccountRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest
class AccountServiceTest {

    @Autowired
    AccountService accountService;

    @MockBean
    AccountRepository accountRepository;

    @Test
    public void create(){

        // Data Testing
        Account input = new Account();
        input.setUsername("fascal");
        input.setPassword("fascal123");

        //Data Expected
        Account expected = new Account();
        expected.setUsername("fascal");
        expected.setPassword("$2a$10$0J0CfGFx5f.sAmY/kR4.I.xLn3CvINUgKCr8fTmzaUcVqq4JvRC5m");

        //Mocking
        Mockito.when(accountRepository.save(Mockito.any(Account.class))).thenReturn(expected);

        Account actual = accountService.save(input);

        Assertions.assertEquals(actual.getUsername(), expected.getUsername());
        Assertions.assertEquals(actual.getPassword(), expected.getPassword());

    }

    @Test
    public void findAll(){

        //Data Expected
        Account expected = new Account();
        expected.setId(1);
        expected.setUsername("fascal");
        expected.setPassword("$2a$10$0J0CfGFx5f.sAmY/kR4.I.xLn3CvINUgKCr8fTmzaUcVqq4JvRC5m");

        List<Account> listExpected = new ArrayList<>();
        listExpected.add(expected);

        Mockito.when(accountRepository.findAll()).thenReturn(listExpected);
        List<Account> accountList = accountService.findAll();
        Assertions.assertNotNull(accountList);

    }

    @Test
    public void findById(){
        //Data Expected
        Account expected = new Account();
        expected.setId(1);
        expected.setUsername("fascal");
        expected.setRole("ROLE_ADMIN");
        expected.setPassword("$2a$10$0J0CfGFx5f.sAmY/kR4.I.xLn3CvINUgKCr8fTmzaUcVqq4JvRC5m");

        Mockito.when(accountRepository.findAccountById(Mockito.anyInt())).thenReturn(expected);

        Account actual = accountService.findById(expected.getId());

        Assertions.assertEquals(actual.getId(), expected.getId());
        Assertions.assertEquals(actual.getUsername(), expected.getUsername());
        Assertions.assertEquals(actual.getPassword(), expected.getPassword());

    }


}