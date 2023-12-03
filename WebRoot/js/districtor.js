jQuery.fn.extend({
  area: function(childId) {
	this.change(function(){
		var parent=$(this).find("option:selected");
		var parentValue=parent.val();
		if(parentValue!=''){
			$("#"+childId).empty();
			$.ajax({
				   type: "get",
				   url: "/commondistrictor.do",
				   data: "pid="+parentValue ,
				   dataType: "json",
				   error:function(event) {
						alert("¥ÌŒÛ" );
		 		   },
				   success: function(data) {
		 			  $("#"+childId).append("<option value='0'>«Î—°‘Ò</option>");
		 			  for(var key in data){
		 				 $("#"+childId).append("<option value='"+key+"'>"+data[key]+"</option>");
		 	          }
				   }
				});
		}
	});
  }
});