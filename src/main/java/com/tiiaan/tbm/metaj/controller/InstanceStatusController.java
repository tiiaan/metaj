package com.tiiaan.tbm.metaj.controller;

import com.tiiaan.tbm.metaj.dto.InstanceStatusDTO;
import com.tiiaan.tbm.metaj.dto.Result;
import com.tiiaan.tbm.metaj.service.InstanceService;
import com.tiiaan.tbm.metaj.service.InstanceStatusService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * @author tiiaan Email:tiiaan.w@gmail.com
 * @version 0.0
 * description
 */


@RestController
@RequestMapping("/instance/status")
public class InstanceStatusController {

    @Resource
    private InstanceStatusService instanceStatusService;


    @GetMapping("/{id}")
    public Result queryInstanceStatus(@PathVariable("id") Long id) {
        return instanceStatusService.queryStatus(id);
    }


    @PostMapping
    public Result uploadInstanceStatus(@RequestBody InstanceStatusDTO instanceStatusDTO) {
        return instanceStatusService.uploadStatus(instanceStatusDTO);
    }

}
