package com.myproject.common.utils;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import java.util.HashMap;
import java.util.Map;

/**
 * @author happyelements
 */
@Data
public class PageForm {

	/**
	 * 是否分页，默认false 分页；true 不分页满足条件的数据一次性输出
	 */
    private Boolean nopage;
    
	/**
	 * 查询时间戳
	 */
    @JsonIgnore
	private long t;

	/**
	 * 第几页
	 */
	private Long page = 1L;

	/**
	 * 分页条数
	 */
	private Long limit = 10L;

	/**
	 * 封装查询用的params
	 * @return
	 */
	@JsonIgnore
	public Map<String, Object> getPageMap() {
		Map<String, Object> pageMap = new HashMap<String, Object>();
        if (page.equals(0L)) {
        	page = null;
		}

        if (limit.equals(0L)) {
        	limit = null;
		}

        if (nopage != null && nopage) {
        	this.limit = -1L;
        }
		pageMap.put(Constant.PAGE, page == null ? page : String.valueOf(page));
		pageMap.put(Constant.LIMIT, limit == null ? limit :  String.valueOf(limit));

		return pageMap;
	}
}
