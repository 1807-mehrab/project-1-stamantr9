package com.revature.model;

public class Request {
	private int request_id;
	private int requester_id;
	private int request_amount;
	private int resolved;
	private int resolver;
	



	public int getRequest_id() {
		return request_id;
	}




	public void setRequest_id(int request_id) {
		this.request_id = request_id;
	}




	public int getRequester_id() {
		return requester_id;
	}




	public void setRequester_id(int requester_id) {
		this.requester_id = requester_id;
	}




	public int getRequest_amount() {
		return request_amount;
	}




	public void setRequest_amount(int request_amount) {
		this.request_amount = request_amount;
	}




	public int getResolver() {
		return resolver;
	}




	public void setResolver(int resolver) {
		this.resolver = resolver;
	}




	public Request() {
		super();
		// TODO Auto-generated constructor stub
	}




	public Request(int request_id, int requester_id, int request_amount, int resolved, int resolver) {
		super();
		this.request_id = request_id;
		this.requester_id = requester_id;
		this.request_amount = request_amount;
		this.resolved = resolved;
		this.resolver = resolver;
	}




	@Override
	public String toString() {
		return "Request [request_id=" + request_id + ", requester_id=" + requester_id + ", request_amount="
				+ request_amount + ", resolved=" + resolved + ", resolver=" + resolver + "]";
	}




	public int getResolved() {
		return resolved;
	}




	public void setResolved(int resolved) {
		this.resolved = resolved;
	}

}
