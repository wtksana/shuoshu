package com.shuoshu.web.shiro;

import com.shuoshu.core.user.entity.User;
import com.shuoshu.core.user.service.UserService;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.Resource;

/**
 * Created by mutou on 2016/9/12.
 */
public class ShuoShuRealm extends AuthorizingRealm {

   /* @Resource的作用相当于@Autowired，只不过@Autowired按byType自动注入，而@Resource默认按 byName自动注入罢了。@Resource有两个属性是比较重要的，分是name和type，Spring将@Resource注解的name属性解析为bean的名字，而type属性则解析为bean的类型。所以如果使用name属性，则使用byName的自动注入策略，而使用type属性时则使用byType自动注入策略。如果既不指定name也不指定type属性，这时将通过反射机制使用byName自动注入策略。
            　　@Resource装配顺序
　　1. 如果同时指定了name和type，则从Spring上下文中找到唯一匹配的bean进行装配，找不到则抛出异常
　　2. 如果指定了name，则从上下文中查找名称（id）匹配的bean进行装配，找不到则抛出异常
　　3. 如果指定了type，则从上下文中找到类型匹配的唯一bean进行装配，找不到或者找到多个，都会抛出异常
　　4. 如果既没有指定name，又没有指定type，则自动按照byName方式进行装配；如果没有匹配，则回退为一个原始类型进行匹配，如果匹配则自动装配*/
    @Autowired
    private UserService userService;

    private String name = "shuoShuRealm";

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    //用于授权
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        // token是用户输入的用户名和密码
        // 第一步从token中取出用户名
        String userName;
        /*userName = (String) principals.getPrincipal();*/

        // 第二步：根据用户输入的userCode从数据库查询
        /*SysUser sysUser = null;

        try {
            sysUser = sysService.findSysUserByUserCode(userCode);
        } catch (Exception e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        }

        // 如果查询不到返回null
        if(sysUser==null){//
            return null;
        }
        // 从数据库查询到密码
        String password = sysUser.getPassword();

        //盐
        String salt = sysUser.getSalt();

        // 如果查询到返回认证信息AuthenticationInfo

        //activeUser就是用户身份信息
        ActiveUser activeUser = new ActiveUser();

        activeUser.setUserid(sysUser.getId());
        activeUser.setUsercode(sysUser.getUsercode());
        activeUser.setUsername(sysUser.getUsername());
        //..

        //根据用户id取出菜单
        List<SysPermission> menus  = null;
        try {
            //通过service取出菜单
            menus = sysService.findMenuListByUserId(sysUser.getId());
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        //将用户菜单 设置到activeUser
        activeUser.setMenus(menus);

        //将activeUser设置simpleAuthenticationInfo
        SimpleAuthenticationInfo simpleAuthenticationInfo = new SimpleAuthenticationInfo(
                activeUser, password,ByteSource.Util.bytes(salt), this.getName());

        return simpleAuthenticationInfo;*/
        return null;
    }

    //用于认证
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {

        //获取用户名
        String userName = (String)token.getPrincipal();

        //根据用户名从数据库中查找
        User user = null;
        user = userService.findByUserName(userName);
        if(user == null)
            return null;

        String password = user.getPwd();


        //start
        //这之间可以进行 从数据库查询用户权限，跟user一同存到一个封装的类中

        //
        SimpleAuthenticationInfo simpleAuthenticationInfo = new SimpleAuthenticationInfo(user, password, this.getName());
        return simpleAuthenticationInfo;
    }
}
