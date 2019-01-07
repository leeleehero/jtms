package com.jk.jtms.comm;

/**
* @Package com.bm.jx.pojo.comm
* @Title: QueryParam.java   
* @Description: 分页查询父类    
* @author steven  
* @date 2018年8月17日 上午9:30:27
* @version V1.0
 */
public class QueryParam {

	/**
	 * start
	 */
	private Integer start = 0;
	/**
	 * pageSize
	 */
	private Integer pageSize = 25;
	/**
	 * page
	 */
	private Integer page = 1;
	/**
	 * sortBy
	 */
	private String sortBy;

	public Integer getStart() {
		return start;
	}

	public void setStart(Integer start) {
		this.start = start;
	}

	public String getSortBy() {
		return sortBy;
	}

	public void setSortBy(String sortBy) {
		this.sortBy = sortBy;
	}

	public Integer getPage() {
		return page;
	}

	public void setPage(Integer page) {
		this.page = page;
	}

	public Integer getPageSize() {
		return pageSize;
	}

	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}
}
