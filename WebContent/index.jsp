<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
  <jsp:include page="updatenewsfeed.html"/>
  <jsp:include page="updateservices.html"/>
  <jsp:include page="updatecandidate.html"/>
  <jsp:include page="updateSettings.jsp"/>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="bootstrap-4/css/bootstrap.css">
<link rel="stylesheet" href="bootstrap-4/css/bootstrap.min.css">
<link rel="stylesheet" href="styles/global/jquery.colorwheel.css">
<link rel="stylesheet" href="styles/datatables.css">
<link rel="stylesheet" href="font-awesome/css/all.css">
<script src="scripts/jquery.js"></script>
<script src="scripts/popper.js"></script>
<script src="scripts/jquery.colorwheel.js"></script>
<script src="bootstrap-4/js/bootstrap.js"></script>
<script src="scripts/previewscript.js"></script>
<script src="scripts/datatables.js"></script>
<script src="scripts/datatables.min.js"></script>
<script src="bootstrap-4/js/bootstrap.min.js"></script>
<script src="scripts/chart.js"></script>
<META http-equiv="Content-Type" content="text/html;charset=UTF-8">

<style type="text/css">

</style>
</head>
<body>

<div class="header"></div>
<br>
<div class="container">
<ul class="nav nav-pills" role="tablist">
    <li class="nav-item">
      <a class="nav-link active" data-toggle="pill" href="#home">सुचना &nbsp;&nbsp;<i class="fas fa-volume-up"></i></a>
    </li>
    <li class="nav-item">
      <a class="nav-link" data-toggle="pill" href="#services">सेवा&nbsp;&nbsp;<i class="fas  fa-briefcase"></i></a>
    </li>
    
     <li class="nav-item">
      <a class="nav-link" data-toggle="pill" href="#elected_candidates">जन प्रतिनिधि&nbsp;&nbsp;<i class="fas fa-user-plus"></i></a>
    </li>
    
    
    <li class="nav-item">
      <a class="nav-link" data-toggle="pill" href="#staffs">कर्मचारी&nbsp;&nbsp;<i class="fas fa-user-tie"></i></a>
    </li>
    <li class="nav-item">
      <a class="nav-link" data-toggle="pill" href="#plans_and_budget">बजेट तथा योजना &nbsp;&nbsp;<i class="fas fa-coins"></i></a>
    </li>
    <li class="nav-item">
      <a class="nav-link" data-toggle="pill" href="#settings">Settings &nbsp;&nbsp;<i class="fas fa-cog"></i></a>
    </li>
    
  </ul>

  <!-- Tab panes -->
  <div class="tab-content">
    <div id="home" class="container tab-pane active"><br>
     <h3>सूचना</h3>
       <form class="form" id="notice_form" action="./Base" method="POST" accept-charset="UTF-8">
       <input type="hidden" name="operation" id="operation" value="new_newsfeed"/>
     <div class="form-group w-100">
     <label for="staff_name">सूचना शिर्षक</label>
     <input class="form-control" type="text" name="notice_title" id="notice_title" placeholder="Notice title"/>
     </div>
    
     <div class="form-group w-100">
     <label for="staff_contact">विवरण</label>
     <TextArea class="form-control"  name="notice_details" id="notice_details"></TextArea>
    
     </div>
      <div class="form-group">
     <input class="btn btn-primary" type="submit" name="submit_notice" id="submit_notice" value="सुरक्षित गर्नुहोस्"/>
     </div>
     </form>
     	<div>
     		<table id="notice_table" class="table">
     		<thead class="thead-dark">
     			<TH>सुचना शिर्षक</TH>
     			<TH>सुचना विवरण</TH>
     			<TH>Operation</TH>
     		</thead>
     		<tbody></tbody>
     	</table>
     	</div>
    
     
     
    </div>
    <div id="services" class="container tab-pane"><br>
      	 <h3>सेवाहरु</h3>
       <form class="form" action="./Base" method="POST">
       <input type="hidden" name="operation" id="operation" value="new_services" accept-charset="UTF-8"/>
     <div class="form-group w-75">
     <label for="staff_name">सेवा</label>
     <input class="form-control" type="text" name="service_name" id="notice_title" placeholder="Notice title"/>
     </div>
    
     <div class="form-group w-75">
     <label for="staff_contact">आवश्यक कागजात</label>
     <TextArea class="form-control"  name="required_documents" id="notice_details"></TextArea>
    
     </div>
     <div class="form-group w-75">
     <label for="staff_contact">प्रकिया</label>
     <TextArea class="form-control"  name="process" id="process"></TextArea>
    
     </div>
      <div class="form-group w-75">
     <label for="staff_name">सम्बन्धित कर्मचारी</label>
     <input class="form-control" type="text" name="res_employee" id="res_employee" placeholder="सम्बन्धप"/>
     </div>
      <div class="form-group w-75">
     <label for="amt">सेवा शुल्क</label>
     <input class="form-control" type="text" name="amount" id="amount" placeholder="सेवा शुल्क"/>
     </div>
     
     
     <div class="form-group">
     <input class="btn btn-primary" type="submit" name="submit_notice" id="submit_notice" value="सुरक्षित गर्नुहोस्"/>
     </div>
      </form>
     <div>
     	<table id="service_table" class="table">
     		<thead class="thead-dark">
     			<TH>सेवा</TH>
     			<TH>आवश्यक कागजात</TH>
     			<TH>प्रक्रिया</TH>
     			<TH>शुल्क</TH>
     			<TH>सम्बन्धित कर्मचारी</TH>
     			<TH>Operation</TH>
     		</thead>
     		<tbody></tbody>
     	</table>
     </div>
    
     
    </div>
    <div id="elected_candidates" class="container tab-pane fade"><br>
     <h3>जन प्रतिनिधि विवरण</h3>
     <form class="form" action="./Base" method="POST" enctype="multipart/form-data" accept-charset="UTF-8">
     <input type="hidden" name="operation" id="xx" value="new_candidate"/>
     <div class="form-group w-50">
     <label for="elected_candidate_name">जनप्रतिनिधिको नाम</label>
     <input class="form-control" type="text" name="elected_candidate_name" id="elected_candidate_name" placeholder="Candidate name here."/>
     </div>
     <div class="form-group w-50">
     <label for="elected_candidate_designation">पद</label>
     <input class="form-control" type="text" name="elected_candidate_designation" id="elected_candidate_designation" placeholder="Candidate designation here."/>
     
     </div>
     <div class="form-group w-50">
     <label for="elected_candidate_name">सम्पर्क</label>
     <input class="form-control" type="text" name="elected_candidate_contact" id="elected_candidate_contact" placeholder="Candidate Contact here."/>
    
     </div>
     <div class="form-group">
     					<label>जन प्रतिनिधिको फोटो</label>
     					<input type="file" name="elected_candidate_photo" accept="image/*"  onchange="previewFile(this, 'preview_elected')" />
						 <br/>
						<img id="preview_elected" style="width:100px; height:100px; margin-top:10px;"  src="" alt="-----------"/>
     					
     					</div>
     					 <div class="form-group w-25">
     <label for="staff_contact">weight(* In ascending order)</label>
     <input class="form-control" type="text" name="candidate_weight" id="candidate_weight" placeholder="Enter rank here."/>
    
     </div>
   
     <div class="form-group">
          <br>
     
     <input class="btn btn-primary" type="submit" name="submit_candidate" id="submit_candidate" value="सुरक्षित गर्नुहोस्"/>
     </div>
     </form>
     	<table class="table" id="candidate_table">
     		<thead class="thead-dark">
     			<th>नाम</th>
     			<th>पद</th>
     			<th>सम्पर्क</th>
     			<th>Image</th>
     			<th>Weight</th>
     			<th>Operation</th>
     		</thead>
     		<tbody>
     		</tbody>
     	</table>
     
    </div>
    <div id="staffs" class="container tab-pane fade"><br>
      <h3>कर्मचारी विवरण</h3>
     	 <form class="form" action="./Base" method="POST" enctype="multipart/form-data" accept-charset="UTF-8">
     	 <input type="hidden" name="operation" id="oprn" value="new_staff"/>
     <div class="form-group w-50">
     <label for="staff_name">कर्मचारीको नाम</label>
     <input class="form-control" type="text" name="staff_name" id="staff_name" placeholder="Staff name here."/>
     </div>
     <div class="form-group w-50">
     <label for="staff_designation">पद</label>
     <input class="form-control" type="text" name="staff_designation" id="staff_designation" placeholder="Candidate designation here."/>
     
     </div>
     <div class="form-group w-50">
     <label for="staff_contact">सम्पर्क</label>
     <input class="form-control" type="text" name="staff_contact" id="staff_contact" placeholder="Staff Contact here."/>
    
     </div>
     <div class="form-group">
     					<label>फोटो</label>
     					<input type="file" name="staff_image" accept="image/*"  onchange="previewFile(this, 'preview_staff')" />
						 <br/>
						<img id="preview_staff" style="width:100px; height:100px; margin-top:10px;"  src="" alt="-----------"/>
     					
     					</div>
     <div class="form-group">
     <div class="form-group w-25">
     <label for="staff_contact">weight(* In ascending order)</label>
     <input class="form-control" type="text" name="staff_weight" id="staff_weight" placeholder="Enter rank here."/>
    
     </div>
     <br>
     <input class="btn btn-primary" type="submit" name="submit_staff" id="submit_staff" value="सुरक्षित गर्नुहोस्"/>
     </div>
     </form>
     			<table class="table" id="staff_table">
     		<thead class="thead-dark">
     			<th>नाम</th>
     			<th>पद</th>
     			<th>सम्पर्क</th>
     			<th>Image</th>
     			<th>Weight</th>
     			<th>Operation</th>
     		</thead>
     		<tbody>
     		</tbody>
     	</table>
    </div>
    <div id="plans_and_budget" class="container tab-pane fade"><br>
      <h3>बजेट विवरण</h3>
      	<form class="form" action="./Base" method="POST" enctype="multipart/form-data">
      	     	       <input type="hidden" name="operation" id="operation" value="new_budgets_plans" accept-charset="UTF-8"/>

      		<div class="form-group">
      		<label>फाइल छान्नुहोस्</label>
      		<input type="file" name="file" accept="image/*"  onchange="previewFile(this, 'preview_file')" />
						 <br/>
						<img id="preview_file" style="width:100px; height:100px; margin-top:10px;"  src="" alt="-----------"/>
      		</div>
      		<div class="form-group">
      		<label>विवरण</label>
      		<input type="text" name="file_desc" id="file_desc" class=" form-control w-75"/>
      		</div>
      		<div class="form-group">
      			<input class="btn btn-primary" type="submit" name="submit_file"/>
      		</div>
      	
      	</form>
      	<table class="table" id="budget_table">
     		<thead class="thead-dark">
     			<th>File</th>
     			<th>Description</th>
     			<th>Operation</th>
     			
     		</thead>
     		<tbody>
     		</tbody>
     	</table>
      
    </div>
    
     <div id="settings" class="container tab-pane fade"><br>
      <h3>Settings</h3>
     	
     	 <div id="accordion">

  <div class="card w-75 ">
    <div class="card-header bg-dark text-white">
      <a class="card-link" data-toggle="collapse" href="#collapseOne" style="color: white;">
        Board Header Settings
      </a>
    </div>
    <div id="collapseOne" class="collapse" data-parent="#accordion">
      <div class="card-body">
        <form class="form" action="./Base" method="POST" enctype="multipart/form-data" accept-charset="UTF-8">
     			
     					<div class="form-group">
     						<label>Noticeboard Header</label>
     						<input class="form-control" type="text" name="board_header" id="board_header"/>
     					</div>
     					<div class="form-group">
     						<label>Office Address :</label>
     						<input class="form-control" type="text" name="office_address" id="office_address"/>
     					</div>
     					<div class="form-group">
     					<label>Choose Logo1</label>
     					<input type="file" name="logo_1" accept="image/*"  onchange="previewFile(this, 'preview_logo1')" />
						 <br/>
						<img id="preview_logo1" style="width:100px; height:100px; margin-top:10px;"  src="" alt="-----------"/>
     					
     					</div>
     					<div class="form-group">
     					<label>Choose Logo2</label>
     					<input type="file" name="logo_2" accept="image/*"  onchange="previewFile(this, 'preview_logo2')" />
						 <br/>
						<img id="preview_logo2" style="width:100px; height:100px; margin-top:10px;"  src="" alt="-------------"/>
     					
     					</div>
     					<div class="form-group">
     						<label >Header Text size:</label>
     						<select class="form-control w-50">
     						<option value="10sp"> 10sp</option>
     						<option value="15sp"> 15sp</option>
     						<option value="20sp"> 20sp</option>
     						<option value="25sp"> 25sp</option>
     						<option value="30sp"> 30sp</option>
     						</select>
     						
     					</div>
     					<div class="form-group">
     						<label>Header background color: </label>
     						<div id="header_bg" style="width:100px;height:100px;"></div>
     					</div>
     					<div class="form-group">
     					<label> Header Text Color:</label> 
     						<div id="header_text_color" style="width:100px;height:100px;"></div>
     					</div>
     					<input class="btn btn-primary" type="submit" value="Apply Changes." />
     			</form>
      </div>
    </div>
  </div>

  <div class="card w-75">
    <div class="card-header bg-primary text-white">
      <a class="collapsed card-link" data-toggle="collapse" href="#collapseTwo" style="color: white;">
        Board Body Settings
      </a>
    </div>
    <div id="collapseTwo" class="collapse" data-parent="#accordion">
      <div class="card-body">
       	<form action="./Base" method="post" enctype="multipart/form-data">
       			<div class="form-group">
     						<label>Main content placement (Main content - panel)</label>
     						<select class="form-control" name="content_width" id="content_width">
     						
     						<option value="0.5-0.5">50%-50%</option>
     						<option value="0.6-0.4">60%-40%</option>
     						<option value="0.7-0.3">70%-30%</option>
     						<option value="0.8-0.2">80%-20%</option>
     						<option value="0.85-0.15">85%-15%</option>
     						<option value="0.9-0.1" selected>90%-10%</option>
     						<option value="0.95-0.05">95%-5%</option>
     						
     						
     						
     						</select>
     					</div>
     					<div class="form-group">
     						<label>Table header size</label>
     						<select class="form-control" name="table_header_fontSize" id="table_header_fontSize">
     							<option value="5">5</option>
     							<option value="10">10</option>
     							<option value="15">15</option>
     							<option value="20">20</option>
     							<option value="25">25</option>
 
     						
     						</select>
     					</div>
     					<div class="form-group">
     						<label> Table Header background color: </label>
     						<div id="table_header_bg" style="width:100px;height:100px;"></div>
     					</div>
     					<div class="form-group">
     						<label> Table Header Text Color: </label>
     						<div id="table_header_textColor" style="width:100px;height:100px;"></div>
     					</div>
     					<div class="form-group">
     						<label>Table content color: </label>
     						<div id="table_content_color" style="width:100px;height:100px;"></div>
     					</div>
     					<div class="form-group">
     						<label>Table content size</label>
     						<select class="form-control"  name="table_content_fontSize" id="panel_width">
     							<option value="5">5</option>
     							<option value="10">10</option>
     							<option value="15">15</option>
     							<option value="20">20</option>
     							<option value="25">25</option>
     						</select>
     					</div>
     					
     					<div class="form-group">
     						<input class="btn btn-primary" type="submit" id="submit_body_settings" name="submit_body_settings" value="apply Changes"/>
     					</div>
     					
       	</form>
      </div>
    </div>
  </div>
  
  
  <div class="card w-75">
    <div class="card-header">
      <a class="collapsed card-link" data-toggle="collapse" href="#collapseThree">
        Account Settings
      </a>
    </div>
    <div id="collapseThree" class="collapse" data-parent="#accordion">
      <div class="card-body">
        Lorem ipsum..
      </div>
    </div>
  </div>
  		<br>
			<table class="table" id="settings_table">
     		<thead class="thead-dark">
     			<th>Field Name</th>
     			<th>Value</th>
     			<th>Operation</th>
     			
     		</thead>
     		<tbody>
     		</tbody>
     	</table>
     	<div id="test"></div>
</div> 
    </div>
    
  </div>
</div>

</body>
<script>
$(document).ready(function(){
	$.ajax({
		  url: "/AppBase/Base",
		  type: "get", //send it through get method
		  dataType: 'json',
		  contentType: "application/json",
		  data: { 
			  'required':'services',
			  'device_type':'tv'
		  },
		  success: function(response) {
		    //Do Something
		    var body = $("#service_table").find("tbody");
		    var row = "";
		    for(var i = 0 ; i < response.length; i++){
		    	 row ="<tr>"+
		    	 "<td>"+response[i].service_title+"</td>"+
		    	 "<td>"+response[i].required_document+"</td>"+
		    	 "<td>"+response[i].process+"</td>"+
		    	 "<td>"+response[i].fee+"</td>"+
		    	 "<td>"+response[i].res_employee+"</td>"+
		    	 "<td>"+"<a id='edit_services' class=' fa fa-edit' href='#' data-toggle='modal' data-target='#updateServices' data-ref='"+JSON.stringify(response[i])+"'></a>"+"</td>"
		    	 +"</tr>" 
		    	 body.append(row);
		    }
		    
		    
		  },
		  error: function(xhr) {
		    //Do Something to handle error
		    console.log(xhr);
		  }
		});
	$.ajax({
		  url: "/AppBase/Base",
		  type: "get", //send it through get method
		  dataType: 'json',
		  contentType: "application/json",
		  data: { 
			  'required':'newsfeed',
			  'device_type':'tv'
		  },
		  success: function(response) {
		    //Do Something
		    var body = $("#notice_table").find("tbody");
		    var row = "";
		    for(var i = 0 ; i < response.length; i++){
		    	 row ="<tr>"+
		    	 "<td>"+response[i].notice_title+"</td>"+
		    	 "<td>"+response[i].notice_body+"</td>"+
		    	 "<td>"+"<a id='edit_newsfeed' class=' fa fa-edit' href='#' data-toggle='modal' data-target='#updateNewsFeed' data-ref='"+JSON.stringify(response[i])+"'></a>"+"&nbsp;&nbsp;&nbsp;<a class=' fa  fa-trash ' href='#'></a>"+"</td>"
		    	 +"</tr>" 
		    	 body.append(row);
		    }
		    
		    
		  },
		  error: function(xhr) {
		    //Do Something to handle error
		    console.log(xhr);
		  }
		});
	
	$.ajax({
		  url: "/AppBase/Base",
		  type: "get", //send it through get method
		  dataType: 'json',
		  contentType: "application/json",
		  data: { 
			  'required':'elected_candidates',
			  'device_type':'tv'
		  },
		  success: function(response) {
		    //Do Something
		   // console.log(response)
		    var body = $("#candidate_table").find("tbody");
		    var row = "";
		    for(var i = 0 ; i < response.length; i++){
		    	 row ="<tr>"+
		    	 "<td>"+response[i].candidate_name+"</td>"+
		    	 "<td>"+response[i].candidate_post+"</td>"+
		    	 "<td>"+response[i].candidate_contact+"</td>"+
		    	 "<td>"+response[i].candidate_image+"</td>"+
		    	 "<td>"+response[i].candidate_weight+"</td>"+
		    	 "<td>"+"<a id='edit_candidate' class=' fa fa-edit' href='#' data-toggle='modal' data-target='#updateCandidate' data-ref='"+JSON.stringify(response[i])+"'></a>"+"&nbsp;&nbsp;&nbsp;<a class=' fa  fa-trash ' href='#'></a>"+"</td>"
		    	 +"</tr>" 
		    	 body.append(row);
		    }
		    
		    
		  },
		  error: function(xhr) {
		    //Do Something to handle error
		    console.log(xhr);
		  }
		});
		
	$.ajax({
		  url: "/AppBase/Base",
		  type: "get", //send it through get method
		  dataType: 'json',
		  contentType: "application/json",
		  data: { 
			 
			  'device_type':'tv',
			  'required':'settings'
		  },
		  success: function(response) {
		    //Do Something
		//   console.log(response);
		   // var body = $("#settings_table").find("tbody");
		    var i = 0;
		    $.each(response, function(index,value){
		    	
		    	$("#settings_table > tbody").append(
		    			"<tr>"+
	    				  "<td>"+response[index].field_name+"</td>"+
	    				  "<td>"+response[index].field_value+"</td>"+
	    				  "<td> <a class='fa fa-edit' id='edit_settings' href='#' data-toggle='modal' data-ref='"+JSON.stringify(value)+"' data-target='#updateSettings'></a>"+"&nbsp;&nbsp;&nbsp;<a class=' fa  fa-trash ' href='#'></a>"+"</td>"+

	    				  "</tr>");
		    	
		    });

		    
		    
		  },
		  error: function(xhr) {
		    //Do Something to handle error
		    console.log(xhr);
		  }
		});
	$("#header_text_color").colorwheel();
	$("#header_bg").colorwheel();
	$("#table_header_bg").colorwheel();
	$("#table_header_textColor").colorwheel();
	$("#table_content_color").colorwheel();
	$("#header_text_color").colorwheel('init',
			  ['000000', 
			   '111111', 
			   '222222', 
			   '333333', 
			   '444444', 
			   '555555', 
			   '666666', 
			   '777777', 
			   '888888', 
			   '999999', 
			   'aaaaaa', 
			   'bbbbbb', 
			   'cccccc', 
			   'dddddd', 
			   'eeeeee', 
			   'ffffff']
			);
});
$("#notice_form")
</script>
</html>