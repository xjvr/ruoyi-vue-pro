package cn.iocoder.yudao.module.member.controller.app.ldap;

import cn.iocoder.yudao.framework.common.enums.UserTypeEnum;
import cn.iocoder.yudao.framework.common.pojo.CommonResult;
import cn.iocoder.yudao.module.member.controller.app.ldap.vo.AppLdapBindReqVO;
import cn.iocoder.yudao.module.member.controller.app.social.vo.AppSocialUserBindReqVO;
import cn.iocoder.yudao.module.member.dal.ldap.LdapPerson;
import cn.iocoder.yudao.module.system.api.social.SocialUserApi;
import cn.iocoder.yudao.module.system.api.social.dto.SocialUserBindReqDTO;
import cn.iocoder.yudao.module.system.enums.social.SocialTypeEnum;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ldap.core.LdapTemplate;
import org.springframework.ldap.query.LdapQuery;
import org.springframework.ldap.query.LdapQueryBuilder;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.security.PermitAll;
import javax.validation.Valid;

import static cn.iocoder.yudao.framework.common.pojo.CommonResult.success;
import static cn.iocoder.yudao.framework.security.core.util.SecurityFrameworkUtils.getLoginUserId;

/**
 * LDAP 认证
 * @author rjw
 * @date 2025/2/15
 */
@Tag(name = "用户 App - Ldap认证")
@Slf4j
@RestController
@RequestMapping("/member/ldap")
@Validated
public class LdapController {

    @Autowired
    private LdapTemplate ldapTemplate;

    @Autowired
    private SocialUserApi socialUserApi;

    @PostMapping("/bind")
    @Operation(summary = "社交绑定，使用 code 授权码")
    @PermitAll
    public CommonResult<String> socialBind(@RequestBody @Valid AppLdapBindReqVO reqVO) {
        LdapPerson person = ldapValidate(reqVO.getUsername(), reqVO.getPassword());
        log.info("用户:{},LDAP认证成功", person.getCn());
//        String openId = socialUserApi.bindSocialUser(new SocialUserBindReqDTO(getLoginUserId(), UserTypeEnum.MEMBER.getValue(),
//                SocialTypeEnum.LDAP.getType(), person.getCn(), reqVO.getState()));
        // TODO 保存ldap认证信息

        return success(person.getSn());
    }

    private LdapPerson ldapValidate(String username, String password) {
        log.info("用户:{},尝试LDAP认证", username);
        try {
            LdapQuery query = LdapQueryBuilder.query().where("uid").is(username);
            ldapTemplate.authenticate(query, password);
            LdapPerson person = ldapTemplate.findOne(query, LdapPerson.class);
            if (person == null) {
                log.error("用户:{},LDAP认证失败", username);
                throw new Exception("LDAP认证失败");
            }
            return person;
            // 保存认证表，和认证标志
        }
        catch (Exception e) {
            log.error("用户:{},LDAP认证失败", username, e);
            throw new RuntimeException("LDAP认证失败");
        }

    }

}
