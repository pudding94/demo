$(document).ready(function() {
	/**
	 * @calss:
	 * @method:public String handleUploadFile(CommonsMultipartFile file)
	 * @explain:upload a file
	 */
	$("#uploadFile").bind("click",function(){
		$.ajaxFileUpload({
            url:'upload/uploadFile',
            secureuri:false,
            async:true,
            fileElementId:"file",
            dataType: 'multipart/form-data',  
           // dataType: 'json',  
            success: function (data, status){
//				var obj = $.parseJSON(data);
				alert("data="+data+",status="+status);
            },
            error: function (data, status, e){
                alert(e);
            }
		})
	})
	
});