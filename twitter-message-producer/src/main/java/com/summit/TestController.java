package com.summit;

import org.springframework.http.HttpStatus;
import org.springframework.validation.BindException;
import org.springframework.validation.FieldError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.ValidationException;
import java.util.Collections;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
class TestController{

	@RequestMapping("/TEST")
	public void test(@ModelAttribute @Validated Message message){
		System.out.print(message.getEmail());
	}

	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ExceptionHandler(value = ValidationException.class)
	public String handleValidationException(ValidationException e) {
		// ValidationException으로 부터 에러 json response를 만든다.
		System.out.print(e.getMessage());

		return "";
	}

	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ExceptionHandler(value = IllegalArgumentException.class)
	public String handleIllegalArgumentException(IllegalArgumentException e) {
		System.out.print(e.getMessage());

		return "";
	}

	/**
	 * BindException
	 * @param e
	 * @return
	 */
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ExceptionHandler(value = BindException.class)
	public String handleBindException(BindException e) {
		System.out.print(e.getMessage());

		return "";
	}
}