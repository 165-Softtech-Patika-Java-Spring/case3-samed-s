package com.softtech.case3.controller;

import com.softtech.case3.dto.UserDto;
import com.softtech.case3.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/users")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @GetMapping
    public ResponseEntity findAll() {
        List<UserDto> userDtoList = userService.findAll();
        return ResponseEntity.ok(userDtoList);
    }

    @GetMapping("/{id}")
    public ResponseEntity findById(@PathVariable Long id) {
        UserDto userDto = userService.findById(id);
        return ResponseEntity.ok(userDto);
    }

    @GetMapping("/{username}/info")
    public ResponseEntity findByUsername(@PathVariable String username) {
        UserDto userDto = userService.findByUsername(username);
        return ResponseEntity.ok(userDto);
    }

    @PostMapping
    public ResponseEntity save(@RequestBody UserDto userDto) {
        userDto = userService.save(userDto);
        return ResponseEntity.ok(userDto);
    }

    @PutMapping("/{id}")
    public ResponseEntity update(@PathVariable Long id, @RequestBody UserDto userDto) {
        userDto = userService.update(id, userDto);
        return ResponseEntity.ok(userDto);
    }

    @DeleteMapping
    public ResponseEntity delete(@RequestParam("username") String username, @RequestParam("phoneNumber") String phoneNumber) {
        String result = userService.delete(username, phoneNumber);
        return ResponseEntity.ok(result);
    }
}
