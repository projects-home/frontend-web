(function($){
	
	$.PieChartCanvasBuilder = function(canvasId,schedulers){
		this.settings = $.extend(true,{},$.PieChartCanvasBuilder.defaults);
		this.canvasId = canvasId;
		this.schedulers = schedulers?schedulers:[];
	}
	
	$.extend($.PieChartCanvasBuilder,{		
		defaults: {
			colors:[{centername:"crm-center",color:"#00c0ef"},
				    {centername:"am-center",color:"#00a65a"},
				    {centername:"resources-center",color:"#f39c12"}
			        //{centername:"commons-center",color:"#f56954"}
			],
			pieOptions: {
				segmentShowStroke: true,
			    segmentStrokeColor: "#fff",
			    segmentStrokeWidth: 1,
			    percentageInnerCutout: 50, 
			    animationSteps: 100,
			    animationEasing: "easeOutBounce",
			    animateRotate: true,
			    animateScale: false,
			    responsive: true,
			    maintainAspectRatio: false,
			    legendTemplate: "<ul class=\"<%=name.toLowerCase()%>-legend\"><% for (var i=0; i<segments.length; i++){%><li><span style=\"background-color:<%=segments[i].fillColor%>\"></span><%if(segments[i].label){%><%=segments[i].label%><%}%></li><%}%></ul>",
			    tooltipTemplate: "<%=label%> ok"
			}
			
		},	
		prototype: {
			
			build: function(){
				var pieChartCanvas = $(this.canvasId).get(0).getContext("2d");
				var pieChart = new Chart(pieChartCanvas);
				var opts = this.constructPipOpts();
				pieChart.Doughnut(opts, opts);
			},
			
			constructPipOpts: function(){
				var opts= [];
				var _this = this;
				$(_this.schedulers).each(function(index,scheduler){
					var centername = scheduler.schedulerName;
					var instancenames = scheduler.instanceName?scheduler.instanceName.join(","):"";
					var color = _this.getColor(centername);
					var d = {
							value: 1,
						    color: color,
						    label: centername+"("+ instancenames +")"
					}
					opts.push(d);
				});
				return opts;
			},
			
			getColor: function(centername){
				var colors =  this.settings.colors;
				var fundColors = $.grep(colors,function(data,i){
					return data.centername==centername;
				});
				if(fundColors.length){
					var color = fundColors[0].color;
					return color;
				} 
				return "#d2d6de";
			}
		}
		
	});
	
	
})(jQuery);

