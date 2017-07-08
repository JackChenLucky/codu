package cn.jack.codu.common.beetl;

import java.io.IOException;

import org.beetl.core.Context;
import org.beetl.core.Function;

public class IsSelectedExpressionFunction implements Function{

	@Override
	public String call(Object[] paras, Context ctx) {
		
		if (paras.length < 2)
			return "";
		
		Object result1 = paras[0];
		Object result2 = paras[1];
		if(result1!=null&&result2!=null){
			if(result1.toString().equals(result2.toString())){
				try{
                    ctx.byteWriter.writeString("selected=selected");
	            }catch (IOException e){
	                    throw new RuntimeException(e);
	            }
			}
		}
		return "";
	}

}
