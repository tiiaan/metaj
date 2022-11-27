package com.tiiaan.tbm.metaj.util;

import org.junit.Test;

import static org.junit.Assert.*;

public class PasswordEncoderTest {

    @Test
    public void encode() {
        String pwd = "admin";
        String encode = PasswordEncoder.encode(pwd);
        System.out.println(encode);
    }

    @Test
    public void matches() {
        String encode = "104h4mwo75zk1g2xrg5i@860bb1bd4adce98bf6e7d74c8e197fb2";
        Boolean admin = PasswordEncoder.matches(encode, "admin");
        System.out.println(admin);
    }
}