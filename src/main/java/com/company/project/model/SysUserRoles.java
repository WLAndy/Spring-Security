package com.company.project.model;

import javax.persistence.*;

@Table(name = "sys_user_roles")
public class SysUserRoles {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "user_id")
    private Long userId;

    @Column(name = "roles_id")
    private Long rolesId;

    /**
     * @return id
     */
    public Long getId() {
        return id;
    }

    /**
     * @param id
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * @return user_id
     */
    public Long getUserId() {
        return userId;
    }

    /**
     * @param userId
     */
    public void setUserId(Long userId) {
        this.userId = userId;
    }

    /**
     * @return roles_id
     */
    public Long getRolesId() {
        return rolesId;
    }

    /**
     * @param rolesId
     */
    public void setRolesId(Long rolesId) {
        this.rolesId = rolesId;
    }


    @Override
    public String toString() {
        return "SysUserRoles{" +
                "id=" + id +
                ", userId=" + userId +
                ", rolesId=" + rolesId +
                '}';
    }
}