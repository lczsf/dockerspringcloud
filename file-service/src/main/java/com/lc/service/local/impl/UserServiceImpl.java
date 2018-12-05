package com.lc.service.local.impl;

import com.lc.entity.*;
import com.lc.mapper.SysRoleMapper;
import com.lc.mapper.SysRoleUserMapper;
import com.lc.mapper.SysUserMapper;
import com.lc.service.local.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by lenovo on 2018/12/3.
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private SysUserMapper     userMapper;
    @Autowired
    private SysRoleMapper     roleMapper;
    @Autowired
    private SysRoleUserMapper roleUserMapper;

    @Override
    public SysUser loadByUsername(String username) {
        SysUserExample example = new SysUserExample();
        example.createCriteria().andUserNameEqualTo(username);
        List<SysUser> userList = this.userMapper.selectByExample(example);
        if (userList != null && userList.size() > 0) {
            SysUser res = userList.get(0);
            // 查询用户-角色列表
            SysRoleUserExample userRoleExample = new SysRoleUserExample();
            userRoleExample.createCriteria().andSysUserIdEqualTo(userList.get(0).getId());
            List<SysRoleUserKey> userRoleList = this.roleUserMapper.selectByExample(userRoleExample);
            if (userRoleList != null && userRoleList.size() > 0) {
                List<Integer> idList = new ArrayList<Integer>();
                for (SysRoleUserKey userRoleKey : userRoleList) {
                    idList.add(userRoleKey.getSysRoleId());
                }
                SysRoleExample roleExample = new SysRoleExample();
                roleExample.createCriteria().andIdIn(idList);
                List<SysRole> roleList = this.roleMapper.selectByExample(roleExample);
                res.setRoles(roleList);
                return res;
            }
        }
        return null;
    }
}
