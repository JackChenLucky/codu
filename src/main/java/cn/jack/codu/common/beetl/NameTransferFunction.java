package cn.jack.codu.common.beetl;

import org.beetl.core.Context;
import org.beetl.core.Function;

/**
 * 页面名称转换
 * @author JackChen
 *
 */
public class NameTransferFunction  implements Function{

	@Override
	public Object call(Object[] paras, Context ctx) {
		if(paras.length<2){
			return "参数有无";
		}
		String flag = paras[0].toString();
		switch(flag){
			case "1":
				return "";
		}
		return "";
	}

}
