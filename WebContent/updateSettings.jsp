<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<link rel="stylesheet" href="bootstrap-4/css/bootstrap.css">
<link rel="stylesheet" href="bootstrap-4/css/bootstrap.min.css">
<script src="scripts/jquery.js"></script>
<script src="bootstrap-4/js/bootstrap.js"></script>
<script src="scripts/previewscript.js"></script>

<script src="bootstrap-4/js/bootstrap.min.js"></script>

</head>
<body>
		<div class="modal fade" id="updateSettings" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
  <div class="modal-dialog" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <h5 class="modal-title" id="exampleModalLabel">Update Setttings</h5>
        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
          <span aria-hidden="true">&times;</span>
        </button>
      </div>
      <div class="modal-body">
       
        <form class="form" action="./Base" method="POST" accept-charset="UTF-8">
       <input type="hidden" name="operation" id="operation" value="update_settings"/>
       
     <div class="form-group w-100">
     <label for="staff_name">Field Name</label>
     <input class="form-control" type="text" name="field_name" id="field_name" placeholder="" readonly/>
     </div>
    
     <div class="form-group w-100">
     <label for="staff_contact">Field value</label>
     <TextArea class="form-control"  name="field_value" id="field_value"></TextArea>
    
     </div>
     </form>
       <div id="newsfeed_update_response"></div>
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
        <button type="button" id="btn_update" class="btn btn-primary">Save changes</button>
      </div>
    </div>
  </div>
</div>
</body>
<script >
$(document).ready(function(){
	//alert("Done!!");
	
	$("#updateSettings").on('shown.bs.modal',function(e){
		
		var data =$(e.relatedTarget).data('ref');
		$("#field_name").val(data.field_name);
		$("#field_value").val(data.field_value);
		
		
	});
	$("#btn_update").click(function(){
		alert(" ");
	});
});
</script>
</html>