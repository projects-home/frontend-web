package com.frontend.web.service.interfaces;

import java.util.List;

import com.frontend.web.model.ArchVarReq;
import com.frontend.web.model.ArchVarResp;

public interface IFrontendManage {
    
    public ArchVarResp getArchByVar(ArchVarReq archVarReq);
    
    public String getDataByChart(ArchVarReq archVarReq);
}
