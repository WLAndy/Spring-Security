package com.company.project.web;
import com.company.project.core.Result;
import com.company.project.core.ResultGenerator;
import com.company.project.model.SysUserRoles;
import com.company.project.service.SysUserRolesService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
* Created by Andy on 2017-11-16.
*/
@RestController
@RequestMapping("/sys/user/roles")
public class SysUserRolesController {
    @Resource
    private SysUserRolesService sysUserRolesService;

    @PostMapping("/add")
    public Result add(SysUserRoles sysUserRoles) {
        sysUserRolesService.save(sysUserRoles);
        return ResultGenerator.genSuccessResult();
    }

    @PostMapping("/delete")
    public Result delete(@RequestParam Integer id) {
        sysUserRolesService.deleteById(id);
        return ResultGenerator.genSuccessResult();
    }

    @PostMapping("/update")
    public Result update(SysUserRoles sysUserRoles) {
        sysUserRolesService.update(sysUserRoles);
        return ResultGenerator.genSuccessResult();
    }

    @PostMapping("/detail")
    public Result detail(@RequestParam Integer id) {
        SysUserRoles sysUserRoles = sysUserRolesService.findById(id);
        return ResultGenerator.genSuccessResult(sysUserRoles);
    }

    @PostMapping("/list")
    public Result list(@RequestParam(defaultValue = "0") Integer page, @RequestParam(defaultValue = "0") Integer size) {
        PageHelper.startPage(page, size);
        List<SysUserRoles> list = sysUserRolesService.findAll();
        PageInfo pageInfo = new PageInfo(list);
        return ResultGenerator.genSuccessResult(pageInfo);
    }
}
