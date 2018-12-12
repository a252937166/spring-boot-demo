package com.ouyanglol.demo.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.ouyanglol.demo.entity.Result;
import com.ouyanglol.demo.entity.ResultStatus;
import com.ouyanglol.demo.entity.ShiroUser;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.LockedAccountException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.UnauthenticatedException;
import org.apache.shiro.authz.UnauthorizedException;
import org.apache.shiro.subject.Subject;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Ouyang
 * @date 18/12/16 19:16
 */
@RestController
@Slf4j
public class ShiroController {

    @RequestMapping("/401")
    public Result page401() {
        throw new UnauthenticatedException();
    }

    @RequestMapping("/403")
    public Result page403() {
        throw new UnauthorizedException();
    }

    @PostMapping("/login")
    public Object login(@RequestBody String body){
        String oper = "用户登录";
        log.info("{}, body: {}",oper,body);
        JSONObject json = JSON.parseObject(body);
        String uname = json.getString("uname");
        String pwd = json.getString("pwd");

        if (StringUtils.isEmpty(uname)){
            return Result.error(ResultStatus.FORBIDDEN);
        }
        if (StringUtils.isEmpty(pwd)){
            return Result.error(ResultStatus.FORBIDDEN);
        }

        Subject currentUser = SecurityUtils.getSubject();
        try {
            //登录
            currentUser.login( new UsernamePasswordToken(uname, pwd) );
            //从session取出用户信息
            ShiroUser user = (ShiroUser) currentUser.getPrincipal();
            if (user==null) {
                throw new AuthenticationException();
            }
            //返回登录用户的信息给前台，含用户的所有角色和权限
            return Result.success("登陆成功");
        } catch ( UnknownAccountException uae ) {
            log.warn("用户帐号不正确");
        } catch ( IncorrectCredentialsException ice ) {
            log.warn("用户密码不正确");
        } catch ( LockedAccountException lae ) {
            log.warn("用户帐号被锁定");
        } catch ( AuthenticationException ae ) {
            log.warn("登录出错");
        }
        return Result.error(ResultStatus.ERROR);

    }
}
