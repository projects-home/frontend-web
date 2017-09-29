<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="/jsp/common/common.jsp" %>
<html>
<head>
	<meta charset="UTF-8">
    <title>任务调度管理平台</title>
    <style type="text/css">
    	.control-sidebar-bg,
		.control-sidebar {
		  top: 0;
		  right: -450px;
		  width: 450px;
		  -webkit-transition: right 0.3s ease-in-out;
		  -o-transition: right 0.3s ease-in-out;
		  transition: right 0.3s ease-in-out;
		}
		.control-sidebar {
		  position: absolute;
		  padding-top: 50px;
		  z-index: 1010;
		}
		.divcss5{text-indent:25px}
    </style>
    <script type="text/javascript" src="${_base}/jsp/scheduler/list.js"></script>
 	<script src="${_base}/jsp/scheduler/monitor.js" type="text/javascript"></script>
 
	<script id="popoverInstancesTmpl" type="text/x-jsrender">
        <tr>
			<td>{{:instanceName}}</td>
            <td>{{:hostIp}}</td>
            <td>{{:userName}}</td>
        </tr>
    </script>
 
    <script id="schedulerJobsTmpl" type="text/x-jsrender">
            <tr>
				<td><input type="checkbox" name="ids" jobName="{{:taskName}}" jobGroup="{{:taskGroup}}" schedulerName="{{:schedulerName}}" ></td>
                <td>{{:taskName}}</td>
                <td>{{:taskGroup}}</td>
                <td>{{:cronExpression}}</td>
				{{if triggerState == 'ACQUIRED'}}
                	<td><span class="label label-info">{{:triggerState}}</span></td>
				{{else triggerState == 'WAITING'}}
                	<td><span class="label label-warning">{{:triggerState}}</span></td>
				{{else triggerState == 'PAUSED'}}
                	<td><span class="label label-danger">{{:triggerState}}</span></td>
				{{else triggerState == 'DELETED'}}
                	<td><span class="label label-danger">{{:triggerState}}</span></td>
				{{/if}}

                <td>{{:schedulerName}}</td>
                <td>
                    <a class="btn btn-success" href="javascript:void(0);" name="hrefSingleResumeTask" jobName="{{:taskName}}" jobGroup="{{:taskGroup}}" schedulerName="{{:schedulerName}}" {{if triggerState == 'WAITING'}} style="display:none" {{/if}} title="重启"><i class="fa fa-repeat"></i></a>
                    <a class="btn btn-info" href="javascript:void(0);" name="hrefSinglePauseTask" jobName="{{:taskName}}" jobGroup="{{:taskGroup}}" schedulerName="{{:schedulerName}}" {{if triggerState == 'PAUSED'}} style="display:none" {{/if}} title="暂停"><i class="fa fa-pause"></i></a>
                    <a class="btn btn-danger" href="javascript:void(0);" name="hrefSingleEditTask" jobName="{{:taskName}}" jobGroup="{{:taskGroup}}" schedulerName="{{:schedulerName}}" title="修改"><i class="fa fa-edit"></i></a>
                </td>
            </tr>
        </script>
    <script id="addJobsFormImpl" type="text/x-jsrender">
            <div class="row">
                <div class="col-md-12">
                    <form class="form-horizontal">
						<div class="form-group">
                            <label class="col-md-4 control-label" for="name">所属中心</label>
                            <div class="col-md-4">
								<select id="schedulerName" name="schedulerName" class="form-control" style="width:150px;display:inline">
                        			<option value="crm-center">crm-center</option>
                        			<option value="am-center">am-center</option>
                        			<option value="resources-center">resources-center</option>
                       			</select>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-md-4 control-label" for="name">任务名称</label>
                            <div class="col-md-4">
                                <input id="jobName" name="jobName" type="text" placeholder="任务名称" class="form-control input-md">
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-md-4 control-label" for="name">任务分组</label>
                            <div class="col-md-4">
                                <input id="jobGroup" name="jobGroup" type="text" placeholder="任务分组" class="form-control input-md">
                            </div>
                        </div>
                         <div class="form-group">
                            <label class="col-md-4 control-label" for="name">任务周期</label>
                            <div class="col-md-4">
                                <input id="cronExpress" name="cronExpress" type="text" placeholder="0/10 * * * * ?" class="form-control input-md">
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-md-4 control-label" for="name">任务实现类</label>
                            <div class="col-md-4">
                                <input id="implClass" name="implClass" type="text" placeholder="com.ai.xxx.xxx.XXX" class="form-control input-md">
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-md-4 control-label" for="name">任务环境变量</label>
                            <div class="col-md-4">
                                <input id="env" name="env" type="text" placeholder='{"key1":"value1","key2":"value2"}' class="form-control input-md">
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-md-4 control-label" for="name">是否异步执行</label>
                            <div class="col-md-4" style="margin-top:5px;">
                                 <div style="display:inline">
                                    <input type="radio" name="isConcurrent" value="1" checked>否
                                 </div>
                                <div style="display:inline">
                                    <input type="radio" name="isConcurrent" value="0" >是
                                 </div>
                            </div>
                        </div>
                    </form>
                </div>
            </div>

        </script>
    <script id="addMVNEJobsFormImpl" type="text/x-jsrender">
            <div class="row">
                <div class="col-md-12">
                    <form class="form-horizontal">
						<div class="form-group">
                            <label class="col-md-4 control-label" for="name">所属中心</label>
                            <div class="col-md-4">
								<select id="schedulerName" name="schedulerName" class="form-control" style="width:150px;display:inline">
                        			<option value="crm-center">营业中心</option>
                        			<option value="am-center">账管中心</option>
                        			<option value="resources-center">资源中心</option>
                       			</select>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-md-4 control-label" for="name">任务名称</label>
                            <div class="col-md-4">
                                <input id="jobName" name="jobName" type="text" placeholder="任务名称" class="form-control input-md">
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-md-4 control-label" for="name">任务分组</label>
                            <div class="col-md-4">
                                <input id="jobGroup" name="jobGroup" type="text" placeholder="任务分组" class="form-control input-md">
                            </div>
                        </div>
                         <div class="form-group">
                            <label class="col-md-4 control-label" for="name">任务周期</label>
                            <div class="col-md-4">
                                <input id="cronExpress" name="cronExpress" type="text" placeholder="0/10 * * * * ?" class="form-control input-md">
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-md-4 control-label" for="name">执行类</label>
                            <div class="col-md-4">
                                <input id="processClass" name="processClass" type="text" placeholder="com.ai.xxx.xxx.XXX" class="form-control input-md">
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-md-4 control-label" for="name">重试次数</label>
                            <div class="col-md-4">
                                <input id="retryTimes" name="retryTimes" type="text" placeholder="3" class="form-control input-md">
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-md-4 control-label" for="name">线程总数</label>
                            <div class="col-md-4">
                                <input id="threads" name="threads" type="text" placeholder="100" class="form-control input-md">
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-md-4 control-label" for="name">读取数量</label>
                            <div class="col-md-4">
                                <input id="recordNum" name="recordNum" type="text" placeholder="500" class="form-control input-md">
                            </div>
                        </div>
                    </form>
                </div>
            </div>


        </script>
        
    <script id="modJobsFormImpl" type="text/x-jsrender">
            <div class="row">
                <div class="col-md-12">
                    <form class="form-horizontal">
						<div class="form-group">
                            <label class="col-md-4 control-label" for="name">所属中心</label>
                            <div class="col-md-4">
								<select id="schedulerName" name="schedulerName" class="form-control" disabled="" style="width:150px;display:inline">
                        			<option value="crm-center" {{if schedulerName == 'crm-center'}} selected="selected" {{/if}}>营业中心</option>
                        			<option value="am-center"  {{if schedulerName == 'am-center'}} selected="selected" {{/if}}>账管中心</option>
                        			<option value="resources-center"  {{if schedulerName == 'resources-center'}} selected="selected" {{/if}}>资源中心</option>
                       			</select>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-md-4 control-label" for="name">任务名称</label>
                            <div class="col-md-4">
                                <input id="jobName" name="jobName" type="text" placeholder="任务名称" class="form-control input-md" disabled="" value="{{:jobName}}">
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-md-4 control-label" for="name">任务分组</label>
                            <div class="col-md-4">
                                <input id="jobGroup" name="jobGroup" type="text" placeholder="任务分组" class="form-control input-md" disabled="" value="{{:jobGroup}}">
                            </div>
                        </div>
                         <div class="form-group">
                            <label class="col-md-4 control-label" for="name">任务周期</label>
                            <div class="col-md-4">
                                <input id="cronExpress" name="cronExpress" type="text" placeholder="0/10 * * * * ?" class="form-control input-md" value="{{:cronExpress}}">
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-md-4 control-label" for="name">任务实现类</label>
                            <div class="col-md-4">
                                <input id="implClass" name="implClass" type="text" placeholder="com.ai.xxx.xxx.XXX" class="form-control input-md" value="{{:implClass}}">
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-md-4 control-label" for="name">任务环境变量</label>
                            <div class="col-md-4">
                                <input id="env" name="env" type="text" placeholder='{"key1":"value1","key2":"value2"}' class="form-control input-md" value='{{:envStr}}'>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-md-4 control-label" for="name">是否异步执行</label>
                            <div class="col-md-4" style="margin-top:5px;">
                                 <div style="display:inline">
                                    <input type="radio" name="isConcurrent" value="1"  {{if isConcurrent == '1'}} checked {{/if}}>否
                                 </div>
                                <div style="display:inline">
                                    <input type="radio" name="isConcurrent" value="0"  {{if isConcurrent == '0'}} checked {{/if}}>是
                                 </div>
                            </div>
                        </div>
                    </form>
                </div>
            </div>

    </script>
    <script id="modMVNEJobsFormImpl" type="text/x-jsrender">
            <div class="row">
                <div class="col-md-12">
                    <form class="form-horizontal">
						<div class="form-group">
                            <label class="col-md-4 control-label" for="name">所属中心</label>
                            <div class="col-md-4">
								<select id="schedulerName" name="schedulerName" class="form-control" disabled="" style="width:150px;display:inline">
                        			<option value="crm-center" {{if schedulerName == 'crm-center'}} selected="selected" {{/if}}>营业中心</option>
                        			<option value="am-center"  {{if schedulerName == 'am-center'}} selected="selected" {{/if}}>账管中心</option>
                        			<option value="resources-center"  {{if schedulerName == 'resources-center'}} selected="selected" {{/if}}>资源中心</option>
                       			</select>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-md-4 control-label" for="name">任务名称</label>
                            <div class="col-md-4">
                                <input id="jobName" name="jobName" type="text" placeholder="任务名称" class="form-control input-md" disabled="" value="{{:jobName}}">
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-md-4 control-label" for="name">任务分组</label>
                            <div class="col-md-4">
                                <input id="jobGroup" name="jobGroup" type="text" placeholder="任务分组" class="form-control input-md" disabled="" value="{{:jobGroup}}">
                            </div>
                        </div>
                         <div class="form-group">
                            <label class="col-md-4 control-label" for="name">任务周期</label>
                            <div class="col-md-4">
                                <input id="cronExpress" name="cronExpress" type="text" placeholder="0/10 * * * * ?" class="form-control input-md" value="{{:cronExpress}}">
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-md-4 control-label" for="name">执行类</label>
                            <div class="col-md-4">
                                <input id="processClass" name="processClass" type="text" placeholder="com.ai.xxx.xxx.XXX" class="form-control input-md" value="{{:processClass}}">
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-md-4 control-label" for="name">重试次数</label>
                            <div class="col-md-4">
                                <input id="retryTimes" name="retryTimes" type="text" placeholder="3" class="form-control input-md" value="{{:retryTimes}}">
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-md-4 control-label" for="name">线程总数</label>
                            <div class="col-md-4">
                                <input id="threads" name="threads" type="text" placeholder="100" class="form-control input-md" value="{{:threads}}">
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-md-4 control-label" for="name">读取数量</label>
                            <div class="col-md-4">
                                <input id="recordNum" name="recordNum" type="text" placeholder="500" class="form-control input-md" value="{{:recordNum}}">
                            </div>
                        </div>
                    </form>
                </div>
            </div>


        </script>
    <script id="editJobsFormImpl" type="text/x-jsrender">
            <div class="row">
                <div class="col-md-12">
                    <form class="form-horizontal">
                        <div class="form-group">
                            <label class="col-md-4 control-label" for="name">任务名称</label>
                            <div class="col-md-8">
                                <label class="col-md-8 control-label" for="name">{{:taskName}}</label>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-md-4 control-label" for="name">任务分组</label>
                            <div class="col-md-8">
                                 <label class="col-md-8 control-label" for="name">{{:taskGroup}}</label>
                            </div>
                        </div>
                         <div class="form-group">
                            <label class="col-md-4 control-label" for="name">任务周期</label>
                            <div class="col-md-8">
                                <input id="cronExpress" name="cronExpress" type="text" placeholder="0/10 * * * * ?"
                                    class="form-control input-md"  value="{{:cronExpression}}">
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-md-4 control-label" for="name">任务实现类</label>
                            <div class="col-md-8">
                               <label class="col-md-4 control-label" for="name">{{:taskClass}}</label>
                            </div>
                        </div>
                    </form>
                </div>
            </div>
        </script>
	<script id="helpImpl" type="text/x-jsrender">
		<div id="row">
		  <div class="divcss5" style="height:400px;overflow:scroll;overflow-x: hidden;">
			<h4>cron表达式概念</h4>
			<p>cron表达式中的星号（ * * * * * * *）由左到右按顺序代表 ： [秒] [分] [小时] [日] [月] [周] [年] ，具体含义见下表：</p>
			<table class="table table-bordered table-hover table-striped" style="font-size:12px;">
				<thead>
					<tr>
						<td>序号</td>			
						<td>说明</td>			
						<td>是否必填</td>			
						<td>允许填写的值</td>			
						<td>允许的通配符</td>			
					</tr>
				<thead>
				<tbody>
					<tr>
						<td>1</td>			
						<td>秒</td>			
						<td>是</td>			
						<td>0-59</td>			
						<td>, - * /</td>			
					</tr>
					<tr>
						<td>2</td>			
						<td>分</td>			
						<td>是</td>			
						<td>0-59</td>			
						<td>, - * /</td>			
					</tr>
					<tr>
						<td>3</td>			
						<td>小时</td>			
						<td>是</td>			
						<td>0-23</td>			
						<td>, - * /</td>			
					</tr>
					<tr>
						<td>4</td>			
						<td>日</td>			
						<td>是</td>			
						<td>1-31</td>			
						<td>, - * ? / L W </td>			
					</tr>
					<tr>
						<td>5</td>			
						<td>月</td>			
						<td>是</td>			
						<td>1-12 or JAN-DEC</td>			
						<td>, - * /</td>			
					</tr>
					<tr>
						<td>6</td>			
						<td>周</td>			
						<td>是</td>			
						<td>1-7 or SUN-SAT</td>			
						<td>, - * ? / L #</td>			
					</tr>
					<tr>
						<td>7</td>			
						<td>年</td>			
						<td>否</td>			
						<td>empty 或 1970-2099</td>			
						<td>, - * /</td>			
					</tr>
				</tbody>
			</table>

			<h4>通配符说明:</h4> 

			* 表示所有值. 例如:在分的字段上设置 "*",表示每一分钟都会触发。 <br>
			? 表示不指定值。使用的场景为不需要关心当前设置这个字段的值。例如:要在每月的10号触发一个操作，但不关心是周几，所以需要周位置的那个字段设置为"?" 具体设置为 0 0 0 10 * ? <br>
			- 表示区间。例如 在小时上设置 "10-12",表示 10,11,12点都会触发。 <br>
			, 表示指定多个值，例如在周字段上设置 "MON,WED,FRI" 表示周一，周三和周五触发 <br>
			/ 用于递增触发。如在秒上面设置"5/15" 表示从5秒开始，每增15秒触发(5,20,35,50)。在月字段上设置'1/3'所示每月1号开始，每隔三天触发一次。 <br>
			L 表示最后的意思。在日字段设置上，表示当月的最后一天(依据当前月份，如果是二月还会依据是否是润年[leap]), 在周字段上表示星期六，相当于"7"或"SAT"。如果在"L"前加上数字，则表示该数据的最后一个。例如在周字段上设置"6L"这样的格式,则表示“本月最后一个星期五" <br>
			W 表示离指定日期的最近那个工作日(周一至周五). 例如在日字段上设置"15W"，表示离每月15号最近的那个工作日触发。如果15号正好是周六，则找最近的周五(14号)触发, 如果15号是周未，则找最近的下周一(16号)触发.如果15号正好在工作日(周一至周五)，则就在该天触发。如果指定格式为 "1W",它则表示每月1号往后最近的工作日触发。如果1号正是周六，则将在3号下周一触发。(注，"W"前只能设置具体的数字,不允许区间"-").<br> 
			'L'和 'W'可以一组合使用。如果在日字段上设置"LW",则表示在本月的最后一个工作日触发(一般指发工资 ) <br>
			# 序号(表示每月的第几个周几)，例如在周字段上设置"6#3"表示在每月的第三个周六.注意如果指定"#5",正好第五周没有周六，则不会触发该配置(用在母亲节和父亲节再合适不过了) <br>
			周字段的设置，若使用英文字母是不区分大小写的 MON 与mon相同. <br>

			<h4>常用示例:</h4>
			0 0 12 * * ? 每天12点触发 <br>
			0 15 10 ? * * 每天10点15分触发 <br>
			0 15 10 * * ? 每天10点15分触发 <br>
			0 15 10 * * ? * 每天10点15分触发 <br>
			0 15 10 * * ? 2005 2005年每天10点15分触发 <br>
			0 * 14 * * ? 每天下午的 2点到2点59分每分触发 <br>
			0 0/5 14 * * ? 每天下午的 2点到2点59分(整点开始，每隔5分触发) <br>
			0 0/5 14,18 * * ? 每天下午的 2点到2点59分(整点开始，每隔5分触发) <br>
			每天下午的 18点到18点59分(整点开始，每隔5分触发) <br>
			0 0-5 14 * * ? 每天下午的 2点到2点05分每分触发 <br>
			0 10,44 14 ? 3 WED     3月分每周三下午的 2点10分和2点44分触发 （特殊情况，在一个时间设置里，执行两次或   <br>                                                          两次以上的情况） 
			0 59 2 ? * FRI    每周5凌晨2点59分触发； <br>
			0 15 10 ? * MON-FRI 从周一到周五每天上午的10点15分触发 <br>
			0 15 10 15 * ? 每月15号上午10点15分触发 <br>
			0 15 10 L * ? 每月最后一天的10点15分触发 <br>
			0 15 10 ? * 6L 每月最后一周的星期五的10点15分触发 <br>
			0 15 10 ? * 6L 2002-2005 从2002年到2005年每月最后一周的星期五的10点15分触发 <br>
			0 15 10 ? * 6#3 每月的第三周的星期五开始触发 <br>
			0 0 12 1/5 * ? 每月的第一个中午开始每隔5天触发一次 <br>
			0 11 11 11 11 ? 每年的11月11号 11点11分触发(光棍节)<br>

		   </div>
		</div>
		</script>
</head>
<body class="skin-blue">
	<div class="wrapper">
      <header class="main-header">
        <!-- Header Navbar: style can be found in header.less -->
         <!-- Header Navbar: style can be found in header.less -->
        <nav class="navbar navbar-static-top" role="navigation" style="margin-left:0px;">
          <!-- Sidebar toggle button-->
          <a href="${_base}/index.jsp" >
            <section class="content-header col-lg-6">	         
	          <h1 style="color:white; display:inline;">
	          	任务调度管理平台            
	          </h1>
	        </section>
          </a>
<!--           <div class="navbar-custom-menu"> -->
<!--             <ul class="nav navbar-nav"> -->
<!--               Control Sidebar Toggle Button -->
<!--               <li> -->
<!--                 <a href="#" data-toggle="control-sidebar"><i class="fa fa-gears">调度任务部署监控</i></a> -->
<!--               </li> -->
<!--             </ul> -->
<!--           </div> -->
        </nav>
      </header>
    
      <!-- Content Wrapper. Contains page content -->
      <div class="content-wrapper" style="margin-left:0px;">
        <!-- Main content -->
        <section class="content">
          <!-- Small boxes (Stat box) -->
<!--           <div class="row"> -->
<!--             <div class="col-lg-4 col-xs-6"> -->
<!--               small box -->
<!--               <div class="small-box bg-aqua"> -->
<!--                 <div class="inner"> -->
<!--                   <h3>crm-center</h3> -->
<!--                   <p id="p_crm-center" data-content="">共有0个节点实例，0个任务</p> -->
<!--                   <a href="#" id="example_bottom" class="btn btn-success" rel="popover" data-content="It's so simple to create a tooltop for my website!" data-original-title="Bootstrap Popover">hover for popover</a> -->
<!--                 </div> -->
<!--                 <div class="icon" style="margin-top:20px;"> -->
<!--                   <i class="ion ion-bag"></i> -->
<!--                 </div> -->
<!--                 <a id="hrefCrmCenter" href="#" class="small-box-footer">点击查看详情 <i class="fa fa-arrow-circle-right"></i></a> -->
<!--               </div> -->
<!--             </div>./col -->
<!--             <div class="col-lg-4 col-xs-6"> -->
<!--               small box -->
<!--               <div class="small-box bg-green"> -->
<!--                 <div class="inner"> -->
<!--                   <h3>am-center</h3> -->
<!--                   <p id="p_am-center"  data-content="">共有0个节点实例，0个任务</p> -->
<!--                 </div> -->
<!--                 <div class="icon" style="margin-top:20px;"> -->
<!--                   <i class="ion ion-stats-bars"></i> -->
<!--                 </div> -->
<!--                 <a id="hrefAccountCenter" href="#" class="small-box-footer">点击查看详情 <i class="fa fa-arrow-circle-right"></i></a> -->
<!--               </div> -->
<!--             </div>./col -->
<!--             <div class="col-lg-4 col-xs-6"> -->
<!--               small box -->
<!--               <div class="small-box bg-yellow"> -->
<!--                 <div class="inner"> -->
<!--                   <h3>resources-center</h3> -->
<!--                   <p id="p_resources-center"  data-content="">共有0个节点实例，0个任务</p> -->
<!--                 </div> -->
<!--                 <div class="icon" style="margin-top:20px;"> -->
<!--                   <i class="ion ion-person-add"></i> -->
<!--                 </div> -->
<!--                 <a id="hrefResCenter" href="#" class="small-box-footer">点击查看详情 <i class="fa fa-arrow-circle-right"></i></a> -->
<!--               </div> -->
<!--             </div>./col -->
           
<!--           </div>/.row -->
          <!-- Main row -->
          <div class="row">
			<div class="col-xs-12">
              <div class="box">
                <div class="box-header">
                  <div class="col-lg-12">
                  	   <h3 class="box-title">任务列表</h3>
                       <input id="cond_taskName" class="form-control" placeholder="任务名称" style="margin-left:10px;font-size:12px; width:120px;display:inline"> 
                  	   <select id="cond_schedulerName" class="form-control" style="font-size:12px;width:130px;display:none;">
                        <option value="">--请选择中心--</option>
                        <option value="crm-center">crm-center</option>
                        <option value="am-center">am-center</option>
                        <option value="resources-center">resources-center</option>
                       </select>
                       <select id="cond_triggerState" class="form-control" style="font-size:12px;width:120px;display:inline">
                        <option value="">--请选择状态--</option>
                        <option value="ACQUIRED">ACQUIRED</option>
                        <option value="WAITING">WAITING</option>
                        <option value="PAUSED">PAUSED</option>
                        <option value="DELETED">DELETED</option>
                       </select>
                       <button class="btn btn-info" id="btnListTasksByCondition" title="查询"><i class="fa fa-search"></i></button>
                       <button class="btn btn-success" id="btnHelp" title="帮助"><i class="fa fa-question-circle"></i></button>
                  	   <button class="btn btn-info" id="btnBatchPauseTask" title="批量暂停" style="float:right; margin-left:5px;"><i class="fa fa-pause"></i></button>
                  	   <button class="btn btn-danger" id="btnBatchResumeTask" title="批量重启" style="float:right; margin-left:5px;"><i class="fa fa-repeat"></i></button> 
<!--                   	   <button class="btn btn-primary" id="btnCreateMVENNewJob" title="添加MVNE任务" style="float:right; margin-left:5px;"><i class="fa fa-plus-square"></i></button>  -->
                       <button class="btn btn-success" id="btnCreateNewJob" title="添加任务" style="float:right; margin-left:5px;"><i class="fa fa-plus-circle"></i></button> 
                  </div>                  
                  
                </div><!-- /.box-header -->
                <div class="box-body">
                  <table id="example2" class="table table-bordered table-hover table-striped">
                    <thead>
                      <tr>
                      	<th style="width:5px;"><input type="checkbox" id="chkCheckAll"></th>
                        <th>任务名称</th>
                        <th>任务分组</th>
                        <th>执行周期</th>
                        <th>任务状态</th>
                        <th>所属中心</th>
                        <th>操作</th>
                      </tr>
                    </thead>
                    <tbody  id="schedulerJobs"></tbody>
                  </table>
                </div><!-- /.box-body -->
              </div><!-- /.box -->
              
            </div><!-- /.col -->
         
          </div><!-- /.row (main row) -->

        </section><!-- /.content -->
      </div><!-- /.content-wrapper -->
      <footer class="main-footer" style="margin-left:0px;">
        <div class="pull-right hidden-xs">
          <b>Version</b> 1.0
        </div>
        <strong>Copyright &copy; 2017-2017 <a href="#" target="_blank">CompanyName</a>.</strong> All rights reserved.
      </footer>
      
      <!-- Control Sidebar -->      
      <aside id="sidebar" class="control-sidebar control-sidebar-dark" >            
        <!-- Tab panes -->
        <div class="tab-content">
          <!-- Home tab content -->
          <div class="tab-pane active " id="control-sidebar-home-tab">
            <ul class='control-sidebar-menu'>
              <li>
                <div class="box box-default" style="margin-left:10px; width:96%;">
				    <div class="box-header with-border">
				        <div class="col-md-12" style="text-align:right;width:100%">
				                图例:
				            <i class="fa fa-circle-o text-aqua"></i> crm-center
				            <i class="fa fa-circle-o text-green"></i> am-center
				            <i class="fa fa-circle-o text-red"></i> resources-center
				        </div>
				    </div>
				
				    <div class="box-body">
				        <!-- solid sales graph -->
				        <div class="box box-solid bg-teal-gradient">
				            <div class="box-footer no-border">
				                <div class="row" id="pieChartDiv">
				                </div>
				                <script id="pieChartTmpl" type="text/x-jsrender">
                     				<div class="col-xs-12 text-center"
                        				 style="border-right: 1px solid #f4f4f4">
                        				<canvas id="pieChart_{{:hostName}}_{{:userName}}" height="150"></canvas>
                        				<div class="knob-label">主机信息:{{:hostIp}}@{{:userName}}</div>
                    				</div>
                				</script>
				            </div>
				        </div>
				    </div>
				</div>
              </li>
              
            </ul><!-- /.control-sidebar-menu -->

          </div><!-- /.tab-pane -->
        </div>
      </aside><!-- /.control-sidebar -->
      <!-- Add the sidebar's background. This div must be placed
           immediately after the control sidebar -->
      <div class='control-sidebar-bg'></div>
    </div><!-- ./wrapper -->

</body>
</html>
