package servlet;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.FilenameUtils;
import org.apache.commons.io.IOUtils;

import objects.Budget;
import objects.ElectedCandidate;
import objects.NewsFeed;
import objects.Services;
import objects.Settings;
import objects.Staff;



/**
 * Servlet implementation class Base
 */
@WebServlet(asyncSupported = true, urlPatterns = { "/Base" })
@MultipartConfig
public class Base extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String CANDIDATE_IMAGE_PATH = "candidate_image";
	private static final String STAFF_IMAGE_PATH = "staff_image";
	private static final String BUDGETS_AND_PLANS = "budgets_and_plans";
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Base() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//	response.getWriter().append("Served at: ").append(request.getContextPath());
			String device_type = request.getParameter("device_type");
			String Query = request.getParameter("required");
			
			response.setContentType("application/json");
			response.setCharacterEncoding("UTF-8");
			
			if(device_type != null){
				
				if(Query.equalsIgnoreCase("newsfeed")){
					
					response.getWriter().write(new NewsFeed().fetchNewsFeed().toString());
					
					
				}else if(Query.equalsIgnoreCase("elected_candidates")){
					
					String IpAddress = InetAddress.getLocalHost().getHostAddress();
					int Port = request.getServerPort();
					response.getWriter().write(new ElectedCandidate().fetchCandidate(IpAddress, Port).toString());
					
				}else if(Query.equalsIgnoreCase("staffs")){
					
					String Address = InetAddress.getLocalHost().getHostAddress().toString();
					int Port = request.getServerPort();
					response.getWriter().write(new Staff().fetchStaff(Address, Port).toString());
					
				}else if(Query.equalsIgnoreCase("bugdets_and_plans")){
					
				} else if(Query.equalsIgnoreCase("services")){
					
					response.getWriter().write(new Services().loadServices().toString());
				} else if(Query.equalsIgnoreCase("settings")){
					
					response.getWriter().write(new Settings().settingsAsArray().toString());
				}
			}
		
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		request.setCharacterEncoding("UTF-8");
		String operation = request.getParameter("operation");
		
		if(operation.equalsIgnoreCase("new_newsfeed")){
			
			String title = request.getParameter("notice_title");
			String body = request.getParameter("notice_details");
		//	System.err.println(title);
			response.getWriter().write(new NewsFeed().addNewsFeed(title, body).toString());
			
		} else if(operation.equalsIgnoreCase("new_services")){
			String service_title = request.getParameter("service_name");
			String required_docs = request.getParameter("required_documents");
			String process = request.getParameter("process");
			String res_employee  =request.getParameter("res_employee");
			String service_amt = request.getParameter("amount");
			response.getWriter().write(new Services().
					addServices(service_title, required_docs, process, res_employee, service_amt).toString());
			
		} else if(operation.equalsIgnoreCase("new_staff")){
			
			
			String staff_name  = request.getParameter("staff_name");
			String staff_post = request.getParameter("staff_designation");
			String staff_contact = request.getParameter("staff_contact");
			int Weight = Integer.parseInt(request.getParameter("staff_weight"));
			String image_path = new FileHandler(request.getPart("staff_image"), request.getServletContext().getRealPath("/").toString().trim()+"/"+STAFF_IMAGE_PATH,request.getServletContext().getContextPath()+"/"+STAFF_IMAGE_PATH)
			.storeFile();
			response.getWriter().write(new Staff().addStaff(staff_name, staff_post, staff_contact, image_path, Weight).toString());

			
		} else if(operation.equalsIgnoreCase("new_candidate")){
			
			String candidate_name = request.getParameter("elected_candidate_name");
			String candidate_designation = request.getParameter("elected_candidate_designation");
			String candidate_contact = request.getParameter("elected_candidate_contact");
			int CandidateWeight = Integer.parseInt(request.getParameter("candidate_weight"));
			String image_path = new FileHandler(request.getPart("elected_candidate_photo"),request.getServletContext().getRealPath("/").toString().trim()+"/"+CANDIDATE_IMAGE_PATH,request.getServletContext().getContextPath()+"/"+CANDIDATE_IMAGE_PATH)
					.storeFile();
			
			if(image_path!=null){
				
				response.getWriter().write(new ElectedCandidate()
						.addCandidate(candidate_name, candidate_designation, candidate_contact, image_path, CandidateWeight).toString());
			}else {
				
			}
			
			
		
		} else if(operation.equalsIgnoreCase("new_budgets_plans")){
			
			
			String description = request.getParameter("file_desc");
			String file_path = new FileHandler(request.getPart("file"),request.getServletContext().getRealPath("/").toString().trim()+"/"+BUDGETS_AND_PLANS,request.getServletContext().getContextPath()+"/"+BUDGETS_AND_PLANS)
					.storeFile();
			//response.getWriter().write(file_path);
			if(file_path != null){
				
				response.getWriter().write(new Budget().addBudget(file_path, description).toString());
			}else {
				
			}
		} else if(operation.equalsIgnoreCase("new_header_settings")){
			
		}else if(operation.equalsIgnoreCase("new_body_settings")){
			
		}else if(operation.equalsIgnoreCase("update_newsfeed")){
			
		}else if(operation.equalsIgnoreCase("update_services")){
			
		}else if(operation.equalsIgnoreCase("update_staff")){
			
		}else if(operation.equalsIgnoreCase("update_candidate")){
			
		}else if(operation.equalsIgnoreCase("update_header_settings")){
			
		}else if(operation.equalsIgnoreCase("update_body_settings")){
			
		}
	
		
		
		

	}
	
		

}
