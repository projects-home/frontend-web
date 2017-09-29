/**
 * 
 */

//页面控制类
var questionPageController = null;
//页面加载初始化
$(document).ready(function () {
	//1.页面事件初始化及绑定
	questionPageController =  new $.QuestionPageController();
	questionPageController.init(); 
});

(function($){
	$.QuestionPageController=function(){
		this.settings=$.extend(true,{},$.QuestionPageController.defaults);		
	}
	
	$.extend($.QuestionPageController,{
		//常量定义
		defaults:{
			//全选/取消
			GET_RANDOM_QUESTION:"#getRandomQuestion",
			RADIO:":radio"
			
		},
		prototype:{
			init: function(){
				var _this = this;
				_this.bindEvents();
				_this.getRandomQuestion();
				$("#u_i").attr("value",$.cookie("u_i"));
			},
			/*初始化事件绑定*/
			bindEvents: function(){
				var _this = this;
				//换一个
				$(_this.settings.GET_RANDOM_QUESTION).bind("click",function(){
					_this.getRandomQuestion();
				});
				//radio点击事件
				$(_this.settings.RADIO).bind("click",function(){
					_this.answerClick(this);
				});
			}
			,
			answerClick: function(__this) {
	        	var _this = this;
	        	var _tr = $(__this).parent().parent();
	        	var _a = $("#questionAnswer");
	        	_a.show();
	        	$(_this.settings.RADIO).each(function(){
	        		var _radio = $(this);
	        		var _v = _radio.val();
	        		var __tr = $(this).parent().parent();
	        		__tr.attr("class","");
	        		if(_v == _a.text()){
	        			__tr.attr("class","bgc_tr_rig");
	        		}
	        	});
	        	if($(__this).val() != _a.text()){
	        		_tr.attr("class","bgc_tr_cho");
	        	}
	        }
			,
	        getRandomQuestion: function() {
	        	var _this = this;
	          	$("tr").each(function(){
	        		$(this).attr("class","");
	        	});
	          	$("input:radio[name=answer]").each(function(){
	          		$(this).attr("checked",false);
	          	});
	          	$("#questionAnswer").hide();
          	    $("#examTipsImage").attr("src","");
          	    $("#questionImage").attr("src","");
          	    var _u_i = $("#u_i").val();
	    		$.ajax({
	    		       method: "POST",
	    		       url: _base+"/question/manage/getRandomQuestion?rnd="+Math.random(),
	    		       data:{"uId":_u_i},
	    		       dataType: "json",
	    		       success: function (data) {
	    		    	   $("#questionId").text("").append(data.data.questionId);
	    		    	   $("#questionName").text("").append(data.data.questionName);
	    		    	   $("#questionType").text("").append(data.data.questionType);
	    		    	   $("#questionAnswer").text("").append(data.data.questionAnswer);
	    		    	   $("#answerA").text("").append(data.data.answerA);
	    		    	   $("#answerB").text("").append(data.data.answerB);
	    		    	   $("#answerC").text("").append(data.data.answerC);
	    		    	   $("#answerD").text("").append(data.data.answerD);
	    		    	   $("#answerE").text("").append(data.data.answerE);
	    		    	   $("#answerF").text("").append(data.data.answerF);
	    		    	   $("#answerG").text("").append(data.data.answerG);
	    		    	   $("#inactiveTime").text("").append(data.data.inactiveTime);
	    		    	   $("#activeTime").text("").append(data.data.activeTime);
	    		    	   $("#state").text("").append(data.data.state);
	    		    	   $("#examTipsTopic").text("").append(data.data.examTipsTopic);
	    		    	   $("#examTipsKey").text("").append(data.data.examTipsKey);
	    		    	   $("#examTipsSource").text("").append(data.data.examTipsSource);
	    		    	   $("#examTipsChoice").text("").append(data.data.examTipsChoice);
	    		    	   if(data.data.examTipsImage){
	    		    		   $("#examTipsImage").attr("src","").attr("src",_base+"/resources/img/"+data.data.examTipsImage);
	    		    	   }
	    		    	   if(data.data.questionImage){
	    		    		   $("#questionImage").attr("src","").attr("src",_base+"/resources/img/"+data.data.questionImage);
	    		    	   }
	    		       },
	    		       //业务处理错误
	    		       failure: function(data){
	    		       },
	    		       //网络错误
	    		       error: function(data){
	    		       }
	    		   });// end of ajax
	        	
	        	
	        }// end of function pauseJob
			
		}
		
	});
	
})(jQuery);