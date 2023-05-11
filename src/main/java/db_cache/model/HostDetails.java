package db_cache.model;

public class HostDetails {

	private Integer hostId;
	private String hostName;
	private String hostType;
	
	
	public HostDetails() {
		super();
	}
	public HostDetails(Integer hostId, String hostName, String hostType) {
		super();
		this.hostId = hostId;
		this.hostName = hostName;
		this.hostType = hostType;
	}
	public Integer getHostId() {
		return hostId;
	}
	public void setHostId(Integer hostId) {
		this.hostId = hostId;
	}
	public String getHostName() {
		return hostName;
	}
	public void setHostName(String hostName) {
		this.hostName = hostName;
	}
	public String getHostType() {
		return hostType;
	}
	public void setHostType(String hostType) {
		this.hostType = hostType;
	}
	@Override
	public String toString() {
		return "HostDetails [hostId=" + hostId + ", hostName=" + hostName + ", hostType=" + hostType + "]";
	}
}
