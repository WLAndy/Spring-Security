package com.company.project.security;

import com.company.project.core.ServiceException;
import com.company.project.model.SysRole;
import com.company.project.model.SysUser;
import com.company.project.model.SysUserRoles;
import com.company.project.service.SysRoleService;
import com.company.project.service.SysUserRolesService;
import com.company.project.service.SysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import tk.mybatis.mapper.entity.Condition;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by localadmin on 2017/11/16.
 */
public class CustomUserService implements UserDetailsService {

    @Autowired
    private SysUserService sysUserService;

    @Autowired
    private SysUserRolesService sysUserRolesService;

    @Autowired
    private SysRoleService sysRoleService;

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        SysUser sysUser = sysUserService.findBy("userName",s);
        if (sysUser == null){
            throw new ServiceException("用户名不存在");
        }
        Condition condition = new Condition(SysUserRoles.class);
        condition.createCriteria().andEqualTo("userId",sysUser.getId());
        List<SysUserRoles> sysUserRolesList = sysUserRolesService.findByCondition(condition);//用户权限关联表
        StringBuffer stringBuffer = new StringBuffer();
        for (SysUserRoles sysUserRoles : sysUserRolesList){
            stringBuffer.append(",").append(sysUserRoles.getRolesId());
        }
        List<SysRole> sysRoles =  sysRoleService.findByIds(stringBuffer.length() > 0 ? stringBuffer.substring(1):"");
        sysUser.setRoles(sysRoles);
        return sysUser;
    }
}
