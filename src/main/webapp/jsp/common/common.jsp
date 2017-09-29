<%--
  Created by IntelliJ IDEA.
  Date: 2015/5/28
  Time: 14:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
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

<link href="${_base }/resources/bower_components/bootstrap/dist/css/bootstrap.css" rel="stylesheet"/>
<link href="${_base}/resources/bower_components/bootstrap/dist/css/AdminLTE.min.css" rel="stylesheet" type="text/css" />
<link href="${_base}/resources/bower_components/bootstrap/dist/css/skins/_all-skins.min.css" rel="stylesheet" type="text/css" />
<script src="${_base}/resources/bower_components/jquery/dist/jquery.min.js" ></script>
<script src="${_base}/resources/bower_components/bootstrap/dist/js/bootstrap.min.js"></script>
<script src="${_base}/resources/bower_components/jsviews/jsrender.min.js"></script>
<script src="${_base}/resources/bower_components/jsviews/jsviews.min.js"></script>
<script src="${_base}/resources/bower_components/bootbox/bootbox.js"></script>
<script src="${_base}/resources/bower_components/chartjs/Chart.min.js"></script>

<script src="${_base}/resources/js/jquery.form.min.js"></script>
<script src="${_base}/resources/js/jquery.pagcontroller.js"></script>
<link href="${_base}/resources/js/css/jquery.pagcontroller.css" rel="stylesheet"/>

<script src="${_base}/resources/bower_components/bootstrap/twitter-bootstrap/bootstrap-tooltip.js"></script>
<script src="${_base}/resources/bower_components/bootstrap/twitter-bootstrap/bootstrap-popover.js"></script>

<!-- 侧边栏对应的js -->
<script src="${_base}/resources/bower_components/bootstrap/adminlte/app.min.js"></script>
<script src="${_base}/resources/bower_components/bootstrap/adminlte/demo.js"></script>

<!-- FontAwesome 4.3.0 -->
<link href="${_base}/resources/bower_components/bootstrap/dist/css/font-awesome.min.css" rel="stylesheet" type="text/css" />
<!-- Ionicons 2.0.0 -->
<link href="${_base}/resources/bower_components/bootstrap/dist/css/ionicons.min.css" rel="stylesheet" type="text/css" />    

<script>
    var _base = "${_base}";
</script>
