package com.jk.jtms.realm;

import com.jk.jtms.service.UserService;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class UserRealm extends AuthorizingRealm {

    @Autowired
    private UserService userServce;

    @Override
    public String getName() {
        return "UserRealm";
    }

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        Map primaryPrincipal = (Map) principalCollection.getPrimaryPrincipal();
        Set<String> set = new HashSet<>();
        set.add("wz:delete");
        set.add("wz:add");
        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
        info.setStringPermissions(set);
        return info;
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        if (authenticationToken.getPrincipal() != null) {
            String username = authenticationToken.getPrincipal().toString();
            Map<String, Object> map = userServce.getUserByUsername(username);
            if (map != null) {
                String password = map.get("password").toString();
                SimpleAuthenticationInfo info = new SimpleAuthenticationInfo(map, password, ByteSource.Util.bytes(map.get("username")),getName());
                return info;
            } else {
                return null;
            }
        } else {
            return null;
        }
    }
}