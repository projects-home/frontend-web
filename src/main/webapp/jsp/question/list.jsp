<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<%
    String _base = request.getContextPath();
			request.setAttribute("_base", _base);

			response.setHeader("Cache-Control", "no-cache");
			response.setDateHeader("Expires", 0);
			response.setHeader("Pragma", "No-cache");
%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script  type="text/javascript" >
	var _base = "${_base}";
</script>
<script type="text/javascript" src="${_base}/resources/bower_components/jquery/dist/jquery.min.js"></script>
<script type="text/javascript" src="${_base}/resources/js/jquery.cookie.js"></script>
<script type="text/javascript" src="${_base}/jsp/question/list.js"></script>
<style type="text/css">
body {
	font-size: 24px;
}
table {
	border: 0px solid #F00;
	width: 100%;
}
table td {
	 border: 0px solid #D00; 
	
}
p {
	margin-top: 5px;
	margin-bottom: 5px;
	margin-left: 10px;
	margin-right: 10px;
	margin-left: 10px;
}

.title_column{
	width: 40px;
	text-align : center; 
}
.bgc_tr_cho{
	background-color: #ff8383;
}
.bgc_tr_rig{
	background-color: #89fb89;
}

input#getRandomQuestion {
	width: 100%;
}
input#u_id {
	width: 100%;
	height: 20px;
}

img{
    max-width: 300px;
    max-height: 736px;
    height:auto;
    zoom:expression( function(e) {
if(e.width>e.height) {if (e.width>128) { e.height = e.height*(128 /e.width); e.width=128; }}
else {if (e.height>128) { e.width = e.width*(128 /e.height); e.height=128; }}
e.style.zoom = '1';     }(this));
         overflow:hidden; 
}
</style>
</head>
<body>
	<input type="button" id="getRandomQuestion" value="换一个">
	<table>
		<thead>
			<tr>
				<td colspan="2">
					<p id="questionName"></p>
				</td>
			</tr>
			<tr>
				<td colspan="2">
					<p ><img id="questionImage" alt="" src=""></p>
				</td>
			</tr>
			<tr style="height: 30px">
				<td class="title_column">答案:</td>
				<td>
					<p id="questionAnswer" style="display: none;"></p>
				</td>
			</tr>
		</thead>
		<tbody>
			<tr >
				<td class="title_column"><input type="radio" name="answer" value="A"></td>
				<td><p id="answerA" ></p></td>
			</tr>
			<tr>
				<td class="title_column"><input type="radio" name="answer" value="B"></td>
				<td><p id="answerB"></p></td>
			</tr>
			<tr>
				<td class="title_column"><input type="radio" name="answer" value="C"></td>
				<td><p id="answerC"></p></td>
			</tr>
			<tr>
				<td class="title_column"><input type="radio" name="answer" value="D"></td>
				<td><p id="answerD"></p></td>
			</tr>
		</tbody>

	</table>
	<table>
		<thead>
			<tr>
				<td colspan="2"></td>
			</tr>
		</thead>
		<tbody>
			<tr>
				<td class="title_column">T:</td>
				<td><p id="examTipsTopic"></p></td>
			</tr>
			<tr>
				<td class="title_column">K:</td>
				<td><p id="examTipsKey"></p></td>
			</tr>
			<tr>
				<td class="title_column">S:</td>
				<td><p id="examTipsSource"></p></td>
			</tr>
			<tr>
				<td colspan="2">
					<p ><img id="examTipsImage" alt="" src=""></p>
				</td>
			</tr>
		</tbody>

	</table>
</body>
<input type="text" id="u_i" />

</html>