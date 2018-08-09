package edu.tsystems.casm.harlov.hibernate;

import java.util.Collection;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "SVV_USER_CONFIG")
public class UserConfig {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID")
	private int id;
	
	@OneToOne
	@JoinColumn(name = "USER_ID")
	private User user;
	
	@Column(name = "NAME")
	private String name;
	
	@Column(name = "FILTER_COCKPIT_ENABLED")
	private int filterCockpitEnabled;
	
	@Column(name = "GROUP_COCKPIT_ENABLED")
	private int groupCockpitEnabled;
	
	@OneToMany(mappedBy = "userConfig", fetch = FetchType.EAGER)
	private List<UserGroupConfig> userGroupConfig;

	public int getId() {
		return id;
	}

	public User getUser() {
		return user;
	}

	public String getName() {
		return name;
	}

	public int getFilterCockpitEnabled() {
		return filterCockpitEnabled;
	}

	public int getGroupCockpitEnabled() {
		return groupCockpitEnabled;
	}
	
	public Collection<UserGroupConfig> getUserGroupConfig() {
		return userGroupConfig;
	}

	@Override
	public String toString() {
		return "UserConfig [id=" + id + ", user=" + user.getId() + ", name=" + name + ", filterCockpitEnabled="
				+ filterCockpitEnabled + ", groupCockpitEnabled=" + groupCockpitEnabled + "]";
	}
}
