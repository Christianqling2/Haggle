package com.Haggle.cloud.user.controller.app;

import com.Haggle.cloud.api.user.vo.AreaVO;
import com.Haggle.cloud.common.response.ServerResponseEntity;
import com.Haggle.cloud.user.service.AreaService;
import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController("appAreaController")
@RequestMapping("/area")
@Tag(name = "app-地区信息")
public class AreaController {

    @Autowired
    private AreaService areaService;

    @GetMapping("/list")
    @Operation(summary = "获取省市区地区信息列表" , description = "获取省市区地区信息列表")
    public ServerResponseEntity<List<AreaVO>> list() {
        List<AreaVO> list = areaService.getAreaListInfo();
        return ServerResponseEntity.success(list);
    }

    @GetMapping("/list_by_pid")
    @Operation(summary = "通过父级id获取区域列表" , description = "通过父级id获取区域列表")
    public ServerResponseEntity<List<AreaVO>> listByPid(Long pid) {
        List<AreaVO> list = areaService.listByPid(pid);
        return ServerResponseEntity.success(list);
    }
}
