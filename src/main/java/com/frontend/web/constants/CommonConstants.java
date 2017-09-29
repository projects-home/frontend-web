package com.frontend.web.constants;

public class CommonConstants {
	
	public static class REQ_TYPE{
		public static final String GET_DATA = "getdata";
	}
	public static class Exception{
	     /**
         *  处理成功[业务处理成功]
         */
		public static final String SUCCESS = "000000";

        /**
         *  系统级异常[其它系统级异常，未知异常]
         */
        public static final String SYSTEM_ERROR = "999999";

        /**
         * 传入的{0}参数为空
         */
        public static final String PARAM_IS_NULL = "888888";
        
        /**
         * 不支持的请求类型
         */
        public static final String REQ_TYPE_ERROR = "888881";
	}

}
