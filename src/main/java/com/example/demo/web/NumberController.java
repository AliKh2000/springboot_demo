package com.example.demo.web;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Random;

@RestController
@RequestMapping("/api/number")
@CrossOrigin
public class NumberController {

    /**
     * Returns a random number in range 0-100
     * @return A single number
     */
    @GetMapping("/random")
    public ResponseEntity<Integer> getRandomNumber() {
        int bound = 100;
        return new ResponseEntity<>(new Random().nextInt(bound), HttpStatus.OK);
    }

    /**
     * Endpoint to return the sum of 2 numbers
     * @param num_1 first number
     * @param num_2 second number
     * @return A number equal to the sum of num_1 and num_2
     */
    @PostMapping("sum")
    public ResponseEntity<Integer> getSum(@RequestParam int num_1,
                                          @RequestParam int num_2) {
        int ret = num_1 + num_2;
        HttpStatus status = HttpStatus.ACCEPTED;
        return new ResponseEntity<Integer>(ret, status);
    }

    /**
     * Endpoint to return the multiplication of 2 numbers
     * @param num_1 first number
     * @param num_2 second number
     * @return A number equal to the multiplication of num_1 and num_2
     */
    @PostMapping("mul")
    public ResponseEntity<Integer> getMul(@RequestParam int num_1,
                                          @RequestParam int num_2) {
        int ret = num_1 * num_2;
        HttpStatus status = HttpStatus.ACCEPTED;
        return new ResponseEntity<Integer>(ret, status);
    }
}
