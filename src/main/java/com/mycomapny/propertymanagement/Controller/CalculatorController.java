package com.mycomapny.propertymanagement.Controller;

import com.mycomapny.propertymanagement.Model.CalculatorDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/vi/calculator")
public class CalculatorController {
 @GetMapping("/add/{num3}")
    public Double add(@RequestParam("num1") Double num1, @RequestParam("num2") Double num2,@PathVariable("num3") Double num3){
        return num1+num2;
    }
  @GetMapping("/sub/{num1}/{num2}")
    public Double sub(@PathVariable("num1") Double num1,@PathVariable("num2") Double num2){
     Double result;
     if(num1<num2){
         result= num2-num1;
     }
     else
         result=num1-num2;
     return result;
 }
 @PostMapping("/mul")
 public ResponseEntity<Double> multiply(@RequestBody CalculatorDto Calculator){
    Double result=Calculator.getNum1()*Calculator.getNum2()*Calculator.getNum3()*Calculator.getNum4();
    ResponseEntity<Double> responseEntity=new ResponseEntity<Double>(result, HttpStatus.CREATED);
    return responseEntity;
 }
}
