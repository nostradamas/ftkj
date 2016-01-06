package com.qd.ftkj.website.result;

import java.util.List;

public class ListResult<T> extends BaseResult {

	private List<T> data;
	private int totalSize;
	private int page;
	private int pagesize;
	private boolean hasPage = true;

	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		this.page = page;
	}

	public int getTotalSize() {
		return totalSize;
	}

	public void setTotalSize(int totalSize) {
		this.totalSize = totalSize;
	}

	public int getPagesize() {
		return pagesize;
	}

	public void setPagesize(int pagesize) {
		this.pagesize = pagesize;
	}

	public boolean isHasPage() {
		return hasPage;
	}

	public void setHasPage(boolean hasPage) {
		this.hasPage = hasPage;
	}

	public List<T> getData() {
		return data;
	}

	public void setData(List<T> data) {
		this.data = data;
	}

	@Override
	public String toString() {
		return "ListResult [data=" + data + ", totalSize=" + totalSize + ", page=" + page + ", pagesize=" + pagesize
				+ ", hasPage=" + hasPage + "]";
	}

}
