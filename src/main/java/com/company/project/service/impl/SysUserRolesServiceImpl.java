package com.company.project.service.impl;

import com.company.project.dao.SysUserRolesMapper;
import com.company.project.model.SysUserRoles;
import com.company.project.service.SysUserRolesService;
import com.company.project.core.AbstractService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;


/**
 * Created by Andy on 2017-11-16.
 */
@Service
@Transactional
public class SysUserRolesServiceImpl extends AbstractService<SysUserRoles> implements SysUserRolesService {
    @Resource
    private SysUserRolesMapper sysUserRolesMapper;

}
