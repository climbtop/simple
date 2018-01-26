package simple;

import java.util.List;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeMap;

import com.common.MD5;
import com.trendy.fw.common.util.ListKit;
import com.trendy.fw.common.util.StringKit;

public class Sign {

	public static void main(String[] args) {
		
		
		//{"appCode":81183,"appId":"wx745ef520c03e19f2","nonceStr":"2cae909c597846e6b60a7ccef83373d0","orderId":1292,"outTradeNo":"2017090819386997014291354","paySign":"49496B12BC5895DE458BD67DC99EB3A1","prepayId":"wx2017090815210955637c345b0512763816","signType":"MD5","timeStamp":"1504855293"}


		
		String nonceStr="2cae909c597846e6b60a7ccef83373d0";
		String timeStamp="1504855293";
		String prepayId="wx2017090815210955637c345b0512763816";
		
		String appId="wx745ef520c03e19f2";
		String md5key = "wet23623476yrt52gfu673262hjkjkry";

			try {
				TreeMap<String, String> map = new TreeMap<String, String>();
				map.put("appId", appId);
				map.put("timeStamp", timeStamp);
				map.put("nonceStr", nonceStr);
				map.put("package", "prepay_id=" + prepayId);
				String sign = signParam(map, "", md5key);
				map.put("signType", "MD5");
				map.put("paySign", sign);
				System.out.println(sign);
			} catch (Exception e) {
				e.printStackTrace();
			}
	}

	public static String signParam(TreeMap<String, String> map, String mustValueParams, String md5key) throws Exception {
		List<String> list = ListKit.string2List(mustValueParams, ",");
		StringBuffer sb = new StringBuffer();
		Set<Entry<String, String>> entries = map.entrySet();
		for (Entry<String, String> entry : entries) {
			String key = entry.getKey();
			String value = entry.getValue();
			if (key.equals("sign")) {
				continue;
			}
			System.out.println(key);
			if (StringKit.isValid(value)) {
				sb.append(key + "=" + value + "&");
			} else if (list.contains(key)) {
				throw new Exception(key + " must value");
			}
		}
		String text = sb.toString() + "key="+md5key;
		System.out.println(text);
		return MD5.getMD5(text).toUpperCase();
	}
	
}
