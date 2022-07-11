// calendar
$.datetimepicker.setLocale('ko');

function dateDefaults(opts) { 
return $.extend({},{ 
	format: 'Y-m-d H:i', ignoreReadonly:true
	, allowTimes:['00:00', '01:00', '02:00', '03:00', '04:00', '05:00', '06:00', '07:00', '08:00', '09:00', '10:00', '11:00',
			'12:00', '13:00', '14:00', '15:00', '16:00', '17:00', '18:00', '19:00', '20:00', '21:00', '22:00', '23:00']
	}, opts);
}

//, allowTimes:['00:00', '00:30', '01:00', '01:30', '02:00', '02:30', '03:00', '03:30', '04:00', '04:30', '05:00', '05:30','06:00', '06:30', '07:00', '07:30', '08:00', '08:30', '09:00', '09:30', '10:00', '10:30', '11:00', '11:30',
//			'12:00', '12:30', '13:00', '13:30', '14:00', '14:30', '15:00', '15:30', '16:00', '16:30', '17:00', '17:30','18:00', '18:30', '19:00', '19:30', '20:00', '20:30', '21:00', '21:30', '22:00', '22:30', '23:00', '23:30']

// cookie
var setCookie = function(name, value, exp) {
	var date = new Date();
	date.setTime(date.getTime() + exp*30*60*1000);			// 30분
	document.cookie = name + '=' + value + ';expires=' + date.toUTCString() + ';path=/;';
};

var getCookie = function(name) {
	var value = document.cookie.match('(^|;) ?' + name + '=([^;]*)(;|$)');
	return value? value[2] : null;
};

var deleteCookie = function(name) {
	document.cookie = name + '=; expires=Thu, 01 Jan 1999 00:00:10 GMT;path=/;';
}

var getCookieDate = function(name) {
	var value = document.cookie.match('(^|;) ?' + name + '=([^;]*)(;|$)');
	return value ? new Date(value[2].substring(0,4), value[2].substring(4,6), value[2].substring(6,8), value[2].substring(8,10), value[2].substring(10,12)) : null;
};