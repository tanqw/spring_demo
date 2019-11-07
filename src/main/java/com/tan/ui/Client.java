package com.tan.ui;

import com.tan.factory.BeanFactory;
import com.tan.service.AccountService;
import com.tan.service.impl.AccountServiceImpl;

public class Client {
    public static void main(String[] args) {
//        AccountService as = new AccountServiceImpl();
        AccountService as = (AccountService) BeanFactory.getBean("accountService");
        as.saveAccount();
    }
}
