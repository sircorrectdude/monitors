package com.evodat.webapp.util;

import java.util.Date;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

public class TrafficInfo implements Comparable<TrafficInfo> {

	protected Date time;
	protected String train;
	protected String timeString;
	protected String target;
	protected String platform;
	protected String ris;
	public String image;
	public String imageGeneral;
	public String timeShift;

	public String getTimeShift() {
		return timeShift;
	}

	public String getImageGeneral() {
		return imageGeneral;
	}

	public void setImageGeneral(String imageGeneral) {
		this.imageGeneral = imageGeneral;
	}

	public Date getTime() {
		return time;
	}

	public String getTrain() {
		return train;
	}

	public String getTarget() {
		return target;
	}

	public String getPlatform() {
		return platform;
	}

	public String getImage() {
		return image;
	}

	public String getRis() {
		return ris;
	}

	public String getTimeString() {
		return timeString;
	}

	public void setTimeString(String timeString) {
		this.timeString = timeString;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == null) {
			throw new IllegalArgumentException();
		}

		if (obj instanceof TrafficInfo) {
			return platform == ((TrafficInfo) obj).platform && train == ((TrafficInfo) obj).train
					&& target == ((TrafficInfo) obj).target && image == ((TrafficInfo) obj).image
					&& ris == ((TrafficInfo) obj).ris && timeString == ((TrafficInfo) obj).timeString
					&& time == ((TrafficInfo) obj).time;
		}

		return false;
	}

	/**
	 * {@inheritDoc}
	 */
	public String toString() {
		return new ToStringBuilder(this, ToStringStyle.SIMPLE_STYLE).append(this.platform).append(this.time)
				.append(this.train).append(this.target).append(this.ris).toString();
	}

	public int compareTo(TrafficInfo o) {
		if (getTime() == null || o.getTime() == null)
			return 0;
		return getTime().compareTo(o.getTime());
	}

}
