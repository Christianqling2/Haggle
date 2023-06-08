package com.Haggle.cloud.user.controller.multishop;

import com.Haggle.cloud.api.user.vo.UserApiVO;
import com.Haggle.cloud.common.database.vo.PageVO;
import com.Haggle.cloud.user.model.User;
import com.Haggle.cloud.user.service.UserService;
import com.Haggle.cloud.user.dto.UserDTO;
import com.Haggle.cloud.common.database.dto.PageDTO;
import com.Haggle.cloud.common.response.ServerResponseEntity;
import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.annotations.Operation;
import ma.glasnost.orika.MapperFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;


@RestController("multishopUserController")
@RequestMapping("/m/user")
@Tag(name = "店铺-用户表")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
	private MapperFacade mapperFacade;

	@GetMapping("/page")
	@Operation(summary = "获取用户表列表" , description = "分页获取用户表列表")
	public ServerResponseEntity<PageVO<UserApiVO>> page(@Valid PageDTO pageDTO) {
		PageVO<UserApiVO> userPage = userService.page(pageDTO);
		return ServerResponseEntity.success(userPage);
	}

	@GetMapping
    @Operation(summary = "获取用户表" , description = "根据userId获取用户表")
    public ServerResponseEntity<UserApiVO> getByUserId(@RequestParam Long userId) {
        UserApiVO userVO = mapperFacade.map(userService.getByUserId(userId), UserApiVO.class);
        return ServerResponseEntity.success(userVO);
    }


    @PutMapping
    @Operation(summary = "更新用户表" , description = "更新用户表")
    public ServerResponseEntity<Void> update(@Valid @RequestBody UserDTO userDTO) {
        User user = mapperFacade.map(userDTO, User.class);
        userService.update(user);
        return ServerResponseEntity.success();
    }

}
