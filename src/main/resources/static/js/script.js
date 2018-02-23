$(document).ready(function() {
	$('#searchStudent').keypress(function(e) {
		if (e.which == 13) {
			e.preventDefault();
			var value = $(this).val();
			
			 $.get( "/sms/students/name/"+value, function( data ) {
				 $("#stdlist").html("");
				 $.each(data.content, function(i, item) {
					$("#stdlist").append("<input type='radio' name='student' value='"+ data.content[i].studentId+"'>" + data.content[i].studentName +"<br>");
				 });
				 
				 
				 $("input[name='student']").click(function(){
					$("#studentId").val($(this).val());
				 });
			});
			

		}
	});
});