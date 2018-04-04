package com.fulln.security.Filter;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.access.SecurityConfig;
import org.springframework.security.web.FilterInvocation;
import org.springframework.security.web.access.intercept.FilterInvocationSecurityMetadataSource;
import org.springframework.util.AntPathMatcher;
import org.springframework.util.PathMatcher;

import javax.servlet.ServletContext;
import java.util.*;


public class SecureResourceFilterInvocationDefinitionSource implements FilterInvocationSecurityMetadataSource, InitializingBean {
      
    private PathMatcher matcher;  
      
    private static Map<String, Collection<ConfigAttribute>> map = new HashMap<String, Collection<ConfigAttribute>>();
  
    /*  
     * 初始化用户权限，为了简便操作没有从数据库获取 
     * 实际操作可以从数据库中获取所有资源路径url所对应的权限
     * 实际操作中  路径访问的添加  存在一点问题 存数据表来进行加载 每次新增页面都要进行一个权限的配置么？
     * 之前是通过页面进行路径权限的配置 现在配置路径的方法是读取文件？还是存储到数据库中
     */
    public void afterPropertiesSet() throws Exception {

        this.matcher = new AntPathMatcher();//用来匹配访问资源路径  
        Collection<ConfigAttribute> atts = new ArrayList<ConfigAttribute>();
        ConfigAttribute ca = new SecurityConfig("ROLE_USER");
        atts.add(ca);   
        map.put("/home/index", atts);
        Collection<ConfigAttribute> attsno =new ArrayList<ConfigAttribute>();
        ConfigAttribute cano = new SecurityConfig("ROLE_NO");
        attsno.add(cano);  
        map.put("/home/detail", attsno);
    }  

  
    @Override  
    public Collection<ConfigAttribute> getAttributes(Object object)
            throws IllegalArgumentException {  
        // TODO Auto-generated method stub  
        FilterInvocation filterInvocation = (FilterInvocation) object;

        String requestURI = filterInvocation.getRequestUrl();  
        //循环资源路径，当访问的Url和资源路径url匹配时，返回该Url所需要的权限  
        for(Iterator<Map.Entry<String, Collection<ConfigAttribute>>> iter = map.entrySet().iterator(); iter.hasNext();) {
            Map.Entry<String, Collection<ConfigAttribute>> entry = iter.next();
            String url = entry.getKey();
            if(matcher.match(url, requestURI)) {
                return map.get(requestURI);
            }
        }
        return null;  
    }  
  
    @Override  
    public Collection<ConfigAttribute> getAllConfigAttributes() {
        // TODO Auto-generated method stub  
        return null;  
    }  
  
    /* (non-Javadoc) 
     * @see org.springframework.security.intercept.ObjectDefinitionSource#getConfigAttributeDefinitions() 
     */  
    @SuppressWarnings("rawtypes")  
    public Collection getConfigAttributeDefinitions() {  
        return null;  
    }  
  
    /* (non-Javadoc) 
     * @see org.springframework.security.intercept.ObjectDefinitionSource#supports(java.lang.Class) 
     */  
    public boolean supports(@SuppressWarnings("rawtypes") Class clazz) {  
        return true;  
    }  
      
    /**
     * @param filterInvocation 
     * @return 
     */  
    @SuppressWarnings("unchecked")  
    private Map<String, String> getUrlAuthorities(org.springframework.security.web.FilterInvocation filterInvocation) {
        ServletContext servletContext = filterInvocation.getHttpRequest().getSession().getServletContext();  
        return (Map<String, String>)servletContext.getAttribute("urlAuthorities");  
    }  
  
}  