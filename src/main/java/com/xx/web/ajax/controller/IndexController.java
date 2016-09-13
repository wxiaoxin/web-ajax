package com.xx.web.ajax.controller;

import com.alibaba.fastjson.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@Controller
@RequestMapping("/")
public class IndexController {


    @RequestMapping("/index")
    public String index() {
        return "index";
    }


    /**
     * 不可跨域请求
     * @param id
     * @return
     */
    @RequestMapping("/info")
    @ResponseBody
    public String info(String id) {
        System.out.println("info 接收到：" + id);
        String s = "UserInfo:{id = " + id + ", name = ahhha, pwd = 123}";
        return JSONObject.toJSONString(s);
    }


    /**
     * 通过jsonp实现跨域请求
     * @param req 请求
     * @return
     */
    @RequestMapping("/info2")
    @ResponseBody
    public String info2(HttpServletRequest req) {
        String id = req.getParameter("id");
        String callback = req.getParameter("callback");
        System.out.println("info2 接收到id：" + id + ", 接收到callback: " + callback);
        String s = "UserInfo:{id = " + id + ", name = ahhha, pwd = 123}";
        // 根据callback参数，动态拼接返回的内容
        String jsonpResult = callback + "(" + JSONObject.toJSONString(s) + ")";
        return jsonpResult;
    }


    /**
     * 通过设置响应头Access-Control-Allow-Origin，允许ajax跨域请求
     * @param id
     * @param resp
     * @return
     */
    @RequestMapping("/info3")
    @ResponseBody
    public String info3(String id, HttpServletResponse resp) {
        System.out.println("info3 接收到：" + id);
        resp.addHeader("Access-Control-Allow-Origin", "*");
        String s = "UserInfo:{id = " + id + ", name = ahhha, pwd = 123}";
        return JSONObject.toJSONString(s);
    }


}
