package com.zc.realm;

import com.zc.common.CustomerLoginToken;
import com.zc.pojo.RolePermissionVO;
import com.zc.pojo.User;
import com.zc.pojo.UserRoleVO;
import com.zc.service.RoleService;
import com.zc.service.UserRoleService;
import com.zc.service.UserService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class MyUserRealm extends AuthorizingRealm {

    @Autowired
    private UserService userService;

    @Autowired
    private UserRoleService userRoleService;

    @Autowired
    private RoleService roleService;

    /**
     * 认证(登录时调用)
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        // 获取基于用户名和密码的令牌
        // 实际上这个authcToken是从LoginController里面currentUser.login(token)传过来的
        // 两个token的引用都是一样的,本例中是org.apache.shiro.authc.UsernamePasswordToken@33799a1e
//        UsernamePasswordToken token1 = (UsernamePasswordToken) authenticationToken;
        CustomerLoginToken token = (CustomerLoginToken) authenticationToken;
        String username = token.getUsername();
        String pwd = String.valueOf(token.getPassword());
        User user = userService.getByNamePwd(username, pwd);
        Session session = SecurityUtils.getSubject().getSession();
        if (user != null) {
            AuthenticationInfo authcInfo = new SimpleAuthenticationInfo(user.getPassword(), user.getName(), getName());
            // 在session里保存学生信息
            session.setAttribute("user", user);
            return authcInfo;
        } else {
            return null;
        }
    }

    /**
     * 授权(验证权限时调用)
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        SimpleAuthorizationInfo authorizationInfo = new SimpleAuthorizationInfo();
        Session session = SecurityUtils.getSubject().getSession();
        User user = (User) session.getAttribute("user");
        //查询用户角色对应的权限
        List<String> permissionList = new ArrayList<>();
        List<String> roleList = new ArrayList<>();
        //根据用户id查询角色
        List<UserRoleVO> userRoleList = userRoleService.listById((user.getId()).intValue());
        if(userRoleList.size() > 0) {
            for (UserRoleVO userRole:userRoleList) {
                // 添加角色
                roleList.add(userRole.getName());
            }
            for (UserRoleVO anUserRoleList : userRoleList) {
                //根据角色查询权限
                List<RolePermissionVO> rolePermissionList = roleService.listById(anUserRoleList.getRoleId());
                if (rolePermissionList.size() > 0) {
                    for (RolePermissionVO aRolePermissionList : rolePermissionList) {
                        // 添加权限
                        permissionList.add(aRolePermissionList.getPermission());
                    }
                }
            }
        }
        // 为当前用户设置角色和权限
        authorizationInfo.addRoles(roleList);
        authorizationInfo.addStringPermissions(permissionList);
        return authorizationInfo;
    }

    /**
     * 将一些数据放到ShiroSession中,以便于其它地方使用
     *比如Controller,使用时直接用HttpSession.getAttribute(key)就可以取到
     */
    private void setSession(Object key, Object value) {
        Subject currentUser = SecurityUtils.getSubject();
        if (null != currentUser) {
            Session session = currentUser.getSession();
            System.out.println("Session默认超时时间为[" + session.getTimeout() + "]毫秒");
            session.setAttribute(key, value);
        }
    }

    // 清除缓存
    public void clearCached() {
        super.clearCache(SecurityUtils.getSubject().getPrincipals());
    }

    //清除所有权限
    public void clearAuthz(){
        super.clearCachedAuthorizationInfo(SecurityUtils.getSubject().getPrincipals());
    }

}
