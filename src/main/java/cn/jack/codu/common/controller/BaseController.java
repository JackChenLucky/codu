package cn.jack.codu.common.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import cn.jack.codu.core.util.HttpKit;

public class BaseController {
	protected Logger logger = LoggerFactory.getLogger(this.getClass());
	
	protected static String SUCCESS = "SUCCESS";
	protected static String ERROR = "ERROR";
	
	protected static String REDIRECT = "redirect:";
	protected static String FORWARD = "forward:";

	protected HttpServletRequest getHttpServletRequest() {
        return HttpKit.getRequest();
    }

    protected HttpServletResponse getHttpServletResponse() {
        return HttpKit.getResponse();
    }

    protected HttpSession getSession() {
        return HttpKit.getRequest().getSession();
    }

    protected String getPara(String name) {
        return HttpKit.getRequest().getParameter(name);
    }

    protected void setAttr(String name, Object value) {
        HttpKit.getRequest().setAttribute(name, value);
    }

}
