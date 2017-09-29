package com.frontend.web.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSONObject;
import com.frontend.web.model.ArchVarReq;
import com.frontend.web.model.ArchVarResp;
import com.frontend.web.model.ResponseData;
import com.frontend.web.service.interfaces.IFrontendManage;

@RestController
@RequestMapping("/frontend/service")
public class FrontendController {

    @Autowired
    private IFrontendManage frontendManage;
    
    private static final Logger logger = LoggerFactory.getLogger(FrontendController.class);

    @CrossOrigin
    @RequestMapping("/getArchByVar")
    public ResponseData<ArchVarResp> getArchByVar(ArchVarReq reqData) {
        ResponseData<ArchVarResp> responseData = null;
        try {
        	logger.info(JSONObject.toJSONString(reqData));
        	ArchVarResp varResp = new ArchVarResp();
        	if(reqData!=null){
        		varResp = frontendManage.getArchByVar(reqData);
        		responseData = new ResponseData<ArchVarResp>(
                        ResponseData.AJAX_STATUS_SUCCESS, "查找任务成功",
                        varResp);
        	}else{
        		responseData = new ResponseData<ArchVarResp>(
                        ResponseData.AJAX_STATUS_FAILURE, "入參不能为空",
                        null);
        	}
        } catch (Exception e) {
            e.printStackTrace();
            responseData = new ResponseData<ArchVarResp>(
                    ResponseData.AJAX_STATUS_FAILURE, "查找任务失败" + e.getMessage());
        }
        return responseData;
    }
    
    @CrossOrigin
    @RequestMapping("/getDataByChart")
    public ResponseData<String> getDataByChart(ArchVarReq reqData) {
        ResponseData<String> responseData = null;
        try {
        	logger.info(JSONObject.toJSONString(reqData));
        	if(reqData!=null){
        		String respData = frontendManage.getDataByChart(reqData);
        		responseData = new ResponseData<String>(
                        ResponseData.AJAX_STATUS_SUCCESS, "查找任务成功",
                        respData);
        	}else{
        		responseData = new ResponseData<String>(
                        ResponseData.AJAX_STATUS_FAILURE, "入參不能为空",
                        null);
        	}
        } catch (Exception e) {
            e.printStackTrace();
            responseData = new ResponseData<String>(
                    ResponseData.AJAX_STATUS_FAILURE, "查找任务失败" + e.getMessage());
        }
        return responseData;
    }
}
