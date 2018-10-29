package PacktCassDev;

import com.datastax.driver.mapping.Result;

public class CassSecurityLogMapper {

	public static void main(String[] args) {
		String[] nodes = {"127.0.0.1"};
		CassandraConnection conn = new CassandraConnection(nodes, "cassdba", "flynnLives", 
		  "datacenter1");

		SecurityLogService securityLogSvc = new SecurityLogService(conn.getSession());
		
		//Create new security log entry
		SecurityLogsByLocation scottB = new SecurityLogsByLocation("MPLS2","scottb","M266");
		securityLogSvc.saveSecurityLogEntry(scottB);
		
		//Query security log entries for MPLS2 on 20180723
		Result<SecurityLogsByLocation> resultsFor0723 = securityLogSvc
				.getAllForDay("MPLS2", 20180723);
		for (SecurityLogsByLocation entry : resultsFor0723) {
			System.out.println(entry);			
		}
		
		//Query new security log entry created above for scottb
		SecurityLogsByLocation newEntry = securityLogSvc.getSecurityLogEntry(
				scottB.getLocation_id(), scottB.getDay(), scottB.getTime_in(), 
				scottB.getEmployee_id());
		System.out.println(newEntry);
		
		conn.close();
	}

}
