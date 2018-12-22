package com.ouyanglol.demo.config.shiro;

import com.ouyanglol.demo.util.HexUtil;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationException;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;

/**
 * @author Ouyang
 * @date 18/12/13 23:30
 */
public class MyRealm extends AuthorizingRealm {

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        //null usernames are invalid
        if (principalCollection == null) {
            throw new AuthorizationException("PrincipalCollection method argument cannot be null.");
        }
        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
        return info;
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        ShiroUser shiroUser = new ShiroUser();
        shiroUser.setUsername("admin");
        shiroUser.setPwd(HexUtil.encryption("password"));
        SimpleAuthenticationInfo info = new SimpleAuthenticationInfo(shiroUser, shiroUser.getPwd(), getName());
        return info;
    }

}
