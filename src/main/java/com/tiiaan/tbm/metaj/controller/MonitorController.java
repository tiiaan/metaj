package com.tiiaan.tbm.metaj.controller;

import com.tiiaan.tbm.metaj.dto.MonitorDTO;
import com.tiiaan.tbm.metaj.dto.Result;
import com.tiiaan.tbm.metaj.service.MonitorService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * @author tiiaan Email:tiiaan.w@gmail.com
 * @version 0.0
 * description
 */

@RestController
@RequestMapping("/monitor")
public class MonitorController {

    @Resource
    private MonitorService monitorService;

    @PostMapping("/upload")
    public Result upload(@RequestBody MonitorDTO monitorDTO) {
        return monitorService.upload(monitorDTO);
    }


    @GetMapping("/{id}/{len}")
    public Result get(@PathVariable("id") Long id, @PathVariable("len") Long len) {
        return monitorService.get(id, len);
    }


    @GetMapping("/push")
    public Result push() {
        return monitorService.push();
    }

}
