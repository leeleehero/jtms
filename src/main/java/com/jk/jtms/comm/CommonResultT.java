package com.jk.jtms.comm;

import com.jk.jtms.enums.ResultEnums;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.List;

/**
* @Package com.bm.jx.pojo.comm
* @Title: CommonResultT.java   
* @Description: 自定义响应结构(为swagger才这么做，返回泛型类型)  
* @author steven  
* @date 2018年7月16日 上午10:59:13
* @version V1.0
 */
public class CommonResultT<T> {

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
	private T data;


	public static<T> CommonResultT<T> build(Integer status, String msg, T data) {
		return new CommonResultT<T>(status, msg, data);
	}

	public static<T> CommonResultT<T> ok(T data) {
		return new CommonResultT<T>(data);
	}

	public static<T> CommonResultT<T> ok() {
		return new CommonResultT<T>(null);
	}

	public CommonResultT() {

	}

	public static<T> CommonResultT<T> build(Integer status, String msg) {
		return new CommonResultT<T>(status, msg, null);
	}

	public CommonResultT(Integer status, String msg, T data) {
		this.status = status;
		this.msg = msg;
		this.data = data;
	}

	public CommonResultT(T data) {
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

	

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}

	/**
	 * 将json结果集转化为CommonResult对象
	 * 
	 * @param jsonData
	 * json数据
	 * @param clazz
	 * CommonResult中的object类型
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public static CommonResultT<Object> formatToPojo(String jsonData, Class<?> clazz) {
		try {
			if (clazz == null) {
				return MAPPER.readValue(jsonData, CommonResultT.class);
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
	public static CommonResultT<?> format(String json) {
		try {
			return MAPPER.readValue(json, CommonResultT.class);
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
	public static<T> CommonResultT<Object> formatToList(String jsonData, Class<?> clazz) {
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
