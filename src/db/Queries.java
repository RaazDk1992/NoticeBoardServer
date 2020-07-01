package db;

public class Queries{
	
	protected static final String ADD_NOTICE_Q = "INSERT INTO NOTICE(notice_title,notice_body) values(?,?)";
	protected static final String ADD_EMPLOYEE_Q = "INSERT INTO STAFFS(staff_name, staff_post, staff_contact,staff_image,weight) VALUES(?,?,?,?,?)";
	protected static final String FETCH_EMPLOYEES = "SELECT * FROM staffs WHERE status = ?  ORDER BY `weight` ASC";
	protected static final String ADD_ELECTED_Q = "INSERT INTO ELECTED_CANDIDATES(candidate_name, candidate_post,candidate_contact,candidate_image,weight) VALUES(?,?,?,?,?)";
	protected static final String UPDATE_NOTICE_Q = "UPDATE NOTICE SET notice_title = ?,notice_body =? WHERE SN=?";
	protected static final String UPDATE_EMPLOYEE_Q = "UPDATE STAFFS SET staff_name=?,staff_post=?,staff_contact=?,staff_image=? WHERE sn=?";
	protected static final String UPDATE_HEADER_SETTINGS_Q = "";
	protected static final String DELETE_EMPLOYEE = "UPDATE STAFFS SET status=? where sn=?";
	protected static final String DELETE_ELECTED_CANDIDATE = "UPDATE ELECTED_CANDIDATES SET status=? where sn=?";
	protected static final String DELETE_NOTICE = "UPDATE NOTICE SET status=? where sn=?";
	protected static final String fetch_candidate = "SELECT * FROM elected_candidates order by weight asc";
	protected static final String fetch_newsfeed = "SELECT * FROM notice order by sn desc";
	protected static final String STORE_SERVICES = "INSERT INTO services(service_title,required_document,process,fee,res_employee) values(?,?,?,?,?)";
	
	protected static final String UPDATE_SERVICES = "UPDATE services SET service_title =?, required_document=?, process=?, fee=?, res_employee =? where SN =?";
	
	protected static final String FETCH_SERVICES = "SELECT * FROM services   WHERE status = true order by SN ASC";
	
	protected static final String ADD_PlANS_AND_BUDGET = "INSERT INTO plans_and_budget(file_location,file_description) VALUES(?,?)";
	protected static final String UPDATE_PLANS_AND_BUDGET = "UPDATE plans_and_budget SET file_location = ?, file_description = ? where SN =? ";
	protected static final String FETCH_BUDGETS  = "SELECT * FROM plans_and_budget WHERE status = true";
	protected static final String LOAD_SETTINGS_Q  = "SELECT field_name, field_value FROM settings";
	protected static final String UPDATE_SETTINGS = "UPDATE settings SET field_value=? WHERE SN=?";
	
	
	

	
	
	
	public Queries(){
		//System.err.println("Queries class");
	}
}