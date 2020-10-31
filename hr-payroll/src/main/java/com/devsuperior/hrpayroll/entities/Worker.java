package com.devsuperior.hrpayroll.entities;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Worker implements Serializable {

	private static final long serialVersionUID = -219638251049766023L;
	
	private Long id;
	private String name;
	private Double dailyIncome;
}
