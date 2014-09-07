$(document).ready(function() {
	/**
	 * user load
	 * 传普通参数
	 */
	$("#userLoad").bind("click",function(){
		var params = {
				id : $("#userId").val(),
			};
		$.ajax({
			   type: "POST",
			   url: "user/getUser",
			   data: params,
			   dataType: "json",
			   success: function(data){
			     alert( data.id+","+data.name);
			   }
		});
	})
	/**
	 * user save
	 * 传json
	 */
	$("#userSave").bind("click",function(){
		var params = {
				name: $("#userName").val()
			};
		$.ajax({
			   type: "POST",
			   url: "user/addUser",
			   contentType:'application/json;charset=UTF-8',
			   data: JSON.stringify(params), 
			   dataType: "json",
			   success: function(id){//返回id
			     alert(id);
			   }
		});
	});
;
	
});