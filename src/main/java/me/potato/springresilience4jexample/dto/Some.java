
/*
 * Some.java 2022. 01. 04
 *
 * Copyright 2022 Naver Cloud Corp. All rights Reserved.
 * Naver Cloud Corp. PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package me.potato.springresilience4jexample.dto;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 * @author dongju.paek
 */
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Some implements Serializable {
	private String name;
	private String nickname;

}