package com.tiiaan.tbm.metaj.controller;


import com.tiiaan.tbm.metaj.dto.InstanceFormDTO;
import com.tiiaan.tbm.metaj.dto.Result;
import com.tiiaan.tbm.metaj.service.InstanceService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author tiiaan
 * @since 2023-02-26
 */
@RestController
@RequestMapping("/instance")
public class InstanceController {

    @Resource
    private InstanceService instanceService;


    @PostMapping
    public Result addInstance(@RequestBody InstanceFormDTO instanceFormDTO) {
        return instanceService.addInstance(instanceFormDTO);
    }


    @GetMapping("/{id}")
    public Result queryInstanceById(@PathVariable("id") Long id) {
        return instanceService.queryInstanceById(id);
    }


    @GetMapping
    public Result queryInstances(@RequestParam(value = "curr", defaultValue = "1") Integer curr) {
        return instanceService.queryInstances(curr);
    }


    @GetMapping("/watching/of/me")
    public Result queryInstancesMe(@RequestParam(value = "curr", defaultValue = "1") Integer curr) {
        return instanceService.queryInstancesMe(curr);
    }



    /**
     * 执行关注或者取消关注，取决于当前登陆的用户是否关注过
     * @param id
     * @return com.tiiaan.tbm.metaj.dto.Result
     * @author tiiaan Email:tiiaan.w@gmail.com
     */
    @PutMapping("/watch/{id}")
    public Result watchInstance(@PathVariable("id") Long id) {
        return instanceService.watchInstance(id);
    }


    /**
     * 查询某一台实例的关注人数
     * @param id
     * @return com.tiiaan.tbm.metaj.dto.Result
     * @author tiiaan Email:tiiaan.w@gmail.com
     */
    @GetMapping("/watching/count/of/{id}")
    public Result queryWatchingCount(@PathVariable("id") Long id) {
        return instanceService.queryWatchingCount(id);
    }



    /**
     * 查询某一台实例是否被当前用户关注
     * @param id
     * @return com.tiiaan.tbm.metaj.dto.Result
     * @author tiiaan Email:tiiaan.w@gmail.com
     */
    @GetMapping("/is/watching/{id}")
    public Result queryIsWatchingByCurrUser(@PathVariable("id") Long id) {
        return instanceService.queryIsWatchingByCurrUser(id);
    }


    @GetMapping("/who/is/watching/{id}")
    public Result queryInstanceWatching(@PathVariable("id") Long id) {
        return instanceService.queryInstanceWatching(id);
    }


    @GetMapping("/count")
    public Result queryInstancesCount() {
        return instanceService.queryInstancesCount();
    }

}
