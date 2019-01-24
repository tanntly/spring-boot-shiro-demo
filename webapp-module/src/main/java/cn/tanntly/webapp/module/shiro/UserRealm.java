package cn.tanntly.webapp.module.shiro;

import cn.tanntly.dao.UserRepository;
import cn.tanntly.entity.User;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;

public class UserRealm extends AuthorizingRealm {

    @Autowired
    private UserRepository userRepository;

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        Subject subject = SecurityUtils.getSubject();
        User user = (User) subject.getPrincipal();
        //给资源授权
        SimpleAuthorizationInfo simpleAuthorizationInfo = new SimpleAuthorizationInfo();

        simpleAuthorizationInfo.addRole(user.getRoles());
        simpleAuthorizationInfo.addStringPermission(user.getPrems());

        simpleAuthorizationInfo.addStringPermission(user.getPrems());
        return simpleAuthorizationInfo;

    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        // TODO Auto-generated method stub
        System.out.println("认证");

        //shiro判断逻辑
        UsernamePasswordToken user = (UsernamePasswordToken) authenticationToken;
        User realUser = new User();
        realUser.setUserName(user.getUsername());
        realUser.setPassword(String.copyValueOf(user.getPassword()));

        User newUser = userRepository.findByUserNameAndPassword(realUser.getUserName(),realUser.getPassword());
        //System.out.println(user.getUsername());
        if(newUser == null){
            //用户名错误
            //shiro会抛出UnknownAccountException异常
            return null;
        }

        return new SimpleAuthenticationInfo(newUser,newUser.getPassword(),"");

    }

}
