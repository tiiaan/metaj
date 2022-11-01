package com.tiiaan.tbm.metaj.controller;

import com.tiiaan.tbm.metaj.dto.Result;
import com.tiiaan.tbm.metaj.service.SystemService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author tiiaan Email:tiiaan.w@gmail.com
 * @version 0.0
 * description
 */


@RestController
@RequestMapping("/system")
public class SystemController {

    @Resource
    private SystemService systemService;


    @GetMapping("/cpu")
    public Result querySystemProcessor() {
        return systemService.querySystemProcessor();
    }

}
