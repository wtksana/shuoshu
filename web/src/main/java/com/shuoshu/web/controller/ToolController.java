package com.shuoshu.web.controller;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import com.shuoshu.core.base.controll.BaseController;
import com.shuoshu.util.StringUtils;
import com.shuoshu.util.ValidCodeMaker;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;

/**
 * 工具类Action,验证码、生产图、计算器
 * 
 * @author fuxingxing
 */
@Controller
public class ToolController extends BaseController {
	private static final Logger LOGGER = LoggerFactory.getLogger(ToolController.class);
	/**
	 * 常量AVATAR_DIR  : avatar 目录
	 */
	private static final String AVATAR_DIR = "avatar";
	private String userId;
	private String size;

	private double account;
	private double lilv;
	private int times;
	private int timeLimitDay;
	private String type;

	private File upload;
	private File localUrl;
	private String uploadFileName;
	private String sep = File.separator;

	// 裁剪后的图像大小
	private double cropX;
	private double cropY;
	private double cropW;
	private double cropH;

	private String plugintype;

	private Map<String, Object> data;

	/**
	 * 生成图片验证码
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/validimg")
	public void validimg() throws Exception {
		try {
			ValidCodeMaker authCode = ValidCodeMaker.getInstance();
			// 取得随机字符串放入session
			session.setAttribute("", authCode.getString());
			//设置验证码输出格式
			response.setContentType("image/jpeg");
			response.setCharacterEncoding("utf-8");
			OutputStream output = new BufferedOutputStream(response.getOutputStream());  
			InputStream in = authCode.getImage();
			int len = 0;
			byte[] buf = new byte[1024];
			while ((len = in.read(buf, 0, 1024)) != -1) {
				output.write(buf, 0, len);
			}
			response.flushBuffer();
			output.flush();
			in.close();
			output.close();
		} catch (IOException e) {
			LOGGER.error("build validCode error.", e);
		}
	}

	/**
	 * 异步校验图片验证码
	 * @return
	 * @throws Exception
	 */
	/*@RequestMapping(value="/valicode")
	@ResponseBody
	public Object valicode(String validCode) throws Exception {
		data = new HashMap();
		if (StringUtils.isBlank(validCode) || !ValidateUtils.checkValidCode(validCode)) {// 不通过
			throw new BussinessException("验证码错误!", BussinessException.TYPE_JSON);
		}
		SessionUtils.setSessionAttr(Constant.VALID_CODE, validCode);
		data.put(RESULT_NAME, true);
		data.put(MSG_NAME, "验证码正确!");
		
		return data;
	}*/




	
	/**
	 * 显示插件Action
	 * 
	 * @return
	 * @throws Exception
	 */
	public String plugin() throws Exception {
		response.setContentType("text/html;charset=UTF-8");
		return null;
	}


	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getSize() {
		return size;
	}

	public void setSize(String size) {
		this.size = size;
	}

	public double getAccount() {
		return account;
	}

	public void setAccount(double account) {
		this.account = account;
	}

	public double getLilv() {
		return lilv;
	}

	public void setLilv(double lilv) {
		this.lilv = lilv;
	}

	public int getTimes() {
		return times;
	}

	public void setTimes(int times) {
		this.times = times;
	}

	public int getTimeLimitDay() {
		return timeLimitDay;
	}

	public void setTimeLimitDay(int timeLimitDay) {
		this.timeLimitDay = timeLimitDay;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public File getUpload() {
		return upload;
	}

	public void setUpload(File upload) {
		this.upload = upload;
	}

	public String getUploadFileName() {
		return uploadFileName;
	}

	public void setUploadFileName(String uploadFileName) {
		this.uploadFileName = uploadFileName;
	}

	public double getCropX() {
		return cropX;
	}

	public void setCropX(double cropX) {
		this.cropX = cropX;
	}

	public double getCropY() {
		return cropY;
	}

	public void setCropY(double cropY) {
		this.cropY = cropY;
	}

	public double getCropW() {
		return cropW;
	}

	public void setCropW(double cropW) {
		this.cropW = cropW;
	}

	public double getCropH() {
		return cropH;
	}

	public void setCropH(double cropH) {
		this.cropH = cropH;
	}

	public String getPlugintype() {
		return plugintype;
	}

	public void setPlugintype(String plugintype) {
		this.plugintype = plugintype;
	}

	public File getLocalUrl() {
		return localUrl;
	}

	public void setLocalUrl(File localUrl) {
		this.localUrl = localUrl;
	}

}
