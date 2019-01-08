package com.jk.jtms.service;


import com.jk.jtms.entity.User;

import java.util.List;
import java.util.Map;

public interface UserService {

    int addUserService(User user);

    int isExit(String name);

    List<Map<String,Object>> getUserJL(String id);
}
