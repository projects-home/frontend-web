<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="/jsp/common/common.jsp" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>调度任务部署监控</title>
    <script src="${_base}/jsp/scheduler/monitor.js" type="text/javascript"></script>
    <script type="text/javascript">
        $(document).ready(function () {
            ajaxController.ajax({
                method: "POST",
                url: _base + "/quartz/manage/hostInstancesInfo",
                dataType: "json",
                success: function (data) {
                    var template = $.templates("#pieChartTmpl");
                    var htmlOutput = template.render(data.data);
                    $("#pieChartDiv").html(htmlOutput);

                    $.each(data.data, function (index, value) {
                        var items = value.schedulerInstances;
                        var id = "#pieChart_" + value.hostName + "_" + value.userName;
                        var caBuilder1 = new $.PieChartCanvasBuilder(id, items);
                        caBuilder1.build();
                    });

                }
            });
        })
    </script>
<head>
<body class="skin-blue">
 <header class="main-header">
        <!-- Header Navbar: style can be found in header.less -->
        <nav class="navbar navbar-static-top" role="navigation" style="margin-left:0px;">
	        <section class="content-header col-lg-6">	         
	          <h1 style="color:white; display:inline;">
	          	MVNE调度任务部署监控            
	          </h1>
	        </section>    
           
        </nav>
</header>
    
<div class="box box-default">
    <div class="box-header with-border">
        <div class="col-md-3" style="text-align:right;width:100%">
            图例:
            <i class="fa fa-circle-o text-aqua"></i> crm-center
            <i class="fa fa-circle-o text-green"></i> am-center
            <i class="fa fa-circle-o text-red"></i> resources-center
            <!-- <i class="fa fa-circle-o text-yellow"></i> commons-center -->
        </div>
    </div>

    <div class="box-body">
        <!-- solid sales graph -->
        <div class="box box-solid bg-teal-gradient">
            <div class="box-footer no-border">
                <div class="row" id="pieChartDiv">
                </div>
                <script id="pieChartTmpl" type="text/x-jsrender">
                     <div class="col-xs-4 text-center"
                         style="border-right: 1px solid #f4f4f4">
                        <canvas id="pieChart_{{:hostName}}_{{:userName}}" height="150"></canvas>
                        <div class="knob-label">主机信息:{{:hostIp}}@{{:userName}}</div>
                    </div>
                </script>
            </div>
        </div>
    </div>
</div>
</body>
</html>

