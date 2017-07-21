package cn.jack.codu.modules.system.dao;

import java.util.Date;

import org.apache.ibatis.annotations.Param;

public interface CommonMapper {
	
	Long getSeq(@Param("seqname") String seqname);
	
	Date getCurrentDate(); 
}
