package com.tan.ui;

import com.tan.factory.BeanFactory;
import com.tan.service.AccountService;
import com.tan.service.impl.AccountServiceImpl;

public class Client {
    public static void main(String[] args) {
//        AccountService as = new AccountServiceImpl();
        for (int i=0;i<5;i++){
            AccountService as = (AccountService) BeanFactory.getBean("accountService");
//            System.out.println(as);
            as.saveAccount();
        }

    }
}
