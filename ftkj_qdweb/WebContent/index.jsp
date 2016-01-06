<%@ page language="java" pageEncoding="UTF-8"%>
<%@ include file="page/include/taglib.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>青岛方天科技</title>
<link href="${ctx}/resources/common/index.css" rel="stylesheet" type="text/css" />
<script language="javascript">
$(function(){
	
	$.ajax({
		url :'${ctx}/website/getInfoList',// 查询新闻
		data : {
			lminfo:'xwzx_snxx',
			limit:5,
			page:0,
			ispic:0
		},
		type : 'post',
		cache : false,
		dataType : 'json',
		success : function(data) {
			// 循环处理查询list
			$ul = $('<ul></ul>');
			$.each(data.data,function(i,info){
				console.log(info);
				$li = $('<li>'+info.guid+'&nbsp;&nbsp;&nbsp;&nbsp'+info.url+'&nbsp;&nbsp;&nbsp;&nbsp'+info.infoname+'</li>');
				$li.appendTo($ul);
			});
			$('#contentid').append($ul);
		},
		error : function() {
			alert('查询异常！');
		}
	});
	

});

</script>
</head> 
<body>
<div id="contentid" class="content">
</div>	
</body>
</html>
