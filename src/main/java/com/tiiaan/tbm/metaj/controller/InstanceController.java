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
    public Result queryInstances() {
        return Result.ok();
        //return instanceService.queryInstances();
    }

}
