package cn.one.findlost.controller.converter;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.core.convert.converter.Converter;

/**
 * S - source:源
 * T - target:目标
 * @author zj
 *
 */
public class CustomGlobalStrToDateConverter implements Converter<String,Date> {
	@Override
	public Date convert(String source) {
		Date date = null;
		try{
			date = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(source);
		}catch (Exception e){

		}
		return date;
	}
}
