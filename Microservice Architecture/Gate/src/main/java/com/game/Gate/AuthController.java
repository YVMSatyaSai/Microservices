package com.game.Gate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    JwtUtil jwtUtil;

    @PostMapping("/login")
    public String login(@RequestParam String username) {
        return jwtUtil.generateToken(username);
    }
}
