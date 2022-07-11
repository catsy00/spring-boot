// 비동기
function a_async(url, param, callback){
	$.ajax({
		url:url, type:"POST", dataType:"json", data:param, cache:false, error:function(m){ 	console.log("error" + url + "/" + m); }, success:function(m){}
		}).done(callback).fail(function(jqXHR, textStatus, errorThrown) { console.log(m);  alert("데이터 호출 실패 : " + m);});
}
// 동기
function a_sync(url, param, callback){
	$.ajax({
		url:url, type:"POST", dataType:"json", data:param, cache:false, async:false, error:function(m){ 	console.log("error" + url + "/" + m); }, success:function(m){}
		}).done(callback).fail(function(jqXHR, textStatus, errorThrown) { console.log(m);  alert("데이터 호출 실패 : " + m);});
}
// 비동기 json : message convert
function a_async_json(url, param, callback){
	$.ajax({
		url:url, type:"POST", dataType:"json", data:param, cache:false, contentType:"application/json;charset=utf-8", error:function(m){ 	console.log("error" + url + "/" + m); }, success:function(m){}
		}).done(callback).fail(function(jqXHR, textStatus, errorThrown) { console.log(m);  alert("데이터 호출 실패 : " + m);});
}
// 비동기 file 
function a_async_file(url, param, callback){
	$.ajax({
		url:url, type:"POST", dataType:"json", data:param, cache:false, enctype:"multipart/form-data", contentType:false, processData:false, error:function(m){ 	console.log("error" + url + "/" + m); }, success:function(m){}
		}).done(callback).fail(function(jqXHR, textStatus, errorThrown) { console.log(m);  alert("데이터 호출 실패 : " + m);});
}