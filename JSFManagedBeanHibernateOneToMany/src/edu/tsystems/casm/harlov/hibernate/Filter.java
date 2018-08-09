package edu.tsystems.casm.harlov.hibernate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.GenerationType;

@Entity
@Table(name = "SVV_FILTERS")
public class Filter {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID")
	private int id;
	
	@Column(name = "NAME")
	private String name;

	@Column(name = "SQL_QUERY")
	private String sqlQuery;
	
	@ManyToOne
	@JoinColumn(name = "GROUP_CONFIG_ID")
	private GroupConfig groupConfig;

	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getSqlQuery() {
		return sqlQuery;
	}

	public GroupConfig getGroupConfig() {
		return groupConfig;
	}

	@Override
	public String toString() {
		return "Filter [id=" + id + ", name=" + name + ", sqlQuery=" + sqlQuery + ", groupConfig=" + groupConfig.getId() + "]";
	}
}
