package com.jk.jtms.comm;

import com.jk.jtms.enums.ResultEnums;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.List;

/**
* @Package com.bm.jx.pojo.comm
* @Title: CommonResult.java   
* @Description: 自定义响应结构   
* @author steven  
* @date 2018年7月16日 上午10:59:00
* @version V1.0
 */
public class CommonResult {

	/**
	 * 定义jackson对象
	 */
	private static final ObjectMapper MAPPER = new ObjectMapper();

	/**
	 * 响应业务状态
	 */
	private Integer status;

	/**
	 * 响应消息
	 */
	private String msg;

	/**
	 * 响应中的数据
	 */
	private Object data;

	public static CommonResult build(Integer status, String msg, Object data) {
		return new CommonResult(status, msg, data);
	}

	/**
	 * 
	* @Title: ok 
	* @Description: TODO
	* @param @param data
	* @param @return   
	* @return CommonResult  
	* @throws
	 */
	public static CommonResult ok(Object data) {
		return new CommonResult(data);
	}

	public static CommonResult ok() {
		return new CommonResult(null);
	}

	public CommonResult() {

	}

	public static CommonResult build(Integer status, String msg) {
		return new CommonResult(status, msg, null);
	}

	public CommonResult(Integer status, String msg, Object data) {
		this.status = status;
		this.msg = msg;
		this.data = data;
	}

	public CommonResult(Object data) {
		this.status = ResultEnums.SUCCESS.getCode();
		this.msg = ResultEnums.SUCCESS.getMsg();
		this.data = data;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}

	/**
	 * 将json结果集转化为CommonResult对象
	 * 
	 * @param jsonData
	 *            json数据
	 * @param clazz
	 *            CommonResult中的object类型
	 * @return
	 */
	public static CommonResult formatToPojo(String jsonData, Class<?> clazz) {
		try {
			if (clazz == null) {
				return MAPPER.readValue(jsonData, CommonResult.class);
			}
			JsonNode jsonNode = MAPPER.readTree(jsonData);
			JsonNode data = jsonNode.get("data");
			Object obj = null;
			if (clazz != null) {
				if (data.isObject()) {
					obj = MAPPER.readValue(data.traverse(), clazz);
				} else if (data.isTextual()) {
					obj = MAPPER.readValue(data.asText(), clazz);
				}
			}
			return build(jsonNode.get("status").intValue(), jsonNode.get("msg").asText(), obj);
		} catch (Exception e) {
			return null;
		}
	}

	/**
	 * 没有object对象的转化
	 * 
	 * @param json
	 * @return
	 */
	public static CommonResult format(String json) {
		try {
			return MAPPER.readValue(json, CommonResult.class);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * Object是集合转化
	 * 
	 * @param jsonData
	 *            json数据
	 * @param clazz
	 *            集合中的类型
	 * @return
	 */
	public static CommonResult formatToList(String jsonData, Class<?> clazz) {
		try {
			JsonNode jsonNode = MAPPER.readTree(jsonData);
			JsonNode data = jsonNode.get("data");
			Object obj = null;
			if (data.isArray() && data.size() > 0) {
				obj = MAPPER.readValue(data.traverse(),
						MAPPER.getTypeFactory().constructCollectionType(List.class, clazz));
			}
			return build(jsonNode.get("status").intValue(), jsonNode.get("msg").asText(), obj);
		} catch (Exception e) {
			return null;
		}
	}

}
