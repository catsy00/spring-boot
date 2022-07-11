$(window).load(function(){
   var date = new Date();
   
   
  if(date.getDate()<10){
			if((date.getMonth()+1)<10){
				$("#stYmd").val(date.getFullYear()+"-0"+(date.getMonth()+1)+"-0"+date.getDate()+" "+date.getHours()+":"+date.getMinutes()+":"+date.getSeconds());
				$("#endYmd").val(date.getFullYear()+"-0"+(date.getMonth()+1)+"-0"+date.getDate()+" "+date.getHours()+":"+date.getMinutes()+":"+date.getSeconds());
			}else{
				$("#stYmd").val(date.getFullYear()+"-"+(date.getMonth()+1)+"-0"+date.getDate()+" "+date.getHours()+":"+date.getMinutes()+":"+date.getSeconds());
				$("#endYmd").val(date.getFullYear()+"-"+(date.getMonth()+1)+"-0"+date.getDate()+" "+date.getHours()+":"+date.getMinutes()+":"+date.getSeconds());
			}
		}else{
			if((date.getMonth()+1)<10){
				$("#stYmd").val(date.getFullYear()+"-0"+(date.getMonth()+1)+"-"+date.getDate()+" "+date.getHours()+":"+date.getMinutes()+":"+date.getSeconds());
				$("#endYmd").val(date.getFullYear()+"-0"+(date.getMonth()+1)+"-"+date.getDate()+" "+date.getHours()+":"+date.getMinutes()+":"+date.getSeconds());
			}else{
				$("#stYmd").val(date.getFullYear()+"-"+(date.getMonth()+1)+"-"+date.getDate()+" "+date.getHours()+":"+date.getMinutes()+":"+date.getSeconds());
				$("#endYmd").val(date.getFullYear()+"-"+(date.getMonth()+1)+"-"+date.getDate()+" "+date.getHours()+":"+date.getMinutes()+":"+date.getSeconds());
			}
		}	
})
