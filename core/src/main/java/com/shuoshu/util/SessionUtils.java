package com.shuoshu.util;

import com.shuoshu.exception.UserException;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;

/**
 * session操作工具类
 */
public class SessionUtils {
	
	private SessionUtils() {
	}

	/**
	 * 获得session
	 * @param key
	 * @param value
	 */
	public static Session getSession(){
		Subject subject = PrincipalUtils.getSubject();
		if(subject == null){
			throw new UserException("No Subject accessible to the calling code");
		}
		return subject.getSession(true);
	}
	
	/**
	 * 获得session
	 * @param create true:不存在时创建session
	 */
	public static Session getSession(boolean create){
		Subject subject = PrincipalUtils.getSubject();
		if(subject == null){
			throw new UserException("No Subject accessible to the calling code");
		}
		return subject.getSession(create);
	}
	/**
	 * 保存session相关属性
	 * @param key
	 * @param value
	 */
	public static void setSessionAttr(String key, Object value){
		Subject subject = PrincipalUtils.getSubject();
		if(subject == null){
			throw new UserException("No Subject accessible to the calling code");
		}
		Session session = subject.getSession(true);
		session.setAttribute(key, value);
	}
	
	/**
	 * 取得session中对应 key的值
	 * @param key
	 * @return
	 */
	public static Object getSessionAttr(String key){
		Subject subject = PrincipalUtils.getSubject();
		if(subject == null){
			throw new UserException("No Subject accessible to the calling code");
		}
		Session session = subject.getSession(false);
		return session==null? null:session.getAttribute(key);
	}
	
	/**
	 * 移除session中对应 key的值
	 * @param key
	 * @return
	 */
	public static Object removeAttribute(String key){
		Subject subject = PrincipalUtils.getSubject();
		if(subject == null){
			throw new UserException("No Subject accessible to the calling code");
		}
		Session session = subject.getSession();
		return session.removeAttribute(key);
	}
	
	/*public static User getSessionUser(){
		return getSessionUser(BussinessException.TYPE_JSON);
	}
	
	public static User getSessionUser(int exceptionType){
		User user = (User) getSessionAttr(Constant.SESSION_USER);
		if(user==null && BussinessException.TYPE_JSON == exceptionType){
			throw new BussinessException(ResourceUtils.get(LoanResource.USER_NOT_LOGIN), exceptionType);
		}
		return user;
	}
     *//**
      *  用户退出登录
      * @author  FangJun
      * @date 2016年7月26日
      *//*
	public static void  logout(){
		Subject subject = PrincipalUtils.getSubject();
		if(subject == null){
			throw new BussinessException(ResourceUtils.get(LoanResource.USER_NOT_LOGIN),BussinessException.TYPE_JSON);
		}
		setSessionAttr(Constant.SESSION_USER, null);
		subject.logout();
	}*/
	
}
