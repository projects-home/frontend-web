//页面控制类
var quartzPageController = null;
//自动刷新主页面磁贴定时器,需停止自动刷新时，调用clearInterval(autoRefreshMainPageHandler)即可 
var autoRefreshMainPageHandler;
//自动刷新任务调度监控定时器ID,需停止自动刷新时，调用clearInterval(autoRefreshHostInstanceHandler)即可 
var autoRefreshHostInstanceHandler;
//页面加载初始化
$(document).ready(function () {
	//1.页面事件初始化及绑定
	quartzPageController =  new $.QuartzPageController();
	quartzPageController.init(); 
	
	//2.页面磁贴初始化,每隔5000ms，自动刷新
	loadSchedulerInstanceStat();
	
	//3.边栏初始化,每隔5000ms，自动刷新
	loadHostInstanceInfo();
});
function loadSchedulerInstanceStat(){
	   var _this = this;
		ajaxController.ajax({
	       method: "POST",
	       url: _base+"/quartz/manage/schedulerStat?rnd="+Math.random(),
	       dataType: "json",
	       success: function (data) {
	       	$.each(data.data,function(i,obj){
	       		//各中心(scheduler)在页面上对应的<p>标签的id
	       		var pId="#p_"+obj.schedulerName;
	       		var pText="共有"+obj.instanceCount+"个节点实例，"+obj.jobCount+"个任务";
	       		$(pId).html(pText);
	       		//更新悬浮窗的内容
	       		$(pId).attr("data-content",popoverContent(obj.zkSchedInsList));
	       		
	       		//添加悬浮窗效果
	       		$(pId).popover({
		       			placement:obj.schedulerPopoverPlacement,
		       			html : true,
		       	        trigger : 'hover',
		       	        title : obj.schedulerPopoverTitle
		       		});
	       		
	       	});
	       	
	       		autoRefreshMainPageHandler=setTimeout(loadSchedulerInstanceStat,5000);
	       },
	       //业务处理错误
	       failure: function(data){
	       	//停止自动刷新
	       	autoRefreshMainPageHandler && clearTimeout(autoRefreshMainPageHandler);
	       },
	       //网络错误
	       error: function(data){
	       	//停止自动刷新
	       	autoRefreshMainPageHandler && clearTimeout(autoRefreshMainPageHandler);
	       }
	   });// end of ajax
		
}// end of function loadSchedulerInstanceStat

function loadHostInstanceInfo(){
	 var _this = this;
  	 ajaxController.ajax({
           method: "POST",
           url: _base + "/quartz/manage/hostInstancesInfo?rnd="+Math.random(),
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
               
               autoRefreshHostInstanceHandler=setTimeout(loadHostInstanceInfo,5000);

           },
           //业务处理错误
           failure: function(data){
           	//停止自动刷新
           	autoRefreshHostInstanceHandler && clearTimeout(autoRefreshHostInstanceHandler);
           },
           //网络错误
           error: function(data){
           	//停止自动刷新
           	autoRefreshHostInstanceHandler && clearTimeout(autoRefreshHostInstanceHandler);
           }
       });// end of ajax
}// end of function loadHostInstanceInfo


//构造悬浮窗内容
function popoverContent(vData){
       	var htmlbody='<table class="table table-bordered table-hover table-striped" style="font-size:12px;">';
       	htmlbody+='<thead>																																';
       	htmlbody+='  <tr>                                                                 ';
       	htmlbody+='    <th>节点实例</th>                                                  ';
       	htmlbody+='    <th>机器IP</th>                                                  ';
       	htmlbody+='    <th>用户</th>                                                  ';
       	htmlbody+='  </tr>                                                                ';
       	htmlbody+='</thead>                                                               ';
       	htmlbody+='<tbody>																																';
       	var template = $.templates("#popoverInstancesTmpl");
        var htmlOutput = template.render(vData);
        htmlbody+=htmlOutput;
       	htmlbody+='</tbody>                                                               ';
       	htmlbody+='</table>';
           return htmlbody;
}

(function($){
	$.QuartzPageController=function(){
		this.settings=$.extend(true,{},$.QuartzPageController.defaults);		
	}
	
	$.extend($.QuartzPageController,{
		//常量定义
		defaults:{
			//营业中心
			CRM_CENTER:"crm-center",
			//账管中心
			ACCOUNT_CENTER:"am-center",
			//资源中心
			RES_CENTER:"resources-center",
			//查询任务列表
			LIST_TASK_BY_CONDITION:"#btnListTasksByCondition",
			//帮助
			BTN_HELP:"#btnHelp",
			//营业中心磁贴点击详情
			CRM_CENTER_LIST_QUERY:"#hrefCrmCenter",
			//账管中心磁贴点击详情
			ACCOUNT_CENTER_LIST_QUERY:"#hrefAccountCenter",
			//资源中心磁贴点击详情
			RES_CENTER_LIST_QUERY:"#hrefResCenter",
			//添加任务
			ADD_TASK:"#btnCreateNewJob",
			//添加MVNE任务
			ADD_MVEN_TASK:"#btnCreateMVENNewJob",
			//批量重启任务
			BATCH_RESUME_TASK:"#btnBatchResumeTask",
			//批量暂停任务
			BATCH_PAUSE_TASK:"#btnBatchPauseTask",
			//全选/取消
			CHECK_CANCEL_TASK:"#chkCheckAll",
			
			//单个重启任务
			SINGLE_RESUME_TASK:"[name='hrefSingleResumeTask']",
			//单个暂停任务
			SINGLE_PAUSE_TASK:"[name='hrefSinglePauseTask']",
			//单个修改任务
			SINGLE_EDIT_TASK:"[name='hrefSingleEditTask']"
			
		},
		prototype:{
			init: function(){
				var _this = this;
				_this.bindEvents();
			},
			/*初始化事件绑定*/
			bindEvents: function(){
				var _this = this;
				//帮助
				$(_this.settings.BTN_HELP).bind("click",function(){
					_this.help();
				});
				//查询任务
				$(_this.settings.LIST_TASK_BY_CONDITION).bind("click",function(){
					_this.listTasksByCondition();
				});
				//营业中心磁贴点击详情
				$(_this.settings.CRM_CENTER_LIST_QUERY).bind("click",function(){
					_this.getJobsBySchedulerName(_this.settings.CRM_CENTER);
				});
				//账管中心磁贴点击详情
				$(_this.settings.ACCOUNT_CENTER_LIST_QUERY).bind("click",function(){
					_this.getJobsBySchedulerName(_this.settings.ACCOUNT_CENTER);
				});
				//资源中心磁贴点击详情	
				$(_this.settings.RES_CENTER_LIST_QUERY).bind("click",function(){
					_this.getJobsBySchedulerName(_this.settings.RES_CENTER);
				});
				//添加任务
				$(_this.settings.ADD_TASK).bind("click",function(){
					_this.createNewJobPrompt();
				});
				//添加MVNE任务
				$(_this.settings.ADD_MVEN_TASK).bind("click",function(){
					_this.createNewMVNEJobPrompt();
				});
				//批量重启任务
				$(_this.settings.BATCH_RESUME_TASK).bind("click",function(){
					_this.batchResumeJob();
				});
				//批量暂停任务
				$(_this.settings.BATCH_PAUSE_TASK).bind("click",function(){
					_this.batchPauseJob();
				});
				//全选/取消
				$(_this.settings.CHECK_CANCEL_TASK).bind("click",function(){
					_this.checkAllRecord();
				});
				
			},
			//绑定列表每条记录中的链接事件
			bindRecordEvents:function(){
				var _this = this;
				//单个重启任务
				$(_this.settings.SINGLE_RESUME_TASK).bind("click",function(){
					var jobName=$(this).attr("jobName");
					var jobGroup=$(this).attr("jobGroup");
					var schedulerName=$(this).attr("schedulerName");
					_this.resumeJob(jobName,jobGroup,schedulerName);
				});
				//单个暂停任务
				$(_this.settings.SINGLE_PAUSE_TASK).bind("click",function(){
					var jobName=$(this).attr("jobName");
					var jobGroup=$(this).attr("jobGroup");
					var schedulerName=$(this).attr("schedulerName");
					_this.pauseJob(jobName,jobGroup,schedulerName);
				});
				//单个修改任务
			    $(_this.settings.SINGLE_EDIT_TASK).bind("click",function(){
			    	var jobName=$(this).attr("jobName");
					var jobGroup=$(this).attr("jobGroup");
					var schedulerName=$(this).attr("schedulerName");
					_this.editJobPrompt(jobName,jobGroup,schedulerName);
				});
			},
			/*帮助 */
	        help: function() {
	        	var _this = this;
				var template = $.templates("#helpImpl");
				var htmlOutput = template.render({});
				bootbox.dialog({
					title : "帮助",
					message : htmlOutput,
					width : 900,
					height:300,
					buttons : {						
						cancelBtn : {
							label : "关闭",
							className : "btn-success",
							callback : function() {
								bootbox.hideAll();
							}
						}
					}
				});
	          
	        },
			/*根据调度中心、任务状态、任务名称查询所有的任务 */
	        listTasksByCondition: function() {
	        	var _this = this; 
	            var url = _base+"/quartz/manage/listTasksByCondition";
	            ajaxController.ajax({
	                method: "POST",
	                url: url,
	                data:{
	                	taskName: function () {
	                        return $("#cond_taskName").val();
	                    },
	                    schedulerName: function () {
	                        return $("#cond_schedulerName").val();
	                    },
	                    triggerState: function () {
	                        return $("#cond_triggerState").val();
	                    }
	                },
	                dataType: "json",
	                showWait:true,
	                message:"正在加载数据..",
	                success: function (data) {
	                	 var template = $.templates("#schedulerJobsTmpl");
	                     var htmlOutput = template.render(data.data);
	                     $("#schedulerJobs").html(htmlOutput);
	                     
	                   //重启、修改、暂停按钮绑定事件
	                     _this.bindRecordEvents();
	            	}
	            }); //end of ajax
	          
	        },
	        /*根据scheduleName查询所有的任务 */
	        getJobsBySchedulerName:function(schedulerName) {
	        	var _this = this; 
	            $("#cond_schedulerName").val(schedulerName);
	            _this.listTasksByCondition();
	        },
	        /*创建任务*/
	        createNewJobPrompt:function() {
	        	var _this = this;
	            var template = $.templates("#addJobsFormImpl");
	            var htmlOutput = template.render({});
	            bootbox.dialog({
	                title: "添加一个任务",
	                message: htmlOutput,
	                buttons: {
	                    saveBtn: {
	                        label: "保存",
	                        className: "btn-success",
	                        callback: function () {
	                            var url = _base+"/quartz/manage/addJob";
	                            ajaxController.ajax({
	                                method: "POST",
	                                url: url,
	                                //postselectors:["#id"],
	                                data: {
	                                	"schedulerName": function () {
	                                        return $("#schedulerName").val();
	                                    },
	                                    "jobName": function () {
	                                        return $("#jobName").val();
	                                    },
	                                    "jobGroup": function () {
	                                        return $("#jobGroup").val();
	                                    },
	                                    "cronExpress": function () {
	                                        return $("#cronExpress").val();
	                                    },
	                                    "envStr": function () {
	                                        return $("#env").val();
	                                    },
	                                    "implClass": function () {
	                                        return $("#implClass").val();
	                                    },
	                                    "isConcurrent": function () {
	                                        return $('input:radio[name=isConcurrent]:checked').val();
	                                    }
	                                },
	                                dataType: "json",
	                                showWait:true,
	                                message:"正在保存任务..",
	                                success: function (data) {
	                                		bootbox.hideAll();
	                                        _this.getJobsBySchedulerName($("#jobName").val());
	                                }
	                            });// end of ajax
	                            return false;
	                        }
	                    },
	                    cancelBtn: {
	                        label: "取消",
	                        className: "btn-success",
	                        callback: function () {
	                            bootbox.hideAll();
	                        }
	                    }
	                }
	            });
	        },
	        createNewMVNEJobPrompt:function() {
	        	var _this = this;
	            var template = $.templates("#addMVNEJobsFormImpl");
	            var htmlOutput = template.render({});
	            bootbox.dialog({
	                title: "添加一个MVNE任务",
	                message: htmlOutput,
	                buttons: {
	                    saveBtn: {
	                        label: "保存",
	                        className: "btn-success",
	                        callback: function () {
	                            var url = _base+"/quartz/manage/addMVNETaskJob";
	                            ajaxController.ajax({
	                                method: "POST",
	                                url: url,
	                                data: {
	                                	"schedulerName": function () {
	                                        return $("#schedulerName").val();
	                                    },
	                                    "jobName": function () {
	                                        return $("#jobName").val();
	                                    },
	                                    "jobGroup": function () {
	                                        return $("#jobGroup").val();
	                                    },
	                                    "cronExpress": function () {
	                                        return $("#cronExpress").val();
	                                    },
	                                    "processClass": function () {
	                                        return $("#processClass").val();
	                                    },
	                                    "retryTimes": function () {
	                                        return $("#retryTimes").val();
	                                    },
	                                    "threads": function () {
	                                        return $("#threads").val();
	                                    },
	                                    "recordNum": function () {
	                                        return $("#recordNum").val();
	                                    }
	                                },
	                                dataType: "json",
	                                showWait:true,
	                                message:"正在保存MVNE任务..",
	                                success: function (data) {
	                                	bootbox.hideAll();
	                                	_this.getJobsBySchedulerName($("#schedulerName").val());
	                                }
	                            });//end of ajax
	                            
	                            return false;
	                        }
	                    },
	                    cancelBtn: {
	                        label: "取消",
	                        className: "btn-success",
	                        callback: function () {
	                            bootbox.hideAll();
	                        }
	                    }
	                }
	            });
	        },
	        //修改任务
	        editJobPrompt: function(jobName, jobGroup,schedulerName) {
	        	var _this = this;
	            var url = _base+"/quartz/manage/task/detail4edit";
	            ajaxController.ajax({
	                method: "POST",
	                url: url,
	                data: {
	                	"schedulerName": schedulerName,
	                    "jobName": jobName,
	                    "jobGroup": jobGroup
	                },
	                dataType: "json",
	                showWait:true,
	                message:"正在编辑调度任务..",
	                success: function (data) {
	                	//modJobsFormImpl modMVNEJobsFormImpl
	                	var template="";
	                	var taskType=data.data.taskType;
	                	var url="";
	                	var dataOptions={};
	                	if(taskType=='PLAIN_TASK'){//普通任务
	                		template = $.templates("#modJobsFormImpl");
	                		url = _base+"/quartz/manage/editJob";
	                		dataOptions={
	                				"schedulerName": schedulerName,
                                    "jobName": jobName,
                                    "jobGroup": jobGroup,
                                    "cronExpress": function () {
                                        return $("#cronExpress").val();
                                    },
                                    "envStr": function () {
                                        return $("#env").val();
                                    },
                                    "implClass": function () {
                                        return $("#implClass").val();
                                    },
                                    "isConcurrent": function () {
                                        return $('input:radio[name=isConcurrent]:checked').val();
                                    }
	                		};
	                	}
	                	else{//MVNE任务
	                		template = $.templates("#modMVNEJobsFormImpl");
	                		url = _base+"/quartz/manage/editMVNEJob";
	                		dataOptions={
	                				"schedulerName": schedulerName,
                                    "jobName": jobName,
                                    "jobGroup": jobGroup,
                                    "cronExpress": function () {
                                        return $("#cronExpress").val();
                                    },
                                    "processClass": function () {
                                        return $("#processClass").val();
                                    },
                                    "retryTimes": function () {
                                        return $("#retryTimes").val();
                                    },
                                    "threads": function () {
                                        return $("#threads").val();
                                    },
                                    "recordNum": function () {
                                        return $("#recordNum").val();
                                    }
	                		};
	                	}
	                    var htmlOutput = template.render(data.data);
	                    bootbox.dialog({
	                        title: "修改任务信息",
	                        message: htmlOutput,
	                        buttons: {
	                            saveBtn: {
	                                label: "保存",
	                                className: "btn-success",
	                                callback: function () {
	                                    ajaxController.ajax({
	                                        method: "POST",
	                                        url: url,
	                                        data: dataOptions,
	                                        dataType: "json",
	                                        showWait:true,
	                                        message:"正在保存调度任务..",
	                                        success: function (data) {
	                                        	//_this.getJobsBySchedulerName(schedulerName);
	                                        	bootbox.hideAll();
	                                        	_this.listTasksByCondition();
	                                        }
	                                    });
	                                    return false;
	                                }
	                            },
	    	                    cancelBtn: {
	    	                        label: "取消",
	    	                        className: "btn-success",
	    	                        callback: function () {
	    	                            bootbox.hideAll();
	    	                        }
	    	                    }
	                        }// end of buttons
	                    });//end of bootbox
	                }
	            });
	        },
			//function：全选/取消
			checkAllRecord: function(){
				var _this = this;
	    		var ckflag=$('#chkCheckAll').is(':checked');
	    		$("[name=ids]").attr("checked",ckflag);
	    	},
	    	/*批量重启*/
	        batchResumeJob: function(){
	        	var _this = this;
	        	//jobName, jobGroup,schedulerName 此三个元素决定一个任务
	        	var selected_ids="";
	    		//至少选择一条记录
	    		if($("input[type=checkbox][name=ids]:checked").length<1){
	    			messageController.alert("请选择要操作的任务");
	    			return false;
	    		}
	    		//拼装选中记录的ID
	    		$("input[type=checkbox][name=ids]:checked").each(function(){
	    			selected_ids+=$(this).attr("jobName")+","+$(this).attr("jobGroup")+","+$(this).attr("schedulerName")+";";
	    		});
	    		
	    		//ajax操作
	    		var url = _base+"/quartz/manage/batchResumeJob";
	            ajaxController.ajax({
	                method: "POST",
	                url: url,
	                data: {
	                	jobs: selected_ids
	                },
	                dataType: "json",
	                showWait:true,
	                message:"正在批量重启任务..",
	                success: function (data) {
	                  	messageController.alert("批量重启成功",function(){
	                  		_this.listTasksByCondition();
	                	})
	                }
	            });
	        },
	        /*批量暂停*/
	        batchPauseJob: function(){
	        	var _this = this;
	        	//jobName, jobGroup,schedulerName 此三个元素决定一个任务
	        	var selected_ids="";
	    		//至少选择一条记录
	    		if($("input[type=checkbox][name=ids]:checked").length<1){
	    			messageController.alert("请选择要操作的任务");
	    			return false;
	    		}
	    		//拼装选中记录的ID
	    		$("input[type=checkbox][name=ids]:checked").each(function(){
	    			selected_ids+=$(this).attr("jobName")+","+$(this).attr("jobGroup")+","+$(this).attr("schedulerName")+";";
	    		});
	    		
	    		//ajax操作
	    		var url = _base+"/quartz/manage/batchPauseJob";
	            ajaxController.ajax({
	                method: "POST",
	                url: url,
	                data: {
	                	jobs: selected_ids
	                },
	                dataType: "json",
	                showWait:true,
	                message:"正在批量暂停任务..",
	                success: function (data) {
	                  	messageController.alert("批量暂停成功",function(){
	                  		_this.listTasksByCondition();
	                	})
	                }
	            });
	        },
	        /*重启任务*/
	        resumeJob: function(jobName, jobGroup,schedulerName) {
	        	var _this = this;
	            var url = _base+"/quartz/manage/resumeJob";
	            
	            ajaxController.ajax({
	                method: "POST",
	                url: url,
	                data: {
	                	"schedulerName": schedulerName,
	                    "jobName": jobName,
	                    "jobGroup": jobGroup
	                },
	                dataType: "json",
	                showWait:true,
	                message:"正在重启调度任务..",
	                success: function (data) {
	                  	messageController.alert("任务重启成功",function(){
	                  		//_this.getJobsBySchedulerName(schedulerName);
	                  		_this.listTasksByCondition();
	                	})
	                }
	            });
	        },
	        /*暂停任务*/
	        pauseJob:function(jobName, jobGroup,schedulerName) {
	        	var _this = this;
	            var url = _base+"/quartz/manage/pauseJob";
	            ajaxController.ajax({
	                method: "POST",
	                url: url,
	                data: {
	                	"schedulerName": schedulerName,
	                    "jobName": jobName,
	                    "jobGroup": jobGroup
	                },
	                dataType: "json",
	                showWait:true,
	                message:"正在暂停调度任务..",
	                success: function (data) {
	                  	messageController.alert("任务暂停成功",function(){
	                  	    //_this.getJobsBySchedulerName(schedulerName);
	                  		_this.listTasksByCondition();
	                	})
	                }
	            });
	        }// end of function pauseJob
			
		}
		
	});
	
})(jQuery);
        