package org.duchess.whattodo.model;

import static com.google.common.base.Objects.equal;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.google.common.base.Objects;
import com.google.common.base.Strings;

public class EventSession {

	private Date showDateTimeStart;

	public EventSession() {
	}

	public EventSession(String showDate, String showTime) {
		this.showDateTimeStart = mergeDateAndTime(showDate, showTime);
	}

	public static Date mergeDateAndTime(String showDate, String showTime) {

		String date = showDate;
		String time = showTime;

		if (Strings.isNullOrEmpty(time)) {
			time = " 00:00";
		}

		String dateTime = date + " " + time;

		try {
			SimpleDateFormat formatter = new SimpleDateFormat(
					"yyyy-MM-dd HH:mm");
			return formatter.parse(dateTime);

		} catch (ParseException e) {
			throw new IllegalStateException(
					"Error when merging date and time. Expected yyyy-MM-dd HH:mm, found ["
							+ dateTime + "]");
		}
	}

	@Override
	public boolean equals(Object obj) {
		if (obj instanceof EventSession) {
			EventSession other = (EventSession) obj;
			return equal(showDateTimeStart, other.showDateTimeStart);
		}
		return false;
	}

	@Override
	public String toString() {
		return Objects.toStringHelper(this)
				.add("showDateTimeStart", showDateTimeStart).toString();
	}

	@Override
	public int hashCode() {
		return Objects.hashCode(showDateTimeStart);
	}

	public Date getShowDateTimeStart() {
		return showDateTimeStart;
	}

	public void setShowDateTimeStart(Date showDateTimeStart) {
		this.showDateTimeStart = showDateTimeStart;
	}
}