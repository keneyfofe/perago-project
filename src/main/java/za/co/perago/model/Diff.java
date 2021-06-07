package za.co.perago.model;

import java.io.Serializable;
import java.util.List;

public class Diff<T> implements Serializable {

	private static final long serialVersionUID = 1L;

	private String parent;

	private List<String> fields;

	private T obj;

	public T getObj() {
		return obj;
	}

	public void setObj(T obj) {
		this.obj = obj;
	}

	public String getParent() {
		return parent;
	}

	public void setParent(String parent) {
		this.parent = parent;
	}

	public List<String> getFields() {
		return fields;
	}

	public void setFields(List<String> fields) {
		this.fields = fields;
	}

	@Override
	public String toString() {
		return "diff:{" + "parent:" + parent + ", fields:" + fields + ", obj:" + obj + '}';
	}

}
