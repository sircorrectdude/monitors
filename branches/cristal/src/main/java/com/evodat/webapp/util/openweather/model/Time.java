package com.evodat.webapp.util.openweather.model;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamAsAttribute;

@XStreamAlias(value = "time")
public class Time {

	@XStreamAsAttribute
	private String value;

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

	/**
	* Pc = (Niederschlagswahrscheinlichkeit)
	 * @return
	 */
	public String getPc() {
		return pc;
	}

	public void setPc(String pc) {
		this.pc = pc;
	}

	public String getDu() {
		return du;
	}

	/**
	* Wd = (Windrichtung in Grad)
	 * @return
	 */
	public String getWd() {
		return wd;
	}

	public void setWd(String wd) {
		this.wd = wd;
	}

	/**
	* Ws = (Windgeschwindigkeitd)
	 * @return
	 */
	public String getWs() {
		return ws;
	}

	public void setWs(String ws) {
		this.ws = ws;
	}

	/**
	* Wd_txt = (Windrichtung text)
	 * @return
	 */
	public String getWd_txt() {
		return wd_txt;
	}

	public void setWd_txt(String wd_txt) {
		this.wd_txt = wd_txt;
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

	/**
	* W = (Weather Code)
	 * 10 = wolkig
	 * 20 = leicht bewölkt 
	 * @return
	 */
	public String getW() {
		return w;
	}

	public void setW(String w) {
		this.w = w;
	}

	/**
	 * Tn = (Min Temperatur)
	 * @return
	 */
	public String getTn() {
		return tn;
	}

	public void setTn(String tn) {
		this.tn = tn;
	}

	/**
	 * Tx = (Max Temperatur)
	 * @return
	 */
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

	/**
	 * The Time Value
	 * @return
	 */
	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public Date getTimeValue() {
		DateFormat sdf = new SimpleDateFormat("hh:mm");
		try {
			return sdf.parse(getValue());
		} catch (ParseException e) {
			return null;
		}

	}

}
