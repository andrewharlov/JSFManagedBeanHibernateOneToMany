package edu.tsystems.casm.harlov.hibernate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;



@Entity
@Table(name = "SVV_USER_GROUP_CONFIG")
public class UserGroupConfig {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID")
	private int id;
	
	@OneToOne
	@JoinColumn(name = "GROUP_CONFIG_ID")
	private GroupConfig groupConfig;
	
	@ManyToOne
	@JoinColumn(name = "USER_CONFIG_ID")
	private UserConfig userConfig;

	public int getId() {
		return id;
	}

	public UserConfig getUserConfig() {
		return userConfig;
	}

	public GroupConfig getGroupConfig() {
		return groupConfig;
	}

	@Override
	public String toString() {
		return "UserGroupConfig [id=" + id + ", groupConfigId=" + groupConfig.getId() + ", userConfig=" + userConfig + "]";
	}
}
