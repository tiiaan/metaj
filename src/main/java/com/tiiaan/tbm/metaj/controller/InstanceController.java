package com.tiiaan.tbm.metaj.controller;

import com.tiiaan.tbm.metaj.dto.InstanceDTO;
import com.tiiaan.tbm.metaj.dto.InstanceStatusDTO;
import com.tiiaan.tbm.metaj.dto.Result;
import com.tiiaan.tbm.metaj.service.InstanceService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * @author tiiaan Email:tiiaan.w@gmail.com
 * @version 0.0
 * description
 */

@RestController
@RequestMapping("/instance")
public class InstanceController {

    @Resource
    private InstanceService instanceService;


    @PostMapping
    public Result registerInstance(@RequestBody InstanceDTO instanceDTO) {
        return instanceService.registerInstance(instanceDTO);
    }


    @GetMapping("/{id}")
    public Result queryInstanceById(@PathVariable("id") Long id) {
        return instanceService.queryInstanceById(id);
    }


    @PutMapping("/watch/{id}")
    public Result watchInstance(@PathVariable("id") Long id) {
        return instanceService.watchInstance(id);
    }

}
