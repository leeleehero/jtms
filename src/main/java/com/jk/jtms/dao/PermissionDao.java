package com.jk.jtms.dao;

import java.util.List;

public interface PermissionDao {

    /**
     * 查询用户的操作权限
     * @param username
     * @return
     */
    List<String> getPermissionByUser(String username);

}
