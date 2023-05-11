package db_cache.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "mapping", schema = "nbuversiontoapiversion")
public class NbuVersionToAPIVersion {
	
	@Id
	@Column(name = "nbuversion")
	private String nbuVersion;
	
	@Column(name = "apiversion")
	private Integer apiVersion;

	public NbuVersionToAPIVersion(String nbuVersion, Integer apiVersion) {
		super();
		this.nbuVersion = nbuVersion;
		this.apiVersion = apiVersion;
	}

	public NbuVersionToAPIVersion() {
		super();
	}

	public String getNbuVersion() {
		return nbuVersion;
	}

	public void setNbuVersion(String nbuVersion) {
		this.nbuVersion = nbuVersion;
	}

	public Integer getApiVersion() {
		return apiVersion;
	}

	public void setApiVersion(Integer apiVersion) {
		this.apiVersion = apiVersion;
	}

	@Override
	public String toString() {
		return "NbuVersionToAPIVersion [nbuVersion=" + nbuVersion + ", apiVersion=" + apiVersion + "]";
	}
	
	
	

}
