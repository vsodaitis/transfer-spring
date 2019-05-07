package com.vytenis.transfer.controller;

import com.vytenis.transfer.dto.Account;
import com.vytenis.transfer.dto.User;
import com.vytenis.transfer.service.AccountService;
import com.vytenis.transfer.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/accounts", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
public class AccountsController {

    @Autowired
    private UserService userService;

    @Autowired
    private AccountService accountService;

    @GetMapping("/{userId}")
    public List<Account> getAccounts(@PathVariable("userId") Long userId) {
        User user = userService.getUser(userId);
        if (user == null) {
            throw new IllegalArgumentException("User not found");
        }
        return accountService.getUserAccounts(user);
    }

    @PostMapping
    public long addAccount(Account account) {
        return accountService.addUserAccount(account);
    }
}
