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


    @GetMapping("/query")
    public Result queryInstances(@RequestParam(value = "curr", defaultValue = "1") Integer curr,
                                 @RequestParam(value = "orderBy", defaultValue = "id") String orderBy,
                                 @RequestParam(value = "orderType", defaultValue = "0") Integer orderType,
                                 @RequestParam(value = "health", defaultValue = "-1") Integer health,
                                 @RequestParam(value = "watching", defaultValue = "false") Boolean watching,
                                 @RequestParam(value = "ofMe", defaultValue = "false") Boolean ofMe) {
        return instanceService.queryInstances(curr, orderBy, orderType, health, watching, ofMe);
    }


    //@GetMapping
    //public Result queryInstances(@RequestParam(value = "curr", defaultValue = "1") Integer curr) {
    //    return instanceService.queryInstances(curr);
    //}

    //
    //@GetMapping("/inorder")
    //public Result queryInstancesOrderBy(@RequestParam(value = "curr", defaultValue = "1") Integer curr,
    //                                    @RequestParam(value = "by", defaultValue = "id") String byWhat,
    //                                    @RequestParam(value = "health", defaultValue = "-1") Integer health) {
    //    return instanceService.queryInstancesOrderBy(curr, byWhat, health);
    //}
    //
    //
    //@GetMapping("/watching/of/me/inorder")
    //public Result queryInstancesMe(@RequestParam(value = "curr", defaultValue = "1") Integer curr,
    //                               @RequestParam(value = "by", defaultValue = "id") String byWhat,
    //                               @RequestParam(value = "health", defaultValue = "-1") Integer health) {
    //    return instanceService.queryInstancesMe(curr, byWhat, health);
    //}



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
     * 故障报告数
     * @param instanceId
     * @return com.tiiaan.tbm.metaj.dto.Result
     * @author tiiaan Email:tiiaan.w@gmail.com
     */
    @GetMapping("/issues/count")
    public Result queryIssuesCount(@RequestParam(value = "instanceId") Long instanceId) {
        return instanceService.queryIssuesCount(instanceId);
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
