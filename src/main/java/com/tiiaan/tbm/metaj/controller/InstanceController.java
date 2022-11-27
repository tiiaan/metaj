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


    @GetMapping("/watching/me")
    public Result queryInstancesMe(@RequestParam(value = "curr", defaultValue = "1") Integer curr) {
        return instanceService.queryInstancesMe(curr);
    }



    @PutMapping("/watch/{id}")
    public Result watchInstance(@PathVariable("id") Long id) {
        return instanceService.watchInstance(id);
    }


    @GetMapping("/watching/all/{id}")
    public Result queryInstanceWatching(@PathVariable("id") Long id) {
        return instanceService.queryInstanceWatching(id);
    }

}
