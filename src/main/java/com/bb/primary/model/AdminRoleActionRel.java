package com.bb.primary.model;

import java.io.Serializable;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.Table;

/**
 * The persistent class for the admin_role_action_rel database table.
 * 
 */
@Entity
@Table(name="admin_role_action_rel")
@NamedQuery(name="AdminRoleActionRel.findByUserId", query="select users,roles from AdminUser users,AdminRoleUserRel userRolerel,"
		+ "MRole roles where  users.id=?1 and userRolerel.userId=users.id and "
		+ "userRolerel.roleId=roles.id  ")
/*@NamedQuery(name = "Adminrole.findByRoleId",
query = "select e from Employee e where e.email = ?1")
*/public class AdminRoleActionRel implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;

	//bi-directional many-to-one association to MAction
	@ManyToOne
	@JoinColumn(name="actionId")
	private MAction MAction;

	//bi-directional many-to-one association to MRole
	@ManyToOne
	@JoinColumn(name="roleId")
	private MRole MRole;

	public AdminRoleActionRel() {
	}

	public long getId() {
		return this.id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public MAction getMAction() {
		return this.MAction;
	}

	public void setMAction(MAction MAction) {
		this.MAction = MAction;
	}

	public MRole getMRole() {
		return this.MRole;
	}

	public void setMRole(MRole MRole) {
		this.MRole = MRole;
	}

}