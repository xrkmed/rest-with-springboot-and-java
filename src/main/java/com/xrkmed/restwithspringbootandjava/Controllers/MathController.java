package com.xrkmed.restwithspringbootandjava.Controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.xrkmed.restwithspringbootandjava.Exceptions.UnsupportedMathOperationException;

@RequestMapping("/v1")
@RestController
public class MathController {
	
	@RequestMapping(value = "/sum/{numberOne}/{numberTwo}", method = RequestMethod.GET)
	public ResponseEntity<Object> sum(@PathVariable(value="numberOne") String numberOne, @PathVariable(value="numberTwo") String numberTwo) {
		try {
			return ResponseEntity.ok().body(Double.parseDouble(numberOne.replaceAll(",", ".")) + Double.parseDouble(numberTwo.replaceAll(",", ".")));
		}catch(Exception e) {
			throw new UnsupportedMathOperationException(e.getMessage());
		}
	}

}
