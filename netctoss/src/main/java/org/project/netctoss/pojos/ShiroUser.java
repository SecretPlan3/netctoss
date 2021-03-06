package org.project.netctoss.pojos;

import java.io.Serializable;
import java.util.Objects;

public class ShiroUser implements Serializable {  
    private static final long serialVersionUID = -1373760761780840081L;  
    public Long id;  
    public String loginName;  
    public String name;  

    public ShiroUser(Long id, String loginName, String name) {  
        this.id = id;  
        this.loginName = loginName;  
        this.name = name;  
    }  

    public String getName() {  
        return name;  
    }  

    public String getLoginName() {  
        return loginName;  
    }  

    /** 
     * 本函数输出将作为默认的<shiro:principal>输出. 
     */  
    @Override  
    public String toString() {  
        return loginName;  
    }  

    /** 
     * 重载hashCode,只计算loginName; 
     */  
    @Override  
    public int hashCode() {  
        return Objects.hashCode(loginName);  
    }  

    /** 
     * 重载equals,只计算loginName; 
     */  
    @Override  
    public boolean equals(Object obj) {  
        if (this == obj)  
            return true;  
        if (obj == null)  
            return false;  
        if (getClass() != obj.getClass())  
            return false;  
        ShiroUser other = (ShiroUser) obj;  
        if (loginName == null) {  
            if (other.loginName != null)  
                return false;  
        } else if (!loginName.equals(other.loginName))  
            return false;  
        return true;  
    }  
}  


