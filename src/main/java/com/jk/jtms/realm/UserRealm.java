package com.jk.jtms.realm;

import com.jk.jtms.entity.User;
import com.jk.jtms.service.UserService;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.credential.CredentialsMatcher;
import org.apache.shiro.authc.credential.HashedCredentialsMatcher;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.crypto.hash.Md5Hash;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;
import sun.security.provider.MD5;

import javax.annotation.Resource;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.UUID;

public class UserRealm extends AuthorizingRealm {


    @Autowired
    private UserService userServce;
    @Override
    public String getName() {
        return "UserRealm";
    }


    public static void main(String[] args) {
        System.out.println(UUID.randomUUID().toString());
    }

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        //Map primaryPrincipal = (Map) principalCollection.getPrimaryPrincipal();
        Set<String> set = new HashSet<>();
        set.add("wz:add");
        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
        info.setStringPermissions(set);
        return info;
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        if (authenticationToken.getPrincipal() != null) {
            String username = authenticationToken.getPrincipal().toString();
            User user = userServce.getUserByUsername(username);
            if (user != null) {
                String password = user.getPassword().toString();
                System.out.println(password+"-----------------");
                SimpleAuthenticationInfo info = new SimpleAuthenticationInfo(user,password,ByteSource.Util.bytes("zhangsan"),getName());
                return info;
            } else {
                return null;
            }
        } else {
            return null;
        }
    }
}