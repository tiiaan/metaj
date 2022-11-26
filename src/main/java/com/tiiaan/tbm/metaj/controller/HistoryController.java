package com.tiiaan.tbm.metaj.controller;


import com.tiiaan.tbm.metaj.dto.Result;
import com.tiiaan.tbm.metaj.service.HistoryService;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

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
@RequestMapping("/history")
public class HistoryController {

    @Resource
    private HistoryService historyService;

    @PostMapping("/stub/{id}")
    public Result stub(@PathVariable("id") Long id) {
        return historyService.stub(id);
    }

}
