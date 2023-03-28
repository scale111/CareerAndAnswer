package cn.iocoder.yudao.module.forum.controller.admin.post.vo;

import lombok.*;
import java.util.*;
import io.swagger.v3.oas.annotations.media.Schema;
import javax.validation.constraints.*;

@Schema(description = "管理后台 - 帖子创建 Request VO")
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class ForumPostCreateReqVO extends ForumPostBaseVO {

}
