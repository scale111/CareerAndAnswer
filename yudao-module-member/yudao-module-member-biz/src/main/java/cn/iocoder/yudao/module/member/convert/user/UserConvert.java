package cn.iocoder.yudao.module.member.convert.user;
import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.module.member.controller.admin.user.vo.*;
import cn.iocoder.yudao.module.member.dal.dataobject.user.MemberUserDO;
import cn.iocoder.yudao.module.member.api.user.dto.MemberUserRespDTO;
import cn.iocoder.yudao.module.member.controller.app.user.vo.AppUserInfoRespVO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;


/**
 * 用户登录表 Convert
 *
 * @author SZT
 */
@Mapper
public interface UserConvert {

    UserConvert INSTANCE = Mappers.getMapper(UserConvert.class);

    AppUserInfoRespVO convert(MemberUserDO bean);

    MemberUserRespDTO convert2(MemberUserDO bean);
    List<MemberUserRespDTO> convertList2(List<MemberUserDO> list);


    MemberUserDO convert(MemberUserCreateReqVO bean);
    MemberUserDO convert(MemberUserUpdateReqVO bean);
    //冲突
//    MemberUserRespVO convert(MemberUserDO bean);
    MemberUserRespVO convert02(MemberUserDO bean);

    List<MemberUserRespVO> convertList(List<MemberUserDO> list);

    PageResult<MemberUserRespVO> convertPage(PageResult<MemberUserDO> page);

    List<MemberUserExcelVO> convertList02(List<MemberUserDO> list);

}







