package com.evodat.webapp.util.openweather.model;

import java.util.List;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamAsAttribute;
import com.thoughtworks.xstream.annotations.XStreamImplicit;

@XStreamAlias(value = "date")
public class Date {

	@XStreamAsAttribute
	private String value;

	@XStreamImplicit(itemFieldName = "time")
	private List<Time> times;

	private String du;
	private String d;
	private String dhu;
	private String dhl;
	private String p;
	private String w;
	private String tn;
	private String tx;
	private String wd;
	private String ws;
	private String w_txt;
	private String wd_txt;
	private String pc;

	public String getPc() {
		return pc;
	}

	public void setPc(String pc) {
		this.pc = pc;
	}

	public String getWd() {
		return wd;
	}

	public void setWd(String wd) {
		this.wd = wd;
	}

	public String getWs() {
		return ws;
	}

	public void setWs(String ws) {
		this.ws = ws;
	}

	public String getWd_txt() {
		return wd_txt;
	}

	public void setWd_txt(String wd_txt) {
		this.wd_txt = wd_txt;
	}

	public List<Time> getTimes() {
		return times;
	}

	public void setTimes(List<Time> times) {
		this.times = times;
	}

	public String getDu() {
		return du;
	}

	public void setDu(String du) {
		this.du = du;
	}

	public String getD() {
		return d;
	}

	public void setD(String d) {
		this.d = d;
	}

	public String getDhu() {
		return dhu;
	}

	public void setDhu(String dhu) {
		this.dhu = dhu;
	}

	public String getDhl() {
		return dhl;
	}

	public void setDhl(String dhl) {
		this.dhl = dhl;
	}

	public String getP() {
		return p;
	}

	public void setP(String p) {
		this.p = p;
	}

	public String getW() {
		return w;
	}

	public void setW(String w) {
		this.w = w;
	}

	public String getTn() {
		return tn;
	}

	public void setTn(String tn) {
		this.tn = tn;
	}

	public String getTx() {
		return tx;
	}

	public void setTx(String tx) {
		this.tx = tx;
	}

	public String getW_txt() {
		return w_txt;
	}

	public void setW_txt(String w_txt) {
		this.w_txt = w_txt;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

}
