package com.zettamine.hibernate.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@ToString(includeFieldNames = false, exclude = "customerName")
@AllArgsConstructor
@Data

public class Customer {
	Integer customerId;
	@EqualsAndHashCode.Exclude
	String customerName;
}
