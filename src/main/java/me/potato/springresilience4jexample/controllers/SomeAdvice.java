
/*
 * SomeAdvice.java 2022. 01. 04
 *
 * Copyright 2022 Naver Cloud Corp. All rights Reserved.
 * Naver Cloud Corp. PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package me.potato.springresilience4jexample.controllers;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * @author dongju.paek
 */
@RestControllerAdvice(basePackageClasses = {SomeExternalController.class})
public class SomeAdvice {

	@ExceptionHandler
	public String handler(Exception error){
		error.printStackTrace();
		return error.getClass().getCanonicalName();
	}
}