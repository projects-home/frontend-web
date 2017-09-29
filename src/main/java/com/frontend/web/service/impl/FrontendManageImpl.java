package com.frontend.web.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.mybatis.spring.SqlSessionTemplate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import com.alibaba.fastjson.JSONObject;
import com.frontend.web.bo.TdChartDataRule;
import com.frontend.web.bo.TdChartDataRuleCriteria;
import com.frontend.web.bo.TdRouteRule;
import com.frontend.web.bo.TdRouteRuleCriteria;
import com.frontend.web.bo.TdRouteRuleCriteria.Criteria;
import com.frontend.web.controller.FrontendController;
import com.frontend.web.bo.TdViewArch;
import com.frontend.web.bo.TdViewArchCriteria;
import com.frontend.web.bo.TdViewArchElement;
import com.frontend.web.bo.TdViewArchElementCriteria;
import com.frontend.web.bo.TdViewChart;
import com.frontend.web.bo.TdViewChartCriteria;
import com.frontend.web.bo.TdViewPageCriteria;
import com.frontend.web.bo.TdViewPage;
import com.frontend.web.dao.TdChartDataRuleMapper;
import com.frontend.web.dao.TdRouteRuleMapper;
import com.frontend.web.dao.TdViewArchElementMapper;
import com.frontend.web.dao.TdViewArchMapper;
import com.frontend.web.dao.TdViewChartMapper;
import com.frontend.web.dao.TdViewPageMapper;
import com.frontend.web.model.ArchElement;
import com.frontend.web.model.ArchVarReq;
import com.frontend.web.model.ArchVarResp;
import com.frontend.web.model.ViewArchVo;
import com.frontend.web.model.chart.PercentChart;
import com.frontend.web.model.request.ReqCycle;
import com.frontend.web.model.request.ReqDic;
import com.frontend.web.model.request.ReqDim;
import com.frontend.web.model.request.ReqQuota;
import com.frontend.web.model.request.Reqdata;
import com.frontend.web.model.request.Request;
import com.frontend.web.model.response.RepDic;
import com.frontend.web.model.response.RepDim;
import com.frontend.web.model.response.RepQuota;
import com.frontend.web.model.response.Reponse;
import com.frontend.web.service.interfaces.IFrontendManage;
import com.frontend.web.utils.HttpClientUtil;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

@Service
@Transactional
public class FrontendManageImpl implements IFrontendManage {

	private static final Logger logger = LoggerFactory.getLogger(FrontendManageImpl.class);
	
    @Autowired
    private SqlSessionTemplate sqlSessionTemplate;
    
    public static final String VAR_SPLIT_FIELD = ",";
    public static final String VAR_PREFIX = "V";
    public static final String CHART_TYPE_CODE = "C";

	@Override
	public ArchVarResp getArchByVar(ArchVarReq archVarReq) {
		// TODO Auto-generated method stub
		ArchVarResp result = new ArchVarResp();
		
		TdViewPage viewPage = this.QueryViewPageByCode(archVarReq.getPageCode());
		TdViewArch arch = this.QueryViewArchByCode(archVarReq.getPageCode(), archVarReq.getArchCode());
		
		result.setPageCode(viewPage.getPageCode());
		result.setArchCode(arch.getArchCode());
		ViewArchVo archVo = new ViewArchVo();
		archVo.setArchCode(arch.getArchCode());
		archVo.setArchName(arch.getArchName());
		archVo.setTimeValRal(String.valueOf(arch.getStaytimeValue()));
		archVo.setTimeUnit(arch.getStaytimeUnit());
		
		List<ArchElement> elements = new ArrayList<>();
		List<String> vars = new ArrayList<>();
		vars.add(archVarReq.getPageCode());
		vars.add(archVarReq.getArchCode());
		Long routeId = this.getRouteId(vars);
		if(routeId!=null){
			List<TdViewArchElement> archElements = this.getArchElementByRouteId(routeId);
			if(!CollectionUtils.isEmpty(archElements)){
				for(TdViewArchElement archElement : archElements){
					ArchElement element = new ArchElement();
					element.setElementCode(archElement.getElementCode());
					element.setElementTypeCode(archElement.getElementTypeCode());
					element.setElementUrl(archElement.getElementUrl());
					element.setShowOrder(String.valueOf(archElement.getShowOrder()));
					elements.add(element);
				}
			}
		}
		archVo.setArchElements(elements);
		result.setArchVo(archVo);
		
		return result;
	}
	
	@Override
	public String getDataByChart(ArchVarReq archVarReq) {
		// TODO Auto-generated method stub
		
		Request resultData = new Request();
		resultData.setReqtype("getdata");
		
		ReqQuota reqQuota = new ReqQuota();
		String chartCode = "";
		String chartType = "";
		String url = "";
		List<ReqCycle> cycles = new ArrayList<>();
		ReqDim dim = new ReqDim();
		
		List<String> vars = new ArrayList<>();
		vars.add(archVarReq.getPageCode());
		vars.add(archVarReq.getArchCode());
		if(StringUtils.isNotBlank(archVarReq.getElementCode())){
			vars.add(archVarReq.getElementCode());
		}
		Long routeId = this.getRouteId(vars);
		if(routeId!=null){
			List<TdViewArchElement> archElements = this.getArchElementByRouteId(routeId);
			for(TdViewArchElement archElement:archElements){
				if(StringUtils.equals(CHART_TYPE_CODE, archElement.getElementTypeCode()) && StringUtils.equals(archVarReq.getPageCode(), archElement.getPageCode())
						&& StringUtils.equals(archVarReq.getArchCode(), archElement.getArchCode()) && StringUtils.equals(archVarReq.getElementCode(), archElement.getElementCode())){
					String virtualchartCode = archElement.getElementCodeVirtual();
					List<TdViewChart> charts = this.getViewChartByVirtualCode(virtualchartCode);
					if(!CollectionUtils.isEmpty(charts)){
						chartCode = charts.get(0).getRuleCode();
						chartType = charts.get(0).getChartTypeCode();
						List<TdChartDataRule> dataRules = this.getChartDataRuleByChartCode(chartCode);
						if(!CollectionUtils.isEmpty(dataRules)){
							List<ReqDic> dics = new ArrayList<>();
							for(TdChartDataRule chartDataRule:dataRules){
								if(StringUtils.equals("quota_code", chartDataRule.getParamCode())){
									chartCode = chartDataRule.getParamValue1();
								}
								if(StringUtils.equals("dim_code", chartDataRule.getParamCode())){
									dim.setDim_code(chartDataRule.getParamValue1());
								}
								if(StringUtils.equals("dic_code", chartDataRule.getParamCode())){
									ReqDic dic = new ReqDic();
									dic.setDic_code(chartDataRule.getParamValue1());
									dics.add(dic);
								}
								if(StringUtils.equals("url", chartDataRule.getParamCode())){
									url = chartDataRule.getParamValue1();
								}
								//处理cycle
							}
							dim.setDic(dics);
						}
					}
				}
			}
		}
		reqQuota.setQuota_code(chartCode);
		reqQuota.setCycle(cycles);
		reqQuota.setDim(dim);
		Reqdata reqdata = new Reqdata();
		
		List<ReqQuota> quotas = new ArrayList<>();
		quotas.add(reqQuota);
		reqdata.setQuota(quotas);
		resultData.setReqdata(reqdata);
		logger.info("resultData------>"+JSONObject.toJSONString(resultData));
		logger.info("url------>"+url);
		if(StringUtils.isNotBlank(url)){
			//将返回的数据解析
			String respStr = HttpClientUtil.sendPost(url, "data="+JSONObject.toJSONString(resultData));
			return this.getConvertRespStr(respStr, chartType);
		}else{
			return null;
		}
	}
	
	/**
	 * 临时赶进度的方法，需要重写
	 * 返回数据转换
	 * @param respStr
	 * @return
	 */
	private String getConvertRespStr(String respStr, String chartType){
		List<List<PercentChart>> chartList = new ArrayList<>();
		if(StringUtils.isNotBlank(respStr)){
			Reponse reponse = JSONObject.parseObject(respStr, Reponse.class);
			if(StringUtils.equals("JT", chartType)){
				for(RepQuota quota:reponse.getQuota()){
					String quotaCode = quota.getQuota_code();
					List<PercentChart> charts = new ArrayList<>();
					for(RepDic repDic : quota.getDim().getDic()){
						PercentChart chart = new PercentChart();
						chart.setQuotaCode(quotaCode);
						chart.setTitle(repDic.getDic_name());
						chart.setData(repDic.getDic_data_cycle().get(0).getCycle_data_set().get(0).getData_set_row().get(0).getRow_data().get(0).getData_value());
						int percent = (int) (Math.random() * 100);
						chart.setPercentage(String.valueOf(percent));
						chart.setType("lineProcess");
						charts.add(chart);
					}
					chartList.add(charts);
				}
			}
			
		}
		return JSONObject.toJSONString(chartList);
	}
	
	private List<TdChartDataRule> getChartDataRuleByChartCode(String chartCode){
		TdChartDataRuleMapper dataRuleMapper = this.sqlSessionTemplate.getMapper(TdChartDataRuleMapper.class);
		TdChartDataRuleCriteria chartDataRuleCriteria = new TdChartDataRuleCriteria();
		com.frontend.web.bo.TdChartDataRuleCriteria.Criteria criteria = chartDataRuleCriteria.createCriteria();
		criteria.andRuleCodeEqualTo(chartCode);
		return dataRuleMapper.selectByExample(chartDataRuleCriteria);
	}
	
	private List<TdViewChart> getViewChartByVirtualCode(String virtualchartCode){
		TdViewChartMapper chartMapper = this.sqlSessionTemplate.getMapper(TdViewChartMapper.class);
		TdViewChartCriteria chartCriteria = new TdViewChartCriteria();
		com.frontend.web.bo.TdViewChartCriteria.Criteria criteria = chartCriteria.createCriteria();
		criteria.andChartCodeEqualTo(virtualchartCode);
		return chartMapper.selectByExample(chartCriteria);
	}
	
	/**
	 * 根据路由id获取元素列表
	 * @param routeId
	 * @return
	 */
	private List<TdViewArchElement> getArchElementByRouteId(Long routeId){
		TdViewArchElementMapper elementMapper = this.sqlSessionTemplate.getMapper(TdViewArchElementMapper.class);
		TdViewArchElementCriteria elementCriteria = new TdViewArchElementCriteria();
		com.frontend.web.bo.TdViewArchElementCriteria.Criteria criteria = elementCriteria.createCriteria();
		criteria.andRouteIdEqualTo(routeId);
		return elementMapper.selectByExample(elementCriteria);
	}
	
	/**
	 * 根据变量值获得路由规则id
	 * @param vars
	 * @return
	 */
	private Long getRouteId(List<String> vars){
		TdRouteRuleMapper routeRuleMapper = this.sqlSessionTemplate.getMapper(TdRouteRuleMapper.class);
		TdRouteRuleCriteria routeRuleCriteria = new TdRouteRuleCriteria();
		Criteria  criteria = routeRuleCriteria.createCriteria();
		StringBuffer expr = new StringBuffer("");
		if(!CollectionUtils.isEmpty(vars)){
			for(int i=0; i<vars.size(); i++){
				expr.append(getVarName(i)+"="+vars.get(i));
				if(i!=vars.size()-1){
					expr.append(VAR_SPLIT_FIELD);
				}
			}
		}
		criteria.andGetValueExprLike(expr.toString()+"%");
		List<TdRouteRule> routeRules = routeRuleMapper.selectByExample(routeRuleCriteria);
		if(!CollectionUtils.isEmpty(routeRules)){
			return routeRules.get(0).getRouteId();
		}else{
			return null;
		}
	}
	
	private TdViewArch QueryViewArchByCode(String pageCode, String archCode){
		TdViewArchMapper archMapper = sqlSessionTemplate.getMapper(TdViewArchMapper.class);
		TdViewArchCriteria archCriteria = new TdViewArchCriteria();
		com.frontend.web.bo.TdViewArchCriteria.Criteria criteria = archCriteria.createCriteria();
		criteria.andArchCodeEqualTo(archCode);
		criteria.andPageCodeEqualTo(pageCode);
		List<TdViewArch> archs = archMapper.selectByExample(archCriteria);
		if(!CollectionUtils.isEmpty(archs)){
			return archs.get(0);
		}else{
			return null;
		}
	}
	
	private TdViewPage QueryViewPageByCode(String code){
		TdViewPageMapper viewPageMapper = sqlSessionTemplate.getMapper(TdViewPageMapper.class);
		TdViewPageCriteria viewPageCriteria = new TdViewPageCriteria();
		com.frontend.web.bo.TdViewPageCriteria.Criteria pageCriteria = viewPageCriteria.createCriteria();
		pageCriteria.andPageCodeEqualTo(code);
		List<TdViewPage> tdViewPages = viewPageMapper.selectByExample(viewPageCriteria);
		if(!CollectionUtils.isEmpty(tdViewPages)){
			return tdViewPages.get(0);
		}else{
			return null;
		}
	}
	
	/**
	 * 得到数据库变量名称
	 * @param index
	 * @return
	 */
	public static String getVarName(int index){
		return VAR_PREFIX+String.valueOf(index);
	}
}
