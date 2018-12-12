package tests.part9_jtl;

import javax.servlet.jsp.tagext.SimpleTagSupport;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 格式化日期参数的标签<br/>
 * 属性：date="${aDateAttr}"，format="aStr'
 */
public class DateFormatTag extends SimpleTagSupport {
	/** 属性：日期参数 */
	private Date date;
	/** 属性：格式化模版 */
	private String format;

	@Override
	public void doTag() throws IOException {
		if(format == null)
			format = "yyyy-MM-dd HH-mm-ss";
		if(date == null)
			date = new Date();

		super.getJspContext().getOut().write(new SimpleDateFormat(format).format(date));
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getFormat() {
		return format;
	}

	public void setFormat(String format) {
		this.format = format;
	}
}
