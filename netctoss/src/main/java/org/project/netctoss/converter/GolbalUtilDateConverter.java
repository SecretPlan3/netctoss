package org.project.netctoss.converter;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.core.convert.converter.Converter;
import org.springframework.util.StringUtils;

/**
 * 瀹氫箟涓�涓叏灞�绫诲瀷杞崲鍣�
 * @author pu
 *
 */
public class GolbalUtilDateConverter implements Converter<String, Date> {

	@Override
	public Date convert(String text) {
		// TODO Auto-generated method stub
		Date date = null;
		if(StringUtils.hasLength(text)) {
			int lenth = text.length();
			String pattern = "yyyy-MM-dd";
			if(lenth != 10) { 
				pattern = "yyyy-MM-dd hh:mm:ss";
			}
			SimpleDateFormat sdf = new SimpleDateFormat(pattern);
			
			try {
				date = sdf.parse(text);
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return date;
	}

}
