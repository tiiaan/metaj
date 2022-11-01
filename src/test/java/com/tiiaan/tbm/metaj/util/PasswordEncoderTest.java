package com.tiiaan.tbm.metaj.util;

import org.junit.Test;

import static org.junit.Assert.*;

public class PasswordEncoderTest {

    @Test
    public void encode() {
        String pwd = "tiiaan";
        String encode = PasswordEncoder.encode(pwd);
        System.out.println(encode);
    }

    @Test
    public void matches() {
        String encode = "xwyaaiwgirlkcns4j0ly@2e4a0565b7e2bfd0f06600dda4bb0c58";
        Boolean admin = PasswordEncoder.matches(encode, "Tang Yunxi3128302161");
        System.out.println(admin);
    }

}