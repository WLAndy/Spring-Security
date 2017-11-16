package com.conpany.project;

import com.company.project.model.SysUserRoles;
import com.company.project.service.SysUserRolesService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import tk.mybatis.mapper.entity.Condition;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

/**
 * Created by localadmin on 2017/11/16.
 */
public class Test{

    public static void main(String args[]){
       /* A a = new A();
        a.setId(1L);
        a.setName("a");
        System.err.println(a);
        B b = new B();
        BeanUtils.copyProperties(a,b);
        System.err.println(b);*/
        StringBuffer stringBuffer = new StringBuffer("123");
        stringBuffer.substring(1);
        System.err.println(stringBuffer.toString());
    }


    @Autowired
    private SysUserRolesService sysUserRolesService;

   /* @org.junit.Test
    public void one(){
        *//*Condition condition = new Condition(SysUserRoles.class);
        condition.createCriteria().andEqualTo("rolesId",1L);
        List<SysUserRoles> sysUserRolesList = sysUserRolesService.findByCondition(condition);
        System.err.println(sysUserRolesList.size());*//*


    }*/
}
