package com.tiiaan.tbm.metaj.service;

import com.tiiaan.tbm.metaj.dto.LoginFormDTO;
import com.tiiaan.tbm.metaj.dto.Result;

/**
 * @author tiiaan Email:tiiaan.w@gmail.com
 * @version 0.0
 * description
 */

public interface UserService {
    Result login(LoginFormDTO loginFormDTO);
}
