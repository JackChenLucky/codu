package cn.jack.codu.modules.system.service.impl;

import cn.jack.codu.modules.system.model.Instructions;
import cn.jack.codu.modules.system.dao.InstructionsMapper;
import cn.jack.codu.modules.system.service.IInstructionsService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author Jackchen
 * @since 2017-07-07
 */
@Service
public class InstructionsServiceImpl extends ServiceImpl<InstructionsMapper, Instructions> implements IInstructionsService {
	
}
